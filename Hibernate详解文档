ORM – hibernate详解

1.	什么是ORM?
对象关系映射(Object Relational Mapping，简称ORM，或O/RM，或O/R mapping），是一种程序技术，用于实现面向对象编程语言里不同类型系统的数据之间的转换。

ORM的核心原则：
{
	简单：以最基本的形式建模数据；
	传达性：数据库结构被任何人都能理解的语言文档化；
	精确性：基于数据模型创建正确标准化的结构；
}

目的：
	ORM技术是在对象和关系之间提供了一条桥梁，前台的对象型数据和数据库中的关系型的数据通过这个桥梁来相互转化。开发时，不需要再去和复杂的SQL语句打交道，只需简单的操作实体对象的属性和方法。

Hibernate就是JAVA的ORM目前的一个主流框架。

2.	Hibernate介绍
发展：
{
		初创：2001年，澳大利亚墨尔本一位名为Gavin King的27岁的程序员;
发展：2003年，Hibernate开发团队进入JBoss公司，开始全职开发Hibernate;
成熟：2004年，整个Java社区开始从实体bean向Hibernate转移。Hibernate和Spring为代表的轻量级开源框架开始成为Java世界的主流和事实标准；
标准：J2EE5.0标准正式发布以后，持久化框架标准Java Persistent API（简称JPA）基本上是参考Hibernate实现的，而Hibernate在3.2版本开始，已经完全兼容JPA标准。
}




特点：
	{
简化开发：将对数据库的操作转换为对Java对象的操作，从而简化开发。通过修改一个“持久化”对象的属性从而修改数据库表中对应的记录数据。
提升性能：提供线程和进程两个级别的缓存提升应用程序性能。
丰富的映射：有丰富的映射方式将Java对象之间的关系转换为数据库表之间的关系。
数据库无关：屏蔽不同数据库实现之间的差异。在Hibernate中只需要通过“方言”的形式指定当前使用的数据库，就可以根据底层数据库的实际情况生成适合的SQL语句。
非侵入式：Hibernate不要求持久化类实现任何接口或继承任何类，POJO即可。
}


核心：
 
1、Configuration接口:负责配置并启动Hibernate
2、SessionFactory接口:负责初始化Hibernate
3、Session接口:负责持久化对象的CRUD操作
4、Transaction接口:负责事务
5、Query接口和Criteria接口:负责执行各种数据库查询


3.	Hibernate缓存

缓存：
	目的：对于Hibernate这类ORM而言,缓存显的尤为重要,它是持久层性能提升的关键.简单来讲Hibernate就是对JDBC进行封装,以实现内部状态的管理,OR关系的映射等,但随之带来的就是数据访问效率的降低,和性能的下降,而缓存就是弥补这一缺点的重要方法.

一般来讲ORM中的缓存分为以下几类:
         1:事务级缓存:即在当前事务范围内的数据缓存.就Hibernate来讲,事务级缓存是基于Session的生命周期实现的,每个Session内部会存在一个数据缓存,它随着 Session的创建而存在,随着Session的销毁而灭亡,因此也称为Session Level Cache.
         2:应用级缓存:即在某个应用中或应用中某个独立数据库访问子集中的共享缓存,此缓存可由多个事务共享(数据库事务或应用事务),事务之间的缓存共享策略与应用的事务隔离机制密切相关.在Hibernate中,应用级缓存由SessionFactory实现,所有由一个SessionFactory创建的 Session实例共享此缓存,因此也称为SessionFactory Level Cache.
         3:分布式缓存:即在多个应用实例,多个JVM间共享的缓存策略.分布式缓存由多个应用级缓存实例组成,通过某种远程机制(RMI,JMS)实现各个缓存实例间的数据同步,任何一个实例的数据修改,将导致整个集群间的数据状态同步.
	


Hibernate的一，二级缓存策略:
  Hibernate中提供了两级Cache，第一级别的缓存是Session级别的缓存，它是属于事务范围的缓存。这一级别的缓存由hibernate管理的，一般情况下无需进行干预；第二级别的缓存是SessionFactory级别的缓存，它是属于进程范围或群集范围的缓存。这一级别的缓存可以进行配置和更改，并且可以动态加载和卸载，属于多事务级别，要防止事务并发性。
缓存是以map的形式进行存储的(key-id,value-object)
一级缓存(Session):
   事务范围，每个事务(Session)都有单独的第一级缓存.
   一级缓存的管理：当应用程序调用Session的save()、update()、saveOrUpdate()、get()或load()，以及调用查询接口的 list()、iterate()--(用的是n+1次查询，先查id)或filter()方法时，如果在Session缓存中还不存在相应的对象，Hibernate就会把该对象加入到第一级缓存中。当清理缓存时，Hibernate会根据缓存中对象的状态变化来同步更新数据库。 Session为应用程序提供了两个管理缓存的方法： evict(Object obj)：从缓存中清除参数指定的持久化对象。 clear()：清空缓存中所有持久化对象,flush():使缓存与数据库同步。
当查询相应的字段如(name)，而不是对象时，不支持缓存。
二级缓存(SessionFactory):
  Hibernate的二级缓存策略的一般过程如下：
   1:条件查询的时候，总是发出一条select * from table_name where …. （选择所有字段）这样的SQL句查询数据库，一次获得所有的数据对象(这个问题要考虑，如果你查询十万条数据时，内存不是被占用)。
　2:把获得的所有数据对象根据ID放入到第二级缓存中。
　3: 当Hibernate根据ID访问数据对象的时候，首先从Session一级缓存中查；查不到，如果配置了二级缓存，那么从二级缓存中查；查不到，再查询数据库，把结果按照ID放入到缓存。
   4:删除、更新、增加数据的时候，同时更新缓存。
  Hibernate的二级缓存策略，是针对于ID查询的缓存策略，对于条件查询则毫无作用。为此，Hibernate提供了针对条件查询的Query Cache。

Q:什么样的数据适合存放到第二级缓存中？
    1.很少被修改的数据
    2.不是很重要的数据，允许出现偶尔并发的数据
    3.不会被并发访问的数据
    4.参考数据,指的是供应用参考的常量数据，它的实例数目有限，它的实例会被许多其他类的实例引用，实例极少或者从来不会被修改。

拓展：
	
Hibernate 与mybatis？

http://hibernate.org/orm/ 

我的demo 
https://github.com/neville-nie/HIbernateDemo 







