package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.util.SparseArray;
import com.tencent.mm.plugin.mmsight.model.a.d.b;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public final class s {
    public c ljK = c.lhF;
    SparseArray<WeakReference<b>> ljL = new SparseArray();
    private ag ljM = new 1(this, Looper.getMainLooper());

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.s$2 */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] ljO = new int[c.values().length];

        static {
            try {
                ljO[c.lhC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                ljO[c.lhF.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                ljO[c.lhH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                ljO[c.lhI.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public final void a(c cVar) {
        x.i("MicroMsg.SightMediaStatusHandler", "status change to %s", new Object[]{cVar.toString()});
        this.ljK = cVar;
        this.ljM.sendMessage(this.ljM.obtainMessage(257, cVar));
    }
}
