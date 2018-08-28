package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.ui.widget.picker.a.a;
import java.text.SimpleDateFormat;
import java.util.Date;

class j$3 implements a {
    final /* synthetic */ r pPF;
    final /* synthetic */ j pPG;
    final /* synthetic */ Bundle pPI;
    final /* synthetic */ com.tencent.mm.ui.widget.picker.a pPJ;
    final /* synthetic */ SimpleDateFormat pPK;

    j$3(j jVar, com.tencent.mm.ui.widget.picker.a aVar, SimpleDateFormat simpleDateFormat, Bundle bundle, r rVar) {
        this.pPG = jVar;
        this.pPJ = aVar;
        this.pPK = simpleDateFormat;
        this.pPI = bundle;
        this.pPF = rVar;
    }

    public final void a(boolean z, int i, int i2, int i3) {
        this.pPJ.hide();
        String format = this.pPK.format(new Date(i - 1900, i2 - 1, i3));
        Bundle bundle = this.pPI;
        String str = "value";
        if (!z) {
            format = "";
        }
        bundle.putString(str, format);
        if (this.pPF != null) {
            this.pPF.b(z, "", this.pPI);
        }
    }
}
