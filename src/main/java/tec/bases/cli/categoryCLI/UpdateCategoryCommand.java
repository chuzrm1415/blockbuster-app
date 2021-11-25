package tec.bases.cli.categoryCLI;

import java.sql.SQLException;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import tec.bases.ApplicationContext;
import tec.bases.entity.Category;

@Command(name = "catu", description = "update a category")

public class UpdateCategoryCommand implements Runnable {

    @CommandLine.Parameters(index = "0", paramLabel = "<cat ID>", description = "category ID")
    private int catID;

    @CommandLine.Parameters(index = "1",paramLabel = "<description>",description = "category description")
    private String descrip;

	@Override
	public void run() {
		var blockbuster = new ApplicationContext().getBlockbuster();
        try {
            blockbuster.updateCategory(new Category(Long.valueOf(catID), descrip));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
		
}

