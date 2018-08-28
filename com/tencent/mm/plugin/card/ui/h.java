package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;

public final class h implements a {
    private g hEY;

    public final /* synthetic */ b nE(int i) {
        return this.hEY != null ? this.hEY.nQ(i) : null;
    }

    public h(g gVar) {
        this.hEY = gVar;
    }

    public final void onCreate() {
        this.hEY.notifyDataSetChanged();
    }

    public final void onDestroy() {
        if (this.hEY != null) {
            g gVar = this.hEY;
            gVar.hzI.release();
            gVar.hzI = null;
            gVar.hzT.clear();
            gVar.mContext = null;
            gVar.hEW = null;
            this.hEY = null;
        }
    }

    public final void Ij() {
        if (this.hEY != null) {
            this.hEY.notifyDataSetChanged();
        }
    }
}
