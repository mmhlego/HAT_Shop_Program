package Manager.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DataController.UserGetter;
import Model.Transaction;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class TransactionList implements Initializable {
	@FXML
	private VBox MainPanel;
	@FXML
	private TextField SearchTXF;
	@FXML
	private Button SearchBTN;
	@FXML
	private Button RefreshPageBTN;

	ArrayList<Transaction> AllTransactions;

	int i = 0;

	private void search(String s) throws Exception {
		ArrayList<Transaction> searchResult = new ArrayList<>();
		for (Transaction transaction : AllTransactions) {
			if (String.valueOf(transaction.Amount).toLowerCase().contains(s)
					|| transaction.Date.toString().toLowerCase().contains(s)
					|| transaction.FromID.toLowerCase().contains(s) || transaction.ID.toLowerCase().contains(s)) {
				searchResult.add(transaction);
			}

		}
		ShowAllTransactions(searchResult);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			AllTransactions = UserGetter.ConvertTransactionToArrayList(UserGetter.GetTransactionsDB());
			ShowAllTransactions(AllTransactions);
			SearchBTN.setOnAction(e -> {
				try {
					search(SearchTXF.getText().toLowerCase());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
			RefreshPageBTN.setOnAction(e -> {
				try {
					AllTransactions = UserGetter.ConvertTransactionToArrayList(UserGetter.GetTransactionsDB());
					search(SearchTXF.getText().toLowerCase());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void ShowAllTransactions(ArrayList<Transaction> transactions) throws Exception {
		for (Transaction transaction : transactions) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../Components/EachTransaction.fxml"));
			Parent root = loader.load();
			EachTransaction c = loader.getController();
			c.ShowTransactions(transaction);
			MainPanel.getChildren().add(root);
		}

	}

}
