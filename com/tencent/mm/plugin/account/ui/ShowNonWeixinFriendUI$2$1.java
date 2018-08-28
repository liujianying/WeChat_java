package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.ui.ShowNonWeixinFriendUI.2;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.f.a.b;
import com.tencent.mm.ui.f.a.c.a;
import com.tencent.mm.ui.f.a.d;

class ShowNonWeixinFriendUI$2$1 implements a {
    final /* synthetic */ 2 eXl;

    ShowNonWeixinFriendUI$2$1(2 2) {
        this.eXl = 2;
    }

    public final void a(d dVar) {
        x.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
    }

    public final void a(b bVar) {
        x.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
    }

    public final void m(Bundle bundle) {
        x.i("MicroMsg.ShowNonWeixinFriendUI", "fbinvite oncomplete");
        h.a(this.eXl.eXk.mController.tml, j.facebook_inviteqqfriends_invite_success, j.app_tip, new 1(this));
    }

    public final void onCancel() {
        x.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite cancle");
    }
}
