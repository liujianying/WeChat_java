package com.google.android.gms.common;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.j.a;
import com.google.android.gms.common.j.ab;

public final class k {
    private static final k aQs = new k();

    private k() {
    }

    static a a(PackageInfo packageInfo, a... aVarArr) {
        if (packageInfo.signatures.length != 1) {
            return null;
        }
        ab abVar = new ab(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < aVarArr.length; i++) {
            if (aVarArr[i].equals(abVar)) {
                return aVarArr[i];
            }
        }
        if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
            new StringBuilder("Signature not valid.  Found: \n").append(Base64.encodeToString(abVar.getBytes(), 0));
        }
        return null;
    }

    private static boolean a(PackageInfo packageInfo, boolean z) {
        if (packageInfo.signatures.length != 1) {
            return false;
        }
        ab abVar = new ab(packageInfo.signatures[0].toByteArray());
        if ((z ? j.pJ() : j.pK()).contains(abVar)) {
            return true;
        }
        if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
            new StringBuilder("Signature not valid.  Found: \n").append(Base64.encodeToString(abVar.getBytes(), 0));
        }
        return false;
    }

    public static boolean a(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            if (packageInfo == null) {
                return false;
            }
            if (e.b(packageManager)) {
                return a(packageInfo, true);
            }
            boolean a = a(packageInfo, false);
            if (a) {
                return a;
            }
            a(packageInfo, true);
            return a;
        } catch (NameNotFoundException e) {
            if (!Log.isLoggable("GoogleSignatureVerifier", 3)) {
                return false;
            }
            new StringBuilder("Package manager can't find package ").append(str).append(", defaulting to false");
            return false;
        }
    }

    public static k pM() {
        return aQs;
    }
}
