package com.tencent.mm.plugin.appbrand.share.a;

import android.view.View;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.plugin.appbrand.s.i;
import com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage;

class a$2 implements f {
    final /* synthetic */ a gsV;
    final /* synthetic */ WxaShareMessagePage gsW;

    a$2(a aVar, WxaShareMessagePage wxaShareMessagePage) {
        this.gsV = aVar;
        this.gsW = wxaShareMessagePage;
    }

    public final void q(View view, int i) {
        switch (i) {
            case 0:
                this.gsW.getLoadingView().setVisibility(0);
                this.gsW.getErrorImageView().setVisibility(4);
                this.gsW.getWidgetPageView().setVisibility(4);
                this.gsW.getLoadingView().cAG();
                return;
            case 1:
                this.gsW.getLoadingView().cAH();
                this.gsW.getLoadingView().setVisibility(4);
                this.gsW.getErrorImageView().setVisibility(0);
                this.gsW.getWidgetPageView().setVisibility(4);
                this.gsW.getErrorImageView().setImageResource(i.dynamic_page_res_not_found);
                return;
            case 4:
                this.gsW.getLoadingView().setVisibility(4);
                this.gsW.getErrorImageView().setVisibility(4);
                this.gsW.getWidgetPageView().setVisibility(0);
                return;
            default:
                this.gsW.getLoadingView().cAH();
                this.gsW.getLoadingView().setVisibility(4);
                this.gsW.getErrorImageView().setVisibility(0);
                this.gsW.getWidgetPageView().setVisibility(4);
                this.gsW.getErrorImageView().setImageResource(i.app_brand_share_page_cover_default);
                return;
        }
    }
}
