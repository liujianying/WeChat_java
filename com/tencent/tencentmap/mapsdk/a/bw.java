package com.tencent.tencentmap.mapsdk.a;

import com.qq.jutil.string.StringUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

public class bw {
    static String a = "tafnode.dat";
    static Properties b = new Properties();
    static AtomicBoolean c = new AtomicBoolean();
    static long d = System.currentTimeMillis();
    static Object e = new Object();

    public static lb a(String str, String str2, String str3, String str4, String str5, int i, int i2, String str6, String str7, String str8, String str9) {
        String str10;
        String str11;
        if (str6 == null || str6.length() == 0) {
            str10 = str + "@1.4.1";
        } else {
            str10 = str6 + str7 + str8 + b(str) + "@1.4.1";
        }
        String str12 = "";
        String str13 = "";
        String str14 = "";
        Object obj = null;
        if (str9 != null && str9.length() > 0) {
            String[] split = StringUtil.split(str9, ".");
            if (split.length == 3) {
                str12 = split[0];
                str13 = split[1];
                str14 = split[2];
                obj = 1;
                str11 = str12 + str13 + str14 + "." + b(a(str2, 127));
                if (obj == null) {
                    str11 = a(str11, 127);
                }
                return new lb(str10, str11, str3, str4, str5, i, i2, str12, str13, str14, "");
            }
        }
        str11 = str2;
        if (obj == null) {
            str11 = a(str11, 127);
        }
        return new lb(str10, str11, str3, str4, str5, i, i2, str12, str13, str14, "");
    }

    private static String b(String str) {
        String str2 = "";
        if (str == null) {
            return str2;
        }
        int indexOf = str.indexOf(46);
        if (indexOf >= 0) {
            return str.substring(indexOf + 1);
        }
        return str2;
    }

    private static String a(String str, int i) {
        String str2 = "";
        if (str == null) {
            return str2;
        }
        str2 = str.trim();
        if (str2.length() > i) {
            return str2.substring(0, i);
        }
        return str2;
    }

    public static synchronized void a() {
        synchronized (bw.class) {
            if (!c.get()) {
                InputStream inputStream = null;
                try {
                    inputStream = d();
                    b.load(inputStream);
                    ArrayList arrayList = new ArrayList();
                    for (Entry entry : b.entrySet()) {
                        if (entry.getKey().toString().startsWith("<")) {
                            arrayList.add(entry.getKey().toString());
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        b.remove((String) it.next());
                    }
                    ax.a("load " + a);
                    c.set(true);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Exception e2) {
                    throw new bl("read file " + a + " error " + e2);
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                }
            }
        }
        return;
    }

    public static String a(String str) {
        a();
        return b.getProperty(str);
    }

    public static ai<ArrayList<bb>, ArrayList<bb>> a(String str, int i, int i2, int i3) {
        String a = a(str);
        if (a == null) {
            ax.a("can not find cacheServerData " + str);
        } else {
            ax.a("getConfigFromRegister failed, try to use backData");
            try {
                return al.a(str, i, i2, i3, a);
            } catch (Throwable e) {
                ax.a("read cacheServerData " + str + " serviceList error " + a, e);
            }
        }
        return null;
    }

    public static void a(String str, String str2) {
        a();
        b.put(str, str2);
        synchronized (e) {
            if (System.currentTimeMillis() - d > 60000) {
                d = System.currentTimeMillis();
                c();
            }
        }
    }

    private static InputStream d() {
        File file = new File(a("TafUtils.class", bw.class));
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = File.separator;
        if (b()) {
            str = "/";
        }
        File file2 = new File(file + str + "tafnode.dat");
        if (!file2.exists()) {
            file2.createNewFile();
        }
        a = file2.getAbsolutePath();
        ax.a("set dataFilePath " + a);
        return new BufferedInputStream(new FileInputStream(file2));
    }

    public static boolean b() {
        return File.separatorChar == '\\';
    }

    public static String a(String str, Class cls) {
        String path = cls.getResource(str).getPath();
        if (path.startsWith("file:")) {
            path = path.substring(path.indexOf("/"));
            int indexOf = path.indexOf("!");
            if (indexOf > 0) {
                path = path.substring(0, indexOf);
            }
        }
        if (b() && path.startsWith("/")) {
            path = path.substring(1);
        }
        char c = File.separatorChar;
        if (b()) {
            c = '/';
        }
        int indexOf2 = path.indexOf("WEB-INF");
        if (indexOf2 > 0) {
            path = path.substring(0, indexOf2 + 7) + c + "classes" + c;
        }
        if (path.charAt(path.length() - 1) != c) {
            return path.substring(0, path.lastIndexOf(c) + 1);
        }
        return path;
    }

    public static void c() {
        Throwable e;
        OutputStream outputStream = null;
        try {
            a();
            File file = new File(a);
            if (!file.exists()) {
                file.createNewFile();
            }
            OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                b.store(bufferedOutputStream, new Date().toString());
                ax.a("save " + a);
                try {
                    bufferedOutputStream.close();
                } catch (IOException e2) {
                }
            } catch (Exception e3) {
                e = e3;
                outputStream = bufferedOutputStream;
                try {
                    ax.a("save " + a + " failed", e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable th) {
                    e = th;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                outputStream = bufferedOutputStream;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e52) {
                    }
                }
                throw e;
            }
        } catch (Exception e6) {
            e = e6;
            ax.a("save " + a + " failed", e);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e42) {
                }
            }
        }
    }

    public static double a(double d, double d2, int i) {
        if (i >= 0) {
            return new BigDecimal(Double.toString(d)).divide(new BigDecimal(Double.toString(d2)), i, 4).doubleValue();
        }
        throw new IllegalArgumentException("The scale must be a positive integer or zero");
    }
}
