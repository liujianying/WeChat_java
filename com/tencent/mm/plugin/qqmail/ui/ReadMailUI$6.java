package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.g;

class ReadMailUI$6 implements Runnable {
    final /* synthetic */ ReadMailUI miD;

    ReadMailUI$6(ReadMailUI readMailUI) {
        this.miD = readMailUI;
    }

    public final void run() {
        g.a(this.miD, this.miD.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail"), this.miD.getString(R.l.chatfooter_mail_without_unread_count), null);
    }
}
