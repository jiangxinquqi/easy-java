package com.github.shallwe;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * 租户创建事件
 */
@Getter
public class TenantCreatedEvent extends ApplicationEvent {

    private TenantId tenantId;

    public TenantCreatedEvent(TenantId tenantId) {
        super(tenantId);
        this.tenantId = tenantId;
    }

}
