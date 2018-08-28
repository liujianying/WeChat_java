package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.n.f;

class BizBindWxaInfoPreference$2 implements OnClickListener {
    final /* synthetic */ BizBindWxaInfoPreference lUi;

    BizBindWxaInfoPreference$2(BizBindWxaInfoPreference bizBindWxaInfoPreference) {
        this.lUi = bizBindWxaInfoPreference;
    }

    public final void onClick(View view) {
        ((f) g.l(f.class)).a(this.lUi.mContext, BizBindWxaInfoPreference.a(this.lUi).field_username, BizBindWxaInfoPreference.a(this.lUi).field_appId, BizBindWxaInfoPreference.b(this.lUi));
    }
}
