package com.tencent.mm.hardcoder;

import com.tencent.mm.hardcoder.d.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public final class e implements a {
    private static String dkY = null;
    private static Long dkZ = null;
    public static boolean dla = false;

    public final void a(int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, int i8, int[] iArr, int i9, int i10, int i11, int i12, int i13, long j2, int[] iArr2, int[] iArr3) {
        if (x.getLogLevel() <= 1 || HardCoderJNI.hcKVPerReport) {
            int i14;
            if (dkZ == null) {
                g.Ek();
                dkZ = (Long) g.Ei().DT().get(aa.a.sVO, Long.valueOf(0));
            }
            if (dkY == null) {
                dkY = bi.fP(ad.getContext());
            }
            String str = dkY;
            int longValue = (int) dkZ.longValue();
            StringBuilder stringBuilder = new StringBuilder();
            if (iArr != null) {
                for (int i15 : iArr) {
                    stringBuilder.append(i15 + "#");
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            if (iArr2 != null) {
                for (int i142 : iArr2) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    if (i142 < 0) {
                        i142 = 0;
                    }
                    stringBuilder2.append(stringBuilder3.append(i142).append("#").toString());
                }
            }
            StringBuilder stringBuilder4 = new StringBuilder();
            if (iArr3 != null) {
                for (int i1422 : iArr3) {
                    StringBuilder stringBuilder5 = new StringBuilder();
                    if (i1422 < 0) {
                        i1422 = 0;
                    }
                    stringBuilder4.append(stringBuilder5.append(i1422).append("#").toString());
                }
            }
            String format = String.format("[oneliang]performance report,imei:%s,threadId:%s,enable:%s, heavy:%s,speedUp:%s,engineStatus:%s,cancelInDelay:%s,scene:%s,action:%s,cpuLevel:%s,ioLevel:%s,bindCoreIds:%s,executeTime:%s,runtime:%s,threadJiffies:%s, phonePower:%s, phoneHZ:%s, processJiffies:%s,cpuLevelTimeArray:%s, ioLevelTimeArray:%s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(longValue), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Long.valueOf(j), Integer.valueOf(i7), Integer.valueOf(i8), stringBuilder.toString(), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Long.valueOf(j2), stringBuilder2.toString(), stringBuilder4.toString()});
            String format2 = String.format("time:%s,imei:%s,threadId:%s,enable:%s,heavy:%s,speedUp:%s,cancelInDelay:%s,scene:%s,action:%s,cpuLevel:%s,ioLevel:%s,bindCoreIds:%s,executeTime:%s,runtime:%s,threadJiffies:%s, phonePower:%s, phoneHZ:%s, processJiffies:%s,cpuLevelTimeArray:%s, ioLevelTimeArray:%s", new Object[]{Long.valueOf(System.currentTimeMillis()), str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(longValue), Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i6), Long.valueOf(j), Integer.valueOf(i7), Integer.valueOf(i8), stringBuilder.toString(), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Long.valueOf(j2), stringBuilder2.toString(), stringBuilder4.toString()});
            if (HardCoderJNI.hcDebug) {
                x.i("MicroMsg.HardCoderReporterImpl", format);
            }
            h hVar = h.mEJ;
            Object[] objArr = new Object[21];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(longValue);
            objArr[2] = Integer.valueOf(i3);
            objArr[3] = Integer.valueOf(i5);
            objArr[4] = Integer.valueOf(i6);
            objArr[5] = Long.valueOf(j);
            objArr[6] = Integer.valueOf(i7);
            objArr[7] = Integer.valueOf(i8);
            objArr[8] = stringBuilder.toString();
            if (i9 < 0) {
                i9 = 0;
            }
            objArr[9] = Integer.valueOf(i9);
            objArr[10] = Integer.valueOf(i10);
            objArr[11] = Integer.valueOf(i11);
            objArr[12] = Integer.valueOf(i12);
            objArr[13] = Integer.valueOf(i13);
            objArr[14] = Long.valueOf(j2);
            objArr[15] = stringBuilder2.toString();
            objArr[16] = stringBuilder4.toString();
            objArr[17] = "";
            objArr[18] = Integer.valueOf(0);
            objArr[19] = Integer.valueOf(i4);
            objArr[20] = Integer.valueOf(i2);
            hVar.h(14607, objArr);
            fy(format2);
        }
    }

    public final void a(int i, long j, int i2, int i3, int i4) {
        if (dkY == null) {
            dkY = bi.fP(ad.getContext());
        }
        String str = dkY;
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        String format = String.format("errorReport imei:%s,callbackType:%s,errorTimestamp:%s,errCode:%s,funcId:%s,dataType:%s", new Object[]{str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        String format2 = String.format("time:%s,imei:%s,callbackType:%s,errorTimestamp:%s,errCode:%s,funcId:%s,dataType:%s", new Object[]{Long.valueOf(System.currentTimeMillis()), str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        x.i("MicroMsg.HardCoderReporterImpl", format);
        h.mEJ.h(14610, new Object[]{str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        fy(format2);
    }

    public final void a(int i, long j, int i2, long j2, long j3) {
        if (dkZ == null) {
            g.Ek();
            dkZ = (Long) g.Ei().DT().get(aa.a.sVO, Long.valueOf(0));
        }
        if (dkY == null) {
            dkY = bi.fP(ad.getContext());
        }
        String str = dkY;
        int longValue = (int) dkZ.longValue();
        int i3 = HardCoderJNI.isHCEnable() ? 1 : 0;
        int isRunning = HardCoderJNI.isRunning();
        int i4 = HardCoderJNI.hcEnable ? 1 : 0;
        if (i2 == 1) {
            long j4 = (100 * j2) / j3;
            h.mEJ.h(15187, new Object[]{str, Integer.valueOf(longValue), Integer.valueOf(i3), Integer.valueOf(isRunning), Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i4)});
            x.i("MicroMsg.HardCoderReporterImpl", String.format("fpsReport imei:%s enable:%s, heavy:%s speedUp:%s, engineStatus:%s, scene:%s, action:%s, type:%s, totalDroppedFrames:%s, interval:%s, average:%s", new Object[]{str, Integer.valueOf(i4), Integer.valueOf(longValue), Integer.valueOf(i3), Integer.valueOf(isRunning), Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}));
        }
    }

    private static void fy(String str) {
        Exception e;
        Throwable th;
        if (dla) {
            StringBuilder stringBuilder = new StringBuilder();
            g.Ek();
            com.tencent.mm.a.e.d(new String[]{stringBuilder.append(g.Ei().dqo).append("/hcstat").toString()});
            File file = new File(r0, "data.txt");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e2) {
                    x.i("MicroMsg.HardCoderReporterImpl", "create new file exception:" + e2.getMessage());
                }
            }
            OutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    fileOutputStream.write((str + "\n").getBytes("UTF-8"));
                    fileOutputStream.flush();
                    try {
                        fileOutputStream.close();
                    } catch (Exception e22) {
                        x.i("MicroMsg.HardCoderReporterImpl", "close exception:" + e22.getMessage());
                    }
                } catch (Exception e3) {
                    e22 = e3;
                    try {
                        x.i("MicroMsg.HardCoderReporterImpl", "exception:" + e22.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e222) {
                                x.i("MicroMsg.HardCoderReporterImpl", "close exception:" + e222.getMessage());
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e4) {
                                x.i("MicroMsg.HardCoderReporterImpl", "close exception:" + e4.getMessage());
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e222 = e5;
                fileOutputStream = null;
                x.i("MicroMsg.HardCoderReporterImpl", "exception:" + e222.getMessage());
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e2222) {
                        x.i("MicroMsg.HardCoderReporterImpl", "close exception:" + e2222.getMessage());
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e42) {
                        x.i("MicroMsg.HardCoderReporterImpl", "close exception:" + e42.getMessage());
                    }
                }
                throw th;
            }
        }
    }

    public final void reportIDKey(boolean z, int i, int i2, boolean z2) {
        x.i("MicroMsg.HardCoderReporterImpl", "reportIDKey feature[%b] key[%d], value[%d]", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z2)});
        h.mEJ.a(z ? 678 : 679, (long) i, (long) i2, z2);
    }
}
