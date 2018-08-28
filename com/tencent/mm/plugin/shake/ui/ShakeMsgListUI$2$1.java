package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.ui.ShakeMsgListUI.2;

class ShakeMsgListUI$2$1 implements OnClickListener {
    final /* synthetic */ 2 mZQ;

    ShakeMsgListUI$2$1(2 2) {
        this.mZQ = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g a = ShakeMsgListUI.a(this.mZQ.mZP);
        a.diF.delete(a.getTableName(), null, null);
        ShakeMsgListUI.b(this.mZQ.mZP).WT();
        ShakeMsgListUI.c(this.mZQ.mZP);
    }
}
