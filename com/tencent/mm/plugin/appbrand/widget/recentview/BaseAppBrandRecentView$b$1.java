package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.b;

class BaseAppBrandRecentView$b$1 implements OnClickListener {
    final /* synthetic */ BaseAppBrandRecentView gPr;
    final /* synthetic */ b gPs;

    BaseAppBrandRecentView$b$1(b bVar, BaseAppBrandRecentView baseAppBrandRecentView) {
        this.gPs = bVar;
        this.gPr = baseAppBrandRecentView;
    }

    public final void onClick(View view) {
        a aVar = (a) view.getTag();
        aVar.position = this.gPs.gm();
        if (this.gPs.gPo.getOnItemClickListener() != null) {
            this.gPs.gPo.getOnItemClickListener().a(view, aVar, BaseAppBrandRecentView.b(this.gPs.gPo), BaseAppBrandRecentView.c(this.gPs.gPo));
        }
        this.gPs.gPo.getAdapter().RR.notifyChanged();
    }
}
