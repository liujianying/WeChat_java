package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.modelmulti.h;

class InviteFriendsBy3rdUI$9 implements OnCancelListener {
    final /* synthetic */ h kyl;
    final /* synthetic */ InviteFriendsBy3rdUI otN;

    InviteFriendsBy3rdUI$9(InviteFriendsBy3rdUI inviteFriendsBy3rdUI, h hVar) {
        this.otN = inviteFriendsBy3rdUI;
        this.kyl = hVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.kyl);
    }
}
