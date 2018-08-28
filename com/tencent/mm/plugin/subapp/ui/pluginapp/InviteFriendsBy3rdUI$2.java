package com.tencent.mm.plugin.subapp.ui.pluginapp;

import com.tencent.mm.pluginsdk.ui.applet.q.b;

class InviteFriendsBy3rdUI$2 implements b {
    final /* synthetic */ String fhM;
    final /* synthetic */ int kyk;
    final /* synthetic */ InviteFriendsBy3rdUI otN;

    InviteFriendsBy3rdUI$2(InviteFriendsBy3rdUI inviteFriendsBy3rdUI, String str, int i) {
        this.otN = inviteFriendsBy3rdUI;
        this.fhM = str;
        this.kyk = i;
    }

    public final void gb(boolean z) {
        if (z) {
            InviteFriendsBy3rdUI.a(this.otN, this.kyk, InviteFriendsBy3rdUI.b(this.otN) == null ? this.fhM : InviteFriendsBy3rdUI.b(this.otN).getText().toString());
        }
    }
}
