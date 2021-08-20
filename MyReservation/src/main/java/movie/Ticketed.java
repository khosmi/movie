
package movie;

public class Ticketed extends AbstractEvent {

    private Long id;
    private Long ReservationID;
    private Long PayID;
    private String userid;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getReservationId() {
        return ReservationID;
    }

    public void setReservationId(Long ReservationID) {
        this.ReservationID = ReservationID;
    }
    public Long getPayId() {
        return PayID;
    }

    public void setPayId(Long PayID) {
        this.PayID = PayID;
    }
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

