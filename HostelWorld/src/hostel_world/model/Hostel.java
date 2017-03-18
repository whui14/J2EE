package hostel_world.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="hostel")
public class Hostel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "paymentableGenerator", strategy = "native")
    private Integer id;
    private String name;
    private String password;
    private String hostelName;
    private String telephone;
    private String address;
    private Date time;
    private String introduction;
    private String pictureurl;
    private int pass ; //0代表未审核，1代表审核通过，-1表示未通过;4代表修改信息审核中，-2代表修改信息失败


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public String getHostelName() {
        return hostelName;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
    }

}
