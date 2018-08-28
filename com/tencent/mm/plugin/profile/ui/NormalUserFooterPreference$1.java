package com.tencent.mm.plugin.profile.ui;

import android.os.Looper;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.e;
import com.tencent.mm.sdk.e.k;

class NormalUserFooterPreference$1 extends k<e, String> {
    final /* synthetic */ NormalUserFooterPreference lXw;

    NormalUserFooterPreference$1(NormalUserFooterPreference normalUserFooterPreference) {
        this.lXw = normalUserFooterPreference;
    }

    public final /* synthetic */ void a(Object obj, Looper looper) {
        e eVar = (e) obj;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        super.a(eVar, looper);
    }

    protected final /* synthetic */ void q(Object obj, Object obj2) {
        e eVar = (e) obj;
        String str = (String) obj2;
        if (str.equals("show_btn")) {
            eVar.aJ(NormalUserFooterPreference.a(this.lXw).field_username, true);
        } else if (str.equals("hide_btn")) {
            eVar.aJ(NormalUserFooterPreference.a(this.lXw).field_username, false);
        }
    }
}
