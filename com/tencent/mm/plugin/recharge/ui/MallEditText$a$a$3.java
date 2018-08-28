package com.tencent.mm.plugin.recharge.ui;

import com.tencent.mm.plugin.recharge.ui.MallEditText.a.a;
import com.tencent.mm.sdk.platformtools.bi;

class MallEditText$a$a$3 implements Runnable {
    final /* synthetic */ a mps;
    final /* synthetic */ com.tencent.mm.plugin.recharge.model.a mpt;

    MallEditText$a$a$3(a aVar, com.tencent.mm.plugin.recharge.model.a aVar2) {
        this.mps = aVar;
        this.mpt = aVar2;
    }

    public final void run() {
        MallEditText.a(this.mps.mpr.mpl, this.mpt);
        if (bi.oW(MallEditText.e(this.mps.mpr.mpl).name)) {
            MallEditText.g(this.mps.mpr.mpl).setText("");
            MallEditText.g(this.mps.mpr.mpl).setVisibility(8);
        } else {
            MallEditText.g(this.mps.mpr.mpl).setText(MallEditText.e(this.mps.mpr.mpl).name);
            MallEditText.g(this.mps.mpr.mpl).setVisibility(0);
        }
        MallEditText.a(this.mps.mpr.mpl).dismissDropDown();
    }
}
