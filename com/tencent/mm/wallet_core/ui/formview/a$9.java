package com.tencent.mm.wallet_core.ui.formview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

class a$9 implements OnClickListener {
    final /* synthetic */ MMActivity ixt;

    a$9(MMActivity mMActivity) {
        this.ixt = mMActivity;
    }

    public final void onClick(View view) {
        h.a(this.ixt, this.ixt.getString(i.wallet_card_name_illustraction_new_detail), this.ixt.getString(i.wallet_card_name_illustraction), this.ixt.getString(i.wallet_card_name_illustraction_new_chnage_name), this.ixt.getString(i.wallet_card_name_illustraction_new_i_know), new 1(this), new 2(this));
    }
}
