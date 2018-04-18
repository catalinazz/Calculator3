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
//operador2 almacena el ultimo valor ingresado.
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

        data1s = numberInputS;

        if (data2f == 0f) {
            data2s = data1s;
        }

    }

    void operator(String o) {

        display.setText(display.getText() + o);

        if (!(operator.isEmpty())) {

            float solution = operate(operator, data1f, data2f);
            data2f = solution;
            data1f = 0f;
        }
        operator = o;
        numberInputS = "";

    }

    @FXML
    public void handleButtonOperator(ActionEvent event) {

        Object source = event.getSource();

        //CONVERSION
        if (!(data1s.isEmpty())) {
            data1f = Float.valueOf(data1s);
            data1s = "";
        }

        if (!(data2s.isEmpty())) {
            data2f = Float.valueOf(data2s);
            data2s = "";
        }

        //SOURCE
        try {
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
        } catch (Exception e) {
            display.setText("ERROR");
            clear();
        }
    }

    void clear() {

        data2f = 0f;
        data1f = 0f;

        data2s = "";
        data1s = "";
        numberInputS = "";
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
        operator = "";

    }

    public float operate(String o, float a, float b) {

        a = data2f;
        b = data1f;
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
