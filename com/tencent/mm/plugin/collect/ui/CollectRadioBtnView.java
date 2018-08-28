package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.y;

public class CollectRadioBtnView extends LinearLayout {
    private TextView gsY;
    private ImageView hZd;

    public CollectRadioBtnView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CollectRadioBtnView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = y.gq(context).inflate(g.collect_bill_radio_btn, this);
        this.hZd = (ImageView) inflate.findViewById(f.radio_iv);
        this.gsY = (TextView) inflate.findViewById(f.title_tv);
    }

    public void setTitleText(String str) {
        this.gsY.setText(str);
    }

    public void setRadioSrc(int i) {
        this.hZd.setImageResource(i);
    }
}
