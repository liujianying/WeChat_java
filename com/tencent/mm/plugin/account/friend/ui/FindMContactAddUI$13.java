package com.tencent.mm.plugin.account.friend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.ui.MMWizardActivity;

class FindMContactAddUI$13 implements OnClickListener {
    final /* synthetic */ FindMContactAddUI eLW;

    FindMContactAddUI$13(FindMContactAddUI findMContactAddUI) {
        this.eLW = findMContactAddUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (FindMContactAddUI.k(this.eLW) == null || !FindMContactAddUI.k(this.eLW).contains("2")) {
            FindMContactAddUI.n(this.eLW);
            return;
        }
        Intent intent = new Intent(this.eLW, FindMContactInviteUI.class);
        intent.putExtra("regsetinfo_ticket", FindMContactAddUI.l(this.eLW));
        intent.putExtra("login_type", FindMContactAddUI.m(this.eLW));
        intent.putExtra("regsetinfo_NextStyle", FindMContactAddUI.e(this.eLW));
        MMWizardActivity.D(this.eLW, intent);
    }
}
