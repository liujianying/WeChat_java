package com.tencent.mm.view;

import android.content.Context;
import com.tencent.mm.api.d;
import com.tencent.mm.api.m.a;

public final class b extends a {
    public b(Context context, a aVar) {
        super(context, aVar);
    }

    protected final com.tencent.mm.view.b.a cBZ() {
        return new com.tencent.mm.view.b.b(getContext(), getPresenter());
    }

    protected final com.tencent.mm.view.footer.a cCa() {
        return new com.tencent.mm.view.footer.b(getContext(), getPresenter());
    }

    public final d[] getFeatures() {
        if (this.uSp == null) {
            this.uSp = new d[]{d.bwN, d.bwP, d.bwO, d.bwQ, d.bwR};
        }
        return this.uSp;
    }
}
