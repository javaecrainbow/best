package com.salk.best.web.listener;

import java.io.IOException;

import javax.servlet.ServletContextEvent;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.context.ContextLoaderListener;

/**
 * 管理系统参数
 * 
 * @author salk 2014年9月25日
 */
public class SystemConfigListener extends ContextLoaderListener {
	private static final String CONTEXT_PROPERTIES_CONF_SYS_PROPERTIES = "/context/properties/conf-sys.properties";

	@Override
	public void contextInitialized(ServletContextEvent event) {
		loadProperties();
	}

	private void loadProperties() {
		try {
			PropertiesLoaderUtils.fillProperties(System.getProperties(), new ClassPathResource(
					CONTEXT_PROPERTIES_CONF_SYS_PROPERTIES));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
