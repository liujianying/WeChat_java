package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.b.j.a;
import com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.b;

class ComposeUI$17 extends a {
    final /* synthetic */ ComposeUI mfs;

    ComposeUI$17(ComposeUI composeUI) {
        this.mfs = composeUI;
    }

    public final void onComplete() {
        b bVar = new b(this.mfs, ComposeUI.d(this.mfs).JS(null));
        this.mfs.mey.setAddrsAdapter(bVar);
        ComposeUI.e(this.mfs).setAddrsAdapter(bVar);
        ComposeUI.f(this.mfs).setAddrsAdapter(bVar);
    }
}
