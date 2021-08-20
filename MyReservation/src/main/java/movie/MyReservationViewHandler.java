package movie;

import movie.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MyReservationViewHandler {


    @Autowired
    private MyReservationRepository myReservationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserved_then_CREATE_1 (@Payload Reserved reserved) {
        try {

            if (!reserved.validate()) return;

            // view 객체 생성
            MyReservation myReservation = new MyReservation();
            // view 객체에 이벤트의 Value 를 set 함
            myReservation.setReservationId(reserved.getId());
            myReservation.setUserid(reserved.getUserid());
            myReservation.setMovie(reserved.getMovie());
            myReservation.setTheater(reserved.getTheater());
            myReservation.setTime(reserved.getTime());
            myReservation.setSeatNo(reserved.getSeatNo());
            myReservation.setPrice(reserved.getPrice());
            myReservation.setStatus(reserved.getStatus());
            // view 레파지 토리에 save
            myReservationRepository.save(myReservation);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
/*
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserved_then_CREATE_2 (@Payload Payed payed) {
        try {

            if (!payed.validate()) return;
                // view 객체 조회

                    List<MyReservation> myReservationList = myReservationRepository.findByReservationId(payed.getReservationId());
                    for(MyReservation myReservation : myReservationList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myReservation.setPayId(payed.getId());
                    myReservation.setStatus(payed.getStatus());
                // view 레파지 토리에 save
                myReservationRepository.save(myReservation);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserved_then_CREATE_3 (@Payload Ticketed ticketed) {
        try {

            if (!ticketed.validate()) return;
                // view 객체 조회

                    List<MyReservation> myReservationList = myReservationRepository.findByReservationId(ticketed.getReservationId());
                    for(MyReservation myReservation : myReservationList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myReservation.setTicketId(ticketed.getId());
                    myReservation.setStatus(ticketed.getStatus());
                // view 레파지 토리에 save
                myReservationRepository.save(myReservation);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

*/
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayed_then_UPDATE_1(@Payload Payed payed) {
        try {
            if (!payed.validate()) return;
                // view 객체 조회

                    List<MyReservation> myReservationList = myReservationRepository.findByReservationId(payed.getReservationId());
                    for(MyReservation myReservation : myReservationList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myReservation.setPayId(payed.getId());
                    myReservation.setStatus(payed.getStatus());
                // view 레파지 토리에 save
                myReservationRepository.save(myReservation);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenTicketed_then_UPDATE_2(@Payload Ticketed ticketed) {
        try {
            if (!ticketed.validate()) return;
                // view 객체 조회

                    List<MyReservation> myReservationList = myReservationRepository.findByReservationId(ticketed.getReservationId());
                    for(MyReservation myReservation : myReservationList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myReservation.setTicketId(ticketed.getId());
                    myReservation.setPayId(ticketed.getPayId());  // by khos
                    myReservation.setStatus(ticketed.getStatus());
                // view 레파지 토리에 save
                myReservationRepository.save(myReservation);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCanceledReservation_then_UPDATE_3(@Payload CanceledReservation canceledReservation) {
        try {
            if (!canceledReservation.validate()) return;
                // view 객체 조회

                    List<MyReservation> myReservationList = myReservationRepository.findByReservationId(canceledReservation.getId());
                    for(MyReservation myReservation : myReservationList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myReservation.setStatus(canceledReservation.getStatus());
                // view 레파지 토리에 save
                myReservationRepository.save(myReservation);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCanceledPay_then_UPDATE_4(@Payload CanceledPay canceledPay) {
        try {
            if (!canceledPay.validate()) return;
                // view 객체 조회

                    List<MyReservation> myReservationList = myReservationRepository.findByPayId(canceledPay.getId());
                    for(MyReservation myReservation : myReservationList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myReservation.setStatus(canceledPay.getStatus());
                // view 레파지 토리에 save
                myReservationRepository.save(myReservation);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCanceledTicket_then_UPDATE_5(@Payload CanceledTicket canceledTicket) {
        try {
            if (!canceledTicket.validate()) return;
                // view 객체 조회

                    List<MyReservation> myReservationList = myReservationRepository.findByTicketId(canceledTicket.getId());
                    for(MyReservation myReservation : myReservationList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myReservation.setStatus(canceledTicket.getStatus());
                // view 레파지 토리에 save
                myReservationRepository.save(myReservation);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

