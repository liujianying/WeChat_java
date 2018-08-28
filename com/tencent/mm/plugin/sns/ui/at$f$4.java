package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.ui.at.f;
import com.tencent.mm.plugin.sns.ui.at.f.a;
import com.tencent.mm.sdk.platformtools.x;

class at$f$4 implements OnClickListener {
    final /* synthetic */ f oav;

    at$f$4(f fVar) {
        this.oav = fVar;
    }

    public final void onClick(View view) {
        if (view.getTag() != null) {
            x.d("MicroMsg.SnsphotoAdapter", "sign click");
            this.oav.oau = (a) view.getTag();
            this.oav.dF(this.oav.oau.nkZ, this.oav.oau.position + 2);
        }
    }
}
