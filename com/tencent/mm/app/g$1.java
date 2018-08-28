package com.tencent.mm.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Looper;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.blink.c.AnonymousClass1;
import com.tencent.mm.by.k;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.j;
import com.tencent.mm.kiss.a.a;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.kiss.a.b.1;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.y;

class g$1 implements Runnable {
    final /* synthetic */ g bys;
    final /* synthetic */ g byt;

    g$1(g gVar, g gVar2) {
        this.byt = gVar;
        this.bys = gVar2;
    }

    public final void run() {
        try {
            k a = g.a(this.byt);
            synchronized (a.dol) {
                a.dol[0] = (byte) -1;
                j.i("MicroMsg.WxWaitingLock", "markUse %s", new Object[]{a});
            }
            g.a(this.byt).done();
            Context contextWrapper = new ContextWrapper(this.bys.dsQ);
            b EY = b.EY();
            Looper looper = a.EX().dtc.getLooper();
            LayoutInflater gq = y.gq(contextWrapper);
            if (!EY.dti) {
                EY.dti = true;
                EY.Bc = gq;
                EY.dtg = looper;
                EY.mMode = 2;
                EY.dth = new 1(EY, EY.dtg);
                if (d.fS(26)) {
                    EY.dtk = new b.b(looper);
                }
            }
            com.tencent.mm.blink.a.xc();
            Context baseContext = ((h) com.tencent.mm.kernel.g.Ef().DM()).dsQ.getBaseContext();
            boolean a2 = b.EY().a("R.layout.actionbar_title_launcher", 1, R.i.actionbar_title_launcher, new LinearLayout(baseContext), new int[0]);
            b.EY().a("R.layout.main_tab", 1, R.i.main_tab, new int[0]);
            if (com.tencent.mm.bp.a.fi(baseContext)) {
                b.EY().a("R.layout.mm_bottom_tabitem_large", 4, R.i.mm_bottom_tabitem_large, new LinearLayout(baseContext), new int[0]);
            } else {
                b.EY().a("R.layout.mm_bottom_tabitem", 4, R.i.mm_bottom_tabitem, new LinearLayout(baseContext), new int[0]);
            }
            b.EY().a("R.layout.mm_activity", 4, R.i.mm_activity, new int[0]);
            if (!(Build.BRAND.equals("vivo") && d.fS(20))) {
                b.EY().a("R.layout.main", 1, R.i.main, new int[0]);
                b.EY().a("R.layout.address", 1, R.i.address, new int[0]);
                b.EY().a("R.layout.mm_preference_fragment_list_content", 2, R.i.mm_preference_fragment_list_content, new int[0]);
            }
            b.EY().a("R.layout.actionview_with_dot_tips", 1, R.i.actionview_with_dot_tips, new int[0]);
            if (com.tencent.mm.bp.a.fi(baseContext)) {
                b.EY().a("R.layout.conversation_item_with_cache_large", 8, R.i.conversation_item_with_cache_large, null);
            } else if (com.tencent.mm.bp.a.fj(baseContext)) {
                b.EY().a("R.layout.conversation_item_with_cache_small", 8, R.i.conversation_item_with_cache_small, null);
            } else {
                b.EY().a("R.layout.conversation_item_with_cache", 8, R.i.conversation_item_with_cache, null);
            }
            if (a2) {
                b EY2 = b.EY();
                EY2.dth.post(new AnonymousClass1());
            }
            g.a(this.byt).done();
        } catch (Throwable e) {
            try {
                x.printErrStackTrace("MicroMsg.DefaultBootStep", e, "", new Object[0]);
                com.tencent.mm.blink.a.j(10, 1);
                x.i("MicroMsg.DefaultBootStep", "found a crash, %s %s %s", new Object[]{ad.getResources(), this.bys.dsQ.getResources(), this.bys.dsQ.getResources().getAssets()});
                g.a(this.byt, this.bys);
                g.b(this.byt);
            } finally {
                g.a(this.byt).done();
            }
        }
    }
}
