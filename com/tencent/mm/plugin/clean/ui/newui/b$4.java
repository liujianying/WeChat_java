package com.tencent.mm.plugin.clean.ui.newui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class b$4 extends ag {
    final /* synthetic */ b hTn;

    b$4(b bVar) {
        this.hTn = bVar;
    }

    public final void handleMessage(Message message) {
        if (!b.b(this.hTn)) {
            this.hTn.notifyDataSetChanged();
        }
    }
}
