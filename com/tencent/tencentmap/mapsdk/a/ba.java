package com.tencent.tencentmap.mapsdk.a;

import com.qq.navi.Handler;
import java.util.concurrent.LinkedBlockingQueue;

public class ba extends Handler {
    private LinkedBlockingQueue<bb> a;

    public void a(bb bbVar, bf bfVar) {
        bbVar.i = bfVar;
        this.a.offer(bbVar);
    }
}
