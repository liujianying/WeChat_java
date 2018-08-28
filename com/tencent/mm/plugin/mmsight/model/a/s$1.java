package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.mmsight.model.a.d.b;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.s.2;
import com.tencent.mm.sdk.platformtools.ag;
import java.lang.ref.WeakReference;

class s$1 extends ag {
    final /* synthetic */ s ljN;

    s$1(s sVar, Looper looper) {
        this.ljN = sVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        b bVar;
        if (257 == message.what) {
            c cVar = (c) message.obj;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ljN.ljL.size()) {
                    if (((b) ((WeakReference) this.ljN.ljL.valueAt(i2)).get()) != null) {
                        int[] iArr = 2.ljO;
                        cVar.ordinal();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } else if (258 == message.what) {
            bVar = (b) message.obj;
            if (bVar != null) {
                this.ljN.ljL.put(bVar.hashCode(), new WeakReference(bVar));
            }
        } else if (259 == message.what) {
            bVar = (b) message.obj;
            if (bVar != null) {
                this.ljN.ljL.remove(bVar.hashCode());
            }
        }
    }
}
