package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ComposeUI$8 implements OnClickListener {
    final /* synthetic */ ComposeUI mfs;

    ComposeUI$8(ComposeUI composeUI) {
        this.mfs = composeUI;
    }

    public final void onClick(View view) {
        h.a(this.mfs, null, new String[]{this.mfs.getString(R.l.plugin_qqmail_composeui_attach_take_phote), this.mfs.getString(R.l.plugin_qqmail_composeui_attach_choose_album), this.mfs.getString(R.l.plugin_qqmail_composeui_attach_choose_file)}, null, new 1(this));
    }
}
