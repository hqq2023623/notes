package zj.framework.first;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Lzj Created on 2016/3/20.
 */
public class UserValidator {

    private String name;

    public UserValidator(String name) {
        this.name = name;
    }

    public boolean validate(String name, String password) {
        Random random = new Random();
        long duration = (long) (Math.random() * 10);
        System.out.println("Validator " + name + " Validating a user during " + duration + " seconds");
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return random.nextBoolean();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
