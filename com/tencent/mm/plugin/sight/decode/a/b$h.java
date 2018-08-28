package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.decode.a.b.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class b$h implements Runnable {
    volatile boolean lhj;
    final /* synthetic */ b ncT;

    private b$h(b bVar) {
        this.ncT = bVar;
        this.lhj = false;
    }

    /* synthetic */ b$h(b bVar, byte b) {
        this(bVar);
    }

    public final void run() {
        if (b.c(this.ncT)) {
            x.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
            return;
        }
        b.a(this.ncT, SightVideoJNI.openFile(b.a(this.ncT), 1 == b.d(this.ncT) ? 0 : 1, 1, false));
        if (b.e(this.ncT) < 0) {
            x.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.ncT.hashCode()), Integer.valueOf(b.e(this.ncT)), b.a(this.ncT)});
            this.ncT.D(null);
            if (b.b(this.ncT) != null) {
                b.b(this.ncT).d(this.ncT, -1);
                return;
            }
            return;
        }
        if (((Boolean) g.Ei().DT().get(344065, Boolean.valueOf(false))).booleanValue()) {
            if (b.f(this.ncT) == null) {
                b.a(this.ncT, new j(this.ncT, (byte) 0));
            }
            b.g(this.ncT).removeCallbacks(b.f(this.ncT));
            b.g(this.ncT).post(b.f(this.ncT));
        }
        int max = Math.max(1, SightVideoJNI.getVideoWidth(b.e(this.ncT)));
        int max2 = Math.max(1, SightVideoJNI.getVideoHeight(b.e(this.ncT)));
        if (b.d(this.ncT) == 0) {
            if (max * max2 >= 1048576 || max <= 0 || max2 <= 0) {
                x.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", new Object[]{Integer.valueOf(max), Integer.valueOf(max2)});
                return;
            }
            b.a(this.ncT, max, max2);
        }
        this.ncT.bvJ();
        if (Float.compare(((float) max) / ((float) max2), 5.0f) > 0 || Float.compare(((float) max2) / ((float) max), 5.0f) > 0) {
            x.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", new Object[]{Integer.valueOf(max), Integer.valueOf(max2)});
            if (!bi.oW(b.a(this.ncT))) {
                b.bvM().put(b.a(this.ncT), Integer.valueOf(2));
            }
            b.a(this.ncT, 0);
            b.b(this.ncT, b.e(this.ncT));
            b.a(this.ncT, -1);
            b.a(this.ncT, "");
            b.b(this.ncT, "ERROR#PATH");
            b.a(this.ncT, null);
            this.lhj = true;
            if (b.b(this.ncT) != null) {
                b.b(this.ncT).d(this.ncT, -1);
                return;
            }
            return;
        }
        this.ncT.cl(max, max2);
        if (1 == b.d(this.ncT)) {
            b.a(this.ncT, new b$b(this.ncT, (byte) 0));
            b.a(this.ncT, null);
            if (!this.lhj) {
                o.d(b.h(this.ncT), 0);
            }
        } else {
            b.a(this.ncT, new b$b(this.ncT, (byte) 0));
            b.a(this.ncT, new b$c(this.ncT));
            b.h(this.ncT).ncY = b.i(this.ncT);
            b.i(this.ncT).ndb = b.h(this.ncT);
            if (!this.lhj) {
                o.d(b.h(this.ncT), 0);
            }
        }
        if (this.lhj) {
            x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", new Object[]{Integer.valueOf(this.ncT.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.lhj)});
        }
    }
}
