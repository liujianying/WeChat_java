package com.google.android.gms.analytics.internal;

import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.c.aa;
import com.google.android.gms.common.internal.w;
import java.util.HashSet;
import java.util.Set;

public final class ac {
    private final q aHe;
    private volatile Boolean aHf;
    private String aHg;
    private Set<Integer> aHh;

    protected ac(q qVar) {
        w.ah(qVar);
        this.aHe = qVar;
    }

    public static boolean nU() {
        return ((Boolean) aj.aHs.get()).booleanValue();
    }

    public static int nV() {
        return ((Integer) aj.aHP.get()).intValue();
    }

    public static long nW() {
        return ((Long) aj.aHA.get()).longValue();
    }

    public static long nX() {
        return ((Long) aj.aHD.get()).longValue();
    }

    public static int nY() {
        return ((Integer) aj.aHF.get()).intValue();
    }

    public static int nZ() {
        return ((Integer) aj.aHG.get()).intValue();
    }

    public static String oa() {
        return (String) aj.aHI.get();
    }

    public static String ob() {
        return (String) aj.aHH.get();
    }

    public static String oc() {
        return (String) aj.aHJ.get();
    }

    public static long oe() {
        return ((Long) aj.aHX.get()).longValue();
    }

    public final boolean nT() {
        if (this.aHf == null) {
            synchronized (this) {
                if (this.aHf == null) {
                    ApplicationInfo applicationInfo = this.aHe.mContext.getApplicationInfo();
                    String r = aa.r(this.aHe.mContext, Process.myPid());
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(r);
                        this.aHf = Boolean.valueOf(z);
                    }
                    if ((this.aHf == null || !this.aHf.booleanValue()) && "com.google.android.gms.analytics".equals(r)) {
                        this.aHf = Boolean.TRUE;
                    }
                    if (this.aHf == null) {
                        this.aHf = Boolean.TRUE;
                        this.aHe.nr().aS("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.aHf.booleanValue();
    }

    public final Set<Integer> od() {
        String str = (String) aj.aHS.get();
        if (this.aHh == null || this.aHg == null || !this.aHg.equals(str)) {
            String[] split = TextUtils.split(str, ",");
            Set hashSet = new HashSet();
            for (String parseInt : split) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(parseInt)));
                } catch (NumberFormatException e) {
                }
            }
            this.aHg = str;
            this.aHh = hashSet;
        }
        return this.aHh;
    }
}
