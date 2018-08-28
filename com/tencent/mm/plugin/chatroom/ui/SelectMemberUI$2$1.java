package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.plugin.chatroom.ui.SelectMemberUI.2;
import com.tencent.mm.plugin.chatroom.ui.SelectMemberUI.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class SelectMemberUI$2$1 implements a {
    final /* synthetic */ 2 hPx;

    SelectMemberUI$2$1(2 2) {
        this.hPx = 2;
    }

    public final boolean vD() {
        x.d("MicroMsg.SelectMemberUI", "searchEvent onTimerExpired");
        b b = SelectMemberUI.b(this.hPx.hPv);
        String obj = SelectMemberUI.c(this.hPx.hPv).getText().toString();
        x.i("MicroMsg.SelectMemberAdapter", "search:%s isLoading:%s", new Object[]{bi.Xf(obj), Boolean.valueOf(b.acT)});
        if (!b.acT) {
            b.dBm = obj;
            b.yt(obj);
            ah.A(new b.2(b));
        }
        return false;
    }
}
