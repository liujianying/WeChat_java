package com.tencent.sqlitelint;

import java.util.concurrent.ConcurrentHashMap;

public enum g {
    ;
    
    ConcurrentHashMap<String, f> vnu;

    private g(String str) {
        this.vnu = new ConcurrentHashMap();
    }

    public final f acI(String str) {
        return (f) this.vnu.get(str);
    }
}
