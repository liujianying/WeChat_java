package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements OnClickListener {
    final /* synthetic */ b mZh;

    b$1(b bVar) {
        this.mZh = bVar;
    }

    public final void onClick(View view) {
        x.v("MicroMsg.SayHiAdapter", "on delView clicked");
        this.mZh.hkQ.aYm();
        if (this.mZh.lCE != null) {
            this.mZh.lCE.bv(view.getTag());
        }
    }
}
