package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.ui.base.preference.Preference;

class AppBrandAuthorizeUI$9 implements Runnable {
    final /* synthetic */ boolean gnL;
    final /* synthetic */ AppBrandAuthorizeUI guf;

    AppBrandAuthorizeUI$9(AppBrandAuthorizeUI appBrandAuthorizeUI, boolean z) {
        this.guf = appBrandAuthorizeUI;
        this.gnL = z;
    }

    public final void run() {
        Preference preference = new Preference(this.guf);
        preference.tDr = false;
        if (this.gnL) {
            preference.setLayoutResource(h.app_brand_authorize_none);
            preference.setTitle(this.guf.getString(j.app_brand_auth_info_none, new Object[]{AppBrandAuthorizeUI.e(this.guf).nickname}));
        } else {
            preference.setLayoutResource(h.app_brand_authorize_used);
            preference.setTitle(this.guf.getString(j.app_brand_auth_info_used, new Object[]{AppBrandAuthorizeUI.e(this.guf).nickname}));
        }
        this.guf.gua.a(preference);
        this.guf.gua.notifyDataSetChanged();
    }
}
