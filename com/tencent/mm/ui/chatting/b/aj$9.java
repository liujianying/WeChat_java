package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class aj$9 implements OnClickListener {
    final /* synthetic */ aj tSJ;
    final /* synthetic */ boolean tSM;

    aj$9(aj ajVar, boolean z) {
        this.tSJ = ajVar;
        this.tSM = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.tSJ.aar(this.tSM ? "fromBanner" : "fromPluginTalk");
    }
}
