package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.ui.MMActivity;

public final class u extends i {
    private View hIa;

    public final void initView() {
    }

    public final void update() {
        if (this.hIa == null) {
            this.hIa = ((ViewStub) findViewById(d.card_operate_field_layout_stub)).inflate();
        }
        b ayu = this.hHF.ayu();
        MMActivity ayx = this.hHF.ayx();
        pr prVar = ayu.awn().rnk;
        if (this.hIa != null) {
            TextView textView = (TextView) this.hIa.findViewById(d.card_operate_field_title_tv);
            textView.setText(prVar.title);
            textView.setTextColor(l.xV(ayu.awm().dxh));
            TextView textView2 = (TextView) this.hIa.findViewById(d.card_operate_field_aux_title_tv);
            LinearLayout linearLayout = (LinearLayout) this.hIa.findViewById(d.card_widget_operate_field_layout);
            LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
            if (ayu.avT()) {
                LayoutParams layoutParams2 = (LayoutParams) textView.getLayoutParams();
                if (TextUtils.isEmpty(prVar.huY)) {
                    textView2.setVisibility(8);
                    layoutParams.height = ayx.getResources().getDimensionPixelOffset(a.b.card_member_operate_field_layout_height_with_no_aux_title);
                } else {
                    textView2.setText(prVar.huY);
                    textView2.setVisibility(0);
                    layoutParams.height = ayx.getResources().getDimensionPixelOffset(a.b.card_member_operate_field_layout_height_with_aux_title);
                    layoutParams2.bottomMargin = ayx.getResources().getDimensionPixelSize(a.b.BasicPaddingSize);
                    LayoutParams layoutParams3 = (LayoutParams) textView2.getLayoutParams();
                    layoutParams3.topMargin = ayx.getResources().getDimensionPixelSize(a.b.BasicPaddingSize);
                    textView2.setLayoutParams(layoutParams3);
                    textView2.invalidate();
                }
                layoutParams2.height = ayx.getResources().getDimensionPixelSize(a.b.card_member_operate_field_title_height);
                textView.setLayoutParams(layoutParams2);
                textView.invalidate();
                textView.setBackgroundDrawable(l.g(ayx, ayu.awm().dxh, ayx.getResources().getDimensionPixelSize(a.b.card_member_widget_bg_round_radius)));
                textView.setTextColor(l.ad(ayx, ayu.awm().dxh));
                linearLayout.setBackgroundDrawable(null);
                textView.setOnClickListener(this.hHF.ayy());
            } else {
                if (TextUtils.isEmpty(prVar.huY)) {
                    textView2.setVisibility(8);
                    layoutParams.height = ayx.getResources().getDimensionPixelOffset(a.b.card_operate_field_layout_height_with_no_aux_title);
                } else {
                    textView2.setText(prVar.huY);
                    textView2.setVisibility(0);
                    layoutParams.height = ayx.getResources().getDimensionPixelOffset(a.b.card_operate_field_layout_height_with_aux_title);
                }
                linearLayout.setOnClickListener(this.hHF.ayy());
            }
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.invalidate();
            this.hIa.invalidate();
            if (ayu.avT()) {
                linearLayout.getLayoutParams();
            }
        }
    }

    public final void azI() {
        if (this.hIa != null) {
            this.hIa.setVisibility(8);
        }
    }
}
