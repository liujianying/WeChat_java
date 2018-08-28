package com.tencent.matrix.trace.e;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.d.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public final class a {
    private static final FileFilter acg = new FileFilter() {
        public final boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    };
    private static a buJ = null;

    public enum a {
        BEST(5),
        HIGH(4),
        MIDDLE(3),
        LOW(2),
        BAD(1),
        UN_KNOW(-1);
        
        public int value;

        private a(int i) {
            this.value = i;
        }
    }

    public static a aB(Context context) {
        if (buJ != null) {
            return buJ;
        }
        long U = U(context);
        int tI = tI();
        b.i("Matrix.DeviceUtil", "[getLevel] totalMemory:%s coresNum:%s", Long.valueOf(U), Integer.valueOf(tI));
        if (U >= 4294967296L) {
            buJ = a.BEST;
        } else if (U >= 3221225472L) {
            buJ = a.HIGH;
        } else if (U >= 2147483648L) {
            if (tI >= 4) {
                buJ = a.HIGH;
            } else if (tI >= 2) {
                buJ = a.MIDDLE;
            } else if (tI > 0) {
                buJ = a.LOW;
            }
        } else if (U >= 1073741824) {
            if (tI >= 4) {
                buJ = a.MIDDLE;
            } else if (tI >= 2) {
                buJ = a.LOW;
            } else if (tI > 0) {
                buJ = a.LOW;
            }
        } else if (0 > U || U >= 1073741824) {
            buJ = a.UN_KNOW;
        } else {
            buJ = a.BAD;
        }
        return buJ;
    }

    private static long U(Context context) {
        if (VERSION.SDK_INT >= 16) {
            MemoryInfo memoryInfo = new MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"));
            String readLine = bufferedReader.readLine();
            String[] split = readLine.split("\\s+");
            for (String str : split) {
                b.i(readLine, str + "\t", new Object[0]);
            }
            long parseInt = (long) (Integer.parseInt(split[1]) * 1024);
            bufferedReader.close();
            return parseInt;
        } catch (Exception e) {
            b.i("Matrix.DeviceUtil", "[getTotalMemory] error! %s", e.toString());
            return 0;
        }
    }

    private static int tI() {
        if (VERSION.SDK_INT <= 10) {
            return 1;
        }
        int cc;
        try {
            cc = cc("/sys/devices/system/cpu/possible");
            if (cc == 0) {
                cc = cc("/sys/devices/system/cpu/present");
            }
            if (cc == 0) {
                cc = new File("/sys/devices/system/cpu/").listFiles(acg).length;
            }
        } catch (Exception e) {
            cc = 0;
        }
        if (cc == 0) {
            cc = 1;
        }
        return cc;
    }

    private static int cc(String str) {
        IOException e;
        Throwable th;
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                if (readLine == null || !readLine.matches("0-[\\d]+$")) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        b.i("Matrix.DeviceUtil", "[getCoresFromFile] error! %s", e2.toString());
                    }
                    return 0;
                }
                int parseInt = Integer.parseInt(readLine.substring(2)) + 1;
                try {
                    fileInputStream.close();
                    return parseInt;
                } catch (IOException e3) {
                    b.i("Matrix.DeviceUtil", "[getCoresFromFile] error! %s", e3.toString());
                    return parseInt;
                }
            } catch (IOException e4) {
                e2 = e4;
                try {
                    b.i("Matrix.DeviceUtil", "[getCoresFromFile] error! %s", e2.toString());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e22) {
                            b.i("Matrix.DeviceUtil", "[getCoresFromFile] error! %s", e22.toString());
                        }
                    }
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e32) {
                            b.i("Matrix.DeviceUtil", "[getCoresFromFile] error! %s", e32.toString());
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e22 = e5;
            fileInputStream = null;
            b.i("Matrix.DeviceUtil", "[getCoresFromFile] error! %s", e22.toString());
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e222) {
                    b.i("Matrix.DeviceUtil", "[getCoresFromFile] error! %s", e222.toString());
                }
            }
            return 0;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e322) {
                    b.i("Matrix.DeviceUtil", "[getCoresFromFile] error! %s", e322.toString());
                }
            }
            throw th;
        }
    }
}
