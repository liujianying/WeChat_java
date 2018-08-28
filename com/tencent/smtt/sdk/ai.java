package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class ai {
    private static ai a = null;
    private static Context b = null;

    private ai() {
    }

    static ai a(Context context) {
        if (a == null) {
            synchronized (ai.class) {
                if (a == null) {
                    a = new ai();
                }
            }
        }
        b = context.getApplicationContext();
        return a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Properties e() {
        /*
        r4 = this;
        r1 = 0;
        r0 = r4.a();	 Catch:{ Exception -> 0x0020, all -> 0x002a }
        r2 = new java.util.Properties;	 Catch:{ Exception -> 0x0020, all -> 0x002a }
        r2.<init>();	 Catch:{ Exception -> 0x0020, all -> 0x002a }
        if (r0 == 0) goto L_0x0042;
    L_0x000c:
        r3 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x003d, all -> 0x002a }
        r3.<init>(r0);	 Catch:{ Exception -> 0x003d, all -> 0x002a }
        r0 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x003d, all -> 0x002a }
        r0.<init>(r3);	 Catch:{ Exception -> 0x003d, all -> 0x002a }
        r2.load(r0);	 Catch:{ Exception -> 0x0040, all -> 0x0039 }
    L_0x0019:
        if (r0 == 0) goto L_0x001e;
    L_0x001b:
        r0.close();	 Catch:{ IOException -> 0x0033 }
    L_0x001e:
        r0 = r2;
    L_0x001f:
        return r0;
    L_0x0020:
        r0 = move-exception;
        r2 = r1;
        r0 = r1;
    L_0x0023:
        if (r0 == 0) goto L_0x0028;
    L_0x0025:
        r0.close();	 Catch:{ IOException -> 0x0035 }
    L_0x0028:
        r0 = r2;
        goto L_0x001f;
    L_0x002a:
        r0 = move-exception;
        r2 = r0;
        r3 = r1;
    L_0x002d:
        if (r3 == 0) goto L_0x0032;
    L_0x002f:
        r3.close();	 Catch:{ IOException -> 0x0037 }
    L_0x0032:
        throw r2;
    L_0x0033:
        r0 = move-exception;
        goto L_0x001e;
    L_0x0035:
        r0 = move-exception;
        goto L_0x0028;
    L_0x0037:
        r0 = move-exception;
        goto L_0x0032;
    L_0x0039:
        r1 = move-exception;
        r2 = r1;
        r3 = r0;
        goto L_0x002d;
    L_0x003d:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0023;
    L_0x0040:
        r1 = move-exception;
        goto L_0x0023;
    L_0x0042:
        r0 = r1;
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.ai.e():java.util.Properties");
    }

    File a() {
        an.a();
        File file = new File(an.s(b), "tbscoreinstall.txt");
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            return null;
        }
    }

    void a(int i) {
        a("dexopt_retry_num", i);
    }

    void a(int i, int i2) {
        a("copy_core_ver", i);
        a("copy_status", i2);
    }

    void a(String str) {
        a("install_apk_path", str);
    }

    void a(String str, int i) {
        a(str, String.valueOf(i));
    }

    void a(String str, String str2) {
        Throwable th;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        FileOutputStream fileOutputStream3;
        try {
            Properties e = e();
            if (e != null) {
                e.setProperty(str, str2);
                File a = a();
                if (a != null) {
                    fileOutputStream3 = new FileOutputStream(a);
                    try {
                        e.store(fileOutputStream3, "update " + str + " and status!");
                        fileOutputStream2 = fileOutputStream3;
                    } catch (Exception e2) {
                        if (fileOutputStream3 != null) {
                            try {
                                fileOutputStream3.close();
                            } catch (IOException e3) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream3;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        throw th;
                    }
                }
            }
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                }
            }
        } catch (Exception e6) {
            fileOutputStream3 = null;
            if (fileOutputStream3 != null) {
                try {
                    fileOutputStream3.close();
                } catch (IOException e32) {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e42) {
                }
            }
            throw th;
        }
    }

    int b() {
        return c("install_core_ver");
    }

    int b(String str) {
        Properties e = e();
        return (e == null || e.getProperty(str) == null) ? -1 : Integer.parseInt(e.getProperty(str));
    }

    void b(int i) {
        a("unzip_retry_num", i);
    }

    void b(int i, int i2) {
        a("install_core_ver", i);
        a("install_status", i2);
    }

    int c() {
        return b("install_status");
    }

    int c(String str) {
        Properties e = e();
        return (e == null || e.getProperty(str) == null) ? 0 : Integer.parseInt(e.getProperty(str));
    }

    void c(int i) {
        a("incrupdate_status", i);
    }

    int d() {
        return b("incrupdate_status");
    }

    String d(String str) {
        Properties e = e();
        return (e == null || e.getProperty(str) == null) ? null : e.getProperty(str);
    }

    void d(int i) {
        a("unlzma_status", i);
    }
}
