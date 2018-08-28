package com.tencent.mm.plugin.game.wepkg.model;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.game.wepkg.utils.d;

class f$1 implements c<Bundle> {
    final /* synthetic */ String keN;

    f$1(String str) {
        this.keN = str;
    }

    public final /* synthetic */ void at(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (bundle != null) {
            d.Em().H(new 1(this, bundle.getString("used_wepkg_version")));
        }
    }
}
