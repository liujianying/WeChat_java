package com.tencent.mm.plugin.voip_cs.b.a;

import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ag;

class b$4 extends ag {
    final /* synthetic */ b oXY;

    b$4(b bVar) {
        this.oXY = bVar;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 12:
                if (this.oXY.oXX != null) {
                    b.g(this.oXY).setImageDrawable(this.oXY.oXX);
                    return;
                } else {
                    b.g(this.oXY).setImageResource(R.g.default_avatar);
                    return;
                }
            default:
                return;
        }
    }
}
