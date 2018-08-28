package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.SparseArray;
import com.tencent.mm.plugin.webview.modelcache.q.a;
import com.tencent.mm.sdk.platformtools.x;

public final class h {
    private static final SparseArray<g> qkh = new SparseArray();
    private static volatile g qki = null;

    private h() {
    }

    @Deprecated
    public static g bYs() {
        if (qki == null) {
            qki = new g(0);
        }
        return qki;
    }

    public static g Bh(int i) {
        g gVar;
        synchronized (h.class) {
            if (qkh.get(i) == null) {
                qkh.put(i, new g(i));
            }
            gVar = (g) qkh.get(i);
            qki = gVar;
        }
        return gVar;
    }

    public static void detach() {
        x.i("MicroMsg.MsgHandlerHolder", "detach");
        synchronized (h.class) {
            for (int i = 0; i < qkh.size(); i++) {
                g gVar = (g) qkh.valueAt(i);
                int keyAt = qkh.keyAt(i);
                if (gVar != null) {
                    a.bUL().Ar(keyAt);
                }
            }
            qkh.clear();
        }
        if (qki != null) {
            a.bUL().Ar(0);
            qki = null;
        }
    }
}
