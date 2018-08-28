package com.tencent.smtt.utils;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

public class t {
    private static t e = null;
    public boolean a = false;
    private Context b = null;
    private File c = null;
    private boolean d = false;
    private File f = null;

    private t(Context context) {
        this.b = context.getApplicationContext();
        b();
    }

    public static synchronized t a() {
        t tVar;
        synchronized (t.class) {
            tVar = e;
        }
        return tVar;
    }

    public static synchronized t a(Context context) {
        t tVar;
        synchronized (t.class) {
            if (e == null) {
                e = new t(context);
            }
            tVar = e;
        }
        return tVar;
    }

    private File d() {
        File file;
        try {
            if (this.c == null) {
                this.c = new File(this.b.getDir("tbs", 0), "core_private");
                if (this.c == null || !this.c.isDirectory()) {
                    return null;
                }
            }
            file = new File(this.c, "debug.conf");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Throwable th) {
            file = null;
        }
        return file;
    }

    public void a(boolean z) {
        this.d = z;
        c();
    }

    public synchronized void b() {
        Throwable th;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            if (this.f == null) {
                this.f = d();
            }
            if (this.f != null) {
                InputStream bufferedInputStream3 = new BufferedInputStream(new FileInputStream(this.f));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream3);
                    String property = properties.getProperty("setting_forceUseSystemWebview", "");
                    if (!"".equals(property)) {
                        this.a = Boolean.parseBoolean(property);
                    }
                    try {
                        bufferedInputStream3.close();
                    } catch (Exception e) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    InputStream bufferedInputStream4 = bufferedInputStream3;
                    if (bufferedInputStream4 != null) {
                        try {
                            bufferedInputStream4.close();
                        } catch (Exception e2) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream4 = null;
            if (bufferedInputStream4 != null) {
                try {
                    bufferedInputStream4.close();
                } catch (Exception e22) {
                }
            }
            throw th;
        }
        return;
    }

    public void c() {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        BufferedInputStream bufferedInputStream;
        try {
            File d = d();
            if (d == null) {
                BufferedInputStream bufferedInputStream2 = null;
                try {
                    bufferedInputStream2.close();
                } catch (Exception e) {
                }
                bufferedOutputStream2 = null;
                try {
                    bufferedOutputStream2.close();
                    return;
                } catch (Exception e2) {
                    return;
                }
            }
            Properties properties;
            bufferedInputStream = new BufferedInputStream(new FileInputStream(d));
            try {
                properties = new Properties();
                properties.load(bufferedInputStream);
                properties.setProperty("setting_forceUseSystemWebview", Boolean.toString(this.a));
                properties.setProperty("result_systemWebviewForceUsed", Boolean.toString(this.d));
                bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(d));
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
                try {
                    bufferedInputStream.close();
                } catch (Exception e3) {
                }
                try {
                    bufferedOutputStream.close();
                } catch (Exception e4) {
                }
                throw th;
            }
            try {
                properties.store(bufferedOutputStream2, null);
                try {
                    bufferedInputStream.close();
                } catch (Exception e5) {
                }
                try {
                    bufferedOutputStream2.close();
                } catch (Exception e6) {
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = bufferedOutputStream2;
                bufferedInputStream.close();
                bufferedOutputStream.close();
                throw th;
            }
        } catch (Throwable th22) {
            th = th22;
            bufferedOutputStream = null;
            bufferedInputStream = null;
            bufferedInputStream.close();
            bufferedOutputStream.close();
            throw th;
        }
    }
}
