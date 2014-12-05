package com.webdev.test;

/**
 * Created by henriezhang on 2014/9/17.
 */
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerPropertyTest {
    //private static Logger logger = Logger.getLogger(LoggerPropertyTest.class);
    /**
     * @param args
     */
    public static void main(String[] args) {
        //System.setProperty("log4j.configuration", "C:\\Users\\henriezhang\\IdeaProjects\\Test\\src\\log4j.properties");
        //BasicConfigurator.configure();// 自动快速地使用缺省Log4j环境。
        PropertyConfigurator.configure("C:\\Users\\henriezhang\\IdeaProjects\\Test\\src\\log4j.properties");

        Logger logger = Logger.getLogger(LoggerPropertyTest.class);
        //System.out.println("This is println message.");
        for(int i=0; i<100; i++) {
            // 记录debug级别的信息
            logger.debug("A:This is debug message."+i);
            // 记录info级别的信息
            logger.info("B:This is info message."+i);
            // 记录error级别的信息
            logger.error("C:This is error message."+i);
        }
    }
}