package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.ui.base.h;

class ComposeUI$13 implements OnClickListener {
    final /* synthetic */ ComposeUI mfs;

    ComposeUI$13(ComposeUI composeUI) {
        this.mfs = composeUI;
    }

    public final void onClick(View view) {
        if (ComposeUI.E(this.mfs).boU()) {
            s.a(ComposeUI.s(this.mfs), ComposeUI.n(this.mfs), ComposeUI.x(this.mfs));
            ComposeUI.I(this.mfs);
            return;
        }
        ComposeUI.a(this.mfs, h.a(this.mfs, this.mfs.getString(R.l.plugin_qqmail_attach_uploading), true, new 1(this)));
        ComposeUI.E(this.mfs).mgq = new 2(this);
    }
}
