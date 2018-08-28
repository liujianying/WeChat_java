package com.tencent.mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.protocal.c.biw;
import com.tencent.mm.protocal.c.bix;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements i {
    private static String pKH = "websearch_";
    private static String pKI;
    private static String pKJ;
    private Runnable pKF;
    private Runnable pKG;

    private static SharedPreferences bSE() {
        init();
        x.i("WebSearchPrivacyMgr", " sp name %s ", new Object[]{pKH});
        return an.m(ad.getContext(), pKH, 0);
    }

    public static void init() {
        if (pKI == null) {
            bSF();
        }
    }

    public static void bSF() {
        x.i("WebSearchPrivacyMgr", "reInit");
        StringBuilder stringBuilder = new StringBuilder("websearch_");
        g.Eg();
        pKH = stringBuilder.append(a.Dg()).toString();
        String obj = g.Ei().DT().get(274436, "").toString();
        pKI = ad.getContext().getString(a.a.open_confirm_url, new Object[]{w.chP(), obj});
        pKJ = ad.getContext().getString(a.a.close_confirm_url, new Object[]{w.chP(), obj});
    }

    public final void bSG() {
        x.i("WebSearchPrivacyMgr", "openSearch ");
        init();
        if (this.pKF != null) {
            this.pKF.run();
            if (this.pKF == this.pKF) {
                this.pKF = null;
            }
        }
        bSE().edit().putBoolean("websearch_confirmed", true).commit();
        biw biw = new biw();
        biw.sji = 1;
        biw.rxy = (int) (System.currentTimeMillis() / 1000);
        biw.jRb = 1;
        b.a aVar = new b.a();
        aVar.dIG = biw;
        aVar.dIH = new bix();
        aVar.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
        aVar.dIF = 2957;
        v.a(aVar.KT(), new 1(this));
    }

    public final void bSH() {
        x.i("WebSearchPrivacyMgr", "closeSearch ");
        init();
        if (this.pKG != null) {
            this.pKG.run();
            if (this.pKG == this.pKG) {
                this.pKG = null;
            }
        }
        bSE().edit().putBoolean("websearch_confirmed", false).commit();
        biw biw = new biw();
        biw.sji = 1;
        biw.rxy = (int) (System.currentTimeMillis() / 1000);
        biw.jRb = 2;
        b.a aVar = new b.a();
        aVar.dIG = biw;
        aVar.dIH = new bix();
        aVar.uri = "/cgi-bin/mmsearch-bin/searchconfirm";
        aVar.dIF = 2957;
        v.a(aVar.KT(), new v.a() {
            public final int a(int i, int i2, String str, b bVar, l lVar) {
                return 0;
            }
        });
        ((n) g.n(n.class)).deleteSOSHistory();
        if (com.tencent.mm.plugin.websearch.api.x.pLP != null) {
            com.tencent.mm.plugin.websearch.api.x.pLP = null;
        }
        ad.getContext().getSharedPreferences("fts_recent_biz_sp", 0).edit().remove(com.tencent.mm.plugin.websearch.api.x.bSY()).commit();
    }

    public final void a(Context context, Runnable runnable) {
        init();
        if (bSE().getBoolean("websearch_confirmed", false) || !com.tencent.mm.al.b.ml((String) g.Ei().DT().get(274436, null))) {
            runnable.run();
            return;
        }
        this.pKF = runnable;
        aU(context, pKI);
    }

    public final boolean b(Context context, Runnable runnable) {
        init();
        if (com.tencent.mm.al.b.ml((String) g.Ei().DT().get(274436, null))) {
            this.pKG = runnable;
            aU(context, pKJ);
            return true;
        }
        runnable.run();
        return false;
    }

    private static void aU(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("showShare", true);
        intent.putExtra("rawUrl", str);
        d.b(context, "webview", ".ui.tools.WebViewUI", intent);
    }
}
