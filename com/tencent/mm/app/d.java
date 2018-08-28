package com.tencent.mm.app;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.mm.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.io.File;
import java.io.RandomAccessFile;

public final class d {
    private static final String byd = (aa.duN + "channel_history.cfg");

    public static void aT(Context context) {
        Throwable e;
        e.fq(context);
        try {
            a cD = a.cD(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir);
            if (!(cD == null || cD.bxh == null)) {
                x.i("MicroMsg.ChannelHistory", "apk external info not null");
                if (cD.bxh.bxk != 0) {
                    e.bxk = cD.bxh.bxk;
                    x.i("MicroMsg.ChannelHistory", "read channelId from apk external");
                }
            }
        } catch (NameNotFoundException e2) {
            x.e("MicroMsg.ChannelHistory", "NameNotFoundException");
        } catch (Exception e3) {
            x.e("MicroMsg.ChannelHistory", "Exception in initChannel, %s", new Object[]{e3.getMessage()});
        }
        x.i("MicroMsg.ChannelHistory", "now channel id = %d, proce name = %s", new Object[]{Integer.valueOf(e.bxk), ad.getProcessName()});
        if (!uO()) {
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(byd, "rw");
                try {
                    randomAccessFile.write(String.format("%d\n", new Object[]{Integer.valueOf(e.bxk)}).getBytes());
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e4) {
                        x.printErrStackTrace("MicroMsg.ChannelHistory", e4, "Close ChannelHistory History file failed.", new Object[]{""});
                    }
                } catch (Exception e5) {
                    e4 = e5;
                    try {
                        x.printErrStackTrace("MicroMsg.ChannelHistory", e4, "Open ChannelHistory History file failed.", new Object[]{""});
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e42) {
                                x.printErrStackTrace("MicroMsg.ChannelHistory", e42, "Close ChannelHistory History file failed.", new Object[]{""});
                            }
                        }
                    } catch (Throwable th) {
                        e42 = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e6) {
                                x.printErrStackTrace("MicroMsg.ChannelHistory", e6, "Close ChannelHistory History file failed.", new Object[]{""});
                            }
                        }
                        throw e42;
                    }
                }
            } catch (Exception e7) {
                e42 = e7;
                randomAccessFile = null;
                x.printErrStackTrace("MicroMsg.ChannelHistory", e42, "Open ChannelHistory History file failed.", new Object[]{""});
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e422) {
                        x.printErrStackTrace("MicroMsg.ChannelHistory", e422, "Close ChannelHistory History file failed.", new Object[]{""});
                    }
                }
            } catch (Throwable th2) {
                e422 = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e62) {
                        x.printErrStackTrace("MicroMsg.ChannelHistory", e62, "Close ChannelHistory History file failed.", new Object[]{""});
                    }
                }
                throw e422;
            }
        }
    }

    public static void uN() {
        Throwable e;
        if (uO()) {
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(byd, "rw");
                try {
                    long length = randomAccessFile.length();
                    x.i("MicroMsg.ChannelHistory", "correctChannleIdBySource fileLen:%d  curChannelId:%d", new Object[]{Long.valueOf(length), Integer.valueOf(e.bxk)});
                    if (length <= 0) {
                        x.w("MicroMsg.ChannelHistory", "channel history file fileLen <= 0");
                        try {
                            randomAccessFile.close();
                            return;
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.ChannelHistory", e2, "Close ChannelHistory History file failed.", new Object[]{""});
                            return;
                        }
                    }
                    String readLine = randomAccessFile.readLine();
                    int i = e.bxk;
                    int i2 = e.bxk;
                    e.sFz = e.bxk;
                    String str = "";
                    if (!bi.oW(readLine)) {
                        str = str + readLine + ",";
                        i2 = bi.getInt(readLine, 0);
                        if (i2 != e.bxk) {
                            e.sFz = i2;
                            x.i("MicroMsg.ChannelHistory", "real correct final channelid: " + e.bxk);
                        }
                    }
                    if (ad.sGA) {
                        while (true) {
                            readLine = randomAccessFile.readLine();
                            if (bi.oW(readLine)) {
                                break;
                            }
                            str = str + readLine + ",";
                            i2 = bi.getInt(readLine, 0);
                        }
                        x.i("MicroMsg.ChannelHistory", "channel list: %s", new Object[]{str});
                        if (i2 != i) {
                            randomAccessFile.seek(length);
                            randomAccessFile.write(String.format("%d\n", new Object[]{Integer.valueOf(i)}).getBytes());
                            x.i("MicroMsg.ChannelHistory", "channelid change from %d to %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
                        }
                    }
                    try {
                        randomAccessFile.close();
                        return;
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.ChannelHistory", e22, "Close ChannelHistory History file failed.", new Object[]{""});
                        return;
                    }
                } catch (Exception e3) {
                    e22 = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.ChannelHistory", e22, "Open ChannelHistory History file failed.", new Object[]{""});
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                                return;
                            } catch (Throwable e222) {
                                x.printErrStackTrace("MicroMsg.ChannelHistory", e222, "Close ChannelHistory History file failed.", new Object[]{""});
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        e222 = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e4) {
                                x.printErrStackTrace("MicroMsg.ChannelHistory", e4, "Close ChannelHistory History file failed.", new Object[]{""});
                            }
                        }
                        throw e222;
                    }
                }
            } catch (Exception e5) {
                e222 = e5;
                randomAccessFile = null;
                x.printErrStackTrace("MicroMsg.ChannelHistory", e222, "Open ChannelHistory History file failed.", new Object[]{""});
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                        return;
                    } catch (Throwable e2222) {
                        x.printErrStackTrace("MicroMsg.ChannelHistory", e2222, "Close ChannelHistory History file failed.", new Object[]{""});
                        return;
                    }
                }
                return;
            } catch (Throwable th2) {
                e2222 = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e42) {
                        x.printErrStackTrace("MicroMsg.ChannelHistory", e42, "Close ChannelHistory History file failed.", new Object[]{""});
                    }
                }
                throw e2222;
            }
        }
        x.w("MicroMsg.ChannelHistory", "channel history file does not exit!");
    }

    private static boolean uO() {
        return new File(byd).exists();
    }
}
