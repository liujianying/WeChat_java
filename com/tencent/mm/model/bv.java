package com.tencent.mm.model;

import com.tencent.mm.ab.d;
import com.tencent.mm.ab.d.b;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bv implements d {
    private Map<String, List<a>> dDA = new HashMap();
    private Map<String, List<n>> dDB = new HashMap();
    private Map<String, m> dDC = new ConcurrentHashMap();
    private Map<String, List<a>> dDz = new HashMap();

    public interface a {
        void a(com.tencent.mm.ab.d.a aVar);
    }

    @Deprecated
    public final void a(String str, a aVar, boolean z) {
        if (!bi.oW(str) && aVar != null) {
            Map map = z ? this.dDA : this.dDz;
            List list = (List) map.get(str);
            if (list == null) {
                list = new LinkedList();
                map.put(str, list);
            }
            if (!list.contains(aVar)) {
                list.add(aVar);
            }
        }
    }

    @Deprecated
    public final void b(String str, a aVar, boolean z) {
        if (!bi.oW(str) && aVar != null) {
            List list = (List) (z ? this.dDA : this.dDz).get(str);
            if (list != null) {
                list.remove(aVar);
            }
        }
    }

    public final void a(String str, n nVar) {
        if (!bi.oW(str) && nVar != null) {
            List list;
            synchronized (this.dDB) {
                List list2 = (List) this.dDB.get(str);
                if (list2 == null) {
                    LinkedList linkedList = new LinkedList();
                    this.dDB.put(str, linkedList);
                    list = linkedList;
                } else {
                    list = list2;
                }
            }
            synchronized (list) {
                if (!list.contains(nVar)) {
                    list.add(nVar);
                }
            }
        }
    }

    public final void b(String str, n nVar) {
        if (!bi.oW(str) && nVar != null) {
            List list;
            synchronized (this.dDB) {
                list = (List) this.dDB.get(str);
            }
            if (list != null) {
                synchronized (list) {
                    list.remove(nVar);
                }
            }
        }
    }

    public final void a(String str, m mVar) {
        if (!bi.oW(str) && mVar != null) {
            if (this.dDC.containsKey(str)) {
                x.w("MicroMsg.SysCmdMsgExtension", "NewXmlConsumer for %s has exist! %s", str, bi.cjd());
            }
            this.dDC.put(str, mVar);
        }
    }

    public final void b(String str, m mVar) {
        if (!bi.oW(str) && mVar != null) {
            synchronized (this.dDC) {
                this.dDC.remove(str);
            }
        }
    }

    public final b b(com.tencent.mm.ab.d.a aVar) {
        by byVar = aVar.dIN;
        switch (byVar.jQd) {
            case 10001:
                String a = ab.a(byVar.rcj);
                ab.a(byVar.rcl);
                a(a, aVar, false);
                f.mDy.k(10395, String.valueOf(byVar.rcq));
                return null;
            case 10002:
                String a2 = ab.a(byVar.rcl);
                if (bi.oW(a2)) {
                    x.e("MicroMsg.SysCmdMsgExtension", "null msg content");
                    return null;
                }
                Map map;
                String str;
                if (a2.startsWith("~SEMI_XML~")) {
                    Map WA = ay.WA(a2);
                    if (WA == null) {
                        x.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", a2);
                        return null;
                    }
                    map = WA;
                    str = "brand_service";
                } else {
                    int indexOf = a2.indexOf("<sysmsg");
                    if (indexOf == -1) {
                        x.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg");
                        return null;
                    }
                    x.d("MicroMsg.SysCmdMsgExtension", "oneliang, msg content:%s,sub content:%s", a2, a2.substring(indexOf));
                    Map z = bl.z(r0, "sysmsg");
                    if (z == null) {
                        x.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", a2);
                        return null;
                    }
                    map = z;
                    str = (String) z.get(".sysmsg.$type");
                }
                x.d("MicroMsg.SysCmdMsgExtension", "recieve a syscmd_newxml %s subType %s", a2, str);
                if (str != null) {
                    List<n> list;
                    a(str, aVar, true);
                    synchronized (this.dDB) {
                        list = (List) this.dDB.get(str);
                    }
                    if (list == null || list.isEmpty()) {
                        x.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
                    } else {
                        x.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", Integer.valueOf(list.size()));
                        synchronized (list) {
                            for (n onNewXmlReceived : list) {
                                onNewXmlReceived.onNewXmlReceived(str, map, aVar);
                            }
                        }
                    }
                    m mVar = (m) this.dDC.get(str);
                    if (mVar != null) {
                        return mVar.a(str, map, aVar);
                    }
                    x.e("MicroMsg.SysCmdMsgExtension", "no NewXmlConsumer to consume cmd %s!!", str);
                }
                return null;
            default:
                x.w("MicroMsg.SysCmdMsgExtension", "cmdAM msgType is %d, ignore, return now", Integer.valueOf(byVar.jQd));
                return null;
        }
    }

    @Deprecated
    private void a(String str, com.tencent.mm.ab.d.a aVar, boolean z) {
        List<a> list = (List) (z ? this.dDA : this.dDz).get(str);
        if (list == null || list.isEmpty()) {
            x.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
            return;
        }
        x.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", Integer.valueOf(list.size()));
        for (a a : list) {
            a.a(aVar);
        }
    }

    public final void h(bd bdVar) {
    }
}
