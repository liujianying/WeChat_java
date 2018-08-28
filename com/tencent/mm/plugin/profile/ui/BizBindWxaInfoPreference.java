package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.bp.a;
import com.tencent.mm.modelappbrand.b.b;
import com.tencent.mm.modelappbrand.b.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.List;

public class BizBindWxaInfoPreference extends Preference {
    private static DisplayMetrics gBr = ad.getContext().getResources().getDisplayMetrics();
    private static int gEW = a.fromDPToPix(ad.getContext(), 15);
    private static int gEX = ad.getResources().getDimensionPixelSize(R.f.NormalIconSize);
    d eXL;
    List<WxaEntryInfo> gEP;
    private View gEQ;
    private ImageView gER;
    private TextView gES;
    private LinearLayout gET;
    private ViewGroup gEU;
    private View gEV;
    private TextView gsY;
    private OnClickListener iDo;
    private volatile boolean lUf;
    volatile boolean lUg;
    private OnClickListener lUh;

    public BizBindWxaInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public BizBindWxaInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    protected final void onBindView(View view) {
        this.gEQ = view.findViewById(R.h.firstItemV);
        this.gER = (ImageView) view.findViewById(R.h.iconIv);
        this.gsY = (TextView) view.findViewById(R.h.titleTv);
        this.gES = (TextView) view.findViewById(R.h.countTv);
        this.gEV = view.findViewById(R.h.moreV);
        this.gET = (LinearLayout) view.findViewById(R.h.containerV);
        this.gEU = (ViewGroup) view.findViewById(R.h.itemContainerV);
        this.lUf = true;
        this.lUg = this.gEP != null;
        aeP();
        super.onBindView(view);
    }

    private void init() {
        this.iDo = new 1(this);
        this.lUh = new 2(this);
    }

    final void aeP() {
        if (this.lUf && this.gEP != null && this.lUg) {
            WxaEntryInfo wxaEntryInfo;
            this.lUg = false;
            if (this.gEP.isEmpty()) {
                wxaEntryInfo = null;
            } else {
                wxaEntryInfo = (WxaEntryInfo) this.gEP.get(0);
            }
            if (wxaEntryInfo != null) {
                a(wxaEntryInfo, this.gER, this.gsY);
            }
            this.gES.setText(this.mContext.getString(R.l.contact_info_bind_weapp_count, new Object[]{Integer.valueOf(this.gEP.size())}));
            List list = this.gEP;
            this.gET.removeAllViews();
            if (!list.isEmpty()) {
                int size = list.size();
                int measuredWidth = this.gEU.getMeasuredWidth();
                if (measuredWidth == 0) {
                    measuredWidth = gBr.widthPixels;
                }
                int paddingLeft = (measuredWidth - this.gEU.getPaddingLeft()) - this.gEU.getPaddingRight();
                measuredWidth = paddingLeft / (gEX + gEW);
                if (measuredWidth > size) {
                    this.gEV.setVisibility(8);
                } else {
                    this.gEV.setVisibility(0);
                    measuredWidth = (paddingLeft - this.gEV.getMeasuredWidth()) / (gEX + gEW);
                }
                paddingLeft = Math.min(measuredWidth, size);
                if (paddingLeft > 1) {
                    for (size = 0; size < paddingLeft; size++) {
                        wxaEntryInfo = (WxaEntryInfo) list.get(size);
                        View imageView = new ImageView(this.mContext);
                        imageView.setLayoutParams(new LayoutParams(gEX + gEW, gEX));
                        imageView.setPadding(0, 0, gEW, 0);
                        this.gET.addView(imageView);
                        a(wxaEntryInfo, imageView, null);
                    }
                }
                x.i("MicroMsg.BizBindWxaInfoPreference", "attachItemToContainer(size : %s)", new Object[]{Integer.valueOf(list.size())});
            }
            if (this.gEP.size() == 1) {
                this.gEQ.setVisibility(0);
                this.gEU.setTag(((WxaEntryInfo) this.gEP.get(0)).username);
                this.gEU.setOnClickListener(this.iDo);
                return;
            }
            this.gEQ.setVisibility(8);
            this.gEU.setTag(null);
            this.gEU.setOnClickListener(this.lUh);
        }
    }

    private static void a(WxaEntryInfo wxaEntryInfo, ImageView imageView, TextView textView) {
        if (wxaEntryInfo != null) {
            String str = wxaEntryInfo.username;
            if (imageView != null) {
                imageView.setTag(str);
                b.Ka().a(imageView, wxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.b.a.JZ(), f.dGr);
            }
            if (textView != null) {
                textView.setText(bi.oV(wxaEntryInfo.title));
            }
        }
    }
}
