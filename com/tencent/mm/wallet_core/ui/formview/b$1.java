package com.tencent.mm.wallet_core.ui.formview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.picker.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$1 implements OnClickListener {
    final /* synthetic */ MMActivity ixt;
    final /* synthetic */ WalletFormView uZj;
    int uZw = -1;
    int year = -1;

    b$1(MMActivity mMActivity, WalletFormView walletFormView) {
        this.ixt = mMActivity;
        this.uZj = walletFormView;
    }

    public final void onClick(View view) {
        this.ixt.YC();
        if (this.ixt instanceof WalletBaseUI) {
            ((WalletBaseUI) this.ixt).Wq();
        }
        a aVar = new a(this.ixt);
        aVar.Z(true, false);
        aVar.uLe = new 1(this, aVar);
        if (this.year >= b.bB() && this.uZw >= b.KD()) {
            aVar.ao(this.year, this.uZw + 1, 1);
        }
        aVar.show();
    }
}
