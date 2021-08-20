
package movie.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="Pay", url="${api.url.pay}")  // Pay Service URL 변수화 by khos
public interface PayService {
    @RequestMapping(method= RequestMethod.GET, path="/pays")
    public void pay(@RequestBody Pay pay);

}

