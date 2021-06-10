package labels;

public class ShipLabel {
	private static String packingList;
	private static String boxName;
	private static String ProcessName;
	private static String InvoiceNumber;
	private static String weight;
	private static String size;
	private static String materialType;

	public String getPackingList() {
		return packingList;
	}

	public void setPackingList(String packingList) {
		ShipLabel.packingList = packingList;
	}

	public String getBoxName() {
		return boxName;
	}

	public void setBoxName(String boxName) {
		ShipLabel.boxName = boxName;
	}

	public String getProcessName() {
		return ProcessName;
	}

	public void setProcessName(String processName) {
		ShipLabel.ProcessName = processName;
	}

	public String getInvoiceNumber() {
		return InvoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		ShipLabel.InvoiceNumber = invoiceNumber;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		ShipLabel.weight = weight;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		ShipLabel.size = size;
	}

	public static String labelGenerator() {
		String template = "^XA^FO980,1500^GFA,4464,4464,24,gK07FE,MFEV0KF,MFEU07KF,MFET01LF,MFET07KFE,MFET0LFE,MFES03LFC,MFES07LF8,I0FCV0MF8,I0FCU01MF,I0FEU03MF,I0FEU07LFE,I0FEU0MFE,I0FET01MFCK078,I0FET03MFCI01IFC,I0FET03MF8I07JF8,I0FET07MF8001LF,I0FEQ0400NFI07LFC,I0FEQ0C00MFE001MFE,I0FEP03C01MFE003NF8,I0FCP07C01MFC007NFE,I0FEO01FC01MFC00PF,MFEL03FC03MF801PF8,MFEL07FC03MF803PFE,MFEL0FFC03MF007QF,MFEK01FFC07MF00RF8,MFEK03FFC07LFE01RFC,MFEK07FFC07LFC03RFE,S07FFC07LFC03SF,";
		template = template
				+ "S0IFC0MF807RFE,S0IFE07LF80SFC,R01IFE0MF01SF,R03IFE0MF01RFE,R03IFE0LFE03RFC,R03IFE0LFC07RF8,R07IFE0LFC07QFE,R07IFE0LF80RFC,00KFEJ07IFE0LF81RF,03KFEJ07IFE0LF01QFE,0LFEJ07IFE0LF03QFC,1LFEJ07IFE0KFE07QF,3LFEJ07IFE0KFE07PFE,7LFEJ07IFE0KFC0QFC,7FCO07IFE0KF81QF,FFP07IFE0KF81PFE,FEP07IFE0KF03PF8,FCP03IFE0KF07PF,FCP03IFE0JFE07OFC,FCP01IFE0JFC0PF8,FCP01IFE0JFC0OFE,FCQ0IFE0JF81OFCK03F,FCQ0IFE0JF83OFK0JFC,FCQ07IF0JF03NFEJ0LF,FCQ07IF0IFE07NF8I07LFC,";
		template = template
				+ "FEQ03IF0IFE07NFI03NF,FEQ03IF0IFC0NFCI0OF8,7F8P01IF0IFC0NFI07OFC,7LFEK01IF0IF81MFE001QF,3LFEL0IF0IF03MF8007QF8,1LFEL07FF0IF03LFE001RFC,0LFEL07FF0FFE07LFC007RFC,07KFEL03FF0FFE07LF003SFE,01KFEL01FF0FFC0LFC007TF,T01FF0FF80LF801UF,U0FF0FF81KFE007UF8,U07F0FF01KF801VF8,U07F0FE03JFE007VFC,CT03F0FE03JFC01WFC,FT01F0FC07JF003WFE,FCS01F0FC0JFC00XFE,FF8S0F0F80JF003XFE,FFES070F01IFC00gF,IF8R070F01IF001gF,7FFER030E03FFC007gF,1IFCQ010C03FF001gGF,07IFS0407FC003gGF,";
		template = template
				+ "03IFCT07FI0gHF,03JF8S0FC001gHF803F7FFES0FI07gHF803F1IF8Q01CI0gIF803F07FFEU03gIF,03F00FFEU0gIFC,03F003FET01gHFE,03F003FET07gHF8,03F01FFET0gHF8,03F07FFES03gGFE,03F1IF8S07gFC,03JFET0gF,03JF8T01WFE,03IFCY07QF8,07IFgJ07IFE,1IFC,7IF,IF8,FFE,FF8,FEgJ07OF8,FL06T03VF8,CK01ES0YFC,L0FES07gF,K07FES03gGF8,J03FFET0gHF,I01IFET07gHF,I07IFET01gHFC,003JF8U0gIF8,03JF8V07gHFE,0JFCS018001gIF87IFEU0EI07gHF8JFV0FC003gHF8IF8V07FI0gHF,FFCW07FC007gGF,IFU0C03FF001gGF,";
		template = template
				+ "IFER030E03FFC007gF,7IFEQ030E01IF003gF,0JF8P070F01IF800gF,01JF8O0F0F80JF003XFE,003IFEO0F0F80JF801XFE,I07IFEM01F0FC07IFE007WFE,J0IFEM03F0FE07JF801WFC,J03FFEM07F0FE03JFE007VFC,J01FFEM07F0FF03KF803VFC,J0IFEM0FF0FF81KFC00VF8,I07IFEL01FF0FF81LF003UF8,003JFM01FF0FFC0LFC00UF,00JFCM03FF0FFC07KFE003SFE,07IFCN03FF0FFE07LF800SFE,3IFEO07FF0IF03LFE003RFC,JF8O0IF0IF03MFI0RF8,IF8P0IF0IF81MFC003QF,FFEP01IF0IF81NFI0PFE,IFP03IF0IFC0NF8001OFC,IFEO03IF0IFE0NFEI07NF,";
		template = template
				+ "JFCN07IF0IFE07NF8I0MFE,1JF8M07FFE0JF03NFCI01LF8,03JFM0IFE0JF03OFJ03JFE,007IFEL0IFE0JF81OF8K0FFE,I0JFEJ01IFE0JFC1OFE,I01IFEJ01IFE0JFC0PF,J03FFEJ03IFE0JFE07OFC,K0FFEJ03IFE0JFE07OFE,K01FEJ03IFE0KF03PF8,L03EJ07IFE0KF83PFC,M06J07IFE0KF81QF,R07IFE0KFC0QF8,R07IFE0KFC0QFE,R0JFE0KFE07QF,R0JFE0KFE03QF8,R07IFE0LF03QFE,MFEJ07IFE0LF81RF,MFEJ07IFE0LF80RF8,MFEJ07IFE0LFC0RFE,MFEJ03IFE07KFC07RF,MFEJ03IFE07KFE03RFC,MFEJ03IFE07KFE01RFE,FC07E07EJ01IFE07LF01SF,";
		template = template
				+ "FC07E07EJ01IFE07LF80SF8,FC07E07EK0IFC0MF807RFE,FC07E07EK0IFC07LFC07SF,FC07E07EK07FFC07LFC03SF,FC07E07EK03FFC07LFE01RFE,FC07E07EK01FFC07LFE00RF8,FC07E07EL0FFC03MF007QF,FC07E07EL07FC03MF803PFE,FC07E07EL03FC03MF801PFC,FC07E07EL01FC03MFC00PF8,FC07E07EM0FC01MFC007NFE,FCJ07EM07C01MFE003NFC,FCJ07EM01C00MFE001NF,FCJ07EN0400NFI0MFC,FCJ07EQ07MFI03LF,FCJ07EQ03MF8I0KFC,F8W03MFCI03JF,Y01MFCJ03FE,g0MFE,g07LFE,g07MF,g03MF,g01MF8,gG07LF8,MFES03LFC,MFES01LFC,MFET07KFE,MFET01LF,MFEU07KF,MFEU01KF,gJ01IF8,^FS";

		template = template
				+ "^FX Quadros.^FO10,10^GB1190,1704,3^FS^FO10,960^GB1190,3,3^FS^FO168,10^GB3,1704,3^FS^FO840,10^GB3,950,3^FS^FO960,960^GB3,750,3^FS^FO960,1460^GB240,3,3^FS";
		template = template
				+ "^FX BoxCode.^BY4,2,270^FO980,120^BCr,120,N^FD---BoxCode---^FS ^FWr^CF0,100^FO850,120^FD---BoxCode---^FS^CF0,50^FO1130,40^FD[NOME CAIXA]^FS";
		template = template
				+ "^FX Volume Por Site.^BY4,2,270 ^FWr^CF0,100^FO1000,1150^FD---CurrLbl---/---TotalQty---^FS^CF0,50^FO1130,1010^FD[VOLUME POR SITE]^FS";
		template = template
				+ "^FX Nota Fiscal.^BY4,2,270 ^FWr^CF0,120^FO200,1000^FD---NF---^FS^CF0,50^FO350,1000^FD[Nota Fiscal]^FS";
		template = template
				+ "^FX PL Number.^BY4,2,270 ^FWr^CF0,50^FO90,30^FD[P/L NO:]  ---PL---^FS^FO40,550^BQN,2,5^FDMA---PL---^FS";
		template = template
				+ "^FX Informação Volume.^BY4,2,270 ^FWr^CF0,40^FO110,980^FD[PESO BRUTO/LIQUIDO(KG)]    ---Peso---/---Peso---^FS^FO65,980^FD[DIMENSOES(L*W*H MM]    ---Dimensao---^FS^FO20,980^FD[PAIS ORIGEM]^FS";
		template = template
				+ "^FX Nome do processo.^BY4,2,270 ^FWr^CF0,40^FO760,30^FD[NOME PROCESSO]^FS^CF0,80^FO350,30^FB940,5,,L^FD---Processo---^FS";
		template = template + "^FX Tipo do material.^BY4,2,270 ^FWr^CF0,50^FO200,30^FD---Tipo---^FS^XZ ";

		template = template.replace("---BoxCode---", boxName);
		template = template.replace("---TotalQty---", "10");
		template = template.replace("---CurrLbl---", "1");
		template = template.replace("---NF---", InvoiceNumber);
		template = template.replace("---PL---", packingList);
		template = template.replace("---Peso---", weight);
		template = template.replace("---Dimensao---", size);
		template = template.replace("---Processo---", ProcessName);

		if (materialType != "") {
			template = template.replace("---Tipo---", "Tipo: " + materialType);
		} else {
			template = template.replace("---Tipo---", "");
		}
		return template;

	}

}
