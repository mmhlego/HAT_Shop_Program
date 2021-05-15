package Manager.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EachTransaction {
    @FXML
    private Label TransactionIDLBL;
    @FXML
    private Label TransactionTimeLBL;
    @FXML
    private Label TransactionValueLBL;
    @FXML
    private Label TransactionFromLBL;

    public Label getTransactionIDLBL() {
        return TransactionIDLBL;
    }

    public void setTransactionIDLBL(Label transactionIDLBL) {
        TransactionIDLBL = transactionIDLBL;
    }

    public Label getTransactionTimeLBL() {
        return TransactionTimeLBL;
    }

    public void setTransactionTimeLBL(Label transactionTimeLBL) {
        TransactionTimeLBL = transactionTimeLBL;
    }

    public Label getTransactionValueLBL() {
        return TransactionValueLBL;
    }

    public void setTransactionValueLBL(Label transactionValueLBL) {
        TransactionValueLBL = transactionValueLBL;
    }

    public Label getTransactionFromLBL() {
        return TransactionFromLBL;
    }

    public void setTransactionFromLBL(Label transactionFromLBL) {
        TransactionFromLBL = transactionFromLBL;
    }
}
