package com.tencent.mm.s;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.aa.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

class a$1 extends ag {
    final /* synthetic */ a dlw;

    a$1(a aVar, Looper looper) {
        this.dlw = aVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what == 0 && (message.obj instanceof a$b)) {
            a$b a_b = (a$b) message.obj;
            if (a_b.dly != null) {
                a aVar = this.dlw;
                a aVar2 = a_b.dly;
                ArrayList arrayList = null;
                Iterator it = aVar.dlt.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null || weakReference.get() == null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(weakReference);
                    } else {
                        ((a$a) weakReference.get()).b(aVar2);
                    }
                }
                if (arrayList != null) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        aVar.dlt.remove((WeakReference) it2.next());
                    }
                    arrayList.clear();
                }
            } else {
                a.a(this.dlw, a_b.dlx);
            }
        }
        if (message.what == 1 && (message.obj instanceof a$c)) {
            a$c a_c = (a$c) message.obj;
            if (a_c.dly != null) {
                a.a(this.dlw);
            } else {
                a.b(this.dlw, a_c.dlz);
            }
        }
    }
}
