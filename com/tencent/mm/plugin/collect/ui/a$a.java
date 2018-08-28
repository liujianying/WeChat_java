package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.wallet_core.ui.WalletTextView;

class a$a {
    TextView hVS;
    TextView hWO;
    WalletTextView hWP;

    public a$a(View view) {
        this.hWO = (TextView) view.findViewById(f.collect_bill_date_tv);
        this.hWP = (WalletTextView) view.findViewById(f.collect_bill_money_tv);
        this.hVS = (TextView) view.findViewById(f.collect_bill_desc_tv);
    }
}
