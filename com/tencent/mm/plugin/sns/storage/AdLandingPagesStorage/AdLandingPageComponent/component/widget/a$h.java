package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$h implements Runnable {
    volatile boolean lhj;
    final /* synthetic */ a nGD;

    private a$h(a aVar) {
        this.nGD = aVar;
        this.lhj = false;
    }

    /* synthetic */ a$h(a aVar, byte b) {
        this(aVar);
    }

    public final void run() {
        if (a.c(this.nGD)) {
            x.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
            return;
        }
        a.a(this.nGD, SightVideoJNI.openFile(a.a(this.nGD), 1 == a.d(this.nGD) ? 0 : 1, 1, false));
        if (a.e(this.nGD) < 0) {
            x.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.nGD.hashCode()), Integer.valueOf(a.e(this.nGD)), a.a(this.nGD)});
            this.nGD.bAm();
            if (a.b(this.nGD) != null) {
                a.b(this.nGD).wS(-1);
                return;
            }
            return;
        }
        if (((Boolean) AdLandingPagesProxy.getInstance().getCfg(344065, Boolean.valueOf(false))).booleanValue()) {
            if (a.f(this.nGD) == null) {
                a.a(this.nGD, new j(this.nGD, (byte) 0));
            }
            a.g(this.nGD).removeCallbacks(a.f(this.nGD));
            a.g(this.nGD).post(a.f(this.nGD));
        }
        int max = Math.max(1, SightVideoJNI.getVideoWidth(a.e(this.nGD)));
        int max2 = Math.max(1, SightVideoJNI.getVideoHeight(a.e(this.nGD)));
        if (a.d(this.nGD) == 0) {
            if (max * max2 >= 1048576 || max <= 0 || max2 <= 0) {
                x.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", new Object[]{Integer.valueOf(max), Integer.valueOf(max2)});
                return;
            }
            a.a(this.nGD, max, max2);
        }
        this.nGD.bvJ();
        if (Float.compare(((float) max) / ((float) max2), 5.0f) > 0 || Float.compare(((float) max2) / ((float) max), 5.0f) > 0) {
            x.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", new Object[]{Integer.valueOf(max), Integer.valueOf(max2)});
            if (!bi.oW(a.a(this.nGD))) {
                a.bvM().put(a.a(this.nGD), Integer.valueOf(2));
            }
            a.a(this.nGD, 0);
            a.b(this.nGD, a.e(this.nGD));
            a.a(this.nGD, -1);
            a.a(this.nGD, "");
            a.b(this.nGD, "ERROR#PATH");
            a.a(this.nGD, null);
            this.lhj = true;
            if (a.b(this.nGD) != null) {
                a.b(this.nGD).wS(-1);
                return;
            }
            return;
        }
        this.nGD.cl(max, max2);
        if (1 == a.d(this.nGD)) {
            a.a(this.nGD, new b(this.nGD, (byte) 0));
            a.a(this.nGD, null);
            if (!this.lhj) {
                o.d(a.h(this.nGD), 0);
            }
        } else {
            a.a(this.nGD, new b(this.nGD, (byte) 0));
            a.a(this.nGD, new a$c(this.nGD));
            a.h(this.nGD).nGE = a.i(this.nGD);
            a.i(this.nGD).nGG = a.h(this.nGD);
            if (!this.lhj) {
                o.d(a.h(this.nGD), 0);
            }
        }
        if (this.lhj) {
            x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", new Object[]{Integer.valueOf(this.nGD.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.lhj)});
        }
    }
}
