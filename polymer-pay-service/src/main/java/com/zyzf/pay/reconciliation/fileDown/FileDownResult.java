package com.zyzf.pay.reconciliation.fileDown;

import java.io.Serializable;

/**
 * 微信文件下载返回结果实体
 *
 */
public class FileDownResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9154198958690896977L;

	/**
	 * 文件编码
	 */
	private String fileCharSet = "UTF-8";

	/**
	 * 文件内容
	 */
	private String fileContent;

	/**
	 * 文件是否由平台生成
	 */
	private boolean isPlatBuild = true;

	public String getFileCharSet() {
		return fileCharSet;
	}

	public void setFileCharSet(String fileCharSet) {
		this.fileCharSet = fileCharSet;
	}

	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

	public boolean isPlatBuild() {
		return isPlatBuild;
	}

	public void setPlatBuild(boolean isPlatBuild) {
		this.isPlatBuild = isPlatBuild;
	}

}
