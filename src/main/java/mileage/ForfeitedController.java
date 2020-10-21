package mileage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
public class ForfeitedController {
    @Autowired
    Environment env;

    @Value("${superuser.userId}")
    String superUserId;

    @GetMapping("/env")
    String getEnvSample() {

        // 1. applicationContext 에서 가져오기

        Environment envContext = PointApplication.applicationContext.getEnvironment();
        System.out.println(" applicationContext = " + envContext.getProperty("superuser.userId"));

        // 2. Autowired Environment
        System.out.println(" Autowired Environment = " + env.getProperty("superuser.userId"));

        // 3. @Value
        System.out.println(" @Value = " + superUserId);

        return superUserId;
    }
}
