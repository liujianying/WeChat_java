package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.ui.at.f;

class at$f$2 implements OnClickListener {
    final /* synthetic */ f oav;

    at$f$2(f fVar) {
        this.oav = fVar;
    }

    public final void onClick(View view) {
        if (view.getTag() != null) {
            this.oav.oau = (at$f$a) view.getTag();
            this.oav.dE(this.oav.oau.nkZ, this.oav.oau.position + 1);
        }
    }
}
