package com.tencent.mm.plugin.account.friend.ui;

import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.ui.f.1;
import com.tencent.mm.pluginsdk.ui.applet.a$a;
import com.tencent.mm.sdk.platformtools.x;

class f$1$1 implements a$a {
    final /* synthetic */ 1 eMO;

    f$1$1(1 1) {
        this.eMO = 1;
    }

    public final void a(boolean z, boolean z2, String str, String str2) {
        x.i("MicroMsg.QQFriendAdapterCaseB", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2});
        long longValue = new o(o.cx(str2)).longValue();
        ao bK = ((ap) ((a) g.n(a.class)).getQQListStg()).bK(longValue);
        if (z && bK != null) {
            bK.username = str;
        }
        if (bK != null) {
            bK.dHO = 2;
            x.d("MicroMsg.QQFriendAdapterCaseB", "f :%s", new Object[]{bK.toString()});
            ((ap) ((a) g.n(a.class)).getQQListStg()).a(longValue, bK);
            this.eMO.eMN.WT();
        } else {
            x.w("MicroMsg.QQFriendAdapterCaseB", "cpan qq friend is null. qq:%s", new Object[]{str2});
        }
        if (z && bK != null) {
            f.pC(str);
        }
    }
}
