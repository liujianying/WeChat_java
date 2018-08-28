package com.tencent.tinker.lib.f;

import com.tencent.tinker.c.b.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class c$a {
    public String bKg;
    public String vtf;

    public c$a(String str, String str2) {
        this.bKg = str;
        this.vtf = str2;
    }

    public static c$a ae(File file) {
        String property;
        Object e;
        Throwable th;
        String str = null;
        Properties properties = new Properties();
        Object fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                properties.load(fileInputStream);
                property = properties.getProperty("md5");
                try {
                    str = properties.getProperty("times");
                    a.ar(fileInputStream);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        a.e("Tinker.UpgradePatchRetry", "fail to readRetryProperty:" + e, new Object[0]);
                        a.ar(fileInputStream);
                        return new c$a(property, str);
                    } catch (Throwable th2) {
                        th = th2;
                        a.ar(fileInputStream);
                        throw th;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                property = str;
            }
        } catch (IOException e4) {
            e = e4;
            fileInputStream = str;
            property = str;
            a.e("Tinker.UpgradePatchRetry", "fail to readRetryProperty:" + e, new Object[0]);
            a.ar(fileInputStream);
            return new c$a(property, str);
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = str;
            a.ar(fileInputStream);
            throw th;
        }
        return new c$a(property, str);
    }

    public static void a(File file, c$a c_a) {
        Throwable e;
        if (c_a != null) {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            Properties properties = new Properties();
            properties.put("md5", c_a.bKg);
            properties.put("times", c_a.vtf);
            Object fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file, false);
                try {
                    properties.store(fileOutputStream, null);
                    a.ar(fileOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        a.printErrStackTrace("Tinker.UpgradePatchRetry", e, "retry write property fail", new Object[0]);
                        a.ar(fileOutputStream);
                    } catch (Throwable th) {
                        e = th;
                        a.ar(fileOutputStream);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                a.printErrStackTrace("Tinker.UpgradePatchRetry", e, "retry write property fail", new Object[0]);
                a.ar(fileOutputStream);
            } catch (Throwable th2) {
                e = th2;
                fileOutputStream = null;
                a.ar(fileOutputStream);
                throw e;
            }
        }
    }
}
