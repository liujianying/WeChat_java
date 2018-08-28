package com.tencent.mm.plugin.record.b;

import com.tencent.mm.a.e;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class k$a implements Runnable {
    private g mrL;
    final /* synthetic */ k msk;

    public k$a(k kVar, g gVar) {
        this.msk = kVar;
        this.mrL = gVar;
    }

    public final void run() {
        Iterator it = this.mrL.field_dataProto.rBI.iterator();
        boolean z = false;
        while (it.hasNext()) {
            String str;
            String c;
            vx vxVar = (vx) it.next();
            if (!bi.oW(vxVar.rzo) || e.cn(vxVar.rzM)) {
                str = vxVar.rzM;
                c = h.c(vxVar, this.mrL.field_msgId);
                x.d("MicroMsg.RecordMsgSendService", "summerrecord CdnDataUrl[%s] copy[%s] to [%s] result[%B]", new Object[]{vxVar.rzo, str, c, Boolean.valueOf(j.q(str, c, false))});
                if (j.q(str, c, false)) {
                    if (bi.oW(vxVar.rzF)) {
                        x.i("MicroMsg.RecordMsgSendService", "summerrecord not find full md5, try to calculate");
                        vxVar.UM(com.tencent.mm.a.g.cu(c));
                        z = true;
                    }
                    if (bi.oW(vxVar.rzH)) {
                        x.i("MicroMsg.RecordMsgSendService", "summerrecord not find head 256 md5, try to calculate");
                        vxVar.UN(com.tencent.mm.a.g.cv(c));
                        z = true;
                    }
                }
                if (e.cm(c) != 0) {
                    vxVar.fO((long) e.cm(c));
                }
                str = h.e(vxVar.jdM, this.mrL.field_msgId, false);
                if (n.getRecordMsgCDNStorage().Kr(str) == null) {
                    f fVar = new f();
                    fVar.field_cdnKey = vxVar.rzq;
                    fVar.field_cdnUrl = vxVar.rzo;
                    fVar.field_dataId = vxVar.jdM;
                    fVar.field_mediaId = str;
                    fVar.field_totalLen = (int) vxVar.rzJ;
                    fVar.field_localId = fVar.field_mediaId.hashCode();
                    fVar.field_path = h.c(vxVar, this.mrL.field_msgId);
                    fVar.field_type = 2;
                    fVar.field_fileType = h.vn(vxVar.bjS);
                    fVar.field_recordLocalId = this.mrL.field_localId;
                    fVar.field_toUser = this.mrL.field_toUser;
                    fVar.field_isThumb = false;
                    boolean b = n.getRecordMsgCDNStorage().b(fVar);
                    x.d("MicroMsg.RecordMsgSendService", "summerrecord insert localId[%d] result[%B] fileType[%d], mediaId[%s]", new Object[]{Integer.valueOf(fVar.field_localId), Boolean.valueOf(b), Integer.valueOf(fVar.field_fileType), str});
                }
            }
            if (!bi.oW(vxVar.dwE) || e.cn(vxVar.rzO)) {
                str = vxVar.rzO;
                c = h.f(vxVar, this.mrL.field_msgId);
                x.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[]{str, c, Boolean.valueOf(j.q(str, c, false))});
                vxVar.fP((long) e.cm(c));
                if (j.q(str, c, false)) {
                    if (bi.oW(vxVar.rzQ)) {
                        x.i("MicroMsg.RecordMsgSendService", "not find ThumbMd5 md5, try to calculate");
                        vxVar.UR(com.tencent.mm.a.g.cu(c));
                        z = true;
                    }
                    if (bi.oW(vxVar.rzS)) {
                        x.i("MicroMsg.RecordMsgSendService", "not find Thumb Head 256 Md5, try to calculate");
                        vxVar.US(com.tencent.mm.a.g.cv(c));
                        z = true;
                    }
                }
                str = h.Ba(vxVar.jdM);
                c = h.e(str, this.mrL.field_msgId, false);
                if (n.getRecordMsgCDNStorage().Kr(c) == null) {
                    f fVar2 = new f();
                    fVar2.field_cdnKey = vxVar.rzk;
                    fVar2.field_cdnUrl = vxVar.dwE;
                    fVar2.field_dataId = str;
                    fVar2.field_mediaId = c;
                    fVar2.field_totalLen = (int) vxVar.rzU;
                    fVar2.field_localId = fVar2.field_mediaId.hashCode();
                    fVar2.field_path = h.f(vxVar, this.mrL.field_msgId);
                    fVar2.field_type = 2;
                    fVar2.field_fileType = b.MediaType_FULLSIZEIMAGE;
                    fVar2.field_recordLocalId = this.mrL.field_localId;
                    fVar2.field_toUser = this.mrL.field_toUser;
                    fVar2.field_isThumb = true;
                    boolean b2 = n.getRecordMsgCDNStorage().b(fVar2);
                    x.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[]{Integer.valueOf(fVar2.field_localId), Boolean.valueOf(b2)});
                }
            }
            z = z;
        }
        if (z) {
            x.d("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[]{Integer.valueOf(this.mrL.field_localId), Long.valueOf(this.mrL.field_msgId), Integer.valueOf(this.mrL.field_type)});
            n.bqv().c(this.mrL, new String[]{"localId"});
        }
        n.bqx().run();
    }
}
