package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.n.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.a;

class MenuAppBrandRecentView$1 implements a {
    final /* synthetic */ MenuAppBrandRecentView gPC;

    MenuAppBrandRecentView$1(MenuAppBrandRecentView menuAppBrandRecentView) {
        this.gPC = menuAppBrandRecentView;
    }

    public final boolean a(View view, a aVar, float f, float f2) {
        boolean a;
        if (MenuAppBrandRecentView.a(this.gPC) != null) {
            a = MenuAppBrandRecentView.a(this.gPC).a(view, aVar, f, f2);
        } else {
            a = false;
        }
        if (a) {
            return true;
        }
        if (aVar.type == 2) {
            ((d) g.l(d.class)).cN(this.gPC.getContext());
        } else {
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1090;
            ((d) g.l(d.class)).a(this.gPC.getContext(), aVar.gOT.username, null, aVar.gOT.fmv, -1, null, appBrandStatObject);
        }
        return false;
    }

    public final boolean b(View view, a aVar, float f, float f2) {
        if (MenuAppBrandRecentView.a(this.gPC) != null) {
            return MenuAppBrandRecentView.a(this.gPC).b(view, aVar, f, f2);
        }
        return false;
    }
}
