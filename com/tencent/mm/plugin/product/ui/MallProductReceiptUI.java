package com.tencent.mm.plugin.product.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import com.tencent.mm.plugin.product.a.a;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bfm;
import com.tencent.mm.sdk.platformtools.bi;

public class MallProductReceiptUI extends MallBaseUI {
    private c lSG;
    private d lSW = null;
    private AutoCompleteTextView lSX = null;
    private h lSY = null;

    protected final int getLayoutId() {
        return g.product_receipt_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lSW = a.bmF().bmH();
        a.bmF();
        this.lSG = a.bmG();
        initView();
    }

    public final void initView() {
        setMMTitle(i.mall_product_receipt_title);
        addTextOptionMenu(0, getString(i.app_finish), new 1(this));
        this.lSX = (AutoCompleteTextView) findViewById(f.mall_product_receipt_actv);
        bfm bmN = this.lSG.bmN();
        if (!(bmN == null || bi.oW(bmN.jQf))) {
            this.lSX.setText(bmN.jQf);
        }
        this.lSX.setSelection(this.lSX.getText().length());
        this.lSY = new h(this);
        this.lSX.setAdapter(this.lSY);
        this.lSX.setOnItemClickListener(new 2(this));
        View.inflate(this.mController.tml, g.product_input_history_last_item, null).setOnClickListener(new 3(this));
    }
}
