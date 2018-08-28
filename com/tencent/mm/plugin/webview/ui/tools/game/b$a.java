package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.ComponentName;
import android.os.IBinder;
import com.tencent.mm.plugin.webview.stub.d.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.i.c;
import com.tencent.mm.sdk.platformtools.x;

class b$a extends c {
    final /* synthetic */ b qfT;

    private b$a(b bVar) {
        this.qfT = bVar;
        super(bVar);
    }

    /* synthetic */ b$a(b bVar, byte b) {
        this(bVar);
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        x.i("MicroMsg.GameFloatWebViewClient", "onServiceConnected");
        if (this.qfT.dEn == null) {
            x.e("MicroMsg.GameFloatWebViewClient", "onServiceConnected, activity destroyed");
            return;
        }
        try {
            this.qfT.qcA = a.Y(iBinder);
            this.qfT.qcA.a(this.qfT.qkU, this.qfT.dEn.hashCode());
            this.qfT.bYv();
            this.qfT.a(this.qfT.qcA, this.qfT.qhr);
            this.qfT.bXI();
        } catch (Exception e) {
            x.e("MicroMsg.GameFloatWebViewClient", "addCallback fail, ex = %s", new Object[]{e.getMessage()});
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        super.onServiceDisconnected(componentName);
    }
}
