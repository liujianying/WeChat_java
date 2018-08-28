package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.w;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class s {
    final Map<String, String> aFa;
    final long aGk = 0;
    final String aGl;
    final String aGm;
    final boolean aGn;
    long aGo;

    public s(String str, String str2, boolean z, long j, Map<String, String> map) {
        w.bg(str);
        w.bg(str2);
        this.aGl = str;
        this.aGm = str2;
        this.aGn = z;
        this.aGo = j;
        if (map != null) {
            this.aFa = new HashMap(map);
        } else {
            this.aFa = Collections.emptyMap();
        }
    }
}
