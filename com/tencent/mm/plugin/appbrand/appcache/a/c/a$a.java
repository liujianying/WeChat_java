package com.tencent.mm.plugin.appbrand.appcache.a.c;

import android.util.SparseIntArray;

public class a$a<_Key> extends SparseIntArray {
    public final void o(_Key _key, int i) {
        super.put(_key.hashCode(), i);
    }

    public final int get(_Key _key) {
        return _key == null ? -1 : super.get(_key.hashCode(), -1);
    }
}
