package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.jsapi.media.c.2;
import com.tencent.mm.plugin.appbrand.jsapi.media.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.media.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.media.c.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.vending.j.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

class c$1 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ WeakReference fUX;
    final /* synthetic */ c fUY;
    final /* synthetic */ String val$url;

    c$1(c cVar, l lVar, String str, WeakReference weakReference, int i) {
        this.fUY = cVar;
        this.fCl = lVar;
        this.val$url = str;
        this.fUX = weakReference;
        this.doP = i;
    }

    public final void run() {
        a aVar = null;
        for (b i : c.ajq()) {
            aVar = i.i(this.fCl.fdO, this.val$url);
            if (aVar != null) {
                break;
            }
        }
        a aVar2 = aVar;
        if (this.fUX.get() != null && ((l) this.fUX.get()).Sx) {
            if (aVar2 != null) {
                String f;
                switch (2.fUZ[((e) aVar2.get(0)).ordinal()]) {
                    case 1:
                        f = this.fUY.f("fail:file not found", null);
                        break;
                    case 2:
                        Map hashMap = new HashMap(2);
                        hashMap.put("width", Integer.valueOf(((c) aVar2.get(1)).width));
                        hashMap.put("height", Integer.valueOf(((c) aVar2.get(1)).height));
                        hashMap.put("orientation", ((c) aVar2.get(1)).fqt);
                        hashMap.put("type", ((c) aVar2.get(1)).type);
                        f = this.fUY.f("ok", hashMap);
                        break;
                    default:
                        f = this.fUY.f("fail", null);
                        break;
                }
                ((l) this.fUX.get()).E(this.doP, f);
                return;
            }
            ((l) this.fUX.get()).E(this.doP, this.fUY.f("fail:src not support", null));
        }
    }
}
