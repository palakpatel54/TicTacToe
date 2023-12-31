package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private char currentPlayer = 'X';
    private Button[][] buttons = new Button[3][3];

    public static void main(String[] args) {
        launch(args);
    }
	public void start(Stage primaryStage) {
		 
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	GridPane grid = new GridPane();
    grid.setVgap(10);
    grid.setHgap(10);

    for (int row = 0; row < 3; row++) {
        for (int col = 0; col < 3; col++) {
            Button button = createButton(row, col);
            buttons[row][col] = button;
            grid.add(button, col, row);
        }
    }

    Scene scene = new Scene(grid, 300, 300);
    primaryStage.setTitle("Tic Tac Toe");
    primaryStage.setScene(scene);
    primaryStage.show();
	}

private Button createButton(int row, int col) {
    Button button = new Button();
    button.setPrefSize(100, 100);
    button.setOnAction(event -> {
        if (button.getText().isEmpty()) {
            button.setText(String.valueOf(currentPlayer));
            button.setDisable(true);
            if (checkWin(row, col)) {
                System.out.println("Player " + currentPlayer + " wins!");
            } else if (isBoardFull()) {
                System.out.println("It's a draw!");
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    });
    return button;
}
private boolean checkWin(int row, int col) {
	// Check rows
    for (int i = 0; i < 3; i++) {
        if (buttons[i][0].getText().equals(String.valueOf(currentPlayer))
                && buttons[i][1].getText().equals(String.valueOf(currentPlayer))
                && buttons[i][2].getText().equals(String.valueOf(currentPlayer))) {
            return true;
        }
    }

    // Check columns
    for (int i = 0; i < 3; i++) {
        if (buttons[0][i].getText().equals(String.valueOf(currentPlayer))
                && buttons[1][i].getText().equals(String.valueOf(currentPlayer))
                && buttons[2][i].getText().equals(String.valueOf(currentPlayer))) {
            return true;
        }
    }

    // Check diagonals
    if (buttons[0][0].getText().equals(String.valueOf(currentPlayer))
            && buttons[1][1].getText().equals(String.valueOf(currentPlayer))
            && buttons[2][2].getText().equals(String.valueOf(currentPlayer))) {
        return true;
    }
    if (buttons[0][2].getText().equals(String.valueOf(currentPlayer))
            && buttons[1][1].getText().equals(String.valueOf(currentPlayer))
            && buttons[2][0].getText().equals(String.valueOf(currentPlayer))) {
        return true;
    }

    return false;
}
 

private boolean isBoardFull() {
    for (int row = 0; row < 3; row++) {
        for (int col = 0; col < 3; col++) {
            if (buttons[row][col].getText().isEmpty()) {
                return false;
            }
        }
    }
    return true;
}
}