package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;

public class MallProductSelectAmountView extends LinearLayout {
    private TextView eBQ = null;
    private ImageView lTa = null;
    private ImageView lTb = null;
    int lTc = Integer.MAX_VALUE;
    int lTd = 1;
    private int lTe = 1;
    int lTf = this.lTe;
    a lTg = null;

    public void setOnAmountChangeListener(a aVar) {
        this.lTg = aVar;
    }

    public MallProductSelectAmountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(g.product_select_amount, this, true);
        this.eBQ = (TextView) inflate.findViewById(f.mall_product_select_sku_count);
        this.lTa = (ImageView) inflate.findViewById(f.mall_product_select_sku_add);
        this.lTb = (ImageView) inflate.findViewById(f.mall_product_select_sku_remove);
        this.eBQ.setText(this.lTf);
        this.lTa.setOnClickListener(new 1(this));
        this.lTb.setOnClickListener(new 2(this));
    }

    public void setAmount(int i) {
        this.lTf = i;
        if (f()) {
            this.eBQ.setText(this.lTf);
            if (this.lTg != null) {
                this.lTg.ex(this.lTf);
            }
        }
    }

    /* renamed from: bnh */
    final boolean f() {
        if (this.lTf > this.lTc) {
            this.lTf = this.lTc;
            if (this.lTg != null) {
                this.lTg.ex(this.lTf);
            }
            if (this.lTg != null) {
                this.lTg.dk(this.lTf, this.lTd);
            }
            this.eBQ.setText(this.lTf);
            return false;
        }
        if (this.lTf > this.lTe) {
            this.lTb.setEnabled(true);
        } else if (this.lTf == this.lTe) {
            this.lTb.setEnabled(false);
        } else {
            this.lTb.setEnabled(false);
            this.lTf = this.lTe;
            if (this.lTg != null) {
                this.lTg.ex(this.lTf);
            }
            if (this.lTg != null) {
                this.lTg.dk(this.lTf, 2);
            }
            this.eBQ.setText(this.lTf);
            return false;
        }
        return true;
    }

    public void setAddEnable(boolean z) {
        this.lTa.setEnabled(z);
    }

    public void setRemoveEnable(boolean z) {
        this.lTb.setEnabled(z);
    }

    public void setMinAmount(int i) {
        this.lTe = i;
        f();
    }
}
