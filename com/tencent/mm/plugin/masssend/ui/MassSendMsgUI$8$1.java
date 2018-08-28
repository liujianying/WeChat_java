package com.tencent.mm.plugin.masssend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.8;

class MassSendMsgUI$8$1 implements OnClickListener {
    final /* synthetic */ String fYI;
    final /* synthetic */ 8 lbr;

    MassSendMsgUI$8$1(8 8, String str) {
        this.lbr = 8;
        this.fYI = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("CropImage_OutputPath", this.fYI);
        MassSendMsgUI.a(this.lbr.lbm, intent);
    }
}
