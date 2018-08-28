package com.tencent.mm.modelmulti;

import com.tencent.mm.ab.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aw;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public final class b implements a {
    boolean dGS = false;
    long dHc = 0;
    Queue<b> dSN = new LinkedList();
    al dSR = new al(au.Em().lnJ.getLooper(), new 4(this), false);
    final al dSS = new al(au.Em().lnJ.getLooper(), new 6(this), true);
    Map<String, LinkedList<a>> dYE = new HashMap();
    LinkedBlockingQueue<a> dYF = new LinkedBlockingQueue();
    c dYG;
    Map<Long, aw> dYH = new HashMap();
    f.a dYI = new 1(this);
    al dYJ = new al(au.Em().lnJ.getLooper(), new 3(this), false);
    int dYK;

    static /* synthetic */ void f(Map map, String str) {
        if (map.size() != 0 && !ai.oW(str)) {
            Iterator it = map.values().iterator();
            if (it != null) {
                while (it.hasNext()) {
                    aw awVar = (aw) it.next();
                    if (awVar != null && str.equals(awVar.field_fromUserName)) {
                        au.HU();
                        if (c.FT().I(str, awVar.field_originSvrId).field_msgId != 0) {
                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr dealSysCmdMsg msg id[%d], originsvrid[%d]", new Object[]{Long.valueOf(c.FT().I(str, awVar.field_originSvrId).field_msgId), Long.valueOf(c.FT().I(str, awVar.field_originSvrId).field_msgSvrId)});
                            by byVar = new by();
                            byVar.rcq = awVar.field_newMsgId;
                            byVar.rcj = ab.oT(awVar.field_fromUserName);
                            byVar.rck = ab.oT(awVar.field_toUserName);
                            byVar.lOH = (int) awVar.field_createTime;
                            byVar.rcl = ab.oT(awVar.field_content);
                            byVar.rco = awVar.field_msgSource;
                            byVar.rcr = awVar.field_msgSeq;
                            int i = awVar.field_flag;
                            byVar.jQd = 10002;
                            com.tencent.mm.plugin.report.f.mDy.a(403, 35, 1, false);
                            au.getSysCmdMsgExtension().b(new d.a(byVar, (i & 2) != 0, (i & 1) != 0, (i & 4) != 0));
                        }
                    }
                }
            }
        }
    }

    b() {
    }

    public final void a(String str, l lVar) {
        if (!ai.oW(str)) {
            try {
                long longValue = Long.valueOf(str).longValue();
                aw awVar = new aw();
                awVar.field_originSvrId = longValue;
                if (o.PO().PL().b(awVar, new String[0])) {
                    this.dYH.put(Long.valueOf(longValue), awVar);
                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr onNotifyChange put info systemRowid[%d], svrId[%d]", new Object[]{Long.valueOf(awVar.sKx), Long.valueOf(longValue)});
                    return;
                }
                this.dYH.remove(Long.valueOf(longValue));
                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr onNotifyChange remove info svrId[%d]", new Object[]{Long.valueOf(longValue)});
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GetChatRoomMsgService", e, "summerbadcr onNotifyChange:", new Object[0]);
            }
        }
    }

    public final boolean a(a aVar, c cVar) {
        if (!b(aVar, cVar)) {
            return false;
        }
        this.dSR.J(0, 0);
        return true;
    }

    public final boolean a(a aVar) {
        if (aVar.dYP != 0) {
            return false;
        }
        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr clearChatRoomMsg info:%s, stack[%s]", new Object[]{aVar, ai.VI()});
        if (!this.dYF.add(aVar)) {
            return false;
        }
        this.dSR.J(0, 0);
        return true;
    }

    private boolean b(a aVar, c cVar) {
        if (aVar == null || cVar == null || ai.oW(aVar.dYN) || !aVar.dYN.equals(cVar.PE())) {
            return false;
        }
        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr addChatRoomMsg info:%s", new Object[]{aVar});
        synchronized (this.dYE) {
            LinkedList linkedList = (LinkedList) this.dYE.get(aVar.dYN);
            if (linkedList == null) {
                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr addChatRoomMsg new infos and add ret:%b, infos[%d], needGetInfosMap[%s]", new Object[]{Boolean.valueOf(linkedList.add(aVar)), Integer.valueOf(new LinkedList().hashCode()), this.dYE});
                this.dYE.put(aVar.dYN, linkedList);
            } else {
                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr addChatRoomMsg infos size:%s ", new Object[]{Integer.valueOf(linkedList.size())});
                if (linkedList.contains(aVar)) {
                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr addChatRoomMsg infos already exist %s ", new Object[]{aVar});
                } else {
                    linkedList.addLast(aVar);
                }
                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr addChatRoomMsg to infos first:%b, infos[%d], size:%d, needGetInfosMap[%s]", new Object[]{Boolean.valueOf(false), Integer.valueOf(linkedList.hashCode()), Integer.valueOf(linkedList.size()), this.dYE});
            }
            this.dYG = cVar;
        }
        return true;
    }
}
