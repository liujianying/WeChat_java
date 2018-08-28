package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ui.tools.ZoneSelectOtherCountryPreference.a;

class MultiStageCitySelectUI$2 implements a {
    final /* synthetic */ MultiStageCitySelectUI uBd;

    MultiStageCitySelectUI$2(MultiStageCitySelectUI multiStageCitySelectUI) {
        this.uBd = multiStageCitySelectUI;
    }

    public final void onClick() {
        Intent intent = new Intent(this.uBd, MultiStageCitySelectUI.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean("GetAddress", MultiStageCitySelectUI.e(this.uBd));
        bundle.putBoolean("ShowSelectedLocation", MultiStageCitySelectUI.f(this.uBd));
        bundle.putBoolean("IsSelectNonChinaCountry", true);
        bundle.putBoolean("IsAutoPosition", false);
        bundle.putBoolean("IsNeedShowSearchBar", true);
        intent.putExtras(bundle);
        this.uBd.startActivityForResult(intent, 1);
    }
}
