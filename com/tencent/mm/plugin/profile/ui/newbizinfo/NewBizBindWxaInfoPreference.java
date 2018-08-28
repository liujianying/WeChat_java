package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.bp.a;
import com.tencent.mm.modelappbrand.b.b;
import com.tencent.mm.modelappbrand.b.b.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.List;

public class NewBizBindWxaInfoPreference extends Preference {
    private static final int gzI = a.fromDPToPix(ad.getContext(), 25);
    private static final int gzJ = a.fromDPToPix(ad.getContext(), 20);
    private static final int gzK = a.fromDPToPix(ad.getContext(), 2);
    private Context context;
    private AppBrandNearbyShowcaseView gBd;
    private View gBe;
    private boolean gBg = false;
    List<WxaEntryInfo> gEP;
    private ThreeDotsLoadingView gtb;
    private f gzY;
    private OnClickListener iDo;
    private OnClickListener lUh;
    d lUs;
    private View mView = null;

    public NewBizBindWxaInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public NewBizBindWxaInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }

    private void init() {
        this.iDo = new 1(this);
        this.lUh = new 2(this);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.gBe = view.findViewById(R.h.new_bizinfo_loading_icon_layout);
        this.gtb = (ThreeDotsLoadingView) view.findViewById(R.h.new_bizinfo_loading_view);
        this.gBd = (AppBrandNearbyShowcaseView) view.findViewById(R.h.new_bizinfo_loading_icon_view);
        this.gBd.setIconSize(gzI + (gzK * 2));
        this.gBd.setIconGap(gzJ);
        hy();
    }

    public final void hy() {
        if (this.gtb == null) {
            x.i("MicroMsg.NewBizBindWxaInfoPreference", "startLoad or mLoadingView is null");
        } else if (this.gBg) {
            x.i("MicroMsg.NewBizBindWxaInfoPreference", "startLoad has load.");
        } else {
            this.gBg = true;
            bN(this.gBe);
            b(this.gtb, null);
            this.gtb.cAG();
            if (this.lUs == null || this.gEP == null) {
                x.w("MicroMsg.NewBizBindWxaInfoPreference", "mWxaEntryInfoList or bizInfo is null, return");
                return;
            }
            this.gtb.cAH();
            bN(this.gtb);
            if (this.gEP.size() > 0) {
                this.gBd.setVisibility(0);
                this.gBd.setIconLayerCount(Math.min(this.gEP.size(), 4));
                boolean z = this.gBe.getVisibility() != 0;
                if (z) {
                    this.gBd.aoT();
                }
                if (this.gzY == null) {
                    this.gzY = new com.tencent.mm.plugin.appbrand.ui.widget.a(gzI, gzK);
                }
                int i = 0;
                while (i < this.gBd.getChildCount()) {
                    b.Ka().a(this.gBd.lT(i), this.gEP.size() > i ? ((WxaEntryInfo) this.gEP.get(i)).iconUrl : null, com.tencent.mm.modelappbrand.b.a.JZ(), this.gzY);
                    i++;
                }
                b(this.gBe, new 3(this, z));
                if (this.gEP.size() == 1) {
                    this.mView.setTag(((WxaEntryInfo) this.gEP.get(0)).username);
                    this.mView.setOnClickListener(this.iDo);
                    return;
                }
                this.mView.setTag(null);
                this.mView.setOnClickListener(this.lUh);
                return;
            }
            this.gBd.setVisibility(8);
        }
    }

    private static void b(View view, Runnable runnable) {
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.animate().setDuration(200).alpha(1.0f).withEndAction(runnable).start();
    }

    private void bN(View view) {
        if (view.getVisibility() == 0) {
            view.animate().setDuration(200).alpha(0.0f).withEndAction(new 4(this, view)).start();
        }
    }
}
