package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.a;
import java.util.HashMap;

class ReadMailUI$a$4 implements Runnable {
    final /* synthetic */ a miN;

    ReadMailUI$a$4(a aVar) {
        this.miN = aVar;
    }

    public final void run() {
        ReadMailUI.a(this.miN.miD, new HashMap());
    }
}
