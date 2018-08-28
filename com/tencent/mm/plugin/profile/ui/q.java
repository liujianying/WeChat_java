package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.mm.R;

final class q implements HelperHeaderPreference$a {
    private Context context;

    public q(Context context) {
        this.context = context;
    }

    public final CharSequence getHint() {
        return this.context.getString(R.l.contact_info_feedsapp_tip);
    }

    public final void a(HelperHeaderPreference helperHeaderPreference) {
        helperHeaderPreference.hd((com.tencent.mm.model.q.GQ() & 32768) == 0);
    }
}
