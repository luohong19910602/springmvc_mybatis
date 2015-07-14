package net.itaem.autogeneratecode.privilege;

/**
 * 这里面程序会根据权限类别type来进行分类
 * 所以同一个类别下面的权限必须使用同一个type
 * 
 * 
 * */
@java.lang.annotation.Target(value={java.lang.annotation.ElementType.METHOD})
@java.lang.annotation.Retention(value=java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface GeneratePrivilege {
    public String name();  //权限名字
    public String type();  //权限所属类别
    public String uri();   //权限请求uri
    public String desc();  //权限备注
}
