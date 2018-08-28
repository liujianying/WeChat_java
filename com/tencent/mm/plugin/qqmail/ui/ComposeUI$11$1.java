package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.plugin.qqmail.ui.ComposeUI.11;

class ComposeUI$11$1 implements OnCancelListener {
    final /* synthetic */ 11 mfx;

    ComposeUI$11$1(11 11) {
        this.mfx = 11;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ComposeUI.E(this.mfx.mfs).boT();
        ComposeUI.E(this.mfx.mfs).mgq = null;
        w.bow().cancel(ComposeUI.F(this.mfx.mfs));
    }
}
