package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class h extends c {
    public final c a(Activity activity, Bundle bundle) {
        c(activity, WalletCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            z(activity);
        }
    }

    public final void c(Activity activity, int i) {
        if (activity != null) {
            activity.finish();
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        z(activity);
        if (bundle != null && bundle.getBoolean("is_offline_create")) {
            a.C((WalletBaseUI) activity);
        }
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final void z(Activity activity) {
        int i = 2;
        if (activity != null) {
            int i2 = this.jfZ.getInt("offline_from_scene", -1);
            if (i2 != 1) {
                if (i2 == 2) {
                    i = 1;
                } else if (i2 == 3) {
                    i = 3;
                } else if (i2 == 4) {
                    i = 6;
                } else if (i2 == 8) {
                    i = 4;
                } else {
                    i = 1;
                }
            }
            com.tencent.mm.plugin.report.service.h.mEJ.h(14096, new Object[]{Integer.valueOf(i)});
            Intent intent = new Intent(activity, WalletOfflineEntranceUI.class);
            intent.putExtra("key_from_scene", i2);
            intent.putExtra("is_offline_create", true);
            a(activity, WalletOfflineEntranceUI.class, intent);
            activity.finish();
        }
    }

    public final g a(MMActivity mMActivity, i iVar) {
        return mMActivity instanceof WalletCheckPwdUI ? new 1(this, mMActivity, iVar) : super.a(mMActivity, iVar);
    }

    public final String aNK() {
        return "OfflineProcess";
    }
}
