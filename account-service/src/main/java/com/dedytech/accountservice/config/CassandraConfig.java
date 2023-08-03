package com.dedytech.accountservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${bankcloud.cassandra.contact.point}")
    private String contactPoint;

    @Value("${bankcloud.cassandra.port}")
    private int port;
    @Value("${bankcloud.cassandra.keyspace.name}")
    private String keyspaceName;

    @Value("${bankcloud.cassandra.username}")
    private String username;

    @Value("${bankcloud.cassandra.password}")
    private String password;

    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }


    @Override
    protected int getPort(){
        return port;
    }

    @Override
    protected String getContactPoints() {
        return contactPoint;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] {"com.dedytech.accountservice"};
    }

    @Override
    public CassandraClusterFactoryBean cluster(){
        CassandraClusterFactoryBean clusterFactoryBean = super.cluster();
        clusterFactoryBean.setPassword(password);
        clusterFactoryBean.setUsername(username);
        return clusterFactoryBean;
    }
}
