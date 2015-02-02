一，升级必看

V1.1.3引入core机制,每一个插件都依赖于core/base.js,请在使用了ligerui的页面都增加这个引用：
<script src="lib/ligerUI/js/core/base.js" type="text/javascript"></script> 
V1.2.0引入解析html模块,如果需要请引用core/inject.js(已经包含在all.js、min.js)
V1.2.1对表单表格的编辑器做了统一化处理,加强了表单的能力
二，更新说明
V1.2.2更新记录
Tree
[需求]优化了加载数据的能力
[需求]增加isExpand(支持灵活地控制展开/收缩状态)
[需求]增加delay(支持延迟加载数据)
表格
[需求]对表格分页条数增加缓存处理
[需求]增加参数toolbarShowInLeft(控制工具条显示在左边还是右边)
表单
[需求]验证部分增加对旧版本的兼容处理
ListBox
[需求]增加方法getDataByValue
Tab
[需求]增加事件onClose、onCloseOther、onCloseAll、onReload
V1.2.1更新记录
核心
[需求]表单、表格编辑器的统一化处理
[BUG]支持jQuery高版本
[BUG]改善layout、dialog在ie下的拖拽操作体验
表单
[需求]表单内置验证支持
[需求]相关表单元素增加参数valueFieldCssClass(隐藏域css样式)
[需求]相关表单元素参数parms支持运行时动态获取
[需求]下拉框组件增加参数alwayShowInTop，增加方法reload、getSelected
[需求]listBox组件增加selectAll方法
[需求]popupEdit增加parms参数
[需求]文本框数值类型默认右对齐
[需求] 表单增加getData setData方法
表格
[需求]优化表格工具条的显示位置,并增加工具条标题的支持
[需求]表格树支持线性数据结构
[需求]表格 列支持auto
[BUG]修复grid不能确定取得更新数据的错误
[BUG]修复grid编辑器位置在显示标题出现错位的情况
[BUG]修改grid排序事件没有起效的问题
树
[需求]tree增加ajaxType、render(自定义html)、selectable(可选择判断函数)参数
V1.2.0更新记录
核心
[需求]支持解析html(属性、事件直接在html元素中定义即可)
表单
[需求]新增RadioList组件
[需求]新增CheckBoxList组件
[需求]新增ListBox组件
[需求]新增PopupEdit(弹出编辑)组件
[需求]表单组件加上readonly支持
[需求]TextBox增加属性currency(货币格式)
[需求]ligerForm组件增加参数labelCss、fieldCss、spaceCss、readonly
[需求]ligerForm组件增加事件onAfterSetFields
[需求]ligerForm组件增加buttons属性
[优化]ligerForm组件优化编辑构造器,增加popup、checkboxlist、radiolist、listbox等
[需求]DateEditor增加属性cancelable、readonly
[需求]DateEditor增加下拉图标样式
[优化]DateEditor和ComboBox下拉框位置优化
[需求]ComboBox增加属性condition(条件设置,配合grid使用)
[需求]ComboBox增加属性cancelable、css、renderItem(下拉选项自定义html函数)
[优化]ComboBox优化url模式，增加属性parms、ajaxType，方法setUrl、setParm
[需求]ComboBox支持自动完成(url模式和grid模式)，增加autocomplete
[优化]ComboBox增加方法getGridHeight、getText、setText
[需求]Button增加属性icon(图标)
树
[需求]增加参数needCancel
工具条
[需求]增加方法removeItem、setEnabled、setDisabled、isEnable
Tab
[需求]增加方法setHeader(设置页签项标题)
表格
[需求]增加属性isSelected(选择初始化函数)
[优化]优化编辑构造器,新增getText和setText
[需求]增加方法setParm、removeParm(ajax参数设置)、getChanges(获取修改过的数据)
[需求]增加事件onGroupExtend(分组展开事件)、onGroupCollapse(分组收缩事件)、onLoadData(加载数据前事件)
[BUG]解决编辑表格在 日期选择框框，或者下拉框 点击会结束编辑状态的情况
[BUG]解决grid刷新表格以后编辑状态还存在的问题
[BUG]解决固定列模式下无法自动根据表格内容调整高度的问题
[需求]增加loadData的别名方法reload
[需求]表格主体的横向滚动条默认不显示
[需求]column.editor的onChange、onChanged事件参数改变
弹窗
[需求]增加事件onContentHeightChange、onClose、onClosed、onStopResize
[BUG]限制弹窗不能拖拽到窗口边界外

