package personal.learning.model.entity;

public class Currency {
	
	private String code;
	private String ccy;
	
	public Currency(String code, String ccy) {
		this.code = code;
		this.ccy = ccy;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCcy() {
		return ccy;
	}
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}

	@Override
	public String toString() {
		return "Currency [code=" + code + ", ccy=" + ccy + "]";
	}
	
}
