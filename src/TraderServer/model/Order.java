package TraderServer.model;

public class Order {
	private int type;
	private String period;
	private int brokerID;
	private int initQty;
	private int dealtQty;
	private String commodityName;
	private int status;
	private double price;
	private int traderID;
	private int orderID;
	
	
	public int getOrderID() {
		return orderID;
	}


	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}


	public int getTraderID() {
		return traderID;
	}


	public void setTraderID(int traderID) {
		this.traderID = traderID;
	}


	public Order() {
		super();
		this.type = -1;
		this.period = null;
		this.brokerID = -1;
		this.initQty = 0;
		this.dealtQty = 0;
		this.commodityName = null;
		this.status = -1;
		this.price = 0;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Order(int type, String period, int brokerID, int traderID, int initQty,
			String commodityName, double price, int orderID) {
		super();
		this.type = type;
		this.period = period;
		this.brokerID = brokerID;
		this.initQty = initQty;
		this.commodityName = commodityName;
		this.price = price;
		this.traderID = traderID;
		this.orderID = orderID;
		
	}
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public int getBrokerID() {
		return brokerID;
	}
	public void setBrokerID(int brokerID) {
		this.brokerID = brokerID;
	}
	public int getInitQty() {
		return initQty;
	}
	public void setInitQty(int initQty) {
		this.initQty = initQty;
	}
	public int getDealtQty() {
		return dealtQty;
	}
	public void setDealtQty(int dealtQty) {
		this.dealtQty = dealtQty;
	}
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
}
