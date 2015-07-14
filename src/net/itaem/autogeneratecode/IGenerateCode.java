package net.itaem.autogeneratecode;

import java.io.IOException;


/**
 * 生成代码接口，这里面默认生成controller,service,dao,mapper,jsp几个包下面的文件
 * @author luohong 15013336
 * @Date 2015-07-06
 * */
public interface IGenerateCode {
	public void generateMybaticsMapper(Class<?> clazz) throws IOException;
	public void generateDao(Class<?> clazz) throws IOException;
	public void generateService(Class<?> clazz) throws IOException;
	public void generateController(Class<?> clazz) throws IOException;
	public void generateJsp(Class<?> clazz) throws IOException;
}
