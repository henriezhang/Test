package com.webdev.test;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Created by henriezhang on 2014/9/17.
 */
public class LoggerXmlTest {
    private static Logger logger = Logger.getLogger(LoggerPropertyTest.class);
    /**
     * @param args
     */
    public static void main(String[] args) {
        DOMConfigurator.configure("C:\\Users\\henriezhang\\IdeaProjects\\Test\\src\\main\\resources\\log4j.xml");//加载.xml文件
        System.out.println("This is println message.");
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
    }
}
