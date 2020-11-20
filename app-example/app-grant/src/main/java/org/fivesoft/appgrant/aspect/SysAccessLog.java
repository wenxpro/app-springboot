package org.fivesoft.appgrant.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.fivesoft.appgrant.aspect.bean.LogBean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


/**
 * 环绕通知
 *
 * @author wenx
 */
@Slf4j
@Aspect
@Component
public class SysAccessLog {


    @Pointcut("execution (* org.fivesoft.*..*Controller.*(..))")
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
            //运行方法
            Object o = pjp.proceed();
            LogBean logBean = handlerHTTP( attributes.getRequest(),pjp,o);
            log.info("[HTTP_>>>]: {}", JSON.toJSONString(logBean));
            return o;
        } catch (Throwable throwable) {
            throw new Exception(throwable.getMessage(), throwable);
        } finally {
            long etime = System.currentTimeMillis();
            log.info("[HTTP_TIME] : {}", (etime - stime) + "ms");
        }
    }

    private LogBean handlerHTTP(HttpServletRequest req,ProceedingJoinPoint pjp,Object o){
        LogBean logBean = new LogBean();
        logBean.setUrl(req.getRequestURL().toString());
        logBean.setMethod(req.getMethod());
        logBean.setAction(pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
        logBean.setParams(JSON.toJSONString(getMethodArg(pjp.getArgs())));
        logBean.setIp(req.getRemoteAddr());
        logBean.setResponse(JSON.toJSONString(o));
        return logBean;
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
