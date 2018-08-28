package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.g.a.lg;
import com.tencent.mm.g.a.lg.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.c.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.u;

class o$5 implements Runnable {
    final /* synthetic */ lg pvl;
    final /* synthetic */ o pxX;

    o$5(o oVar, lg lgVar) {
        this.pxX = oVar;
        this.pvl = lgVar;
    }

    public final void run() {
        x.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback");
        b bVar = this.pvl.bVA;
        if (bVar == null) {
            this.pxX.mpb.pxN = 0;
            x.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, result == null");
            return;
        }
        int i = bVar.errCode;
        x.v("MicroMsg.WalletPwdDialog", "alvinluo errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), bVar.Yy});
        int i2;
        String str;
        PayInfo payInfo;
        if (i == 0) {
            x.i("MicroMsg.WalletPwdDialog", "hy: payInfo soterAuthReq: %s", new Object[]{bVar.bVE});
            if (this.pxX.mpb == null) {
                i2 = 0;
            } else {
                i2 = this.pxX.mpb.bVY;
            }
            if (this.pxX.mpb == null) {
                str = "";
            } else {
                str = this.pxX.mpb.bOd;
            }
            u.d(i2, str, 22, "");
            this.pxX.mpb.pxN = 1;
            this.pxX.mpb.bQb = bVar.bQb;
            this.pxX.mpb.bQc = bVar.bQc;
            this.pxX.mpb.bVE = bVar.bVE;
            this.pxX.mpb.bPZ = bVar.bPZ;
            payInfo = this.pxX.mpb;
            payInfo.pxO++;
            this.pxX.pxF.setText("");
            this.pxX.bQv();
            h.mEJ.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2)});
            a.xP(0);
            return;
        }
        boolean z;
        x.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
        if (this.pxX.mpb == null) {
            i2 = 0;
        } else {
            i2 = this.pxX.mpb.bVY;
        }
        if (this.pxX.mpb == null) {
            str = "";
        } else {
            str = this.pxX.mpb.bOd;
        }
        u.d(i2, str, 23, "");
        this.pxX.mpb.pxN = 0;
        this.pxX.pxE.setVisibility(0);
        this.pxX.pxF.setTextColor(this.pxX.getContext().getResources().getColor(c.red));
        this.pxX.pxF.setText(i.wallet_finger_print_fail);
        i2 = (int) (System.currentTimeMillis() / 1000);
        int e = i2 - o.e(this.pxX);
        if (e > 1) {
            o.a(this.pxX, i2);
            o.f(this.pxX);
            payInfo = this.pxX.mpb;
            payInfo.pxO++;
        }
        h.mEJ.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2)});
        boolean z2 = i == 2 || i == 10308;
        if (bVar.bVF == 2) {
            z = true;
        } else {
            z = false;
        }
        x.v("MicroMsg.WalletPwdDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[]{Boolean.valueOf(z2), Integer.valueOf(o.g(this.pxX)), Integer.valueOf(i), Boolean.valueOf(z)});
        if ((z || (o.g(this.pxX) < 3 && e > 1)) && !z2) {
            x.v("MicroMsg.WalletPwdDialog", "alvinluo fingerprint pay");
            if (o.h(this.pxX) == null) {
                o.a(this.pxX, com.tencent.mm.ui.c.a.gz(this.pxX.getContext()));
            }
            this.pxX.pxG.setVisibility(8);
            this.pxX.pxF.setVisibility(4);
            o.h(this.pxX).reset();
            o.h(this.pxX).setAnimationListener(new 1(this));
            this.pxX.pxF.startAnimation(o.h(this.pxX));
            a.xP(1);
        } else if (o.g(this.pxX) >= 3 || z2) {
            x.v("MicroMsg.WalletPwdDialog", "alvinluo change to pwd pay");
            o.bQB();
            this.pxX.pxH = 0;
            o.i(this.pxX);
            this.pxX.pxD.setVisibility(8);
            this.pxX.pxE.setVisibility(8);
            this.pxX.pxF.setVisibility(0);
            this.pxX.pxF.setText(i.wallet_finger_print_not_recorded);
            this.pxX.pxF.setTextColor(this.pxX.getContext().getResources().getColor(c.wallet_pwd_bank_card_text_color));
            this.pxX.pxj.setText(i.wallet_pwd_dialog_titile);
            this.pxX.pxo.setVisibility(0);
            if (!this.pxX.kMk.isShown()) {
                this.pxX.kMk.setVisibility(0);
            }
            a.xP(2);
            o.jC(true);
        }
    }
}
