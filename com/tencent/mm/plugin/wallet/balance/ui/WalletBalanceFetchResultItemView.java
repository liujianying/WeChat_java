package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;

public class WalletBalanceFetchResultItemView extends LinearLayout {
    private TextView gsY;
    private TextView hVS;
    private boolean mvp;

    public WalletBalanceFetchResultItemView(Context context) {
        this(context, false);
    }

    public WalletBalanceFetchResultItemView(Context context, boolean z) {
        super(context);
        this.mvp = false;
        this.mvp = z;
        init();
    }

    public WalletBalanceFetchResultItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mvp = false;
        init();
    }

    public WalletBalanceFetchResultItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mvp = false;
        init();
    }

    private void init() {
        if (this.mvp) {
            inflate(getContext(), g.bank_remit_detail_item_money_layout, this);
        } else {
            inflate(getContext(), g.bank_remit_detail_item_comm_layout, this);
        }
        this.gsY = (TextView) findViewById(f.brdi_title_tv);
        this.hVS = (TextView) findViewById(f.brdi_desc_tv);
    }

    public final void b(int i, CharSequence charSequence) {
        this.gsY.setText(getContext().getString(i));
        this.hVS.setText(charSequence);
    }
}
