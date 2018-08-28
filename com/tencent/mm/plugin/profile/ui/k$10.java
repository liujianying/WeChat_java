package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.e;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;

class k$10 implements e {
    final /* synthetic */ NormalUserHeaderPreference lWF;
    final /* synthetic */ k lWx;

    k$10(k kVar, NormalUserHeaderPreference normalUserHeaderPreference) {
        this.lWx = kVar;
        this.lWF = normalUserHeaderPreference;
    }

    public final void aJ(String str, boolean z) {
        this.lWF.bo(str, z);
        this.lWF.jX(this.lWx.guS.field_username);
    }
}
