package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public abstract class e<T> {
    private ag handler;
    List<Integer> nKB;

    public abstract List<T> bBI();

    public abstract void cq(List<T> list);

    public e() {
        this.handler = null;
        this.nKB = new LinkedList();
        this.handler = af.aRu();
        this.nKB.clear();
    }

    protected final void fu(boolean z) {
        int i = z ? 0 : 1;
        if (i == 1) {
            Object obj;
            for (Integer intValue : this.nKB) {
                if (intValue.intValue() == 1) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj != null) {
                x.e("MicroMsg.AdapterLoader", "thread is loading ui should be not load any");
                return;
            }
        }
        if (z) {
            x.d("MicroMsg.AdapterLoader", "thread load" + this.nKB.size());
        } else {
            x.d("MicroMsg.AdapterLoader", "ui load");
        }
        if (this.nKB.size() <= 1) {
            this.nKB.add(Integer.valueOf(i));
            if (z) {
                af.bxY().post(new 1(this, z));
            } else {
                cp(bBI());
            }
        }
    }

    final void cp(List<T> list) {
        this.handler.post(new 2(this, list));
    }
}
