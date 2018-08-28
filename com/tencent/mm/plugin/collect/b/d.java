package com.tencent.mm.plugin.collect.b;

import java.util.LinkedList;
import java.util.List;

public enum d {
    ;
    
    public List<a> htB;

    private d(String str) {
        this.htB = new LinkedList();
    }

    public final void a(t tVar) {
        for (a aVar : this.htB) {
            if (aVar != null) {
                aVar.b(tVar);
            }
        }
    }
}
