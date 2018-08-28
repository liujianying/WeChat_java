package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.ht;
import com.tencent.mm.g.a.sj;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.CountDownLatch;

class l$a implements e, Runnable {
    CountDownLatch iyu;
    final /* synthetic */ l mPc;
    h mPi;
    l mPj;
    long start;

    l$a(l lVar, h hVar, CountDownLatch countDownLatch) {
        this.mPc = lVar;
        this.mPi = hVar;
        this.iyu = countDownLatch;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.UnfamiliarContactEngine", "[onSceneEnd] errType:%s errCode:%s errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            this.iyu.countDown();
        } else if (lVar.getType() == 292) {
            this.mPj = lVar;
            com.tencent.mm.sdk.f.e.post(this, "load_unfamiliar_contact");
        }
    }

    public final void run() {
        sj sjVar = new sj();
        sjVar.cde.cdg = this.mPj;
        a.sFg.m(sjVar);
        int i = sjVar.cdf.state;
        Object obj = sjVar.cdf.cdh;
        String str = "MicroMsg.UnfamiliarContactEngine";
        String str2 = "[callback] state:%s,tagList is null?%s,tagList size:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(obj == null);
        objArr[2] = Integer.valueOf(obj == null ? 0 : obj.size());
        x.i(str, str2, objArr);
        if (i != 1) {
            if (obj != null) {
                this.mPc.mOZ.addAll(obj);
            }
            x.i("MicroMsg.UnfamiliarContactEngine", "[AsyncGetSnsTagInfo] %sms", new Object[]{Long.valueOf(System.currentTimeMillis() - this.start)});
            this.iyu.countDown();
            return;
        }
        if (this.mPi != null) {
            ah.A(new 1(this));
        }
        this.mPc.dqM.h(new Runnable() {
            public final void run() {
                l$a.btr();
            }
        }, 30000);
    }

    static void btr() {
        ht htVar = new ht();
        htVar.bRe.bOh = 3;
        a.sFg.m(htVar);
    }
}
