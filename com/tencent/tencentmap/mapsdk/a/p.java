package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class p {
    private static String a;
    private static String b;

    public static void a(Context context, String str, String str2, String str3) {
        if (!new File(str, str2).exists()) {
            c(context, str, str2, str3);
        }
    }

    public static void b(Context context, String str, String str2, String str3) {
        File file = new File(str, str2);
        if (file.exists()) {
            file.delete();
        }
        c(context, str, str2, str3);
    }

    public static final InputStream a(Context context, String str) {
        return a(context, "tencentmap/mapsdk_vector/", str);
    }

    public static final InputStream a(Context context, String str, String str2) {
        return b(context, str + str2);
    }

    public static final InputStream b(Context context, String str) {
        InputStream inputStream = null;
        if (context == null) {
            return inputStream;
        }
        AssetManager assets = context.getAssets();
        if (assets == null) {
            return inputStream;
        }
        try {
            return assets.open(str);
        } catch (IOException e) {
            return inputStream;
        }
    }

    private static void c(Context context, String str, String str2, String str3) {
        Closeable closeable;
        Throwable th;
        Closeable closeable2;
        Closeable b;
        try {
            b = q.b(o.a(context).i() + str3);
            if (b == null) {
                try {
                    if (a != null) {
                        b = b(context, a + str3);
                    } else if (b != null) {
                        b = q.b(b + str3);
                    }
                } catch (IOException e) {
                    closeable = null;
                    q.a(closeable);
                    q.a(b);
                } catch (Throwable th2) {
                    th = th2;
                    closeable2 = null;
                    q.a(closeable2);
                    q.a(b);
                    throw th;
                }
            }
            if (b == null) {
                b = a(context, str3);
            }
            closeable = new FileOutputStream(new File(str, str2));
            try {
                q.a(b, closeable);
                q.a(closeable);
                q.a(b);
            } catch (IOException e2) {
                q.a(closeable);
                q.a(b);
            } catch (Throwable th3) {
                th = th3;
                closeable2 = closeable;
                q.a(closeable2);
                q.a(b);
                throw th;
            }
        } catch (IOException e3) {
            closeable = null;
            b = null;
        } catch (Throwable th22) {
            th = th22;
            closeable2 = null;
            b = null;
            q.a(closeable2);
            q.a(b);
            throw th;
        }
    }

    public static void a(String str) {
        if (str != null && str.trim().length() != 0) {
            if (!str.endsWith(File.separator)) {
                str = str + File.separator;
            }
            a = str;
        }
    }

    public static void b(String str) {
        if (str != null && str.trim().length() != 0) {
            if (!str.endsWith(File.separator)) {
                str = str + File.separator;
            }
            b = str;
        }
    }

    public static String a() {
        return a;
    }

    public static String b() {
        return b;
    }
}
