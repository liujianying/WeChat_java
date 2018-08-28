package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;

class c$12 implements OnClickListener {
    final /* synthetic */ a quY;
    final /* synthetic */ c quZ;

    c$12(c cVar, a aVar) {
        this.quZ = cVar;
        this.quY = aVar;
    }

    public final void onClick(View view) {
        boolean z = true;
        h.mEJ.h(14547, new Object[]{Integer.valueOf(8)});
        this.quZ.quR.setPressed(false);
        this.quZ.quP.setPressed(false);
        if (this.quZ.quW || this.quZ.quX) {
            this.quZ.quV = false;
        }
        c.c(u.qtx, Boolean.valueOf(!this.quZ.quV));
        c cVar = this.quZ;
        if (this.quZ.quV) {
            z = false;
        }
        cVar.quV = z;
        c.a(this.quZ, view, this.quZ.quV);
        c.b(this.quY);
        this.quZ.quW = false;
        this.quZ.quX = false;
    }
}
