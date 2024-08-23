package com.meng;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.nio.file.Paths;
import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://menghuanchenfeng.fun:3306/meng?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8", "root", "fjahfhasdiuhfi")
                .globalConfig(builder -> builder
                        .author("menghuanchenfeng")
                        .enableSwagger() // 开启 swagger 模式
                        .outputDir(Paths.get(System.getProperty("user.dir")) + "/meng-admin/src/main/java")
                        .commentDate("yyyy-MM-dd HH:mm:ss")
                )
                .packageConfig(builder -> {
                            builder.parent("com.meng") // 设置父包名
                                    .entity("entity")
                                    .service("service")
                                    .serviceImpl("service.impl")
                                    .mapper("mapper")
                                    .xml("mapper.xml")
                                    .controller("controller")
                                    .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir")+"/meng-admin/src/main/resources/mapper")); // 设置mapperXml生成路径
                        })
                .strategyConfig(builder -> builder.addInclude("bill_type","bill") // 设置需要生成的表名
                        .controllerBuilder()
                        .enableRestStyle()//开启restful风格
                        .entityBuilder()
                        .enableLombok()//开启 Lombok
                        .mapperBuilder()
                        .enableMapperAnnotation()//开启 @Mapper
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();

    }
}
