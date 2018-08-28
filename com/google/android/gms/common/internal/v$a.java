package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

public final class v$a {
    private final List<String> aOL;
    private final Object aOM;

    private v$a(Object obj) {
        this.aOM = w.ah(obj);
        this.aOL = new ArrayList();
    }

    /* synthetic */ v$a(Object obj, byte b) {
        this(obj);
    }

    public final v$a h(String str, Object obj) {
        this.aOL.add(((String) w.ah(str)) + "=" + String.valueOf(obj));
        return this;
    }

    public final String toString() {
        StringBuilder append = new StringBuilder(100).append(this.aOM.getClass().getSimpleName()).append('{');
        int size = this.aOL.size();
        for (int i = 0; i < size; i++) {
            append.append((String) this.aOL.get(i));
            if (i < size - 1) {
                append.append(", ");
            }
        }
        return append.append('}').toString();
    }
}
