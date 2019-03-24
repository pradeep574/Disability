package application;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Main extends Application{

    public static void main(String args[]){
        launch(args);
    }
    public void start(Stage primaryStage) throws Exception{
    	GridPane grid1 = new GridPane();
    	GridPane grid2 = new GridPane();
    	GridPane grid3 = new GridPane();
    	Scene scene1 =  new Scene(grid1,600,500);
    	Scene scene2 =  new Scene(grid2,600,500);
    	Scene scene3 =  new Scene(grid3,600,500);
   	 
        
    	 
        primaryStage.setTitle("WELCOME");
         grid1.setAlignment(Pos.CENTER);
         grid1.setHgap(10);
         grid1.setVgap(10);
         grid1.setPadding(new Insets(25, 25, 25, 25));
         
         Text scenetitle = new Text("Welcome");
         scenetitle.setFont(Font.font("serif", FontWeight.NORMAL, 50));
        // scenetitle.setTextAlignment();
         grid1.add(scenetitle, 1, 0, 1,1 );

         Label userName = new Label("Username:");
         grid1.add(userName, 0, 1);
         userName.setFont(Font.font("serif", FontWeight.NORMAL, 30));
         TextField userTextField = new TextField();
         grid1.add(userTextField, 1, 1);
         userTextField.setPromptText("UserName");
         userTextField.setFont(Font.font("serif", FontWeight.NORMAL, 20));
        
         Label pw = new Label("Password:");
         grid1.add(pw, 0, 2);
         pw.setFont(Font.font("serif", FontWeight.NORMAL, 30));
         PasswordField pwBox = new PasswordField();
         grid1.add(pwBox, 1, 2);
         pwBox.setPromptText("Password (Phone No.)");
         pwBox.setFont(Font.font("serif", FontWeight.NORMAL, 20));
         grid1.setAlignment(Pos.CENTER);

         
         Button signbtn = new Button("Sign in");
         HBox hbBtn = new HBox(100);
         signbtn.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font: normal bold 20.0px 'serif',50.0"); 
         Button regbtn = new Button("Register");
         HBox hbBtn1 = new HBox(100);
         regbtn.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font: normal bold 20.0px 'serif'"); 
         grid1.add(signbtn,1, 3);
         grid1.add(regbtn,2,3);
         
        //String css= this.getClass().getResource("NewFile.css").toExternalForm();
         scene1.getStylesheets().add("NewFile.css");
         scene2.getStylesheets().add("NewFile.css");
         scene3.getStylesheets().add("NewFile.css");
         primaryStage.setScene(scene1);
         primaryStage.show();

         signbtn.setOnAction(new EventHandler<ActionEvent>() {

             @Override
             public void handle(ActionEvent e) {
            	 
            	 Connection con = null;
          		// PreparedStatement stmt = null;
            	 
          		try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
            		System.out.println("After loading SQLServerDriver:");
             
            		final String JDBC_DRIVER = "com.mysql.cjF.jdbc.Driver";
            		final String USER = "root";
            		final String PASS = "pradeep@574"; 
            		
            		
            		final String DB_URL = "jdbc:mysql://127.0.0.1:3306/studennt";
            		//System.setProperty(JDBC_DRIVER,"");
            		con = DriverManager.getConnection(DB_URL,USER,PASS);    
            		System.out.println("Connected with default host.");
            		
            		String sql = "SELECT name,phone from Regis where name= '"+userTextField.getText()+"' and phone='"+pwBox.getText()+"'";
            		String sql1 = "SELECT disablity,subdis from Regis where name= '"+userTextField.getText()+"' and phone='"+pwBox.getText()+"'";
            	
            		Statement smt = con.createStatement();
            		ResultSet rs = smt.executeQuery(sql1);
            		ResultSet rs1=con.prepareStatement(sql).executeQuery();
          		
                   	if(rs1.next()) {
            		System.out.println("login into the table...");
            		grid3.setMinSize(500, 600);
                    grid3.setPadding(new Insets(10,10,10,10));
                    grid3.setVgap(10);
                    grid3.setHgap(5);
                    grid3.setAlignment(Pos.TOP_CENTER);
                    primaryStage.setScene(scene3);
              	    primaryStage.show();
                    primaryStage.setTitle("YouTube");
                    WebView wv =new WebView();
                    
                    while (rs.next()) {
            		String disa = rs.getString("disablity");
            		String subdisa = rs.getString("subdis");
            		System.out.println(disa);
            		System.out.println(subdisa);
            		if(disa.equals("Physical") && subdisa.equals("Acquired brain injury")) {
            			//System.out.println("aa");
            		wv.getEngine().load("https://www.youtube.com/channel/UCdW5pP2ct-HWv4WXSpvXBDQ");
                  	  wv.setPrefSize(600, 600);
                  	  primaryStage.setScene(new Scene(wv));
                  	  
            		}
            		else if(disa.equals("Physical") && subdisa.equals("Spinal cord injury")){
            			wv.getEngine().load("https://www.youtube.com/channel/UCqMGDQjxv6lZ_hlzQe-BiUQ");
                    	  wv.setPrefSize(600, 600);
                    	  primaryStage.setScene(new Scene(wv));
            		}
            		else if(disa.equals("Physical") && subdisa.equals("Spina bifida")){
            			wv.getEngine().load("https://www.youtube.com/channel/UCZn-2dSbYhQbXercnzj7_KQ");
                    	  wv.setPrefSize(600, 600);
                    	  primaryStage.setScene(new Scene(wv));
            		}
            		else if(disa.equals("Intellectual") && subdisa.equals("Fragile X syndrome")){
            			wv.getEngine().load("https://www.youtube.com/channel/UCVlMUh4WsDQvOxCJJXmWwdw");
                    	  wv.setPrefSize(600, 600);
                    	  primaryStage.setScene(new Scene(wv));
            		}
            		else if(disa.equals("Intellectual") && subdisa.equals("Down syndrome")){
            			wv.getEngine().load("https://www.youtube.com/user/TelefonicaDigital");
                    	  wv.setPrefSize(600, 600);
                    	  primaryStage.setScene(new Scene(wv));
            		}
            		else if(disa.equals("Intellectual") && subdisa.equals("Prader-Willi Syndrome")){
            			wv.getEngine().load("https://www.youtube.com/watch?v=RNp4OpToAdQ");
                    	  wv.setPrefSize(600, 600);
                    	  primaryStage.setScene(new Scene(wv));
            		}
            		else if(disa.equals("Mental") && subdisa.equals("Bipolar disorder")){
            			wv.getEngine().load("https://www.youtube.com/channel/UCWHpsFuBDYf_gYz5OI7aErA");
                    	  wv.setPrefSize(600, 600);
                    	  primaryStage.setScene(new Scene(wv));
            		}
            		else if(disa.equals("Mental") && subdisa.equals("Depression")){
            			wv.getEngine().load("https://www.youtube.com/watch?v=Oq2gc2MXZFI");
                    	  wv.setPrefSize(600, 600);
                    	  primaryStage.setScene(new Scene(wv));
            		}
            		else if(disa.equals("Mental") && subdisa.equals("Anxiety disorders")){
            			wv.getEngine().load("https://www.youtube.com/watch?v=_uQrJ0TkZlc");
                    	  wv.setPrefSize(600, 600);
                    	  primaryStage.setScene(new Scene(wv));
            		}
            		else if(disa.equals("Sensory") && subdisa.equals("Autism spectrum disorder")){
            			wv.getEngine().load("https://www.youtube.com/watch?v=_uQrJ0TkZlc");
                    	  wv.setPrefSize(600, 600);
                    	  primaryStage.setScene(new Scene(wv));
            		}
            		else if(disa.equals("Sensory") && subdisa.equals("Hearing loss and deafness")){
            			wv.getEngine().load("https://www.youtube.com/watch?v=RbuFVWavkyQ");
                    	  wv.setPrefSize(600, 600);
                    	  primaryStage.setScene(new Scene(wv));
            		}
            		else if(disa.equals("Sensory") && subdisa.equals("Sensory processing disorder")){
            			wv.getEngine().load("https://www.youtube.com/watch?v=_uQrJ0TkZlc");
                    	  wv.setPrefSize(600, 600);
                    	  primaryStage.setScene(new Scene(wv));
            		}
            		else {
            			System.out.println("no video");
            		}
                    }  
                   	}
            		
            		else {
            			 Alert alert = new Alert(AlertType.INFORMATION); 
            			 alert.setTitle("Alert Messagae");
            			 alert.setContentText("Invalid password/username");
            			 alert.setHeaderText(null);
            			 alert.showAndWait();
            		}
            		}	catch(SQLException se){
            			se.printStackTrace();
            		}
            		catch(Exception ex){
            			ex.printStackTrace();
            		}
             }
         });
         
         regbtn.setOnAction(new EventHandler<ActionEvent>() {

             @Override
             public void handle(ActionEvent e) {
            	 grid2.setMinSize(500, 600);
                 grid2.setPadding(new Insets(10,10,10,10));
                 grid2.setVgap(10);
                 grid2.setHgap(5);
                 grid2.setAlignment(Pos.TOP_CENTER);
            	 
            	 
            	 HBox box = new HBox(20);
                 Text t= new Text("Register");
                 
                 Text nameLabel=new Text("Name");
                 TextField nameText=new TextField();
                 nameText.setPromptText(" Name ");
                 nameText.setFont(Font.font("serif", FontWeight.NORMAL, 20));
                 nameLabel.setFont(Font.font("serif", FontWeight.NORMAL, 20));
                 
                 Text dob=new Text("Phone No");
                 TextField db = new TextField();
                 db.setPromptText(" Phone No. ");
                 dob.setFont(Font.font("serif", FontWeight.NORMAL, 20));
                 db.setFont(Font.font("serif", FontWeight.NORMAL, 20));
                 Text genderlabel=new Text("Gender");
                 genderlabel.setFont(Font.font("serif", FontWeight.NORMAL, 20));
                 ToggleGroup groupGender=new ToggleGroup();
                 RadioButton maleRadio=new RadioButton("Male");
                 maleRadio.setToggleGroup(groupGender);
                 maleRadio.setFont(Font.font("serif", FontWeight.NORMAL, 20));
                 RadioButton femaleRadio=new RadioButton("Female");
                 femaleRadio.setToggleGroup(groupGender);
                 femaleRadio.setFont(Font.font("serif", FontWeight.NORMAL, 20));

                 Text disLabel=new Text("Disability");
                 Text subdisLabel=new Text("SubDisability ");
                 disLabel.setFont(Font.font("serif", FontWeight.NORMAL, 20));
                 subdisLabel.setFont(Font.font("serif", FontWeight.NORMAL, 20));

                 ObservableList<String> dischoice=
                         FXCollections.observableArrayList(
                         "Intellectual",
                         "Physical",
                         "Mental",
                         "Sensory"
                         );
              

                 final ObservableList<String> Intellectual =
                         FXCollections.observableArrayList(
                         "Fragile X syndrome",
                         "Down syndrome",
                         "Prader-Willi Syndrome ");

                 final ObservableList<String> Physical =
                         FXCollections.observableArrayList(
                         "Acquired brain injury",
                         "Spinal cord injury",
                         "Spina bifida"
                         );

                 final ObservableList<String> Mental =
                         FXCollections.observableArrayList(
                         "Bipolar disorder",
                         "Depression",
                         "Anxiety disorders");
                 
                 final ObservableList<String> Sensory =
                         FXCollections.observableArrayList(
                         "Autism spectrum disorder ",
                         "Hearing loss and deafness",
                         "Sensory processing disorder");


                 ComboBox<String> comboBox1 = new ComboBox<String>(dischoice);
                 final ComboBox<String> comboBox2 = new ComboBox<String>();
                 comboBox1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
                     @Override
                     public void changed(ObservableValue<?> ov, Object t, Object t1) {

                         switch (t1.toString()) {
                             case "Intellectual":
                                 comboBox2.setItems(Intellectual);
                                 break;
                            case "Physical":
                                 comboBox2.setItems(Physical);
                                 break;
                            case "Mental":
                                 comboBox2.setItems(Mental);
                                break;
                            case "Sensory":
                                comboBox2.setItems(Sensory);
                               break;    
                         }
                     }
                 });
                 box.getChildren().addAll(comboBox1, comboBox2);
                 
                 Text locationlabel=new Text("Location");
                 ChoiceBox<String> locationchoicebox=new ChoiceBox<String>();
                 locationchoicebox.getItems().addAll("Bangalore","Hyderabad","Chennai","Delhi");
                 locationchoicebox.getSelectionModel().selectFirst();       
                 //locationchoicebox.setStyle("Font.font("serif", FontWeight.NORMAL, 20"));
                 locationlabel.setFont(Font.font("serif", FontWeight.NORMAL, 20));
                 
                 Button buttonregister=new Button("SUBMIT");
                 
                 grid2.add(t, 1, 0);
                 t.setStyle("-fx-font: normal bold 40.0px 'serif' ");
                 grid2.add(nameLabel, 0, 3);
                 grid2.add(nameText, 1, 3);
                 grid2.add(dob, 0, 4);
                 grid2.add(db, 1, 4);
                 grid2.add(genderlabel, 0, 5);
                 grid2.add(maleRadio, 1, 5);
                 grid2.add(femaleRadio, 2, 5);
                 grid2.add(disLabel, 0, 6);
                 grid2.add(comboBox1, 1, 6);
                 grid2.add(subdisLabel, 0, 8);
                 grid2.add(comboBox2, 1, 8);
                 grid2.add(locationlabel, 0, 10);
                 grid2.add(locationchoicebox, 1, 10);
                 
                 Text resp=new Text();
                 grid2.add(resp, 1,15);
                 grid2.add(buttonregister,1,12);
                 primaryStage.show();
                 
                 nameLabel.setStyle("-fx-background-color: blue;");
                 dob.setStyle("-fx-background-color: blue;");
                 buttonregister.setText("SUBMIT");
                 buttonregister.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font: normal bold 20.0px 'serif'"); 
                 locationchoicebox.setStyle("-fx-background-color: lightgrey;"+ "-fx-text-fill: red;");
                 
                 primaryStage.setScene(scene2);
                 primaryStage.show();
                 
                 buttonregister.setOnAction(new EventHandler<ActionEvent>() {
                	 
                	 public void handle(ActionEvent event){
                		 
                         System.out.println("Complete");
                         System.out.println("Name: "+nameText.getText());
                         //System.out.println("Gender: "+groupGender.selectedToggleProperty().getValue());
                         System.out.println("Phone No: "+ db.getText());
                         System.out.println("Location: "+locationchoicebox.getValue());
                         
                        Connection con = null;
                 		Statement stmt = null;
                 		// if(valPhone()) 
                 		try {
                         Class.forName("com.mysql.cj.jdbc.Driver");
                 		System.out.println("After loading SQLServerDriver:");
                  
                 		final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
                 		final String USER = "root";
                 		final String PASS = "pradeep@574"; 
                 		
                 		
                 		final String DB_URL = "jdbc:mysql://127.0.0.1:3306/studennt";
                 		//System.setProperty(JDBC_DRIVER,"");
                 		con = DriverManager.getConnection(DB_URL,USER,PASS);    
                 		System.out.println("Connected with default host.");
                 		System.out.println("Inserting records into the table...");
                 		stmt = con.createStatement();
                 		String sql = "INSERT INTO Regis VALUES('"+nameText.getText()+"','"+db.getText()+"','"+comboBox1.getValue()+"','"+comboBox2.getValue()+"','"+ locationchoicebox.getValue()+"')";
                 		stmt.executeUpdate(sql);
                 		System.out.println("Inserted records into the table...");
                 		}	catch(SQLException se){
                 			se.printStackTrace();
                 		}
                 		catch(Exception e){
                 			e.printStackTrace();
                 		}
                 	  // resp.setText("Successful");
                     grid3.setStyle("-fx-background-color: lightblue");
                     grid3.setMinSize(500, 600);
                     grid3.setPadding(new Insets(10,10,10,10));
                     grid3.setVgap(10);
                     grid3.setHgap(5);
                     if(nameText.getText().toString()!=null) {
                    	 primaryStage.setScene(scene1);
                    	 primaryStage.show();
                    	 primaryStage.setTitle("Welcome");
                		}
                     else {
            			 Alert alert = new Alert(AlertType.INFORMATION); 
            			 alert.setTitle("Alert Messagae");
            			 alert.setContentText("Enter All Fields");
            			 alert.setHeaderText(null);
            			 alert.showAndWait();
                     }
                     }  
                });
             }
          });        
       
       
    }

}