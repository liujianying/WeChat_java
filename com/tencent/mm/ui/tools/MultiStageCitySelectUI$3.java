package com.tencent.mm.ui.tools;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.tools.o.b;

class MultiStageCitySelectUI$3 implements b {
    final /* synthetic */ MultiStageCitySelectUI uBd;

    MultiStageCitySelectUI$3(MultiStageCitySelectUI multiStageCitySelectUI) {
        this.uBd = multiStageCitySelectUI;
    }

    public final void WX() {
    }

    public final void WW() {
        this.uBd.YC();
        MultiStageCitySelectUI.g(this.uBd);
        this.uBd.czK();
    }

    public final void pk(String str) {
        if (!bi.oW(str)) {
            MultiStageCitySelectUI.a(this.uBd, str);
            MultiStageCitySelectUI.h(this.uBd).removeAll();
            MultiStageCitySelectUI.j(this.uBd).removeCallbacks(MultiStageCitySelectUI.i(this.uBd));
            MultiStageCitySelectUI.j(this.uBd).postDelayed(MultiStageCitySelectUI.i(this.uBd), 50);
        }
    }

    public final boolean pj(String str) {
        if (bi.oW(str)) {
            return false;
        }
        MultiStageCitySelectUI.a(this.uBd, str);
        MultiStageCitySelectUI.h(this.uBd).removeAll();
        MultiStageCitySelectUI.j(this.uBd).removeCallbacks(MultiStageCitySelectUI.i(this.uBd));
        MultiStageCitySelectUI.j(this.uBd).postDelayed(MultiStageCitySelectUI.i(this.uBd), 50);
        return true;
    }

    public final void WY() {
        MultiStageCitySelectUI.g(this.uBd);
        this.uBd.czK();
    }

    public final void WZ() {
    }
}
