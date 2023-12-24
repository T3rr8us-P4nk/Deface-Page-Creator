package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MainController {

    private Scene scene;
    private Stage stage;

    @FXML
    private TextField Title;
    @FXML
    private TextField Logo;
    @FXML
    private TextField Hackername;
    @FXML
    private TextArea Message;
    @FXML
    private TextField Background;
    @FXML
    private TextField TextColor;
    @FXML
    private TextField Font;
    @FXML
    private Label respond;
    @FXML
    private Button generateButton;

    public void goToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 600);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void goToAbout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("About.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 600);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void genDFP() {
        String title = Title.getText();
        String logo = Logo.getText();
        String hackerName = Hackername.getText();
        String message = Message.getText();
        String bgColor = Background.getText();
        String textColor = TextColor.getText();
        String font = Font.getText();

        String htmlContent = "<html>"
                + "<head>"
                + "<title>" + title + "</title>"
                + "<meta charset=\"UTF-8\">\r\n"
                + "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
                + "<link href=\"https://fonts.googleapis.com/css2?family=Anonymous+Pro&display=swap\" rel=\"stylesheet\">"
                + "<style>"
                + "body {"
                + "    background-color: " + bgColor + ";"
                + "    font-family:" + font + ";"
                + "}"
                + ".logo {"
                + "    width: 20%;"
                + "    height:250px;"
                + "}"
                + "a {"
                + "    text-decoration:none;"
                + "    color:silver;"
                + "}"
                + "h2 { color:white; font-family:courier new;}"
                + "pre {"
                + "    color:" + textColor +";"
                + "}"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<div align=\"center\">"
                + "<br>"
                + "<br>"
                + "<img class=\"logo\" src='" + logo + "'></a><br></br></br>"
                + "<div align=\"center\">"
                + "<pre style=\"font: 40px/13px courier;\"><b>"
                + hackerName
                + "</b></pre>"
                + "</div>"
                + "<h2>No system is safe</h2>"
                + "<br>"
                + "<pre>" + message.replace("\n", "<br>") + "</pre><br>"
                + "</div>"
                + "<script src=\"https://cdn.rawgit.com/bungfrangki/efeksalju/2a7805c7/efek-salju.js\" type=\"text/javascript\"></script>"
                + "</body>"
                + "</html>";


        String filePath = "C://deface-page.html";
        
        saveToFile(htmlContent, filePath);
    }

    private void saveToFile(String htmlContent, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(htmlContent);
            respond.setText("Deface page saved: C://deface-page.html");
        } catch (IOException e) {
            e.printStackTrace();
            respond.setText("Theres something wrong!");
        }
    }
}