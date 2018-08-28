package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ComposeUI$11 implements OnClickListener {
    final /* synthetic */ ComposeUI mfs;

    ComposeUI$11(ComposeUI composeUI) {
        this.mfs = composeUI;
    }

    public final void onClick(View view) {
        this.mfs.YC();
        ComposeUI.j(this.mfs).getText().toString();
        ComposeUI.D(this.mfs);
        if (this.mfs.boL()) {
            ComposeUI composeUI = this.mfs;
            ComposeUI composeUI2 = this.mfs;
            this.mfs.getString(R.l.app_tip);
            ComposeUI.a(composeUI, h.a(composeUI2, this.mfs.getString(R.l.plugin_qqmail_compose_send_ing), true, new 1(this)));
            if (ComposeUI.E(this.mfs).boU()) {
                ComposeUI.a(this.mfs, ComposeUI.H(this.mfs));
                return;
            }
            ComposeUI.G(this.mfs).setMessage(this.mfs.getString(R.l.plugin_qqmail_attach_uploading));
            ComposeUI.E(this.mfs).mgq = new 2(this);
        }
    }
}
