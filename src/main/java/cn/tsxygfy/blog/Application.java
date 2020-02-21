package cn.tsxygfy.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author feiyang
 * @version v1.0
 * @className Application
 * @description Beyond Run. And enjoy it.
 * @date 2020/02/10 周一 17:16
 */
@MapperScan(basePackages = "cn.tsxygfy.blog.mapper")
@SpringBootApplication
public class Application {

    public static ConfigurableApplicationContext context;

    // run application
    public static void main(String[] args) {
        context = SpringApplication.run(Application.class, args);
    }

    // restart application
    public static void restart() {
        ApplicationArguments arguments = context.getBean(ApplicationArguments.class);

        Thread thread = new Thread(() -> {
            context.close();
            context = SpringApplication.run(Application.class, arguments.getSourceArgs());
        });

        thread.setDaemon(false);
        thread.start();
    }

    // shutdown application
    public static void shutdown() {
        if (context == null) {
            return;
        }
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            context.close();
        });

        thread.setContextClassLoader(Application.class.getClassLoader());
        thread.start();
    }
}
