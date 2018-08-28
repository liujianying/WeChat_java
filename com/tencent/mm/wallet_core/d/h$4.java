package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.tenpay.model.j;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class h$4 implements OnClickListener {
    final /* synthetic */ l bFp;
    final /* synthetic */ WalletBaseUI peV;

    h$4(l lVar, WalletBaseUI walletBaseUI) {
        this.bFp = lVar;
        this.peV = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String str = "";
        if (this.bFp instanceof j) {
            str = ((j) this.bFp).phl;
        }
        if (bi.oW(str)) {
            com.tencent.mm.g.b.a.j jVar = new com.tencent.mm.g.b.a.j();
            jVar.cip = 1;
            jVar.ciq = 1;
            jVar.RD();
            if (q.GS()) {
                a.b(this.peV, "PayUForgotPwdProcess", null);
            } else {
                a.b(this.peV, "ForgotPwdProcess", null);
            }
            if (this.peV.bbR()) {
                this.peV.finish();
                return;
            }
            return;
        }
        com.tencent.mm.g.b.a.j jVar2 = new com.tencent.mm.g.b.a.j();
        jVar2.cip = 1;
        jVar2.ciq = 2;
        jVar2.RD();
        x.i("MicroMsg.WalletErrMgr", "jump to forget_url %s", new Object[]{str});
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        d.b(this.peV, "webview", ".ui.tools.WebViewUI", intent);
    }
}
