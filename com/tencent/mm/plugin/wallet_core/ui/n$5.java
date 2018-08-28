package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.g.a.lg;
import com.tencent.mm.g.a.lg.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.c.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;

class n$5 implements Runnable {
    final /* synthetic */ lg pvl;
    final /* synthetic */ n pxQ;

    n$5(n nVar, lg lgVar) {
        this.pxQ = nVar;
        this.pvl = lgVar;
    }

    public final void run() {
        x.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback");
        b bVar = this.pvl.bVA;
        if (bVar == null) {
            n.a(this.pxQ, 0);
            x.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, result == null");
            return;
        }
        int i = bVar.errCode;
        x.v("MicroMsg.WalletPwdCustomDialog", "alvinluo errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), bVar.Yy});
        if (i == 0) {
            x.i("MicroMsg.WalletPwdCustomDialog", "hy: payInfo soterAuthReq: %s", new Object[]{bVar.bVE});
            n.a(this.pxQ, 1);
            n.a(this.pxQ, bVar.bVE);
            n.e(this.pxQ);
            this.pxQ.pxF.setText("");
            this.pxQ.bQv();
            h.mEJ.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2)});
            a.xP(0);
            return;
        }
        boolean z;
        x.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
        n.a(this.pxQ, 0);
        n.a(this.pxQ, "");
        this.pxQ.pxE.setVisibility(0);
        this.pxQ.pxF.setTextColor(this.pxQ.getContext().getResources().getColor(c.red));
        this.pxQ.pxF.setText(i.wallet_finger_print_fail);
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int f = currentTimeMillis - n.f(this.pxQ);
        if (f > 1) {
            n.b(this.pxQ, currentTimeMillis);
            n.g(this.pxQ);
            n.e(this.pxQ);
        }
        h.mEJ.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2)});
        boolean z2 = i == 2 || i == 10308;
        if (bVar.bVF == 2) {
            z = true;
        } else {
            z = false;
        }
        x.v("MicroMsg.WalletPwdCustomDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[]{Boolean.valueOf(z2), Integer.valueOf(n.h(this.pxQ)), Integer.valueOf(i), Boolean.valueOf(z)});
        if ((z || (n.h(this.pxQ) < 3 && f > 1)) && !z2) {
            x.v("MicroMsg.WalletPwdCustomDialog", "alvinluo fingerprint pay");
            if (n.i(this.pxQ) == null) {
                n.a(this.pxQ, com.tencent.mm.ui.c.a.gz(this.pxQ.getContext()));
            }
            this.pxQ.pxG.setVisibility(8);
            this.pxQ.pxF.setVisibility(4);
            n.i(this.pxQ).reset();
            n.i(this.pxQ).setAnimationListener(new 1(this));
            this.pxQ.pxF.startAnimation(n.i(this.pxQ));
            a.xP(1);
        } else if (n.h(this.pxQ) >= 3 || z2) {
            x.v("MicroMsg.WalletPwdCustomDialog", "alvinluo change to pwd pay");
            n.bQx();
            this.pxQ.pxH = 0;
            n.j(this.pxQ);
            this.pxQ.pxD.setVisibility(8);
            this.pxQ.pxE.setVisibility(8);
            this.pxQ.pxF.setVisibility(0);
            this.pxQ.pxF.setText(i.wallet_finger_print_not_recorded);
            this.pxQ.pxF.setTextColor(this.pxQ.getContext().getResources().getColor(c.wallet_pwd_bank_card_text_color));
            this.pxQ.pxj.setText(i.wallet_pwd_dialog_titile);
            this.pxQ.pxo.setVisibility(0);
            if (!this.pxQ.kMk.isShown()) {
                this.pxQ.kMk.setVisibility(0);
            }
            a.xP(2);
            n.bQy();
        }
    }
}
