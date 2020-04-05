package pers.xsy.security;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName SecurityServerApp
 * @Description: TODO
 * @Author XsYounG. Tribute to Alan Turing
 * @Date 2020/4/5
 * @Version V1.0
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class SecurityServerApp {
    public static void main(String[] args) {
        SpringApplication.run(SecurityServerApp.class, args);
    }
}
