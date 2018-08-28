package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.c.a;

class j$2 implements a {
    final /* synthetic */ r pPF;
    final /* synthetic */ j pPG;
    final /* synthetic */ c pPH;
    final /* synthetic */ Bundle pPI;

    j$2(j jVar, c cVar, Bundle bundle, r rVar) {
        this.pPG = jVar;
        this.pPH = cVar;
        this.pPI = bundle;
        this.pPF = rVar;
    }

    public final void f(boolean z, Object obj) {
        c cVar = this.pPH;
        if (cVar.tYZ != null) {
            cVar.tYZ.dismiss();
        }
        this.pPI.putString("value", z ? obj.toString() : "");
        if (this.pPF != null) {
            this.pPF.b(z, "", this.pPI);
        }
    }
}
