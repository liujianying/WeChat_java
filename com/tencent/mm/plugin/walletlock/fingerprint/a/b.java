package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.ta;
import com.tencent.mm.plugin.walletlock.a.b$a;
import com.tencent.mm.plugin.walletlock.b.a;
import com.tencent.mm.plugin.walletlock.b.g;
import com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends a {
    public final void init() {
        g gVar = g.pIt;
        g.bRZ();
        g.pIt.zB(2);
    }

    public final void a(Activity activity, com.tencent.mm.plugin.walletlock.a.b.b bVar) {
        if (!com.tencent.mm.kernel.g.Ee().k(com.tencent.mm.plugin.walletlock.a.a.class)) {
            x.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
        } else if (bVar == null || bVar.L(activity)) {
            ta taVar = new ta();
            taVar.cex.cez = 0;
            taVar.cex.activity = activity;
            com.tencent.mm.sdk.b.a.sFg.m(taVar);
            switch (((Integer) taVar.cey.data).intValue()) {
                case 17:
                    activity.finish();
                    Intent intent = new Intent(activity, FingerprintWalletLockUI.class);
                    intent.addFlags(131072);
                    intent.putExtra("action", "action.verify_pattern");
                    intent.putExtra("next_action", "next_action.goto_protected_page");
                    intent.putExtra("page_intent", activity.getIntent());
                    intent.putExtra("scene", a.M(activity));
                    intent.setPackage(ad.getPackageName());
                    activity.startActivity(intent);
                    return;
                default:
                    return;
            }
        } else {
            x.d("MicroMsg.FingerprintLockImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
        }
    }

    public final void a(Activity activity, com.tencent.mm.plugin.walletlock.a.b.b bVar, b$a b_a) {
        if (com.tencent.mm.kernel.g.Ee().k(com.tencent.mm.plugin.walletlock.a.a.class)) {
            ta taVar = new ta();
            taVar.cex.cez = 1;
            taVar.cex.activity = activity;
            com.tencent.mm.sdk.b.a.sFg.m(taVar);
            switch (((Integer) taVar.cey.data).intValue()) {
                case 17:
                    if (bVar == null || bVar.L(activity)) {
                        Intent intent = new Intent(activity, FingerprintWalletLockUI.class);
                        intent.addFlags(131072);
                        intent.putExtra("action", "action.verify_pattern");
                        intent.putExtra("next_action", "next_action.goto_protected_page");
                        intent.putExtra("page_intent", activity.getIntent());
                        intent.putExtra("scene", a.M(activity));
                        intent.setPackage(ad.getPackageName());
                        activity.startActivity(intent);
                        return;
                    }
                    x.d("MicroMsg.FingerprintLockImpl", "protectMeOnResume: still in filter range, do not activate protection.");
                    return;
                default:
                    return;
            }
        }
        x.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
    }

    public final void h(Activity activity, int i) {
        if (i == 2) {
            if (com.tencent.mm.kernel.g.Ee().k(com.tencent.mm.plugin.walletlock.a.a.class)) {
                Intent intent = new Intent();
                intent.putExtra("action", "action.verify_paypwd");
                intent.putExtra("next_action", "next_action.switch_on_pattern");
                intent.putExtra("key_wallet_lock_type", 2);
                d.b(activity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent);
                return;
            }
            x.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
        }
    }

    public final void b(Activity activity, int i, int i2) {
        if (i == 2) {
            if (com.tencent.mm.kernel.g.Ee().k(com.tencent.mm.plugin.walletlock.a.a.class)) {
                Intent intent = new Intent();
                intent.putExtra("action", "action.verify_paypwd");
                intent.putExtra("next_action", "next_action.switch_on_pattern");
                intent.putExtra("key_wallet_lock_type", 2);
                x.i("MicroMsg.FingerprintLockImpl", "alvinluo enterNewWalletLockProcessForResult start check pwd ui, wallet lock type: %d", new Object[]{Integer.valueOf(i)});
                d.b(activity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, i2);
                return;
            }
            x.d("MicroMsg.FingerprintLockImpl", "Plugin gesture is not installed.");
        }
    }

    public final void K(Activity activity) {
    }

    public final void i(Activity activity, int i) {
    }

    public final com.tencent.mm.plugin.walletlock.a.b.b bRo() {
        return com.tencent.mm.plugin.walletlock.b.d.bRW();
    }

    public final boolean bRp() {
        g gVar = g.pIt;
        return g.bRt();
    }

    public final boolean bRq() {
        return false;
    }
}
