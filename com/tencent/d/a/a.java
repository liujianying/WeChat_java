package com.tencent.d.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.d.a.c.c;
import com.tencent.d.a.c.d;
import com.tencent.d.a.c.e;
import com.tencent.d.a.c.f;
import com.tencent.d.a.c.g;
import com.tencent.d.a.c.h;
import com.tencent.d.a.c.i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.security.UnrecoverableEntryException;

public final class a implements com.tencent.d.a.c.a {
    private static boolean vkS = false;

    @SuppressLint({"PrivateApi"})
    public static void setUp() {
        try {
            Method method = Class.forName("android.security.keystore.SoterKeyStoreProvider").getMethod("install", new Class[0]);
            method.setAccessible(true);
            method.invoke(null, new Object[0]);
        } catch (ClassNotFoundException e) {
            c.i("Soter.SoterCore", "soter: no SoterProvider found", new Object[0]);
        } catch (NoSuchMethodException e2) {
            c.i("Soter.SoterCore", "soter: function not found", new Object[0]);
        } catch (IllegalAccessException e3) {
            c.i("Soter.SoterCore", "soter: cannot access", new Object[0]);
        } catch (InvocationTargetException e4) {
            c.i("Soter.SoterCore", "soter: InvocationTargetException", new Object[0]);
        } finally {
            vkS = true;
        }
    }

    public static boolean cFz() {
        if (!vkS) {
            setUp();
        }
        if (g.cFL()) {
            c.w("Soter.SoterCore", "hy: the device has already triggered OOM. mark as not support", new Object[0]);
            return false;
        }
        Provider[] providers = Security.getProviders();
        if (providers == null) {
            c.e("Soter.SoterCore", "soter: no provider supported", new Object[0]);
            return false;
        }
        for (Provider name : providers) {
            if ("SoterKeyStore".equals(name.getName())) {
                c.i("Soter.SoterCore", "soter: found soter provider", new Object[0]);
                return true;
            }
        }
        c.i("Soter.SoterCore", "soter: soter provider not found", new Object[0]);
        return false;
    }

