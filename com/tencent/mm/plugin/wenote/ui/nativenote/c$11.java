package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.b;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;

class c$11 implements OnClickListener {
    final /* synthetic */ a quY;
    final /* synthetic */ c quZ;

    c$11(c cVar, a aVar) {
        this.quZ = cVar;
        this.quY = aVar;
    }

    public final void onClick(View view) {
        boolean z;
        boolean z2 = true;
        h.mEJ.h(14547, new Object[]{Integer.valueOf(7)});
        b bVar = u.qtv;
        if (this.quZ.quU) {
            z = false;
        } else {
            z = true;
        }
        c.c(bVar, Boolean.valueOf(z));
        c cVar = this.quZ;
        if (this.quZ.quU) {
            z2 = false;
        }
        cVar.quU = z2;
        c.a(this.quZ, view, this.quZ.quU);
        c.b(this.quY);
    }
}
