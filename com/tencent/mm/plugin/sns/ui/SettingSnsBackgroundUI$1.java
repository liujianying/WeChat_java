package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.ui.tools.a.a;

class SettingSnsBackgroundUI$1 implements a {
    final /* synthetic */ SettingSnsBackgroundUI nRb;

    SettingSnsBackgroundUI$1(SettingSnsBackgroundUI settingSnsBackgroundUI) {
        this.nRb = settingSnsBackgroundUI;
    }

    public final String NT(String str) {
        return af.getAccSnsTmpPath() + g.u((this.nRb.filePath + System.currentTimeMillis()).getBytes());
    }
}
