package com.tencent.mm.plugin.wallet_core.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a$h;

class SwitchPhoneItemGroupView$1 implements OnClickListener {
    final /* synthetic */ SwitchPhoneItemGroupView pzz;

    SwitchPhoneItemGroupView$1(SwitchPhoneItemGroupView switchPhoneItemGroupView) {
        this.pzz = switchPhoneItemGroupView;
    }

    public final void onClick(View view) {
        for (SwitchPhoneItemView switchPhoneItemView : this.pzz.pzw) {
            switchPhoneItemView.pzC.setImageResource(a$h.radio_off);
        }
        ((SwitchPhoneItemView) view).pzC.setImageResource(a$h.radio_on);
        if (SwitchPhoneItemGroupView.a(this.pzz) != null) {
            SwitchPhoneItemGroupView.a(this.pzz).cZ(view);
        }
    }
}
