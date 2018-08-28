package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.7;

class SnsSightPlayerUI$7$1 implements Runnable {
    final /* synthetic */ 7 obe;
    final /* synthetic */ Intent val$intent;

    SnsSightPlayerUI$7$1(7 7, Intent intent) {
        this.obe = 7;
        this.val$intent = intent;
    }

    public final void run() {
        a.ezn.j(this.val$intent, this.obe.obb);
        this.obe.obb.finish();
    }
}
