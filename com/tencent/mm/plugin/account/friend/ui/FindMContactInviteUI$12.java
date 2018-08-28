package com.tencent.mm.plugin.account.friend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.ActionBarActivity;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.ui.base.h;

class FindMContactInviteUI$12 implements OnClickListener {
    final /* synthetic */ FindMContactInviteUI eLY;

    FindMContactInviteUI$12(FindMContactInviteUI findMContactInviteUI) {
        this.eLY = findMContactInviteUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        StringBuilder stringBuilder;
        if (FindMContactInviteUI.j(this.eLY) == 1) {
            stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(a.DA()).append(",").append(getClass().getName()).append(",R300_500_QQ,");
            g.Eg();
            com.tencent.mm.plugin.c.a.pV(stringBuilder.append(a.gd("R300_500_QQ")).append(",3").toString());
        } else {
            stringBuilder = new StringBuilder();
            g.Eg();
            stringBuilder = stringBuilder.append(a.DA()).append(",").append(getClass().getName()).append(",R300_500_phone,");
            g.Eg();
            com.tencent.mm.plugin.c.a.pV(stringBuilder.append(a.gd("R300_500_phone")).append(",3").toString());
        }
        g.DF().a(432, FindMContactInviteUI.a(this.eLY, new 1(this)));
        FindMContactInviteUI findMContactInviteUI = this.eLY;
        ActionBarActivity actionBarActivity = this.eLY.mController.tml;
        this.eLY.getString(j.app_tip);
        FindMContactInviteUI.a(findMContactInviteUI, h.a(actionBarActivity, this.eLY.getString(j.find_mcontact_invite_friend_processing), true, new 2(this)));
        FindMContactInviteUI.b(this.eLY).pu(FindMContactInviteUI.m(this.eLY));
    }
}
