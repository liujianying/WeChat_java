package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.aa.a;

class e$6 implements Runnable {
    final /* synthetic */ e kuf;

    e$6(e eVar) {
        this.kuf = eVar;
    }

    public final void run() {
        au.HU();
        if (((Boolean) c.DT().get(a.sQV, Boolean.valueOf(false))).booleanValue()) {
            this.kuf.kue.setVisibility(0);
        } else {
            this.kuf.kue.setVisibility(8);
        }
        au.HU();
        String str = (String) c.DT().get(a.sQX, "");
        au.HU();
        String str2 = (String) c.DT().get(a.sQY, "");
        if (!bi.oW(str)) {
            this.kuf.kud.setText(str);
            this.kuf.kuc.setVisibility(0);
        } else if (bi.oW(str2)) {
            this.kuf.kud.setText("");
            this.kuf.kuc.setVisibility(8);
        } else {
            this.kuf.kud.setText(str2);
            this.kuf.kuc.setVisibility(0);
        }
    }
}
