package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;

class j$4 implements a {
    final /* synthetic */ b gQT;
    final /* synthetic */ r pPF;
    final /* synthetic */ j pPG;
    final /* synthetic */ Bundle pPI;

    j$4(j jVar, b bVar, Bundle bundle, r rVar) {
        this.pPG = jVar;
        this.gQT = bVar;
        this.pPI = bundle;
        this.pPF = rVar;
    }

    public final void h(boolean z, Object obj) {
        this.gQT.hide();
        this.pPI.putString("value", z ? this.gQT.cAP() : "-1");
        if (this.pPF != null) {
            this.pPF.b(z, "", this.pPI);
        }
    }
}
