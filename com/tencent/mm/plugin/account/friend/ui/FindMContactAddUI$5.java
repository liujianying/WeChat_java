package com.tencent.mm.plugin.account.friend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class FindMContactAddUI$5 implements OnClickListener {
    final /* synthetic */ FindMContactAddUI eLW;

    FindMContactAddUI$5(FindMContactAddUI findMContactAddUI) {
        this.eLW = findMContactAddUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        FindMContactAddUI.q(this.eLW);
        this.eLW.finish();
    }
}
