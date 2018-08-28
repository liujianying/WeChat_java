package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.card.a$c;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends a {
    protected TextView eCm;
    private ImageView hJA;
    private ImageView hJB;
    private ImageView hJC;
    private ImageView hJD;
    private ImageView hJE;
    private RelativeLayout hJx;
    private TextView hJy;
    private View hJz;
    private LinearLayout hzi;

    public e(Context context) {
        super(context);
    }

    protected final void azZ() {
        this.eCm = (TextView) azY().findViewById(d.card_title);
        this.hJx = (RelativeLayout) azY().findViewById(d.card_membership_layout);
        this.hzi = (LinearLayout) azY().findViewById(d.card_code_layout);
        this.hJy = (TextView) azY().findViewById(d.code_text);
        this.hJz = azY().findViewById(d.card_code_click_view);
        this.hJA = (ImageView) azY().findViewById(d.card_code_img);
        this.hJB = (ImageView) this.hJb.findViewById(d.member_widget_bg_up);
        this.hJC = (ImageView) this.hJb.findViewById(d.member_widget_bg_down);
        this.hJD = (ImageView) this.hJb.findViewById(d.card_member_bg_img);
        this.hJE = (ImageView) this.hJb.findViewById(d.card_member_top_shadow_img);
    }

    protected final void aAa() {
        if (this.hJd != null) {
            this.hJd.setText(this.htQ.awm().hwh);
        }
        if (this.htQ.awm().rnG != null && this.htQ.awm().rnG.size() > 0) {
            pr prVar = (pr) this.htQ.awm().rnG.get(0);
            if (TextUtils.isEmpty(prVar.title)) {
                this.eCm.setText("");
            } else {
                this.eCm.setText(prVar.title);
            }
        }
        if (this.htQ.awi()) {
            dV(true);
            this.hJD.setAlpha(255);
            if (this.hJD.getBackground() != null) {
                this.hJD.getBackground().setAlpha(255);
            }
            String str = this.htQ.awn().code;
            if (!TextUtils.isEmpty(str)) {
                this.hJz.setOnClickListener(this.eZF);
                this.hJA.setOnClickListener(this.eZF);
                this.hJy.setOnClickListener(this.eZF);
                switch (this.htQ.awn().rnc) {
                    case 0:
                        if (str.length() > 40) {
                            this.hJy.setText("");
                            break;
                        } else {
                            this.hJy.setText(m.yd(str));
                            break;
                        }
                    case 1:
                    case 2:
                        if (str.length() <= 40) {
                            if (!this.htQ.awb()) {
                                this.hJy.setText("");
                                break;
                            } else {
                                this.hJy.setText(m.yd(str));
                                break;
                            }
                        }
                        this.hJy.setText("");
                        break;
                }
            }
            x.e("MicroMsg.CardWidgetMembership", "don't updateCodeLayout, code is empty!");
            dV(false);
        } else {
            this.hJy.setText("");
            this.hJA.setVisibility(8);
            this.hJz.setVisibility(8);
            this.hJD.setAlpha(90);
            if (this.hJD.getBackground() != null) {
                this.hJD.getBackground().setAlpha(90);
            }
        }
        LayoutParams layoutParams = this.hJx.getLayoutParams();
        layoutParams.height = ((this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mContext.getResources().getDimensionPixelSize(b.LargerPadding) * 2)) * 3) / 5;
        x.d("MicroMsg.CardWidgetMembership", "padding:%d,originWidth:%d,targetWidth:%d", new Object[]{Integer.valueOf(r1), Integer.valueOf(r2), Integer.valueOf(r3)});
        this.hJx.setLayoutParams(layoutParams);
    }

    public final void v(boolean z, boolean z2) {
    }

    public final void dV(boolean z) {
        if (TextUtils.isEmpty(this.htQ.awn().code) || !z || this.htQ.awn().rnc == 0 || this.htQ.awm().roo) {
            this.hJA.setVisibility(8);
            this.hJz.setVisibility(8);
            return;
        }
        this.hJA.setVisibility(0);
        this.hJz.setVisibility(0);
    }

    public final void oc(int i) {
        if (!TextUtils.isEmpty(this.htQ.awn().rnn)) {
            this.hJD.setBackgroundDrawable(null);
            this.hJE.setVisibility(0);
            aAe();
        } else if (this.hJb != null) {
            this.hJD.setBackgroundResource(i);
            this.hJE.setVisibility(8);
        }
    }

    public final void a(ShapeDrawable shapeDrawable) {
        if (!TextUtils.isEmpty(this.htQ.awn().rnn)) {
            this.hJD.setBackgroundDrawable(null);
            this.hJE.setVisibility(0);
            aAe();
        } else if (this.hJb != null) {
            this.hJD.setBackgroundDrawable(shapeDrawable);
            this.hJE.setVisibility(8);
        }
    }

    public final void dW(boolean z) {
        if (TextUtils.isEmpty(this.htQ.awn().rnn)) {
            this.hJC.setVisibility(0);
            this.hJB.setVisibility(0);
            return;
        }
        this.hJC.setVisibility(8);
        this.hJB.setVisibility(8);
    }

    private void aAe() {
        a aVar = new a();
        aVar.dXB = com.tencent.mm.compatible.util.e.bnE;
        o.Pk();
        aVar.dXU = null;
        aVar.dXA = com.tencent.mm.plugin.card.model.m.xr(this.htQ.awn().rnn);
        aVar.dXy = true;
        aVar.dXW = true;
        aVar.dXX = (float) this.mContext.getResources().getDimensionPixelSize(b.card_member_widget_bg_big_round_radius);
        aVar.dXY = true;
        aVar.dXw = true;
        aVar.dXN = a$c.card_widget_member_bg;
        aVar.dXF = com.tencent.mm.bp.a.ad(this.mContext, b.card_member_widget_layout_height);
        aVar.dXE = com.tencent.mm.bp.a.fk(this.mContext);
        o.Pj().a(this.htQ.awn().rnn, this.hJD, aVar.Pt());
        x.i("MicroMsg.CardWidgetMembership", "the member back ground url is " + this.htQ.awn().rnn);
    }
}
