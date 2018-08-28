package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class a extends c {
    static /* synthetic */ void sg(int i) {
        qd qdVar = new qd();
        qdVar.caN.key = i;
        qdVar.caN.value = 1;
        qdVar.caN.caO = true;
        com.tencent.mm.sdk.b.a.sFg.m(qdVar);
    }

    public final c a(Activity activity, Bundle bundle) {
        if (activity instanceof SnsLuckyMoneyFreePwdSetting) {
            c(activity, WalletCheckPwdUI.class, bundle);
        }
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        b(activity, bundle);
    }

    public final void c(Activity activity, int i) {
        b(activity, null);
    }

    public final void b(Activity activity, Bundle bundle) {
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        a(activity, "luckymoney", ".sns.SnsLuckyMoneyFreePwdSetting", -1, intent, true);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String aNK() {
        return "LuckyFreePwdProcess";
    }

    public final g a(MMActivity mMActivity, i iVar) {
        return mMActivity instanceof WalletCheckPwdUI ? new 1(this, mMActivity, iVar) : super.a(mMActivity, iVar);
    }
}
