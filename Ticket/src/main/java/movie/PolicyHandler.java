package movie;

import movie.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class PolicyHandler{
    @Autowired TicketRepository ticketRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReserved_Ticket(@Payload Reserved reserved){

        if(!reserved.validate()) return;

        System.out.println("\n\n##### listener Ticket : " + reserved.toJson() + "\n\n");


        // Sample Logic // ticket 데이터 저장 
        Ticket ticket = new Ticket();
        ticket.setMovie(reserved.getMovie());
        //ticket.setPayId(reserved.getId());
        ticket.setReservationId(reserved.getId());
        ticket.setSeatNo(reserved.getSeatNo());
        ticket.setStatus(reserved.getStatus());
        ticket.setTheater(reserved.getTheater());
        ticket.setTime(reserved.getTime());
        ticket.setUserid(reserved.getUserid());
        ticketRepository.save(ticket);

        // ticket 데이터 저장 
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayed__Ticket(@Payload Payed payed) {
        try {
            if (!payed.validate()) return;
                // view 객체 조회

                    List<Ticket> ticketList = ticketRepository.findByReservationId(payed.getReservationId());
                    for(Ticket ticket : ticketList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    ticket.setPayId(payed.getId());
                    ticket.setStatus(payed.getStatus());
                // view 레파지 토리에 save
                ticketRepository.save(ticket);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCanceledPay_CancelTicket(@Payload CanceledReservation canceledReservation){
      
        try {
            if (!canceledReservation.validate()) return;
                // view 객체 조회

                    List<Ticket> ticketList = ticketRepository.findByReservationId(canceledReservation.getId());
                    for(Ticket ticket : ticketList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    ticket.setStatus(canceledReservation.getStatus());
                // view 레파지 토리에 save
                ticketRepository.save(ticket);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
        
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
