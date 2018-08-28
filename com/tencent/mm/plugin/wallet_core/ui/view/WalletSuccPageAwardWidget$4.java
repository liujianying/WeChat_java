package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.mm.ak.a.c.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WalletSuccPageAwardWidget$4 implements i {
    final /* synthetic */ WalletSuccPageAwardWidget pAM;

    WalletSuccPageAwardWidget$4(WalletSuccPageAwardWidget walletSuccPageAwardWidget) {
        this.pAM = walletSuccPageAwardWidget;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        x.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img finish, url: %s, bitmap: %s", new Object[]{str, bitmap});
        if (bitmap != null && WalletSuccPageAwardWidget.g(this.pAM) != null && !bi.oW(WalletSuccPageAwardWidget.g(this.pAM).vHq) && WalletSuccPageAwardWidget.g(this.pAM).vHq.equals(str)) {
            ah.A(new 1(this, new NinePatchDrawable(this.pAM.getResources(), new NinePatch(bitmap, WalletSuccPageAwardWidget.M(bitmap), "widget_bg"))));
        }
    }
}
