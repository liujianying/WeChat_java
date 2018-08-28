package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.pluginsdk.ui.f$a;

class NewBizInfoHeaderPreference$1 implements OnClickListener {
    final /* synthetic */ NewBizInfoHeaderPreference lYE;

    NewBizInfoHeaderPreference$1(NewBizInfoHeaderPreference newBizInfoHeaderPreference) {
        this.lYE = newBizInfoHeaderPreference;
    }

    public final void onClick(View view) {
        new f(NewBizInfoHeaderPreference.b(this.lYE), NewBizInfoHeaderPreference.a(this.lYE).field_username, NewBizInfoHeaderPreference.c(this.lYE), f$a.qFw).cde();
    }
}
