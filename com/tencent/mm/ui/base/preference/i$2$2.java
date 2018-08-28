package com.tencent.mm.ui.base.preference;

import com.tencent.mm.ui.base.preference.EditPreference.a;
import com.tencent.mm.ui.base.preference.i.2;

class i$2$2 implements a {
    final /* synthetic */ Preference guh;
    final /* synthetic */ EditPreference tCS;
    final /* synthetic */ 2 tDf;

    i$2$2(2 2, EditPreference editPreference, Preference preference) {
        this.tDf = 2;
        this.tCS = editPreference;
        this.guh = preference;
    }

    public final void csi() {
        i.c(this.tDf.tDe);
        if (this.tCS.tDr) {
            i.b(this.tDf.tDe).edit().putString(this.guh.mKey, this.tCS.value).commit();
        }
        i.d(this.tDf.tDe).notifyDataSetChanged();
    }
}
