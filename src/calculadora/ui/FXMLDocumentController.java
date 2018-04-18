package calculadora.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FXMLDocumentController implements Initializable {

    //data2s almacena los valores ultimos calculados en strings, funciona como segundo operando, se sobreescribe al operar o marcar igual.
    String data2s = "";
    float data2f = 0f;
    //data1s almacena los valores ultimos indresados en strings, funciona como primer operando, se sobrescribe al volver a ingresar un valor luego de operar.
    String data1s = "";
    float data1f = 0f;
    
    String numberInputS = "";
    float numberInputF = 0f;
    //guarda el ultimo operator ingresado para ser ejecutado 
    //por el proximo operator a ingresar o al marcar igual.
    String operator = "";
    //Resultado parcial, el utlimo que se setea en las operaciones al finalizarlas
    float partialResult = 0f;

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
            numberInputS = (numberInputS + "1");
            display.setText(numberInputS);

        } else if (source == two) {
            numberInputS = (numberInputS + "2");
            display.setText(numberInputS);
        } else if (source == three) {
            numberInputS = (numberInputS + "3");
            display.setText(numberInputS);
        } else if (source == four) {
            numberInputS = (numberInputS + "4");
            display.setText(numberInputS);
        } else if (source == five) {
            numberInputS = (numberInputS + "5");
            display.setText(numberInputS);
        } else if (source == six) {
            numberInputS = (numberInputS + "6");
            display.setText(numberInputS);
        } else if (source == seven) {
            numberInputS = (numberInputS + "7");
            display.setText(numberInputS);
        } else if (source == eight) {
            numberInputS = (numberInputS + "8");
            display.setText(numberInputS);
        } else if (source == nine) {
            numberInputS = (numberInputS + "9");
            display.setText(numberInputS);
        } else if (source == zero) {
            numberInputS = (numberInputS + "0");
            display.setText(numberInputS);
        }

        confirm();

    }

    void confirm() {

        data1s = numberInputS;

        if (data2s.isEmpty()) {
            data2s = data1s;
        }

    }

    @FXML
    public void handleButtonOperator(ActionEvent event) {

        //TODO hacer que al presionar el operador, este se muestre en pantalla, y usar la segunda pantalla de arriba
        Object source = event.getSource();

        if (!(data1s.isEmpty())) {
            data1f = Float.valueOf(data1s);
            data1s = "";
        }

        if (!(data2s.isEmpty())) {
            data2f = Float.valueOf(data2s);
            data2s = "";
        }

        if (source == plus) {

            display.setText(display.getText() + "+");

            if (!(operator.isEmpty())) {

                float solution = operate(operator, data1f, data2f);
                data2f = solution;
                display.setText(String.valueOf(data2f));
                data1f = 0f;

            }

            operator = "+";
            numberInputS = "";
        } else if (source == minus) {

            display.setText(display.getText() + "-");

            if (!(operator.isEmpty())) {

                float solution = operate(operator, data1f, data2f);
                data2f = solution;
                display.setText(String.valueOf(data2f));
                data1f = 0f;

            }

            operator = "-";
            numberInputS = "";
        } else if (source == mult) {

            display.setText(display.getText() + "*");

            if (!(operator.isEmpty())) {

                float solution = operate(operator, data1f, data2f);
                data2f = solution;
                display.setText(String.valueOf(data2f));
                data1f = 0f;

            }

            operator = "*";
            numberInputS = "";
        } else if (source == div) {

            display.setText(display.getText() + "/");

            if (!(operator.isEmpty())) {

                float solution = operate(operator, data1f, data2f);
                data2f = solution;
                display.setText(String.valueOf(data2f));
                data1f = 0f;

            }

            operator = "/";
            numberInputS = "";
        }

    }

    void clear() {

        data2f = 0f;
        data1f = 0f;

        data2s = "";
        data1s = "";
        numberInputS = "";
        operator = "";
        display.setText("");

    }

    @FXML
    public void handleButtonEqual(ActionEvent event) {

        if (!(data1s.isEmpty())) {
            data1f = Float.valueOf(data1s);
            data1s = "";

            if (!(data2s.isEmpty())) {
                data2f = Float.valueOf(data2s);
                data2s = "";
            }

            if (!(data1f == 0 && data2f == 0)) {

                float solution = operate(operator, data1f, data2f);
                data2f = solution;
                display.setText(String.valueOf(data2f));
                display.setText(String.valueOf(data2f));
            } else {
                display.setText("ERROR");
            }

            data1f = 0f;
        }

    }

    @FXML
    public void handleButtonClear(ActionEvent event
    ) {

        clear();

    }

    public float operate(String o, float a, float b) {

        a = data1f;
        b = data2f;
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
                    solution = a / b;
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
