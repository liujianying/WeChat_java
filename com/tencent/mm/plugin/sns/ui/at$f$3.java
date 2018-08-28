package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.ui.at.f;
import com.tencent.mm.plugin.sns.ui.at.f.a;

class at$f$3 implements OnClickListener {
    final /* synthetic */ f oav;

    at$f$3(f fVar) {
        this.oav = fVar;
    }

    public final void onClick(View view) {
        if (view.getTag() != null) {
            this.oav.oau = (a) view.getTag();
            this.oav.dE(this.oav.oau.nkZ, this.oav.oau.position + 2);
        }
    }
}
