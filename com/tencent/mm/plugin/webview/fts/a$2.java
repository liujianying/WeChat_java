package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.d;
import java.util.List;

class a$2 implements c {
    final /* synthetic */ d eRB;
    final /* synthetic */ List iYC;
    final /* synthetic */ a pNN;

    public a$2(a aVar, List list, d dVar) {
        this.pNN = aVar;
        this.iYC = list;
        this.eRB = dVar;
    }

    public final void a(l lVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iYC.size()) {
                aa aaVar = (aa) this.iYC.get(i2);
                lVar.a(i2, aaVar.title, aaVar.desc);
                if (aaVar.eQK) {
                    this.eRB.uKk = i2;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
