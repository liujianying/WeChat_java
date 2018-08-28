package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;

class ZoneSelectOtherCountryPreference$1 implements OnClickListener {
    final /* synthetic */ ZoneSelectOtherCountryPreference uCM;

    ZoneSelectOtherCountryPreference$1(ZoneSelectOtherCountryPreference zoneSelectOtherCountryPreference) {
        this.uCM = zoneSelectOtherCountryPreference;
    }

    public final void onClick(View view) {
        if (ZoneSelectOtherCountryPreference.a(this.uCM) != null) {
            ZoneSelectOtherCountryPreference.a(this.uCM).onClick();
        }
    }
}
