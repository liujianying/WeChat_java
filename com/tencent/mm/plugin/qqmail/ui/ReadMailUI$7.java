package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ReadMailUI$7 implements OnClickListener {
    final /* synthetic */ ReadMailUI miD;

    ReadMailUI$7(ReadMailUI readMailUI) {
        this.miD = readMailUI;
    }

    public final void onClick(View view) {
        switch (ReadMailUI.w(this.miD)) {
            case 0:
                ReadMailUI.a(this.miD, 2);
                if (bi.oW(ReadMailUI.x(this.miD)) || bi.oW(ReadMailUI.y(this.miD))) {
                    ReadMailUI.A(this.miD);
                    return;
                } else {
                    ReadMailUI.z(this.miD);
                    return;
                }
            case 1:
                ReadMailUI.a(this.miD, 1);
                int intValue = ((Integer) new ReadMailProxy(ReadMailUI.l(this.miD), null).REMOTE_CALL("removeDownloadQQMailAppTask", new Object[]{Long.valueOf(ReadMailUI.B(this.miD))})).intValue();
                if (intValue == -1) {
                    x.e("MicroMsg.ReadMailUI", "cancel_download_task:fail_apilevel_too_low downloadId = %d", new Object[]{Long.valueOf(ReadMailUI.B(this.miD))});
                    return;
                } else if (intValue <= 0) {
                    x.e("MicroMsg.ReadMailUI", "cancel_download_task:fail downloadId = %d", new Object[]{Long.valueOf(ReadMailUI.B(this.miD))});
                    return;
                } else {
                    x.i("MicroMsg.ReadMailUI", "cancel_download_task:ok downloadId = %d", new Object[]{Long.valueOf(ReadMailUI.B(this.miD))});
                    ReadMailUI.C(this.miD).SO();
                    ReadMailUI.b(this.miD, 0);
                    ReadMailUI.D(this.miD);
                    ReadMailUI.p(this.miD);
                    return;
                }
            case 2:
                ReadMailUI.a(this.miD, 3);
                ReadMailUI.E(this.miD);
                return;
            case 3:
                ReadMailUI.a(this.miD, 4);
                ReadMailUI.F(this.miD);
                return;
            default:
                return;
        }
    }
}
