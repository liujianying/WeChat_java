package com.tencent.mm.plugin.masssend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.masssend.a.f;

class MassSendMsgUI$6 implements OnCancelListener {
    final /* synthetic */ f laH;
    final /* synthetic */ MassSendMsgUI lbm;

    MassSendMsgUI$6(MassSendMsgUI massSendMsgUI, f fVar) {
        this.lbm = massSendMsgUI;
        this.laH = fVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.laH);
    }
}
