package com.tencent.mm.aq;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class p$a$1 implements a {
    private int dZr = 0;
    private int ecr = 0;
    final /* synthetic */ p ecs;
    final /* synthetic */ List ect;
    final /* synthetic */ LinkedList ecu;

    p$a$1(p pVar, List list, LinkedList linkedList) {
        this.ecs = pVar;
        this.ect = list;
        this.ecu = linkedList;
    }

    public final boolean vD() {
        int i = 0;
        int size = this.ect.size();
        int size2 = this.ecu.size();
        int i2 = size < size2 ? size : size2;
        if (size != size2) {
            x.w("MicroMsg.OplogService", "summeroplog oplogSize[%d] not equal to resultSize[%d]! now size[%d] respIndex[%d]", new Object[]{Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(i2), Integer.valueOf(this.dZr)});
        }
        List arrayList = new ArrayList();
        if (this.dZr >= i2) {
            this.ecs.dGS = false;
            if (this.ecr > 0) {
                long j;
                al alVar = this.ecs.dSR;
                if (this.ecs.dSK.size() > 0) {
                    j = 500;
                } else {
                    j = 0;
                }
                alVar.J(j, j);
            }
            return false;
        }
        size = this.dZr + 20;
        if (size > i2) {
            size2 = i2;
        } else {
            size2 = size;
        }
        while (this.dZr < size2) {
            size = ((Integer) this.ecu.get(this.dZr)).intValue();
            b bVar = (b) this.ect.get(this.dZr);
            int i3 = bVar.id;
            x.d("MicroMsg.OplogService", "summeroplog id:%d, cmd:%d, result:%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(bVar.getCmdId()), Integer.valueOf(size)});
            if (size == 0) {
                this.ecr++;
                arrayList.add(bVar);
                this.ecs.dSK.remove(Integer.valueOf(i3));
            } else if (size == -433) {
                x.e("MicroMsg.OplogService", "oplog not yet process, id:%d, cmd:%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(bVar.getCmdId())});
            } else {
                Integer num = (Integer) this.ecs.dSK.get(Integer.valueOf(i3));
                x.d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", new Object[]{Integer.valueOf(i3), Long.valueOf(bVar.dSH), num});
                if (num == null) {
                    this.ecs.dSK.m(Integer.valueOf(i3), Integer.valueOf(1));
                } else if (num.intValue() < 2) {
                    this.ecs.dSK.m(Integer.valueOf(i3), Integer.valueOf(num.intValue() + 1));
                } else {
                    x.d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", new Object[]{Integer.valueOf(i3), Long.valueOf(bVar.dSH)});
                    arrayList.add(bVar);
                }
            }
            this.dZr++;
        }
        size = arrayList.size();
        if (size > 0) {
            g.Ek();
            long dO = g.Ei().dqq.dO(Thread.currentThread().getId());
            while (i < size) {
                this.ecs.ecp.a((b) arrayList.get(i));
                i++;
            }
            g.Ek();
            g.Ei().dqq.gp(dO);
        }
        return true;
    }

    public final String toString() {
        return super.toString() + "|RespHandler";
    }
}
