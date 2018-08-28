package com.tencent.c.d.b;

import android.os.Build.VERSION;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;

public final class f {
    private static Boolean vjx = null;
    private static final Object vjy = new Object();

    public static boolean cFi() {
        Boolean bool;
        boolean booleanValue;
        Throwable th;
        Closeable closeable;
        boolean z = false;
        synchronized (vjy) {
            if (vjx == null) {
                if (VERSION.SDK_INT < 17 || !new File("/sys/fs/selinux/enforce").exists()) {
                    bool = null;
                } else {
                    Closeable fileInputStream;
                    try {
                        fileInputStream = new FileInputStream("/sys/fs/selinux/enforce");
                        try {
                            if (fileInputStream.read() == 49) {
                                z = true;
                            }
                            Boolean valueOf = Boolean.valueOf(z);
                            b.b(fileInputStream);
                            bool = valueOf;
                        } catch (Exception e) {
                            b.b(fileInputStream);
                            bool = null;
                            if (bool == null) {
                                bool = Boolean.valueOf(false);
                            }
                            vjx = bool;
                            booleanValue = vjx.booleanValue();
                            return booleanValue;
                        } catch (Throwable th2) {
                            th = th2;
                            closeable = fileInputStream;
                            b.b(closeable);
                            throw th;
                        }
                    } catch (Exception e2) {
                        fileInputStream = null;
                        b.b(fileInputStream);
                        bool = null;
                        if (bool == null) {
                            bool = Boolean.valueOf(false);
                        }
                        vjx = bool;
                        booleanValue = vjx.booleanValue();
                        return booleanValue;
                    } catch (Throwable th3) {
                        th = th3;
                        closeable = null;
                        b.b(closeable);
                        throw th;
                    }
                }
                if (bool == null) {
                    bool = Boolean.valueOf(false);
                }
                vjx = bool;
            }
            booleanValue = vjx.booleanValue();
        }
        return booleanValue;
    }
}
