package com.tencent.map.lib;

import android.os.Environment;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class d {
    public static boolean a = false;

    public static void a(String str) {
        if (a && str != null) {
        }
    }

    public static void a(String str, Throwable th) {
    }

    public static void b(String str) {
    }

    public static void c(String str) {
        if (a) {
            try {
                File file = new File(Environment.getExternalStorageDirectory(), "xiaozhi.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write(a() + " " + str + "\n");
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
            }
        }
    }

    public static void a(String str, String str2) {
        if (a) {
            try {
                File file = new File(Environment.getExternalStorageDirectory() + "/SOSOMap/");
                if (!file.exists()) {
                    file.mkdir();
                }
                File file2 = new File(file, str);
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                Writer fileWriter = new FileWriter(file2, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(str2);
                bufferedWriter.write("\n");
                bufferedWriter.flush();
                bufferedWriter.close();
                fileWriter.close();
            } catch (Exception e) {
            }
        }
    }

    private static String a() {
        return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.CHINA).format(new Date(System.currentTimeMillis()));
    }
}
