package zj.framework.executor;

/**
 * @author Lzj Created on 2016/3/17.
 */
public class TestExecutor {

    public static void main(String[] args) {
        Server server = new Server();
        for (int i = 0; i < 10; i++) {
            ExecTask execTask = new ExecTask("Task" + i);
            server.executeTask(execTask);
        }
        server.endServer();
    }


}
