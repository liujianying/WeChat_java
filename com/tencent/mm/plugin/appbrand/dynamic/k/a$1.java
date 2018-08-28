package com.tencent.mm.plugin.appbrand.dynamic.k;

import com.tencent.mm.kernel.api.g;
import java.util.concurrent.CountDownLatch;

class a$1 implements g {
    final /* synthetic */ CountDownLatch dKu;

    a$1(CountDownLatch countDownLatch) {
        this.dKu = countDownLatch;
    }

    public final void vk() {
        this.dKu.countDown();
    }

    public final void aF(boolean z) {
        this.dKu.countDown();
    }
}
