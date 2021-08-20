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
    @Autowired PayRepository payRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCanceledReservation_CancelPay(@Payload CanceledReservation canceledReservation){

        if(!canceledReservation.validate()) return;

        System.out.println("\n\n##### listener CancelPay : " + canceledReservation.toJson() + "\n\n");

        // Sample Logic //
         Pay pay = new Pay();

         pay.setReservationId(canceledReservation.getId());   // 예약ID 설정 by khos
         pay.setStatus("Canceled Payment");                   // 상태 변경 by khos
         payRepository.save(pay);
         

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
