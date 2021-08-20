
package movie;

public class CanceledReservation extends AbstractEvent {

    private Long id;
    private String userid;
    private String movie;
    private Integer price;
    private String cardNO;
    private String status;

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
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getCardNo() {
        return cardNO;
    }

    public void setCardNo(String cardNO) {
        this.cardNO = cardNO;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

