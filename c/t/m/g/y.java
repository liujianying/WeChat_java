package c.t.m.g;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public final class y {
    public ThreadPoolExecutor a;

    private y() {
        this.a = (ThreadPoolExecutor) Executors.newCachedThreadPool(new o("HalleyBusiTaskPoolHolder"));
    }

    /* synthetic */ y(byte b) {
        this();
    }
}
