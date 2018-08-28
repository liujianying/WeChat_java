package com.tencent.mm.plugin.scanner.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.scanner.util.e.a;
import com.tencent.mm.sdk.platformtools.x;

class p$1 implements a {
    final /* synthetic */ p mLr;

    p$1(p pVar) {
        this.mLr = pVar;
    }

    public final void o(int i, Bundle bundle) {
        x.i("MicroMsg.scanner.ScanModeQRCode", "notify Event: %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 0:
                this.mLr.mLh = false;
                return;
            case 1:
                this.mLr.hk(true);
                return;
            case 2:
                this.mLr.hk(true);
                return;
            case 3:
                this.mLr.mKp.bsA();
                return;
            case 4:
                if (bundle != null) {
                    String string = bundle.getString("geta8key_fullurl");
                    if (string != null && (string.startsWith("http://login.weixin.qq.com") || string.startsWith("https://login.weixin.qq.com"))) {
                        this.mLr.bJM = 2;
                        break;
                    }
                }
                break;
            case 5:
                break;
            default:
                return;
        }
        this.mLr.mKp.hu(true);
        this.mLr.mLh = true;
    }
}
