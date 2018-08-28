package com.tencent.mm.plugin.luckymoney.appbrand.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.ui.b;
import com.tencent.mm.plugin.luckymoney.ui.f;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.widget.MMEditText;

public class WxaLuckyMoneyTextInputView extends LinearLayout implements b {
    private TextView gsY;
    private f kLt;
    private MMEditText kMR;

    public WxaLuckyMoneyTextInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(g.wxa_lucky_money_text_input_view, this, true);
        this.kMR = (MMEditText) inflate.findViewById(a.f.lucky_money_text);
        this.gsY = (TextView) inflate.findViewById(a.f.lucky_money_text_input_title);
        this.kMR.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (WxaLuckyMoneyTextInputView.this.kLt != null) {
                    f a = WxaLuckyMoneyTextInputView.this.kLt;
                    WxaLuckyMoneyTextInputView.this.getInputViewId();
                    a.baD();
                }
            }
        });
        c fj = c.d(this.kMR).fj(0, 24);
        fj.uCR = false;
        fj.a(null);
    }

    public void setOnInputValidChangerListener(f fVar) {
        this.kLt = fVar;
    }

    public String getInput() {
        return this.kMR.getText().toString();
    }

    public void setHintText(String str) {
        this.kMR.setHint(str);
    }

    public void setTitle(String str) {
        this.gsY.setText(str);
    }

    public final int baC() {
        return 0;
    }

    public final void restore() {
    }

    public final void onError() {
    }

    public int getInputViewId() {
        return getId();
    }

    public final String rV(int i) {
        return null;
    }
}
