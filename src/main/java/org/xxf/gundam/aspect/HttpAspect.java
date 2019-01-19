package org.xxf.gundam.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.xxf.gundam.util.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cheng
 */
@Aspect
@Component
public class HttpAspect {

	private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

	@Pointcut("execution(public * org.xxf.gundam.controller.*.*(..))")
	public void log() {
	}

	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// url
		logger.info("url={}", request.getRequestURL());
		// method
		logger.info("method={}", request.getMethod());
		// ip
		logger.info("ip={}", request.getRemoteAddr());
		// 类方法
		logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		Object[] args = joinPoint.getArgs();
		for (int i = 0; i < args.length; i++) {
			// 参数
			logger.info("arg" + i + "{" + args[i] + "}");
		}

	}

	@AfterReturning(returning = "object", pointcut = "log()")
	public void doAfterReturning(Object object) {
		Result result = (Result) object;
		logger.info("response={}", result.toString());
	}

}
