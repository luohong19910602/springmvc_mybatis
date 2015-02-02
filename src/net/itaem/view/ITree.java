package net.itaem.view;
import java.util.List;  
  
/**  
 * liger ui中Tree模型  
 * 
 * 菜单模型使用树的结构进行组织
 * 一个ITreeModel有两个形态，一个是Menu，一个Leaf
 * 遍历节点的时候，会递归遍历结点
 * 
 * 这个接口主要用来描述菜单的一些相关操作
 * 每一个后台框架都应该实现该接口，然后对外体现出一致性
 * 目前框架提供了LigerUI Tree的实现
 * 
 * <br>
 * 如果用户如果感兴趣，可以提供一个DWZ, EXTJS的实现
 * 在判断一个结点是否是同一个结点，这里使用结点ID来判断
 * 为了配置菜单的显示顺序，这里需要默认指定一个排序方式
 * 
 * @see LigerUiTree
 * 
 * @date 2014-08-19 10:17 am  
 * @author 骆宏  
 * @email 846705189@qq.com  
 *   
 * */  
public interface ITree {  
    /**  
     * 定义一个字符串，用来表示树模型中的菜单节点  
     * */  
    String MENU = "menu";  
      
    /**  
     * 定义一个字符串，用来表示数模型中的叶子节点  
     * */  
    String LEAF = "leaf";  
    
    /**  
     * 返回当前菜单的结构层次  
     * @return 返回菜单的结构层次  
     *         如果是叶子节点，那么返回0  
     * */  
    public int level();  
      
    /**  
     * 返回当前节点的所有子节点，子节点包括了子菜单以及叶子节点  
     * @return 返回当前菜单的全部子节点  
     * */  
    public List<ITree> children();  
      
    /**  
     * 返回当前节点的父节点  
     * @return 返回当前节点的父亲节点，如果没有父亲节点，返回null  
     * */  
    public ITree parent();  
      
    /**  
     * 返回当前节点的节点类型，这里的节点类型一共有两种，一种是菜单，另外一种是叶子节点  
     * @return 节点类型  
     * @see ITree#MENU  
     * @see ITree#LEAF  
     * */  
    public String nodeType();  
      
    /**  
     * 返回当前节点的url  
     * @return 当前节点的url  
     * */  
    public String url();  
      
    /**  
     * 放回当前节点的id  
     * @return 当前节点id  
     * */  
    public String id();  
      
    /**  
     * 返回节点的名字  
     * @return 节点名字  
     * */  
    public String name();  
      
    /**  
     * 当前节点如果是菜单，那么该菜单默认是否展开呢？如果是返回true，代表展开；否则，代表不展开  
     * @return 返回菜单节点的展开状态  
     * */  
    public boolean isexpand();  
      
    /**  
     * 设置菜单名字  
     * @param name  
     * */  
    public void setName(String name);  
      
    /**  
     * 设置菜单url  
     * @param url  
     * */  
    public void setUrl(String url);  
      
    /**  
     * 设置菜单展开状态  
     * @param isexpend  
     * */  
    public void setIsexpand(boolean isexpand);  
      
    /**  
     * 设置父节点  
     * @param parent  
     * */  
    public void setParent(ITree parent);  
      
    /**  
     * 设置孩子节点  
     * @param children  
     * */  
    public void setChildren(List<ITree> children);  
      
    /**  
     * 设置节点id  
     * @param id  
     * */  
    public void setId(String id);  
      
    /**  
     * 返回该节点的json数据，包含该节点下面的所有子节点  
     * @return 返回当前节点的json数据  
     * */  
    public String toTreeJson();  
      
    /**  
     * 返回从根节点到当前节点的所有节点集合，包含当前节点
     * 该集合的第一个元素为最大根节点，第二个元素为第二个根结点，依次类推 
     * @return 返回根节点到当前节点的集合  
     * */  
    public List<ITree> route();  
    
    /**  
     * 返回当前结点下面的第position结点
     * @return 返回以当前节点子根节点的子树  
     * */  
    public ITree subTree(int position);  
    
    /**
     * 添加子节点，添加到结点的结尾处
     * @param subTree 要添加的子节点
     * */
    public boolean addSubTree(ITree subTree);
    
    /**
     * 在指定position添加结点
     * @param position 下标
     * @param subTree 要添加的子节点
     * */
    public void addSubTree(int position, ITree subTree);
    
    /**
     * 删除子节点
     * @param subTree 要删除的结点
     * */
    public boolean deleteSubTree(ITree subTree);
    
    /**
     * 删除子节点
     * @param position 要删除的结点在子节点中的位置
     * */
    public boolean deleteSubTree(int position);
    
    /**
     * 判断类型
     * @return
     * */
    public boolean isMenu();
    
    /**
     * 判断类型
     * @return
     * */
    public boolean isLeaf();
    
    /**
     * 返回Menu的图片
     * @return
     * */
    public String pic();
    
    /**
     * 返回图标的图片
     * @param pic 图片url地址
     * */
    public void setPic(String pic);
}  