package com.github.shallwe;

import lombok.Getter;

@Getter
public class TenantId {

    private long id = -1;

    public TenantId(long id) {
        this.id = id;
    }
}
