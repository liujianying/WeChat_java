package com.tencent.mm.plugin.order.ui.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

class g$1 implements OnClickListener {
    final /* synthetic */ TextView lQw;
    final /* synthetic */ LinearLayout lQx;
    final /* synthetic */ g lQy;

    g$1(g gVar, TextView textView, LinearLayout linearLayout) {
        this.lQy = gVar;
        this.lQw = textView;
        this.lQx = linearLayout;
    }

    public final void onClick(View view) {
        this.lQw.setVisibility(8);
        for (String a : g.a(this.lQy)) {
            this.lQx.addView(g.a(this.lQy, a), new LayoutParams(-2, -2));
        }
        this.lQw.setOnClickListener(null);
        if (g.b(this.lQy) != null) {
            g.b(this.lQy).notifyDataSetChanged();
        }
    }
}
