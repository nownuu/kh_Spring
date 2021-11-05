package home.beans;

public class MemberProfileDto {
	private int memberFileNo;
	private String memberId;
	private String memberFileUploadname;
	private String memberFileSavename;
	private String memberFileType;
	private long memberFileSize;
	public MemberProfileDto() {
		super();
	}
	@Override
	public String toString() {
		return "MemberFileDto [memberFileNo=" + memberFileNo + ", memberId=" + memberId + ", memberFileUploadname="
				+ memberFileUploadname + ", memberFileSavename=" + memberFileSavename + ", memberFileType="
				+ memberFileType + ", memberFileSize=" + memberFileSize + "]";
	}
	public int getMemberFileNo() {
		return memberFileNo;
	}
	public void setMemberFileNo(int memberFileNo) {
		this.memberFileNo = memberFileNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberFileUploadname() {
		return memberFileUploadname;
	}
	public void setMemberFileUploadname(String memberFileUploadname) {
		this.memberFileUploadname = memberFileUploadname;
	}
	public String getMemberFileSavename() {
		return memberFileSavename;
	}
	public void setMemberFileSavename(String memberFileSavename) {
		this.memberFileSavename = memberFileSavename;
	}
	public String getMemberFileType() {
		return memberFileType;
	}
	public void setMemberFileType(String memberFileType) {
		this.memberFileType = memberFileType;
	}
	public long getMemberFileSize() {
		return memberFileSize;
	}
	public void setMemberFileSize(long memberFileSize) {
		this.memberFileSize = memberFileSize;
	}
}
