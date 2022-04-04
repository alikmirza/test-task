package az.test.testtask.configuration;

import az.test.testtask.utils.LogDetail;
import az.test.testtask.utils.LogUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;

import static az.test.testtask.utils.TokenGenerator.generateToken;

@Configuration
@EnableAsync
public class ApplicationConfiguration {

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public LogDetail logDetail() {
        LogDetail logDetail = new LogDetail();
        logDetail.setRequestKey(generateToken());
        HttpServletRequest httpServletRequest = LogUtil.getCurrentRequest();
        if (httpServletRequest != null) {
            logDetail.setIp(LogUtil.getClientIp(httpServletRequest));
            logDetail.setRequestPath(LogUtil.getRequestPath(httpServletRequest));
        }
        return logDetail;
    }

}
