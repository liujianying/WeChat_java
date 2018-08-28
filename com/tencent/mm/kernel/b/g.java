package com.tencent.mm.kernel.b;

import android.app.Application;
import com.tencent.mm.kernel.a.a;

public abstract class g {
    public String dox;
    public a dqh = new a();
    public Application dsQ;
    private Boolean dsR;

    public abstract String getPackageName();

    public g(String str, Application application) {
        this.dox = str;
        this.dsQ = application;
    }

    public String toString() {
        return this.dox != null ? this.dox : super.toString();
    }

    public final boolean ES() {
        if (this.dsR == null) {
            this.dsR = Boolean.valueOf(gn(""));
        }
        return this.dsR.booleanValue();
    }

    public final boolean gn(String str) {
        return this.dox != null && this.dox.equals(getPackageName() + str);
    }
}
