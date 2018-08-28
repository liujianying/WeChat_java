package com.tencent.c.d.a;

import com.tencent.c.d.b.a;
import com.tencent.c.d.b.c;
import com.tencent.c.f.h;
import java.io.File;

public final class f {
    private static boolean X(File file) {
        try {
            if ((c.acr(file.getAbsolutePath()) & 2048) > 0) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            h.k(e);
            return false;
        }
    }

    public static boolean cFg() {
        if (com.tencent.c.d.b.f.cFi()) {
            h.i("SetuidBitChecker : SELinux is enforcing");
            return false;
        }
        try {
            int i;
            int length;
            boolean z;
            String str = new String(a.acq("/proc/mounts"));
            h.d("SetuidBitChecker mounts : " + str);
            for (String str2 : str.split("\n")) {
                if (str2.contains(" /system ")) {
                    if (str2.contains(",nosuid")) {
                        h.i("SetuidBitChecker : nosuid found");
                        z = true;
                        if (!z) {
                            return false;
                        }
                        if (c.isAvailable()) {
                            File file;
                            File[] listFiles = new File("/system/bin").listFiles();
                            if (listFiles != null) {
                                length = listFiles.length;
                                i = 0;
                                while (i < length) {
                                    file = listFiles[i];
                                    if ("run-as".equals(file.getName()) || !X(file)) {
                                        i++;
                                    } else {
                                        h.i("SetuidBitChecker s-bit found : " + file.getAbsolutePath());
                                        return true;
                                    }
                                }
                            }
                            listFiles = new File("/system/xbin").listFiles();
                            if (listFiles != null) {
                                for (File file2 : listFiles) {
                                    if (X(file2)) {
                                        h.i("SetuidBitChecker s-bit found : " + file2.getAbsolutePath());
                                        return true;
                                    }
                                }
                            }
                            h.i("SetuidBitChecker s-bit not found");
                            return false;
                        }
                        h.i("SetuidBitChecker : OsUtil isn't available");
                        return false;
                    }
                    z = false;
                    if (!z) {
                        return false;
                    }
                    if (c.isAvailable()) {
                        File file22;
                        File[] listFiles2 = new File("/system/bin").listFiles();
                        if (listFiles2 != null) {
                            length = listFiles2.length;
                            i = 0;
                            while (i < length) {
                                file22 = listFiles2[i];
                                if ("run-as".equals(file22.getName()) || !X(file22)) {
                                    i++;
                                } else {
                                    h.i("SetuidBitChecker s-bit found : " + file22.getAbsolutePath());
                                    return true;
                                }
                            }
                        }
                        listFiles2 = new File("/system/xbin").listFiles();
                        if (listFiles2 != null) {
                            for (File file222 : listFiles2) {
                                if (X(file222)) {
                                    h.i("SetuidBitChecker s-bit found : " + file222.getAbsolutePath());
                                    return true;
                                }
                            }
                        }
                        h.i("SetuidBitChecker s-bit not found");
                        return false;
                    }
                    h.i("SetuidBitChecker : OsUtil isn't available");
                    return false;
                }
            }
            z = false;
            if (!z) {
                return false;
            }
            if (c.isAvailable()) {
                File file2222;
                File[] listFiles22 = new File("/system/bin").listFiles();
                if (listFiles22 != null) {
                    length = listFiles22.length;
                    i = 0;
                    while (i < length) {
                        file2222 = listFiles22[i];
                        if ("run-as".equals(file2222.getName()) || !X(file2222)) {
                            i++;
                        } else {
                            h.i("SetuidBitChecker s-bit found : " + file2222.getAbsolutePath());
                            return true;
                        }
                    }
                }
                listFiles22 = new File("/system/xbin").listFiles();
                if (listFiles22 != null) {
                    for (File file22222 : listFiles22) {
                        if (X(file22222)) {
                            h.i("SetuidBitChecker s-bit found : " + file22222.getAbsolutePath());
                            return true;
                        }
                    }
                }
                h.i("SetuidBitChecker s-bit not found");
                return false;
            }
            h.i("SetuidBitChecker : OsUtil isn't available");
            return false;
        } catch (Throwable e) {
            h.k(e);
            return false;
        }
    }
}
