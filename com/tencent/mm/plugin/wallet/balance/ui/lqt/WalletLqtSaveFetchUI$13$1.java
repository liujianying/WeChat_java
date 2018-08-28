package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mm.platformtools.y.a;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.13;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.l;

class WalletLqtSaveFetchUI$13$1 implements a {
    final /* synthetic */ String lMv;
    final /* synthetic */ l lMw;
    final /* synthetic */ 13 pcl;

    WalletLqtSaveFetchUI$13$1(13 13, String str, l lVar) {
        this.pcl = 13;
        this.lMv = str;
        this.lMw = lVar;
    }

    public final void m(final String str, final Bitmap bitmap) {
        ah.A(new Runnable() {
            public final void run() {
                x.i("MicroMsg.WalletLqtSaveFetchUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[]{str, WalletLqtSaveFetchUI$13$1.this.lMv});
                if (WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI$13$1.this.pcl.pcc).containsKey(str)) {
                    int intValue = ((Integer) WalletLqtSaveFetchUI.f(WalletLqtSaveFetchUI$13$1.this.pcl.pcc).get(str)).intValue();
                    if (WalletLqtSaveFetchUI$13$1.this.lMw.getItem(intValue) != null) {
                        WalletLqtSaveFetchUI$13$1.this.lMw.getItem(intValue).setIcon(new BitmapDrawable(c.a(bitmap, WalletLqtSaveFetchUI$13$1.this.pcl.pcc.getResources().getDimensionPixelOffset(d.wallet_offline_bank_logo_width), WalletLqtSaveFetchUI$13$1.this.pcl.pcc.getResources().getDimensionPixelOffset(d.wallet_offline_bank_logo_width), true, false)));
                        WalletLqtSaveFetchUI$13$1.this.pcl.eRB.cAK();
                    }
                }
            }
        });
    }
}
