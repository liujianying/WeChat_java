package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;

public class DateSorter {
    public static int DAY_COUNT = 5;
    private android.webkit.DateSorter a;
    private IX5DateSorter b;

    static {
        a();
    }

    public DateSorter(Context context) {
        bv a = bv.a();
        if (a == null || !a.b()) {
            this.a = new android.webkit.DateSorter(context);
        } else {
            this.b = a.c().h(context);
        }
    }

    private static boolean a() {
        bv a = bv.a();
        return a != null && a.b();
    }

    public long getBoundary(int i) {
        bv a = bv.a();
        return (a == null || !a.b()) ? this.a.getBoundary(i) : this.b.getBoundary(i);
    }

    public int getIndex(long j) {
        bv a = bv.a();
        return (a == null || !a.b()) ? this.a.getIndex(j) : this.b.getIndex(j);
    }

    public String getLabel(int i) {
        bv a = bv.a();
        return (a == null || !a.b()) ? this.a.getLabel(i) : this.b.getLabel(i);
    }
}
