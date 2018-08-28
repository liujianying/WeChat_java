package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.n.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

class BizBindWxaInfoPreference$1 implements OnClickListener {
    final /* synthetic */ BizBindWxaInfoPreference lUi;

    BizBindWxaInfoPreference$1(BizBindWxaInfoPreference bizBindWxaInfoPreference) {
        this.lUi = bizBindWxaInfoPreference;
    }

    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag != null && (tag instanceof String)) {
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1020;
            appBrandStatObject.bGG = BizBindWxaInfoPreference.a(this.lUi).field_username;
            ((d) g.l(d.class)).a(this.lUi.mContext, (String) tag, null, 0, 0, null, appBrandStatObject, BizBindWxaInfoPreference.a(this.lUi).field_appId);
        }
    }
}
