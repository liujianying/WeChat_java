package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.launching.precondition.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.a;
import com.tencent.mm.sdk.platformtools.ah;

class p$35 implements a {
    final /* synthetic */ p gnH;

    p$35(p pVar) {
        this.gnH = pVar;
    }

    public final boolean a(View view, com.tencent.mm.plugin.appbrand.widget.recentview.a aVar, float f, float f2) {
        ah.i(new 1(this), 100);
        if (aVar.type != 1) {
            return false;
        }
        LocalUsageInfo localUsageInfo = aVar.gOT;
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1090;
        appBrandStatObject.bGG = this.gnH.mAppId;
        g.ghE.a(this.gnH.mContext, localUsageInfo.username, null, null, localUsageInfo.fmv, -1, appBrandStatObject, null, null);
        return true;
    }

    public final boolean b(View view, com.tencent.mm.plugin.appbrand.widget.recentview.a aVar, float f, float f2) {
        return false;
    }
}
