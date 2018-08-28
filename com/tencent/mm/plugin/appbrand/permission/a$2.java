package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.page.l;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.f.a;
import com.tencent.mm.plugin.appbrand.widget.f.b;

class a$2 implements Runnable {
    final /* synthetic */ g fdu;
    final /* synthetic */ String ffJ;

    a$2(g gVar, String str) {
        this.fdu = gVar;
        this.ffJ = str;
    }

    public final void run() {
        n nVar = this.fdu.fcz;
        if (nVar != null) {
            l currentPage = nVar.getCurrentPage();
            if (currentPage != null) {
                p currentPageView = currentPage.getCurrentPageView();
                if (currentPageView != null) {
                    b bVar = currentPageView.gnD;
                    String str = this.ffJ;
                    if (bVar.gOQ.aha() != null && bVar.gOQ.mContext != null) {
                        if (bVar.gOR == null) {
                            bVar.gOR = new a(bVar.gOQ.mContext);
                            bVar.gOR.a(bVar.gOQ.aha());
                        }
                        bVar.gOQ.aha().bringChildToFront(bVar.gOR.getView());
                        bVar.gOR.wp(str);
                    }
                }
            }
        }
    }
}
