package com.tencent.mm.plugin.address.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.address.model.a;
import com.tencent.mm.plugin.address.ui.InvoiceListUI.3;
import com.tencent.mm.plugin.q.a.b;
import com.tencent.mm.ui.base.h.c;

class InvoiceListUI$3$1 implements c {
    final /* synthetic */ 3 eZi;
    final /* synthetic */ int hW;

    InvoiceListUI$3$1(3 3, int i) {
        this.eZi = 3;
        this.hW = i;
    }

    public final void ju(int i) {
        b bVar;
        synchronized (this.eZi.eZh.lockObj) {
            if (this.hW < this.eZi.eZh.eZe.size()) {
                bVar = (b) this.eZi.eZh.eZe.get(this.hW);
            } else {
                bVar = null;
            }
        }
        if (bVar != null) {
            switch (i) {
                case 0:
                    this.eZi.eZh.jt(bVar.knA);
                    return;
                case 1:
                    a aVar = new a(bVar.knA);
                    this.eZi.eZh.eYZ = null;
                    au.DF().a(aVar, 0);
                    return;
                case 2:
                    InvoiceListUI.b(this.eZi.eZh, bVar);
                    return;
                default:
                    return;
            }
        }
    }
}
