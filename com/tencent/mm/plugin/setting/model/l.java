package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public final class l {
    public final ah dqM;
    public long jIL;
    Object mLock = new Object();
    public boolean mOS;
    public boolean mOT;
    public boolean mOU;
    final CountDownLatch mOV;
    HashSet<String> mOW = new HashSet();
    HashSet<String> mOX = new HashSet();
    HashSet<String> mOY = new HashSet();
    HashSet<String> mOZ = new HashSet();
    public a mPa;
    public h mPb;
    public Runnable mRunnable;

    static /* synthetic */ void a(l lVar, LinkedList linkedList) {
        if (lVar.mOT) {
            lVar.mPa = new a(lVar, lVar.mPb, lVar.mOV);
            a aVar = lVar.mPa;
            aVar.start = System.currentTimeMillis();
            g.DF().a(292, aVar);
            a.btr();
        }
        if (lVar.mOS) {
            HashSet hashSet = new HashSet();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                hashSet.add((String) it.next());
            }
            long currentTimeMillis = System.currentTimeMillis() - 15552000000L;
            x.i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] timestamp:%s size:%s", new Object[]{Long.valueOf(currentTimeMillis), Integer.valueOf(hashSet.size())});
            long currentTimeMillis2 = System.currentTimeMillis();
            i iVar = new i();
            iVar.jsn = 9;
            iVar.bWm = String.valueOf(currentTimeMillis);
            iVar.jsv = new 3(lVar, hashSet, currentTimeMillis, currentTimeMillis2);
            iVar.handler = lVar.dqM.cil();
            ((n) g.n(n.class)).search(2, iVar);
        }
        if (lVar.mOU) {
            lVar.f(linkedList, 0);
        }
        Runnable anonymousClass2 = new Runnable() {
            public final void run() {
                try {
                    l.this.mOV.await();
                    long currentTimeMillis = System.currentTimeMillis();
                    l.this.mOW.clear();
                    l.this.mOX.remove(q.GF());
                    l.this.mOW.addAll(l.this.mOX);
                    l.this.mOW.addAll(l.this.mOY);
                    l.this.mOW.addAll(l.this.mOZ);
                    if (l.this.mOT) {
                        l.this.mOW.retainAll(l.this.mOZ);
                    }
                    if (l.this.mOU) {
                        l.this.mOW.retainAll(l.this.mOY);
                    }
                    if (l.this.mOS) {
                        l.this.mOW.retainAll(l.this.mOX);
                    }
                    l.this.mPb.e(l.this.mOW);
                    x.i("MicroMsg.UnfamiliarContactEngine", "[onResult] :%sms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    ah.A(new 1(this));
                    x.i("MicroMsg.UnfamiliarContactEngine", "all cost:%sms", new Object[]{Long.valueOf(System.currentTimeMillis() - l.this.jIL)});
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.UnfamiliarContactEngine", e, "", new Object[0]);
                    ah.A(new 2(this));
                }
            }
        };
        lVar.mRunnable = anonymousClass2;
        e.post(anonymousClass2, "MicroMsg.UnfamiliarContactEngineAwait");
    }

    public l(boolean z, boolean z2, boolean z3, h hVar) {
        this.mOS = z;
        this.mOT = z2;
        this.mOU = z3;
        x.i("MicroMsg.UnfamiliarContactEngine", "[UnfamiliarContactEngine] count:%s [%s:%s:%s]", new Object[]{Integer.valueOf((this.mOU ? 1 : 0) + ((this.mOS ? 1 : 0) + (this.mOT ? 1 : 0))), Boolean.valueOf(this.mOT), Boolean.valueOf(this.mOS), Boolean.valueOf(this.mOU)});
        this.mOV = new CountDownLatch(r0);
        this.dqM = new ah("UnfamiliarContactEngine");
        this.mPb = hVar;
    }

    final void f(LinkedList<String> linkedList, int i) {
        final long currentTimeMillis = System.currentTimeMillis();
        final int size = i + 10 < linkedList.size() ? i + 10 : linkedList.size();
        final List subList = linkedList.subList(i, size);
        i iVar = new i();
        iVar.jsn = 8;
        iVar.bWm = bi.c(subList, ",");
        final LinkedList<String> linkedList2 = linkedList;
        iVar.jsv = new com.tencent.mm.plugin.fts.a.l() {
            final int limit = size;

            public final void b(j jVar) {
                List list = jVar.jsx;
                String str;
                String str2;
                Object[] objArr;
                boolean z;
                int i;
                Object[] objArr2;
                Object[] objArr3;
                if (list == null || list.size() <= 0) {
                    str = "MicroMsg.UnfamiliarContactEngine";
                    str2 = "[getSameChatInfoTask] list is null? %s ";
                    objArr = new Object[1];
                    if (subList == null) {
                        z = true;
                        i = 0;
                        objArr2 = objArr;
                        objArr3 = objArr;
                    } else {
                        z = false;
                        i = 0;
                        objArr2 = objArr;
                        objArr3 = objArr;
                    }
                    objArr2[i] = Boolean.valueOf(z);
                    x.e(str, str2, objArr3);
                } else {
                    com.tencent.mm.plugin.fts.a.a.l lVar = (com.tencent.mm.plugin.fts.a.a.l) list.get(0);
                    if (lVar.userData == null || !(lVar.userData instanceof HashMap)) {
                        boolean z2;
                        str = "MicroMsg.UnfamiliarContactEngine";
                        str2 = "[getSameChatInfoTask] is null?%s is instanceof List";
                        objArr = new Object[2];
                        if (lVar.userData == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objArr[0] = Boolean.valueOf(z2);
                        z = lVar.userData instanceof HashMap;
                        i = 1;
                        objArr2 = objArr;
                        objArr3 = objArr;
                        objArr2[i] = Boolean.valueOf(z);
                        x.e(str, str2, objArr3);
                    } else {
                        HashMap hashMap = (HashMap) lVar.userData;
                        synchronized (l.this.mLock) {
                            for (String str3 : subList) {
                                if (hashMap.containsKey(str3)) {
                                    int i2;
                                    for (com.tencent.mm.plugin.fts.a.a.l lVar2 : (List) hashMap.get(str3)) {
                                        if (lVar2.jsA < 100) {
                                            i2 = 1;
                                            break;
                                        }
                                    }
                                    i2 = 0;
                                    if (i2 == 0) {
                                        l.this.mOY.add(str3);
                                    }
                                } else {
                                    l.this.mOY.add(str3);
                                }
                            }
                        }
                    }
                }
                if (this.limit >= linkedList2.size()) {
                    x.i("MicroMsg.UnfamiliarContactEngine", "[getSameChatInfoTask] finish all load! userNames.size:%s cost:%sms", new Object[]{Integer.valueOf(linkedList2.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    l.this.mOV.countDown();
                    return;
                }
                l.this.f(linkedList2, this.limit);
            }
        };
        iVar.handler = this.dqM.cil();
        ((n) g.n(n.class)).search(2, iVar);
    }
}
