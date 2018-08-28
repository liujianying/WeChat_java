package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class d {
    public float cXm = -85.0f;
    public float cXn = -1000.0f;
    Map<String, Object> htT = new HashMap();
    int mXk = 0;
    long mXl = 0;
    String mXm = "";

    public d() {
        this.htT.clear();
    }

    public final void putValue(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            this.htT.put(str, obj);
        }
    }
}
