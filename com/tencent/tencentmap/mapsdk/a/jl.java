package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.map.lib.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class jl {
    static final /* synthetic */ boolean a = (!jl.class.desiredAssertionStatus());
    private static boolean b = false;

    static boolean a(Context context, String str) {
        if (a || context != null) {
            File b = b(context, str);
            boolean exists = b.exists();
            d.a("libary:" + b.getAbsolutePath() + " is exist:" + exists);
            if (!exists && !b(context)) {
                return false;
            }
            try {
                System.load(b.getAbsolutePath());
                return true;
            } catch (UnsatisfiedLinkError e) {
                return false;
            }
        }
        throw new AssertionError();
    }

    public static File a(Context context) {
        return new File(context.getApplicationInfo().nativeLibraryDir);
    }

    private static File b(Context context, String str) {
        return new File(a(context), System.mapLibraryName(str));
    }

    private static boolean b(Context context) {
        Throwable th;
        if (b) {
            return false;
        }
        b = true;
        File a = a(context);
        a(a);
        ZipFile zipFile;
        File b;
        FileOutputStream fileOutputStream;
        try {
            zipFile = new ZipFile(new File(context.getApplicationInfo().sourceDir), 1);
            String[] strArr = jk.a;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str = strArr[i];
                ZipEntry a2 = a(zipFile, str);
                if (a2 == null) {
                    zipFile.close();
                    a(a);
                    return false;
                }
                b = b(context, str);
                d.a("Extracting native libraries into " + b.getAbsolutePath());
                if (!a && b.exists()) {
                    throw new AssertionError();
                } else if (b.createNewFile()) {
                    InputStream inputStream;
                    try {
                        inputStream = zipFile.getInputStream(a2);
                        try {
                            fileOutputStream = new FileOutputStream(b);
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = null;
                        }
                        try {
                            byte[] bArr = new byte[16384];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            fileOutputStream.close();
                            if (VERSION.SDK_INT >= 9) {
                                a(b, "setReadable", true, false);
                                a(b, "setExecutable", true, false);
                                a(b, "setWritable", true);
                            }
                            i++;
                        } catch (Throwable th3) {
                            th = th3;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = null;
                        inputStream = null;
                    }
                } else {
                    throw new IOException();
                }
            }
            zipFile.close();
            return true;
        } catch (IOException e) {
            if (b.exists() && !b.delete()) {
                d.b("Failed to delete " + b.getAbsolutePath());
            }
            zipFile.close();
            throw e;
        } catch (Throwable th5) {
            d.a("Failed to unpack native libraries", th5);
            a(a);
            return false;
        } catch (Throwable th6) {
            fileOutputStream.close();
        }
    }

    private static void a(File file, String str, boolean z) {
        if (file != null) {
            Method method = null;
            try {
                method = File.class.getMethod(str, new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException e) {
            }
            if (method != null) {
                try {
                    method.invoke(file, new Object[]{Boolean.valueOf(z)});
                } catch (IllegalArgumentException e2) {
                } catch (IllegalAccessException e3) {
                } catch (InvocationTargetException e4) {
                }
            }
        }
    }

    private static void a(File file, String str, boolean z, boolean z2) {
        if (file != null) {
            Method method = null;
            try {
                method = File.class.getMethod(str, new Class[]{Boolean.TYPE, Boolean.TYPE});
            } catch (NoSuchMethodException e) {
            }
            if (method != null) {
                try {
                    method.invoke(file, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
                } catch (IllegalArgumentException e2) {
                } catch (IllegalAccessException e3) {
                } catch (InvocationTargetException e4) {
                }
            }
        }
    }

    private static ZipEntry a(ZipFile zipFile, String str) {
        ZipEntry entry = zipFile.getEntry("lib/" + Build.CPU_ABI + "/" + System.mapLibraryName(str));
        return entry != null ? entry : zipFile.getEntry("lib/" + Build.CPU_ABI2 + "/" + System.mapLibraryName(str));
    }

    private static void a(File file) {
        try {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    file2.getName();
                    if (!file2.delete()) {
                        d.b("Failed to remove " + file2.getAbsolutePath());
                    }
                }
            }
            if (!file.delete()) {
                d.b("Failed to remove " + file.getAbsolutePath());
            }
        } catch (Throwable e) {
            d.a("Failed to remove old libs, ", e);
        }
    }
}
