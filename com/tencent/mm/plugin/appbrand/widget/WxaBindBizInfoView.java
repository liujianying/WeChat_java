package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ac.m;
import com.tencent.mm.bp.a;
import com.tencent.mm.modelappbrand.b.b;
import com.tencent.mm.modelappbrand.b.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public class WxaBindBizInfoView extends LinearLayout {
    private static int gEW = a.fromDPToPix(ad.getContext(), 15);
    private static int gEX = a.fromDPToPix(ad.getContext(), 30);
    public List<WxaEntryInfo> gEP;
    private View gEQ;
    private ImageView gER;
    private TextView gES;
    private LinearLayout gET;
    private ViewGroup gEU;
    private View gEV;
    private TextView gsY;

    public WxaBindBizInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public WxaBindBizInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.gEP = new LinkedList();
        View inflate = View.inflate(getContext(), h.app_brand_profile_wxa_bind_biz_info_item, this);
        this.gEQ = inflate.findViewById(g.firstItemV);
        this.gER = (ImageView) inflate.findViewById(g.iconIv);
        this.gsY = (TextView) inflate.findViewById(g.titleTv);
        this.gES = (TextView) inflate.findViewById(g.countTv);
        this.gEV = inflate.findViewById(g.moreV);
        this.gET = (LinearLayout) inflate.findViewById(g.containerV);
        this.gEU = (ViewGroup) inflate.findViewById(g.itemContainerV);
    }

    public final void dj(boolean z) {
        if (this.gEU.getMeasuredWidth() != 0) {
            WxaEntryInfo wxaEntryInfo;
            if (this.gEP.isEmpty()) {
                setVisibility(8);
                wxaEntryInfo = null;
            } else {
                setVisibility(0);
                wxaEntryInfo = (WxaEntryInfo) this.gEP.get(0);
            }
            if (wxaEntryInfo != null) {
                a(wxaEntryInfo, this.gER, this.gsY);
            }
            this.gES.setText(getContext().getString(j.contact_info_bind_weapp_count, new Object[]{Integer.valueOf(this.gEP.size())}));
            List list = this.gEP;
            this.gET.removeAllViews();
            if (!list.isEmpty()) {
                int size = list.size();
                int measuredWidth = (this.gEU.getMeasuredWidth() - this.gEU.getPaddingLeft()) - this.gEU.getPaddingRight();
                int i = measuredWidth / (gEX + gEW);
                if (i > size) {
                    this.gEV.setVisibility(8);
                } else {
                    this.gEV.setVisibility(0);
                    i = (measuredWidth - this.gEV.getMeasuredWidth()) / (gEX + gEW);
                }
                measuredWidth = Math.min(i, size);
                if (measuredWidth > 1) {
                    for (size = 0; size < measuredWidth; size++) {
                        wxaEntryInfo = (WxaEntryInfo) list.get(size);
                        View imageView = new ImageView(getContext());
                        imageView.setLayoutParams(new LayoutParams(gEX + gEW, gEX));
                        imageView.setPadding(0, 0, gEW, 0);
                        this.gET.addView(imageView);
                        a(wxaEntryInfo, imageView, null);
                    }
                }
                x.i("MicroMsg.WxaBindBizInfoView", "attachItemToContainer(size : %s)", new Object[]{Integer.valueOf(list.size())});
            }
            if (this.gEP.size() == 1) {
                this.gEQ.setVisibility(0);
                this.gEU.setTag(((WxaEntryInfo) this.gEP.get(0)).username);
                return;
            }
            this.gEQ.setVisibility(8);
            this.gEU.setTag(null);
        } else if (z) {
            getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                public final boolean onPreDraw() {
                    WxaBindBizInfoView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                    WxaBindBizInfoView.this.dj(false);
                    return true;
                }
            });
        }
    }

    private static void a(WxaEntryInfo wxaEntryInfo, ImageView imageView, TextView textView) {
        if (wxaEntryInfo != null) {
            String str = wxaEntryInfo.username;
            if (imageView != null) {
                imageView.setTag(str);
                Bitmap kV = m.kV(wxaEntryInfo.username);
                if (kV == null || kV.isRecycled()) {
                    b.Ka().a(imageView, wxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.b.a.JZ(), f.dGr);
                } else {
                    imageView.setImageBitmap(kV);
                }
            }
            if (textView != null) {
                textView.setText(bi.oV(wxaEntryInfo.title));
            }
        }
    }

    public List<WxaEntryInfo> getWxaEntryInfoList() {
        return this.gEP;
    }
}
