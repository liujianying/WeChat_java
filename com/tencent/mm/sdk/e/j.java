package com.tencent.mm.sdk.e;

import android.os.Looper;

public abstract class j implements f {
    public final k<a, l> sKC = new k<a, l>() {
        protected final /* synthetic */ void q(Object obj, Object obj2) {
            l lVar = (l) obj2;
            ((a) obj).a(lVar.bHA, lVar);
        }
    };
    private final k<Object, String> sKD = new k<Object, String>() {
        protected final /* bridge */ /* synthetic */ void q(Object obj, Object obj2) {
        }
    };

    public interface a {
        void a(String str, l lVar);
    }

    public void lock() {
        this.sKC.lock();
    }

    public void unlock() {
        this.sKC.unlock();
    }

    public void c(a aVar) {
        this.sKC.a(aVar, Looper.getMainLooper());
    }

    public void a(a aVar, Looper looper) {
        this.sKC.a(aVar, looper);
    }

    public void d(a aVar) {
        this.sKC.remove(aVar);
    }

    public final void doNotify() {
        this.sKC.ci(new l("*"));
        this.sKC.doNotify();
    }

    public final void Xp(String str) {
        this.sKC.ci(new l(str));
        this.sKC.doNotify();
    }

    public void b(String str, int i, Object obj) {
        l lVar = new l();
        lVar.bHA = str;
        lVar.fBN = i;
        lVar.obj = obj;
        lVar.sKL = this;
        this.sKC.ci(lVar);
        this.sKC.doNotify();
    }
}
