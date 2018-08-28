package com.tencent.mm.modelstat;

import android.content.Intent;
import android.os.Looper;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.mars.xlog.Xlog;
import com.tencent.mm.a.e;
import com.tencent.mm.ab.d;
import com.tencent.mm.ab.d.b;
import com.tencent.mm.bv.c;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.network.a.b.a;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.io.File;
import java.util.Map;

public final class l extends a implements d {
    public static long a(File file, long j) {
        long j2 = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                long a;
                if (listFiles[i].isDirectory()) {
                    a = a(listFiles[i], j);
                } else {
                    if (listFiles[i].length() > j) {
                        x.i("MicroMsg.NetStatMsgExtension", "getFolderSize filesize:%s [%s]", new Object[]{Long.valueOf(listFiles[i].length()), listFiles[i].getPath()});
                    }
                    a = listFiles[i].length();
                }
                j2 += a;
            }
        } catch (Throwable e) {
            x.e("MicroMsg.NetStatMsgExtension", "getFolderSize :%s", new Object[]{bi.i(e)});
        }
        return j2;
    }

    public final b b(d.a aVar) {
        if (g.Eg().Dx()) {
            String str = aVar.dIN.rcl.siM;
            x.d("MicroMsg.NetStatMsgExtension", "onPreAddMessage %s", new Object[]{str});
            if (!bi.oW(str)) {
                x.i("MicroMsg.NetStatMsgExtension", "get ipxx cmd=%s", new Object[]{str});
                Map z = bl.z(str, "cmd");
                String str2;
                if (z == null) {
                    Map z2 = bl.z(str, "ClearCache");
                    if (z2 != null) {
                        long j = bi.getLong((String) z2.get(".ClearCache.androidCacheMask"), 0);
                        str2 = (String) z2.get(".ClearCache.message");
                        Intent intent = new Intent();
                        intent.putExtra("key_mask", j);
                        intent.putExtra("key_message", str2);
                        com.tencent.mm.bg.d.e(ad.getContext(), ".ui.ClearCacheUI", intent);
                    }
                } else {
                    int i = bi.getInt((String) z.get(".cmd.trace.$code"), -1);
                    if (i <= 0) {
                        int i2 = bi.getInt((String) z.get(".cmd.hprof.$type"), -1);
                        if (i2 > 0) {
                            x.d("MicroMsg.NetStatMsgExtension", "hprof type: %d", new Object[]{Integer.valueOf(i2)});
                            c.DC(i2);
                        } else {
                            if ("android".equalsIgnoreCase((String) z.get(".cmd.hotpatch.$os"))) {
                                ig igVar = new ig();
                                igVar.bRH.bRI = (String) z.get(".cmd.hotpatch.xml.$url");
                                igVar.bRH.bRJ = (String) z.get(".cmd.hotpatch.xml.$signature");
                                igVar.bRH.bRK = (String) z.get(".cmd.hotpatch.$url");
                                igVar.bRH.bRL = (String) z.get(".cmd.hotpatch.$signature");
                                com.tencent.mm.sdk.b.a.sFg.a(igVar, Looper.myLooper());
                            } else {
                                i2 = bi.getInt((String) z.get(".cmd.clearfile.$fb"), -1);
                                if (i2 == 1) {
                                    g.Em().H(new 1(this, (long) bi.getInt((String) z.get(".cmd.clearfile.$ps"), 1048576)));
                                } else if (i2 == 2) {
                                    long length;
                                    str2 = (String) z.get(".cmd.clearfile.$pd");
                                    File file = new File(str2);
                                    String str3 = "MicroMsg.NetStatMsgExtension";
                                    String str4 = "clearfile delete :[%s] length:%s";
                                    Object[] objArr = new Object[2];
                                    objArr[0] = str2;
                                    objArr[1] = Long.valueOf(file.exists() ? file.length() : -1);
                                    x.i(str3, str4, objArr);
                                    e.deleteFile(str2);
                                    file = new File(str2);
                                    String str5 = "MicroMsg.NetStatMsgExtension";
                                    String str6 = "clearfile delete finish :[%s] length:%s";
                                    Object[] objArr2 = new Object[2];
                                    objArr2[0] = str2;
                                    if (file.exists()) {
                                        length = file.length();
                                    } else {
                                        length = -1;
                                    }
                                    objArr2[1] = Long.valueOf(length);
                                    x.i(str5, str6, objArr2);
                                } else if (i2 == 3) {
                                    x.i("MicroMsg.NetStatMsgExtension", "running  clearfile start:" + g.Ei().DQ() + ".tem");
                                    e.deleteFile(g.Ei().DQ() + ".tem");
                                    e.deleteFile(g.Ei().DR() + ".tem");
                                    x.i("MicroMsg.NetStatMsgExtension", "running  clearfile end:" + g.Ei().DQ() + ".tem");
                                }
                                final int i3 = bi.getInt((String) z.get(".cmd.updzh.$pt"), -1);
                                str2 = (String) z.get(".cmd.updzh.$pd");
                                x.d("MicroMsg.NetStatMsgExtension", "StackReportUploader pt:%d pd:%s", new Object[]{Integer.valueOf(i3), str2});
                                if (i3 > 0 && !bi.oW(str2)) {
                                    g.Em().H(new Runnable() {
                                        public final void run() {
                                            switch (i3) {
                                                case 1:
                                                    ae.a(g.Ei().dqp + str2, q.GF(), false, true);
                                                    return;
                                                case 2:
                                                    ae.a(g.Ei().cachePath + str2, q.GF(), false, true);
                                                    return;
                                                case 3:
                                                    ae.a(str2, q.GF(), false, true);
                                                    return;
                                                default:
                                                    return;
                                            }
                                        }

                                        public final String toString() {
                                            return super.toString() + "|onPreAddMessage";
                                        }
                                    });
                                }
                            }
                        }
                    } else if (i == 6) {
                        com.tencent.mm.sdk.b.a.sFg.m(new sn());
                    } else {
                        com.tencent.mm.bv.d.cov().c(new com.tencent.mm.bv.d.a((String) z.get(".cmd.trace.$class"), i, bi.getInt((String) z.get(".cmd.trace.$size"), 0), bi.getInt((String) z.get(".cmd.trace.$type"), 0)));
                    }
                }
                x.chR();
                g.DF().dJs.kg(str);
                try {
                    Thread.sleep(50, 0);
                } catch (Exception e) {
                }
                LogLogic.initIPxxLogInfo();
                MMProtocalJni.setProtocalJniLogLevel(new Xlog().getLogLevel());
            }
        } else {
            x.e("MicroMsg.NetStatMsgExtension", "skip ipxx stat while account not set");
        }
        return null;
    }

    public final void a(int i, int i2, String str, int i3, String str2, boolean z) {
        g.Em().h(new 3(this, i, i2, str, i3, str2, z), 3000);
    }

    public final void k(int i, int i2, int i3, int i4) {
        if (!g.Eg().Dx()) {
            return;
        }
        if (g.Ek().dqL.drf) {
            x.i("MicroMsg.NetStatMsgExtension", "reportNetFlow wifi[%d, %d] mobile[%d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            if (i <= 0) {
                i = 0;
            }
            if (i2 <= 0) {
                i2 = 0;
            }
            n.z(i, i2, 0);
            if (i3 <= 0) {
                i3 = 0;
            }
            if (i4 <= 0) {
                i4 = 0;
            }
            n.A(i3, i4, 0);
            return;
        }
        x.i("MicroMsg.NetStatMsgExtension", "kernel has not startup");
    }

    public static void b(int i, int i2, int i3, boolean z) {
        if (g.Eg().Dx()) {
            switch (i) {
                case 4:
                    x.d("MicroMsg.NetStatMsgExtension", "recv bytes flow:" + i3);
                    if (z) {
                        n.z(i3, 0, i2);
                        return;
                    } else {
                        n.A(i3, 0, i2);
                        return;
                    }
                case 5:
                    x.d("MicroMsg.NetStatMsgExtension", "send bytes flow:" + i3);
                    if (z) {
                        n.z(0, i3, i2);
                        return;
                    } else {
                        n.A(0, i3, i2);
                        return;
                    }
                case 8:
                    af.Wp("dns_failed_report");
                    return;
                default:
                    return;
            }
        }
    }

    public final void h(bd bdVar) {
    }
}
