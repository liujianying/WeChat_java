package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.ui.ComposeUI.11;
import com.tencent.mm.plugin.qqmail.ui.b.b;

class ComposeUI$11$2 implements b {
    final /* synthetic */ 11 mfx;

    ComposeUI$11$2(11 11) {
        this.mfx = 11;
    }

    public final void boM() {
        ComposeUI.G(this.mfx.mfs).setMessage(this.mfx.mfs.getString(R.l.plugin_qqmail_attach_uploading));
    }

    public final void onComplete() {
        ComposeUI.a(this.mfx.mfs, ComposeUI.H(this.mfx.mfs));
    }
}
