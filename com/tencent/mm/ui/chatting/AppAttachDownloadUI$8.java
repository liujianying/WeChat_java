package com.tencent.mm.ui.chatting;

import com.tencent.mm.a.e;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.x;

class AppAttachDownloadUI$8 implements Runnable {
    final /* synthetic */ AppAttachDownloadUI tGp;
    final /* synthetic */ b tGq;
    final /* synthetic */ b tGr;

    AppAttachDownloadUI$8(AppAttachDownloadUI appAttachDownloadUI, b bVar, b bVar2) {
        this.tGp = appAttachDownloadUI;
        this.tGq = bVar;
        this.tGr = bVar2;
    }

    public final void run() {
        boolean c;
        long currentTimeMillis = System.currentTimeMillis();
        long y = e.y(this.tGq.field_fileFullPath, this.tGr.field_fileFullPath);
        if (y > 0) {
            this.tGr.field_offset = y;
            if (AppAttachDownloadUI.b(this.tGr)) {
                this.tGr.field_status = 199;
            }
            c = ao.asF().c(this.tGr, new String[0]);
        } else {
            c = false;
        }
        x.i("MicroMsg.AppAttachDownloadUI", "summerapp copyAttachFromLocal size[%d], id[%d, %d], ret[%b], new status[%d], take[%d]ms", new Object[]{Long.valueOf(y), Long.valueOf(this.tGq.field_msgInfoId), Long.valueOf(this.tGr.field_msgInfoId), Boolean.valueOf(c), Long.valueOf(this.tGr.field_status), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }
}
