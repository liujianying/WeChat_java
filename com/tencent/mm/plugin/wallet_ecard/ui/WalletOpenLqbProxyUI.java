package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class WalletOpenLqbProxyUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ux(4);
        c cDK = cDK();
        if (cDK != null) {
            int i = this.sy.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.pBy, 0);
            String string = this.sy.getString(com.tencent.mm.plugin.wallet_ecard.a.a.pBE);
            x.i("MicroMsg.WalletOpenLqbProxyUI", "WalletOpenLqbProxyUI onCreate, openScene: %s, extraData: %s", new Object[]{Integer.valueOf(i), string});
            if (i == 3) {
                cDL().m(new Object[]{Integer.valueOf(i), string});
                return;
            }
            cDK.b(this, this.sy);
            finish();
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
