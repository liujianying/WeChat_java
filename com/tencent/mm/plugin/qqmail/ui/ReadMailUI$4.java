package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.sdk.platformtools.al.a;

class ReadMailUI$4 implements a {
    final /* synthetic */ ReadMailUI miD;

    ReadMailUI$4(ReadMailUI readMailUI) {
        this.miD = readMailUI;
    }

    public final boolean vD() {
        if (!ReadMailUI.l(this.miD).isConnected()) {
            return false;
        }
        double doubleValue = ((Double) new ReadMailProxy(ReadMailUI.l(this.miD), null).REMOTE_CALL("getMailAppDownloadProgress", new Object[]{Long.valueOf(ReadMailUI.B(this.miD))})).doubleValue();
        if (doubleValue == 1.0d) {
            ReadMailUI.t(this.miD);
            return false;
        }
        int i;
        if (ReadMailUI.N(this.miD) == 0) {
            ReadMailUI.c(this.miD, ReadMailUI.O(this.miD).getWidth());
            i = 0;
        } else {
            i = (int) (((double) ReadMailUI.N(this.miD)) * doubleValue);
        }
        ReadMailUI.b(this.miD, i);
        return true;
    }
}
