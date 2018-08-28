package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.b;

class BaseAppBrandRecentView$b$2 implements OnLongClickListener {
    final /* synthetic */ BaseAppBrandRecentView gPr;
    final /* synthetic */ b gPs;

    BaseAppBrandRecentView$b$2(b bVar, BaseAppBrandRecentView baseAppBrandRecentView) {
        this.gPs = bVar;
        this.gPr = baseAppBrandRecentView;
    }

    public final boolean onLongClick(View view) {
        a aVar = (a) view.getTag();
        aVar.position = this.gPs.gm();
        if (this.gPs.gPo.getOnItemClickListener() != null) {
            this.gPs.gPo.getOnItemClickListener().b(view, aVar, BaseAppBrandRecentView.b(this.gPs.gPo), BaseAppBrandRecentView.c(this.gPs.gPo));
        }
        BaseAppBrandRecentView.d(this.gPs.gPo);
        return true;
    }
}
