package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.wallet_core.ui.WalletTextView;

class b$a {
    TextView hVS;
    TextView hWO;
    WalletTextView hWP;
    TextView hWQ;

    public b$a(View view) {
        this.hWO = (TextView) view.findViewById(f.collect_bill_list_date_tv);
        this.hWQ = (TextView) view.findViewById(f.collect_bill_list_currency_tv);
        this.hWP = (WalletTextView) view.findViewById(f.collect_bill_list_money_tv);
        this.hVS = (TextView) view.findViewById(f.collect_bill_list_desc_tv);
    }
}
