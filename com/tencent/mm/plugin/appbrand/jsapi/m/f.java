package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView.d;
import java.util.LinkedList;
import java.util.List;

public final class f {
    private static long fYv = 200;
    private static long fYw = 20;
    private g fYb;
    private final List<h> fYx;
    private Runnable fYy;

    /* synthetic */ f(byte b) {
        this();
    }

    public static f ajz() {
        return a.fYA;
    }

    private static boolean ajA() {
        if (MMWebView.getUsingTbsCoreVersion(ad.getContext()) < 36867 && MMWebView.getCurWebType() != d.vAP) {
            return false;
        }
        return true;
    }

    public static int kR(int i) {
        switch (i) {
            case 0:
                return 0;
            case 20:
                return 1;
            case 60:
                return 2;
            default:
                return 3;
        }
    }

    public static int ajB() {
        return ajA() ? 5 : 20;
    }

    private f() {
        this.fYx = new LinkedList();
        fYv = (long) (ajA() ? 20 : 200);
        this.fYy = new 1(this);
        this.fYb = new g(fYv, new 2(this));
    }

    public final boolean a(h hVar, c cVar) {
        if (hVar == null) {
            return false;
        }
        if (!hVar.b(cVar)) {
            return false;
        }
        boolean isEmpty;
        synchronized (this.fYx) {
            isEmpty = this.fYx.isEmpty();
            if (this.fYx.isEmpty()) {
                this.fYx.add(hVar);
            } else if (((h) this.fYx.get(0)).equals(hVar)) {
                this.fYx.add(0, hVar);
                this.fYx.remove(1);
            } else {
                this.fYx.remove(hVar);
                this.fYx.add(hVar);
            }
        }
        if (isEmpty && !this.fYb.k(new Object[0])) {
            x.v("MicroMsg.SensorJsEventPublisher", "post delay publish event(event : %s).", new Object[]{hVar.getName()});
            com.tencent.mm.plugin.appbrand.r.c.Em().h(this.fYy, fYv);
        }
        return true;
    }
}
