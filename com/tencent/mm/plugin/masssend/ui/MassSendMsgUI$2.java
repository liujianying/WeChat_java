package com.tencent.mm.plugin.masssend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class MassSendMsgUI$2 implements OnClickListener {
    final /* synthetic */ Intent heh;
    final /* synthetic */ MassSendMsgUI lbm;

    MassSendMsgUI$2(MassSendMsgUI massSendMsgUI, Intent intent) {
        this.lbm = massSendMsgUI;
        this.heh = intent;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        MassSendMsgUI.b(this.lbm, this.heh);
    }
}
