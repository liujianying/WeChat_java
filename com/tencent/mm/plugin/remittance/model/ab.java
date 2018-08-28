package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.remittance.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g.a;
import com.tencent.mm.y.h;
import java.util.HashMap;
import java.util.HashSet;

public final class ab {
    public static String TAG = "MicroMsg.RemittanceLocalMsgMgr";
    public Object lock;
    public HashSet<String> myE;
    public HashMap<String, String> myF;

    public ab() {
        this.myE = null;
        this.myF = new HashMap();
        this.myE = new HashSet();
        this.lock = new Object();
    }

    public final boolean Ky(String str) {
        boolean contains;
        synchronized (this.lock) {
            contains = this.myE.contains(str);
        }
        return contains;
    }

    private synchronized boolean Kz(String str) {
        boolean z;
        if (this.myE.contains(str)) {
            x.i(TAG, "it is a duplicate msg");
            z = false;
        } else {
            z = this.myE.add(str);
        }
        return z;
    }

    public final boolean en(String str, String str2) {
        String str3 = (String) this.myF.get(str);
        if (!bi.oW(str3)) {
            return V(str, str3, str2);
        }
        x.w(TAG, "empty transid: %s", new Object[]{str});
        return false;
    }

    public final boolean V(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str)) {
            x.e(TAG, "msgxml or toUserName or antiRepeatid is null");
            return false;
        } else if (!Kz(str)) {
            return false;
        } else {
            bd bdVar = new bd();
            bdVar.setContent(str2);
            bdVar.setStatus(2);
            bdVar.ep(str3);
            bdVar.ay(com.tencent.mm.model.bd.iD(str3));
            bdVar.eX(1);
            bdVar.setType(419430449);
            long T = ((i) g.l(i.class)).bcY().T(bdVar);
            if (T < 0) {
                x.e(TAG, com.tencent.mm.compatible.util.g.Ac() + "insert msg failed :" + T);
                this.myE.remove(str);
                return false;
            }
            boolean b;
            bdVar.setMsgId(T);
            if (bdVar.aQm()) {
                b.ehL.a(bdVar, h.g(bdVar));
            } else {
                b.ehL.f(bdVar);
            }
            com.tencent.mm.y.g gVar = new com.tencent.mm.y.g();
            gVar.field_xml = bdVar.field_content;
            String WT = bi.WT(str2);
            a aVar = null;
            if (WT != null) {
                aVar = a.J(WT, bdVar.field_reserved);
                if (aVar != null) {
                    gVar.field_title = aVar.title;
                    gVar.field_description = aVar.description;
                }
            }
            gVar.field_type = 2000;
            gVar.field_msgId = T;
            com.tencent.mm.y.g fI = com.tencent.mm.plugin.ac.a.bmg().fI(T);
            if (fI == null || fI.field_msgId != T) {
                b = com.tencent.mm.plugin.ac.a.bmg().b(gVar);
                if (!b) {
                    x.e(TAG, "PinOpenApi.getAppMessageStorage().insert msg failed id:" + T);
                }
            } else {
                b = com.tencent.mm.plugin.ac.a.bmg().c(gVar, new String[0]);
            }
            if (aVar != null) {
                c cVar = new c();
                cVar.field_locaMsgId = bdVar.field_msgId;
                cVar.field_transferId = aVar.dxB;
                cVar.field_receiveStatus = -1;
                cVar.field_isSend = true;
                com.tencent.mm.plugin.remittance.a.b.bqQ();
                com.tencent.mm.plugin.remittance.a.b.bqS().a(cVar);
            }
            return b;
        }
    }
}
