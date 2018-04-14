package calculadora.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FXMLDocumentController implements Initializable {
    
    String dataS = "";
    float dataF = 0f;
    String numberInputS = "";
    float numberInputF = 0f;

    @FXML
    private Button minus;

    @FXML
    private Button nine;

    @FXML
    private Button six;

    @FXML
    private Button mult;

    @FXML
    private Label displayAnterior;

    @FXML
    private Button one;

    @FXML
    private Button clear;

    @FXML
    private Button seven;

    @FXML
    private Label display;

    @FXML
    private Button two;

    @FXML
    private Button three;

    @FXML
    private Button plus;

    @FXML
    private Button eight;

    @FXML
    private Button div;

    @FXML
    private Button equal;

    @FXML
    private Button zero;

    @FXML
    private Button four;

    @FXML
    protected Button five;

    @FXML
    public void handleButtonNumber (ActionEvent event) {
        
        try{
        Object source = event.getSource();

        if (source == one) {
            display.setText(display.getText() + "1");
            numberInputS.concat("1");            
        }            
         else if (source == two) {
            display.setText(display.getText() + "2");
            numberInputS.concat("2");
        } else if (source == three) {
            display.setText(display.getText() + "3");
            numberInputS.concat("3");
        } else if (source == four) {
            display.setText(display.getText() + "4");
            numberInputS.concat("4");
        } else if (source == five) {
            display.setText(display.getText() + "5");
            numberInputS.concat("5");
        } else if (source == six) {
            display.setText(display.getText() + "6");
            numberInputS.concat("6");
        } else if (source == seven) {
            display.setText(display.getText() + "7");
            numberInputS.concat("7");
        } else if (source == eight) {
            display.setText(display.getText() + "8");
            numberInputS.concat("8");
        } else if (source == nine) {
            display.setText(display.getText() + "9");
            numberInputS.concat("9");
        } else if (source == zero) {
            display.setText(display.getText() + "0");
            numberInputS.concat("0");
        }
        
        }catch(Exception e){
            display.setText("ERROR");
            
        }
        
        }

    @FXML
    public void handleButtonOperator(ActionEvent event) {
        
        Object source = event.getSource();
        
        if(source == plus){
            
            dataF = Float.valueOf(dataS);
            
            
        }else if (source == minus){
            
        }else if (source == mult){
            
        }else if (source == div){
            
        }
        
    }
    @FXML
    public void handleButtonEqual(ActionEvent event) {
        
        dataF = Float.valueOf(dataS);
        
    }
    @FXML
    public void handleButtonClear(ActionEvent event) {
    }

    public float convert (String convert){
        
        float converted = Float.valueOf(convert);
        
        return converted;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
