package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class AppBrandProfileUI$3 implements c {
    final /* synthetic */ AppBrandProfileUI gvm;

    AppBrandProfileUI$3(AppBrandProfileUI appBrandProfileUI) {
        this.gvm = appBrandProfileUI;
    }

    public final void a(l lVar) {
        lVar.clear();
        lVar.eR(2, j.app_brand_authorize_settings);
        if (AppBrandProfileUI.b(this.gvm) != null && AppBrandProfileUI.b(this.gvm).bJu == 3 && AppBrandProfileUI.c(this.gvm)) {
            lVar.eR(3, j.app_brand_profile_action_sheet_feedback);
        }
        lVar.eR(1, j.app_brand_export);
    }
}
