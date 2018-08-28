package com.tencent.mm.plugin.welab.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.welab.d.b;
import com.tencent.mm.plugin.welab.ui.WelabMainUI;

public final class c implements com.tencent.mm.plugin.welab.a.a.c {
    public final void x(Context context, Intent intent) {
        intent.setClass(context, WelabMainUI.class);
        String str = "para_from_with_red_point";
        int i = (bYN() || bYO()) ? 1 : 0;
        intent.putExtra(str, i);
        context.startActivity(intent);
    }

    public final boolean bYN() {
        b.bYX();
        return b.bYZ() && !bYO();
    }

    public final boolean bYO() {
        b.bYX();
        if (!b.bZa()) {
            b.bYX();
            if (b.bYZ()) {
                return true;
            }
        }
        return false;
    }

    public final boolean bYP() {
        return !bYO();
    }
}
