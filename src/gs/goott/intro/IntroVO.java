package gs.goott.intro;

public class IntroVO {
	private int introNo;
	private String userid;
	private String filename;
	private String[] interest;
	private String interestStr;
	private String description;
	private String introdate;
	private String thumbnail;
	private String title;
	private int follower;
	private Double price;
	
	public IntroVO() {}
	public int getIntroNo() {
		return introNo;
	}
	public void setIntroNo(int introNo) {
		this.introNo = introNo;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String[] getInterest() {
		return interest;
	}	
	public void setInterest(String[] interest) {
		this.interest = interest;
		interestStr="";
		for(int i=0;i<interest.length;i++) {
			if(interest.length-1==i) {
				interestStr +=interest[i];
			}else {
				interestStr +=interest[i]+"/";
			}				
		}
	}
	public String getInterestStr() {
		return interestStr;
	}
	public void setInterestStr(String interestStr) {
		this.interestStr = interestStr;
		interest = interestStr.split("/");
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIntrodate() {
		return introdate;
	}
	public void setIntrodate(String introdate) {
		this.introdate = introdate;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getFollower() {
		return follower;
	}
	public void setFollower(int follower) {
		this.follower = follower;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
