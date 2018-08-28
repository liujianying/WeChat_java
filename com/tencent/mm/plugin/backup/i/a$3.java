package com.tencent.mm.plugin.backup.i;

import android.database.Cursor;
import com.tencent.mm.g.a.jq;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.z.c.a;
import com.tencent.mm.plugin.z.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.LinkedList;

class a$3 extends c<jq> {
    final /* synthetic */ a hdj;

    a$3(a aVar) {
        this.hdj = aVar;
        this.sFo = jq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        final jq jqVar = (jq) bVar;
        if (!(jqVar == null || !(jqVar instanceof jq) || jqVar.bTp == null)) {
            x.i("MicroMsg.BackupCore", "receive msgSynchronizeStartEvent.");
            au.Em().H(new Runnable() {
                public final void run() {
                    jq jqVar = jqVar;
                    x.i("MicroMsg.BackupCore", "receive msgSynchronizeStartEvent run userCloseMsgSync[%b]", new Object[]{Boolean.valueOf(jqVar.bTp.bTs)});
                    if (jqVar.bTp.bTs) {
                        h.mEJ.a(466, 13, 1, false);
                        return;
                    }
                    byte[] bArr = jqVar.bTp.bTq;
                    if (bArr == null) {
                        x.e("MicroMsg.BackupCore", "msgsynchronize loginconfirmok key is null!");
                        h.mEJ.a(466, 14, 1, false);
                        return;
                    }
                    int i = jqVar.bTp.bTr;
                    if (e.lsG == null) {
                        e.lsG = new e();
                    }
                    e eVar = e.lsG;
                    x.i("MicroMsg.MsgSynchronizeServer", "msg synchronize start, loginDevice[%d]", new Object[]{Integer.valueOf(i)});
                    h.mEJ.a(466, 0, 1, false);
                    eVar.lsM = bi.VF();
                    eVar.lsI = bArr;
                    eVar.bTr = i;
                    d.asG().asJ();
                    eVar.lsH.lsB = eVar;
                    eVar.lsH.lsA = false;
                    com.tencent.mm.plugin.z.c cVar = eVar.lsH;
                    long VF = bi.VF();
                    LinkedList linkedList = new LinkedList();
                    Cursor b = d.asG().asH().FW().b(s.dAN, g.arb(), "*");
                    if (b.getCount() == 0) {
                        x.i("MicroMsg.MsgSynchronizePack", "empty conversation!");
                        b.close();
                    } else {
                        b.moveToFirst();
                        x.i("MicroMsg.MsgSynchronizePack", "calculateConversationList count:%d", new Object[]{Integer.valueOf(b.getCount())});
                        while (!cVar.lsA) {
                            ai aiVar = new ai();
                            aiVar.d(b);
                            if (!bi.oW(aiVar.field_username)) {
                                x.i("MicroMsg.MsgSynchronizePack", "calculateConversationList user:%s msgCnt:%d", new Object[]{aiVar.field_username, Integer.valueOf(d.asG().asH().FT().GT(aiVar.field_username))});
                                if (d.asG().asH().FT().GT(aiVar.field_username) > 0) {
                                    linkedList.add(new a(aiVar.field_username));
                                }
                            }
                            if (!b.moveToNext()) {
                                b.close();
                                x.i("MicroMsg.MsgSynchronizePack", "calculateConversationList loading time:" + bi.bH(VF));
                                break;
                            }
                        }
                        b.close();
                    }
                    x.i("MicroMsg.MsgSynchronizeServer", "calculateConversationList finish. conversationList size:%d", new Object[]{Integer.valueOf(linkedList.size())});
                    if (linkedList.size() == 0) {
                        x.e("MicroMsg.MsgSynchronizeServer", "No conversation to synchronize");
                        long bH = bi.bH(eVar.lsM);
                        h.mEJ.a(466, 1, 1, false);
                        h.mEJ.a(466, 5, 0, false);
                        h.mEJ.a(466, 7, bH, false);
                        h.mEJ.a(466, 11, 0, false);
                        h.mEJ.a(466, 12, 0, false);
                        h.mEJ.h(14108, new Object[]{Integer.valueOf(0), Long.valueOf(bH), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i)});
                    } else if (com.tencent.mm.plugin.z.b.lsz < 0) {
                        eVar.lsH.b(linkedList, (long) com.tencent.mm.plugin.z.b.lsz);
                    } else {
                        eVar.lsH.b(linkedList, bi.bH((long) ((((com.tencent.mm.plugin.z.b.lsz * 24) * 60) * 60) * BaseReportManager.MAX_READ_COUNT)));
                    }
                }
            });
        }
        return false;
    }
}
