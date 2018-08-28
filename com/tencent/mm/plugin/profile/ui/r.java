package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.profile.ui.HelperHeaderPreference.a;

final class r implements a {
    private Context context;

    public r(Context context) {
        this.context = context;
    }

    public final CharSequence getHint() {
        return this.context.getString(R.l.contact_info_linkedin_tip);
    }

    public final void a(HelperHeaderPreference helperHeaderPreference) {
        helperHeaderPreference.hd((q.GQ() & 16777216) == 0);
    }
}
