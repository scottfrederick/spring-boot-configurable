package hello;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable(autowire = Autowire.BY_TYPE, preConstruction = true)
public class GreetingService {
    private NameService nameService;

    @Autowired
    public void setNameService(NameService nameService) {
        this.nameService = nameService;
    }

    public GreetingService() {
    }

    public String getName() {
        return nameService.getName();
    }
}
