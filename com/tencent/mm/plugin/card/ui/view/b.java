package com.tencent.mm.plugin.card.ui.view;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.protocal.c.xk;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public final class b extends i {
    private MMActivity gKS;
    private View hHn;
    private TextView hHo;
    private g hHp;
    private com.tencent.mm.plugin.card.base.b htQ;

    public final void initView() {
        this.gKS = this.hHF.ayx();
        this.hHp = this.hHF.ayz();
    }

    public final void destroy() {
        super.destroy();
        this.gKS = null;
        this.hHp = null;
    }

    public final void update() {
        if (this.hHn == null) {
            this.hHn = ((ViewStub) findViewById(d.card_accept_layout_stub)).inflate();
            this.hHn.findViewById(d.card_accept_btn).setOnClickListener(this.hHF.ayy());
        }
        this.htQ = this.hHF.ayu();
        this.hHp = this.hHF.ayz();
        boolean azh = this.hHp.azh();
        boolean azi = this.hHp.azi();
        if (azh) {
            this.hHn.setVisibility(0);
            x.i("MicroMsg.CardAcceptView", "updateAcceptView() acceptViewVisible:" + azh + " acceptViewEnabled:" + azi);
            Button button = (Button) this.hHn.findViewById(d.card_accept_btn);
            View findViewById = this.hHn.findViewById(d.card_accept_layout);
            findViewById.setBackgroundDrawable(null);
            findViewById.setOnClickListener(null);
            int dimensionPixelSize = this.gKS.getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.card_member_widget_bg_round_radius);
            LayoutParams layoutParams;
            LayoutParams layoutParams2;
            if (azi) {
                if (!TextUtils.isEmpty(this.htQ.awm().rnP)) {
                    button.setText(this.htQ.awm().rnP);
                }
                Drawable e;
                Drawable cm;
                Drawable stateListDrawable;
                if (this.htQ.avT()) {
                    button.setTextColor(l.xV(this.htQ.awm().dxh));
                    e = l.e(this.gKS, l.xV(this.htQ.awm().dxh), dimensionPixelSize);
                    cm = l.cm(l.xV(this.htQ.awm().dxh), dimensionPixelSize);
                    stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{16842919}, cm);
                    stateListDrawable.addState(new int[0], e);
                    int[] iArr = new int[]{this.gKS.getResources().getColor(a.white), l.xV(this.htQ.awm().dxh)};
                    int[][] iArr2 = new int[][]{new int[]{16842919, 16842910}, new int[0]};
                    button.setBackgroundDrawable(stateListDrawable);
                    button.setTextColor(new ColorStateList(iArr2, iArr));
                    layoutParams = (LayoutParams) this.hHn.getLayoutParams();
                    layoutParams.topMargin = this.gKS.getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.card_card_accept_layout_top_margin_for_member_acceptable);
                    this.hHn.setLayoutParams(layoutParams);
                    this.hHn.findViewById(d.divider_line).setVisibility(8);
                    f ayC = this.hHF.ayC();
                    CheckBox checkBox = (CheckBox) this.hHn.findViewById(d.card_follow_cbx);
                    if (ayC.awL() == null || !ayC.awL().hvj) {
                        x.i("MicroMsg.CardAcceptView", "updateFollowBox() not show followbox");
                        checkBox.setVisibility(8);
                    } else {
                        x.i("MicroMsg.CardAcceptView", "updateFollowBox() show followbox");
                        checkBox.setVisibility(0);
                        xk xkVar = this.htQ.awm().roa;
                        if (xkVar == null || TextUtils.isEmpty(xkVar.text)) {
                            checkBox.setText(ayC.awL().title);
                        } else {
                            checkBox.setText(xkVar.text);
                        }
                        checkBox.setChecked(ayC.awL().hvk);
                        checkBox.setOnClickListener(new 1(this, ayC));
                    }
                } else if (this.htQ.avU() || this.htQ.avS() || this.htQ.avV()) {
                    e = l.cm(l.xV(this.htQ.awm().dxh), dimensionPixelSize);
                    cm = l.cm(l.bc(this.htQ.awm().dxh, 175), dimensionPixelSize);
                    stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{16842919}, cm);
                    stateListDrawable.addState(new int[0], e);
                    button.setBackgroundDrawable(stateListDrawable);
                    button.setTextColor(this.gKS.getResources().getColor(a.white_text_color_selector));
                    layoutParams2 = (LayoutParams) button.getLayoutParams();
                    layoutParams2.width = -1;
                    button.setLayoutParams(layoutParams2);
                } else {
                    e = l.cm(l.xV(this.htQ.awm().dxh), dimensionPixelSize);
                    cm = l.cm(l.bc(this.htQ.awm().dxh, 175), dimensionPixelSize);
                    stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{16842919}, cm);
                    stateListDrawable.addState(new int[0], e);
                    button.setBackgroundDrawable(stateListDrawable);
                    button.setTextColor(this.gKS.getResources().getColor(a.white_text_color_selector));
                }
            } else {
                this.hHn.setEnabled(false);
                findViewById.setEnabled(false);
                button.setEnabled(false);
                button.setText(this.htQ.avT() ? this.htQ.awm().rnP : this.hHp.aza());
                if (this.htQ.avT()) {
                    button.setTextColor(l.bc(this.htQ.awm().dxh, 125));
                    button.setBackgroundDrawable(l.e(this.gKS, l.bc(this.htQ.awm().dxh, 125), dimensionPixelSize));
                    layoutParams = (LayoutParams) this.hHn.getLayoutParams();
                    layoutParams.topMargin = this.gKS.getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.card_card_accept_layout_top_margin_for_member_unacceptable);
                    this.hHn.setLayoutParams(layoutParams);
                    this.hHn.findViewById(d.divider_line).setVisibility(8);
                } else if (this.htQ.avU() || this.htQ.avS() || this.htQ.avV()) {
                    button.setTextColor(this.gKS.getResources().getColor(a.grey_background_text_color));
                    button.setBackgroundDrawable(l.A(this.gKS, this.gKS.getResources().getColor(a.card_accept_btn_disable_bg_color)));
                    layoutParams2 = (LayoutParams) button.getLayoutParams();
                    layoutParams2.width = -1;
                    button.setLayoutParams(layoutParams2);
                } else {
                    button.setTextColor(this.gKS.getResources().getColor(a.grey_background_text_color));
                    button.setBackgroundDrawable(l.A(this.gKS, this.gKS.getResources().getColor(a.card_accept_btn_disable_bg_color)));
                }
            }
            if (!this.htQ.avU() && !this.htQ.avS()) {
                if (this.htQ.awm().rob != null && !bi.oW(this.htQ.awm().rob.text)) {
                    if (this.hHo == null) {
                        this.hHo = (TextView) this.hHn.findViewById(d.card_accept_guidance_tv);
                    }
                    this.hHo.setText(this.htQ.awm().rob.text);
                    if (!bi.oW(this.htQ.awm().rob.url)) {
                        this.hHo.setOnClickListener(this.hHF.ayy());
                        this.hHo.setTextColor(l.xV(this.htQ.awm().dxh));
                    }
                    this.hHo.setVisibility(0);
                    return;
                } else if (this.hHo != null) {
                    this.hHo.setVisibility(8);
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        x.i("MicroMsg.CardAcceptView", "updateAcceptView(), mAcceptCardView is Gone");
        this.hHn.setVisibility(8);
    }

    public final void azI() {
        this.hHn.setVisibility(8);
    }
}
