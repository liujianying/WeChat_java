package com.tencent.mm.vending.e;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class c<_Target extends a> implements a, b<_Target> {
    private List<WeakReference<_Target>> uQJ = new ArrayList();
    private boolean uQK = true;

    public final synchronized void keep(_Target _target) {
        if (this.uQK) {
            this.uQJ.add(new WeakReference(_target));
        } else {
            Assert.assertNotNull(_target);
            _target.dead();
        }
    }

    public final synchronized void dead() {
        if (this.uQK) {
            for (WeakReference weakReference : this.uQJ) {
                a aVar = (a) weakReference.get();
                if (aVar != null) {
                    aVar.dead();
                }
            }
            this.uQJ.clear();
            this.uQK = false;
        }
    }
}
