package com.tencent.mm.app;

import android.os.FileObserver;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;

class k$a extends FileObserver {
    final /* synthetic */ k byU;

    k$a(k kVar, String str) {
        this.byU = kVar;
        super(str, 712);
    }

    public final void onEvent(int i, String str) {
        Object obj = null;
        if (System.currentTimeMillis() - k.a(this.byU) < 120000) {
            obj = 1;
        }
        if (obj == null) {
            synchronized (this.byU.byJ) {
                switch (i) {
                    case 8:
                        x.i("MicroMsg.MMCrashReporter", "Detected trace file changed: " + str);
                        this.byU.byM.open();
                        if (this.byU.byS == null) {
                            this.byU.byS = new k$b(this.byU, (byte) 0);
                            e.post(this.byU.byS, "MMCrashReporter_parseANRTrace");
                            break;
                        }
                        break;
                    case a$k.AppCompatTheme_imageButtonStyle /*64*/:
                    case 512:
                        this.byU.byJ.remove(str);
                        break;
                    case 128:
                        break;
                }
                this.byU.byJ.add(str);
            }
        }
    }
}
