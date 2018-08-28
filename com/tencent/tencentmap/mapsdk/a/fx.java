package com.tencent.tencentmap.mapsdk.a;

import android.util.Log;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class fx {
    private static volatile boolean a = false;
    private static volatile boolean b = false;
    private static volatile boolean c = false;
    private static FileWriter d = null;

    public static void a(String str, String str2) {
        boolean z = a;
        if (b) {
            a("D", "Hally-" + str, str2, null);
        }
    }

    private static void a(String str, String str2, String str3, Throwable th) {
        if (em.a() != null) {
            StringBuilder stringBuilder = new StringBuilder(str + "\t");
            stringBuilder.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis())) + "\t");
            stringBuilder.append(str2 + "\t");
            if (str3 != null) {
                stringBuilder.append("[MSG]" + str3 + "\t");
            }
            if (th != null) {
                stringBuilder.append("[Throwable]" + Log.getStackTraceString(th));
            }
            stringBuilder.append("\r\n");
            synchronized (fx.class) {
                if (d != null) {
                    try {
                        d.write(stringBuilder.toString());
                        d.flush();
                    } catch (IOException e) {
                        try {
                            d.close();
                        } catch (IOException e2) {
                        }
                        d = null;
                    }
                }
                if (d == null) {
                    String str4 = "halleylog_" + new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date(System.currentTimeMillis()));
                    if (fz.a()) {
                        String str5 = fz.b() + "/Log";
                        File file = new File(str5);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        file = new File(str5, str4);
                        if (file.isDirectory()) {
                            file.delete();
                        }
                        if (!file.exists()) {
                            try {
                                file.createNewFile();
                            } catch (IOException e3) {
                                if (d != null) {
                                    try {
                                        d.close();
                                    } catch (Exception e4) {
                                    }
                                    d = null;
                                }
                                return;
                            }
                        }
                        try {
                            FileWriter fileWriter = new FileWriter(file, true);
                            d = fileWriter;
                            fileWriter.write(stringBuilder.toString());
                            d.flush();
                        } catch (IOException e5) {
                            if (d != null) {
                                try {
                                    d.close();
                                } catch (Exception e6) {
                                }
                                d = null;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        boolean z = a;
        if (b) {
            a("W", "Hally-" + str, str2, th);
        }
    }

    public static void a(boolean z) {
        a = z;
        b = z;
    }

    public static void b(String str, String str2) {
        boolean z = a;
        if (b) {
            a("I", "Hally-" + str, str2, null);
        }
    }

    public static void b(boolean z) {
        c = z;
    }

    public static void c(String str, String str2) {
        boolean z = a;
        if (b) {
            a("W", "Hally-" + str, str2, null);
        }
    }
}
