package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.p;
import com.tencent.mm.ui.base.h;

class g$1 implements OnLongClickListener {
    final /* synthetic */ g hHB;

    g$1(g gVar) {
        this.hHB = gVar;
    }

    public final boolean onLongClick(View view) {
        if (view.getId() == d.code_text) {
            p.R(this.hHB.gKS, this.hHB.htQ.awn().code);
            h.bA(this.hHB.gKS, this.hHB.getString(g.app_copy_ok));
        }
        return false;
    }
}
