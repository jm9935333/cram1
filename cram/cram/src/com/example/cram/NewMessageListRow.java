//³Ì·s®ø®§ ListRow
package com.example.cram;

public class NewMessageListRow {

	private String Date;
	private String Message;
//	private static int See;
	
	public NewMessageListRow(String date, String message/*,int see*/) {
		super();

		this.Date = date;
		this.Message = message;
//		this.See = see;
	}

	public String getDate() {
		return this.Date;
	}

	public void setDate(String date) {
		this.Date = date;
	}
	
//	public static int getSee() {
//		return NewMessageListRow.See;
//	}
//
//	public static void setSee(int see) {
//		NewMessageListRow.See = see;
//	}

	public String getMessage() {
		return this.Message;
	}

	public void setMessage(String message) {
		this.Message = message;
	}


}
