//package Driver;
//
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//
//public class userandadminController implements Initializable {
//
//	@FXML 
//	private Button btnBackMenu;
//
//	@FXML
//	private TableView<Record> tableView;
//
//	@FXML
//	private TableColumn<Record, String> athID;
//
//	@FXML
//	private TableColumn<Record, Integer> point;
//
//
//
//	private ObservableList<Record> mainDisplay = FXCollections.observableArrayList(Ozlympic.gamedb.scoreboard);
//
//
//
//	@Override
//
//	public void initialize() {
//
//
//	}
//
//
//
//	/** handling the button action to back to main menu */
//
//	@FXML
//
//	private void handleBtnBackMenu(ActionEvent event) throws IOException {
//
//		Stage stage = (Stage) btnBackMenu.getScene().getWindow();
//
//		Parent root = FXMLLoader.load(getClass().getResource("/main/views/Main.fxml"));
//
//		Scene scene = new Scene(root);
//
//		stage.setScene(scene);
//
//		stage.show();
//
//	}
//
//}
