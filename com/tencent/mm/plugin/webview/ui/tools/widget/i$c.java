package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mm.plugin.webview.stub.d.a;
import com.tencent.mm.sdk.platformtools.x;

protected class i$c implements ServiceConnection {
    final /* synthetic */ i qkV;

    public i$c(i iVar) {
        this.qkV = iVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        x.i("MicroMsg.MMWebViewClient", "onServiceConnected");
        if (this.qkV.dEn == null) {
            x.e("MicroMsg.MMWebViewClient", "onServiceConnected, activity destroyed");
            return;
        }
        try {
            this.qkV.qcA = a.Y(iBinder);
            this.qkV.qcA.a(this.qkV.qkU, this.qkV.dEn.hashCode());
            if (this.qkV.qkH != null) {
                this.qkV.qcA.b(this.qkV.qkH, this.qkV.dEn.hashCode());
            }
            this.qkV.a(this.qkV.qcA, this.qkV.qhr);
            this.qkV.bYv();
            this.qkV.bXI();
        } catch (Exception e) {
            x.e("MicroMsg.MMWebViewClient", "addCallback fail, ex = %s", new Object[]{e.getMessage()});
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        x.i("MicroMsg.MMWebViewClient", "edw onServiceDisconnected");
        if (this.qkV.ftd.isFinishing()) {
            this.qkV.qcA = null;
            return;
        }
        x.i("MicroMsg.MMWebViewClient", "maybe mm process crash, try rebind service");
        i.a(this.qkV);
    }
}
