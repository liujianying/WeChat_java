package com.tencent.mm.plugin.backup.bakoldlogic.d;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.LinkedList;

public final class a {
    public LinkedList<a> gYz = new LinkedList();
    ag handler = new ag(Looper.getMainLooper());

    public final boolean f(final int i, final Object obj) {
        this.handler.post(new Runnable() {
            public final void run() {
                a.this.gYz.add(new a(a.this, i, obj));
            }
        });
        return true;
    }
}
