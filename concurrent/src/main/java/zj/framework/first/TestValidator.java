package zj.framework.first;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Lzj Created on 2016/3/20.
 */
public class TestValidator {


    public static void main(String[] args) {

        String username = "lzj";
        String password = "m123";

        UserValidator ldapValidator = new UserValidator("LDAP");
        UserValidator dbValidator = new UserValidator("DataBase");

        TaskValidator ldapTask = new TaskValidator(ldapValidator, username, password);
        TaskValidator dbTask = new TaskValidator(dbValidator, username, password);
        //创建任务列表
        List<TaskValidator> taskList = new ArrayList<>();
        taskList.add(ldapTask);
        taskList.add(dbTask);

        ExecutorService executorService = Executors.newCachedThreadPool();

        String result;

        //调用执行器的invokeAny()
        try {
            result = executorService.invokeAny(taskList);
            System.out.println("Main : Result : " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("Main : End of the Execution");

    }


}
