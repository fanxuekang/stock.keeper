# stock.keeper
idea2019.3 社区版和MySql8.0数据库。
项目的开发使用了MVC的三层框架结构，技术主要用到了反射，泛型，集合，JDBC。
client端作为前端，veiw层为视图层，用于与用户交互，获取用户输入的数据，并将用户的输入传入到controller层，
server端作为后端，controller层负责将数据传递给server端的service层，service层调用DAO层方法，Dao与数据库交互，实现增删给查功能，
仅用到了MVC的框架，不涉及java前端的内容，所有的输入输出是在控制台完成
