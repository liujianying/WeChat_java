package com.tencent.mm.plugin.wallet_core.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.formview.b;

class WalletPhoneInputView$2 implements OnClickListener {
    final /* synthetic */ WalletPhoneInputView pzY;

    WalletPhoneInputView$2(WalletPhoneInputView walletPhoneInputView) {
        this.pzY = walletPhoneInputView;
    }

    public final void onClick(View view) {
        b.a((MMActivity) this.pzY.getContext(), a$g.wallet_phone_illustration_dialog, i.wallet_card_phone_illustraction);
    }
}
