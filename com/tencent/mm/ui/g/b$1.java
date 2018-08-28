package com.tencent.mm.ui.g;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class b$1 extends ag {
    final /* synthetic */ b uuH;

    b$1(b bVar) {
        this.uuH = bVar;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 256:
                this.uuH.dismiss();
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
