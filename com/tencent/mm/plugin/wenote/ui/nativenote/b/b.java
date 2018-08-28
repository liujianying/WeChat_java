package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class b extends h {
    public b(View view, k kVar) {
        super(view, kVar);
        this.qvq.setVisibility(8);
        this.bOA.setVisibility(8);
        this.eRj.setVisibility(8);
        this.qvq.setOnClickListener(null);
    }

    public final void a(com.tencent.mm.plugin.wenote.model.a.b bVar, int i, int i2) {
        super.a(bVar, i, i2);
        if (bVar.getType() == -2 && this.qtF.qrC == 3) {
            this.qvy.setVisibility(0);
        }
    }

    public final int caZ() {
        return -2;
    }
}
