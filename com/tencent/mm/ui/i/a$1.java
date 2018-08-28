package com.tencent.mm.ui.i;

import android.content.Context;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.f.a.e;
import com.tencent.mm.ui.i.a.c;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

class a$1 extends ag {
    final /* synthetic */ a uFi;

    a$1(a aVar) {
        this.uFi = aVar;
    }

    public final void handleMessage(Message message) {
        if (message.what == BaseReportManager.MAX_READ_COUNT) {
            String str = (String) message.obj;
            if (str != null) {
                Context context = this.uFi.context;
                a aVar = this.uFi;
                if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
                    e.E(context, "Error", "Application requires permission to access the Internet");
                } else {
                    new b(context, str, aVar).show();
                }
            } else {
                this.uFi.c(c.uFm);
            }
        }
        if (message.what == 1010) {
            c cVar = (c) message.obj;
            a aVar2 = this.uFi;
            aVar2.uFf = false;
            if (cVar == c.uFm) {
                aVar2.uFd = null;
                a.a(null);
            }
            if (aVar2.uFh != null) {
                aVar2.uFh.b(cVar);
            }
        }
    }
}
