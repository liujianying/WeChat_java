package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.d.b.c.b;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.sdk.platformtools.x;

class k$1 implements b {
    final /* synthetic */ c jgR;
    final /* synthetic */ k jgS;

    k$1(k kVar, c cVar) {
        this.jgS = kVar;
        this.jgR = cVar;
    }

    public final void aNF() {
        x.i("MicroMsg.SoterAuthMgrImp", "alvinluo onStartAuthentication");
    }

    public final void onAuthenticationHelp(int i, CharSequence charSequence) {
        x.i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationHelp helpCode: %d, helpString: %s", new Object[]{Integer.valueOf(i), charSequence});
        if (this.jgR != null) {
            this.jgR.aK(2000, -1);
        }
    }

    public final void aNG() {
        k.a(this.jgS);
        x.i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationSucceed");
    }

    public final void onAuthenticationFailed() {
        x.i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationFailed");
        if (this.jgR != null) {
            this.jgR.aK(2002, -1);
        }
    }

    public final void aNH() {
        x.i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationCancelled");
        k.a(this.jgS);
    }

    public final void onAuthenticationError(int i, CharSequence charSequence) {
        x.e("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationError errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), charSequence});
        k.a(this.jgS);
    }
}
