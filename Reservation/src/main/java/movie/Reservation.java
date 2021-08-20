package movie;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Reservation_table")
public class Reservation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String userid;
    private String movie;
    private String theater;
    private String time;
    private String seatNo;
    private Integer price;
    private String cardNo;
    private String status;

    @PostPersist
    public void onPostPersist(){
        Reserved reserved = new Reserved();
        BeanUtils.copyProperties(this, reserved);
        reserved.setStatus("Reserved");  // 예약상태 입력 by khos
        reserved.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        movie.external.Pay pay = new movie.external.Pay();
        // mappings goes here
        BeanUtils.copyProperties(this, pay); // Pay 값 설정 by khos
        pay.setReservationId(reserved.getId());
        pay.setStatus("reserved"); // Pay 값 설정 by khos
        ReservationApplication.applicationContext.getBean(movie.external.PayService.class)
            .pay(pay);

    }
    @PreRemove
    public void onPreRemove(){
        CanceledReservation canceledReservation = new CanceledReservation();
        BeanUtils.copyProperties(this, canceledReservation);
        canceledReservation.setStatus("Canceled Reservation");  // 예약상태 입력 by khos
        canceledReservation.publishAfterCommit();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
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




}
