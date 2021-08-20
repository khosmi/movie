package movie;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MyReservationRepository extends CrudRepository<MyReservation, Long> {

    List<MyReservation> findByReservationId(Long reservationId);
 //  List<MyReservation> findByReservationId(Long reservationId);
 //  List<MyReservation> findByReservationId(Long reservationId);
    List<MyReservation> findByPayId(Long payId);
    List<MyReservation> findByTicketId(Long ticketId);

}