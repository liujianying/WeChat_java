package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appusage.c;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.appusage.l.b;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.protocal.c.ako;
import java.util.ArrayList;

class a$7 implements Runnable {
    final /* synthetic */ a gyS;

    a$7(a aVar) {
        this.gyS = aVar;
    }

    public final void run() {
        String str;
        ArrayList arrayList = null;
        int i = 0;
        ArrayList k = a.k(this.gyS).k(e.abg().fmt.bN(Long.MAX_VALUE));
        a.p(this.gyS);
        int i2 = this.gyS.fdx;
        String str2 = this.gyS.guK;
        if (k == null || k.size() <= 0) {
            str = null;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int i3 = 0;
            for (int i4 = 0; i4 < k.size(); i4++) {
                Object obj = k.get(i4);
                if (obj instanceof k) {
                    i3++;
                    stringBuilder.append(((k) obj).appId);
                    if (i3 == 20 || i3 >= k.size()) {
                        break;
                    }
                    stringBuilder.append(":#:");
                }
            }
            str = stringBuilder.toString();
        }
        String str3 = "";
        ako acT = i.acT();
        if (acT != null) {
            i = acT.gTo;
            str3 = acT.rNg;
        }
        a.a(i2, "", str, i, str3, str2);
        if (a.l(this.gyS)) {
            arrayList = e.abh().jM(b.fml);
        }
        this.gyS.runOnUiThread(new 1(this, arrayList, k));
        c.acK().a(a.h(this.gyS).get(), true, a.q(this.gyS));
        a.r(this.gyS).set(true);
    }
}
