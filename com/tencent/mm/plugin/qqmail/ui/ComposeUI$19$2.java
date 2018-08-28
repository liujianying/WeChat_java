package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.qqmail.ui.ComposeUI.19;

class ComposeUI$19$2 implements OnClickListener {
    final /* synthetic */ MailAddrsViewControl mfA;
    final /* synthetic */ 19 mfB;

    ComposeUI$19$2(19 19, MailAddrsViewControl mailAddrsViewControl) {
        this.mfB = 19;
        this.mfA = mailAddrsViewControl;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ComposeUI.i(this.mfB.mfs).postDelayed(new 1(this), 150);
    }
}
