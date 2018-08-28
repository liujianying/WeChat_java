package com.tencent.mm.modelmulti;

import com.tencent.mm.g.c.cm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.c;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.Iterator;

class b$1 implements a {
    final /* synthetic */ b dYL;

    b$1(b bVar) {
        this.dYL = bVar;
    }

    public final void a(f fVar, c cVar) {
        if (fVar != null && cVar != null) {
            try {
                if (cVar.lcy != null && cVar.lcx != null && cVar.lcx.equals("delete")) {
                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr msgListener delete msg count[%s] list[%s]", new Object[]{Integer.valueOf(cVar.lcB), Integer.valueOf(cVar.lcy.size())});
                    Iterator it = cVar.lcy.iterator();
                    while (it.hasNext()) {
                        cm cmVar = (bd) it.next();
                        if (!(cmVar == null || cmVar.field_msgId == 0 || cmVar.field_msgSeq <= 0 || (cmVar.field_flag & 1) == 0)) {
                            cm W;
                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr msgListener check fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[]{Integer.valueOf(cmVar.field_flag), Integer.valueOf(cmVar.field_isSend), Long.valueOf(cmVar.field_msgId), Long.valueOf(cmVar.field_msgSvrId), Long.valueOf(cmVar.field_msgSeq), Long.valueOf(cmVar.field_createTime), Integer.valueOf(cmVar.getType()), cmVar.field_talker});
                            if ((cmVar.field_flag & 4) == 0) {
                                W = ((i) g.l(i.class)).bcY().W(cmVar.field_talker, cmVar.field_msgSeq);
                            } else {
                                W = ((i) g.l(i.class)).bcY().V(cmVar.field_talker, cmVar.field_msgSeq);
                            }
                            if (!(W == null || W.field_msgId == 0)) {
                                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr msgListener delete msg check next fault[%d, %d, %d, %d, %d, %d, %d, %s]", new Object[]{Integer.valueOf(W.field_flag), Integer.valueOf(W.field_isSend), Long.valueOf(W.field_msgId), Long.valueOf(W.field_msgSvrId), Long.valueOf(W.field_msgSeq), Long.valueOf(W.field_createTime), Integer.valueOf(W.getType()), W.field_talker});
                                W.fg(cmVar.field_flag);
                                ((i) g.l(i.class)).bcY().a(W.field_msgId, W);
                            }
                        }
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GetChatRoomMsgService", e, "delete msg", new Object[0]);
            }
        }
    }
}
