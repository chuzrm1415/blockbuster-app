package tec.bases.cli.categoryCLI;

import java.sql.SQLException;
import java.util.List;
import tec.bases.entity.Category;

import picocli.CommandLine.Command;
import tec.bases.ApplicationContext;

@Command(name = "catr", description = "get all categorys")

public class GetAllCategorysCommand implements Runnable {

    @Override
    public void run() {
        var blockbuster = new ApplicationContext().getBlockbuster();
        try {
            var catList = blockbuster.getAllCategorys();
            showInfo(catList);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    private void showInfo(List<Category> _list) {
        System.out.println("CATEGORY_ID     DESCRIPTION");
        if (! _list.isEmpty()) {
            for (int indx = 0; indx < _list.size(); indx++) {
                System.out.println( _list.get(indx).toString());
            }
        }
    }
    
}
