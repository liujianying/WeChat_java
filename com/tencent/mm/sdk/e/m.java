package com.tencent.mm.sdk.e;

import android.os.Looper;

public abstract class m implements g {
    private final k<b, a> sKC = new k<b, a>() {
        protected final /* synthetic */ void q(Object obj, Object obj2) {
            b bVar = (b) obj;
            a aVar = (a) obj2;
            if (m.this.Xu()) {
                bVar.a(aVar.sKN, aVar.sKO, aVar.obj);
            }
        }
    };

    private class a {
        Object obj;
        int sKN;
        m sKO;

        a(int i, m mVar, Object obj) {
            this.sKN = i;
            this.obj = obj;
            this.sKO = mVar;
        }
    }

    public interface b {
        void a(int i, m mVar, Object obj);
    }

    public abstract boolean Xu();

    public final void a(b bVar) {
        if (bVar != null) {
            this.sKC.a(bVar, Looper.getMainLooper());
        }
    }

    public final void b(b bVar) {
        if (bVar != null) {
            this.sKC.remove(bVar);
        }
    }

    public final void b(int i, m mVar, Object obj) {
        this.sKC.ci(new a(i, mVar, obj));
        this.sKC.doNotify();
    }
}
