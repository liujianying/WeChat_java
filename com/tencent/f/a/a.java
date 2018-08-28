package com.tencent.f.a;

import com.tencent.f.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a {
    public Object sNC = new Object();
    public HashMap<String, Object> vwN = new HashMap();
    c vwO;

    public final void a(d dVar, String[] strArr) {
        if (dVar != null && strArr != null) {
            synchronized (this.sNC) {
                for (Object obj : strArr) {
                    if (obj != null) {
                        Object obj2 = this.vwN.get(obj);
                        if (obj2 == null) {
                            this.vwN.put(obj, dVar);
                        } else if (obj2 instanceof d) {
                            d dVar2 = (d) obj2;
                            if (dVar2 == dVar) {
                                return;
                            }
                            LinkedList linkedList = new LinkedList();
                            linkedList.add(dVar2);
                            linkedList.add(dVar);
                            this.vwN.put(obj, linkedList);
                        } else if (obj2 instanceof List) {
                            LinkedList linkedList2 = (LinkedList) obj2;
                            if (linkedList2.indexOf(dVar) >= 0) {
                                return;
                            }
                            linkedList2.add(dVar);
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
    }

    public final void c(String str, int i, Object obj) {
        c cVar = this.vwO;
        e cHq = cVar.cHq();
        if (cHq == null) {
            cHq = cVar.cHp();
        } else {
            cHq.reset();
        }
        e eVar = (e) cHq;
        eVar.bTQ = str;
        eVar.vwQ = i;
        eVar.arg1 = 0;
        eVar.arg2 = 0;
        eVar.obj = obj;
        if (eVar != null && eVar.bTQ != null) {
            d dVar;
            LinkedList linkedList;
            System.currentTimeMillis();
            String str2 = eVar.bTQ;
            synchronized (this.sNC) {
                Object obj2 = this.vwN.get(str2);
                if (obj2 != null) {
                    if (obj2 instanceof d) {
                        dVar = (d) obj2;
                        linkedList = null;
                    } else if (obj2 instanceof List) {
                        dVar = null;
                        linkedList = (LinkedList) ((LinkedList) obj2).clone();
                    }
                }
                dVar = null;
                linkedList = null;
            }
            if (dVar != null) {
                dVar.dE(str2, eVar.vwQ);
            }
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).dE(str2, eVar.vwQ);
                }
            }
            cVar = this.vwO;
            synchronized (cVar.mLock) {
                if (cVar.ndo < cVar.vwz.length) {
                    cVar.vwz[cVar.ndo] = eVar;
                    cVar.ndo++;
                }
            }
        }
    }
}
