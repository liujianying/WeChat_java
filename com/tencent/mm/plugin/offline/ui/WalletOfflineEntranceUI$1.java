package com.tencent.mm.plugin.offline.ui;

import android.content.Intent;
import com.tencent.mm.g.a.gg;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletOfflineEntranceUI$1 extends c<gg> {
    final /* synthetic */ WalletOfflineEntranceUI lMF;

    WalletOfflineEntranceUI$1(WalletOfflineEntranceUI walletOfflineEntranceUI) {
        this.lMF = walletOfflineEntranceUI;
        this.sFo = gg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.WalletOfflineEntranceUI", "rcv fuck event: %s", new Object[]{((gg) bVar).bPt.bPu});
        Intent intent = new Intent();
        intent.putExtra("key_callback", r6.bPt.bPu);
        this.lMF.setResult(-1, intent);
        this.lMF.finish();
        return false;
    }
}
