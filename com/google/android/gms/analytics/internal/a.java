package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Locale;

public final class a extends o {
    public static boolean aEP;
    private com.google.android.gms.a.a.a.a aEQ;
    private final j aER;
    private String aES;
    private boolean aET = false;
    private Object aEU = new Object();

    a(q qVar) {
        super(qVar);
        this.aER = new j(qVar.aFC);
    }

    private boolean a(com.google.android.gms.a.a.a.a aVar, com.google.android.gms.a.a.a.a aVar2) {
        String str = null;
        String str2 = aVar2 == null ? null : aVar2.aEp;
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        String nP = this.aFn.nw().nP();
        synchronized (this.aEU) {
            boolean aJ;
            if (!this.aET) {
                this.aES = mJ();
                this.aET = true;
            } else if (TextUtils.isEmpty(this.aES)) {
                if (aVar != null) {
                    str = aVar.aEp;
                }
                if (str == null) {
                    aJ = aJ(str2 + nP);
                    return aJ;
                }
                this.aES = aI(str + nP);
            }
            Object aI = aI(str2 + nP);
            if (TextUtils.isEmpty(aI)) {
                return false;
            } else if (aI.equals(this.aES)) {
                return true;
            } else {
                if (TextUtils.isEmpty(this.aES)) {
                    str = nP;
                } else {
                    aO("Resetting the client id because Advertising Id changed.");
                    str = this.aFn.nw().nQ();
                    d("New client Id", str);
                }
                aJ = aJ(str2 + str);
                return aJ;
            }
        }
    }

    private static String aI(String str) {
        if (k.aM("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, k.aM("MD5").digest(str.getBytes()))});
    }

    private boolean aJ(String str) {
        try {
            String aI = aI(str);
            aO("Storing hashed adid.");
            FileOutputStream openFileOutput = this.aFn.mContext.openFileOutput("gaClientIdData", 0);
            openFileOutput.write(aI.getBytes());
            openFileOutput.close();
            this.aES = aI;
            return true;
        } catch (IOException e) {
            g("Error creating hash file", e);
            return false;
        }
    }

    private synchronized com.google.android.gms.a.a.a.a mH() {
        if (this.aER.Y(1000)) {
            this.aER.start();
            com.google.android.gms.a.a.a.a mI = mI();
            if (a(this.aEQ, mI)) {
                this.aEQ = mI;
            } else {
                aS("Failed to reset client id on adid change. Not using adid");
                this.aEQ = new com.google.android.gms.a.a.a.a("", false);
            }
        }
        return this.aEQ;
    }

    private com.google.android.gms.a.a.a.a mI() {
        com.google.android.gms.a.a.a.a aVar = null;
        try {
            return com.google.android.gms.a.a.a.Z(this.aFn.mContext);
        } catch (IllegalStateException e) {
            aR("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
            return aVar;
        } catch (Throwable th) {
            if (aEP) {
                return aVar;
            }
            aEP = true;
            f("Error getting advertiser id", th);
            return aVar;
        }
    }

    private String mJ() {
        Object e;
        String str = null;
        try {
            FileInputStream openFileInput = this.aFn.mContext.openFileInput("gaClientIdData");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                aR("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                this.aFn.mContext.deleteFile("gaClientIdData");
                return null;
            } else if (read <= 0) {
                aO("Hash file is empty.");
                openFileInput.close();
                return null;
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    return str2;
                } catch (FileNotFoundException e2) {
                    return str2;
                } catch (IOException e3) {
                    e = e3;
                    str = str2;
                    f("Error reading Hash file, deleting it", e);
                    this.aFn.mContext.deleteFile("gaClientIdData");
                    return str;
                }
            }
        } catch (FileNotFoundException e4) {
            return null;
        } catch (IOException e5) {
            e = e5;
            f("Error reading Hash file, deleting it", e);
            this.aFn.mContext.deleteFile("gaClientIdData");
            return str;
        }
    }

    protected final void mE() {
    }

    public final boolean mF() {
        np();
        com.google.android.gms.a.a.a.a mH = mH();
        return (mH == null || mH.aEq) ? false : true;
    }

    public final String mG() {
        np();
        com.google.android.gms.a.a.a.a mH = mH();
        CharSequence charSequence = mH != null ? mH.aEp : null;
        return TextUtils.isEmpty(charSequence) ? null : charSequence;
    }
}
