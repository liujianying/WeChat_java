package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.27;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.a;
import com.tencent.mm.plugin.wallet_core.ui.j.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.u;

class WalletPayUI$27$1 implements b {
    final /* synthetic */ 27 pgX;

    WalletPayUI$27$1(27 27) {
        this.pgX = 27;
    }

    public final void a(FavorPayInfo favorPayInfo) {
        int i = 1;
        this.pgX.pgT.pfz = favorPayInfo;
        String str = "MicroMsg.WalletPayUI";
        String str2 = "WalletFavorDialog onSelectionDone %s";
        Object[] objArr = new Object[1];
        objArr[0] = favorPayInfo == null ? "" : favorPayInfo.toString();
        x.i(str, str2, objArr);
        if (this.pgX.pgT.pfz != null) {
            int i2;
            boolean z;
            if (this.pgX.pgT.mCn == null) {
                i2 = 0;
            } else {
                i2 = this.pgX.pgT.mCn.bVY;
            }
            if (this.pgX.pgT.mCn == null) {
                str = "";
            } else {
                str = this.pgX.pgT.mCn.bOd;
            }
            u.d(i2, str, 15, this.pgX.pgT.pfz.pnP);
            if (this.pgX.pgT.oZH == null || a.a(this.pgX.pgT.pfz, this.pgX.pgT.oZH)) {
                this.pgX.pgT.pgy.setVisibility(8);
                this.pgX.pgT.mAE.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        x.i("MicroMsg.WalletPayUI", "mDefaultBankcard null or needToPayWithBankcard after favor selection! payWithNewBankcard");
                        WalletPayUI$27$1.this.pgX.pgT.b(false, 0, "");
                    }
                });
                z = true;
            } else {
                h Pn = this.pgX.pgT.pgk.Pn(this.pgX.pgT.pfz.pnP);
                if (Pn != null && this.pgX.pgT.oZH.bOs()) {
                    p.bNp();
                    Bankcard bankcard = p.bNq().paw;
                    double d = Pn.pdX;
                    if (bankcard != null && bankcard.plV < d) {
                        x.i("MicroMsg.WalletPayUI", "balance not meet");
                        this.pgX.pgT.pgy.setVisibility(8);
                        this.pgX.pgT.mAE.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                x.i("MicroMsg.WalletPayUI", "Balance amount not meet, after favor selection! payWithNewBankcard");
                                WalletPayUI$27$1.this.pgX.pgT.b(false, 0, "");
                            }
                        });
                        z = true;
                    }
                }
                z = false;
            }
            x.i("MicroMsg.WalletPayUI", "needBindBankCard %s", new Object[]{Boolean.valueOf(z)});
            WalletPayUI.c(this.pgX.pgT).setVisibility(0);
            WalletPayUI.d(this.pgX.pgT).setVisibility(0);
            if (this.pgX.pgT.pfz != null) {
                this.pgX.pgT.pgk = com.tencent.mm.plugin.wallet_core.ui.b.psB.a(this.pgX.pgT.mCZ);
                h Pn2 = this.pgX.pgT.pgk.Pn(this.pgX.pgT.pfz.pnP);
                if (Pn2 != null && Pn2.pdX == 0.0d) {
                    WalletPayUI.c(this.pgX.pgT).setVisibility(8);
                    WalletPayUI.d(this.pgX.pgT).setVisibility(8);
                    z = false;
                    if (!z) {
                        this.pgX.pgT.pgx.setVisibility(8);
                        this.pgX.pgT.pgy.setVisibility(0);
                        this.pgX.pgT.mAE.setOnClickListener(new 3(this));
                    }
                    if (i != 0) {
                        this.pgX.pgT.pgy.setVisibility(8);
                    }
                    this.pgX.pgT.bNN();
                }
            }
            i = 0;
            if (z) {
                this.pgX.pgT.pgx.setVisibility(8);
                this.pgX.pgT.pgy.setVisibility(0);
                this.pgX.pgT.mAE.setOnClickListener(new 3(this));
            }
            if (i != 0) {
                this.pgX.pgT.pgy.setVisibility(8);
            }
            this.pgX.pgT.bNN();
        }
    }
}
