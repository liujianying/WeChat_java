package com.tencent.mm.plugin.wallet_ecard.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.q;

public class a extends b {
    public final c a(Activity activity, Bundle bundle) {
        y(new Object[]{"start", activity, bundle});
        x.d("MicroMsg.BindCardProcess", "start Process : BindCardProcess");
        if (bundle != null) {
            q.fu(6, bundle.getInt("key_bind_scene"));
            p.GZ(bundle.getInt("key_bind_scene"));
        } else {
            q.fu(6, 0);
            p.GZ(0);
        }
        if (!o.bOW().bPs()) {
            if (bundle != null) {
                com.tencent.mm.plugin.wallet_core.e.c.ea(bundle.getInt("key_bind_scene", 0), 1);
            }
            if (bundle == null || !bundle.getBoolean("key_is_import_bind", false)) {
                return super.a(activity, bundle);
            }
            c(activity, WalletCardImportUI.class, bundle);
            return this;
        } else if (bundle == null) {
            return super.a(activity, bundle);
        } else {
            if (bundle.getBoolean("key_is_import_bind", false)) {
                c(activity, WalletCardImportUI.class, bundle);
                return this;
            }
            c(activity, WalletBankcardIdUI.class, bundle);
            return this;
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        if (bundle == null || !bundle.getBoolean("intent_bind_end", false)) {
            a(activity, "wallet_ecard", ".ui.WalletECardBindCardListUI", 0, new Intent(), true);
            activity.finish();
            return;
        }
        Activity activity2 = activity;
        a(activity2, "wallet_ecard", ".ui.WalletECardBindCardListUI", -1, new Intent(), true);
    }

    public final String aNK() {
        return "OpenECardBindCardProcess";
    }
}
