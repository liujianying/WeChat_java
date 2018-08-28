package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.b.ai;
import com.tencent.mm.plugin.luckymoney.ui.g.c;
import com.tencent.mm.plugin.luckymoney.ui.g.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.bi;

class g$b implements d {
    c kWH;

    g$b() {
    }

    public final void a(Context context, ViewGroup viewGroup, ai aiVar) {
        if (!bi.oW(aiVar.name)) {
            View textView = new TextView(context);
            if (this.kWH == null || this.kWH.textColor == Integer.MIN_VALUE) {
                textView.setTextColor(context.getResources().getColor(a.c.wallet_link_color));
            } else {
                textView.setTextColor(this.kWH.textColor);
            }
            if (this.kWH == null || this.kWH.textSize == Integer.MIN_VALUE) {
                textView.setTextSize(0, (float) context.getResources().getDimensionPixelSize(a.d.HintTextSize));
            } else {
                textView.setTextSize(0, (float) this.kWH.textSize);
            }
            textView.setGravity(17);
            textView.setText(aiVar.name);
            if (!bi.oW(aiVar.content)) {
                textView.setOnClickListener(new 1(this, aiVar, context));
            }
            viewGroup.addView(textView, new LayoutParams(-2, -2));
            viewGroup.setVisibility(0);
            h.mEJ.h(11701, new Object[]{Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(aiVar.kRD)});
        }
    }
}
