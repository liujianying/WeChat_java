package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.a.d;

class j$1 implements OnClickListener {
    final /* synthetic */ j hGo;

    j$1(j jVar) {
        this.hGo = jVar;
    }

    public final void onClick(View view) {
        if (view.getId() == d.popupwd_qrcode_iv || view.getId() == d.popupwd_barcode_iv) {
            if (this.hGo.eZB != null && this.hGo.eZB.isShowing()) {
                this.hGo.eZB.dismiss();
            }
            if (!this.hGo.htQ.avV()) {
                this.hGo.ayT();
            }
        }
    }
}
