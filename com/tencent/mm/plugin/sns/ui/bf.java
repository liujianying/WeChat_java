package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.c.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class bf {
    private String kCA = w.fD(ad.getContext());
    private LinearLayout ohj;
    public TextView ohk;
    public TextView ohl;
    private View ohm;
    private View ohn;
    public b oho;
    public a ohp;
    private View view;

    public final String bEC() {
        if (this.ohp == null) {
            return "";
        }
        if (this.ohp.ntU == null) {
            return "";
        }
        return this.ohp.ntU;
    }

    public final int[] bED() {
        int[] iArr = new int[2];
        if (this.ohj != null) {
            this.ohm.getLocationInWindow(iArr);
            iArr[0] = iArr[0] + this.ohm.getMeasuredWidth();
        } else if (this.ohm != null) {
            this.ohm.getLocationInWindow(iArr);
            iArr[0] = iArr[0] + this.ohm.getMeasuredWidth();
        }
        return iArr;
    }

    public bf(View view) {
        this.view = view;
        x.i("MicroMsg.TimeLineAdView", "adView init lan " + this.kCA);
        this.ohk = (TextView) this.view.findViewById(f.ad_info_tv);
        this.ohl = (TextView) this.view.findViewById(f.ad_link_tv);
        this.ohm = this.view.findViewById(f.ad_info_tv_arrow);
        this.ohn = this.view.findViewById(f.ad_lbs_icon_tv);
        this.ohj = (LinearLayout) this.view.findViewById(f.ad_info_ll);
        this.ohk.setText(" " + this.view.getResources().getString(j.sns_ad_tip) + " ");
    }

    public final void a(OnClickListener onClickListener, OnClickListener onClickListener2) {
        this.ohl.setOnClickListener(onClickListener);
        this.ohk.setOnClickListener(onClickListener2);
        if (this.ohm != null) {
            this.ohm.setOnClickListener(onClickListener2);
        }
        if (this.ohj != null) {
            this.ohj.setOnClickListener(onClickListener2);
        }
    }

    public final void r(Object obj, Object obj2) {
        this.ohl.setTag(obj);
        this.ohk.setTag(obj2);
        if (this.ohm != null) {
            this.ohm.setTag(obj2);
        }
        if (this.ohj != null) {
            this.ohj.setTag(obj2);
        }
    }

    public final void a(b bVar, a aVar) {
        Object imageSpan;
        this.ohp = aVar;
        this.oho = bVar;
        String str = "";
        if (bVar != null) {
            if ("zh_CN".equals(this.kCA)) {
                str = bVar.nyI;
            } else if ("zh_TW".equals(this.kCA) || "zh_HK".equals(this.kCA)) {
                str = bVar.nyK;
            } else {
                str = bVar.nyJ;
            }
        }
        if (bVar != null && bi.oW(r0)) {
            str = bVar.nyG;
        }
        Context context = this.ohl.getContext();
        if (bi.oW(str)) {
            str = context.getString(j.sns_ad_view_more);
        }
        str = str + " ";
        int length = str.length();
        CharSequence spannableString = new SpannableString(str + "ad_");
        Drawable drawable;
        if (aVar == null || !aVar.bzk()) {
            drawable = context.getResources().getDrawable(i.album_advertise_link_icon);
            drawable.setBounds(0, 0, (int) (((double) this.ohl.getTextSize()) * 1.3d), (int) (((double) this.ohl.getTextSize()) * 1.3d));
            imageSpan = new ImageSpan(drawable, 0);
        } else {
            drawable = context.getResources().getDrawable(i.album_ad_link_tag_weapp);
            drawable.setBounds(0, 0, (int) (((double) this.ohl.getTextSize()) * 0.8d), (int) (((double) this.ohl.getTextSize()) * 0.8d));
            imageSpan = new ImageSpan(drawable, 1);
        }
        if (!bi.oW(bVar.nyH)) {
            d.b("adId", bVar.nyH, false, 41, new 1(this, spannableString, length));
        }
        spannableString.setSpan(imageSpan, length, length + 3, 33);
        this.ohl.setText(spannableString);
        if (aVar == null || bi.oW(aVar.nyc)) {
            this.ohn.setVisibility(8);
        } else {
            this.ohn.setVisibility(0);
        }
        if (bVar != null) {
            CharSequence charSequence;
            if ("zh_CN".equals(this.kCA)) {
                charSequence = bVar.nyR;
            } else if ("zh_TW".equals(this.kCA) || "zh_HK".equals(this.kCA)) {
                charSequence = bVar.nyT;
            } else {
                charSequence = bVar.nyS;
            }
            if (!bi.oW(charSequence)) {
                this.ohk.setText(charSequence);
            }
        }
    }

    public final void setVisibility(int i) {
        int i2;
        if (this.oho == null || this.oho.nyF != 1) {
            this.ohl.setVisibility(i);
        } else {
            this.ohl.setVisibility(8);
        }
        com.tencent.mm.storage.a XE = c.Jy().XE("Sns_CanvasAd_DetailLink_JumpWay");
        if (XE.isValid()) {
            i2 = bi.getInt(XE.field_value, -1);
        } else {
            i2 = -1;
        }
        if (i2 != -1 && this.oho != null && this.oho.bzm() && e.Nf(this.oho.bVv)) {
            this.ohl.setVisibility(i);
        }
        this.ohk.setVisibility(i);
        if (this.ohm != null) {
            this.ohm.setVisibility(i);
        }
        if (this.ohj != null) {
            this.ohj.setVisibility(i);
        }
        if (this.ohp == null || bi.oW(this.ohp.nyc)) {
            this.ohn.setVisibility(8);
        } else {
            this.ohn.setVisibility(i);
        }
    }
}
