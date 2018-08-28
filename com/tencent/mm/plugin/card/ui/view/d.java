package com.tencent.mm.plugin.card.ui.view;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.ui.MMActivity;

public final class d extends i {
    private View hHu;
    private TextView hHv;
    private TextView hHw;
    private TextView hzs;

    public final void initView() {
        this.hHu = findViewById(com.tencent.mm.plugin.card.a.d.advertise_layout);
        this.hHv = (TextView) findViewById(com.tencent.mm.plugin.card.a.d.advertise_text);
        this.hzs = (TextView) findViewById(com.tencent.mm.plugin.card.a.d.share_detail_tv);
        this.hHw = (TextView) findViewById(com.tencent.mm.plugin.card.a.d.card_private_setting_tv);
        this.hHv.setOnClickListener(this.hHF.ayy());
        this.hHu.setVisibility(8);
    }

    public final void update() {
        b ayu = this.hHF.ayu();
        MMActivity ayx = this.hHF.ayx();
        this.hHu.setVisibility(0);
        if (TextUtils.isEmpty(ayu.awm().rnR)) {
            this.hHv.setVisibility(8);
        } else {
            this.hHv.setVisibility(0);
            this.hHv.setText(ayu.awm().rnR);
            if (ayu.avS() || (ayu.avR() && ayu.avU())) {
                this.hHv.setTextColor(ayx.getResources().getColor(a.white));
            } else if (ayu.avR() && ayu.avT()) {
                this.hHv.setTextColor(ayx.getResources().getColor(a.card_advertise_text_color));
                this.hHu.setBackgroundColor(ayx.getResources().getColor(a.card_bg_color));
            } else {
                this.hHv.setTextColor(ayx.getResources().getColor(a.white));
            }
        }
        View findViewById = this.hHu.findViewById(com.tencent.mm.plugin.card.a.d.card_setting_layout_container);
        if (this.hHF.ayz().azF()) {
            findViewById.setVisibility(0);
            this.hHw.setText(ayx.getString(g.card_share_card_private_setting));
            this.hHw.setTextColor(ayx.getResources().getColor(a.white));
            int dimensionPixelOffset = ayx.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.card.a.b.NormalPadding);
            Button button = (Button) this.hHu.findViewById(com.tencent.mm.plugin.card.a.d.card_private_setting_btn);
            Drawable e = l.e(ayx, ayx.getResources().getColor(a.white), dimensionPixelOffset);
            Drawable cm = l.cm(ayx.getResources().getColor(a.white), dimensionPixelOffset);
            Drawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, cm);
            stateListDrawable.addState(new int[0], e);
            button.setBackgroundDrawable(stateListDrawable);
            int[] iArr = new int[]{l.xV(ayu.awm().dxh), ayx.getResources().getColor(a.white)};
            button.setTextColor(new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[0]}, iArr));
            button.setOnClickListener(this.hHF.ayy());
            findViewById = this.hHu.findViewById(com.tencent.mm.plugin.card.a.d.middle_divider);
            View findViewById2 = this.hHu.findViewById(com.tencent.mm.plugin.card.a.d.card_hongbao_layout);
            if (ayu.awm().rof == 1) {
                findViewById.setVisibility(0);
                findViewById2.setVisibility(0);
                return;
            }
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            return;
        }
        findViewById.setVisibility(8);
    }

    public final void azI() {
        this.hHu.setVisibility(8);
    }

    public final void xL(String str) {
        this.hHw.setText(str);
    }
}
