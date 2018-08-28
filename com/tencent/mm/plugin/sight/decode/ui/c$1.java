package com.tencent.mm.plugin.sight.decode.ui;

import android.util.Base64;
import com.tencent.mm.ak.o;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ c ndR;

    c$1(c cVar) {
        this.ndR = cVar;
    }

    public final void iy() {
        x.d("MicroMsg.VideoPopupHelper", g.Ab() + " onPrepared");
        c.a(this.ndR);
    }

    public final void onError(int i, int i2) {
        x.e("MicroMsg.VideoPopupHelper", "on play video error, what %d extra %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        c.b(this.ndR).stop();
        b.A(Base64.encodeToString((d.bvD() + "[SightPopupHelper] on play video error, what " + i + " extra " + i2 + ", path=" + bi.aG(c.c(this.ndR), "")).getBytes(), 2), "FullScreenPlaySight");
        String c = c.c(this.ndR);
        ah.A(new 1(this, o.Pf().a(c, com.tencent.mm.bp.a.getDensity(this.ndR.getContext()), this.ndR.getContext(), -1), c));
    }

    public final void wd() {
        x.d("MicroMsg.VideoPopupHelper", "on completion");
        c.d(this.ndR).post(new 2(this));
        c.b(this.ndR).setLoop(true);
        c.a(this.ndR);
    }

    public final int ck(int i, int i2) {
        return 0;
    }

    public final void cl(int i, int i2) {
    }
}
