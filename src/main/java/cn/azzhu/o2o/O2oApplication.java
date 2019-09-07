package cn.azzhu.o2o;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@MapperScan("cn.azzhu.o2o.mapper")
@SpringBootApplication
@EnableTransactionManagement
@ImportResource(locations = {"classpath:kaptcha.xml"})
public class O2oApplication extends Throwable {

    public static void main(String[] args) {
        SpringApplication.run(O2oApplication.class, args);
    }

}
