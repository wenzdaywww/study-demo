package com.www.demo.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * 自定义servlet容器信息
 * httpConnector()和tomcatServletWebServerFactory(Connector connector)必须一起使用
 * @author www
 *
 */
@Component
public class CustomeServletContainer{
	/**
	 * 设置http自动跳转为https
	 * @return
	 */
	@Bean
	public Connector httpConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");//设置协议类型，http或者https
		connector.setPort(80);//协议类型的请求端口，这个参数必须设置
		connector.setSecure(false);
		connector.setRedirectPort(443);//重定向的请求端口,不一定与application.properties的配置端口一样
		return connector;
	}
	/**
	 * 通过代码配置tomcat信息
	 * 新版的spring boot中已没有EmbeddedServletContainerFactory这个类，使用TomcatServletWebServerFactory代替
	 * @param connector
	 * @return
	 */
	@Bean
	public TomcatServletWebServerFactory tomcatServletWebServerFactory(Connector connector) {
		TomcatServletWebServerFactory tomcat=new TomcatServletWebServerFactory(){
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint=new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection=new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(connector);
        tomcat.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));
        tomcat.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/500.html"));
        return tomcat;
	}
}
