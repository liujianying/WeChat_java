package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditErrDetailUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class d extends c {
    public final c a(Activity activity, Bundle bundle) {
        x.d("MicroMsg.WXCreditManagerProcess", "start Process : WXCreditManagerProcess");
        c(activity, WalletWXCreditDetailUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (i == 1) {
            c(activity, WalletWXCreditErrDetailUI.class, bundle);
            activity.finish();
        } else if (activity instanceof WalletWXCreditDetailUI) {
            c(activity, WalletCheckPwdUI.class, bundle);
        } else if (activity instanceof WalletCheckPwdUI) {
            b(activity, bundle);
        } else if (activity instanceof WalletWXCreditErrDetailUI) {
            c(activity, WalletCheckPwdUI.class, bundle);
        }
    }

    public final void c(Activity activity, int i) {
        z(activity);
    }

    public final void b(Activity activity, Bundle bundle) {
        e(activity, "mall", ".ui.MallIndexUI");
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final g a(MMActivity mMActivity, i iVar) {
        if (mMActivity instanceof WalletWXCreditDetailUI) {
            return new 1(this, mMActivity, iVar);
        }
        return mMActivity instanceof WalletCheckPwdUI ? new 2(this, mMActivity, iVar) : super.a(mMActivity, iVar);
    }

    public final String aNK() {
        return "WXCreditManagerProcess";
    }
}
