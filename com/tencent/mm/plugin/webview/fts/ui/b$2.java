package com.tencent.mm.plugin.webview.fts.ui;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.webview.fts.ui.b.a;
import com.tencent.mm.sdk.platformtools.bd;

class b$2 extends bd<Boolean> {
    final /* synthetic */ int fKG;
    final /* synthetic */ b pQL;

    public b$2(b bVar, Boolean bool, int i) {
        this.pQL = bVar;
        this.fKG = i;
        super(1000, bool, (byte) 0);
    }

    protected final /* synthetic */ Object run() {
        boolean z;
        b bVar = this.pQL;
        int i = this.fKG;
        a Aj = bVar.Aj(i);
        if (Aj != null) {
            bVar.lB(i);
            bVar.a(Aj);
            ViewGroup ls = bVar.ls(Aj.gpc);
            if (ls != null) {
                bVar.goM.remove(Aj);
                ls.removeView((View) Aj.gpb.get());
                z = true;
                return Boolean.valueOf(z);
            }
        }
        z = false;
        return Boolean.valueOf(z);
    }
}
