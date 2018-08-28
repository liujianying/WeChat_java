package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.protocal.c.bwx;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public final class b extends a {
    private final String TAG = "MicroMsg.CardWidgetCommon";
    protected TextView eGX;
    private boolean hHc = false;
    protected TextView hJe;
    protected TextView hJf;
    protected Button hJg;
    protected LinearLayout hJh;
    protected TextView hJi;
    protected ImageView hJj;
    protected View hJk;
    protected ImageView hJl;

    public b(Context context) {
        super(context);
    }

    protected final void azZ() {
        this.eGX = (TextView) this.hJb.findViewById(d.card_title);
        this.hJe = (TextView) this.hJb.findViewById(d.card_subtitle);
        this.hJf = (TextView) this.hJb.findViewById(d.card_auxtitle);
        this.hJg = (Button) this.hJb.findViewById(d.card_consume_btn);
        this.hJh = (LinearLayout) this.hJb.findViewById(d.widget_body);
        this.hJj = (ImageView) this.hJh.findViewById(d.app_small_logo);
        this.hJk = this.hJb.findViewById(d.card_bottom_dash_divider);
        this.hJl = (ImageView) this.hJb.findViewById(d.card_code_img);
        this.hJi = (TextView) this.hJb.findViewById(d.card_operate_field_aux_title_tv);
    }

    protected final void aAa() {
        if (this.htQ.awm().rnG != null && this.htQ.awm().rnG.size() > 0) {
            pr prVar = (pr) this.htQ.awm().rnG.get(0);
            if (!bi.oW(prVar.title)) {
                this.eGX.setText(prVar.title);
            }
            if (bi.oW(prVar.huX)) {
                this.hJe.setVisibility(8);
            } else {
                this.hJe.setText(prVar.huX);
                this.hJe.setVisibility(0);
            }
            LayoutParams layoutParams = (LayoutParams) this.hJe.getLayoutParams();
            if (bi.oW(prVar.huY)) {
                this.hJf.setVisibility(8);
                layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.LargerPadding);
            } else {
                this.hJf.setText(prVar.huY);
                this.hJf.setVisibility(0);
                layoutParams.bottomMargin = 0;
            }
            this.hJe.setLayoutParams(layoutParams);
            this.hJe.invalidate();
        }
        if (this.hJg == null || this.hJl == null) {
            x.e("MicroMsg.CardWidgetCommon", "consumeBtn == null || mCardCodeImg == null");
        } else if (this.htQ.awn() == null) {
            x.e("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo() == null");
            this.hJg.setVisibility(8);
            this.hJl.setVisibility(8);
        } else {
            if (this.htQ.awn().rnk != null) {
                x.i("MicroMsg.CardWidgetCommon", "operate_field.title is " + this.htQ.awn().rnk.title);
                x.d("MicroMsg.CardWidgetCommon", "operate_field.url is " + this.htQ.awn().rnk.url);
                x.i("MicroMsg.CardWidgetCommon", "operate_field.aux_title is " + this.htQ.awn().rnk.huY);
            }
            pr prVar2 = this.htQ.awn().rnl;
            if (prVar2 != null) {
                x.i("MicroMsg.CardWidgetCommon", "limit_field.title is " + prVar2.title);
                x.i("MicroMsg.CardWidgetCommon", "limit_field.show_flag is " + prVar2.roL);
                x.i("MicroMsg.CardWidgetCommon", "limit_field.aux_title is " + prVar2.huY);
            }
            bwx bwx = this.htQ.awm().rnZ;
            LinearLayout linearLayout = (LinearLayout) this.hJh.findViewById(d.card_detail_field_layout);
            if (bwx == null || bi.cX(bwx.stl)) {
                linearLayout.setVisibility(8);
            } else {
                linearLayout.setVisibility(0);
                linearLayout.removeAllViews();
                Iterator it = bwx.stl.iterator();
                while (it.hasNext()) {
                    pr prVar3 = (pr) it.next();
                    View inflate = LayoutInflater.from(this.mContext).inflate(e.card_detail_field_item, null);
                    TextView textView = (TextView) inflate.findViewById(d.card_detail_field_dec);
                    ((TextView) inflate.findViewById(d.card_detail_field_title)).setText(prVar3.title);
                    textView.setText(prVar3.huX);
                    linearLayout.addView(inflate);
                }
            }
            if (prVar2 != null && !TextUtils.isEmpty(prVar2.title) && prVar2.roL != 0 && this.htQ.awi()) {
                this.hJg.setClickable(false);
                this.hJg.setVisibility(0);
                this.hJg.setTextColor(this.mContext.getResources().getColor(a.white_text_color_selector));
                this.hJg.setText(prVar2.title);
                if (prVar2 == null || TextUtils.isEmpty(prVar2.huX)) {
                    this.hJi.setVisibility(8);
                } else {
                    this.hJi.setText(prVar2.huX);
                    this.hJi.setVisibility(0);
                }
                this.hJl.setVisibility(8);
                if ((prVar2.roL & 2) > 0) {
                    this.hJg.setBackgroundDrawable(l.A(this.mContext, l.bc(this.htQ.awm().dxh, 150)));
                    this.hJi.setTextColor(l.xV(this.htQ.awm().dxh));
                } else if ((prVar2.roL & 4) > 0) {
                    this.hJg.setBackgroundDrawable(l.A(this.mContext, this.mContext.getResources().getColor(a.light_grey)));
                    this.hJi.setTextColor(this.mContext.getResources().getColor(a.normal_color));
                } else {
                    this.hJg.setBackgroundDrawable(l.A(this.mContext, l.xV(this.htQ.awm().dxh)));
                    this.hJi.setTextColor(this.mContext.getResources().getColor(a.normal_color));
                }
            } else if (this.htQ.awn().rnk != null && !TextUtils.isEmpty(this.htQ.awn().rnk.title) && !TextUtils.isEmpty(this.htQ.awn().rnk.url) && this.htQ.awi()) {
                this.hJg.setClickable(true);
                this.hJg.setVisibility(0);
                this.hJg.setBackgroundDrawable(l.A(this.mContext, l.xV(this.htQ.awm().dxh)));
                this.hJg.setTextColor(this.mContext.getResources().getColorStateList(a.white_text_color_selector));
                this.hJg.setText(this.htQ.awn().rnk.title);
                if (this.htQ.awn().rnk == null || TextUtils.isEmpty(this.htQ.awn().rnk.huY)) {
                    this.hJi.setVisibility(8);
                } else {
                    this.hJi.setTextColor(this.mContext.getResources().getColor(a.normal_color));
                    this.hJi.setText(this.htQ.awn().rnk.huY);
                    this.hJi.setVisibility(0);
                }
                if (TextUtils.isEmpty(this.htQ.awn().code)) {
                    this.hJl.setVisibility(8);
                } else {
                    this.hJl.setVisibility(0);
                }
            } else if (!TextUtils.isEmpty(this.htQ.awn().code) && this.htQ.awi()) {
                x.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().code is valid");
                this.hJl.setVisibility(8);
                this.hJi.setVisibility(8);
                this.hJg.setClickable(true);
                this.hJg.setVisibility(0);
                this.hJg.setBackgroundDrawable(l.A(this.mContext, l.xV(this.htQ.awm().dxh)));
                this.hJg.setTextColor(this.mContext.getResources().getColorStateList(a.white_text_color_selector));
                this.hJg.setText(g.card_state_normal);
            } else if (this.htQ.awi()) {
                x.i("MicroMsg.CardWidgetCommon", "operate_field and code is empty!");
                this.hJg.setVisibility(8);
                this.hJi.setVisibility(8);
                this.hJl.setVisibility(8);
            } else {
                x.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().status is " + this.htQ.awn().status);
                this.hJl.setVisibility(8);
                this.hJi.setVisibility(8);
                this.hJg.setClickable(true);
                this.hJg.setVisibility(0);
                this.hJg.setTextColor(this.mContext.getResources().getColor(a.grey_background_text_color));
                this.hJg.setBackgroundDrawable(l.A(this.mContext, this.mContext.getResources().getColor(a.card_accept_btn_disable_bg_color)));
                if (TextUtils.isEmpty(this.htQ.awm().roe)) {
                    m.b(this.hJg, this.htQ.awn().status);
                } else {
                    this.hJg.setText(this.htQ.awm().roe);
                }
            }
        }
        aAb();
        this.hJh.setBackgroundDrawable(this.mContext.getResources().getDrawable(c.card_white_top_bg));
        aAc();
        this.hJb.invalidate();
    }

    private void aAb() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hJh.getLayoutParams();
        if (this.htQ.avR()) {
            this.hJc.setVisibility(0);
            this.hJj.setVisibility(8);
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.card_coupon_widget_body_top_margin);
        } else if (this.htQ.avS() && this.hHc) {
            this.hJc.setVisibility(8);
            this.hJj.setVisibility(8);
            layoutParams.topMargin = 0;
        } else if (this.htQ.avS()) {
            this.hJc.setVisibility(0);
            this.hJj.setVisibility(8);
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.card_coupon_widget_body_top_margin);
        }
        this.hJh.setLayoutParams(layoutParams);
    }

    public final void oc(int i) {
        RelativeLayout.LayoutParams layoutParams;
        this.hJh.setBackgroundResource(i);
        this.hJj.setVisibility(8);
        if (i == 0) {
            layoutParams = (RelativeLayout.LayoutParams) this.hJh.getLayoutParams();
            if (this.htQ.avR()) {
                this.hJc.setVisibility(8);
                layoutParams.topMargin = 0;
                this.hJj.setVisibility(0);
                m.a(this.hJj, this.htQ.awm().huW, this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.card_app_small_logo_height), c.my_card_package_defaultlogo, false);
            } else if (this.htQ.avS() && this.hHc) {
                this.hJc.setVisibility(8);
                layoutParams.topMargin = 0;
            }
            this.hJh.setLayoutParams(layoutParams);
            this.hJh.invalidate();
        } else {
            aAb();
        }
        aAc();
        layoutParams = (RelativeLayout.LayoutParams) this.hJk.getLayoutParams();
        if (i == 0) {
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        } else {
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.BiggerPadding);
            layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.BiggerPadding);
        }
        this.hJk.setLayoutParams(layoutParams);
        this.hJk.invalidate();
        this.hJb.invalidate();
    }

    private void aAc() {
        LayoutParams layoutParams = (LayoutParams) this.hJg.getLayoutParams();
        if (this.htQ.awn().rnk != null && !TextUtils.isEmpty(this.htQ.awn().rnk.huY)) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.card.a.b.NormalPadding);
        } else if (this.htQ.awn().rnl != null && !TextUtils.isEmpty(this.htQ.awn().rnl.huX)) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.card.a.b.NormalPadding);
        } else if (this.htQ.awm().rnG == null || this.htQ.awm().rnG.size() <= 0) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.card.a.b.LargerPadding);
        } else {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.card.a.b.NormalPadding);
        }
        this.hJg.setLayoutParams(layoutParams);
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        if (this.hJg != null) {
            this.hJg.setOnClickListener(onClickListener);
        }
        if (this.hJl != null) {
            this.hJl.setOnClickListener(onClickListener);
        }
    }

    public final void v(boolean z, boolean z2) {
        if (this.hJg != null) {
            pr prVar = this.htQ.awn().rnl;
            if (prVar != null && !TextUtils.isEmpty(prVar.title) && prVar.roL != 0 && this.htQ.awi()) {
                this.hJg.setClickable(false);
                this.hJg.setVisibility(0);
                this.hJl.setVisibility(8);
            } else if (this.htQ.awn().rnk != null && !TextUtils.isEmpty(this.htQ.awn().rnk.title) && !TextUtils.isEmpty(this.htQ.awn().rnk.url) && this.htQ.awi()) {
                this.hJg.setVisibility(0);
                this.hJg.setEnabled(true);
                if (TextUtils.isEmpty(this.htQ.awn().code) || this.htQ.awn().rnc == 0) {
                    this.hJl.setVisibility(8);
                } else {
                    this.hJl.setVisibility(0);
                }
            } else if (z && !TextUtils.isEmpty(this.htQ.awn().code) && this.htQ.awi()) {
                this.hJg.setVisibility(0);
                this.hJg.setEnabled(z2);
                this.hJl.setVisibility(8);
            } else if (!z || this.htQ.awi()) {
                this.hJg.setVisibility(8);
                this.hJl.setVisibility(8);
            } else {
                this.hJg.setVisibility(0);
                this.hJg.setEnabled(false);
                this.hJl.setVisibility(8);
            }
        }
    }

    public final void aAd() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hJh.getLayoutParams();
        if (this.htQ.avS()) {
            this.hJc.setVisibility(0);
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.card_coupon_widget_body_top_margin);
        }
        this.hJh.setLayoutParams(layoutParams);
        this.hJh.invalidate();
    }

    public final void dW(boolean z) {
        this.hHc = z;
        if (z) {
            this.hJk.setVisibility(0);
        } else {
            this.hJk.setVisibility(8);
        }
    }
}
