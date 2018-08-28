package com.tencent.mm.plugin.soter.ui;

import com.tencent.d.a.a;
import com.tencent.d.a.a.a.b;
import com.tencent.d.a.c.i;
import com.tencent.mm.plugin.soter.ui.SoterTestUI.8;
import com.tencent.mm.sdk.platformtools.x;
import java.security.Signature;
import java.security.SignatureException;

class SoterTestUI$8$1 extends b {
    final /* synthetic */ Signature onX;
    final /* synthetic */ 8 onY;

    SoterTestUI$8$1(8 8, Signature signature) {
        this.onY = 8;
        this.onX = signature;
    }

    public final void onAuthenticationError(int i, CharSequence charSequence) {
        x.i("MicroMsg.SoterTestUI", "hy: onAuthenticationError");
    }

    public final void onAuthenticationHelp(int i, CharSequence charSequence) {
        x.i("MicroMsg.SoterTestUI", "hy: onAuthenticationHelp");
    }

    public final void bFm() {
        x.i("MicroMsg.SoterTestUI", "hy: onAuthenticationSucceeded");
        try {
            this.onX.update("challenge".getBytes());
            i bP = a.bP(this.onX.sign());
            SoterTestUI.a(this.onY.onW).setText(bP == null ? "not pass: exception occurs" : bP.toString());
        } catch (SignatureException e) {
            x.e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + e.toString());
        }
    }

    public final void onAuthenticationFailed() {
        x.i("MicroMsg.SoterTestUI", "hy: onAuthenticationFailed");
    }

    public final void aNH() {
        super.aNH();
    }
}
