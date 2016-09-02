package zj.framework.first;

import java.util.concurrent.Callable;

/**
 * @author Lzj Created on 2016/3/20.
 */
public class TaskValidator implements Callable<String> {

    private UserValidator validator;

    private String username;
    private String password;

    public TaskValidator(UserValidator validator, String username, String password) {
        this.validator = validator;
        this.username = username;
        this.password = password;
    }

    @Override
    public String call() throws Exception {
        //验证不通过
        if (!validator.validate(username, password)) {
            System.out.println(validator.getName() + ": The user has not been found ");
            throw new Exception("Error validating user");
        }
        System.err.println(validator.getName() + " : THe user has been found");
        return validator.getName();
    }
}
