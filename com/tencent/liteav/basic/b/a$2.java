package com.tencent.liteav.basic.b;

import com.tencent.liteav.basic.util.TXCTimeUtil;

class a$2 implements Runnable {
    final /* synthetic */ a a;

    a$2(a aVar) {
        this.a = aVar;
    }

    public void run() {
        a.a(this.a, true);
        a.a(this.a, TXCTimeUtil.getTimeTick());
    }
}
