package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;

class c$10 implements OnClickListener {
    final /* synthetic */ a quY;
    final /* synthetic */ c quZ;

    c$10(c cVar, a aVar) {
        this.quZ = cVar;
        this.quY = aVar;
    }

    public final void onClick(View view) {
        boolean z = true;
        h.mEJ.h(14547, new Object[]{Integer.valueOf(11)});
        this.quZ.quO.setPressed(false);
        this.quZ.quP.setPressed(false);
        if (this.quZ.quW || this.quZ.quV) {
            this.quZ.quX = false;
        }
        c.c(u.qtw, Boolean.valueOf(!this.quZ.quX));
        c cVar = this.quZ;
        if (this.quZ.quX) {
            z = false;
        }
        cVar.quX = z;
        c.a(this.quZ, view, this.quZ.quX);
        c.b(this.quY);
        this.quZ.quW = false;
        this.quZ.quV = false;
    }
}
