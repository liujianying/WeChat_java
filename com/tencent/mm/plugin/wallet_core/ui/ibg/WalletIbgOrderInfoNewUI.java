package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.j;

public class WalletIbgOrderInfoNewUI extends WalletOrderInfoNewUI {
    private Orders pfb;

    public void onCreate(Bundle bundle) {
        this.pfb = WalletIbgOrderInfoUI.pfb;
        super.onCreate(bundle);
    }

    protected final Orders bQo() {
        return this.pfb;
    }

    public final void done() {
        x.i("MicroMsg.WalletIbgOrderInfoNewUI", "hy: result is not set manly. set to OK");
        for (String str : this.pvK) {
            if (!bi.oW(str)) {
                x.d("MicroMsg.WalletIbgOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", new Object[]{str});
                g.Ek();
                g.Eh().dpP.a(new j(str), 0);
            }
        }
        setResult(-1);
        finish();
    }

    protected final void bQb() {
    }
}
