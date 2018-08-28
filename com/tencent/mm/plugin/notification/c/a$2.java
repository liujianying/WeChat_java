package com.tencent.mm.plugin.notification.c;

import com.tencent.mm.plugin.notification.ui.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements a {
    final /* synthetic */ a lHC;

    a$2(a aVar) {
        this.lHC = aVar;
    }

    public final void bkp() {
        x.d("MicroMsg.AbstractSendMsgFailNotification", "onClickResendButton");
        ah.A(new Runnable() {
            public final void run() {
                h.mEJ.h(11425, new Object[]{Integer.valueOf(a$2.this.lHC.getType()), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0)});
                a$2.this.lHC.bkm();
                a.a(a$2.this.lHC);
                a$2.this.lHC.bkf();
            }
        });
    }

    public final void bkq() {
        x.d("MicroMsg.AbstractSendMsgFailNotification", "onClickOmitButton");
        ah.A(new Runnable() {
            public final void run() {
                h.mEJ.h(11425, new Object[]{Integer.valueOf(a$2.this.lHC.getType()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0)});
                a$2.this.lHC.bkm();
                a$2.this.lHC.bki();
                a.b(a$2.this.lHC);
                a$2.this.lHC.lHu.dismiss();
            }
        });
    }
}
