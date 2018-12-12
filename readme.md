开发步骤记录：

```
1.使用spring boot Initializr, 使用创建spring boot 工程
2.添加web支持、使用http://localhost:8080/greeting测试。或者直接在第一步中选中web功能
3.添加mysql db支持、使用JPA支持ACID，使用spring的CrudRepository接口bean完成db操作。
添加入口http://localhost:8080/demo/add?name=zhang&email=abc@abc.com， 查询使用http://localhost:8080/demo/all
4.封装范型Result对象结果集，使用RESTFUL风格api 返回JSON结果。
查询使用http://localhost:8080/demo/hello, 查询使用http://localhost:8080/demo/error
5.使用Thymeleaf分页, 查询使用 http://localhost:8080/thymeleafdemo/greeting?name=zhangsan
6. 使用mybatis和durid 数据连接池，倒入数据，INSERT INTO `miaosha`.`miaoshaUser` (`id`, `name`) VALUES (2, 'zhang')
使用注解@Select 的方式，查询使用mybatis，验证：http://localhost:8080/dbdemo/db/get， 
使用xxxMapper.xml 的方式查询， 验证：http://localhost:8080/dbdemo/db/getall
7. 支持事物功能, 使用@Transactional 注解 让mybatis实现的dao具有事务能力。 验证:  http://localhost:8080/dbdemo/db/tx, 
得到java.sql.SQLIntegrityConstraintViolationException 500 
```