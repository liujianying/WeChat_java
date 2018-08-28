package com.tencent.mm.plugin.collect.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.collect.ui.CollectMainUI.15;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class CollectMainUI$15$1 implements OnClickListener {
    final /* synthetic */ 15 hYT;

    CollectMainUI$15$1(15 15) {
        this.hYT = 15;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.CollectMainUI", "save code from click");
        if (this.hYT.hYN.hYH != null) {
            CollectMainUI.cn(this.hYT.hYN.hYH.username, this.hYT.hYN.hYH.rWY);
            h.mEJ.h(15387, new Object[]{Integer.valueOf(2)});
        }
    }
}
