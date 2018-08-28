package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.ab.d.a;
import com.tencent.mm.ab.d.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.bsm;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d implements com.tencent.mm.ab.d {
    public final b b(a aVar) {
        int i = 1;
        by byVar = aVar.dIN;
        if (byVar == null) {
            x.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM is null");
        } else if (byVar.jQd != 56) {
            x.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM.type:%d", new Object[]{Integer.valueOf(byVar.jQd)});
        } else {
            String a = ab.a(byVar.rcj);
            String a2 = ab.a(byVar.rck);
            au.HU();
            if (!((String) c.DT().get(2, null)).equals(a)) {
                a2 = a;
            }
            au.HU();
            com.tencent.mm.storage.ab Yg = c.FR().Yg(a2);
            if (Yg == null || ((int) Yg.dhP) == 0) {
                au.HU();
                c.FR().T(new com.tencent.mm.storage.ab(a2));
            }
            String a3 = ab.a(byVar.rcl);
            x.d("MicroMsg.TalkRoomExtension", "talkroom xml:" + a3);
            Map z = bl.z(a3, "talkroominfo");
            if (z != null) {
                try {
                    int i2;
                    String str;
                    String bs;
                    if (Oq((String) z.get(".talkroominfo.tracksysmsgtype")) == 0) {
                        Oq((String) z.get(".talkroominfo.sysmsgtype"));
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    Object linkedList = new LinkedList();
                    Oq((String) z.get(".talkroominfo.membersize"));
                    int i3 = 0;
                    while (true) {
                        str = ".talkroominfo.memberlist.member" + (i3 == 0 ? "" : Integer.valueOf(i3));
                        a3 = (String) z.get(str + ".username");
                        if (bi.oW(a3)) {
                            break;
                        }
                        int Oq = Oq((String) z.get(str + ".memberid"));
                        bsm bsm = new bsm();
                        bsm.hbL = a3;
                        bsm.spS = Oq;
                        linkedList.add(bsm);
                        i3++;
                    }
                    if (a2.equals(b.bGT().owU)) {
                        str = br(linkedList);
                        bs = bi.oW(str) ? bs(linkedList) : null;
                    } else {
                        bs = null;
                        str = null;
                    }
                    e bGU = b.bGU();
                    if (i2 != 0) {
                        i = 0;
                    }
                    bGU.a(a2, linkedList, str, bs, i);
                } catch (Throwable e) {
                    x.e("MicroMsg.TalkRoomExtension", "parsing memList xml failed");
                    x.printErrStackTrace("MicroMsg.TalkRoomExtension", e, "", new Object[0]);
                }
            }
        }
        return null;
    }

    public final void h(bd bdVar) {
    }

    private static int Oq(String str) {
        int i = 0;
        if (bi.oW(str)) {
            return i;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomExtension", e, "", new Object[i]);
            return i;
        }
    }

    private static String br(List<bsm> list) {
        List<bsm> aZp = b.bGT().aZp();
        List linkedList = new LinkedList();
        for (bsm bsm : list) {
            Object obj;
            for (bsm bsm2 : aZp) {
                if (bsm2.hbL.equals(bsm.hbL)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                linkedList.add(bsm.hbL);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            String str = (String) linkedList.get(i);
            if (!str.equals(q.GF())) {
                return str;
            }
        }
        return null;
    }

    private static String bs(List<bsm> list) {
        List<bsm> aZp = b.bGT().aZp();
        List linkedList = new LinkedList();
        for (bsm bsm : aZp) {
            Object obj;
            for (bsm bsm2 : list) {
                if (bsm2.hbL.equals(bsm.hbL)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                linkedList.add(bsm.hbL);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            String str = (String) linkedList.get(i);
            if (!str.equals(q.GF())) {
                return str;
            }
        }
        return null;
    }
}
