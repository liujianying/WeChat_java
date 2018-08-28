package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class e {
    private static boolean jgw = false;

    public static String getUserId() {
        return ac.ce(ac.ce(com.tencent.mm.wallet_core.ui.e.getUsername()) + ac.ce(q.zz()));
    }

    public static String aNu() {
        return h.bFk();
    }

    public static void aNv() {
        g.Ek();
        g.Ei().DT().a(a.sQm, Boolean.valueOf(true));
    }

    public static boolean aNw() {
        g.Ek();
        Object obj = g.Ei().DT().get(a.sQm, Boolean.valueOf(false));
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static void aNx() {
        g.Ek();
        g.Ei().DT().a(a.sQn, Boolean.valueOf(true));
    }

    public static void fa(boolean z) {
        g.Ek();
        g.Ei().DT().a(a.sQp, Boolean.valueOf(z));
    }

    public static boolean aNy() {
        g.Ek();
        Object obj = g.Ei().DT().get(a.sQp, Boolean.FALSE);
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static void fb(boolean z) {
        g.Ek();
        g.Ei().DT().a(a.sQq, Boolean.valueOf(z));
    }

    public static boolean aNz() {
        g.Ek();
        Object obj = g.Ei().DT().get(a.sQq, Boolean.valueOf(false));
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static void fc(boolean z) {
        jgw = z;
    }

    public static boolean aNA() {
        return jgw;
    }

    public static boolean aNm() {
        return c.aNd() && aNz() && jgw;
    }

    public static boolean aNB() {
        x.i("MicroMsg.FingerPrintUtil", "isShowFPOpenGuide");
        if (aNy()) {
            x.e("MicroMsg.FingerPrintUtil", "the fingerprint is open ready");
            return false;
        } else if (!c.aNd()) {
            x.e("MicroMsg.FingerPrintUtil", "device is not support");
            return false;
        } else if (o.bOW().bPp() || o.bOW().bPt()) {
            x.e("MicroMsg.FingerPrintUtil", "user had not reg wxpay");
            return false;
        } else if (o.bOW().bPw().bPl()) {
            com.tencent.mm.plugin.fingerprint.a.aMW();
            com.tencent.mm.plugin.fingerprint.a.aMX();
            if (!c.aNf() || aNw()) {
                return false;
            }
            x.i("MicroMsg.FingerPrintUtil", "will showOpenFingerPrintPayGuide()");
            return true;
        } else {
            x.e("MicroMsg.FingerPrintUtil", "isSupportTouchPay is false");
            return false;
        }
    }

    public static boolean aNC() {
        x.i("MicroMsg.FingerPrintUtil", "isShowFPSettingGuide");
        if (aNy()) {
            x.e("MicroMsg.FingerPrintUtil", "the fingerprint is open ready");
            return false;
        } else if (!c.aNd()) {
            x.e("MicroMsg.FingerPrintUtil", "device is not support");
            return false;
        } else if (o.bOW().bPp() || o.bOW().bPt()) {
            x.e("MicroMsg.FingerPrintUtil", "user had not reg wxpay");
            return false;
        } else if (o.bOW().bPw().bPl()) {
            c cVar = new c();
            if (!c.aNf()) {
                boolean booleanValue;
                g.Ek();
                Object obj = g.Ei().DT().get(a.sQn, Boolean.valueOf(false));
                if (obj != null) {
                    booleanValue = ((Boolean) obj).booleanValue();
                } else {
                    booleanValue = false;
                }
                if (!booleanValue) {
                    x.i("MicroMsg.FingerPrintUtil", "will call showSetFingerPrintGuide()");
                    return true;
                }
            }
            return false;
        } else {
            x.e("MicroMsg.FingerPrintUtil", "isSupportTouchPay is false");
            return false;
        }
    }

    public static final String dk(Context context) {
        return context.getApplicationContext().getFilesDir().getAbsolutePath() + "/b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec";
    }

    public static int dl(Context context) {
        CharSequence m;
        InputStream open;
        Throwable e;
        Throwable th;
        int i;
        FileOutputStream fileOutputStream = null;
        String dk = dk(context);
        File file = new File(dk);
        if (file.exists()) {
            m = com.tencent.mm.a.g.m(file);
            CharSequence charSequence = "";
            try {
                open = context.getAssets().open("b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec");
                if (open != null) {
                    try {
                        charSequence = com.tencent.mm.a.g.b(open, 1024);
                    } catch (IOException e2) {
                        e = e2;
                    }
                }
                if (open != null) {
                    try {
                        open.close();
                    } catch (Throwable e3) {
                        x.printErrStackTrace("MicroMsg.FingerPrintUtil", e3, "", new Object[0]);
                    }
                }
            } catch (IOException e4) {
                e3 = e4;
                open = null;
            } catch (Throwable th2) {
                th = th2;
                open = null;
                if (open != null) {
                    try {
                        open.close();
                    } catch (Throwable e5) {
                        x.printErrStackTrace("MicroMsg.FingerPrintUtil", e5, "", new Object[0]);
                    }
                }
                throw th;
            }
            if (TextUtils.isEmpty(m) && !TextUtils.isEmpty(charSequence) && m.equals(charSequence)) {
                i = 0;
            } else if (TextUtils.isEmpty(m) && TextUtils.isEmpty(charSequence)) {
                i = 0;
            } else {
                i = 1;
            }
        } else {
            i = 1;
            open = null;
        }
        if (i != 0) {
            return 0;
        }
        InputStream open2;
        try {
            open2 = context.getAssets().open("b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec");
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = open2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    }
                    fileOutputStream2.flush();
                    if (open2 != null) {
                        try {
                            open2.close();
                        } catch (Throwable th3) {
                            x.printErrStackTrace("MicroMsg.FingerPrintUtil", th3, "", new Object[0]);
                            x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + th3.getMessage());
                        }
                    }
                    try {
                        fileOutputStream2.close();
                        i = 0;
                    } catch (Throwable th32) {
                        x.printErrStackTrace("MicroMsg.FingerPrintUtil", th32, "", new Object[0]);
                        x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + th32.getMessage());
                        i = 0;
                    }
                } catch (Exception e6) {
                    th32 = e6;
                    fileOutputStream = fileOutputStream2;
                    try {
                        x.printErrStackTrace("MicroMsg.FingerPrintUtil", th32, "", new Object[0]);
                        x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets Exception " + th32.getMessage());
                        if (open2 != null) {
                            try {
                                open2.close();
                            } catch (Throwable th322) {
                                x.printErrStackTrace("MicroMsg.FingerPrintUtil", th322, "", new Object[0]);
                                x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + th322.getMessage());
                            }
                        }
                        if (fileOutputStream == null) {
                            i = -1;
                        } else {
                            try {
                                fileOutputStream.close();
                                i = -1;
                            } catch (Throwable th3222) {
                                x.printErrStackTrace("MicroMsg.FingerPrintUtil", th3222, "", new Object[0]);
                                x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + th3222.getMessage());
                                i = -1;
                            }
                        }
                        if (Runtime.getRuntime().exec("chmod 777 " + dk).waitFor() == 0) {
                            x.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                            return i;
                        }
                        x.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                        return i;
                    } catch (Throwable th4) {
                        th3222 = th4;
                        if (open2 != null) {
                            try {
                                open2.close();
                            } catch (Throwable e52) {
                                x.printErrStackTrace("MicroMsg.FingerPrintUtil", e52, "", new Object[0]);
                                x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + e52.getMessage());
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e522) {
                                x.printErrStackTrace("MicroMsg.FingerPrintUtil", e522, "", new Object[0]);
                                x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + e522.getMessage());
                            }
                        }
                        throw th3222;
                    }
                } catch (Throwable th5) {
                    th3222 = th5;
                    fileOutputStream = fileOutputStream2;
                    if (open2 != null) {
                        try {
                            open2.close();
                        } catch (Throwable e5222) {
                            x.printErrStackTrace("MicroMsg.FingerPrintUtil", e5222, "", new Object[0]);
                            x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + e5222.getMessage());
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e52222) {
                            x.printErrStackTrace("MicroMsg.FingerPrintUtil", e52222, "", new Object[0]);
                            x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + e52222.getMessage());
                        }
                    }
                    throw th3222;
                }
            } catch (Exception e7) {
                th3222 = e7;
                x.printErrStackTrace("MicroMsg.FingerPrintUtil", th3222, "", new Object[0]);
                x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets Exception " + th3222.getMessage());
                if (open2 != null) {
                    try {
                        open2.close();
                    } catch (Throwable th32222) {
                        x.printErrStackTrace("MicroMsg.FingerPrintUtil", th32222, "", new Object[0]);
                        x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + th32222.getMessage());
                    }
                }
                if (fileOutputStream == null) {
                    try {
                        fileOutputStream.close();
                        i = -1;
                    } catch (Throwable th322222) {
                        x.printErrStackTrace("MicroMsg.FingerPrintUtil", th322222, "", new Object[0]);
                        x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + th322222.getMessage());
                        i = -1;
                    }
                } else {
                    i = -1;
                }
                if (Runtime.getRuntime().exec("chmod 777 " + dk).waitFor() == 0) {
                    x.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                    return i;
                }
                x.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                return i;
            }
        } catch (Exception e8) {
            th322222 = e8;
            open2 = open;
        } catch (Throwable th6) {
            th322222 = th6;
            open2 = open;
            if (open2 != null) {
                try {
                    open2.close();
                } catch (Throwable e522222) {
                    x.printErrStackTrace("MicroMsg.FingerPrintUtil", e522222, "", new Object[0]);
                    x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + e522222.getMessage());
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable e5222222) {
                    x.printErrStackTrace("MicroMsg.FingerPrintUtil", e5222222, "", new Object[0]);
                    x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + e5222222.getMessage());
                }
            }
            throw th322222;
        }
        try {
            if (Runtime.getRuntime().exec("chmod 777 " + dk).waitFor() == 0) {
                x.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                return i;
            }
            x.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
            return i;
        } catch (Exception e9) {
            x.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file Exception " + e9.getMessage());
            return i;
        }
        try {
            x.printErrStackTrace("MicroMsg.FingerPrintUtil", e3, "", new Object[0]);
            if (open != null) {
                try {
                    open.close();
                } catch (Throwable e32) {
                    x.printErrStackTrace("MicroMsg.FingerPrintUtil", e32, "", new Object[0]);
                }
            }
            if (TextUtils.isEmpty(m)) {
            }
            if (TextUtils.isEmpty(m)) {
            }
            i = 1;
            if (i != 0) {
                return 0;
            }
            InputStream open22;
            try {
                open22 = context.getAssets().open("b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec");
                try {
                    FileOutputStream fileOutputStream22 = new FileOutputStream(file);
                    try {
                        byte[] bArr2 = new byte[1024];
                        while (true) {
                            int read2 = open22.read(bArr2);
                            if (read2 == -1) {
                                break;
                            }
                            fileOutputStream22.write(bArr2, 0, read2);
                        }
                        fileOutputStream22.flush();
                        if (open22 != null) {
                            try {
                                open22.close();
                            } catch (Throwable th3222222) {
                                x.printErrStackTrace("MicroMsg.FingerPrintUtil", th3222222, "", new Object[0]);
                                x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + th3222222.getMessage());
                            }
                        }
                        try {
                            fileOutputStream22.close();
                            i = 0;
                        } catch (Throwable th32222222) {
                            x.printErrStackTrace("MicroMsg.FingerPrintUtil", th32222222, "", new Object[0]);
                            x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + th32222222.getMessage());
                            i = 0;
                        }
                    } catch (Exception e62) {
                        th32222222 = e62;
                        fileOutputStream = fileOutputStream22;
                        try {
                            x.printErrStackTrace("MicroMsg.FingerPrintUtil", th32222222, "", new Object[0]);
                            x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets Exception " + th32222222.getMessage());
                            if (open22 != null) {
                                try {
                                    open22.close();
                                } catch (Throwable th322222222) {
                                    x.printErrStackTrace("MicroMsg.FingerPrintUtil", th322222222, "", new Object[0]);
                                    x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + th322222222.getMessage());
                                }
                            }
                            if (fileOutputStream == null) {
                                i = -1;
                            } else {
                                try {
                                    fileOutputStream.close();
                                    i = -1;
                                } catch (Throwable th3222222222) {
                                    x.printErrStackTrace("MicroMsg.FingerPrintUtil", th3222222222, "", new Object[0]);
                                    x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + th3222222222.getMessage());
                                    i = -1;
                                }
                            }
                            if (Runtime.getRuntime().exec("chmod 777 " + dk).waitFor() == 0) {
                                x.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                                return i;
                            }
                            x.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                            return i;
                        } catch (Throwable th42) {
                            th3222222222 = th42;
                            if (open22 != null) {
                                try {
                                    open22.close();
                                } catch (Throwable e52222222) {
                                    x.printErrStackTrace("MicroMsg.FingerPrintUtil", e52222222, "", new Object[0]);
                                    x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + e52222222.getMessage());
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable e522222222) {
                                    x.printErrStackTrace("MicroMsg.FingerPrintUtil", e522222222, "", new Object[0]);
                                    x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + e522222222.getMessage());
                                }
                            }
                            throw th3222222222;
                        }
                    } catch (Throwable th52) {
                        th3222222222 = th52;
                        fileOutputStream = fileOutputStream22;
                        if (open22 != null) {
                            try {
                                open22.close();
                            } catch (Throwable e5222222222) {
                                x.printErrStackTrace("MicroMsg.FingerPrintUtil", e5222222222, "", new Object[0]);
                                x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + e5222222222.getMessage());
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e52222222222) {
                                x.printErrStackTrace("MicroMsg.FingerPrintUtil", e52222222222, "", new Object[0]);
                                x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + e52222222222.getMessage());
                            }
                        }
                        throw th3222222222;
                    }
                } catch (Exception e72) {
                    th3222222222 = e72;
                    x.printErrStackTrace("MicroMsg.FingerPrintUtil", th3222222222, "", new Object[0]);
                    x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets Exception " + th3222222222.getMessage());
                    if (open22 != null) {
                        try {
                            open22.close();
                        } catch (Throwable th32222222222) {
                            x.printErrStackTrace("MicroMsg.FingerPrintUtil", th32222222222, "", new Object[0]);
                            x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + th32222222222.getMessage());
                        }
                    }
                    if (fileOutputStream == null) {
                        try {
                            fileOutputStream.close();
                            i = -1;
                        } catch (Throwable th322222222222) {
                            x.printErrStackTrace("MicroMsg.FingerPrintUtil", th322222222222, "", new Object[0]);
                            x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + th322222222222.getMessage());
                            i = -1;
                        }
                    } else {
                        i = -1;
                    }
                    if (Runtime.getRuntime().exec("chmod 777 " + dk).waitFor() == 0) {
                        x.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                        return i;
                    }
                    x.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                    return i;
                }
            } catch (Exception e82) {
                th322222222222 = e82;
                open22 = open;
            } catch (Throwable th62) {
                th322222222222 = th62;
                open22 = open;
                if (open22 != null) {
                    try {
                        open22.close();
                    } catch (Throwable e522222222222) {
                        x.printErrStackTrace("MicroMsg.FingerPrintUtil", e522222222222, "", new Object[0]);
                        x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + e522222222222.getMessage());
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e5222222222222) {
                        x.printErrStackTrace("MicroMsg.FingerPrintUtil", e5222222222222, "", new Object[0]);
                        x.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + e5222222222222.getMessage());
                    }
                }
                throw th322222222222;
            }
            try {
                if (Runtime.getRuntime().exec("chmod 777 " + dk).waitFor() == 0) {
                    x.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                    return i;
                }
                x.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                return i;
            } catch (Exception e92) {
                x.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file Exception " + e92.getMessage());
                return i;
            }
        } catch (Throwable th7) {
            th322222222222 = th7;
            if (open != null) {
                try {
                    open.close();
                } catch (Throwable e52222222222222) {
                    x.printErrStackTrace("MicroMsg.FingerPrintUtil", e52222222222222, "", new Object[0]);
                }
            }
            throw th322222222222;
        }
    }
}
