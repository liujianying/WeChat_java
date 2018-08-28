package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.a.o;
import com.tencent.mm.plugin.card.a$g;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.p;
import com.tencent.mm.ui.base.h;

class h$1 implements OnLongClickListener {
    final /* synthetic */ b hHD;
    final /* synthetic */ h hHE;

    h$1(h hVar, b bVar) {
        this.hHE = hVar;
        this.hHD = bVar;
    }

    public final boolean onLongClick(View view) {
        if (view.getId() == d.code_text) {
            p.R(this.hHE.gKS, this.hHD.awn().code);
            h.bA(this.hHE.gKS, o.getString(a$g.app_copy_ok));
        }
        return false;
    }
}
