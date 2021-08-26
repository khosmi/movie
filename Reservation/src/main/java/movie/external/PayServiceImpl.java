package movie.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PayServiceImpl implements PayService {
    
    public void pay(Pay pay) {
        System.out.println("@@@@@@@결제 서비스 지연중 입니다. @@@@@@@@@@@@");

    }

}

