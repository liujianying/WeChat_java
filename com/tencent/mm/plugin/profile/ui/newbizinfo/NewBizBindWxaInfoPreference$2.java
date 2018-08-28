package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.n.f;

class NewBizBindWxaInfoPreference$2 implements OnClickListener {
    final /* synthetic */ NewBizBindWxaInfoPreference lYw;

    NewBizBindWxaInfoPreference$2(NewBizBindWxaInfoPreference newBizBindWxaInfoPreference) {
        this.lYw = newBizBindWxaInfoPreference;
    }

    public final void onClick(View view) {
        ((f) g.l(f.class)).a(this.lYw.mContext, NewBizBindWxaInfoPreference.a(this.lYw).field_username, NewBizBindWxaInfoPreference.a(this.lYw).field_appId, NewBizBindWxaInfoPreference.b(this.lYw));
    }
}
