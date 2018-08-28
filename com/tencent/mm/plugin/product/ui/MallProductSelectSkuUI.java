package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.platformtools.y.a;
import com.tencent.mm.plugin.product.b.b;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class MallProductSelectSkuUI extends MallBaseUI implements a {
    private TextView gsY;
    private m lQL;
    private e lRa;
    private c lSG;
    private ImageView lTi;
    private TextView lTj;
    private TextView lTk;
    private Button lTl;
    private ListView lTm;
    private MallProductSelectAmountView lTn = null;
    private i lTo = null;
    private f lTp;

    protected final int getLayoutId() {
        return g.product_select_sku_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lTp = new f(this.mController.tml, new 1(this));
        com.tencent.mm.plugin.product.a.a.bmF();
        this.lSG = com.tencent.mm.plugin.product.a.a.bmG();
        this.lQL = this.lSG.lQL;
        initView();
        aL();
    }

    public void onStart() {
        this.lTp.onStart();
        super.onStart();
    }

    protected void onStop() {
        this.lTp.onStop();
        super.onStop();
    }

    protected final void initView() {
        setMMTitle(i.mall_product_select_sku_title);
        this.lTi = (ImageView) findViewById(f.mall_product_select_sku_img_iv);
        this.gsY = (TextView) findViewById(f.mall_product_select_sku_title_tv);
        this.lTj = (TextView) findViewById(f.mall_product_select_sku_price_tv);
        this.lTk = (TextView) findViewById(f.mall_product_select_sku_err);
        this.lTl = (Button) findViewById(f.mall_product_select_sku_pre_submit);
        this.lTm = (ListView) findViewById(f.mall_product_sku_lv);
        this.lTn = (MallProductSelectAmountView) findViewById(f.select_amount);
        this.lTn.setAmount(this.lSG.mCount);
        this.lTo = new i(this);
        if (this.lQL == null || this.lQL.lRp == null || this.lQL.lRp.lRJ == null) {
            x.e("MicroMsg.MallProductSelectSkuUI", "Illage mProductInfo.base_attr.sku_table");
        } else {
            this.lTo.lTr = this.lQL.lRp.lRJ;
        }
        this.lTo.lTs = new 2(this);
        this.lTm.setAdapter(this.lTo);
        this.lTn.setOnAmountChangeListener(new 3(this));
        this.lTl.setOnClickListener(new 4(this));
        this.lTi.setFocusable(true);
        this.lTi.setFocusableInTouchMode(true);
        this.lTi.requestFocus();
    }

    private void aL() {
        if (this.lQL != null) {
            if (this.lRa == null || this.lQL.lRp == null) {
                this.lTj.setText(b.l(this.lQL.lRp.lRB, this.lQL.lRp.lRC, this.lQL.lRp.lNV));
            } else {
                this.lTj.setText(b.l(this.lRa.lRe, this.lRa.lRf, this.lQL.lRp.lNV));
            }
            if (this.lQL.lRp != null) {
                this.gsY.setText(this.lQL.lRp.name);
            }
        }
        if (!bi.oW(this.lSG.bmJ())) {
            this.lTi.setImageBitmap(y.a(new c(this.lSG.bmJ())));
            y.a(this);
        }
        this.lTk.setVisibility(8);
        MallProductSelectAmountView mallProductSelectAmountView = this.lTn;
        int bmR = this.lSG.bmR();
        int i = this.lSG.lQL.lRo;
        if (bmR > i) {
            mallProductSelectAmountView.lTd = 3;
            mallProductSelectAmountView.lTc = i;
        } else {
            mallProductSelectAmountView.lTd = 1;
            mallProductSelectAmountView.lTc = bmR;
        }
        mallProductSelectAmountView.bnh();
        if (mallProductSelectAmountView.lTg != null) {
            mallProductSelectAmountView.lTg.ex(mallProductSelectAmountView.lTf);
        }
        this.lTo.notifyDataSetChanged();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.lTp.onActivityResult(i, i2, intent);
    }

    public final void m(String str, Bitmap bitmap) {
        x.d("MicroMsg.MallProductSelectSkuUI", str + ", bitmap = " + (bitmap == null));
        if (!bi.oW(this.lSG.bmJ())) {
            this.lTi.post(new 5(this, bitmap));
        }
    }
}
