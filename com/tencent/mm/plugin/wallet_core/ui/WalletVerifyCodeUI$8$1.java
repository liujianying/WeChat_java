package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.8;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.a;

class WalletVerifyCodeUI$8$1 implements OnClickListener {
    final /* synthetic */ 8 pyW;

    WalletVerifyCodeUI$8$1(8 8) {
        this.pyW = 8;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess2 and finish to reset mobile num!");
        Bundle bundle = this.pyW.pyT.sy;
        bundle.putInt("key_err_code", 408);
        a.j(this.pyW.pyT, bundle);
        this.pyW.pyT.finish();
    }
}
