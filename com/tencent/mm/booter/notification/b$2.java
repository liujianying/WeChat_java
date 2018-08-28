package com.tencent.mm.booter.notification;

import com.tencent.mm.g.a.oc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

class b$2 extends c<oc> {
    final /* synthetic */ b cYv;

    b$2(b bVar) {
        this.cYv = bVar;
        this.sFo = oc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        oc ocVar = (oc) bVar;
        if (ocVar != null && (ocVar instanceof oc)) {
            bd bdVar = ocVar.bYY.bXQ;
            if (bdVar != null) {
                b bVar2 = this.cYv;
                if (bdVar.field_isSend == 1) {
                    x.w("MicroMsg.MMNotification", "notifyRevorkMessage is sender , msgid:%d ", new Object[]{Long.valueOf(bdVar.field_msgSvrId)});
                } else {
                    bVar2.bXQ = bdVar;
                    int b = b.b(bdVar);
                    bVar2.talker = bdVar.field_talker;
                    String str = bdVar.field_content;
                    int type = bdVar.getType();
                    bVar2.cYk = "";
                    bVar2.cYl = null;
                    x.i("MicroMsg.MMNotification", "notifyRevorkMessage talker:%s msgid:%d type:%d tipsFlag:%d content:%s", new Object[]{bVar2.talker, Long.valueOf(bdVar.field_msgSvrId), Integer.valueOf(type), Integer.valueOf(b), bi.Xf(str)});
                    if (f.a(bVar2.talker, bVar2.bXQ, b, true)) {
                        bVar2.cYs.sendMessageDelayed(b.b(bVar2.talker, str, type, b, 1), 200);
                    } else {
                        x.w("MicroMsg.MMNotification", "[no notificaion], preNotificationCheck");
                    }
                }
            }
        }
        return false;
    }
}
