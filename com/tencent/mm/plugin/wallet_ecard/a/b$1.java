package com.tencent.mm.plugin.wallet_ecard.a;

import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wallet_ecard.a.b.a;
import com.tencent.mm.protocal.c.bbc;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$1 implements OnClickListener {
    final /* synthetic */ bbc pBU;
    final /* synthetic */ WalletBaseUI pBV;
    final /* synthetic */ a pBW = null;

    b$1(bbc bbc, WalletBaseUI walletBaseUI) {
        this.pBU = bbc;
        this.pBV = walletBaseUI;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.content.DialogInterface r9, int r10) {
        /*
        r8 = this;
        r7 = 1;
        r6 = 0;
        r0 = r8.pBU;
        r0 = r0.rvK;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x0065;
    L_0x000c:
        r0 = r8.pBV;
        r1 = r8.pBU;
        r1 = r1.rvK;
        r2 = r8.pBW;
        r3 = "MicroMsg.ECardUtil";
        r4 = "url: %s";
        r5 = new java.lang.Object[r7];
        r5[r6] = r1;
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
        r3 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r3 != 0) goto L_0x0065;
    L_0x0027:
        r3 = "native.";
        r3 = r1.startsWith(r3);
        if (r3 == 0) goto L_0x0069;
    L_0x0030:
        r0 = "MicroMsg.ECardUtil";
        r3 = "goto native";
        com.tencent.mm.sdk.platformtools.x.i(r0, r3);
        if (r2 == 0) goto L_0x0041;
    L_0x003b:
        r0 = r2.bQY();
        if (r0 != 0) goto L_0x0065;
    L_0x0041:
        r0 = "native.qryacctdesc";
        r0 = r1.equals(r0);
        if (r0 != 0) goto L_0x0065;
    L_0x004a:
        r0 = "native.openecardauth";
        r0 = r1.equals(r0);
        if (r0 != 0) goto L_0x0065;
    L_0x0053:
        r0 = "native.cancloseecard";
        r0 = r1.equals(r0);
        if (r0 != 0) goto L_0x0065;
    L_0x005c:
        r0 = "native.withdraw";
        r0 = r1.equals(r0);
        if (r0 == 0) goto L_0x0065;
    L_0x0065:
        r9.dismiss();
        return;
    L_0x0069:
        r2 = "MicroMsg.ECardUtil";
        r3 = "url: %s";
        r4 = new java.lang.Object[r7];
        r4[r6] = r1;
        com.tencent.mm.sdk.platformtools.x.d(r2, r3, r4);
        r2 = new android.content.Intent;
        r2.<init>();
        r3 = "rawUrl";
        r2.putExtra(r3, r1);
        r1 = "showShare";
        r2.putExtra(r1, r6);
        r1 = "webview";
        r3 = ".ui.tools.WebViewUI";
        com.tencent.mm.bg.d.b(r0, r1, r3, r2);
        goto L_0x0065;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet_ecard.a.b$1.onClick(android.content.DialogInterface, int):void");
    }
}
