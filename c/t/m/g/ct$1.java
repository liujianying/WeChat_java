package c.t.m.g;

import java.util.concurrent.ThreadFactory;

class ct$1 implements ThreadFactory {
    ct$1() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "network_request_pool");
    }
}
