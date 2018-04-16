package calculadora.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FXMLDocumentController implements Initializable {

    //dataS almacena los valores ultimos calculados en strings, se sobreescribe al operar o marcar igual.
    String dataS = "";
    float dataF = 0f;
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

        try {
            Object source = event.getSource();

            if (source == one) {
                display.setText(display.getText() + "1");
                numberInputS = (numberInputS + "1");
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

            
            if (!(numberInputS.equals(""))) {
                dataS = numberInputS;

            }

        } catch (Exception e) {
            display.setText("ERROR");

        }

    }

    @FXML
    public void handleButtonOperator(ActionEvent event) {

        //TODO hacer que al presionar el operador, este se muestre en pantalla, y usar la segunda pantalla de arriba
        Object source = event.getSource();

        if (source == plus) {

            dataF = Float.valueOf(dataS);
            numberInputF = Float.valueOf(numberInputS);

            display.setText(display.getText() + "+");

            if (!(operator.equals(""))) {

                if (!(numberInputF == 0f)) {

                    float solution = operate(operator, numberInputF, dataF);
                    String displaySolution = String.valueOf(solution);
                    display.setText(displaySolution);
                    partialResult = solution;
                }

            }
            operator = "+";
            dataS = "";
            numberInputS = "";
        } else if (source == minus) {

            dataF = Float.valueOf(dataS);
            numberInputF = Float.valueOf(numberInputS);

            display.setText(display.getText() + "+");

            if (!(operator.equals(""))) {

                if (!(numberInputF == 0f)) {

                    float solution = operate(operator, numberInputF, dataF);
                    String displaySolution = String.valueOf(solution);
                    display.setText(displaySolution);
                                        partialResult = solution;
                }

            }
            operator = "-";

            dataS = "";
            numberInputS = "";
        } else if (source == mult) {

            dataF = Float.valueOf(dataS);
            numberInputF = Float.valueOf(numberInputS);

            display.setText(display.getText() + "+");

            if (!(operator.equals(""))) {

                if (!(numberInputF == 0f)) {

                    float solution = operate(operator, numberInputF, dataF);
                    String displaySolution = String.valueOf(solution);
                    display.setText(displaySolution);
                                        partialResult = solution;

                }
            }
            operator = "-";

            dataS = "";
            numberInputS = "";
        } else if (source == div) {

            dataF = Float.valueOf(dataS);
            numberInputF = Float.valueOf(numberInputS);

            display.setText(display.getText() + "+");

            if (!(operator.equals(""))) {

                if (!(numberInputF == 0f)) {

                    float solution = operate(operator, numberInputF, dataF);
                    String displaySolution = String.valueOf(solution);
                    display.setText(displaySolution);
                                        partialResult = solution;
                }

            }
            operator = "-";

            dataS = "";
            numberInputS = "";

        }

    }

    void clear() {

        dataF = 0f;
        numberInputF = 0f;

        dataS = "";
        numberInputS = "";

        display.setText("");

    }

    @FXML
    public void handleButtonEqual(ActionEvent event) {

        dataF = Float.valueOf(dataS);
        numberInputF = Float.valueOf(numberInputS);

        if (!(operator.equals(""))) {

            if (!(numberInputF == 0f)) {

                float solution = operate(operator, numberInputF, dataF);
                String displaySolution = String.valueOf(solution);
                display.setText(displaySolution);
            }
        }

    }

    @FXML
    public void handleButtonClear(ActionEvent event) {

        clear();

    }

    public float operate(String o, float a, float b) {

        a = numberInputF;
        b = dataF;
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
