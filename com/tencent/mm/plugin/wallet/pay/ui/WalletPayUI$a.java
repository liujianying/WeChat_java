package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

protected class WalletPayUI$a {
    final /* synthetic */ WalletPayUI pgT;

    protected WalletPayUI$a(WalletPayUI walletPayUI) {
        this.pgT = walletPayUI;
    }

    public final void notifyDataSetChanged() {
        this.pgT.pgC.removeAllViews();
        int i = this.pgT.mCount == 0 ? 0 : this.pgT.pgq ? this.pgT.mCount : 1;
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        for (int i2 = 0; i2 < i; i2++) {
            View inflate = ((LayoutInflater) this.pgT.getSystemService("layout_inflater")).inflate(a$g.wallet_pay_item, null);
            TextView textView = (TextView) inflate.findViewById(a$f.wallet_order_info_desc);
            TextView textView2 = (TextView) inflate.findViewById(a$f.wallet_order_info_spid);
            Commodity commodity = (Commodity) this.pgT.mCZ.ppf.get(i2);
            Object obj = "";
            if (this.pgT.mCn != null && (this.pgT.mCn.bVY == 32 || this.pgT.mCn.bVY == 33 || this.pgT.mCn.bVY == 31 || this.pgT.mCn.bVY == 48)) {
                String string = this.pgT.mCn.qUL.getString("extinfo_key_1", "");
                if (bi.oW(string)) {
                    x.e("MicroMsg.WalletPayUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                } else {
                    g.Ek();
                    ab Ye = ((i) g.l(i.class)).FR().Ye(string);
                    if (Ye != null) {
                        obj = Ye.BL();
                    } else {
                        x.e("MicroMsg.WalletPayUI", "can not found contact for user::" + string);
                    }
                }
            }
            if (commodity != null) {
                if (!bi.oW(obj)) {
                    textView2.setText(obj);
                    textView2.setVisibility(0);
                    ((TextView) inflate.findViewById(a$f.wallet_order_info_spid_title)).setVisibility(0);
                } else if (bi.oW(commodity.lNK)) {
                    ((TextView) inflate.findViewById(a$f.wallet_order_info_spid_title)).setVisibility(8);
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(commodity.lNK);
                    textView2.setVisibility(0);
                    ((TextView) inflate.findViewById(a$f.wallet_order_info_spid_title)).setVisibility(0);
                }
                if (bi.oW(commodity.desc)) {
                    ((TextView) inflate.findViewById(a$f.wallet_order_info_desc_title)).setVisibility(8);
                    textView.setVisibility(8);
                } else {
                    textView.setText(commodity.desc);
                    textView.setVisibility(8);
                    ((TextView) inflate.findViewById(a$f.wallet_order_info_desc_title)).setVisibility(8);
                }
                if (bi.oW(obj) && bi.oW(commodity.lNK)) {
                    inflate.setVisibility(8);
                } else {
                    inflate.setVisibility(0);
                }
            }
            inflate.setLayoutParams(layoutParams);
            inflate.measure(-2, -2);
            this.pgT.pgC.addView(inflate);
        }
    }
}
