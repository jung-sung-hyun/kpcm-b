package kp.cmsc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kp.cmsc.common.config.DataSourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@Slf4j
public class KpcmApplication {

    private final DataSourceService dataSourceService;

    @Autowired
    public KpcmApplication (DataSourceService dataSourceService) {
        this.dataSourceService = dataSourceService;
    }

    public static void main(String[] args) {
        log.debug("===========================KOMSCO Pay System Start============================");
        SpringApplication.run(KpcmApplication.class, args);
    }

}