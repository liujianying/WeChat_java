package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;

final class e$a extends al {
    e$a(final String str) {
        super(Looper.getMainLooper(), new a() {
            public final boolean vD() {
                e.up(str);
                return false;
            }
        }, false);
    }
}
