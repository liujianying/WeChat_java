package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.ui.base.h.d;
import java.util.ArrayList;

class GoogleFriendUI$4 implements d {
    final /* synthetic */ GoogleFriendUI eIi;
    final /* synthetic */ ArrayList eIj;
    final /* synthetic */ n eIk;

    GoogleFriendUI$4(GoogleFriendUI googleFriendUI, ArrayList arrayList, n nVar) {
        this.eIi = googleFriendUI;
        this.eIj = arrayList;
        this.eIk = nVar;
    }

    public final void bx(int i, int i2) {
        if (i2 != -1) {
            GoogleFriendUI.a(this.eIi, (n) this.eIj.get(i2), this.eIk);
        }
    }
}
