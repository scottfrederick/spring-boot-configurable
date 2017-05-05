package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@RestController
public class GreetingController {
    private GreetingService greetingService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public GreetingController() {
        this.greetingService = new GreetingService();
    }

    @RequestMapping("/greeting")
    public Greeting greeting() {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, greetingService.getName()));
    }

}
