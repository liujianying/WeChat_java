package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.p;
import com.tencent.mm.ui.base.h;

class a$2 implements OnLongClickListener {
    final /* synthetic */ a hyY;

    a$2(a aVar) {
        this.hyY = aVar;
    }

    public final boolean onLongClick(View view) {
        if (view.getId() == d.code_text) {
            p.R(this.hyY.gKS, this.hyY.htQ.awn().code);
            h.bA(this.hyY.gKS, this.hyY.gKS.getString(g.app_copy_ok));
        }
        return false;
    }
}
