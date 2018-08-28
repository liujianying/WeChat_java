package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.qqmail.ui.ComposeUI.19;

class ComposeUI$19$1 implements OnClickListener {
    final /* synthetic */ MailAddrsViewControl mfA;
    final /* synthetic */ 19 mfB;

    ComposeUI$19$1(19 19, MailAddrsViewControl mailAddrsViewControl) {
        this.mfB = 19;
        this.mfA = mailAddrsViewControl;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.mfA.mgU.setText("");
        ComposeUI.i(this.mfB.mfs).postDelayed(new 1(this), 150);
    }
}
