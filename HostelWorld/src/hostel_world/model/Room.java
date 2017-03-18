package hostel_world.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="room")
public class Room implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")
	private Integer id;
	private Integer hid;
	private String title;
	private int breakfast;
	private String type;
	private int person;
	private int cancel;
	private double price;
	private String posturl;


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
