package com.tencent.mm.plugin.walletlock.gesture.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.ta;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.walletlock.a.b$a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.b.a;
import com.tencent.mm.plugin.walletlock.b.g;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends a {
    public final void init() {
        x.e("MicroMsg.GestureImpl", "alvinluo gestureimpl init");
        g gVar = g.pIt;
        g.jI(true);
        g.pIt.zB(1);
    }

    public final void a(Activity activity, b bVar) {
        if (!com.tencent.mm.kernel.g.Ee().k(com.tencent.mm.plugin.walletlock.a.a.class)) {
            x.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
        } else if (bVar == null || bVar.L(activity)) {
            ta taVar = new ta();
            taVar.cex.cez = 0;
            taVar.cex.activity = activity;
            com.tencent.mm.sdk.b.a.sFg.m(taVar);
            switch (((Integer) taVar.cey.data).intValue()) {
                case 17:
                    activity.finish();
                    Intent intent = new Intent(activity, GestureGuardLogicUI.class);
                    intent.addFlags(131072);
                    intent.putExtra("action", "action.verify_pattern");
                    intent.putExtra("next_action", "next_action.goto_protected_page");
                    intent.putExtra("page_intent", activity.getIntent());
                    intent.putExtra("scene", a.M(activity));
                    intent.setPackage(ad.getPackageName());
                    activity.startActivity(intent);
                    h.mEJ.h(12097, new Object[]{Integer.valueOf(8), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis())});
                    return;
                default:
                    return;
            }
        } else {
            x.d("MicroMsg.GestureImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
        }
    }

    public final void a(Activity activity, b bVar, b$a b_a) {
        if (com.tencent.mm.kernel.g.Ee().k(com.tencent.mm.plugin.walletlock.a.a.class)) {
            ta taVar = new ta();
            taVar.cex.cez = 1;
            taVar.cex.activity = activity;
            com.tencent.mm.sdk.b.a.sFg.m(taVar);
            switch (((Integer) taVar.cey.data).intValue()) {
                case 17:
                    if (bVar == null || bVar.L(activity)) {
                        Intent intent = new Intent(activity, GestureGuardLogicUI.class);
                        intent.addFlags(131072);
                        intent.putExtra("action", "action.verify_pattern");
                        intent.putExtra("next_action", "next_action.goto_protected_page");
                        intent.putExtra("page_intent", activity.getIntent());
                        intent.putExtra("scene", a.M(activity));
                        intent.setPackage(ad.getPackageName());
                        activity.startActivity(intent);
                        return;
                    }
                    x.d("MicroMsg.GestureImpl", "protectMeOnResume: still in filter range, do not activate protection.");
                    return;
                default:
                    return;
            }
        }
        x.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
    }

    public final void h(Activity activity, int i) {
        if (i == 1) {
            if (com.tencent.mm.kernel.g.Ee().k(com.tencent.mm.plugin.walletlock.a.a.class)) {
                Intent intent = new Intent();
                intent.putExtra("action", "action.verify_paypwd");
                intent.putExtra("next_action", "next_action.switch_on_pattern");
                intent.putExtra("key_wallet_lock_type", 1);
                d.b(activity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent);
                return;
            }
            x.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
        }
    }

    public final void b(Activity activity, int i, int i2) {
        if (i == 1) {
            if (com.tencent.mm.kernel.g.Ee().k(com.tencent.mm.plugin.walletlock.a.a.class)) {
                Intent intent = new Intent();
                intent.putExtra("action", "action.verify_paypwd");
                intent.putExtra("next_action", "next_action.switch_on_pattern");
                intent.putExtra("key_wallet_lock_type", 1);
                d.b(activity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, i2);
                return;
            }
            x.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
        }
    }

    public final void K(Activity activity) {
        if (!com.tencent.mm.kernel.g.Ee().k(com.tencent.mm.plugin.walletlock.a.a.class)) {
            x.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
        } else if (b.bRE()) {
            Intent intent = new Intent(activity, GestureGuardLogicUI.class);
            intent.addFlags(131072);
            intent.putExtra("action", "action.verify_pattern");
            intent.putExtra("next_action", "next_action.modify_pattern");
            intent.setPackage(ad.getPackageName());
            activity.startActivity(intent);
        } else {
            x.d("MicroMsg.GestureImpl", "try to enter modify gesture password process while gesture password has been switched off.");
        }
    }

    public final void i(Activity activity, int i) {
        if (!com.tencent.mm.kernel.g.Ee().k(com.tencent.mm.plugin.walletlock.a.a.class)) {
            x.d("MicroMsg.GestureImpl", "Plugin gesture is not installed.");
        } else if (b.bRE()) {
            Intent intent = new Intent(activity, GestureGuardLogicUI.class);
            intent.addFlags(131072);
            intent.putExtra("action", "action.verify_pattern");
            intent.putExtra("next_action", "next_action.switch_off_pattern");
            intent.setPackage(ad.getPackageName());
            activity.startActivity(intent);
        } else {
            x.d("MicroMsg.GestureImpl", "try to enter close gesture password process while gesture password has been switched off.");
        }
    }

    public final boolean bRp() {
        return b.bRE();
    }

    public final boolean bRq() {
        return b.bRF();
    }
}
