package com.tencent.mm.az;

import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.g.a.fq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

class d$1 extends c<fq> {
    final /* synthetic */ d elp;

    d$1(d dVar) {
        this.elp = dVar;
        this.sFo = fq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fq fqVar = (fq) bVar;
        int i = fqVar.bOf.bOh;
        String str = fqVar.bOf.talker;
        int i2 = fqVar.bOf.state;
        if (i == 1) {
            as SF = d.SF();
            ar arVar = new ar();
            arVar.field_state = -1;
            Cursor b = SF.diF.b(String.format("select %s from %s where %s = %s", new Object[]{DownloadInfoColumns.STATE, "fmessage_conversation", "talker", h.fz(str)}), null, 2);
            if (b.moveToFirst()) {
                arVar.d(b);
            }
            b.close();
            i2 = arVar.field_state;
        } else if (i == 0) {
            if (i2 == 2) {
                d.SF().db(str, 2);
            } else if (i2 == 1) {
                d.SF().db(str, 1);
            } else {
                d.SF().db(str, 0);
            }
        }
        fqVar.bOg.state = i2;
        return false;
    }
}
