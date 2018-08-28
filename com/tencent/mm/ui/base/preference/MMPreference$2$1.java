package com.tencent.mm.ui.base.preference;

import com.tencent.mm.ui.base.preference.DialogPreference.a;
import com.tencent.mm.ui.base.preference.MMPreference.2;

class MMPreference$2$1 implements a {
    final /* synthetic */ Preference guh;
    final /* synthetic */ DialogPreference tCQ;
    final /* synthetic */ 2 tCR;

    MMPreference$2$1(2 2, DialogPreference dialogPreference, Preference preference) {
        this.tCR = 2;
        this.tCQ = dialogPreference;
        this.guh = preference;
    }

    public final void csi() {
        MMPreference.c(this.tCR.tCP);
        if (this.tCQ.tDr) {
            MMPreference.b(this.tCR.tCP).edit().putString(this.guh.mKey, this.tCQ.getValue()).commit();
        }
        MMPreference.d(this.tCR.tCP).notifyDataSetChanged();
    }
}
