package com.tencent.mm.plugin.voip_cs.b.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements OnClickListener {
    final /* synthetic */ b oXY;

    b$3(b bVar) {
        this.oXY = bVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.voipcs.VoipCSViewManager", "switch camera");
        b.d(this.oXY).setEnabled(false);
        if (b.bMw().oXs > 1) {
            b.e(this.oXY);
        }
        b.d(this.oXY).setEnabled(true);
        if (b.f(this.oXY) != null) {
            b.f(this.oXY).bLX();
        }
    }
}
