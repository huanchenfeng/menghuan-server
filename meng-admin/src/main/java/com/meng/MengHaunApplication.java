package com.meng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


    /**
     * 启动程序
     *
     * @author ruoyi
     */
    @SpringBootApplication(scanBasePackages = {"com.meng"})
    @MapperScan("com.meng.mapper")
    public class MengHaunApplication {
        public static void main(String[] args) {
            SpringApplication.run(MengHaunApplication.class, args);
            System.out.println("(♥◠‿◠)ﾉﾞ  梦幻启动成功   ლ(´ڡ`ლ)ﾞ\n");
        }
    }
