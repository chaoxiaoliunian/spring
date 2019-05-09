package com.sjqi.springboot;

import com.sjqi.springboot.applicationlistener.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName SpringBootApplicaton
 * @Description SpringBoot 的入口
 * @Author sjqi
 * @Date 17:09 2019/4/13
 * @Version 1.0
 **/
@SpringBootApplication
@Slf4j
//lombok注解，需要idea 安装对应插件
public class DemoApplicaton implements CommandLineRunner {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {

        ConfigurableApplicationContext context=SpringApplication.run(DemoApplicaton.class);
        context.publishEvent(new MyEvent("hello","测试"));
        //context.getEnvironment().getActiveProfiles();
        System.out.println(context.getBean("myListener"));
    }


    public void run(String... args) throws Exception {
        showConnection();
        showData();
    }

    private void showConnection() throws SQLException {
        log.info(dataSource.toString());
        Connection conn = dataSource.getConnection();
        log.info(conn.toString());
        conn.close();
    }

    private void showData() {
        jdbcTemplate.queryForList("SELECT * FROM FOO")
                .forEach(row -> log.info(row.toString()));
    }
}
