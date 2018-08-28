package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appusage.l.b;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import java.util.List;

class AppBrandStarListUI$a$1 implements a {
    final /* synthetic */ AppBrandStarListUI.a gvU;

    AppBrandStarListUI$a$1(AppBrandStarListUI.a aVar) {
        this.gvU = aVar;
    }

    public final void a(String str, l lVar) {
        if (2 == lVar.fBN || 3 == lVar.fBN) {
            List jM = e.abh().jM(b.fmk);
            if (this.gvU.getActivity() != null) {
                this.gvU.getActivity().runOnUiThread(new 1(this, jM));
            }
        }
    }
}
