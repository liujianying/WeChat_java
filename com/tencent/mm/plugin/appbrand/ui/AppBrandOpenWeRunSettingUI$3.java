package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandOpenWeRunSettingUI$3 implements a {
    final /* synthetic */ AppBrandOpenWeRunSettingUI guU;

    AppBrandOpenWeRunSettingUI$3(AppBrandOpenWeRunSettingUI appBrandOpenWeRunSettingUI) {
        this.guU = appBrandOpenWeRunSettingUI;
    }

    public final void x(String str, boolean z) {
        x.i("MicroMsg.AppBrandOpenWeRunSettingUI", "getContactCallBack, suc = %b,user %s", new Object[]{Boolean.valueOf(z), str});
        AppBrandOpenWeRunSettingUI.a(this.guU, ((i) g.l(i.class)).FR().Yg("gh_43f2581f6fd6"));
        AppBrandOpenWeRunSettingUI.a(this.guU);
        AppBrandOpenWeRunSettingUI.b(this.guU).dismiss();
    }
}
