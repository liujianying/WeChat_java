package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.n.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.sdk.platformtools.x;

class NewBizBindWxaInfoPreference$1 implements OnClickListener {
    final /* synthetic */ NewBizBindWxaInfoPreference lYw;

    NewBizBindWxaInfoPreference$1(NewBizBindWxaInfoPreference newBizBindWxaInfoPreference) {
        this.lYw = newBizBindWxaInfoPreference;
    }

    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag == null || !(tag instanceof String)) {
            x.e("MicroMsg.NewBizBindWxaInfoPreference", "username is null, err");
            return;
        }
        x.i("MicroMsg.NewBizBindWxaInfoPreference", "jump to wxa:%s", new Object[]{(String) tag});
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1020;
        appBrandStatObject.bGG = NewBizBindWxaInfoPreference.a(this.lYw).field_username;
        ((d) g.l(d.class)).a(this.lYw.mContext, (String) tag, null, 0, 0, null, appBrandStatObject, NewBizBindWxaInfoPreference.a(this.lYw).field_appId);
        c.bT(NewBizBindWxaInfoPreference.a(this.lYw).field_username, 500);
    }
}
