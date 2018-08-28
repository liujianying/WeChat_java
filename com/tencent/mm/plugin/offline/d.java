package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.g.a.kr;
import com.tencent.mm.plugin.offline.a.k;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class d extends b {
    static /* synthetic */ void h(MMActivity mMActivity) {
        String string = ((WalletBaseUI) mMActivity).sy.getString("key_pwd1");
        int i = ((WalletBaseUI) mMActivity).sy.getInt("offline_add_fee", 0);
        Bankcard blB = a.blB();
        if (blB != null) {
            ((WalletBaseUI) mMActivity).a(new k(blB, string, i), true, false);
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        com.tencent.mm.sdk.b.a.sFg.m(new kr());
        c(activity, WalletOfflineEntranceUI.class);
        if (activity != null) {
            activity.finish();
        }
    }

    public final void c(Activity activity, int i) {
        super.c(activity, i);
    }

    public final g a(MMActivity mMActivity, i iVar) {
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new 1(this, mMActivity, iVar);
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new 2(this, mMActivity, iVar) : super.a(mMActivity, iVar);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return super.c(activity, bundle);
    }

    public final String aNK() {
        return "OfflineBindCardRegProcess";
    }
}
