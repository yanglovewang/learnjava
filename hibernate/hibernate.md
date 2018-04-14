---
title: hibernate 
tags: hibernate
grammar_cjkRuby: true
---

### hibernate 入门

1. 什么是框架
    - 就是写程序的时候我们可以用的现成的代码就是款技术我们用了框架以后可以少写一部分代码
2. 什么是hibernate框架
    - hibernate框架是应用在三层中的dao层我们
    - 在dao我们做的是jdbc对数据库crud的操作但是使用了hibernate框架我们就可以不用自己写jdbc的代码和自己拼sql，它的底层就是对jdbc的封装
    - hibernate是一个开源轻量级的框架
3. 基于什么思想
    - orm思想:对象关系映射
        - 然我们的实体类和表有一一对应的关系
            - 让实体类和数据库中的表一一对应
            - 让表中的字段和表里面的属性一一对应
        - 不需要直接操作表而是操作对应的实体类
        - 图描述
        - ![enter description here][1]
4. hibernate入门
    - 导入jar包：解压hibernate包以后导入lib目录下的requred和jpa这两个目录里面的jar包
    - 还要导入额外的两部分jar包，一个是连接mysql的jar包还有一个就是日志信息的jar包，因为hibernate本身没有输出日志信息的jar包
    - 创建实体类
        - 实体类要求有一个唯一的属性对应表中的主键
    - 创建表：这里hibernate自己会帮我们把表创建出来，所以不用我们自己创建只需创建号数据库就行了
    - 配置**映射配置**文件：你的实体类和数据表之间的映射关系
        - 映射文件的命名和位置没有固定的要求，但是建议在实体类所在的包里面创建，建议名称.hbm.xml
        - 配置xml文件格式，在xml文件中首先引入文件约束，在hibernate中引入的约束一般是动dtd文件的约束
        - 映射配置文件图例
        - ![enter description here][2]
    - 配置核心配置文件
        - 核心配置文件的格式也是xml，但是核心配置文件的格式和位置是固定的
            - 位置：必须在src下面
            - 名称：必须hibernate.cfg.xml
        - 映入dtd约束
        - hibernate在操作过程中，只会加载核心配置文件，其他的配置文件不会加载
            - 配置数据库信息
            - ![enter description here][3]
            - 配置hibernate信息
            - ![enter description here][4]
            - 把映射文件放到核心的配置文件中来
            - ![enter description here][5]
5. 代码步骤
    - 以下六个步骤前四步和后两步是固定的只有第五步是我们自己实现的逻辑代码
        - 加载hibernate的核心配置文件
        - 创建SessionFactory对象（这个session和web阶段的session没有联系）
        - 使用SessionFactory创建session对象
        - 开启事务
        - 写具体的crud逻辑操作
        - 提交事务
        - 关闭资源
        - 代码如下：
```code
package hibernateTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import entity.User;

public class hibernateDome {

	@Test
	public void addTest() {
//		加载hibernate的核心配置文件
		//这一句就是加载核心配置文件
		Configuration cfg = new Configuration();
		cfg.configure();
//		创建SessionFactory对象（这个session和web阶段的session没有联系）
		//读取hibernate核心配置文件内容
		//在这个过程中根据映射关系把数据库中的表创建好
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
//		使用SessionFactory创建session对象
		//这里创建session 相当于在jdbc中的连接 
		Session session = sessionFactory.openSession();
//		开启事务
		Transaction tx = session.beginTransaction();
//		写具体的crud逻辑操作
		User user = new User();
		user.setUsername("xiao");
		user.setAddres("beijin");
		user.setPassword("239");
		session.save(user);
//		提交事务
		tx.commit();
//		关闭资源
		session.close();
		sessionFactory.close();
	}
}

```
6. 配置文件的详解
    - 映射文件详解
        - 映射文件中的名字和位置是不固定的，但是建议在实体类所在的包里面创建，建议名称.hbm.xml
        - 映射文件中的的name属性对应这实体类中的内容
        - class标签中的name对应的是实体类的全路径
        - id标签和property标签中的出炉满可以省略但是不建议
        - property还有一个type标签来指定创建表的时候字段的数据类型，但是不建议写，因为hibernate默认会把它创建好
    - 核心配置文件
        - hibernate核心配置文件的内容要在<session-factory>这个标签里面（这一点很容易忽略）
        - 核心文件的文件名和路径是固定的
            - 文件名：hibernater.cfg.xml
            - 路径:在src下
        - 核心文件的三个部分
            - 数据库部分（必须的）
            - hibernate部分（可选的）
            - 映射文件引入部分（必须的）
