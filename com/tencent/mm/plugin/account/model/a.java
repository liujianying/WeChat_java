package com.tencent.mm.plugin.account.model;

import android.os.Message;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class a implements e {
    b dRz = new 3(this);
    Set<String> eNM = Collections.synchronizedSet(new HashSet());
    c eNN = new 1(this);
    ag eNO = new ag() {
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    a.this.egv = true;
                    if (!com.tencent.mm.platformtools.b.syncAddrBook(a.this.dRz)) {
                        a.this.egv = false;
                    }
                    x.i("MicroMsg.ContactsAutoSyncLogic ", "sync result %b", new Object[]{Boolean.valueOf(r0)});
                    return;
                default:
                    return;
            }
        }
    };
    boolean egv = false;

    public a() {
        com.tencent.mm.sdk.b.a.sFg.b(this.eNN);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == 133) {
            g.DF().b(133, this);
            if (i == 0 && i2 == 0) {
                g.DF().a(32, this);
                al alVar = (al) lVar;
                g.DF().a(new ab(alVar.eLj, alVar.eLk), 0);
            } else {
                x.e("MicroMsg.ContactsAutoSyncLogic ", "MMFunc_UploadMContact onSceneEnd: errType = " + i + ", errCode = " + i2);
                this.egv = false;
            }
        }
        if (lVar.getType() == 32) {
            this.egv = false;
            g.DF().b(32, this);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.ContactsAutoSyncLogic ", "update All Contact");
                com.tencent.mm.platformtools.x.cb(ad.getContext());
                return;
            }
            x.e("MicroMsg.ContactsAutoSyncLogic ", "rtGETMFRIEND onSceneEnd: errType = " + i + ", errCode = " + i2);
        }
    }
}
