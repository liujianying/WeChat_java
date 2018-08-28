package com.google.android.gms.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Base64;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public final class a {
    static Map<String, a> aQR = new HashMap();
    public static e aQS;
    private static d aQT;
    public static String aQX;
    KeyPair aQU;
    public String aQV = "";
    long aQW;
    Context mContext;

    private a(Context context, String str) {
        this.mContext = context.getApplicationContext();
        this.aQV = str;
    }

    static String a(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + TbsListener$ErrorCode.DOWNLOAD_OVER_FLOW) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    static int an(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            new StringBuilder("Never happens: can't find own package ").append(e);
            return i;
        }
    }

    public static a ao(Context context) {
        return c(context, null);
    }

    public static synchronized a c(Context context, Bundle bundle) {
        a aVar;
        synchronized (a.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            String str = string == null ? "" : string;
            Context applicationContext = context.getApplicationContext();
            if (aQS == null) {
                aQS = new e(applicationContext);
                aQT = new d(applicationContext);
            }
            aQX = Integer.toString(an(applicationContext));
            aVar = (a) aQR.get(str);
            if (aVar == null) {
                aVar = new a(applicationContext, str);
                aQR.put(str, aVar);
            }
        }
        return aVar;
    }

    static String j(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    static e pN() {
        return aQS;
    }

    static d pO() {
        return aQT;
    }

    public static boolean pP() {
        String str = aQS.get("appVersion");
        if (str == null || !str.equals(aQX)) {
            return true;
        }
        str = aQS.get("lastToken");
        if (str == null) {
            return true;
        }
        return (System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(str)).longValue() > 604800;
    }

    public final String b(String str, String str2, Bundle bundle) {
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        String str3 = "".equals(this.aQV) ? str : this.aQV;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        d dVar = aQT;
        if (this.aQU == null) {
            this.aQU = aQS.bp(this.aQV);
        }
        if (this.aQU == null) {
            this.aQW = System.currentTimeMillis();
            this.aQU = aQS.c(this.aQV, this.aQW);
        }
        KeyPair keyPair = this.aQU;
        Intent a = dVar.a(bundle, keyPair);
        if (a != null && a.hasExtra("google.messenger")) {
            a = dVar.a(bundle, keyPair);
        }
        return d.g(a);
    }
}
