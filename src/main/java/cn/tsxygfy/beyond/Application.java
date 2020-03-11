package cn.tsxygfy.beyond;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * <p>
 * Description: Beyond run and enjoy it.
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond
 * @since 2020-02-21 14:56:50
 */
@MapperScan(basePackages = "cn.tsxygfy.beyond.mapper")
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
