package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.c;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j.2;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j.3;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j.4;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;

class g$23 implements Runnable {
    final /* synthetic */ double dSw;
    final /* synthetic */ double dSx;
    final /* synthetic */ g qiK;
    final /* synthetic */ int qjd;
    final /* synthetic */ String qje;
    final /* synthetic */ int qjf;

    g$23(g gVar, int i, double d, double d2, String str, int i2) {
        this.qiK = gVar;
        this.qjd = i;
        this.dSw = d;
        this.dSx = d2;
        this.qje = str;
        this.qjf = i2;
    }

    public final void run() {
        byte b = (byte) 0;
        if (!(g.j(this.qiK) == null || !(g.j(this.qiK) instanceof Activity) || ((Activity) g.j(this.qiK)).isFinishing())) {
            j F = g.F(this.qiK);
            Context j = g.j(this.qiK);
            int i = this.qjd;
            double d = this.dSw;
            double d2 = this.dSx;
            String str = this.qje;
            int i2 = this.qjf;
            AnonymousClass1 anonymousClass1 = new d() {
                public final void Bf(int i) {
                    aW(i, "cancel");
                }

                public final void pT(int i) {
                    aW(i, "fail");
                }

                public final void uX(int i) {
                    aW(i, "ok");
                }

                private void aW(int i, String str) {
                    c a = g.a(g$23.this.qiK, i);
                    if (a != null && a.qhP != null && a.pRY != null) {
                        g.a(g$23.this.qiK, g.D(g$23.this.qiK), g.k(g$23.this.qiK), "openMapNavigateMenu:" + bi.aG(str, "fail"));
                    }
                }

                public final void Bg(int i) {
                    g.c(g$23.this.qiK, i);
                }
            };
            if (!(j == null || !(j instanceof MMActivity) || ((MMActivity) j).isFinishing())) {
                F.pSW = i2;
                F.qkm = true;
                F.qkn = i;
                F.qkp = new e(d, d2, (byte) 0);
                F.qkq = str;
                F.YC = new WeakReference(j);
                F.qkr = anonymousClass1;
                F.dMm = null;
                if (F.dMm == null) {
                    F.bYu();
                } else {
                    F.qku = new 2(F);
                    if (F.kHU != null) {
                        F.qkt = new 3(F);
                        F.kHU.a(F.qkp.latitude, F.qkp.longitude, F.qkt);
                    }
                    ah.A(new 4(F));
                    F.dMm.b(F.qku);
                    ah.i(F.qkv, 4000);
                }
                b = (byte) 1;
            }
        }
        if (b == (byte) 0) {
            c a = g.a(this.qiK, this.qjf);
            if (a.pRY != null && a.qhP != null) {
                g.a(this.qiK, a.pRY, a.qhP, "openMapNavigateMenu:fail");
            }
        }
    }
}
