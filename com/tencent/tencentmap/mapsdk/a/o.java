package com.tencent.tencentmap.mapsdk.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.storage.StorageManager;
import com.tencent.map.lib.util.StringUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class o {
    private static String a = "/Android/data/com.tencent.map/files";
    private static o d = null;
    private String b;
    private String c;
    private HashMap<String, Integer> e = new HashMap();
    private Context f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;

    private o(Context context) {
        if (context == null) {
            throw new Error("context can not be null");
        }
        this.f = context.getApplicationContext();
        a = "/Android/data/" + this.f.getPackageName() + "/files";
        c(context);
        String b = b(context);
        String a = jn.a(this.f);
        if (StringUtil.isEmpty(a)) {
            this.g = b + "/tencentmapsdk/";
        } else {
            this.g = b + "/tencentmapsdk/" + a;
        }
        this.h = this.g + "/data/v3/render/";
        this.i = this.g + "/sat/";
        this.k = context.getFilesDir().getAbsolutePath() + "/tencentMapSdk/config/";
        this.m = this.k + "temp/";
        this.l = context.getFilesDir().getAbsolutePath() + "/tencentMapSdk/assets/";
        this.j = this.h + "closeRoadDatas/";
        a();
    }

    public static o a(Context context) {
        if (d == null) {
            d = new o(context);
        }
        return d;
    }

    public void a() {
        try {
            String b = b();
            List<String> c = c();
            if (!(StringUtil.isEmpty(b) || b.equals(""))) {
                for (String equals : c) {
                    if (b.equals(equals)) {
                        try {
                            g("");
                            return;
                        } catch (FileNotFoundException e) {
                            return;
                        }
                    }
                }
            }
            b = "";
            if (StringUtil.isEmpty(b) || b.equals("")) {
                for (String equals2 : c) {
                    File file = new File(equals2 + this.g);
                    if (file.exists() && file.isDirectory()) {
                        break;
                    }
                }
            }
            String equals22 = b;
            c(equals22);
            try {
                g("");
            } catch (FileNotFoundException e2) {
            }
        } catch (Exception e3) {
            try {
                g("");
            } catch (FileNotFoundException e4) {
            }
        } catch (Throwable th) {
            try {
                g("");
            } catch (FileNotFoundException e5) {
            }
            throw th;
        }
    }

    public String b() {
        return this.b;
    }

    public List<String> c() {
        List arrayList = new ArrayList();
        String d = d();
        if (!StringUtil.isEmpty(d)) {
            arrayList.add(d);
        }
        for (String d2 : o()) {
            if (!StringUtil.isEmpty(d2) && a(d2)) {
                arrayList.add(d2);
            }
        }
        return arrayList;
    }

    public String d() {
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState == null || !externalStorageState.equals("mounted")) {
            return "";
        }
        return Environment.getExternalStorageDirectory().getPath();
    }

    public synchronized boolean a(String str) {
        boolean z;
        BufferedWriter bufferedWriter;
        Throwable th;
        if (str != null) {
            if (str.length() > 0) {
                int intValue;
                if (this.e.containsKey(str)) {
                    intValue = ((Integer) this.e.get(str)).intValue();
                } else {
                    intValue = 0;
                }
                switch (intValue) {
                    case 1:
                        z = false;
                        break;
                    case 2:
                        z = true;
                        break;
                    default:
                        FileWriter fileWriter;
                        try {
                            File file = new File(str, "test.txt");
                            if (file.exists()) {
                                file.delete();
                            }
                            file.createNewFile();
                            fileWriter = new FileWriter(file, true);
                            try {
                                bufferedWriter = new BufferedWriter(fileWriter);
                            } catch (Exception e) {
                                bufferedWriter = null;
                                z = false;
                                try {
                                    this.e.put(str, Integer.valueOf(1));
                                    if (bufferedWriter != null) {
                                        try {
                                            bufferedWriter.close();
                                        } catch (IOException e2) {
                                        }
                                    }
                                    if (fileWriter != null) {
                                        fileWriter.close();
                                    }
                                    return z;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (bufferedWriter != null) {
                                        try {
                                            bufferedWriter.close();
                                        } catch (IOException e3) {
                                            throw th;
                                        }
                                    }
                                    if (fileWriter != null) {
                                        fileWriter.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                bufferedWriter = null;
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                    } catch (IOException e32) {
                                        throw th;
                                    }
                                }
                                if (fileWriter != null) {
                                    fileWriter.close();
                                }
                                throw th;
                            }
                            try {
                                bufferedWriter.write("1");
                                bufferedWriter.flush();
                                try {
                                    file.delete();
                                    this.e.put(str, Integer.valueOf(2));
                                    try {
                                        bufferedWriter.close();
                                        fileWriter.close();
                                        z = true;
                                    } catch (IOException e4) {
                                        z = true;
                                    }
                                } catch (Exception e5) {
                                    z = true;
                                    this.e.put(str, Integer.valueOf(1));
                                    if (bufferedWriter != null) {
                                        try {
                                            bufferedWriter.close();
                                        } catch (IOException e22) {
                                        }
                                    }
                                    if (fileWriter != null) {
                                        fileWriter.close();
                                    }
                                    return z;
                                }
                            } catch (Exception e6) {
                                z = false;
                                this.e.put(str, Integer.valueOf(1));
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                    } catch (IOException e222) {
                                    }
                                }
                                if (fileWriter != null) {
                                    fileWriter.close();
                                }
                                return z;
                            }
                        } catch (Exception e7) {
                            bufferedWriter = null;
                            fileWriter = null;
                            z = false;
                            this.e.put(str, Integer.valueOf(1));
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e2222) {
                                }
                            }
                            if (fileWriter != null) {
                                fileWriter.close();
                            }
                            return z;
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedWriter = null;
                            fileWriter = null;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e322) {
                                    throw th;
                                }
                            }
                            if (fileWriter != null) {
                                fileWriter.close();
                            }
                            throw th;
                        }
                }
            }
        }
        z = false;
        return z;
    }

    public long b(String str) {
        try {
            StatFs statFs = new StatFs(str);
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Exception e) {
            return 0;
        }
    }

    public void c(String str) {
        this.b = str;
        r();
    }

    public boolean d(String str) {
        return e(str) > 157286400;
    }

    public long e(String str) {
        try {
            StatFs statFs = new StatFs(str);
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Exception e) {
            return 0;
        }
    }

    public static String b(Context context) {
        int checkPermission;
        Object obj = null;
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        int checkPermission2;
        if (VERSION.SDK_INT >= 23) {
            checkPermission = context.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", Process.myPid(), Process.myUid());
            checkPermission2 = context.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid());
        } else {
            checkPermission2 = 0;
            checkPermission = 0;
        }
        if (checkPermission == 0 && checkPermission2 == 0) {
            obj = 1;
        }
        if (!equals || obj == null) {
            return context.getFilesDir().getPath();
        }
        String path = Environment.getExternalStorageDirectory().getPath();
        if (f(path) >= 5) {
            return path;
        }
        path = context.getFilesDir().getPath();
        if (f(path) < 5) {
            return Environment.getExternalStorageDirectory().getPath();
        }
        return path;
    }

    @SuppressLint({"NewApi"})
    public static long f(String str) {
        try {
            long blockSize;
            long availableBlocks;
            StatFs statFs = new StatFs(str);
            if (VERSION.SDK_INT < 18) {
                blockSize = (long) statFs.getBlockSize();
                availableBlocks = (long) statFs.getAvailableBlocks();
            } else {
                blockSize = statFs.getBlockSizeLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            }
            return ((availableBlocks * blockSize) / 1024) / 1024;
        } catch (Exception e) {
            return 0;
        }
    }

    public String e() {
        return this.h;
    }

    public String f() {
        return this.i;
    }

    public String g() {
        return this.j;
    }

    public String h() {
        return this.k;
    }

    public String i() {
        return this.l;
    }

    public String j() {
        return this.m;
    }

    private synchronized File g(String str) {
        File file;
        switch (k()) {
            case 6:
                this.b = l();
                break;
            case 7:
            case 9:
                List<String> n = n();
                if (n != null && n.size() > 0) {
                    for (String str2 : n) {
                        if (!str2.equals("")) {
                            this.b = str2;
                        }
                    }
                }
                if (this.b.equals("")) {
                    this.b = l();
                    break;
                }
                break;
        }
        r();
        file = new File(this.b + str);
        if (file.exists()) {
            if (!(file.canWrite() && a(this.b))) {
                throw new FileNotFoundException();
            }
        } else if (!file.mkdirs()) {
            throw new FileNotFoundException();
        }
        return file;
    }

    private int k() {
        if (this.b.equals("")) {
            return 9;
        }
        String str = this.b;
        String h = h(str);
        if (!h.equals("mounted") && str.contains(a)) {
            h = h(str.replace(a, ""));
        }
        if (h.equals("bad_removal") || h.equals("removed")) {
            return 6;
        }
        if (h.equals("unmounted") || h.equals("shared")) {
            return 5;
        }
        if (!h.equals("mounted")) {
            return 9;
        }
        if (!d(this.b)) {
            return 8;
        }
        if (new File(this.b + this.g).exists()) {
            return 4;
        }
        return 7;
    }

    private String h(String str) {
        String i;
        if (VERSION.SDK_INT >= 9) {
            try {
                i = i(str);
            } catch (Exception e) {
            }
            if (i != null) {
                return "";
            }
            return i;
        }
        i = Environment.getExternalStorageState();
        if (i != null) {
            return i;
        }
        return "";
    }

    private String i(String str) {
        StorageManager storageManager = (StorageManager) this.f.getSystemService("storage");
        return (String) storageManager.getClass().getMethod("getVolumeState", new Class[]{String.class}).invoke(storageManager, new Object[]{str});
    }

    private String l() {
        String path = Environment.getExternalStorageDirectory().getPath();
        if (d(path) && a(path)) {
            return path;
        }
        String m = m();
        if (m.equals("")) {
            return !this.b.equals("") ? this.b : path;
        } else {
            return m;
        }
    }

    private String m() {
        String str = "";
        List<String> o = o();
        if (o != null) {
            long j = 157286401;
            for (String str2 : o) {
                String str22;
                long e = e(str22);
                if (e <= j || !a(str22)) {
                    e = j;
                    str22 = str;
                }
                j = e;
                str = str22;
            }
        }
        return str;
    }

    private List<String> n() {
        String d = d();
        List<String> o = o();
        o.add(0, d);
        List<String> arrayList = new ArrayList();
        for (String d2 : o) {
            if (!d2.equals(this.b) && a(d2)) {
                File file = new File(d2 + this.g);
                file.mkdirs();
                if (file.exists() && file.canWrite()) {
                    arrayList.add(d2);
                }
            }
        }
        return arrayList;
    }

    @TargetApi(19)
    private List<String> o() {
        List p;
        List<String> arrayList = new ArrayList();
        String path = Environment.getExternalStorageDirectory().getPath();
        if (VERSION.SDK_INT >= 9) {
            try {
                p = p();
            } catch (Exception e) {
            }
            if (p != null) {
                File[] externalFilesDirs;
                if (VERSION.SDK_INT >= 19) {
                    externalFilesDirs = this.f.getExternalFilesDirs(null);
                } else {
                    externalFilesDirs = null;
                }
                for (String str : p) {
                    String str2;
                    if (!a(path, str2)) {
                        if (externalFilesDirs != null) {
                            for (File file : externalFilesDirs) {
                                if (file != null && file.getAbsolutePath() != null && file.getAbsolutePath().contains(str2)) {
                                    str2 = file.getAbsolutePath();
                                    break;
                                }
                            }
                        }
                        File file2 = new File(str2);
                        if (file2.exists() && file2.isDirectory() && file2.canWrite()) {
                            arrayList.add(str2);
                        }
                    }
                }
            }
            return arrayList;
        }
        p = q();
        if (p != null) {
            File[] externalFilesDirs2;
            if (VERSION.SDK_INT >= 19) {
                externalFilesDirs2 = this.f.getExternalFilesDirs(null);
            } else {
                externalFilesDirs2 = null;
            }
            for (String str22 : p) {
                String str222;
                if (!a(path, str222)) {
                    if (externalFilesDirs2 != null) {
                        for (File file3 : externalFilesDirs2) {
                            if (file3 != null && file3.getAbsolutePath() != null && file3.getAbsolutePath().contains(str222)) {
                                str222 = file3.getAbsolutePath();
                                break;
                            }
                        }
                    }
                    File file22 = new File(str222);
                    if (file22.exists() && file22.isDirectory() && file22.canWrite()) {
                        arrayList.add(str222);
                    }
                }
            }
        }
        return arrayList;
    }

    private List<String> p() {
        StorageManager storageManager = (StorageManager) this.f.getSystemService("storage");
        return Arrays.asList((String[]) storageManager.getClass().getMethod("getVolumePaths", new Class[0]).invoke(storageManager, new Object[0]));
    }

    private List<String> q() {
        List arrayList = new ArrayList();
        String path = Environment.getExternalStorageDirectory().getPath();
        try {
            Scanner scanner = new Scanner(new File("/proc/mounts"));
            while (scanner.hasNext()) {
                String nextLine = scanner.nextLine();
                if (nextLine.startsWith("/dev/block/vold/")) {
                    nextLine = nextLine.split(" ")[1];
                    if (!nextLine.equals(path)) {
                        arrayList.add(nextLine);
                    }
                }
            }
            scanner.close();
        } catch (Exception e) {
        }
        return arrayList;
    }

    private boolean a(String str, String str2) {
        if (str == null || str2 == null) {
            return true;
        }
        boolean equals = str.equals(str2);
        boolean z;
        if (b(str) == b(str2)) {
            z = true;
        } else {
            z = false;
        }
        if (equals || z) {
            return true;
        }
        return false;
    }

    private void c(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("default_storage_path", 0);
        String string = sharedPreferences.getString("key_for_city_data_path", "");
        this.b = string;
        this.c = string;
        if (this.b.equals("")) {
            String string2 = sharedPreferences.getString("key_for_storage_path", "");
            this.b = string2;
            this.c = string2;
        }
    }

    private void r() {
        if (!this.b.equals("") && !this.b.equals(this.c)) {
            Editor edit = this.f.getSharedPreferences("default_storage_path", 0).edit();
            edit.putString("key_for_city_data_path", "");
            edit.putString("key_for_storage_path", this.b);
            edit.commit();
            this.c = this.b;
        }
    }
}
