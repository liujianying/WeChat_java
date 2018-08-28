package com.tencent.mm.plugin.ah;

import android.util.SparseArray;

public enum c {
    ;
    
    public final SparseArray<b> nbQ;

    private c(String str) {
        this.nbQ = new SparseArray();
    }

    public final boolean a(b bVar) {
        this.nbQ.put(bVar.getType(), bVar);
        return true;
    }
}
