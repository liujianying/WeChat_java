package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.5;
import com.tencent.mm.wallet_core.a;

class WalletVerifyCodeUI$5$2 implements OnClickListener {
    final /* synthetic */ int pyU;
    final /* synthetic */ 5 pyV;

    WalletVerifyCodeUI$5$2(5 5, int i) {
        this.pyV = 5;
        this.pyU = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        boolean z;
        Bundle bundle = this.pyV.pyT.sy;
        bundle.putInt("key_err_code", 417);
        bundle.putBoolean("key_need_show_switch_phone", true);
        String str = "key_isbalance";
        if (this.pyV.oZt == null || this.pyV.oZt.bOs()) {
            z = true;
        } else {
            z = false;
        }
        bundle.putBoolean(str, z);
        a.j(this.pyV.pyT, bundle);
        this.pyV.pyT.finish();
        h.mEJ.h(15443, new Object[]{Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(this.pyU)});
    }
}
