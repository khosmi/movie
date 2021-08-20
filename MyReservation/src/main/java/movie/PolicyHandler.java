package movie;

import movie.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReserved_UpdateReservation(@Payload Reserved reserved){

        if(!reserved.validate()) return;

        System.out.println("\n\n##### listener UpdateReservation : " + reserved.toJson() + "\n\n");



        // Sample Logic //

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCanceledReservation_UpdateReservation(@Payload CanceledReservation canceledReservation){

        if(!canceledReservation.validate()) return;

        System.out.println("\n\n##### listener UpdateReservation : " + canceledReservation.toJson() + "\n\n");



        // Sample Logic //

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayed_UpdateReservation(@Payload Payed payed){

        if(!payed.validate()) return;

        System.out.println("\n\n##### listener UpdateReservation : " + payed.toJson() + "\n\n");



        // Sample Logic //

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCanceledPay_UpdateReservation(@Payload CanceledPay canceledPay){

        if(!canceledPay.validate()) return;

        System.out.println("\n\n##### listener UpdateReservation : " + canceledPay.toJson() + "\n\n");



        // Sample Logic //

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverTicketed_UpdateReservation(@Payload Ticketed ticketed){

        if(!ticketed.validate()) return;

        System.out.println("\n\n##### listener UpdateReservation : " + ticketed.toJson() + "\n\n");



        // Sample Logic //

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCanceledTicket_UpdateReservation(@Payload CanceledTicket canceledTicket){

        if(!canceledTicket.validate()) return;

        System.out.println("\n\n##### listener UpdateReservation : " + canceledTicket.toJson() + "\n\n");



        // Sample Logic //

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
