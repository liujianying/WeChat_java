package com.tencent.mm.plugin.sport;

import android.app.Activity;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sport.b.a;
import com.tencent.mm.plugin.sport.b.b;
import com.tencent.mm.plugin.sport.b.c;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.plugin.sport.c.i;
import com.tencent.mm.plugin.sport.c.n;
import com.tencent.mm.plugin.sport.c.n.1;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.s;

class c$1 implements Runnable {
    final /* synthetic */ String dhF;
    final /* synthetic */ Activity mr;
    final /* synthetic */ c ooG;

    c$1(c cVar, Activity activity, String str) {
        this.ooG = cVar;
        this.mr = activity;
        this.dhF = str;
    }

    public final void run() {
        Activity activity = this.mr;
        String str = this.dhF;
        if ((n.opq == null || !n.opq.isShowing()) && i.L(5, 1) != 0 && q.GF().equals(str) && !((b) g.l(b.class)).ei(ad.getContext())) {
            n.opq = s.a(activity, a.tipsbar_red_bg_color, c.tipsbar_icon_warning, ad.getContext().getString(d.sport_device_not_support), b.b.tipsbar_icon_close_dark_selector, new 1());
        }
    }
}
