spring security 结合JPA
1、创建springboot工程，加入依赖
2、配置文件 application.properties
3、创建实体类，JPA在实体类加@Entity(name="数据库的表名"),创建成员变量，分别创用户类和角色类
  3.1 用户类需要实现UserDetails接口，并实现该接口的相应方法（同时创建对应的成员变量）
  3.2 一个用户对应多个角色，@ManyToMany，主键主键以及自增长
4、创建dao层，UserDao extends JpaRepository<User, Long>long是User主键的类型
5、创建service层，实现UserDetailsService接口，实现loadUserByUsername方法, 
   这个方法的参数就是用户在登录的时候传入的用户名，
   根据用户名去查询用户信息（查出来之后，系统会自动进行密码比对）
6、创建 SecurityConfig配置类，configure 方法，不是基于内存与JdbcUserDetailsManager，
  而是使用自定义的 UserService
     6.1  注入第五步写的service，UserService
     6.2  重写configure方法，auth.userDetailsService(userService);使用自定义的userService
7、启动程序后，会发现数据库多了三张表，分别是用户表，角色表，用户角色表
8、创建测试类，加入用户，加入用户的角色时候要//角色的创建 前面要加 Role_
9、创建controller层
10、可以在securityconfig配置文件里面，给对应的用户添加权限