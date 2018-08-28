package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.ui.b.1;

class b$1$1 implements Runnable {
    final /* synthetic */ c kto;
    final /* synthetic */ 1 ktp;

    b$1$1(1 1, c cVar) {
        this.ktp = 1;
        this.kto = cVar;
    }

    public final void run() {
        if (this.kto == null || this.kto.sKx == -1) {
            this.ktp.ktn.eCM.setText("");
        } else {
            this.ktp.ktn.eCM.setText(this.kto.field_systemAddressBookUsername);
        }
    }
}
