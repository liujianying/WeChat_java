package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;

public final class h implements a {
    private g hzU;

    public h(g gVar) {
        this.hzU = gVar;
    }

    public final void onCreate() {
        this.hzU.notifyDataSetChanged();
    }

    public final void onDestroy() {
        if (this.hzU != null) {
            g gVar = this.hzU;
            gVar.hzI.release();
            gVar.hzI = null;
            gVar.hzT.clear();
            gVar.mContext = null;
            this.hzU = null;
        }
    }

    public final void Ij() {
        if (this.hzU != null) {
            this.hzU.notifyDataSetChanged();
        }
    }

    public final b nE(int i) {
        if (this.hzU != null) {
            return this.hzU.getItem(i);
        }
        return null;
    }
}
