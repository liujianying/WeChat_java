package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.tencent.mm.pluginsdk.model.s.a;

public abstract class r {
    public abstract boolean SK(String str);

    public abstract String Vw();

    public abstract String cbq();

    public abstract a cbr();

    public abstract boolean eM(Context context);

    public boolean z(Context context, Intent intent) {
        return false;
    }

    public String a(Context context, ResolveInfo resolveInfo) {
        return resolveInfo.activityInfo.loadLabel(context.getPackageManager()).toString();
    }
}
