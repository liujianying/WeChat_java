package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.MMActivity;

public class WxaLuckyMoneyCompleteUI extends WxaLuckyMoneyBaseUI implements b {
    private Button klJ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        this.klJ = (Button) findViewById(f.wxa_lucky_money_complete_finish_btn);
        this.klJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WxaLuckyMoneyCompleteUI.this.setResult(0, null);
                WxaLuckyMoneyCompleteUI.this.finish();
            }
        });
    }

    public void onBackPressed() {
        setResult(0, null);
        finish();
    }

    protected final int getLayoutId() {
        return g.wxa_lucky_money_complete_ui;
    }

    public final MMActivity baA() {
        return this;
    }

    public final void Ga(String str) {
    }

    public final void baB() {
    }
}
