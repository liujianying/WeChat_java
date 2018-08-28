package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_payu.bind.model.c;
import com.tencent.mm.plugin.wallet_payu.bind.model.d;
import com.tencent.mm.ui.base.a;

@a(3)
public class WalletPayUBankcardManageUI extends WalletBankcardManageUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void jk(boolean z) {
        if (z) {
            a(new com.tencent.mm.plugin.wallet_core.c.b.a(), false, false);
        } else {
            a(new com.tencent.mm.plugin.wallet_core.c.b.a(), true, false);
        }
    }

    protected final void bNj() {
        com.tencent.mm.wallet_core.a.a(this, c.class, null);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof com.tencent.mm.plugin.wallet_core.c.b.a)) {
            return false;
        }
        bNk();
        return true;
    }

    protected final com.tencent.mm.plugin.wallet.bind.ui.a bNi() {
        return new a(this, this.pcZ);
    }

    protected final void c(Bankcard bankcard) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_bankcard", bankcard);
        com.tencent.mm.wallet_core.a.a(this, d.class, bundle);
    }
}
