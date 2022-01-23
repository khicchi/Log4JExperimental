package net.kicchi;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

@Log4j2
public class TestForLogging {

    @Test
    public void mainTestMethod()
    {
        log.info("this is a pure string message with method name : " +
                Thread.currentThread().getStackTrace()[1].getMethodName());
        //business logic
        regularMethod("regular methods parameter");
    }

    private void regularMethod(String param){
        log.info("now in regular method and logging with parameters. method name: {}, parameters: {}" ,
                Thread.currentThread().getStackTrace()[1].getMethodName(), param);
        errorThrowingMethod();
    }

    private void errorThrowingMethod(){
        int b = 0;
        try{
            System.out.println(20/b);
        }
        catch (Exception e){
            log.error("error occured", e);
        }
    }
}
