package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import com.tencent.mm.ak.a.c.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WalletSuccPageAwardWidget$7 implements i {
    final /* synthetic */ WalletSuccPageAwardWidget pAM;

    WalletSuccPageAwardWidget$7(WalletSuccPageAwardWidget walletSuccPageAwardWidget) {
        this.pAM = walletSuccPageAwardWidget;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        x.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img_whole finish, url: %s, bitmap: %s", new Object[]{str, bitmap});
        if (bitmap != null && WalletSuccPageAwardWidget.i(this.pAM) != null && !bi.oW(WalletSuccPageAwardWidget.i(this.pAM).vHd) && WalletSuccPageAwardWidget.i(this.pAM).vHd.equals(str)) {
            ah.A(new 1(this, bitmap));
        }
    }
}
