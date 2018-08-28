package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.appusage.l.b;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class a$14 implements a {
    final /* synthetic */ a gyS;

    a$14(a aVar) {
        this.gyS = aVar;
    }

    public final void a(String str, l lVar) {
        try {
            if (lVar.obj != null && (lVar.obj instanceof Long)) {
                ArrayList bN;
                long j = a.h(this.gyS).get();
                x.d("MicroMsg.AppBrandLauncherRecentsList", "onPagingDataBack ticket %d, mInitFetchTicket %d, mPagingFetchTicket %d", new Object[]{(Long) lVar.obj, Long.valueOf(j), Long.valueOf(a.i(this.gyS).get())});
                if (lVar.obj.equals(Long.valueOf(j))) {
                    bN = e.abg().fmt.bN(Long.MAX_VALUE);
                } else {
                    bN = e.abg().fmt.bN(a.j(this.gyS).get());
                }
                if (!bi.cX(bN)) {
                    a.j(this.gyS).set(((k) bN.get(bN.size() - 1)).dlj);
                }
                bN = a.k(this.gyS).k(bN);
                if (lVar.obj.equals(Long.valueOf(j))) {
                    this.gyS.runOnUiThread(new 1(this, a.l(this.gyS) ? e.abh().jM(b.fml) : null, bN));
                } else if (lVar.obj.equals(Long.valueOf(r4))) {
                    this.gyS.runOnUiThread(new 2(this, bN));
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandLauncherRecentsList", "onPagingDataBack e %s", new Object[]{e});
        }
    }
}
