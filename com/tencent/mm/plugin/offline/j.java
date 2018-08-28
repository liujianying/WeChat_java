package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.wallet_core.c;

public class j extends c {
    public final c a(Activity activity, Bundle bundle) {
        String str;
        String str2 = "";
        if (bundle != null) {
            if (bi.oW(bundle.getString("key_trans_id"))) {
                Orders orders = (Orders) bundle.getParcelable("key_orders");
                if (!(orders == null || orders.ppf == null || orders.ppf.size() <= 0)) {
                    str = ((Commodity) orders.ppf.get(0)).bOe;
                }
            } else {
                str = "key_trans_id";
            }
            g.Ek();
            g.Eh().dpP.a(new com.tencent.mm.plugin.offline.a.g("offlineshowpage", "push", str), 0);
            c(activity, WalletOrderInfoUI.class, bundle);
            g.Ek();
            g.Ei().DT().a(a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.valueOf(true));
            return this;
        }
        str = str2;
        g.Ek();
        g.Eh().dpP.a(new com.tencent.mm.plugin.offline.a.g("offlineshowpage", "push", str), 0);
        c(activity, WalletOrderInfoUI.class, bundle);
        g.Ek();
        g.Ei().DT().a(a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.valueOf(true));
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletOrderInfoUI) {
            z(activity);
            b(activity, null);
        }
    }

    public final void c(Activity activity, int i) {
        z(activity);
    }

    public final void b(Activity activity, Bundle bundle) {
        ag(activity);
        if (this.jfZ.getInt("key_from_scene") == 8) {
            com.tencent.mm.plugin.offline.c.a.Jl(this.jfZ.getString("key_appid"));
        }
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String aNK() {
        return "ShowOrderSuccessProcess";
    }
}
