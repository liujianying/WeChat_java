package com.tencent.mm.ui.base;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class s$4 extends ag {
    final /* synthetic */ o tym;

    s$4(o oVar) {
        this.tym = oVar;
    }

    public final void handleMessage(Message message) {
        this.tym.dismiss();
        super.handleMessage(message);
    }
}
