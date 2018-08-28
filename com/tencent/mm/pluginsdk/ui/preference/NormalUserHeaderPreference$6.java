package com.tencent.mm.pluginsdk.ui.preference;

import com.tencent.mm.l.a;

class NormalUserHeaderPreference$6 implements Runnable {
    final /* synthetic */ NormalUserHeaderPreference qPp;

    NormalUserHeaderPreference$6(NormalUserHeaderPreference normalUserHeaderPreference) {
        this.qPp = normalUserHeaderPreference;
    }

    public final void run() {
        NormalUserHeaderPreference.f(this.qPp);
        NormalUserHeaderPreference.g(this.qPp);
        NormalUserHeaderPreference.h(this.qPp);
        if (NormalUserHeaderPreference.i(this.qPp) != null) {
            NormalUserHeaderPreference.i(this.qPp).setReplyBtnVisible(!a.gd(NormalUserHeaderPreference.b(this.qPp).field_type));
        }
    }
}
