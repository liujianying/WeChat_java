package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public final class l extends o {
    protected boolean aEK;
    protected String aEV;
    protected String aEW;
    protected int aEY;
    protected boolean aFF;
    protected int aFG;
    protected boolean aFH;
    protected boolean aFI;

    public l(q qVar) {
        super(qVar);
    }

    public final int getLogLevel() {
        np();
        return this.aFG;
    }

    protected final void mE() {
        ApplicationInfo applicationInfo;
        Context context = this.aFn.mContext;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 129);
        } catch (NameNotFoundException e) {
            f("PackageManager doesn't know about the app package", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            aR("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null) {
            int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
            if (i > 0) {
                b bVar = (b) new ak(this.aFn).dg(i);
                if (bVar != null) {
                    String str;
                    int i2;
                    aO("Loading global XML config values");
                    if (bVar.aEV != null) {
                        str = bVar.aEV;
                        this.aEV = str;
                        e("XML config - app name", str);
                    }
                    if (bVar.aEW != null) {
                        str = bVar.aEW;
                        this.aEW = str;
                        e("XML config - app version", str);
                    }
                    if (bVar.aEX != null) {
                        str = bVar.aEX.toLowerCase();
                        i2 = "verbose".equals(str) ? 0 : "info".equals(str) ? 1 : "warning".equals(str) ? 2 : "error".equals(str) ? 3 : -1;
                        if (i2 >= 0) {
                            this.aFG = i2;
                            d("XML config - log level", Integer.valueOf(i2));
                        }
                    }
                    if (bVar.aEY >= 0) {
                        i2 = bVar.aEY;
                        this.aEY = i2;
                        this.aFH = true;
                        e("XML config - dispatch period (sec)", Integer.valueOf(i2));
                    }
                    if (bVar.aEZ != -1) {
                        boolean z = bVar.aEZ == 1;
                        this.aEK = z;
                        this.aFI = true;
                        e("XML config - dry run", Boolean.valueOf(z));
                    }
                }
            }
        }
    }

    public final String nb() {
        np();
        return this.aEW;
    }

    public final String nc() {
        np();
        return this.aEV;
    }

    public final boolean nd() {
        np();
        return this.aFF;
    }

    public final boolean ne() {
        np();
        return this.aFH;
    }

    public final int nf() {
        np();
        return this.aEY;
    }

    public final boolean ng() {
        np();
        return this.aFI;
    }

    public final boolean nh() {
        np();
        return this.aEK;
    }
}
