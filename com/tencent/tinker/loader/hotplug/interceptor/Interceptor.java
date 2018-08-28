package com.tencent.tinker.loader.hotplug.interceptor;

public abstract class Interceptor<T_TARGET> {
    private volatile boolean mInstalled = false;
    private T_TARGET vul = null;

    protected interface ITinkerHotplugProxy {
    }

    protected abstract void cH(T_TARGET t_target);

    protected abstract T_TARGET cHb();

    protected T_TARGET cI(T_TARGET t_target) {
        return t_target;
    }

    public final synchronized void cHc() {
        try {
            Object cHb = cHb();
            this.vul = cHb;
            Object cI = cI(cHb);
            if (cI != cHb) {
                cH(cI);
            } else {
                new StringBuilder("target: ").append(cHb).append(" was already hooked.");
            }
            this.mInstalled = true;
        } catch (Throwable th) {
            this.vul = null;
            InterceptFailedException interceptFailedException = new InterceptFailedException(th);
        }
    }

    public final synchronized void ts() {
        if (this.mInstalled) {
            try {
                cH(this.vul);
                this.vul = null;
                this.mInstalled = false;
            } catch (Throwable th) {
                InterceptFailedException interceptFailedException = new InterceptFailedException(th);
            }
        }
    }
}
