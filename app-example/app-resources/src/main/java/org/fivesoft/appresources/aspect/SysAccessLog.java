package org.fivesoft.appresources.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


/**
 * 环绕通知
 * @author wenx
 */
@Slf4j
@Aspect
@Component
public class SysAccessLog {


    @Pointcut("execution (* com.chinasoftinc.*..*Controller.*(..))")
    public void sysAccessLog() {
    }

    //环绕通知,环绕增强，相当于MethodInterceptor
    @Around(value = "sysAccessLog()")
    public Object doArround(ProceedingJoinPoint pjp) throws Exception {

        long stime = System.currentTimeMillis();

        try {
            // 接收到请求，记录请求内容
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            assert attributes != null;
            HttpServletRequest req = attributes.getRequest();
            // 记录下请求内容
            log.info("[HTTP <<<] ");
            log.info("[HTTP_URL] : {}" , req.getRequestURL().toString());
            log.info("[HTTP_METHOD] : {}" ,  req.getMethod());
            log.info("[HTTP_ACTION] : {}", pjp.getSignature().getDeclaringTypeName()+ "." + pjp.getSignature().getName());
            Object[] args = getMethodArg(pjp.getArgs());
            log.info("[HTTP_PARAMS] : {}", JSON.toJSONString(args));
            log.info("[REMOTE_IP] : {}" ,  req.getRemoteAddr());

            //运行方法
            Object o = pjp.proceed();
            log.info("[HTTP_RESPONSE]: {}",JSON.toJSONString(o));
            return o;
        } catch (Throwable throwable) {
            throw new Exception(throwable.getMessage(), throwable);
        } finally {
            long etime = System.currentTimeMillis();
            log.info("[HTTP_TIME] : {}",  (etime - stime)+"ms");
        }
    }


    private Object[] getMethodArg(Object[] args) {
        Object[] arguments = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ServletRequest || args[i] instanceof ServletResponse || args[i] instanceof MultipartFile) {
                //ServletRequest不能序列化，从入参里排除，否则报异常：java.lang.IllegalStateException: It is illegal to call this method if the current request is not in asynchronous mode (i.e. isAsyncStarted() returns false)
                //ServletResponse不能序列化 从入参里排除，否则报异常：java.lang.IllegalStateException: getOutputStream() has already been called for this response
                continue;
            }
            arguments[i] = args[i];
        }
        return arguments;
    }

}
