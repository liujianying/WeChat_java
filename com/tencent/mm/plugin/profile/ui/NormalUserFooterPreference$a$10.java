package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;

class NormalUserFooterPreference$a$10 implements Runnable {
    final /* synthetic */ a lXy;

    NormalUserFooterPreference$a$10(a aVar) {
        this.lXy = aVar;
    }

    public final void run() {
        b.U(NormalUserFooterPreference.b(this.lXy.lXw), NormalUserFooterPreference.a(this.lXy.lXw).field_username);
    }
}
