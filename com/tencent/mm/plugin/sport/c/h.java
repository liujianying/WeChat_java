package com.tencent.mm.plugin.sport.c;

import com.tencent.mm.storage.w;

public final class h extends w {
    public h(String str) {
        super(str);
    }

    public final synchronized long getLong(int i, long j) {
        Object obj = get(i);
        if (obj instanceof Long) {
            j = ((Long) obj).longValue();
        } else if (obj instanceof Integer) {
            j = ((Integer) obj).longValue();
        }
        return j;
    }

    public final synchronized void Og(String str) {
        set(2, str);
    }

    public final synchronized String Oh(String str) {
        String str2;
        Object obj = get(2);
        if (obj instanceof String) {
            str2 = (String) obj;
        } else {
            str2 = str;
        }
        return str2;
    }
}
