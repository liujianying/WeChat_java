package com.tencent.mm.plugin.masssend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelvideo.c;

class MassSendMsgUI$14 implements OnCancelListener {
    final /* synthetic */ MassSendMsgUI lbm;
    final /* synthetic */ c lbn;

    MassSendMsgUI$14(MassSendMsgUI massSendMsgUI, c cVar) {
        this.lbm = massSendMsgUI;
        this.lbn = cVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.lbn.elt = null;
    }
}
