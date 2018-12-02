开发步骤记录：

```
1.使用spring boot Initializr, 使用创建spring boot 工程
2.添加web支持、使用http://localhost:8080/greeting测试。或者直接在第一步中选中web功能
3.添加mysql db支持、使用JPA支持ACID，使用spring的CrudRepository接口bean完成db操作。
添加入口http://localhost:8080/demo/add?name=zhang&email=abc@abc.com， 查询使用http://localhost:8080/demo/all
4.封装范型Result对象结果集，使用RESTFUL风格api 返回JSON结果。
查询使用http://localhost:8080/demo/hello, 查询使用http://localhost:8080/demo/error
5.使用Thymeleaf分页, 查询使用 http://localhost:8080/thymeleafdemo/greeting?name=zhangsan
```
