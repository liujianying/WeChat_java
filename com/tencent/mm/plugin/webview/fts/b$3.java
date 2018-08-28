package com.tencent.mm.plugin.webview.fts;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.fts.b.a.a;
import com.tencent.mm.plugin.webview.fts.b.a.a.1;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

class b$3 implements f {
    final /* synthetic */ String bAj;
    final /* synthetic */ String fwt;
    final /* synthetic */ b pOa;
    final /* synthetic */ ThreeDotsLoadingView pOf;
    final /* synthetic */ ImageView pOg;
    final /* synthetic */ String pOh;
    final /* synthetic */ long pOi;

    b$3(b bVar, String str, ThreeDotsLoadingView threeDotsLoadingView, ImageView imageView, String str2, String str3, long j) {
        this.pOa = bVar;
        this.fwt = str;
        this.pOf = threeDotsLoadingView;
        this.pOg = imageView;
        this.pOh = str2;
        this.bAj = str3;
        this.pOi = j;
    }

    public final void q(View view, int i) {
        x.i("FTSSearchWidgetMgr", "onWidgetStateChanged sessionId %s, state %d", this.fwt, Integer.valueOf(i));
        s.i("FTSSearchWidgetMgr", "onWidgetStateChanged sessionId %s, state %d", new Object[]{this.fwt, Integer.valueOf(i)});
        b.a(this.pOa, i);
        switch (i) {
            case 0:
                h.mEJ.a(867, 1, 1, false);
                this.pOf.setVisibility(0);
                this.pOg.setVisibility(4);
                b.a(this.pOa).cI(this.pOh, 1);
                return;
            case 1:
                h.mEJ.a(867, 3, 1, false);
                this.pOf.cAH();
                this.pOf.setVisibility(4);
                b.a(this.pOa).cI(this.pOh, 3);
                b.bTF();
                s.z(this.bAj, false);
                return;
            case 4:
                h.mEJ.a(867, 2, 1, false);
                this.pOf.setVisibility(4);
                this.pOg.setVisibility(4);
                this.pOf.cAH();
                b.bTF();
                s.z(this.bAj, true);
                b.a(this.pOa).cI(this.pOh, 2);
                a bTN = a.bTN();
                String str = this.bAj;
                if (bTN.pPL.containsKey(str)) {
                    ah.i(new 1(bTN, str, view), 3000);
                }
                s.i("FTSSearchWidgetMgr", "widget display timecost %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - this.pOi)});
                return;
            default:
                h.mEJ.a(867, 4, 1, false);
                b.bTF();
                s.z(this.bAj, false);
                this.pOf.cAH();
                this.pOf.setVisibility(4);
                if (i == 2) {
                    b.a(this.pOa).cI(this.pOh, 4);
                    return;
                } else {
                    b.a(this.pOa).cI(this.pOh, 3);
                    return;
                }
        }
    }
}
