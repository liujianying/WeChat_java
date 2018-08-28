package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class h$9 implements OnClickListener {
    final /* synthetic */ WalletBaseUI peV;

    h$9(WalletBaseUI walletBaseUI) {
        this.peV = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_bind_bankcard", false);
        a.a(this.peV, "BindCardProcess", bundle, new 1(this));
    }
}
