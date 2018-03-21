package com.unicom.common.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MybatisCodeGenerator {
	
	private static final Logger logger = LoggerFactory.getLogger(MybatisCodeGenerator.class);
	
	public static void main(String[] args) throws Throwable{
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		String resource = "generatorConfig.xml";
		File configFile = Resources.getResourceAsFile(resource);
		
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		
	}
}
