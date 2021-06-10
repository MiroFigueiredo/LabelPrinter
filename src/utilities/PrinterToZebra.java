package utilities;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.PrintServiceAttribute;
import javax.print.attribute.standard.PrinterName;

public class PrinterToZebra {
	public static String getLabel() {
		return Label;
	}

	public static void setLabel(String label) {
		Label = label;
	}

	public static String getsPrinterName() {
		return sPrinterName;
	}

	public static void setsPrinterName(String sPrinterName) {
		PrinterToZebra.sPrinterName = sPrinterName;
	}

	private static String Label;
	private static String sPrinterName = null;

	public static String[] listPrinters() {

		// PrintService psZebra = null;

		PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
		String[] printerList = new String[services.length];

		for (int i = 0; i < services.length; i++) {

			PrintServiceAttribute attr = services[i].getAttribute(PrinterName.class);

			printerList[i] = ((PrinterName) attr).getValue();
		}

		return printerList;

	}

	public static void print(String printerName, String zplString) {

		try {

			PrintService psZebra = null;

			PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);

			for (int i = 0; i < services.length; i++) {

				PrintServiceAttribute attr = services[i].getAttribute(PrinterName.class);
				sPrinterName = ((PrinterName) attr).getValue();

				if (sPrinterName == printerName) {
					psZebra = services[i];
					break;
				}
			}

			if (psZebra == null) {
				System.out.println("Printer is not found.");
				return;
			}
			DocPrintJob job = psZebra.createPrintJob();

			// String s = "^XA^FO100,40^BY3^B3,,30^FD123ABC^XZ";

			byte[] by = zplString.getBytes();
			DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
			Doc doc = new SimpleDoc(by, flavor, null);
			job.print(doc, null);

		} catch (PrintException e) {
			e.printStackTrace();
		}
	}
}