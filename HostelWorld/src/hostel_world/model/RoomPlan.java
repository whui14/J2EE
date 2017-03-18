package hostel_world.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="roomplan")
public class RoomPlan implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")
	private Integer id;
	private Integer hid;
	private String title;
	private Date airTime;
	private Date endTime;
	private int breakfast;
	private String type;
	private int person;
	private int cancel;
	private double price;
	private String posturl;
	private int state;                    //0代表待审核1代表通过审核-1代表未通过审核 2代表已经下架了


	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getAirTime() {
		return airTime;
	}

	public void setAirTime(Date airTime) {
		this.airTime = airTime;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(int breakfast) {
		this.breakfast = breakfast;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPerson() {
		return person;
	}

	public void setPerson(int person) {
		this.person = person;
	}

	public int getCancel() {
		return cancel;
	}

	public void setCancel(int cancel) {
		this.cancel = cancel;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPosturl() {
		return posturl;
	}

	public void setPosturl(String posturl) {
		this.posturl = posturl;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
