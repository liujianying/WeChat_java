package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.a.o;

public final class c implements OnClickListener {
    private Context context;
    private a eMj;

    public c(Context context, a aVar) {
        this.context = context;
        this.eMj = aVar;
    }

    public final void onClick(View view) {
        b bVar = (b) view.getTag();
        String str = bVar.eMl;
        int[] iArr = new int[]{o.cx(str)};
        new g(this.context, new 1(this, bVar.position)).g(iArr);
    }
}
