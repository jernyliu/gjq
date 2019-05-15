org.apache.ibatis.binding.BindingException: Invalid bound statement (not found....
原因：没有配置映射文件，需要在application.xml中指定mybatis.mapper-locations=classpath*:/mappers/*/**Mapper.xml

redis缓存的对象需要实现Serializable接口