package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI.4;

class VideoAdPlayerUI$4$1 implements Runnable {
    final /* synthetic */ 4 oiB;
    final /* synthetic */ Intent val$intent;

    VideoAdPlayerUI$4$1(4 4, Intent intent) {
        this.oiB = 4;
        this.val$intent = intent;
    }

    public final void run() {
        a.ezn.j(this.val$intent, this.oiB.oiz);
    }
}
