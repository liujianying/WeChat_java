package com.tencent.mm.plugin.appbrand.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.b.a;
import com.tencent.mm.modelappbrand.b.b$f;
import com.tencent.mm.plugin.appbrand.compat.n;
import com.tencent.mm.plugin.appbrand.q.b;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.LinkedList;

public class AppBrandLoadIconPreference extends Preference {
    private AppBrandNearbyShowcaseView gBd;
    private View gBe;
    public String gBf;
    private boolean gBg = false;
    private int gBh = -1;
    private LinkedList<d> gBi = new LinkedList();
    private ThreeDotsLoadingView gtb;
    private int gzI;
    private int gzJ;
    private int gzK;
    private final int gzL = -1;
    private b$f gzY;
    private Context mContext;
    private View mView = null;

    static /* synthetic */ void a(AppBrandLoadIconPreference appBrandLoadIconPreference) {
        b.reset();
        b.a(appBrandLoadIconPreference.gBf, new 2(appBrandLoadIconPreference));
    }

    static /* synthetic */ void b(AppBrandLoadIconPreference appBrandLoadIconPreference) {
        int i = 0;
        appBrandLoadIconPreference.gtb.cAH();
        appBrandLoadIconPreference.bN(appBrandLoadIconPreference.gtb);
        if (appBrandLoadIconPreference.gBi.size() > 0) {
            appBrandLoadIconPreference.gBd.setVisibility(0);
            appBrandLoadIconPreference.gBd.setIconLayerCount(Math.min(appBrandLoadIconPreference.gBi.size(), 3));
            boolean z = appBrandLoadIconPreference.gBe.getVisibility() != 0;
            if (z) {
                appBrandLoadIconPreference.gBd.aoT();
            }
            if (appBrandLoadIconPreference.gzY == null) {
                appBrandLoadIconPreference.gzY = new a(appBrandLoadIconPreference.gzI, appBrandLoadIconPreference.gzK);
            }
            while (true) {
                int i2 = i;
                if (i2 < appBrandLoadIconPreference.gBd.getChildCount()) {
                    com.tencent.mm.modelappbrand.b.b.Ka().a(appBrandLoadIconPreference.gBd.lT(i2), appBrandLoadIconPreference.gBi.size() > i2 ? ((d) appBrandLoadIconPreference.gBi.get(i2)).imagePath : null, a.JZ(), appBrandLoadIconPreference.gzY);
                    i = i2 + 1;
                } else {
                    b(appBrandLoadIconPreference.gBe, new 3(appBrandLoadIconPreference, z));
                    return;
                }
            }
        }
        appBrandLoadIconPreference.gBd.setVisibility(8);
    }

    public AppBrandLoadIconPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cK(context);
    }

    public AppBrandLoadIconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        cK(context);
    }

    private void cK(Context context) {
        setLayoutResource(n.b.appbrand_load_icon_preference);
        this.mContext = context;
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
        this.gzI = com.tencent.mm.bp.a.fromDPToPix(this.mContext, 21);
        this.gzJ = com.tencent.mm.bp.a.fromDPToPix(this.mContext, 11);
        this.gzK = com.tencent.mm.bp.a.fromDPToPix(this.mContext, 2);
        this.gBe = view.findViewById(n.a.app_brand_loading_icon_layout);
        this.gtb = (ThreeDotsLoadingView) view.findViewById(n.a.app_brand_loading_view);
        this.gBd = (AppBrandNearbyShowcaseView) view.findViewById(n.a.app_brand_loading_icon_view);
        this.gBd.setIconSize(this.gzI + (this.gzK * 2));
        this.gBd.setIconGap(this.gzJ);
        if (this.gBf == null || this.gtb == null) {
            x.i("MicroMsg.AppBrandLoadIconPreference", "startLoad mTalker or mLoadingView is null");
        } else if (this.gBg) {
            x.i("MicroMsg.AppBrandLoadIconPreference", "startLoad has load.");
        } else {
            this.gBg = true;
            bN(this.gBe);
            b(this.gtb, null);
            this.gtb.cAG();
            g.Em().H(new 1(this));
        }
    }

    public static void onDestroy() {
        b.reset();
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
