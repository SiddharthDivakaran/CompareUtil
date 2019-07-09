package Api_Response_Comparison_Utility.CompareUtil;

public enum FileType {
	TEXT_FILE("txt");

	private final String fileTypeTxt;

	private FileType(String fileTypeTxt) {
		this.fileTypeTxt = fileTypeTxt;
	}

	public String getFileType() {
		return this.fileTypeTxt;
	}

}
