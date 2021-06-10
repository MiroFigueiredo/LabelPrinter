package gui;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import entities.BoxLabel;
import gui.util.Alerts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import utilities.ExcelLoad;
import utilities.ExcelTemplate;
import utilities.PrinterToZebra;
import utilities.zplCreate;

public class ShipViewControler {
	// Ship Label pint form
	private BoxLabel[] boxList;
	@FXML
	private TableView<BoxLabel> shipTable;
	@FXML
	private TableColumn<BoxLabel, String> boxNameColumn;
	@FXML
	private TableColumn<BoxLabel, String> sizeColumn;
	@FXML
	private TableColumn<BoxLabel, String> weightColumn;
	@FXML
	private TableColumn<BoxLabel, String> materialTypeColumn;
	@FXML
	private Label lblPackingList;
	@FXML
	private Label lblProcessName;
	@FXML
	private Label lblInvoice;
	@FXML
	private ComboBox<String> cbxPrinter;
	@FXML
	private Button btnPrintShip;

	// Reg ID label form
	@FXML
	private Button btnPrintRegIdLabel;
	@FXML
	private TextField txbRedId;

	@FXML
	private TextField txbQty;
	@FXML
	private CheckBox checkUseCurrentTime;

	private void loadDataToTable(BoxLabel[] boxList) {
		ObservableList<BoxLabel> tableInfo = FXCollections.observableArrayList();
		for (BoxLabel box : boxList) {
			tableInfo.add(box);
		}

		boxNameColumn.setCellValueFactory(new PropertyValueFactory<BoxLabel, String>("boxName"));
		sizeColumn.setCellValueFactory(new PropertyValueFactory<BoxLabel, String>("size"));
		weightColumn.setCellValueFactory(new PropertyValueFactory<BoxLabel, String>("weight"));
		materialTypeColumn.setCellValueFactory(new PropertyValueFactory<BoxLabel, String>("processType"));

		shipTable.setItems(tableInfo);

	}

	public void btnPrintShipLbl() throws Exception {

		String fileName = null;

		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel file", "xls", "xlsx");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			// System.out.println("You chose to open this file: " +
			// chooser.getSelectedFile().getName());
			fileName = chooser.getSelectedFile().getAbsolutePath();

			boxList = ExcelLoad.getFileInfo(fileName);
			try {
				lblPackingList.setText(boxList[1].getPackingList());
				lblProcessName.setText(boxList[1].getProcessName());
				lblInvoice.setText(boxList[1].getInvoiceNumber());

				loadDataToTable(boxList);
			} catch (Exception e) {
				Alerts.showAlert("Error", null, "Wrong file structure", AlertType.ERROR);
			}
		} else {
			return;

		}

		// fileName = "C:/Users/miron/Desktop/testando.xls";

		// lblPackingList.setText(boxList[1].getPackingList());
		// lblProcessName.setText(boxList[1].getProcessName());
		// lblInvoice.setText(boxList[1].getInvoiceNumber());

		// loadDataToTable(boxList);

	}

	@FXML
	public void btnPrint() {
		String printerName = cbxPrinter.getValue();
		String zplCode = zplCreate.ShipLabelGenerator(boxList);
		PrinterToZebra.print(printerName, zplCode);

	}

	@FXML
	public void initialize() {
		cbxPrinter.getItems().removeAll(cbxPrinter.getItems());
		cbxPrinter.getItems().addAll(PrinterToZebra.listPrinters());
		// cbxPrinter.getSelectionModel().select("Option B");
	}

	@FXML
	private void btnPrintRegId() {

		String printerName = cbxPrinter.getValue();
		if (printerName != null) {
			try {
				Calendar calendar = Calendar.getInstance();
				// SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				String regId = txbRedId.getText();
				int quantity = Integer.parseInt(txbRedId.getText());
				Date date = calendar.getTime();

				String zplCodeString = zplCreate.RegIdLabelGenerator(regId, quantity, date);
				// String printerName = cbxPrinter.getValue();
				PrinterToZebra.print(printerName, zplCodeString);
			} catch (Exception e) {
				Alerts.showAlert("Erro to Print the file", null, "Check the number of label.", AlertType.ERROR);
			}

		} else {
			Alerts.showAlert("Erro to Print the file", null, "Is needed to select a printer", AlertType.ERROR);
		}

	}

	@FXML
	private void btnPrintShip() {
		String printerName = cbxPrinter.getValue();
		if (printerName != null) {
			String zplCode = zplCreate.ShipLabelGenerator(boxList);
			PrinterToZebra.print(printerName, zplCode);
		} else {
			Alerts.showAlert("Erro to Print the file", null, "Is needed to select a printer", AlertType.ERROR);
		}

	}

	@FXML
	private void lblDownloadTemplate() throws Exception {
		String fileName;
		JFrame parentFrame = new JFrame();

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel file", "xls");
		fileChooser.setFileFilter(filter);
		int userSelection = fileChooser.showSaveDialog(parentFrame);

		if (userSelection == JFileChooser.APPROVE_OPTION) {

			File fileToSave = fileChooser.getSelectedFile();
			fileName = fileToSave.getAbsolutePath();

			if (fileName.length() > 3) {

				if (fileName.indexOf(".xls") == -1) {
					fileName = fileName + ".xls";

				}

				ExcelTemplate.fileDownload(fileName);
				Alerts.showAlert("Template Download", null, "The template was downloaded successfully",
						AlertType.INFORMATION);

			}

		}

	}

}
