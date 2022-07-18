package ca.sheridancollege.antonye.model;

public class Club {
    private int id;
	private String memberName;
	private String memberEmail;
	private String memberPhoneNumber;
	
	// no-arg constructor
	public Club() {}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPhoneNumber() {
		return memberPhoneNumber;
	}

	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
	}
	
	
	

	

}
