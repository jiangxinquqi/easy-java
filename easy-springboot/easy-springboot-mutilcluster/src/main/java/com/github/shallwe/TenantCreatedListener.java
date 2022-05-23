package com.github.shallwe;

import org.springframework.context.ApplicationListener;

public class TenantCreatedListener implements ApplicationListener<TenantCreatedEvent> {

    @Override
    public void onApplicationEvent(TenantCreatedEvent event) {
        System.out.println("Into TenantCreatedListener");
        System.out.println("Tenant Id is " + event.getTenantId().getId());
        event.toString();
    }

}
