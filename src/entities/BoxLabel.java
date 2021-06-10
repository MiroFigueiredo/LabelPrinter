package entities;

public class BoxLabel {
	private String packingList;
	private String boxName;
	private String ProcessName;
	private String InvoiceNumber;
	private String weight;
	private String size;
	private String processType;

	public BoxLabel(String packingList, String boxName, String processName, String invoiceNumber, String weight,
			String size, String processType) {
		this.packingList = packingList;
		this.boxName = boxName;
		this.ProcessName = processName;
		this.InvoiceNumber = invoiceNumber;
		this.weight = weight;
		this.size = size;
		this.processType = processType;
	}

	public String getProcessType() {
		return processType;
	}

	public void setProcessType(String processType) {
		this.processType = processType;
	}

	public String getPackingList() {
		return packingList;
	}

	public void setPackingList(String packingList) {
		this.packingList = packingList;
	}

	public String getBoxName() {
		return boxName;
	}

	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}

	public String getProcessName() {
		return ProcessName;
	}

	public void setProcessName(String processName) {
		ProcessName = processName;
	}

	public String getInvoiceNumber() {
		return InvoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		InvoiceNumber = invoiceNumber;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
