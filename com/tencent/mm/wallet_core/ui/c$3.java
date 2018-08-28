package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class c$3 implements OnClickListener {
    final /* synthetic */ c uYM;

    c$3(c cVar) {
        this.uYM = cVar;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.OfflinePopupWindow", "root on click");
        if (this.uYM.eZB != null && this.uYM.eZB.isShowing()) {
            this.uYM.eZB.dismiss();
        }
    }
}
