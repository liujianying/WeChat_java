package com.tencent.mm.plugin.luckymoney.appbrand.ui;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.appbrand.a.h.a;
import com.tencent.mm.plugin.luckymoney.b.d;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.luckymoney.ui.b;
import com.tencent.mm.plugin.luckymoney.ui.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class WxaLuckyMoneyMoneyInputView extends LinearLayout implements b {
    private TextWatcher UE = new 1(this);
    private TextView gsY;
    private TenpaySecureEditText kLq;
    private TextView kLr;
    private View kLs;
    private f kLt;
    private d kLu;
    private double kLv;
    private double kLw;
    public a kLx;

    public void setHint(String str) {
        this.kLq.setHint(str);
    }

    public WxaLuckyMoneyMoneyInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        com.tencent.mm.plugin.luckymoney.a.a.bat();
        this.kLu = com.tencent.mm.plugin.luckymoney.a.a.bau().baS();
        View inflate = LayoutInflater.from(context).inflate(g.wxa_lucky_money_money_input_view, this, true);
        this.kLq = (TenpaySecureEditText) inflate.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_et);
        this.kLq.addTextChangedListener(this.UE);
        this.gsY = (TextView) inflate.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_money_input_title);
        this.kLs = inflate.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_money_input_group_icon);
        this.kLr = (TextView) inflate.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_amount_unit_title);
    }

    public void setType(a aVar) {
        this.kLx = aVar;
    }

    public double getInput() {
        return bi.getDouble(this.kLq.getText().toString(), 0.0d);
    }

    public void setTitle(String str) {
        this.gsY.setText(str);
    }

    public void setShowGroupIcon(boolean z) {
        if (z) {
            this.kLs.setVisibility(0);
        } else {
            this.kLs.setVisibility(8);
        }
    }

    public void setOnInputValidChangerListener(f fVar) {
        this.kLt = fVar;
    }

    public void setMaxLen(int i) {
        this.kLq.setFilters(new InputFilter[]{new LengthFilter(i)});
    }

    public void setAmount(String str) {
        this.kLq.setText(str);
    }

    public void setMaxAmount(double d) {
        this.kLv = d;
    }

    public void setMinAmount(double d) {
        this.kLw = d;
    }

    public final int baC() {
        if (bi.oW(this.kLq.getText().toString())) {
            return 0;
        }
        double d = bi.getDouble(this.kLq.getText().toString(), -1.0d);
        if (d < 0.0d) {
            return 3;
        }
        if (d > this.kLv && this.kLv > 0.0d) {
            return 1;
        }
        if (d >= this.kLw || d <= 0.0d) {
            return 0;
        }
        return 2;
    }

    public final void restore() {
        this.gsY.setTextColor(-16777216);
        this.kLq.setTextColor(-16777216);
        this.kLr.setTextColor(-16777216);
    }

    public final void onError() {
        this.gsY.setTextColor(o.dM(getContext()));
        this.kLq.setTextColor(o.dM(getContext()));
        this.kLr.setTextColor(o.dM(getContext()));
    }

    public int getInputViewId() {
        return getId();
    }

    public final String rV(int i) {
        com.tencent.mm.plugin.luckymoney.a.a.bat();
        this.kLu = com.tencent.mm.plugin.luckymoney.a.a.bau().baS();
        if (i == 1) {
            if (this.kLx == a.kKZ) {
                return getContext().getString(i.lucky_money_total_amount_max_limit_tips, new Object[]{Math.round(this.kLv), bi.aG(this.kLu.kKW, "")});
            }
            return getContext().getString(i.lucky_money_amount_max_limit_tips, new Object[]{Math.round(this.kLv), bi.aG(this.kLu.kKW, "")});
        } else if (i != 2) {
            return null;
        } else {
            return getContext().getString(i.lucky_money_amount_min_limit_tips, new Object[]{e.A(this.kLw), bi.aG(this.kLu.kKW, "")});
        }
    }
}
