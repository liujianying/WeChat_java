package com.tencent.mm.booter;

import android.content.Intent;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class NotifyReceiver$NotifyService$1 implements g {
    final /* synthetic */ long cXh;
    final /* synthetic */ Intent cXi;
    final /* synthetic */ NotifyService cXj;

    NotifyReceiver$NotifyService$1(NotifyService notifyService, long j, Intent intent) {
        this.cXj = notifyService;
        this.cXh = j;
        this.cXi = intent;
    }

    public final void vk() {
        com.tencent.mm.kernel.g.Ek().b(this);
        NotifyService.a(this.cXj);
        long currentTimeMillis = System.currentTimeMillis() - this.cXh;
        x.i("MicroMsg.NotifyReceiver", "summerboot startupDone[%b] take[%d]ms tid[%d] post last notify task", new Object[]{Boolean.valueOf(com.tencent.mm.kernel.g.Ek().dqL.drf), Long.valueOf(currentTimeMillis), Long.valueOf(Thread.currentThread().getId())});
        f.mDy.h(11098, new Object[]{Integer.valueOf(3600), Long.valueOf(currentTimeMillis)});
        f.mDy.a(99, 214, 1, false);
        ah.i(new 1(this), 500);
    }

    public final void aF(boolean z) {
    }
}
