package com.tencent.mm.console;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;

class Shell$2 implements Shell$a {
    Shell$2() {
    }

    public final void n(Intent intent) {
        if (ad.cic()) {
            String stringExtra = intent.getStringExtra("sql");
            String stringExtra2 = intent.getStringExtra("file");
            if (stringExtra != null && stringExtra.length() > 0) {
                g.Em().H(new 1(this, stringExtra));
            } else if (stringExtra2 != null && stringExtra2.length() > 0) {
                g.Em().H(new 2(this, stringExtra2));
            }
        }
    }
}
