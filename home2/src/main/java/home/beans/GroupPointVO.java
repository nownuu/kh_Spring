package home.beans;

public class GroupPointVO {
	private String memberGrade;
	private int total;
	@Override
	public String toString() {
		return "GroupPointVO [memberGrade=" + memberGrade + ", total=" + total + "]";
	}
	public String getMemberGrade() {
		return memberGrade;
	}
	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public GroupPointVO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
