package com.xiao.base.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.concurrent.atomic.AtomicBoolean;

public class ClassPathJsonApplicationContext extends AbstractApplicationContext {

    private final DefaultListableBeanFactory beanFactory;

    private final AtomicBoolean refreshed = new AtomicBoolean();

    public ClassPathJsonApplicationContext() {
        this.beanFactory = new DefaultListableBeanFactory();
    }

    public ClassPathJsonApplicationContext(String... configLocations) {
        this();
        refresh();
    }

    @Override
    protected void refreshBeanFactory() throws BeansException, IllegalStateException {
        if (!this.refreshed.compareAndSet(false, true)) {
            throw new IllegalStateException(
                    "ClassPathJsonApplicationContext does not support multiple refresh attempts: just call 'refresh' once");
        }
        this.beanFactory.setSerializationId(getId());
    }

    @Override
    protected void closeBeanFactory() {
        this.beanFactory.setSerializationId(null);
    }

    @Override
    public ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException {
        return this.beanFactory;
    }

}
