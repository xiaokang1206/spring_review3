package com.itheima.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ResourceBundle;

//标志该类是spring核心配置类
@Configuration
// <context:component-scan base-package="com.itheima">
@ComponentScan("com.itheima")
//<import reSource=""/>
@Import(DataSourceConfigration.class)
public class SpringConfigration {


}
