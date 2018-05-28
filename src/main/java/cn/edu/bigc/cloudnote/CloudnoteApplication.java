package cn.edu.bigc.cloudnote;

import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "cn.edu.bigc.cloudnote.mapper")
public class CloudnoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudnoteApplication.class, args);
    }
}
