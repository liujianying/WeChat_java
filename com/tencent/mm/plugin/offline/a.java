package com.tencent.mm.plugin.offline;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T> {
    protected List<WeakReference<T>> lIC = new ArrayList();

    public final void bN(T t) {
        if (this.lIC != null) {
            this.lIC = new ArrayList();
        }
        if (t != null) {
            this.lIC.add(new WeakReference(t));
        }
    }

    public final void bO(T t) {
        if (this.lIC != null && t != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.lIC.size()) {
                    WeakReference weakReference = (WeakReference) this.lIC.get(i2);
                    if (weakReference != null) {
                        Object obj = weakReference.get();
                        if (obj != null && obj.equals(t)) {
                            weakReference.clear();
                            this.lIC.remove(weakReference);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
