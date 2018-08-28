package com.tencent.mm.plugin.nearby.ui;

import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.a;

class NearbyPersonalInfoUI$3 implements a {
    final /* synthetic */ NearbyPersonalInfoUI lCt;

    NearbyPersonalInfoUI$3(NearbyPersonalInfoUI nearbyPersonalInfoUI) {
        this.lCt = nearbyPersonalInfoUI;
    }

    public final boolean a(Preference preference, Object obj) {
        String str = (String) obj;
        if ("male".equalsIgnoreCase(str)) {
            NearbyPersonalInfoUI.a(this.lCt, 1);
        } else if ("female".equalsIgnoreCase(str)) {
            NearbyPersonalInfoUI.a(this.lCt, 2);
        }
        return false;
    }
}
