//package com.example.blog.common;
//
//
//import javax.sql.DataSource;
//import org.apache.ibatis.mapping.DatabaseIdProvider;
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.session.Configuration;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.util.StringUtils;
//
//@Configuration
//public class MybatisPlusConfig {
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    private MybatisPlusProperties properties;
//
//    @Autowired
//    private ResourceLoader resourceLoader = new DefaultResourceLoader();
//
//    @Autowired(required = false)
//    private Interceptor[] interceptors;
//
//    @Autowired(required = false)
//    private DatabaseIdProvider databaseIdProvider;
//
//    /**
//     * mybatis-plus分页插件
//     */
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        PaginationInterceptor page = new PaginationInterceptor();
//        page.setDialectType("mysql");
//        return page;
//    }
//
//    /**
//     * 这里全部使用mybatis-autoconfigure 已经自动加载的资源。不手动指定 配置文件和mybatis-boot的配置文件同步
//     *
//     * @return
//     * @throws IOException
//     */
//    @Bean
//    public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean() throws IOException {
//        MybatisSqlSessionFactoryBean mybatisPlus = new MybatisSqlSessionFactoryBean();
//        mybatisPlus.setDataSource(dataSource);
//        mybatisPlus.setVfs(SpringBootVFS.class);
//        String configLocation = this.properties.getConfigLocation();
//        if (StringUtils.isNotBlank(configLocation)) {
//            mybatisPlus.setConfigLocation(this.resourceLoader.getResource(configLocation));
//        }
//        mybatisPlus.setConfiguration(properties.getConfiguration());
//        mybatisPlus.setPlugins(this.interceptors);
//        MybatisConfiguration mc = new MybatisConfiguration();
//        mc.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
//        mc.setMapUnderscoreToCamelCase(false);// 数据库和java都是驼峰，就不需要
//        mybatisPlus.setConfiguration(mc);
//        if (this.databaseIdProvider != null) {
//            mybatisPlus.setDatabaseIdProvider(this.databaseIdProvider);
//        }
//        mybatisPlus.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
//        mybatisPlus.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
//        mybatisPlus.setMapperLocations(this.properties.resolveMapperLocations());
//        // 设置mapper.xml文件的路径
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        Resource[] resource = resolver.getResources("classpath:mapper/*.xml");
//        mybatisPlus.setMapperLocations(resource);
//        return mybatisPlus;
//    }
//}
