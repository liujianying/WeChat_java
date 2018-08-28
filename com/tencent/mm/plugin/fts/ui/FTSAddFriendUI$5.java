package com.tencent.mm.plugin.fts.ui;

import com.tencent.mm.ab.e;

class FTSAddFriendUI$5 implements e {
    final /* synthetic */ FTSAddFriendUI jwa;

    FTSAddFriendUI$5(FTSAddFriendUI fTSAddFriendUI) {
        this.jwa = fTSAddFriendUI;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r7, int r8, java.lang.String r9, com.tencent.mm.ab.l r10) {
        /*
        r6 = this;
        r5 = 0;
        r4 = 1;
        r0 = com.tencent.mm.kernel.g.DF();
        r1 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        r0.b(r1, r6);
        r0 = r6.jwa;
        com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.d(r0);
        if (r7 != 0) goto L_0x0014;
    L_0x0012:
        if (r8 == 0) goto L_0x0066;
    L_0x0014:
        switch(r8) {
            case -24: goto L_0x0048;
            case -4: goto L_0x0033;
            default: goto L_0x0017;
        };
    L_0x0017:
        r0 = r6.jwa;
        r0 = com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.e(r0);
        r1 = com.tencent.mm.plugin.fts.ui.n$g.no_contact_result;
        r0.setText(r1);
    L_0x0022:
        r0 = r6.jwa;
        r1 = -1;
        com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.a(r0, r1);
        r0 = r6.jwa;
        com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.b(r0, r4);
    L_0x002d:
        r0 = r6.jwa;
        com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.h(r0);
    L_0x0032:
        return;
    L_0x0033:
        r0 = 4;
        if (r7 == r0) goto L_0x0017;
    L_0x0036:
        r0 = r6.jwa;
        r0 = com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.e(r0);
        r1 = r6.jwa;
        r2 = com.tencent.mm.plugin.fts.ui.n$g.search_contact_err_no_code;
        r1 = r1.getString(r2);
        r0.setText(r1);
        goto L_0x0022;
    L_0x0048:
        r0 = com.tencent.mm.h.a.eV(r9);
        if (r0 == 0) goto L_0x005a;
    L_0x004e:
        r1 = r6.jwa;
        r1 = com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.e(r1);
        r0 = r0.desc;
        r1.setText(r0);
        goto L_0x0022;
    L_0x005a:
        r0 = r6.jwa;
        r0 = com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.e(r0);
        r1 = com.tencent.mm.plugin.fts.ui.n$g.no_contact_result;
        r0.setText(r1);
        goto L_0x0022;
    L_0x0066:
        r0 = r6.jwa;
        r10 = (com.tencent.mm.plugin.messenger.a.f) r10;
        r1 = r10.bcS();
        com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.a(r0, r1);
        r0 = r6.jwa;
        r0 = com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.f(r0);
        r0 = r0.rHb;
        if (r0 <= 0) goto L_0x00f8;
    L_0x007b:
        r0 = r6.jwa;
        r0 = com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.f(r0);
        r0 = r0.rHc;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x0092;
    L_0x0089:
        r0 = r6.jwa;
        r1 = com.tencent.mm.plugin.fts.ui.n$g.search_contact_not_found;
        r2 = 0;
        com.tencent.mm.ui.base.h.a(r0, r1, r5, r4, r2);
        goto L_0x0032;
    L_0x0092:
        r2 = new android.content.Intent;
        r2.<init>();
        r0 = "add_more_friend_search_scene";
        r1 = 3;
        r2.putExtra(r0, r1);
        r0 = r6.jwa;
        r0 = com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.f(r0);
        r0 = r0.rHc;
        r0 = r0.size();
        if (r0 <= r4) goto L_0x00db;
    L_0x00ac:
        r0 = "result";
        r1 = r6.jwa;	 Catch:{ IOException -> 0x00cd }
        r1 = com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.f(r1);	 Catch:{ IOException -> 0x00cd }
        r1 = r1.toByteArray();	 Catch:{ IOException -> 0x00cd }
        r2.putExtra(r0, r1);	 Catch:{ IOException -> 0x00cd }
        r0 = r6.jwa;	 Catch:{ IOException -> 0x00cd }
        r0 = r0.mController;	 Catch:{ IOException -> 0x00cd }
        r0 = r0.tml;	 Catch:{ IOException -> 0x00cd }
        r1 = "subapp";
        r3 = ".ui.pluginapp.ContactSearchResultUI";
        com.tencent.mm.bg.d.b(r0, r1, r3, r2);	 Catch:{ IOException -> 0x00cd }
        goto L_0x0032;
    L_0x00cd:
        r0 = move-exception;
        r1 = "MicroMsg.FTS.FTSAddFriendUI";
        r2 = "";
        r3 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);
        goto L_0x0032;
    L_0x00db:
        r0 = com.tencent.mm.api.h.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r0 = (com.tencent.mm.api.h) r0;
        r1 = r6.jwa;
        r1 = com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.f(r1);
        r1 = r1.rHc;
        r1 = r1.getFirst();
        r1 = (com.tencent.mm.protocal.c.biy) r1;
        r3 = r6.jwa;
        r3 = r3.jvZ;
        r0.a(r2, r1, r3);
    L_0x00f8:
        r0 = r6.jwa;
        com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.a(r0, r4);
        r0 = r6.jwa;
        com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.g(r0);
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.ui.FTSAddFriendUI$5.a(int, int, java.lang.String, com.tencent.mm.ab.l):void");
    }
}
