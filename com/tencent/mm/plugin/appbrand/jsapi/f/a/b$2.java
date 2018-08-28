package com.tencent.mm.plugin.appbrand.jsapi.f.a;

import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

class b$2 extends b {
    final /* synthetic */ String bAj;

    b$2(String str) {
        this.bAj = str;
    }

    public final void onResume() {
        x.i("MicroMsg.AppBrandMapManager", "appId:%s onPause, foreground all map", new Object[]{this.bAj});
        synchronized (b.AW()) {
            HashMap hashMap = (HashMap) b.AW().get(this.bAj);
            if (hashMap == null) {
                return;
            }
            for (c cVar : hashMap.values()) {
                if (cVar != null) {
                    cVar.isBackground = false;
                }
            }
        }
    }

    public final void a(c cVar) {
        x.i("MicroMsg.AppBrandMapManager", "appId:%s onPause, background all map", new Object[]{this.bAj});
        synchronized (b.AW()) {
            HashMap hashMap = (HashMap) b.AW().get(this.bAj);
            if (hashMap == null) {
                return;
            }
            for (c cVar2 : hashMap.values()) {
                if (cVar2 != null) {
                    cVar2.isBackground = true;
                }
            }
        }
    }

    public final void onDestroy() {
        x.i("MicroMsg.AppBrandMapManager", "appId:%s onDestroy, remove all map", new Object[]{this.bAj});
        synchronized (b.AW()) {
            HashMap hashMap = (HashMap) b.AW().get(this.bAj);
            if (hashMap == null) {
                return;
            }
            for (c cVar : hashMap.values()) {
                if (cVar != null) {
                    cVar.onPause();
                    cVar.onDestroy();
                }
            }
            b.AW().remove(this.bAj);
        }
    }
}
