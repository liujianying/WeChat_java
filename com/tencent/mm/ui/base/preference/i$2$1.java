package com.tencent.mm.ui.base.preference;

import com.tencent.mm.ui.base.preference.DialogPreference.a;
import com.tencent.mm.ui.base.preference.i.2;

class i$2$1 implements a {
    final /* synthetic */ Preference guh;
    final /* synthetic */ DialogPreference tCQ;
    final /* synthetic */ 2 tDf;

    i$2$1(2 2, DialogPreference dialogPreference, Preference preference) {
        this.tDf = 2;
        this.tCQ = dialogPreference;
        this.guh = preference;
    }

    public final void csi() {
        i.c(this.tDf.tDe);
        if (this.tCQ.tDr) {
            i.b(this.tDf.tDe).edit().putString(this.guh.mKey, this.tCQ.getValue()).commit();
        }
        i.d(this.tDf.tDe).notifyDataSetChanged();
    }
}
