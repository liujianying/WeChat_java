package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.ui.f;

class BizInfoHeaderPreference$1 implements OnClickListener {
    final /* synthetic */ BizInfoHeaderPreference lUt;

    BizInfoHeaderPreference$1(BizInfoHeaderPreference bizInfoHeaderPreference) {
        this.lUt = bizInfoHeaderPreference;
    }

    public final void onClick(View view) {
        new f(BizInfoHeaderPreference.b(this.lUt), BizInfoHeaderPreference.a(this.lUt).field_username, BizInfoHeaderPreference.c(this.lUt)).cde();
    }
}
