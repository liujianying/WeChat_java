package com.tencent.mm.plugin.appbrand.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.s$j;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.sdk.e.j.a;
import java.lang.reflect.Field;
import java.util.ArrayList;

public final class AppBrandStarListUI$a extends Fragment {
    private View gvK;
    private RecyclerView gvL;
    private e gvM;
    private GridLayoutManager gvN;
    private View gvO;
    private TextView gvP;
    boolean gvQ = false;
    final ArrayList<k> gvR = new ArrayList(10);
    private final a gvS = new 1(this);
    private c gvT = c.gwg;

    static /* synthetic */ void b(AppBrandStarListUI$a appBrandStarListUI$a) {
        if (appBrandStarListUI$a.gvK != null && appBrandStarListUI$a.gvN != null) {
            int width = appBrandStarListUI$a.gvK.getWidth() / com.tencent.mm.bp.a.ad(appBrandStarListUI$a.getActivity(), e.app_brand_star_list_item_width);
            if (width != appBrandStarListUI$a.gvN.Ov) {
                appBrandStarListUI$a.gvN.bb(width);
                appBrandStarListUI$a.gvN.requestLayout();
            }
        }
    }

    static /* synthetic */ void g(AppBrandStarListUI$a appBrandStarListUI$a) {
        appBrandStarListUI$a.gvQ = true;
        appBrandStarListUI$a.gvK.post(new 2(appBrandStarListUI$a));
    }

    final void a(c cVar) {
        this.gvT = cVar;
        if (this.gvM != null) {
            this.gvM.b(0, this.gvR.size(), cVar.tag);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gvK = layoutInflater.inflate(h.app_brand_star_list_ui, null);
        this.gvL = (RecyclerView) this.gvK.findViewById(g.star_list_recycler_view);
        getActivity();
        this.gvN = new GridLayoutManager();
        this.gvM = new e(this);
        this.gvL.a(new d(this));
        this.gvL.setItemAnimator(new 3(this));
        this.gvL.setLayoutManager(this.gvN);
        this.gvL.setAdapter(this.gvM);
        this.gvO = this.gvK.findViewById(g.star_list_footer);
        this.gvP = (TextView) this.gvK.findViewById(g.star_list_full_size_tip_text);
        this.gvK.post(new 4(this));
        com.tencent.mm.plugin.appbrand.app.e.abh().a(this.gvS, c.Em().lnJ.getLooper());
        return this.gvK;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        com.tencent.mm.plugin.appbrand.app.e.abh().d(this.gvS);
        try {
            for (Field field : getClass().getFields()) {
                if (field.isAccessible()) {
                    field.set(this, null);
                }
            }
        } catch (Exception e) {
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.gvK != null) {
            ViewTreeObserver viewTreeObserver = this.gvK.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new 5(this, viewTreeObserver));
            }
        }
    }

    /* renamed from: anz */
    final void a() {
        if (this.gvP != null && this.gvO != null) {
            if (this.gvR.size() >= 10) {
                this.gvO.setVisibility(0);
                this.gvP.setText(getResources().getString(s$j.app_brand_star_list_full_size_tip, new Object[]{Integer.valueOf(10)}));
                return;
            }
            this.gvO.setVisibility(8);
        }
    }
}
