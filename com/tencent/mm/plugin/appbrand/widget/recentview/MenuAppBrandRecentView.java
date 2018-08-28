package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.plugin.appbrand.widget.k.d;
import com.tencent.mm.plugin.appbrand.widget.k.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.b;

public class MenuAppBrandRecentView extends BaseAppBrandRecentView {
    private a gPu;

    public MenuAppBrandRecentView(Context context) {
        super(context);
    }

    public MenuAppBrandRecentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected String getType() {
        return MenuAppBrandRecentView.class.getSimpleName();
    }

    public void setOnItemClickListener(a aVar) {
        this.gPu = aVar;
    }

    protected final void a(b bVar, a aVar) {
        super.a(bVar, aVar);
        bVar.eBO.setTextColor(-1728053248);
        if (aVar.type == 2) {
            bVar.eBO.setVisibility(0);
            bVar.gPp.setVisibility(8);
            bVar.eBO.setText(e.multitask_bar_back_wechat);
            bVar.gmn.setImageResource(d.app_brand_capsule_multitasking_wechat);
        } else if (aVar.type == -1) {
            bVar.gmn.setImageResource(d.default_avatar);
        }
    }

    protected int getLoadCount() {
        return 11;
    }

    protected final void init(Context context) {
        super.init(context);
        super.setOnItemClickListener(new 1(this));
    }
}
