package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.g.a.bc;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class b {
    private static String kPy = null;
    private static c<bc> kPz = new 1();

    static /* synthetic */ void V(String str, int i, int i2) {
        x.i("MicroMsg.LuckMoneyEffectResourceMgr", "start saveEffectResource %s %s %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        e.post(new 2(str, i, i2), "LuckMoneyEffectResourceMgr_saveEffectResource");
    }

    static /* synthetic */ void W(String str, int i, int i2) {
        try {
            long VG = bi.VG();
            x.i("MicroMsg.LuckMoneyEffectResourceMgr", "on saveEffectResource: %s %s %s %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), kPy + i2});
            dB(str, r2);
            x.i("MicroMsg.LuckMoneyEffectResourceMgr", "saveEffectResource used %s", new Object[]{Long.valueOf(bi.bI(VG))});
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.LuckMoneyEffectResourceMgr", e, "saveEffectResourceImpl error: %s", new Object[]{e.getMessage()});
        }
    }

    public static void init() {
        x.i("MicroMsg.LuckMoneyEffectResourceMgr", "init");
        if (kPy == null) {
            kPy = com.tencent.mm.loader.stub.b.bnE + "wallet/luckyMoneyEffect/";
        }
        com.tencent.mm.pluginsdk.g.a.a.b.c.ccr();
        com.tencent.mm.pluginsdk.g.a.a.b.BK(53);
        a.sFg.a(kPz);
    }

    public static void Wa() {
        x.i("MicroMsg.LuckMoneyEffectResourceMgr", "unInit");
        a.sFg.c(kPz);
    }

    private static boolean dB(String str, String str2) {
        Closeable closeable;
        Throwable e;
        Closeable closeable2 = null;
        try {
            OutputStream fileOutputStream;
            OutputStream bufferedOutputStream;
            File file = new File(str2);
            file.mkdirs();
            ZipFile zipFile = new ZipFile(new File(str), 1);
            Enumeration entries = zipFile.entries();
            closeable = null;
            while (entries.hasMoreElements()) {
                try {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    x.i("MicroMsg.LuckMoneyEffectResourceMgr", "zipEntry name: %s", new Object[]{zipEntry.getName()});
                    if (!(zipEntry.getName().contains("../") || zipEntry.getName().contains("..\\"))) {
                        File file2 = new File(file, zipEntry.getName());
                        file2.getParentFile().mkdirs();
                        if (zipEntry.isDirectory()) {
                            continue;
                        } else {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                            try {
                                byte[] bArr = new byte[4096];
                                try {
                                    fileOutputStream = new FileOutputStream(file2);
                                    try {
                                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 4096);
                                        while (true) {
                                            try {
                                                int read = bufferedInputStream.read(bArr, 0, 4096);
                                                if (read == -1) {
                                                    break;
                                                }
                                                bufferedOutputStream.write(bArr, 0, read);
                                            } catch (Exception e2) {
                                                e = e2;
                                                try {
                                                    x.printErrStackTrace("MicroMsg.LuckMoneyEffectResourceMgr", e, "", new Object[0]);
                                                    com.tencent.mm.a.e.closeOutputStream(fileOutputStream);
                                                    com.tencent.mm.a.e.closeOutputStream(bufferedOutputStream);
                                                    closeable = bufferedInputStream;
                                                } catch (Throwable th) {
                                                    e = th;
                                                }
                                            }
                                        }
                                        com.tencent.mm.a.e.closeOutputStream(fileOutputStream);
                                        com.tencent.mm.a.e.closeOutputStream(bufferedOutputStream);
                                        closeable = bufferedInputStream;
                                    } catch (Exception e3) {
                                        e = e3;
                                        bufferedOutputStream = null;
                                        x.printErrStackTrace("MicroMsg.LuckMoneyEffectResourceMgr", e, "", new Object[0]);
                                        com.tencent.mm.a.e.closeOutputStream(fileOutputStream);
                                        com.tencent.mm.a.e.closeOutputStream(bufferedOutputStream);
                                        closeable = bufferedInputStream;
                                    } catch (Throwable th2) {
                                        e = th2;
                                        bufferedOutputStream = null;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    bufferedOutputStream = null;
                                    fileOutputStream = null;
                                    x.printErrStackTrace("MicroMsg.LuckMoneyEffectResourceMgr", e, "", new Object[0]);
                                    com.tencent.mm.a.e.closeOutputStream(fileOutputStream);
                                    com.tencent.mm.a.e.closeOutputStream(bufferedOutputStream);
                                    closeable = bufferedInputStream;
                                } catch (Throwable th3) {
                                    e = th3;
                                    bufferedOutputStream = null;
                                    fileOutputStream = null;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                closeable2 = bufferedInputStream;
                            } catch (Throwable th4) {
                                e = th4;
                                Object obj = bufferedInputStream;
                            }
                        }
                    }
                } catch (Exception e6) {
                    e = e6;
                    closeable2 = closeable;
                    try {
                        x.printErrStackTrace("MicroMsg.LuckMoneyEffectResourceMgr", e, "", new Object[0]);
                        bi.d(closeable2);
                        return false;
                    } catch (Throwable th5) {
                        e = th5;
                        closeable = closeable2;
                        bi.d(closeable);
                        throw e;
                    }
                } catch (Throwable th6) {
                    e = th6;
                    bi.d(closeable);
                    throw e;
                }
            }
            bi.d(closeable);
            return true;
            com.tencent.mm.a.e.closeOutputStream(fileOutputStream);
            com.tencent.mm.a.e.closeOutputStream(bufferedOutputStream);
            throw e;
        } catch (Exception e7) {
            e = e7;
            x.printErrStackTrace("MicroMsg.LuckMoneyEffectResourceMgr", e, "", new Object[0]);
            bi.d(closeable2);
            return false;
        } catch (Throwable th7) {
            e = th7;
            closeable = null;
            bi.d(closeable);
            throw e;
        }
    }
}
