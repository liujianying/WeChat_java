package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;

class i$1 implements OnClickListener {
    final /* synthetic */ i qMU;

    i$1(i iVar) {
        this.qMU = iVar;
    }

    public final void onClick(View view) {
        if (!(this.qMU.qMT == null || this.qMU.qMP == null)) {
            this.qMU.qMT.TO(this.qMU.qMP.qMN);
        }
        this.qMU.qMQ.dismiss();
    }
}
