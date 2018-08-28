package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c$a;

public final class a extends c$a {
    private boolean gtW = false;

    public a(Context context) {
        super(context);
        if (context instanceof Activity) {
            this.gtW = j.c(((Activity) context).getWindow());
        }
    }

    public final c anj() {
        c anj = super.anj();
        j.a(anj.getWindow(), this.gtW);
        return anj;
    }
}
