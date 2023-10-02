package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.sql.Statement;
import java.sql.*;


public class Main extends Application {
	private Label lblStatus = new Label();
	
	private Label lblID = new Label("ID");
	private TextField txtID = new TextField();
	private Label lblLastName = new Label ("Last Name");
	private TextField txtLastName = new TextField();
	private Label lblFirstName = new Label ("First Name");
	private TextField txtFirstName = new TextField();
	private Label lblMidd1e = new Label ("MI");
	private TextField txtMiddle = new TextField();
	private Label lblAddress = new Label ("Address");
	private TextField txtAddress = new TextField();
	private Label lblCity = new Label ("City");
	private TextField txtCity = new TextField( ) ;
	private Label lblState = new Label ("State");
	private TextField txtState = new TextField();
	private Label lblPhone = new Label ("Telephone");
	private TextField txtPhone = new TextField();
	private Label lblEmail = new Label ("Email");
	private TextField txtEmail = new TextField();
	
	private Button btnView = new Button("View");
	private Button btnInsert = new Button("Insert");
	private Button btnUpdate = new Button("Update");
	private Button btnClear = new Button("Clear");
	
	private Statement stmt;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			HBox hbox1 = new HBox(5);
			hbox1.getChildren().addAll(lblID, txtID);
			HBox hbox2 = new HBox(5);
			hbox2.getChildren().addAll(lblLastName, txtLastName, lblFirstName, txtFirstName, lblMidd1e, txtMiddle);
			HBox hbox3 = new HBox(5);
			hbox3.getChildren().addAll(lblAddress, txtAddress);
			HBox hbox4 = new HBox(5);
			hbox4.getChildren().addAll(lblCity, txtCity, lblState, txtState);
			HBox hbox5 = new HBox(5);
			hbox5.getChildren().addAll(lblPhone, txtPhone, lblEmail, txtEmail);
			
			
			VBox vBox = new VBox(5);
			vBox.getChildren().addAll(hbox1, hbox2, hbox3, hbox4, hbox5);
			
			HBox btnBox = new HBox(5);
			btnBox.getChildren().addAll(btnView, btnInsert, btnUpdate, btnClear);
			
			BorderPane pane = new BorderPane() ;
			pane.setTop(lblStatus);
			pane.setCenter(vBox) ;
			pane.setBottom(btnBox) ;
			
			// Create a scene from the grid pane. 
			// Create the stage with a title and scene and display it 
			Scene scene = new Scene(pane, 700, 200);
			primaryStage.setTitle("Staff Table"); // Set the stage title
			primaryStage.setScene(scene); // Place the scene in the stage
			primaryStage.show(); // Display the stage.
			
			initializeDB();
			
			btnView.setOnAction(e -> view());
			btnInsert.setOnAction(e -> insert());
			btnClear.setOnAction(e -> clear());
			btnUpdate.setOnAction(e -> update());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private Object update() {
		
	}
	
	private Object clear() {
		txtID.setText(null) ;
		txtLastName.setText(null) ;
		txtFirstName.setText(null) ;
		txtMiddle.setText(null) ;
		txtAddress.setText(null) ;
		txtCity.setText(null) ;
		txtState.setText(null) ;
		txtPhone.setText(null) ;
		txtEmail.setText(null) ;
	}
	private Object insert() {
		String insertQuery = 
			"INSERT INTO Staff (id, lastName, FirstName, mi, address, " +
			"city, state, telephone, email) VALUES ('" + txtID.getText().trim() +
			"' , '" + txtLastName.getText().trim() +
			"' , '" + txtFirstName.getText().trim() +
			"' , '" + txtMiddle.getText().trim() +
			"' , '" + txtAddress.getText().trim() +
			"' , '" + txtCity.getText().trim() +
			"' , '" + txtState.getText().trim() +
			"' , '" + txtPhone.getText().trim() +
			"' , '" + txtEmail.getText().trim() + "');";
		try {
			stmt.executeUpdate(insertQuery);
			lblStatus.setText("Inserted Record Successfully.");
			System.out.println("Insert succeeded");
		}
		catch (SQLException ex){
			lblStatus.setText( "Insert Failed: " + ex);
			System.out.println("Insert Failed: " + ex);
		}
			
	}
	private Object view() {
		String query = "SELECT * FROM Staff WHERE id = '" + txtID.getText().trim() +"'";
		try {
			ResultSet rs = stmt.executeQuery(query);
			loadFieIds(rs);
		}
		catch(SQLException Ex){
			lblStatus.setText( "Query Failed");
			System.out.println("Captain, there is a problem with the query" + Ex);
		}
	}
	
	private void loadFields(ResultSet rs) throws SQLException {
		if (rs.next()) {
			txtLastName.setText(rs.getString(2));
			txtFirstName.setText(rs.getString(3));
			txtMiddle.setText(rs.getString(4));
			txtAddress.setText(rs.getString(5));
			txtCity.setText(rs.getString(6));
			txtState.setText(rs.getString(7));
			txtPhone.setText(rs.getString(8));
			txtEmail.setText(rs.getString(9));
			lblStatus.setText("Record Found");
		} else {
			txtLastName.setText("");
			txtFirstName.setText("");
			txtMiddle.setText("");
			txtAddress.setText("");
			txtCity.setText("");
			txtState.setText("");
			txtPhone.setText("");
			txtEmail.setText("");
			lblStatus.setText("Record NOT Found");
		}
	}
	
	private void initializeDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			Connection connection = DriverManager.getConnection("jdbc:mysql://apollo.gtc.edu/aaaaa_javabook2", "aaaaa", "password");
			System.out.println("Database connected");
			lblStatus.setText("Database connnected");
			stmt = connection.createStatement();
		}
		catch(Exception Ex) {
			System.out.println("Something is wrong with the Database. HELP! !!! ! " + Ex);
			lblStatus.setText("Database Connection Failed. Please try again.");
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
