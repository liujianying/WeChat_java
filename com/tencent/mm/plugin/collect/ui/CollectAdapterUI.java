package com.tencent.mm.plugin.collect.ui;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class CollectAdapterUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ux(8);
        g.Ek();
        x.i("MicroMsg.CollectAdapterUI", "walletRegion: %s", new Object[]{Integer.valueOf(((Integer) g.Ei().DT().get(aa.a.sTs, Integer.valueOf(0))).intValue())});
        if (((Integer) g.Ei().DT().get(aa.a.sTs, Integer.valueOf(0))).intValue() == 8) {
            d.b(this, "collect", ".ui.CollectHKMainUI", getIntent());
        } else {
            d.b(this, "collect", ".ui.CollectMainUI", getIntent());
        }
        finish();
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
