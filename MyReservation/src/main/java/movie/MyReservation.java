package movie;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="MyReservation_table")
public class MyReservation {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long reservationId;
        private Long payId;
        private Long ticketId;
        private String userid;
        private String movie;
        private String theater;
        private String time;
        private String seatNo;
        private Integer price;
        private String status;


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
        public Long getPayId() {
            return payId;
        }

        public void setPayId(Long payId) {
            this.payId = payId;
        }
        public Long getTicketId() {
            return ticketId;
        }

        public void setTicketId(Long ticketId) {
            this.ticketId = ticketId;
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
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

}