7. hibernate的api
    - Configuration
        - 到src下面加载核心配置文件
        - 有多种编写方式但是最常用的：
        - ![enter description here][6]
    - SessionFactory
        - 创建sessionFactory过程中，读取配置文件中的信息到数据库里面根据映射关系把表创建
        - 下面这个核心文件中的标签是有表就更新，没表就创建：
        - ![enter description here][7]
        - 但是有对个表创建的时候效率就会低，所以我们具体解决的方式就是xiey一个工具类
        - ![enter description here][8]
    - Session
        - 类似与jdbc中的connection 对象
        - 调用session中的不同方法可以实现crud操作
            - 添加 save
            - 修改update
            - 删除delete
            - 根据id查询get
        - Session是单线程的对象
            - session对象不能共用只能自己用
    - Transaction
        - 事务开启、提交、回滚
        - 原子性：要么做要么不做
        - 一致性：数据的总量在执行前不变
        - 隔离性：多个事务对同一组数据操作不会互相产生影响
        - 持久性：提交后就会真正生效
8. 实体类（持久化类）的编写规则
    - 实体类的属性要设置为私有的
    - 属性要有set和get方法
    - 属性中有一个唯一值（一般使用id对应表中字段的主键）
    - 实体类中的属性建议使用基本数据类型中的包装类
9. 主键生成策略
    - hibernate映射配置文件中主键生成策略标签：
    - ![enter description here][9]
    - hibernate提供多种主键的生成方式：
    - ![enter description here][10]
    - 我们主要用的有native和uuid
        - native操作
            - 实体类主键是int类型
            - generator 标签中class属性值是native
        - uuid操作
            - 实体类主键是String类型
            - enerator 标签中class属性值是uuid
10. 对实体类的操作
    - 增加
        - 先建一个实体类，然后保存
    - 删除
        - 先查询要删除的数据再删除
    - 修改
        - 先查询修改的数据在修改
    - 查询
        - 查询
11. 实体类的几种状态saveOrUpadate
    - 瞬时态
    - 托管态
    - 持久态
12. hibernate的一级缓存
    - 缓存：我们把数据保存在数据库中默认的使用流来操作的，这样的话效率是非常的低的，缓存就是把数据保存在内存中这样子效率高
    - hibernate的一级缓存：
        - hibernate一级缓存默认是打开的
        - hibernate的一级缓存的使用范围是在session开启和session关闭之间
        - hibernate缓存的数据的实体类必须是持久态
        - 一级缓存执行图例：
        - ![enter description here][11]
        - 一级缓存持久态数据会自动更新到数据库，也就是说持久态的数据被改动以后不用自己写更新代码就自动更新这是因为在一级缓存中还有一个快照区的概念，以下是图例:
        - ![enter description here][12]
    - 二级缓存
        - 二级缓存现在不用了，代替的是redis技术
        - 二级缓存需要通过配置打开
        - 二级缓存的生存范围是在SessionFactory域间
13. 事务操作的代码规范
    - 如果处理事务不考虑隔离性的话那么会产生以下几个问题
        - 脏读
        - 幻读
        - 不可重复读
    - 解决上面的问题就要设置事物的隔离级别
        - 例如mysql默认隔离级别repeatable read 不可重复读
        - hibernate可以通过配置核心文件来选取事务的隔开级别:
        - ![enter description here][13]
        - 模板代码（回寝室写）
14. hibernate 绑定
    - 因为我们实现事务的地方是在server层不是在dao层，所以我们要保证事务开启过程中使用的session和我们调用多个dao使用的session使用的是同一个session那么就要把session绑定到当前线程
    - 在核心配置文件中配置如下:
    - ![enter description here][14]
    - hibernate提供sessionFactory.getCurrentSession()创建一个session和ThreadLocal绑定方法在hibernate工具类中添加getCurrentSession方法
    
15. hibernate查询query
    - ![enter description here][15]
    - ![enter description here][16]
16. 回顾表关系
    - 一对多
        - 外键在多的一方
    - 多对多
        - 有一张中间表
        - 至少两个字段指向两个表
17. hibernate的一对多操作
    - 一对多映射配置
        - 建立实体类
        - 一的一方配置：
        - ![enter description here][17]
        - 多的一方配置如下：
        - ![enter description here][18]
        - 然后配置核心文件，把两个映射文件加入进来
    - 一对多级联操作
        - 例如添加一个客户，可添加多个联系人
        - 例如删除一个客户hibernate就会把这个客户所对应的所有的联系人都删除掉，如果直接写语句只删除客户就会报错
        - 级联保存方法一（比较复杂写法）：
        - ![enter description here][19]
        - 级联保存方法二：
            - 配置映射文件
            - ![enter description here][20]
            - 简化方法一的代码
    - 级联删除
        - 配置映射文件
        - 编写代码
        - 底层的实现方式是先把外键设置为空，再把两条记录都删除掉
    - 级联修改
        - 例如把属于A的联系人修改到属于B
        - 代码
        - 性能问题inverse属性
            - 因为hibernate是双向绑定外键，所以我们做级联修改操作的时候会对外键修改两次，这样子影响效率解决办法是通过配置inverse属性
            - 在一对多的关系中我们让一的那一方放弃绑定
            - ![enter description here][21]
