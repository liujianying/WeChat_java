package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.plugin.qqmail.stub.QQMailStubProxyUI;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.a;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;

class ReadMailUI$a$3 implements Runnable {
    final /* synthetic */ int bFr;
    final /* synthetic */ String fYD;
    final /* synthetic */ a miN;

    ReadMailUI$a$3(a aVar, int i, String str) {
        this.miN = aVar;
        this.bFr = i;
        this.fYD = str;
    }

    public final void run() {
        if (!this.miN.miD.isFinishing()) {
            Intent intent;
            switch (this.miN.miL) {
                case 1:
                    ReadMailUI.j(this.miN.miD).setVisibility(0);
                    if (this.bFr == -5) {
                        intent = new Intent(this.miN.miD, QQMailStubProxyUI.class);
                        intent.addFlags(268435456);
                        this.miN.miD.startActivityForResult(intent, 1);
                        return;
                    }
                    if (this.bFr == -7) {
                        ReadMailUI.j(this.miN.miD).setVisibility(8);
                        try {
                            new ReadMailProxy(ReadMailUI.l(this.miN.miD), null).REMOTE_CALL("replaceMsgContent", new Object[]{Long.valueOf(ReadMailUI.k(this.miN.miD)), this.fYD});
                        } catch (Exception e) {
                            x.w("MicroMsg.ReadMailUI", "replaceMsgContent fail, ex = %s", new Object[]{e.getMessage()});
                        }
                    }
                    if (this.bFr == -10005 && !ao.isConnected(this.miN.miD)) {
                        Toast.makeText(this.miN.miD, this.miN.miD.getString(R.l.fmt_iap_err, new Object[]{Integer.valueOf(2), Integer.valueOf(this.bFr)}), 1).show();
                    }
                    ReadMailUI.g(this.miN.miD).loadDataWithBaseURL(p.bor(), this.fYD + "(" + this.bFr + ")", "text/html", "utf-8", null);
                    return;
                case 2:
                    if (this.bFr == -5) {
                        intent = new Intent(this.miN.miD, QQMailStubProxyUI.class);
                        intent.addFlags(268435456);
                        this.miN.miD.startActivityForResult(intent, 2);
                        return;
                    }
                    Toast.makeText(this.miN.miD, this.fYD, 1).show();
                    return;
                default:
                    x.e("MicroMsg.ReadMailUI", "onError invalid userData = %d", new Object[]{Integer.valueOf(this.miN.miL)});
                    return;
            }
        }
    }
}
