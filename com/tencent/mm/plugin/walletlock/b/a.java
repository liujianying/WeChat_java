package com.tencent.mm.plugin.walletlock.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.a.b$a;
import com.tencent.mm.plugin.walletlock.gesture.a.c;
import com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI;
import com.tencent.mm.sdk.platformtools.x;

public class a implements b {
    public static int M(Activity activity) {
        x.i("MicroMsg.BaseWalletLockImpl", "alvinluo activity %s", new Object[]{activity.getClass().getSimpleName()});
        if (activity.getClass().getSimpleName().equals("MallIndexUI")) {
            return 1;
        }
        if (activity.getClass().getSimpleName().equals("WalletOfflineCoinPurseUI")) {
            return 2;
        }
        return -1;
    }

    public void init() {
        g.pIt.zB(0);
    }

    public void a(Activity activity, b.b bVar) {
    }

    public void a(Activity activity, b.b bVar, b$a b_a) {
    }

    public void h(Activity activity, int i) {
        x.i("MicroMsg.BaseWalletLockImpl", "alvinluo enterNewWalletLockProcess walletLockType: %d", new Object[]{Integer.valueOf(i)});
        if (i == 1) {
            new c().h(activity, i);
        } else if (i == 2) {
            new com.tencent.mm.plugin.walletlock.fingerprint.a.b().h(activity, i);
        }
    }

    public void b(Activity activity, int i, int i2) {
        x.i("MicroMsg.BaseWalletLockImpl", "alvinluo enterNewWalletLockProcessForResult walletLockType: %d, requestCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 1) {
            new c().b(activity, i, i2);
        } else if (i == 2) {
            new com.tencent.mm.plugin.walletlock.fingerprint.a.b().b(activity, i, i2);
        }
    }

    public void K(Activity activity) {
    }

    public void i(Activity activity, int i) {
    }

    public b.b bRo() {
        return null;
    }

    public boolean bRp() {
        return false;
    }

    public boolean bRq() {
        return false;
    }

    public void c(Activity activity, Intent intent) {
        intent.setClass(activity, WalletLockSettingUI.class);
        activity.startActivity(intent);
    }

    public void b(Activity activity, Intent intent, int i) {
        intent.setClass(activity, WalletLockSettingUI.class);
        activity.startActivityForResult(intent, i);
    }

    public void zw(int i) {
    }
}