18. 关于hibernate中的多对多的操作
    - 多对多配置
        - 创建实体类后配置如下
        - ![enter description here][22]
    - 多对多级联操作
        - 级联保存
            - 在用户（保存的一方）映射配置文件中配置cascade="save-update"
            - 创建用户和角色的对象。
            - 把角色对象放进用户的对象
    - 第三张表的维护
        - 让某个用户有某个角色
        - ![enter description here][23]
        - 让某个用户没有某个角色
19. hibernate 查询
    - 对象导航查询
        - 查询某个客户，再里面的所有联系人
        - 代码：
        - ![enter description here][24]
    - OID查询
        - 直接用get方法查询
    - hql查询
    - qbc查询
    - sql的多表联合查询
        - 交叉查询：就是两个的笛卡尔积，就是把两个表的所有记录做一个组合（这种方式在我们业务中很少见）
        - 把查询的表有关联的数据找出来，隐式内连接就是用where的连接语句，显式内连接就是用join on语句
        - 外连接
            - 左连接：左表的数据全部显式，右表的数据只是和左表有关联的数据显式
            - 右连接：和左连接相反
    - hql中的连接
        - hql中的内连接
            - 代码：
            - ![enter description here][25]
            - hql中的内连接没有on语句
        - 迫切内连接
            - 语法就是在内连接的基础上加上一个fetch语句
            - ![enter description here][26]
            - 内连接和迫切内连接的区别在与底层的封装，内连接查询后返回的list集合里面的元素是一个数组，数组里面的元素分别是查询的两个实体类，而迫切内连接返回的是Customer的集合
        - hql的左外连接
            - hql只有左外连接
            - 迫切左外连接
            - 右外连接
20. 检索策略的概念
    - 立即查询：立即查询代码就是查询的时候调用get方法，只要执行这个语句就会向数据库中查询数据
    - 延迟查询: 立即查询是调用load方法，它并不会立即向数据库中发送数据而是要使用数据的时候才去向数据库中查询
        - 类级别延迟
        - 关联级别延迟
            - 在查询客户后再通过客户的对象获取联系人得到set集合，得到set集合的时候是没有发送语句的，只有用到set集合里面的数据时候才发送语句
            - 可以通过配置来改变它的延迟级别
                - 延迟
                - 不延迟
                - 极其延迟


  [1]: ./images/1523064170333.jpg "图描述.jpg"
  [2]: ./images/1523067494407.jpg "配置文件.jpg"
  [3]: ./images/1523074513961.jpg "1523074513961.jpg"
  [4]: ./images/1523074547653.jpg "1523074547653.jpg"
  [5]: ./images/1523074586091.jpg "1523074586091.jpg"
  [6]: ./images/1523079020806.jpg "1523079020806.jpg"
  [7]: ./images/1523079120524.jpg "1523079120524.jpg"
  [8]: ./images/1523079884329.jpg "1523079884329.jpg"
  [9]: ./images/1523087355035.jpg "主键生成策略标签.jpg"
  [10]: ./images/1523087210174.jpg "主键生成策略.jpg"
  [11]: ./images/1523102375012.jpg "一级缓存.jpg"
  [12]: ./images/1523103537641.jpg "1523103537641.jpg"
  [13]: ./images/1523104892794.jpg "配置事务隔离级别.jpg"
  [14]: ./images/1523147366520.jpg "1523147366520.jpg"
  [15]: ./images/1523149880880.jpg "1523149880880.jpg"
  [16]: ./images/1523150093374.jpg "1523150093374.jpg"
  [17]: ./images/1523168123038.jpg "1523168123038.jpg"
  [18]: ./images/1523168173312.jpg "1523168173312.jpg"
  [19]: ./images/1523171177672.jpg "1523171177672.jpg"
  [20]: ./images/1523171221968.jpg "1523171221968.jpg"
  [21]: ./images/1523175142921.jpg "1523175142921.jpg"
  [22]: ./images/1523183800926.jpg "1523183800926.jpg"
  [23]: ./images/1523275637629.jpg "1523275637629.jpg"
  [24]: ./images/1523346955324.jpg "1523346955324.jpg"
  [25]: ./images/1523435340920.jpg "1523435340920.jpg"
  [26]: ./images/1523435475873.jpg "1523435475873.jpg"