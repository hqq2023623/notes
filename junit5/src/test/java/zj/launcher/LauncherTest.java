package zj.launcher;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import zj.ALogger;


/**
 * 使用Launcher API 来启动 JUnit5
 *
 * @author lzj
 * @date 2017/11/3
 **/
public class LauncherTest {

    public static void main(String[] args) {
        //设置搜索和过滤规则
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(
                        selectPackage("zj"),
                        selectClass(ALogger.class)
                )
                .filters(
                        includeClassNamePatterns(".*Tests")
                )
                .build();

        Launcher launcher = LauncherFactory.create();

        // Register a listener of your choice
        //通过监听器来监听获取执行结果
        TestExecutionListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);

        launcher.execute(request);

        //获取搜索过滤后的需要执行的测试计划
        TestPlan testPlan = launcher.discover(request);
    }


}