V1.1.9更新记录
表单
[BUG]修复isChecked方法重复调用的问题
表格
[BUG]修复表格下拉框/日期 编辑有时无法更新值的问题
[需求]分组行优化自定义函数
下拉框
[BUG]修复 调用updateStyle方法无法更新下拉框树的 问题
其他
[需求]过滤器插件增加设置规则方法


V1.1.8更新记录
基础
[需求]增加条件过滤器插件(通用查询组件)
表单
[需求]增强表单插件，支持自动创建表单，支持表单元素自定义控件的构建扩展。
[需求]文本框插件支持 整数、浮点数的限制
表格
[BUG]修复表格单元格编辑有时无法编辑的问题
[BUG]修复上移，下移方法 选择状态会被取消的问题。
[BUG]修复不能多行编辑的bug
Tab
[BUG]修复以target方式增加时loading不消失的问题
综合
[BUG]修复如果dialog里面带有grid editor ，editor会被覆盖在下面的问题。
窗口
[BUG]修复在dialog再次显示dialog，最后显示的dialog会被遮住的问题




V1.1.7更新记录
基础
[需求]增加一套皮肤

表格
[BUG]修复grid重复加载数据的问题

[BUG]优化grid 日期格式的自定义渲染函数，使之支持 /Date(XXXX)/ 这种格式

[BUG]修复奇偶行效果

[需求]支持改变行高和表头行高

[需求]支持工具条.工具条支持图标图片

对话框
[BUG]修复ligerDialog.confirm() 和ligerMessageBox弹出的对话框位置不是屏幕居中的问题

[BUG]修复ligerDialog里面带有下拉框、或者日期选择框时，选择框被遮住的问题。

[BUG]修复ligerDialog里面带有下拉框、或者日期选择框时，选择框不会随着窗口移动而移动的问题。

布局
[需求]tab 页签项，增加content和target参数。

[需求]tab 增加 loading效果。

[需求]layout增加调整左/右侧宽度时的最小允许宽度

表单
[需求]支持设定表单元素的宽度


V1.1.6更新记录
基础
[需求]全面优化框架图片

[需求]整理简化皮肤Silvery,需要依赖默认的Aqua

表格
[BUG]修复 隐藏列后 再次加载数据，隐藏的列会再次显示 的问题

[BUG]修复存在行序号时,汇总行错位的问题

[需求]重写列调整,需要依赖ligerResizable

[需求]支持动态设置columns

[需求]支持行移位、列拖拽

窗口/对话框
[需求]支持最小化、最大化、可收缩

树
[需求]增加节点图标

[需求]增加节点拖拽


V1.1.5更新记录
表格
[需求]固定列

[需求]多表头支持跨行合并

[需求]增加行编辑模式

[需求]增加明细编辑模式

[需求]增加扩展接口：排序、格式化器,优化扩展接口：编辑器

[需求]选择行支持Ctrl选择

[需求]明细框可以设置高度(detail参数增加onExtend、onCollapse 和height)

[需求]参数移除renderDate、dblClickToEdit 方法移除stringToDate、getFormatDate

[需求]增加参数detailToEdit、frozen、frozenDetail、frozenCheckbox、detailHeight、rownumbers、frozenRownumbers、rownumbersColWidth；
增加方法beginEdit、SubmitEdit、cancelEdit、reRender、addEditRow、extendDetail、collapseDetail、getSelectedRows(支持Ctrl)、getSelected、getSelecteds、getSelectedRowObjs；
增加事件onBeforeChangeColumnWidth、onAfterChangeColumnWidth、onBeginEdit、onAfterBeginEdit、onCancelEdit、onBeforeSubmitEdit、onAfterSubmitEdit

表单
[需求]combobox 增加事件onToggle、onShow、onHide

树
[BUG]修复右键菜单不触发的问题




