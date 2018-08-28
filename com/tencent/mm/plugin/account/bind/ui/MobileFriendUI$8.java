package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MobileFriendUI$8 implements OnClickListener {
    final /* synthetic */ MobileFriendUI eIS;

    MobileFriendUI$8(MobileFriendUI mobileFriendUI) {
        this.eIS = mobileFriendUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.eIS.finish();
    }
}
