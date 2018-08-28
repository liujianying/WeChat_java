package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;
import java.util.Arrays;

final class n$a {
    private final String aOA;
    private final String aOB;
    private final ComponentName aOC;

    public n$a(ComponentName componentName) {
        this.aOA = null;
        this.aOB = null;
        this.aOC = (ComponentName) w.ah(componentName);
    }

    public n$a(String str, String str2) {
        this.aOA = w.bg(str);
        this.aOB = w.bg(str2);
        this.aOC = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n$a)) {
            return false;
        }
        n$a n_a = (n$a) obj;
        return v.c(this.aOA, n_a.aOA) && v.c(this.aOC, n_a.aOC);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.aOA, this.aOC});
    }

    public final Intent pn() {
        return this.aOA != null ? new Intent(this.aOA).setPackage(this.aOB) : new Intent().setComponent(this.aOC);
    }

    public final String toString() {
        return this.aOA == null ? this.aOC.flattenToString() : this.aOA;
    }
}
