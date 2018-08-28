package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.d.j;

public class BankRemitDetailItemView extends LinearLayout {
    private TextView gsY;
    private TextView hVS;
    private boolean mvp;

    public BankRemitDetailItemView(Context context) {
        this(context, false);
    }

    public BankRemitDetailItemView(Context context, boolean z) {
        super(context);
        this.mvp = false;
        this.mvp = z;
        init();
    }

    public BankRemitDetailItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mvp = false;
        init();
    }

    public BankRemitDetailItemView(Context context, AttributeSet attributeSet, int i) {
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

    public final void a(String str, CharSequence charSequence, boolean z) {
        this.gsY.setText(str);
        if (z) {
            this.hVS.setText(j.a(getContext(), charSequence, this.hVS.getTextSize()));
        } else {
            this.hVS.setText(charSequence);
        }
    }

    public final void b(int i, CharSequence charSequence) {
        a(getContext().getString(i), charSequence, false);
    }
}
