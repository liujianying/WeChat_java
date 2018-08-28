package com.tencent.mm.plugin.account.friend.ui;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.12;

class FindMContactInviteUI$12$1 implements e {
    final /* synthetic */ 12 eLZ;

    FindMContactInviteUI$12$1(12 12) {
        this.eLZ = 12;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (FindMContactInviteUI.a(this.eLZ.eLY) != null) {
            FindMContactInviteUI.a(this.eLZ.eLY).dismiss();
            FindMContactInviteUI.a(this.eLZ.eLY, null);
        }
        if (FindMContactInviteUI.k(this.eLZ.eLY) != null) {
            g.DF().b(432, FindMContactInviteUI.k(this.eLZ.eLY));
            FindMContactInviteUI.a(this.eLZ.eLY, null);
        }
        FindMContactInviteUI.l(this.eLZ.eLY);
    }
}
