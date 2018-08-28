package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.modelmulti.e;

class InviteFriendsBy3rdUI$8 implements OnCancelListener {
    final /* synthetic */ InviteFriendsBy3rdUI otN;
    final /* synthetic */ e otP;

    InviteFriendsBy3rdUI$8(InviteFriendsBy3rdUI inviteFriendsBy3rdUI, e eVar) {
        this.otN = inviteFriendsBy3rdUI;
        this.otP = eVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.otP);
    }
}
