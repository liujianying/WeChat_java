package com.tencent.c.d.b;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class d {
    public static List<a> cFh() {
        List arrayList = new ArrayList();
        String[] list = new File("/proc").list();
        if (list != null) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        char charAt = str.charAt(0);
                        if (charAt <= '9' && charAt >= '0') {
                            a Hn = Hn(Integer.parseInt(str));
                            if (Hn != null) {
                                arrayList.add(Hn);
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        return arrayList;
    }

    private static String Hm(int i) {
        try {
            String str = "";
            byte[] dB = a.dB(String.format(Locale.ENGLISH, "/proc/%d/cmdline", new Object[]{Integer.valueOf(i)}), 100);
            if (dB != null) {
                str = new String(dB, 0, a(dB, 0, 0));
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            dB = a.dB(String.format(Locale.ENGLISH, "/proc/%d/status", new Object[]{Integer.valueOf(i)}), 150);
            if (dB == null) {
                return str;
            }
            int a = a(dB, 7, 10);
            if (a == 0) {
                return "";
            }
            return new String(dB, 6, a - 6);
        } catch (Throwable th) {
            return "";
        }
    }

    private static int a(byte[] bArr, int i, char c) {
        int i2 = i - 1;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= bArr.length) {
                return 0;
            }
            if (i3 == bArr.length || bArr[i3] == c) {
                return i3;
            }
            i2 = i3;
        }
    }

    private static a Hn(int i) {
        String Hm;
        String trim;
        int a;
        try {
            Hm = Hm(i);
            int i2;
            try {
                int parseInt;
                byte[] dB = a.dB(String.format(Locale.ENGLISH, "/proc/%d/status", new Object[]{Integer.valueOf(i)}), 150);
                if (dB != null) {
                    a = a(dB, 7, 10);
                    if (a != 0) {
                        a = a(dB, a(dB, a(dB, a + 1, 10) + 1, 10) + 1, 10);
                        if (a != 0) {
                            i2 = a + 7;
                            int a2 = a(dB, a + 1, 10);
                            if (a2 != 0) {
                                a = Integer.parseInt(new String(dB, i2, a2 - i2));
                                try {
                                    i2 = a(dB, a2 + 1, 10);
                                    if (i2 != 0) {
                                        i2 += 6;
                                        parseInt = Integer.parseInt(new String(dB, i2, a(dB, i2 + 1, 9) - i2));
                                    } else {
                                        parseInt = -1;
                                    }
                                    i2 = parseInt;
                                } catch (Exception e) {
                                    i2 = -1;
                                    trim = new String(a.acq(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
                                    if (Hm != null) {
                                    }
                                    return null;
                                }
                                trim = new String(a.acq(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
                                if (Hm != null || a == -1 || i2 == -1) {
                                    return null;
                                }
                                return new a(i, a, Hm, i2, trim);
                            }
                        }
                    }
                }
                parseInt = -1;
                a = -1;
                i2 = parseInt;
            } catch (Exception e2) {
                a = -1;
                i2 = -1;
                trim = new String(a.acq(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
                if (Hm != null) {
                }
                return null;
            }
        } catch (Exception e3) {
            a = -1;
            Hm = null;
        }
        try {
            trim = new String(a.acq(String.format(Locale.ENGLISH, "/proc/%d/attr/current", new Object[]{Integer.valueOf(i)}))).trim();
        } catch (Exception e4) {
            trim = null;
        }
        if (Hm != null) {
        }
        return null;
    }
}
