package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public abstract class a implements g {
    protected LayoutInflater Bc;
    private final String TAG = "MicroMsg.CardWidgetCouponBase";
    protected OnClickListener eZF;
    protected View hJb;
    protected ImageView hJc;
    protected TextView hJd;
    protected b htQ;
    protected Context mContext;

    protected abstract void aAa();

    protected abstract void azZ();

    public a(Context context) {
        this.mContext = context;
    }

    public final void k(b bVar) {
        this.htQ = bVar;
    }

    public final View azX() {
        if (this.htQ == null || this.htQ.awm() == null) {
            x.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
            return null;
        }
        int i;
        this.Bc = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        LayoutInflater layoutInflater = this.Bc;
        if (!this.htQ.avU()) {
            if (this.htQ.avV()) {
                i = e.card_ticket;
            } else if (this.htQ.avT()) {
                i = e.card_membership;
            } else if (this.htQ.avW()) {
                i = e.card_enterpricecash;
            } else if (this.htQ.avX()) {
                i = e.card_invoice;
            }
            this.hJb = layoutInflater.inflate(i, null);
            this.hJc = (ImageView) this.hJb.findViewById(d.app_logo);
            this.hJd = (TextView) this.hJb.findViewById(d.app_name);
            azZ();
            aoV();
            return this.hJb;
        }
        i = e.card_coupon;
        this.hJb = layoutInflater.inflate(i, null);
        this.hJc = (ImageView) this.hJb.findViewById(d.app_logo);
        this.hJd = (TextView) this.hJb.findViewById(d.app_name);
        azZ();
        aoV();
        return this.hJb;
    }

    private void aoV() {
        if (this.htQ == null || this.htQ.awm() == null) {
            x.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
            return;
        }
        if (!bi.oW(this.htQ.awm().huW)) {
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.card_detail_ui_logo_height);
            if (this.htQ.avR() && this.htQ.avU()) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.card_coupon_widget_logo_size);
            } else if (this.htQ.avR() && this.htQ.avT()) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.card_member_widget_logo_size);
            } else if (this.htQ.avR() && this.htQ.avV()) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.card_ticket_widget_logo_size);
            } else if (this.htQ.avX()) {
                dimensionPixelSize = 0;
            }
            if (dimensionPixelSize > 0) {
                m.a(this.hJc, this.htQ.awm().huW, dimensionPixelSize, c.my_card_package_defaultlogo, true);
            }
        }
        if (!bi.oW(this.htQ.awm().hwh)) {
            this.hJd.setText(this.htQ.awm().hwh);
        }
        aAa();
    }

    protected final View azY() {
        return this.hJb;
    }

    public final void release() {
        this.eZF = null;
        this.mContext = null;
    }

    public void oc(int i) {
    }

    public void dV(boolean z) {
    }

    public final void f(b bVar) {
        this.htQ = bVar;
        aoV();
    }

    public void a(ShapeDrawable shapeDrawable) {
    }

    public void dW(boolean z) {
    }

    public void v(boolean z, boolean z2) {
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.eZF = onClickListener;
    }
}
