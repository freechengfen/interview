package springboot.manualproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboot.manualproject.services.RedisDistrubuteLock;

@SpringBootTest
class ManualprojectApplicationTests {

    @Autowired
    private RedisDistrubuteLock distrubuteLock;

    @Test
    public void lock(){
        distrubuteLock.lockDemo();
    }

}
