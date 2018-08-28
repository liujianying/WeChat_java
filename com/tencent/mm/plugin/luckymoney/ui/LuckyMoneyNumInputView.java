package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyNumInputView extends LinearLayout implements b {
    private TextWatcher UE = new TextWatcher() {
        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            if (LuckyMoneyNumInputView.this.kLt != null) {
                f a = LuckyMoneyNumInputView.this.kLt;
                LuckyMoneyNumInputView.this.getInputViewId();
                a.baD();
            }
        }
    };
    private TextView gsY;
    private f kLt;
    private TenpaySecureEditText kWB;
    private TextView kWC;
    private int kWD = 1;
    private int kWE = Integer.MAX_VALUE;
    private int kWF = 1;

    public void setHint(String str) {
        this.kWB.setHint(str);
    }

    public LuckyMoneyNumInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(g.lucky_money_num_input_view, this, true);
        this.gsY = (TextView) inflate.findViewById(f.lucky_money_num_input_title);
        this.kWB = (TenpaySecureEditText) inflate.findViewById(f.lucky_money_et);
        this.kWC = (TextView) inflate.findViewById(f.lucky_money_num_unit);
        this.kWB.setText(this.kWD);
        this.kWB.addTextChangedListener(this.UE);
    }

    public void setMaxNum(int i) {
        int i2 = 3;
        this.kWE = i;
        int i3 = 0;
        while (i > 0) {
            i3++;
            i /= 10;
        }
        if (i3 > 3) {
            i2 = i3;
        }
        this.kWB.setFilters(new InputFilter[]{new LengthFilter(i2)});
    }

    public void setMinNum(int i) {
        this.kWF = i;
    }

    public int getInput() {
        try {
            return Integer.parseInt(this.kWB.getText().toString(), 10);
        } catch (Exception e) {
            return 0;
        }
    }

    public void setNum(String str) {
        this.kWB.setText(str);
        this.kWB.setSelection(this.kWB.getText().length());
        this.kWD = bi.getInt(str, 0);
    }

    public void setOnInputValidChangerListener(f fVar) {
        this.kLt = fVar;
    }

    public final int baC() {
        if (bi.oW(this.kWB.getText().toString())) {
            return 0;
        }
        int i = bi.getInt(this.kWB.getText().toString(), -1);
        if (i < 0) {
            return 3;
        }
        if (i > this.kWE && this.kWE > 0) {
            return 1;
        }
        if (i >= this.kWF || this.kWF <= 0) {
            return 0;
        }
        return 2;
    }

    public final void restore() {
        this.gsY.setTextColor(-16777216);
        this.kWB.setTextColor(-16777216);
        this.kWC.setTextColor(-16777216);
    }

    public final void onError() {
        this.gsY.setTextColor(o.dM(getContext()));
        this.kWB.setTextColor(o.dM(getContext()));
        this.kWC.setTextColor(o.dM(getContext()));
    }

    public int getInputViewId() {
        return getId();
    }

    public final String rV(int i) {
        if (i == 1) {
            return getContext().getString(i.lucky_money_num_max_limit_tips, new Object[]{Integer.valueOf(this.kWE)});
        } else if (i != 2) {
            return null;
        } else {
            return getContext().getString(i.lucky_money_num_luck_min_limit_tips, new Object[]{Integer.valueOf(this.kWF)});
        }
    }
}
