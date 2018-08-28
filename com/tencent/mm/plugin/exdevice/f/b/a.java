package com.tencent.mm.plugin.exdevice.f.b;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

public final class a {
    SparseArray<WeakReference<e>> iyd;

    public final void a(e eVar) {
        Assert.assertTrue(eVar != null);
        if (this.iyd == null) {
            this.iyd = new SparseArray();
        }
        this.iyd.put(eVar.hashCode(), new WeakReference(eVar));
    }

    public final void b(e eVar) {
        Assert.assertTrue(eVar != null);
        if (this.iyd == null) {
            x.d("MicroMsg.ExdeviceRankCallbackManager", "hy: callback pool is null. abort ");
        } else {
            this.iyd.remove(eVar.hashCode());
        }
    }

    public final void a(String str, d dVar) {
        Assert.assertTrue(true);
        if (this.iyd == null) {
            x.d("MicroMsg.ExdeviceRankCallbackManager", "hy: callback pool is null. abort");
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iyd.size()) {
                e eVar = (e) ((WeakReference) this.iyd.get(this.iyd.keyAt(i2))).get();
                if (eVar != null) {
                    eVar.b(str, dVar);
                }
                i = i2 + 1;
            } else {
                x.d("MicroMsg.ExdeviceRankCallbackManager", "hy: publish end");
                return;
            }
        }
    }
}
