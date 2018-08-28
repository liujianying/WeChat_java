package com.b.a.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;

public class b {
    private static volatile Integer ach;

    public static int V(Context context) {
        int i = 2011;
        int i2 = -1;
        if (ach == null) {
            synchronized (b.class) {
                if (ach == null) {
                    long U = a.U(context);
                    if (U == -1) {
                        ArrayList arrayList = new ArrayList();
                        int in = a.in();
                        in = in <= 0 ? -1 : in == 1 ? 2008 : in <= 3 ? 2011 : 2012;
                        c(arrayList, in);
                        long io = (long) a.io();
                        in = io == -1 ? -1 : io <= 528000 ? 2008 : io <= 620000 ? 2009 : io <= 1020000 ? 2010 : io <= 1220000 ? 2011 : io <= 1520000 ? 2012 : io <= 2020000 ? 2013 : 2014;
                        c(arrayList, in);
                        io = a.U(context);
                        if (io <= 0) {
                            i = -1;
                        } else if (io <= 201326592) {
                            i = 2008;
                        } else if (io <= 304087040) {
                            i = 2009;
                        } else if (io <= 536870912) {
                            i = 2010;
                        } else if (io > 1073741824) {
                            i = io <= 1610612736 ? 2012 : io <= 2147483648L ? 2013 : 2014;
                        }
                        c(arrayList, i);
                        if (!arrayList.isEmpty()) {
                            Collections.sort(arrayList);
                            if ((arrayList.size() & 1) == 1) {
                                i2 = ((Integer) arrayList.get(arrayList.size() / 2)).intValue();
                            } else {
                                i = (arrayList.size() / 2) - 1;
                                i2 = ((((Integer) arrayList.get(i + 1)).intValue() - ((Integer) arrayList.get(i)).intValue()) / 2) + ((Integer) arrayList.get(i)).intValue();
                            }
                        }
                    } else {
                        i2 = U <= 805306368 ? a.in() <= 1 ? 2009 : 2010 : U <= 1073741824 ? a.io() < 1300000 ? 2011 : 2012 : U <= 1610612736 ? a.io() < 1800000 ? 2012 : 2013 : U <= 2147483648L ? 2013 : U <= 3221225472L ? 2014 : 2015;
                    }
                    ach = Integer.valueOf(i2);
                }
            }
        }
        return ach.intValue();
    }

    private static void c(ArrayList<Integer> arrayList, int i) {
        if (i != -1) {
            arrayList.add(Integer.valueOf(i));
        }
    }
}
