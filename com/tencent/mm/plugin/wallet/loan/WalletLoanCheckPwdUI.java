package com.tencent.mm.plugin.wallet.loan;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.c.s;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.ui.base.a;

@a(3)
public class WalletLoanCheckPwdUI extends WalletCheckPwdUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (cDK() != null) {
            setBackBtn(new 1(this));
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof s) || (i == 0 && i2 == 0)) {
            return super.d(i, i2, str, lVar);
        }
        return false;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
