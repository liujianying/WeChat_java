package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.ui.base.h;

class c$12 implements OnClickListener {
    final /* synthetic */ c fKg;
    final /* synthetic */ View fKo;

    c$12(c cVar, View view) {
        this.fKg = cVar;
        this.fKo = view;
    }

    public final void onClick(View view) {
        if (this.fKo.getParent() != null) {
            ((ViewGroup) this.fKo.getParent()).removeAllViews();
        }
        h.a(this.fKg.fJQ.mContext, false, this.fKg.fJQ.getContentView().getResources().getString(j.app_brand_get_phone_number_expose_title), this.fKo, this.fKg.fJQ.getContentView().getResources().getString(j.app_brand_get_phone_number_expose_ok_hint), "", new 1(this), new 2(this));
    }
}
