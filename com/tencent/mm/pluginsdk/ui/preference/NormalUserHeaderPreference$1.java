package com.tencent.mm.pluginsdk.ui.preference;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;

class NormalUserHeaderPreference$1 implements OnClickListener {
    final /* synthetic */ NormalUserHeaderPreference qPp;

    NormalUserHeaderPreference$1(NormalUserHeaderPreference normalUserHeaderPreference) {
        this.qPp = normalUserHeaderPreference;
    }

    public final void onClick(View view) {
        d.A(NormalUserHeaderPreference.a(this.qPp), "bottle", ".ui.BottlePersonalInfoUI");
    }
}
