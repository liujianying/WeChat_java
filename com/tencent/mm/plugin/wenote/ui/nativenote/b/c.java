package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class c extends h {
    public c(View view, k kVar) {
        super(view, kVar);
        this.qvq.setVisibility(0);
        this.bOA.setVisibility(8);
        this.eRj.setVisibility(8);
        this.qvq.setTag(this);
        this.qvq.setOnClickListener(this.jXR);
    }

    public final void a(b bVar, int i, int i2) {
        this.qvt.setImageResource(com.tencent.mm.plugin.fav.ui.c.Bx(((com.tencent.mm.plugin.wenote.model.a.c) bVar).qoT));
        this.qvr.setText(((com.tencent.mm.plugin.wenote.model.a.c) bVar).title);
        this.qvs.setText(((com.tencent.mm.plugin.wenote.model.a.c) bVar).content);
        super.a(bVar, i, i2);
    }

    public final int caZ() {
        return 5;
    }
}
