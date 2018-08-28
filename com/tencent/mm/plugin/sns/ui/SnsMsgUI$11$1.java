package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.ui.SnsMsgUI.11;

class SnsMsgUI$11$1 implements OnClickListener {
    final /* synthetic */ 11 nYo;

    SnsMsgUI$11$1(11 11) {
        this.nYo = 11;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        SnsMsgUI.c(this.nYo.nYl).setVisibility(8);
        SnsMsgUI.d(this.nYo.nYl).setVisibility(0);
        af.byt().dCZ.fV("SnsComment", "delete from SnsComment");
        this.nYo.nYl.enableOptionMenu(false);
    }
}
