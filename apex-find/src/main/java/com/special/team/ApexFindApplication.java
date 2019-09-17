package com.special.team;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApexFindApplication {
    private final static Logger logger = LoggerFactory.getLogger(ApexFindApplication.class);

	public static void main(String[] args) {

	    SpringApplication.run(ApexFindApplication.class, args);

        logger.info("ヾ(◍°∇°◍)ﾉﾞ    项目启动成功      ヾ(◍°∇°◍)ﾉﾞ\n" +
                " ______                           \n" +
                "|_   _ \\                  / |_|_   _ `.          \n" +
                "  | |_) |   .--.    .--. `| | .--.   \n" +
                "  |  __'. / .'`\\ \\/ .'`'`\\ \\ \n" +
                " _| |__) || \\__. || \\__. || |,  | \n" +
                "|  '.__.'  '.__.' . ");
	}

}
