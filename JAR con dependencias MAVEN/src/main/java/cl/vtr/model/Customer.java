package cl.vtr.model;

public class Customer {

	private String id;
	private Long npvrQuota;
	private Long expenditureLimit;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getNpvrQuota() {
		return npvrQuota;
	}
	public void setNpvrQuota(Long npvrQuota) {
		this.npvrQuota = npvrQuota;
	}
	public Long getExpenditureLimit() {
		return expenditureLimit;
	}
	public void setExpenditureLimit(Long expenditureLimit) {
		this.expenditureLimit = expenditureLimit;
	}
	
	
}
