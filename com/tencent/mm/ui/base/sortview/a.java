package com.tencent.mm.ui.base.sortview;

import android.content.Context;

public abstract class a {
    public Object data;
    public boolean tDC;
    public int type;

    public abstract void a(Context context, a aVar, Object... objArr);

    public abstract b auQ();

    public abstract a auR();

    public a(int i, Object obj) {
        this.type = i;
        this.data = obj;
    }
}
