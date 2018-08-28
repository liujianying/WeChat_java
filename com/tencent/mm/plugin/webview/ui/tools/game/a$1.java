package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import android.os.RemoteException;

class a$1 extends c {
    final /* synthetic */ a qfR;

    a$1(a aVar) {
        this.qfR = aVar;
    }

    protected final void A(Bundle bundle) {
        try {
            if (this.qfR.qcA != null && bundle != null) {
                this.qfR.qcA.g(96, bundle);
            }
        } catch (RemoteException e) {
        }
    }
}
