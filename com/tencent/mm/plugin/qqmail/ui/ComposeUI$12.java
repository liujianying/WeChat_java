package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.ui.base.s;

class ComposeUI$12 implements a {
    final /* synthetic */ ComposeUI mfs;

    ComposeUI$12(ComposeUI composeUI) {
        this.mfs = composeUI;
    }

    public final boolean vD() {
        if (this.mfs.meV && ComposeUI.a(this.mfs, false) && ComposeUI.a(this.mfs) == 5) {
            ComposeUI.b(this.mfs);
            if (ComposeUI.c(this.mfs) != null) {
                ComposeUI.c(this.mfs).dismiss();
            }
            ComposeUI.a(this.mfs, s.a(this.mfs, this.mfs.getString(R.l.plugin_qqmail_composeui_auto_save), 2000));
        }
        return true;
    }
}
