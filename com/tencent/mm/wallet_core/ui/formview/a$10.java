package com.tencent.mm.wallet_core.ui.formview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;

class a$10 implements OnClickListener {
    final /* synthetic */ MMActivity ixt;

    a$10(MMActivity mMActivity) {
        this.ixt = mMActivity;
    }

    public final void onClick(View view) {
        b.a(this.ixt, g.wallet_name_illustration_dialog, i.wallet_card_name_illustraction);
    }
}
