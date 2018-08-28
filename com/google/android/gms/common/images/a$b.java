package com.google.android.gms.common.images;

import com.google.android.gms.common.images.ImageManager.a;
import com.google.android.gms.common.internal.v;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public final class a$b extends a {
    private WeakReference<a> aMU;

    public final boolean equals(Object obj) {
        if (!(obj instanceof a$b)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        a$b a_b = (a$b) obj;
        a aVar = (a) this.aMU.get();
        a aVar2 = (a) a_b.aMU.get();
        return aVar2 != null && aVar != null && v.c(aVar2, aVar) && v.c(a_b.aMR, this.aMR);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.aMR});
    }

    protected final void pb() {
        this.aMU.get();
    }
}
