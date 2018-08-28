package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.d.a.c.i;
import com.tencent.mm.sdk.platformtools.x;
import java.security.Signature;

public enum s {
    ;
    
    public String jgX;
    public boolean jgY;
    private Signature pqS;
    public i pqT;

    private s(String str) {
        this.jgX = null;
        this.jgY = false;
        this.pqS = null;
        this.pqT = null;
    }

    public final void reset() {
        x.i("MicroMsg.WalletFingerprintVerifyManager", "hy: start reset");
        this.pqS = null;
        this.jgX = null;
        this.jgY = false;
    }
}