V1.1.4更新记录
核心
[需求]增加方法的调用方式：liger{Plugin}(method) 

[需求]增加获取属性的调用方式：liger{Plugin}("option",name)

[需求]增加设置属性的调用方式：liger{Plugin}("option",name,value)

综合
[BUG]修复V1.1.3部分插件没有触发事件的BUG

表单
[BUG]修复V1.1.3验证出现的气泡没有消失的BUG

布局
[需求]Tab控件增加双击关闭页签

[需求]Tab控件增加拖动页签功能




V1.1.3更新记录
核心
[需求]引入core/base.js,每一个插件都需要依赖这个文件,其提供了ligerui内置事件处理机制、属性动态设置机制等等

[需求]每一个插件拥有get、set、bind、trigger的方法

基础
[优化]优化了ligerResizable和ligerDrag

[需求]ligerDrag增加副本模式

[需求]ligerDrag增加指定区域释放拖动(Drop)的支持

V1.1.2更新记录
综合
[需求]给每一个插件提供onRender和onRendered接口

表格
[需求]为表格编辑器提供扩展接口

[需求]参数onRClickToSelect(右击行时是否选中)改名whenRClickToSelect

[需求]增加参数clickToEdit、minColumnWidth

[需求]增加事件onEndEdit

[需求]增加方法setColumnWidth(调整列宽)

[需求]参数onRClickToSelect改名whenRClickToSelect

对话框
[优化]移除ligerDialogImagePath,改为$.ligerui.DialogImagePath

[需求]添加设置url方法

[需求]增加加载完成事件onloaded

[需求]增加参数：show、title

Window
[需求]添加load远程文件方法和设置url方法

气泡
[优化]优化气泡控件

树
[需求]增加方法arrayToTree

V1.1.1更新记录
综合
[需求]给每一个组件管理器提供扩展接口

表格
[需求]增加addRows方法,一次性增加多行,参数为行数据数组

[需求]增加了表格列初始化隐藏的属性hide

[BUG]解决表格返回的数据为空时页面不反应的问题

[BUG]解决表格隐藏列以后排序,依旧会把依把已经隐藏的数据显示出来的问题

[BUG]解决在表头右键会出现【显示/隐藏列】，但是在表头点击 【显示/隐藏列】 不消失的问题

[BUG]解决在表格的最后一列点击鼠标右键显示【显示/隐藏列】，【显示/隐藏列】错位的问题

[BUG]解决在表格隐藏列以后，如果是明细情况，明细的宽度没有根据现有显示列改变的问题

[BUG]解决调用显示/隐藏列后【显示/隐藏列菜单】没有更新的问题

[BUG]解决树表格启用编辑状态时数据没有更新准确的问题

[BUG]解决分组模式下启用明细出现问题的BUG

[BUG]解决分组、明细展开框 显示时 没有右边框的问题

[BUG]解决统计时存在 明细或者复选框 不能准确显示的问题

[BUG]解决 分组显示时，收缩所有分组 不能准确显示的问题

[BUG]解决 隐藏列后，调整表头宽度 不能准确显示的问题

下拉框
[BUG]解决带分页下拉框在调整grid宽度时没反应的问题

表单
[BUG]解决不能设置text长度。text本身是可以设置，但在form里初始化text时，没传参数的问题

[需求]统一为每一个表单元素"管理器"提供 设置只读、获取值、设置值的接口




三，目录说明

api             -------------  API目录
demos		-------------  本地demos目录
lib		-------------  框架源代码目录
lab             -------------  实验室，在这里可能会写一些综合应用和创意作品
index.htm	-------------  主页面
indexdata.js    -------------  demos目录树数据
loading.gif	-------------  loading图标
welcome.htm	-------------  欢迎页面

dotnetdemos	-------------  .NET目录(服务器版本的demos目录) 
index.aspx	-------------  .NET文件(服务器版本主页面)
Web.config	-------------  .NET文件(配置文件)


如果没有.net framework环境，可以直接把.NET的相关目录和文件删除，不会影响使用
 

作者：稻米(daomi)
mailto:gd_star@163.com
version:v1.1.8
 