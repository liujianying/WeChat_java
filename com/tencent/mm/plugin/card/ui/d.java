package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;

public final class d implements a {
    private c hBt;

    public final /* synthetic */ b nE(int i) {
        return this.hBt != null ? (CardInfo) this.hBt.getItem(i) : null;
    }

    public d(c cVar) {
        this.hBt = cVar;
    }

    public final void onCreate() {
        if (this.hBt != null) {
            am.axi().c(this.hBt);
        }
    }

    public final void onDestroy() {
        if (this.hBt != null) {
            am.axi().d(this.hBt);
            this.hBt.release();
            this.hBt = null;
        }
    }

    public final void Ij() {
        if (this.hBt != null) {
            this.hBt.a(null, null);
        }
    }
}