    public static e cFA() {
        c.i("Soter.SoterCore", "soter: start generate ask", new Object[0]);
        if (cFz()) {
            try {
                KeyStore.getInstance("AndroidKeyStore").load(null);
                KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "SoterKeyStore");
                instance.initialize(com.tencent.d.a.b.a.acE(d.cFJ().vly + ".addcounter.auto_signed_when_get_pubkey_attk").M(new String[]{"SHA-256"}).N(new String[]{"PSS"}).cFH());
                long nanoTime = System.nanoTime();
                instance.generateKeyPair();
                long gU = f.gU(nanoTime);
                c.i("Soter.SoterCore", "soter: generate successfully. cost: %d ms", new Object[]{Long.valueOf(gU)});
                return new e(0);
            } catch (Throwable e) {
                Throwable th = e;
                c.e("Soter.SoterCore", "soter: generateAppGlobalSecureKey " + th.toString(), new Object[0]);
                c.a("Soter.SoterCore", th, "soter: generateAppGlobalSecureKey error");
                return new e(4, th.toString());
            } catch (Throwable e2) {
                c.a("Soter.SoterCore", e2, "soter: out of memory when generate ASK!! maybe no attk inside");
                g.cFK();
            }
        } else {
            c.e("Soter.SoterCore", "soter: not support soter", new Object[0]);
            return new e(2);
        }
    }

    public static e cFB() {
        c.i("Soter.SoterCore", "soter: start remove app global secure key", new Object[0]);
        if (cFz()) {
            try {
                KeyStore instance = KeyStore.getInstance("SoterKeyStore");
                instance.load(null);
                instance.deleteEntry(d.cFJ().vly);
                return new e(0);
            } catch (Exception e) {
                Exception exception = e;
                c.e("Soter.SoterCore", "soter: removeAppGlobalSecureKey " + exception.toString(), new Object[0]);
                return new e(5, exception.toString());
            }
        }
        c.e("Soter.SoterCore", "soter: not support soter", new Object[0]);
        return new e(2);
    }

    public static boolean cFC() {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            if (instance.getCertificate(d.cFJ().vly) != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            c.e("Soter.SoterCore", "soter: hasAppGlobalSecureKey exception: " + e.toString(), new Object[0]);
            return false;
        }
    }

    public static boolean cFD() {
        return cFC() && cFE() != null;
    }

    public static h cFE() {
        c.i("Soter.SoterCore", "soter: start get app global secure key pub", new Object[0]);
        if (cFz()) {
            try {
                KeyStore instance = KeyStore.getInstance("SoterKeyStore");
                instance.load(null);
                try {
                    Key key = instance.getKey(d.cFJ().vly, "from_soter_ui".toCharArray());
                    if (key != null) {
                        return bR(key.getEncoded());
                    }
                    c.e("Soter.SoterCore", "soter: key can not be retrieved", new Object[0]);
                    return null;
                } catch (ClassCastException e) {
                    c.e("Soter.SoterCore", "soter: cast error: " + e.toString(), new Object[0]);
                    return null;
                }
            } catch (Throwable e2) {
                c.a("Soter.SoterCore", e2, "soter: error when get ask");
                return null;
            } catch (Throwable e22) {
                c.a("Soter.SoterCore", e22, "soter: out of memory when getting ask!! maybe no attk inside");
                g.cFK();
                return null;
            }
        }
        c.e("Soter.SoterCore", "soter: not support soter", new Object[0]);
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.d.a.c.e acy(java.lang.String r8) {
        /*
        r7 = 5;
        r3 = 1;
        r6 = 0;
        r0 = com.tencent.d.a.c.f.oW(r8);
        if (r0 == 0) goto L_0x001d;
    L_0x0009:
        r0 = "Soter.SoterCore";
        r1 = "soter: auth key name is null or nil. abort.";
        r2 = new java.lang.Object[r6];
        com.tencent.d.a.c.c.e(r0, r1, r2);
        r0 = new com.tencent.d.a.c.e;
        r1 = "no authKeyName";
        r0.<init>(r3, r1);
    L_0x001c:
        return r0;
    L_0x001d:
        r0 = cFz();
        if (r0 == 0) goto L_0x0123;
    L_0x0023:
        r0 = cFC();	 Catch:{ Exception -> 0x0033, OutOfMemoryError -> 0x010e }
        if (r0 != 0) goto L_0x005b;
    L_0x0029:
        r0 = new com.tencent.d.a.c.e;	 Catch:{ Exception -> 0x0033, OutOfMemoryError -> 0x010e }
        r1 = 3;
        r2 = "app secure key not exist";
        r0.<init>(r1, r2);	 Catch:{ Exception -> 0x0033, OutOfMemoryError -> 0x010e }
        goto L_0x001c;
    L_0x0033:
        r0 = move-exception;
        r1 = r0;
        r0 = "Soter.SoterCore";
        r2 = new java.lang.StringBuilder;
        r3 = "soter: generate auth key failed: ";
        r2.<init>(r3);
        r3 = r1.toString();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r3 = new java.lang.Object[r6];
        com.tencent.d.a.c.c.e(r0, r2, r3);
        r0 = new com.tencent.d.a.c.e;
        r1 = r1.toString();
        r0.<init>(r7, r1);
        goto L_0x001c;
    L_0x005b:
        r0 = "AndroidKeyStore";
        r0 = java.security.KeyStore.getInstance(r0);	 Catch:{ Exception -> 0x0033, OutOfMemoryError -> 0x010e }
        r1 = 0;
        r0.load(r1);	 Catch:{ Exception -> 0x0033, OutOfMemoryError -> 0x010e }
        r0 = "RSA";
        r1 = "SoterKeyStore";
        r0 = java.security.KeyPairGenerator.getInstance(r0, r1);	 Catch:{ Exception -> 0x0033, OutOfMemoryError -> 0x010e }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r1.<init>();	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r1 = r1.append(r8);	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r2 = ".addcounter.auto_signed_when_get_pubkey(%s).secmsg_and_counter_signed_when_sign";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r4 = 0;
        r5 = com.tencent.d.a.c.d.cFJ();	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r5 = r5.vly;	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r3[r4] = r5;	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r2 = java.lang.String.format(r2, r3);	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r1 = com.tencent.d.a.b.a.acE(r1);	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r3 = 0;
        r4 = "SHA-256";
        r2[r3] = r4;	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r1 = r1.M(r2);	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r1 = r1.cFI();	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r3 = 0;
        r4 = "PSS";
        r2[r3] = r4;	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r1 = r1.N(r2);	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r1 = r1.cFH();	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r0.initialize(r1);	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r2 = java.lang.System.nanoTime();	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r0.generateKeyPair();	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r0 = com.tencent.d.a.c.f.gU(r2);	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r2 = "Soter.SoterCore";
        r3 = "soter: generate successfully, cost: %d ms";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r5 = 0;
        r0 = java.lang.Long.valueOf(r0);	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r4[r5] = r0;	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        com.tencent.d.a.c.c.i(r2, r3, r4);	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r0 = new com.tencent.d.a.c.e;	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        r1 = 0;
        r0.<init>(r1);	 Catch:{ Exception -> 0x00e3, OutOfMemoryError -> 0x010e }
        goto L_0x001c;
    L_0x00e3:
        r0 = move-exception;
        r1 = r0;
        r0 = "Soter.SoterCore";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0033, OutOfMemoryError -> 0x010e }
        r3 = "soter: cause exception. maybe reflection exception: ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x0033, OutOfMemoryError -> 0x010e }
        r3 = r1.toString();	 Catch:{ Exception -> 0x0033, OutOfMemoryError -> 0x010e }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0033, OutOfMemoryError -> 0x010e }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0033, OutOfMemoryError -> 0x010e }
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0033, OutOfMemoryError -> 0x010e }
        com.tencent.d.a.c.c.e(r0, r2, r3);	 Catch:{ Exception -> 0x0033, OutOfMemoryError -> 0x010e }
        r0 = new com.tencent.d.a.c.e;	 Catch:{ Exception -> 0x0033, OutOfMemoryError -> 0x010e }
        r2 = 5;
        r1 = r1.toString();	 Catch:{ Exception -> 0x0033, OutOfMemoryError -> 0x010e }
        r0.<init>(r2, r1);	 Catch:{ Exception -> 0x0033, OutOfMemoryError -> 0x010e }
        goto L_0x001c;
    L_0x010e:
        r0 = move-exception;
        r1 = "Soter.SoterCore";
        r2 = "soter: out of memory when generate AuthKey!! maybe no attk inside";
        com.tencent.d.a.c.c.a(r1, r0, r2);
        com.tencent.d.a.c.g.cFK();
    L_0x011b:
        r0 = new com.tencent.d.a.c.e;
        r1 = 2;
        r0.<init>(r1);
        goto L_0x001c;
    L_0x0123:
        r0 = "Soter.SoterCore";
        r1 = "soter: not support soter";
        r2 = new java.lang.Object[r6];
        com.tencent.d.a.c.c.e(r0, r1, r2);
        goto L_0x011b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.d.a.a.acy(java.lang.String):com.tencent.d.a.c.e");
    }

    public static e bD(String str, boolean z) {
        if (f.oW(str)) {
            c.e("Soter.SoterCore", "soter: auth key name is null or nil. abort.", new Object[0]);
            return new e(1, "no authKeyName");
        }
        c.i("Soter.SoterCore", "soter: start remove key: " + str, new Object[0]);
        if (cFz()) {
            try {
                KeyStore instance = KeyStore.getInstance("SoterKeyStore");
                instance.load(null);
                instance.deleteEntry(str);
                if (z) {
                    c.i("Soter.SoterCore", "soter: auto delete ask", new Object[0]);
                    if (cFC()) {
                        cFB();
                    }
                }
                return new e(0);
            } catch (Exception e) {
                Exception exception = e;
                c.e("Soter.SoterCore", "soter: removeAuthKey " + exception.toString(), new Object[0]);
                return new e(6, exception.toString());
            }
        }
        c.e("Soter.SoterCore", "soter: not support soter", new Object[0]);
        return new e(2);
    }

    public static boolean acz(String str) {
        if (f.oW(str)) {
            c.e("Soter.SoterCore", "soter: authkey name not correct", new Object[0]);
            return false;
        }
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            if (instance.getCertificate(str) != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            c.e("Soter.SoterCore", "soter: hasAppGlobalSecureKey exception: " + e.toString(), new Object[0]);
            return false;
        }
    }

    public static boolean acA(String str) {
        c.i("Soter.SoterCore", String.format("soter: checking key valid: auth key name: %s, autoDelIfNotValid: %b ", new Object[]{str, Boolean.valueOf(true)}), new Object[0]);
        if (f.oW(str)) {
            c.e("Soter.SoterCore", "soter: checking key valid: authkey name not correct", new Object[0]);
            return false;
        }
        try {
            acD(str);
            c.i("Soter.SoterCore", "soter: key valid", new Object[0]);
            return true;
        } catch (UnrecoverableEntryException e) {
            c.e("Soter.SoterCore", "soter: key invalid.", new Object[0]);
            bD(str, false);
            return false;
        } catch (InvalidKeyException e2) {
            c.e("Soter.SoterCore", "soter: key invalid.", new Object[0]);
            bD(str, false);
            return false;
        } catch (Throwable e3) {
            c.e("Soter.SoterCore", "soter: occurs other exceptions: %s", new Object[]{e3.toString()});
            c.a("Soter.SoterCore", e3, "soter: occurs other exceptions");
            return false;
        } catch (Throwable e4) {
            c.a("Soter.SoterCore", e4, "soter: out of memory when isAuthKeyValid!! maybe no attk inside");
            g.cFK();
            return false;
        }
    }

    public static h acB(String str) {
        if (f.oW(str)) {
            c.e("Soter.SoterCore", "soter: auth key name is null or nil. abort.", new Object[0]);
            return null;
        } else if (cFz()) {
            try {
                KeyStore instance = KeyStore.getInstance("SoterKeyStore");
                instance.load(null);
                try {
                    Key key = instance.getKey(str, "from_soter_ui".toCharArray());
                    if (key != null) {
                        return bR(key.getEncoded());
                    }
                    c.e("Soter.SoterCore", "soter: key can not be retrieved", new Object[0]);
                    return null;
                } catch (ClassCastException e) {
                    c.e("Soter.SoterCore", "soter: cast error: " + e.toString(), new Object[0]);
                    return null;
                }
            } catch (Throwable e2) {
                c.a("Soter.SoterCore", e2, "soter: error in get auth key model");
                return null;
            } catch (Throwable e22) {
                c.a("Soter.SoterCore", e22, "soter: out of memory when getAuthKeyModel!! maybe no attk inside");
                g.cFK();
                return null;
            }
        } else {
            c.e("Soter.SoterCore", "soter: not support soter AndroidKeyStore", new Object[0]);
            return null;
        }
    }

    public static Signature acC(String str) {
        Signature signature = null;
        if (f.oW(str)) {
            c.e("Soter.SoterCore", "soter: auth key name is null or nil. abort.", new Object[0]);
            return signature;
        } else if (cFz()) {
            try {
                return acD(str);
            } catch (UnrecoverableEntryException e) {
            } catch (InvalidKeyException e2) {
            } catch (Throwable e3) {
                c.e("Soter.SoterCore", "soter: exception when getSignatureResult: " + e3.toString(), new Object[0]);
                c.a("Soter.SoterCore", e3, "soter: exception when getSignatureResult");
                return signature;
            } catch (Throwable e32) {
                c.a("Soter.SoterCore", e32, "soter: out of memory when getAuthInitAndSign!! maybe no attk inside");
                g.cFK();
                return signature;
            }
        } else {
            c.e("Soter.SoterCore", "soter: not support soterAndroidKeyStore", new Object[0]);
            return signature;
        }
        c.e("Soter.SoterCore", "soter: key invalid. Advice remove the key", new Object[0]);
        return signature;
    }

    private static Signature acD(String str) {
        if (f.oW(str)) {
            c.e("Soter.SoterCore", "soter: auth key name is null or nil. abort.", new Object[0]);
            return null;
        }
        Signature instance = Signature.getInstance("SHA256withRSA/PSS", "AndroidKeyStoreBCWorkaround");
        KeyStore instance2 = KeyStore.getInstance("SoterKeyStore");
        instance2.load(null);
        PrivateKeyEntry privateKeyEntry = (PrivateKeyEntry) instance2.getEntry(str, null);
        if (privateKeyEntry != null) {
            instance.initSign(privateKeyEntry.getPrivateKey());
            return instance;
        }
        c.e("Soter.SoterCore", "soter: entry not exists", new Object[0]);
        return null;
    }

    public static i bP(byte[] bArr) {
        i iVar = null;
        int i = (bArr == null || bArr.length <= 0) ? 1 : 0;
        if (i != 0) {
            c.e("Soter.SoterCore", "origin is null or nil. abort", new Object[0]);
        } else if (bArr.length < 4) {
            c.e("Soter.SoterCore", "soter: length not correct 1", new Object[0]);
        } else {
            Object obj = new byte[4];
            System.arraycopy(bArr, 0, obj, 0, 4);
            i = bQ(obj);
            c.d("Soter", "parsed raw length: " + i, new Object[0]);
            if (i > 1048576) {
                c.e("Soter.SoterCore", "soter: too large signature result!", new Object[0]);
            } else {
                Object obj2 = new byte[i];
                if (bArr.length <= i + 4) {
                    c.e("Soter.SoterCore", "soter: length not correct 2", new Object[0]);
                } else {
                    System.arraycopy(bArr, 4, obj2, 0, i);
                    iVar = i.acF(new String(obj2));
                    int length = bArr.length - (i + 4);
                    c.d("Soter.SoterCore", "soter: signature length: " + length, new Object[0]);
                    Object obj3 = new byte[length];
                    System.arraycopy(bArr, i + 4, obj3, 0, length);
                    if (iVar != null) {
                        iVar.signature = Base64.encodeToString(obj3, 2);
                    }
                }
            }
        }
        return iVar;
    }

    private static int bQ(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= 4) {
                return i3;
            }
            i = ((bArr[i2] & 255) << (i2 * 8)) + i3;
            i2++;
        }
    }

    private static h bR(byte[] bArr) {
        if (bArr == null) {
            c.e("Soter.SoterCore", "soter: raw data is null", new Object[0]);
            return null;
        }
        if (bArr.length < 4) {
            c.e("Soter.SoterCore", "soter: raw data length smaller than RAW_LENGTH_PREFIX", new Object[0]);
        }
        Object obj = new byte[4];
        System.arraycopy(bArr, 0, obj, 0, 4);
        int bQ = bQ(obj);
        c.d("Soter.SoterCore", "soter: parsed raw length: " + bQ, new Object[0]);
        if (bQ > 1048576) {
            c.e("Soter.SoterCore", "soter: too large json result!", new Object[0]);
            return null;
        }
        Object obj2 = new byte[bQ];
        if (bArr.length <= bQ + 4) {
            c.e("Soter.SoterCore", "length not correct 2", new Object[0]);
            return null;
        }
        System.arraycopy(bArr, 4, obj2, 0, bQ);
        String str = new String(obj2);
        c.d("Soter.SoterCore", "soter: to convert json: " + str, new Object[0]);
        h hVar = new h(str, "");
        int length = bArr.length - (bQ + 4);
        c.d("Soter.SoterCore", "soter: signature length: " + length, new Object[0]);
        Object obj3 = new byte[length];
        System.arraycopy(bArr, bQ + 4, obj3, 0, length);
        hVar.signature = Base64.encodeToString(obj3, 2);
        return hVar;
    }

    public static boolean hy(Context context) {
        return com.tencent.d.a.a.a.hB(context).isHardwareDetected();
    }

    public static boolean hz(Context context) {
        return com.tencent.d.a.a.a.hB(context).hasEnrolledFingerprints();
    }

    public static boolean hA(Context context) {
        return (com.tencent.d.a.a.c.hJ(context) || com.tencent.d.a.a.c.hI(context)) ? false : true;
    }

    public static String cFF() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<deviceinfo>");
        stringBuilder.append("<MANUFACTURER name=\"");
        stringBuilder.append(Build.MANUFACTURER);
        stringBuilder.append("\">");
        stringBuilder.append("<MODEL name=\"");
        stringBuilder.append(Build.MODEL);
        stringBuilder.append("\">");
        stringBuilder.append("<VERSION_RELEASE name=\"");
        stringBuilder.append(VERSION.RELEASE);
        stringBuilder.append("\">");
        stringBuilder.append("<VERSION_INCREMENTAL name=\"");
        stringBuilder.append(VERSION.INCREMENTAL);
        stringBuilder.append("\">");
        stringBuilder.append("<DISPLAY name=\"");
        stringBuilder.append(Build.DISPLAY);
        stringBuilder.append("\">");
        stringBuilder.append("</DISPLAY></VERSION_INCREMENTAL></VERSION_RELEASE></MODEL></MANUFACTURER></deviceinfo>");
        c.d("Soter.SoterCore", "soter: getFingerprint  " + stringBuilder.toString(), new Object[0]);
        return stringBuilder.toString();
    }
}
