package tec.bases.cli.categoryCLI;

import java.sql.SQLException;
import java.util.Optional;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import tec.bases.ApplicationContext;
import tec.bases.entity.Category;

@Command(name = "catrid", description = "get category by ID")

public class GetCategoryByIDCommand implements Runnable {

    @CommandLine.Parameters(paramLabel = "<cat ID>", description = "category ID")
    private int catID;

    @Override
    public void run() {
        var blockbuster = new ApplicationContext().getBlockbuster();
        try {
            var catList = blockbuster.findCategoryByID(Long.valueOf(catID));
            showInfo(catList);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    private void showInfo(Optional<Category> _cat) {
        System.out.println("CATEGORY_ID       DESCRIPTION");
        if (_cat.isPresent()) {
            System.out.println(_cat.get().toString());
        }
    }
    
}
