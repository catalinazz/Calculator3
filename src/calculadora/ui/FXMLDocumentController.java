package calculadora.ui;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

//TODO solo permite multiplicar o dividir una sola vez, porque la proxima vez,
//muestra el resultado infinito o un valor inválido(podria ser MIN_VALUE).

public class FXMLDocumentController implements Initializable {
    

    DecimalFormat format = new DecimalFormat("0.#");

    String numberInputS = "";
    float numberInputF = 0f;

    // SEGUNDO OPERANDO
    String dataSecondS = "";
    float dataSecondF = Float.MIN_VALUE;

    //PRIMER OPERANDO; GUARDA RESULTADOS
    String dataFirstS = "";
    float dataFirstF = Float.MIN_VALUE;

    //OPERADOR
    String operator = "";

    //FXML 
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

    @FXML
    public void handleButtonOperator(ActionEvent event) {

        Object source = event.getSource();

        convert();

        //SOURCE
        if (!(dataFirstF == Float.MIN_VALUE)) {
            if (source == plus) {
                String o = "+";
                operator(o);
            } else if (source == minus) {
                String o = "-";
                operator(o);
            } else if (source == mult) {
                String o = "x";
                operator(o);
            } else if (source == div) {
                String o = "/";
                operator(o);
            }

        }
    }

    @FXML
    public void handleButtonEqual(ActionEvent event) {

        convert();

        if (!(dataFirstF == Float.MIN_VALUE)) {
            if (!(dataSecondF == Float.MIN_VALUE || Float.MIN_VALUE == 0)) {
                try {
                    float solution = operate(operator, dataFirstF, dataSecondF);
                    dataFirstF = solution;
                    display.setText(String.valueOf(format.format(dataFirstF)));
                } catch (Exception e) {
                    errorMessage();
                }
            } else {
                errorMessage();
            }

        }

    }

    @FXML
    void handleButtonClear(ActionEvent event) {

        clear();

    }

    float operate(String o, float a, float b) throws Exception {

        a = dataFirstF;
        b = dataSecondF;
        o = operator;
        float solution = 0f;

        switch (operator) {
            case "+":
                solution = a + b;
                break;
            case "-":
                solution = a - b;
                break;
            case "/":
                if (b != 0) {
                    solution = a / b;
                } else {
                    Exception e = new Exception();
                    throw e;
                }
                break;
            case "x":
                solution = a * b;
                break;
        }

        dataSecondF = Float.MIN_VALUE;
        numberInputS = "";

        return solution;
    }

    void operator(String o) {

        display.setText(display.getText() + o);

        if (!(operator.isEmpty())) {
            try {
                float solution = operate(operator, dataSecondF, dataFirstF);
                dataFirstF = solution;
            } catch (Exception e) {
                errorMessage();
            }
        }
        operator = o;

    }

    void confirm() {

        dataSecondS = numberInputS;

        if (dataFirstF == Float.MIN_VALUE) {
            dataFirstS = dataSecondS;

        }
        
        dataFirstF = dataFirstF;
        dataSecondF = dataSecondF;
    }

    void convert() {

        if (!(dataSecondS.isEmpty())) {
            dataSecondF = Float.valueOf(dataSecondS);
            dataSecondS = "";
            numberInputS = "";
        }

        if (!(dataFirstS.isEmpty())) {
            dataFirstF = Float.valueOf(dataFirstS);
            dataFirstS = "";
            numberInputS = "";
        }
    }

    void errorMessage() {
        clear();
        display.setText("ERROR");
    }

    void clear() {

        dataFirstF = Float.MIN_VALUE;
        dataSecondF = Float.MIN_VALUE;

        dataFirstS = "";
        dataSecondS = "";

        operator = "";
        numberInputS = "";
        display.setText("");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}