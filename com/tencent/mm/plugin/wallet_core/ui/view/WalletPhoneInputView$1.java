package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

class WalletPhoneInputView$1 implements OnClickListener {
    final /* synthetic */ WalletPhoneInputView pzY;

    WalletPhoneInputView$1(WalletPhoneInputView walletPhoneInputView) {
        this.pzY = walletPhoneInputView;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.WalletPhoneInputView", "click area");
        Intent intent = new Intent();
        intent.setClassName(this.pzY.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
        ((MMActivity) this.pzY.getContext()).startActivityForResult(intent, 65521);
    }
}
