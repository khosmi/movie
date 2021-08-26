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
    @Autowired PayRepository payRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCanceledReservation_CancelPay(@Payload CanceledReservation canceledReservation){
        /*
        if(!canceledReservation.validate()) return;

        System.out.println("\n\n##### listener CancelPay : " + canceledReservation.toJson() + "\n\n");

        // Sample Logic //
         Pay pay = new Pay();

         pay.setReservationId(canceledReservation.getId());   // 예약ID 설정 by khos
         pay.setStatus("Canceled Payment");                   // 상태 변경 by khos
         payRepository.save(pay);
         //payRepository.delete(pay);                         // 삭제 by khos
         */

         try {
            if (!canceledReservation.validate()) return;
                // view 객체 조회

                    List<Pay> payList = payRepository.findByReservationId(canceledReservation.getId());
                    for(Pay pay : payList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    pay.setStatus(canceledReservation.getStatus());
                // view 레파지 토리에 save
                payRepository.save(pay);
                }

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
