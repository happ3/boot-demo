package com.boot.demo.dao.mbg.plugin;

import org.mybatis.generator.api.ShellRunner;

/**
 * MyBatis Generator 生成
 *
 */
public class MyBatisGeneratorStarter {
	public static void main(String[] args) {
		String config = MyBatisGeneratorStarter.class.getClassLoader().getResource("generatorConfig.xml").getFile();
		String[] arg = { "-configfile", config, "-overwrite" };
		ShellRunner.main(arg);
		System.out.println("generate success!");
	}
}
