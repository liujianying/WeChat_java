package com.tencent.mm.plugin.card.b;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.ak;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.s;
import com.tencent.mm.plugin.card.model.w;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b implements e {
    public byte[] dsN = new byte[0];
    private s htA;
    public List<WeakReference<d>> htB = new ArrayList();
    public List<ak> hty = am.axj().axg();
    public List<ak> htz = new ArrayList();

    public b() {
        x.i("MicroMsg.BatchGetCardMgr", "<init>, init pending list size = %d", new Object[]{Integer.valueOf(this.hty.size())});
        g.Eh().dpP.a(559, this);
    }

    public final void detach() {
        this.hty.clear();
        this.htz.clear();
        if (this.htA != null) {
            g.Eh().dpP.c(this.htA);
        }
        g.Eh().dpP.b(559, this);
    }

    public final void awz() {
        if (this.hty.size() == 0) {
            x.i("MicroMsg.BatchGetCardMgr", "getNow, no pending cardinfo ,no need to get");
        } else if (this.htA != null) {
            x.i("MicroMsg.BatchGetCardMgr", "getNow, already doing scene, not trigger now");
        } else {
            LinkedList linkedList = new LinkedList();
            if (this.hty.size() <= 10) {
                linkedList.addAll(this.hty);
            } else {
                linkedList.addAll(this.hty.subList(0, 10));
            }
            this.htA = new s(linkedList);
            g.Eh().dpP.a(this.htA, 0);
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        int i3 = 0;
        x.i("MicroMsg.BatchGetCardMgr", "onSceneEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.htA = null;
        List<ak> list = ((s) lVar).hxa;
        al axj;
        if (i == 0 && i2 == 0) {
            String str2 = "MicroMsg.BatchGetCardMgr";
            String str3 = "onSceneEnd, batch get succ, remove succ id list, size = %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
            x.i(str2, str3, objArr);
            if (list != null) {
                synchronized (this.dsN) {
                    this.hty.removeAll(list);
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            long dO = g.Ei().dqq.dO(Thread.currentThread().getId());
            axj = am.axj();
            if (list == null || list.size() == 0) {
                x.e("MicroMsg.PendingCardIdInfoStorage", "deleteList fail, list is empty");
            } else {
                for (ak akVar : list) {
                    if (akVar != null) {
                        axj.a(akVar, new String[0]);
                    }
                }
            }
            g.Ei().dqq.gp(dO);
            x.i("MicroMsg.BatchGetCardMgr", "onSceneEnd do transaction use time %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            awz();
            if (this.htB != null) {
                while (i3 < this.htB.size()) {
                    WeakReference weakReference = (WeakReference) this.htB.get(i3);
                    if (weakReference != null) {
                        d dVar = (d) weakReference.get();
                        if (dVar != null) {
                            dVar.awx();
                        }
                    }
                    i3++;
                }
                return;
            }
            return;
        }
        x.e("MicroMsg.BatchGetCardMgr", "onSceneEnd fail, stop batch get, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        synchronized (this.dsN) {
            if (list != null) {
                if (list.size() > 0) {
                    this.hty.removeAll(list);
                    this.htz.addAll(list);
                }
            }
        }
        axj = am.axj();
        if (list == null || list.size() == 0) {
            x.e("MicroMsg.PendingCardIdInfoStorage", "increaseRetryCount fail, list is empty");
            return;
        }
        for (ak akVar2 : list) {
            if (akVar2 != null) {
                akVar2.field_retryCount++;
                axj.c(akVar2, new String[0]);
            }
        }
    }

    public static void nG(int i) {
        g.Eh().dpP.a(new w(i), 0);
    }
}
