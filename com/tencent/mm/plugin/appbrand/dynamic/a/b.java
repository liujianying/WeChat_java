package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.modelappbrand.c;
import com.tencent.mm.modelappbrand.d;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Set;

final class b implements d {
    c fvh;
    Runnable fvi = new 1(this);
    Runnable fvj = new Runnable() {
        public final void run() {
            if (g.fF("com.tencent.mm:support")) {
                f.a("com.tencent.mm:support", null, a.class, new com.tencent.mm.ipcinvoker.c<Bundle>() {
                    public final /* synthetic */ void at(Object obj) {
                        x.i("MicroMsg.DynamicPagePerformance", "exitTask onCallback");
                        g.fE("com.tencent.mm:support");
                    }
                });
            }
        }
    };
    Runnable fvk = new 3(this);

    b(c cVar) {
        this.fvh = cVar;
    }

    public final void exit() {
        com.tencent.mm.plugin.appbrand.dynamic.b.n(this.fvj);
    }

    public final void restart() {
        com.tencent.mm.plugin.appbrand.dynamic.b.n(this.fvk);
        com.tencent.mm.plugin.appbrand.dynamic.b.e(this.fvi, 2000);
    }

    public final void jj(String str) {
        Set<View> aX = this.fvh.aX(str);
        if (aX != null && !aX.isEmpty()) {
            for (View view : aX) {
                if (view != null && (view instanceof IPCDynamicPageView)) {
                    x.v("MicroMsg.DynamicPagePerformance", "pauseAllView, do pause view(%s)", new Object[]{Integer.valueOf(view.hashCode())});
                    ((IPCDynamicPageView) view).onPause();
                }
            }
        }
    }

    public final void jk(String str) {
        Set<View> aX = this.fvh.aX(str);
        if (aX != null && !aX.isEmpty()) {
            for (View view : aX) {
                if (view != null && (view instanceof IPCDynamicPageView)) {
                    x.v("MicroMsg.DynamicPagePerformance", "pauseAllView, do resume view(%s)", new Object[]{Integer.valueOf(view.hashCode())});
                    ((IPCDynamicPageView) view).onResume();
                }
            }
        }
    }
}
