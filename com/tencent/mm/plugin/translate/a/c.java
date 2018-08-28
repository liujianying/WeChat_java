package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.s;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bub;
import com.tencent.mm.protocal.c.buc;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

public final class c implements a {
    public ArrayList<a> dlt;
    public int htY;
    public final d[] oEr;
    public Queue<c> oEs;
    public HashMap<String, Integer> oEt;

    /* synthetic */ c(byte b) {
        this();
    }

    private c() {
        this.htY = 0;
        this.dlt = new ArrayList(1);
        this.oEs = new LinkedList();
        this.oEt = new HashMap();
        this.oEr = new d[1];
    }

    private void b(int i, SparseArray<c> sparseArray) {
        Iterator it = this.dlt.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(i, sparseArray);
        }
    }

    public final void bIR() {
        x.d("MicroMsg.TranslateServiceManager", "current waitings : %s", Integer.valueOf(this.oEs.size()));
        if (this.oEs.size() != 0 && this.htY <= this.oEr.length) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.oEr.length) {
                    if (this.oEr[i2] == null) {
                        this.oEr[i2] = new d(i2, this);
                        au.DF().a(631, this.oEr[i2]);
                    }
                    if (!this.oEr[i2].oEA) {
                        Object obj;
                        d dVar = this.oEr[i2];
                        Queue queue = this.oEs;
                        if (dVar.oEA) {
                            obj = null;
                        } else {
                            dVar.oEz = new SparseArray();
                            if (queue.size() == 0) {
                                obj = null;
                            } else {
                                dVar.oEA = true;
                                LinkedList linkedList = new LinkedList();
                                i = 0;
                                while (true) {
                                    int i3 = i;
                                    if (i3 >= 512 || queue.size() <= 0) {
                                        dVar.oEB = new b(linkedList);
                                        au.DF().a(dVar.oEB, 0);
                                        dVar.start = System.currentTimeMillis();
                                        dVar.oED.J(60000, 60000);
                                        obj = 1;
                                    } else {
                                        c cVar = (c) queue.peek();
                                        int length = cVar.ccF.getBytes().length;
                                        if (i3 == 0 || i3 + length <= 512) {
                                            queue.poll();
                                            bub bub = new bub();
                                            bub.srv = cVar.oEw;
                                            bub.srw = cVar.ccF;
                                            bub.rEB = new bhy().bq(cVar.cGM);
                                            if (cVar.type == 1 || s.fq(cVar.bhd)) {
                                                bub.srx = cVar.bhd;
                                            }
                                            switch (cVar.type) {
                                                case 0:
                                                    bub.otY = 1;
                                                    break;
                                                case 1:
                                                    bub.otY = 4;
                                                    break;
                                                case 2:
                                                    bub.otY = 2;
                                                    break;
                                                case 3:
                                                    bub.otY = 3;
                                                    break;
                                            }
                                            x.d("MicroMsg.WorkingTranslate", "eventMsg.type: %d, msg.Scene:%d, id: %s", Integer.valueOf(cVar.type), Integer.valueOf(bub.otY), cVar.id);
                                            linkedList.add(bub);
                                            dVar.oEz.put(cVar.oEw, cVar);
                                        }
                                        i = i3 + length;
                                    }
                                }
                                dVar.oEB = new b(linkedList);
                                au.DF().a(dVar.oEB, 0);
                                dVar.start = System.currentTimeMillis();
                                dVar.oED.J(60000, 60000);
                                obj = 1;
                            }
                        }
                        if (obj != null) {
                            this.htY++;
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final boolean OB(String str) {
        return this.oEt.containsKey(str);
    }

    public final void a(int i, SparseArray<c> sparseArray, LinkedList<buc> linkedList) {
        int i2;
        HashMap hashMap;
        this.htY--;
        if (linkedList == null || sparseArray.size() != linkedList.size()) {
            x.d("MicroMsg.TranslateServiceManager", "originals.size() != translatedMsg.size()");
            HashMap hashMap2 = new HashMap();
            for (i2 = 0; i2 < sparseArray.size(); i2++) {
                hashMap2.put(((c) sparseArray.valueAt(i2)).id, Integer.valueOf(((c) sparseArray.valueAt(i2)).oEw));
            }
            hashMap = hashMap2;
        } else {
            hashMap = null;
        }
        c cVar;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                buc buc = (buc) it.next();
                cVar = (c) sparseArray.get(buc.srv);
                String str = buc.sry;
                if (cVar.type == 1) {
                    str = bd.U(str, cVar.oEx);
                    cVar.ccF = bd.U(cVar.ccF, cVar.oEx);
                }
                cVar.ccM = str;
                cVar.ret = buc.rfn;
                cVar.cbd = buc.srz;
                byte[] bArr = (buc.rEB == null || buc.rEB.siK == null) ? null : buc.rEB.siK.lR;
                cVar.cGM = bArr;
                cVar.oEv = buc.srA;
                this.oEt.remove(cVar.id);
                if (hashMap != null) {
                    hashMap.remove(cVar.id);
                }
            }
        } else {
            for (i2 = 0; i2 < sparseArray.size(); i2++) {
                cVar = (c) sparseArray.valueAt(i2);
                if (cVar.type == 1) {
                    cVar.ccF = bd.U(cVar.ccF, cVar.oEx);
                }
            }
        }
        if (hashMap != null && hashMap.size() > 0) {
            for (Entry key : hashMap.entrySet()) {
                this.oEt.remove(key.getKey());
                x.d("MicroMsg.TranslateServiceManager", "we found missing translate, msgId : %s, clientId : %s", key.getKey(), key.getValue());
            }
        }
        b(i, sparseArray);
        bIR();
    }
}
