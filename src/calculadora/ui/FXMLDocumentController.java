package calculadora.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FXMLDocumentController implements Initializable {

    String numberInputS = "";
    float numberInputF = 0f;

    //dataSecondS almacena los últimos valores ingresados en strings
    //funciona como segundo operando
    //se sobrescribe luego de operar.
    String dataSecondS = "";
    float dataSecondF = 0f;

    //cuando dataFirstF esta en MIN_VALUE, adquiere el próximo valor de dataSecondS
    //el String deja de usarse luego del primer uso, mientras que el float se sobreescribe con los resultados parciales.
    //funciona de primer operando
    String dataFirstS = "";
    float dataFirstF = Float.MIN_VALUE;

    //operator almacena el ultimo operador ingresado.
    String operator = "";

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
    public void handleButtonNumber(ActionEvent event) {
        Object source = event.getSource();

        if (source == one) {
            display.setText(display.getText() + "1");
            numberInputS = numberInputS.concat("1");
        } else if (source == two) {
            display.setText(display.getText() + "2");
            numberInputS = numberInputS.concat("2");
        } else if (source == three) {
            display.setText(display.getText() + "3");
            numberInputS = numberInputS.concat("3");
        } else if (source == four) {
            display.setText(display.getText() + "4");
            numberInputS = numberInputS.concat("4");
        } else if (source == five) {
            display.setText(display.getText() + "5");
            numberInputS = numberInputS.concat("5");
        } else if (source == six) {
            display.setText(display.getText() + "6");
            numberInputS = numberInputS.concat("6");
        } else if (source == seven) {
            display.setText(display.getText() + "7");
            numberInputS = numberInputS.concat("7");
        } else if (source == eight) {
            display.setText(display.getText() + "8");
            numberInputS = numberInputS.concat("8");
        } else if (source == nine) {
            display.setText(display.getText() + "9");
            numberInputS = numberInputS.concat("9");
        } else if (source == zero) {
            display.setText(display.getText() + "0");
            numberInputS = numberInputS.concat("0");
        }

        confirm();

    }

    void confirm() {

        dataSecondS = numberInputS;

        if (dataFirstF == Float.MIN_VALUE) {
            dataFirstS = dataSecondS;

        }

    }

    void operator(String o) {

        display.setText(display.getText() + o);

        if (!(operator.isEmpty())) {

            float solution = operate(operator, dataSecondF, dataFirstF);
            dataFirstF = solution;
            dataSecondF = 0f;
        }
        operator = o;
        numberInputS = "";
             

    }

    @FXML
    public void handleButtonOperator(ActionEvent event) {

        Object source = event.getSource();

        //CONVERSION
        if (!(dataSecondS.isEmpty())) {
            dataSecondF = Float.valueOf(dataSecondS);
            dataSecondS = "";
        }

        if (!(dataFirstS.isEmpty())) {
            dataFirstF = Float.valueOf(dataFirstS);
            dataFirstS = "";
        }
        //SOURCE
        if (!(dataFirstF == Float.MIN_VALUE)) {
            if (source == plus) {
                String o = "+";
                operator(o);
            } else if (source == minus) {
                String o = "-";
                operator(o);
            } else if (source == mult) {
                String o = "*";
                operator(o);
            } else if (source == div) {
                String o = "/";
                operator(o);
            }

        }
    }

    void clear() {

        dataFirstF = Float.MIN_VALUE;
        dataSecondF = 0f;

        dataFirstS = "";
        dataSecondS = "";

        operator = "";
        numberInputS = "";
        display.setText("");

    }

    @FXML
    public void handleButtonEqual(ActionEvent event) {

        if (!(dataSecondS.isEmpty())) {
            dataSecondF = Float.valueOf(dataSecondS);
            dataSecondS = "";

            if (!(dataFirstS.isEmpty())) {
                dataFirstF = Float.valueOf(dataFirstS);
                dataFirstS = "";
            }

            if (!(dataSecondF == 0 && dataFirstF == 0)) {

                float solution = operate(operator, dataFirstF, dataSecondF);
                dataFirstF = solution;
                display.setText(String.valueOf(dataFirstF));
            } else {
                display.setText("ERROR");
            }

            dataSecondF = 0f;
        }

    }

    @FXML
    public void handleButtonClear(ActionEvent event
    ) {

        clear();

    }

    public float operate(String o, float a, float b) {

        a = dataFirstF;
        b = dataSecondF;
        o = operator;
        float solution = 0f;

        try {
            switch (operator) {
                case "+":
                    solution = a + b;
                    break;
                case "-":
                    solution = a - b;
                    break;
                case "/":
                    if(b!=0){
                    solution = a / b;
                    }else{
                        Exception e = new Exception();
                        throw e;
                    }
                    break;
                case "*":
                    solution = a * b;
                    break;
            }
        } catch (Exception e) {
            display.setText("ERROR");
            clear();
        }

        return solution;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
