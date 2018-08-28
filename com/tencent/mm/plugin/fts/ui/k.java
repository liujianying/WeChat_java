package com.tencent.mm.plugin.fts.ui;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class k {
    public static void w(int i, long j) {
        x.v("MicroMsg.FTS.FTSReportLogic", "reportIDKey: type=%d time=%d", Integer.valueOf(i), Long.valueOf(j));
        switch (i) {
            case 0:
            case 3:
            case 6:
            case 9:
            case 12:
                IDKey iDKey = new IDKey();
                iDKey.SetID(79);
                iDKey.SetKey(i + 1);
                iDKey.SetValue((long) ((int) j));
                IDKey iDKey2 = new IDKey();
                iDKey2.SetID(79);
                iDKey2.SetKey(i + 2);
                iDKey2.SetValue(1);
                ArrayList arrayList = new ArrayList();
                arrayList.add(iDKey);
                arrayList.add(iDKey2);
                h.mEJ.b(arrayList, false);
                return;
            default:
                return;
        }
    }

    public static void c(String str, boolean z, int i, int i2) {
        a(str, z, i, i2, new b());
    }

    public static void a(String str, boolean z, int i, int i2, b bVar) {
        int i3;
        String format;
        switch (i2) {
            case -15:
            case -5:
            case -4:
            case -3:
            case -2:
            case -1:
                i3 = 2;
                break;
            case 0:
                i3 = 1;
                break;
            default:
                i3 = 0;
                break;
        }
        if (z) {
            format = String.format("%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{str, Integer.valueOf(3), Integer.valueOf(i3), Integer.valueOf(bVar.jza), Integer.valueOf(bVar.jzd), Integer.valueOf(bVar.jzk), Integer.valueOf(bVar.jzh), Integer.valueOf(bVar.jzi)});
        } else if (i > 0) {
            format = String.format("%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{str, Integer.valueOf(2), Integer.valueOf(i3), Integer.valueOf(bVar.jza), Integer.valueOf(bVar.jzd), Integer.valueOf(bVar.jzk), Integer.valueOf(bVar.jzh), Integer.valueOf(bVar.jzi)});
        } else {
            format = String.format("%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{str, Integer.valueOf(1), Integer.valueOf(i3), Integer.valueOf(bVar.jza), Integer.valueOf(bVar.jzd), Integer.valueOf(bVar.jzk), Integer.valueOf(bVar.jzh), Integer.valueOf(bVar.jzi)});
        }
        x.i("MicroMsg.FTS.FTSReportLogic", "reportKvQuery %d %s", Integer.valueOf(11062), format);
        h.mEJ.k(11062, format);
    }

    public static void a(a aVar, b bVar) {
        int i;
        String str;
        int i2 = 1;
        int i3 = aVar.jtl;
        int i4 = aVar.jtm;
        String str2 = aVar.jtn;
        long j = aVar.jto;
        String afE = aVar.afE();
        int i5 = i(aVar.jtq, aVar.jtr, aVar.aQi());
        if (aVar.jtk == -8) {
            i = 2;
            int i6 = 0;
            switch (aVar.hER) {
                case 1:
                    i6 = 3;
                    break;
                case 2:
                    i6 = 4;
                    break;
                case 3:
                    i6 = 10;
                    break;
                case 4:
                    i6 = 5;
                    break;
            }
            str = i6 + "$" + afE;
        } else {
            switch (aVar.hER) {
                case 1:
                    i = 3;
                    str = afE;
                    break;
                case 2:
                    i = 4;
                    str = afE;
                    break;
                case 3:
                    i = 10;
                    str = afE;
                    break;
                case 4:
                    i = 5;
                    str = afE;
                    break;
                case 5:
                    i = 16;
                    str = afE;
                    break;
                case 6:
                    i = 11;
                    str = afE;
                    break;
                case 7:
                    i = 12;
                    str = afE;
                    break;
                case 8:
                    i = 13;
                    str = afE;
                    break;
                case 9:
                    i = 14;
                    str = afE;
                    break;
                case 10:
                    if (!aVar.jtp) {
                        i = 9;
                        str = afE;
                        break;
                    }
                    i = 8;
                    str = afE;
                    break;
                case 12:
                    i2 = 2;
                    if (aVar.jtk == -5) {
                        i = 16;
                        str = afE;
                        break;
                    } else if (aVar.jtk == -3) {
                        i = 4;
                        str = afE;
                        break;
                    } else if (aVar.jtk == -4) {
                        i = 3;
                        str = afE;
                        break;
                    } else if (aVar.jtk == -1) {
                        i = 12;
                        str = afE;
                        break;
                    } else if (aVar.jtk == -2) {
                        i = 11;
                        str = afE;
                        break;
                    } else if (aVar.jtk == -15) {
                        i = 21;
                        str = afE;
                        break;
                    } else if (aVar.jtk == -6) {
                        i = 10;
                        str = afE;
                        break;
                    } else if (aVar.jtk == -13) {
                        i = 19;
                        str = afE;
                        break;
                    } else if (aVar.jtk == -7) {
                        i = 5;
                        str = afE;
                        break;
                    } else {
                        return;
                    }
                case 13:
                    i = 17;
                    str = afE;
                    break;
                case 14:
                    i = 15;
                    str = afE;
                    break;
                case 16:
                    i = 19;
                    d dVar = new d();
                    str = aVar.jrx.jrV;
                    if (str != null) {
                        str = str.replaceAll(",", " ");
                    }
                    dVar.r("20KeyWordId", str + ",");
                    dVar.r("21ViewType", "1,");
                    dVar.r("22OpType", "2,");
                    dVar.r("23ResultCount", ",");
                    dVar.r("24ClickPos", aVar.jtm + ",");
                    dVar.r("25ClickAppUserName", aVar.info + ",");
                    x.i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", dVar.wF());
                    h.mEJ.h(13963, dVar);
                    str = afE;
                    break;
                case 17:
                    i = 20;
                    str = afE;
                    break;
                case 19:
                    i = 22;
                    str = afE;
                    break;
                case 20:
                    i = 21;
                    str = afE;
                    break;
                default:
                    return;
            }
        }
        long currentTimeMillis = System.currentTimeMillis() - bVar.jyY;
        if (currentTimeMillis < 0 || bVar.jyY == 0) {
            currentTimeMillis = 0;
        }
        x.v("MicroMsg.FTS.FTSReportLogic", "report home page click: %d, %s", Integer.valueOf(10991), String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(aVar.jsZ), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i4), bi.aG(str2, ""), Long.valueOf(j), Integer.valueOf(i5), Integer.valueOf(0), Integer.valueOf(aVar.afF()), Integer.valueOf(ql(aVar.aQh())), str, Long.valueOf(currentTimeMillis), Integer.valueOf(bVar.jzb), Integer.valueOf(bVar.jzc), Integer.valueOf(bVar.jzd), Integer.valueOf(bVar.jze), Integer.valueOf(bVar.jzf), Integer.valueOf(bVar.jzg), Integer.valueOf(bVar.jzh), Integer.valueOf(bVar.jzj), Integer.valueOf(bVar.jzk), e.jqM, aVar.jrx.jrV, Integer.valueOf(bVar.jzi), Integer.valueOf(bVar.jzl)}));
        x.i("MicroMsg.FTS.FTSReportLogic", "lxl, click blockpos:" + bVar.jzl);
        h.mEJ.k(10991, str);
    }

    private static int i(int i, int i2, boolean z) {
        if (z) {
            return 15;
        }
        if (i == 131072) {
            switch (i2) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 7:
                    return 7;
                case 11:
                    return 8;
                case 15:
                    return 16;
                case 16:
                    return 10;
                case 17:
                case 18:
                    return 9;
                default:
                    return 0;
            }
        } else if (i == 131075) {
            switch (i2) {
                case 1:
                case 5:
                    return 12;
                case 2:
                case 6:
                    return 13;
                case 3:
                case 7:
                    return 14;
                case 29:
                case 30:
                case 31:
                case 32:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                    return 11;
                default:
                    return 0;
            }
        } else if (i == 131081) {
            return 19;
        } else {
            if (i == 65536) {
                return 17;
            }
            return 0;
        }
    }

    private static int ql(int i) {
        switch (i) {
            case 29:
                return 1;
            case 30:
                return 2;
            case 31:
                return 3;
            case 32:
                return 4;
            case 34:
                return 5;
            case 35:
            case 36:
                return 6;
            case 37:
                return 16;
            default:
                return 0;
        }
    }

    public static void a(a aVar, com.tencent.mm.plugin.fts.ui.c.a aVar2) {
        int i;
        String str;
        int i2 = aVar.jtl;
        String str2 = aVar.jtn;
        long j = aVar.jto;
        int i3 = i(aVar.jtq, aVar.jtr, aVar.aQi());
        switch (aVar.hER) {
            case 1:
                i = 3;
                break;
            case 2:
                i = 4;
                break;
            case 3:
                i = 10;
                break;
            case 4:
                i = 5;
                break;
            case 5:
                i = 16;
                break;
            case 6:
                i = 11;
                break;
            case 7:
                i = 12;
                break;
            case 8:
                i = 13;
                break;
            case 9:
                i = 14;
                break;
            case 13:
                i = 17;
                break;
            case 14:
                i = 15;
                break;
            case 16:
                d dVar = new d();
                str = aVar.jrx.jrV;
                if (str != null) {
                    str = str.replaceAll(",", " ");
                }
                dVar.r("20KeyWordId", str + ",");
                dVar.r("21ViewType", "2,");
                dVar.r("22OpType", "2,");
                dVar.r("23ResultCount", ",");
                dVar.r("24ClickPos", aVar.jtm + ",");
                dVar.r("25ClickAppUserName", aVar.info + ",");
                x.i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", dVar.wF());
                h.mEJ.h(13963, dVar);
                i = 19;
                break;
            case 17:
                i = 20;
                break;
            case 20:
                i = 21;
                break;
            default:
                return;
        }
        long currentTimeMillis = System.currentTimeMillis() - aVar2.jyY;
        if (currentTimeMillis < 0 || aVar2.jyY == 0) {
            currentTimeMillis = 0;
        }
        x.d("MicroMsg.FTS.FTSReportLogic", "report detail page click: %s", String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(aVar.jsZ), Integer.valueOf(i), Integer.valueOf(i2), bi.aG(str2, ""), Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(aVar.afF()), Integer.valueOf(ql(aVar.aQh())), aVar.afE(), Long.valueOf(currentTimeMillis), Integer.valueOf(aVar2.jyZ)}));
        h.mEJ.k(11310, str);
    }

    public static final void fh(boolean z) {
        int i;
        int i2 = 1;
        String str = "MicroMsg.FTS.FTSReportLogic";
        String str2 = "reportFTSCreateChatroom: %d %d";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(13970);
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[1] = Integer.valueOf(i);
        x.v(str, str2, objArr);
        h hVar = h.mEJ;
        Object[] objArr2 = new Object[1];
        if (!z) {
            i2 = 0;
        }
        objArr2[0] = Integer.valueOf(i2);
        hVar.h(13970, objArr2);
    }
}
