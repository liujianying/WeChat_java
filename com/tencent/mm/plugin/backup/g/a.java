package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.LinkedList;

public final class a {
    LinkedList<a> gYz = new LinkedList();
    public ag handler = new ag(Looper.getMainLooper());

    public final boolean f(int i, Object obj) {
        this.handler.post(new 1(this, i, obj));
        return true;
    }
}
