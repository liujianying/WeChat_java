package com.tencent.mm.ui.base.preference;

import com.tencent.mm.ui.base.preference.EditPreference.a;
import com.tencent.mm.ui.base.preference.MMPreference.2;

class MMPreference$2$2 implements a {
    final /* synthetic */ Preference guh;
    final /* synthetic */ 2 tCR;
    final /* synthetic */ EditPreference tCS;

    MMPreference$2$2(2 2, EditPreference editPreference, Preference preference) {
        this.tCR = 2;
        this.tCS = editPreference;
        this.guh = preference;
    }

    public final void csi() {
        MMPreference.c(this.tCR.tCP);
        if (this.tCS.tDr) {
            MMPreference.b(this.tCR.tCP).edit().putString(this.guh.mKey, this.tCS.value).commit();
        }
        MMPreference.d(this.tCR.tCP).notifyDataSetChanged();
    }
}
