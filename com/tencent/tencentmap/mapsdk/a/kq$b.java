package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.a;
import com.tencent.map.lib.b;
import com.tencent.map.lib.c;
import java.lang.ref.WeakReference;

public class kq$b implements a {
    private final WeakReference<kq> a;

    public kq$b(kq kqVar) {
        this.a = new WeakReference(kqVar);
    }

    public ih a() {
        if (this.a == null || this.a.get() == null) {
            return null;
        }
        return ((kq) this.a.get()).b;
    }

    public jg b() {
        if (this.a == null || this.a.get() == null) {
            return null;
        }
        return ((kq) this.a.get()).c;
    }

    public b c() {
        if (this.a == null || this.a.get() == null) {
            return null;
        }
        return ((kq) this.a.get()).d;
    }

    public c d() {
        return null;
    }
}
