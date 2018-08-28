package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.x;

class GoogleFriendUI$3 implements a {
    final /* synthetic */ GoogleFriendUI eIi;

    GoogleFriendUI$3(GoogleFriendUI googleFriendUI) {
        this.eIi = googleFriendUI;
    }

    public final void a(boolean z, boolean z2, String str, String str2) {
        x.d("MicroMsg.GoogleContact.GoogleFriendUI", "MicroMsg.AddContact ok:%b hasSentVerify:%b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (z || z2) {
            x.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[]{str2});
            ((o) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aa(str2, 1);
        } else {
            ((o) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).aa(str2, 2);
        }
        GoogleFriendUI.a(this.eIi).WT();
    }
}
