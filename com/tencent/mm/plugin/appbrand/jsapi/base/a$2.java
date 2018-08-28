package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.sdk.platformtools.ah;

class a$2 implements e {
    final /* synthetic */ b fIk;
    final /* synthetic */ p fJO;
    final /* synthetic */ a fKF;
    final /* synthetic */ int fKG;

    a$2(a aVar, p pVar, int i, b bVar) {
        this.fKF = aVar;
        this.fJO = pVar;
        this.fKG = i;
        this.fIk = bVar;
    }

    public final void onDestroy() {
        this.fJO.b(this);
        ah.A(new Runnable() {
            public final void run() {
                a$2.this.fJO.agU().lt(a$2.this.fKG);
            }
        });
        this.fJO.agU().ly(this.fKG);
        this.fIk.recycle();
        System.gc();
    }
}
