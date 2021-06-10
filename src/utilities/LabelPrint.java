package utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class LabelPrint {

	private final String port;

	public LabelPrint(String port) {
		this.port = port;
	}

	public void printLabel(String label) throws FileNotFoundException {
		FileOutputStream os = new FileOutputStream(port);
		PrintStream ps = new PrintStream(os);
		// String commands = label;

		ps.println(label);
		ps.close();
	}

	public static void main(String[] argv) throws FileNotFoundException {
		// EplPrint1 p = new EplPrint1("d:\\tmp\\eplcommands.txt");
		LabelPrint p = new LabelPrint("COM1");
		// p.printLabel("23535.A.33.B.233445");
		p.printLabel("^XA^CF0,60^FO220,50^FDIntershipping, Inc.^FS^XZ");
	}

}
