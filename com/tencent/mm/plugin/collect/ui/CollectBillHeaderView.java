package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.ui.WalletTextView;

public class CollectBillHeaderView extends LinearLayout {
    TextView hVS;
    TextView hWO;
    WalletTextView hWP;
    private TextView hWQ;

    public CollectBillHeaderView(Context context) {
        super(context);
        init(context);
    }

    public CollectBillHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CollectBillHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = y.gq(context).inflate(g.collect_bill_header, this);
        this.hWO = (TextView) inflate.findViewById(f.collect_bill_header_date_tv);
        this.hWQ = (TextView) inflate.findViewById(f.collect_bill_header_currency_tv);
        this.hWP = (WalletTextView) inflate.findViewById(f.collect_bill_header_money_tv);
        this.hVS = (TextView) inflate.findViewById(f.collect_bill_header_desc_tv);
    }
}
