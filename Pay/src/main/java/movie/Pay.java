package movie;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Pay_table")
public class Pay {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long reservationId;
    private String userid;
    private String movie;
    private String theater;
    private String time;
    private Integer price;
    private String cardNo;
    private String status;
    private String seatNo;

    @PostPersist
    public void onPostPersist(){
        Payed payed = new Payed();
        BeanUtils.copyProperties(this, payed);
        //payed.setStatus("Payed");  // 상태 변경 by khos
        payed.publishAfterCommit();

    }

    @PostUpdate
    public void onPostUpdate(){
        Payed payed = new Payed();
        BeanUtils.copyProperties(this, payed);
        //payed.setStatus("Payed");  // 상태 변경 by khos
        payed.publishAfterCommit();

    }

    @PreRemove
    public void onPreRemove(){
        CanceledPay canceledPay = new CanceledPay();
        BeanUtils.copyProperties(this, canceledPay);
        canceledPay.setStatus("Canceled Payment");  // 상태 변경 by khos
        canceledPay.publishAfterCommit();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }
    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }




}
