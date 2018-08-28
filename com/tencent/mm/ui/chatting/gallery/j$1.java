package com.tencent.mm.ui.chatting.gallery;

import android.util.Base64;
import android.view.View;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;

class j$1 implements a {
    final /* synthetic */ j tXq;

    j$1(j jVar) {
        this.tXq = jVar;
    }

    public final void iy() {
    }

    public final void onError(int i, int i2) {
        this.tXq.tWS.stop();
        String str = (String) ((View) this.tXq.tWS).getTag();
        b.A(Base64.encodeToString((d.bvD() + "[ImageGallery] on play sight error, what=" + i + ", extra=" + i2 + ", path=" + bi.aG(str, "")).getBytes(), 2), "FullScreenPlaySight");
        ah.A(new 1(this, str));
        this.tXq.tWQ.put(str, Boolean.valueOf(true));
    }

    public final void wd() {
        this.tXq.tWS.start();
        this.tXq.tWW.post(new 2(this));
    }

    public final int ck(int i, int i2) {
        return 0;
    }

    public final void cl(int i, int i2) {
    }
}
