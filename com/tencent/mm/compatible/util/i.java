package com.tencent.mm.compatible.util;

import java.security.PrivilegedAction;

public final class i implements PrivilegedAction {
    private String dgD;
    private String dgE;

    public i(String str) {
        this.dgD = str;
    }

    public final Object run() {
        Object property = System.getProperty(this.dgD);
        return property == null ? this.dgE : property;
    }
}
