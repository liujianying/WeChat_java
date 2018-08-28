package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.profile.ui.HelperHeaderPreference.a;

final class p implements a {
    private Context context;

    public p(Context context) {
        this.context = context;
    }

    public final CharSequence getHint() {
        return this.context.getString(R.l.contact_info_facebookapp_tip);
    }

    public final void a(HelperHeaderPreference helperHeaderPreference) {
        helperHeaderPreference.hd((q.GQ() & 8192) == 0);
    }
}
