package com.tencent.mm.modelcontrol;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bd.b;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.bd;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class c implements ar {
    public static synchronized c NM() {
        c cVar;
        synchronized (c.class) {
            cVar = (c) p.v(c.class);
        }
        return cVar;
    }

    public static boolean o(bd bdVar) {
        if (bdVar == null) {
            x.w("MicroMsg.SubCoreAutoDownload", "this message is null, can not auto download.");
            return false;
        } else if (!bdVar.ckA()) {
            x.w("MicroMsg.SubCoreAutoDownload", "this message is not image, please tell cash.");
            return false;
        } else if (p(bdVar)) {
            return NN();
        } else {
            x.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download C2C image.");
            return false;
        }
    }

    public static boolean NN() {
        String value = ((a) g.l(a.class)).AT().getValue("C2CImgNotAutoDownloadTimeRange");
        x.i("MicroMsg.BusyTimeControlLogic", "C2CImgNotAutoDownloadTimeRange value: " + value);
        if (b.lz(value)) {
            x.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C image.");
            return false;
        }
        int i = bi.getInt(((a) g.l(a.class)).AT().getValue("ChatImgAutoDownload"), 1);
        if (i == 3) {
            x.i("MicroMsg.SubCoreAutoDownload", "settings is not auto download C2C image. ChatImgAutoDownload : " + i);
            return false;
        }
        Context context = ad.getContext();
        if (i == 2 && ao.isWifi(context)) {
            x.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
            return true;
        } else if (i == 1 && ao.isWifi(context)) {
            x.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
            return true;
        } else {
            long j = (long) bi.getInt(((a) g.l(a.class)).AT().getValue("ChatImgAutoDownloadMax"), 0);
            long a = bi.a((Long) g.Ei().DT().get(aa.a.sPH, null), 0);
            long WV = bi.WV((String) DateFormat.format("M", System.currentTimeMillis()));
            long a2 = bi.a((Long) g.Ei().DT().get(aa.a.sPI, null), 0);
            x.d("MicroMsg.SubCoreAutoDownload", "currentmonth " + WV + " month " + a2 + " maxcount " + j + " current " + a + " downloadMode: " + i);
            if (WV != a2) {
                x.i("MicroMsg.SubCoreAutoDownload", "update month %d ", new Object[]{Long.valueOf(WV)});
                g.Ei().DT().a(aa.a.sPH, Long.valueOf(0));
                g.Ei().DT().a(aa.a.sPI, Long.valueOf(WV));
                a2 = 0;
            } else {
                a2 = a;
            }
            if (a2 > j && j > 0) {
                x.i("MicroMsg.SubCoreAutoDownload", "this month had auto download " + a2 + " C2C image, can not auto download.");
                return false;
            } else if (i == 1 && (ao.isWifi(context) || ao.is3G(context) || ao.is4G(context))) {
                x.i("MicroMsg.SubCoreAutoDownload", "it is wifi or 3,4G now, auto download C2C image.");
                return true;
            } else {
                x.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C image.");
                return false;
            }
        }
    }

    public static boolean NO() {
        String value = ((a) g.l(a.class)).AT().getValue("SnsImgPreLoadingAroundTimeLimit");
        x.i("MicroMsg.BusyTimeControlLogic", "SnsImgPreLoadingAroundTimeLimit value: " + value);
        if (b.lz(value)) {
            x.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download SNS image.");
            return false;
        }
        x.i("MicroMsg.SubCoreAutoDownload", "it is not busy time, can auto download SNS image.");
        return true;
    }

    public static boolean a(PInt pInt, PInt pInt2, PInt pInt3) {
        pInt.value = 0;
        int i = bi.getInt(((a) g.l(a.class)).AT().getValue("SIGHTAutoLoadNetwork"), 1);
        pInt2.value = i;
        if (i == 3) {
            x.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video");
            return false;
        }
        boolean isWifi = ao.isWifi(ad.getContext());
        if (i == 2 && !isWifi) {
            x.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video.");
            return false;
        } else if (ao.is2G(ad.getContext())) {
            x.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video.");
            return false;
        } else {
            String value = ((a) g.l(a.class)).AT().getValue("SnsSightNoAutoDownload");
            if (!bi.oW(value)) {
                try {
                    x.i("MicroMsg.SubCoreAutoDownload", "dynamicConfigValSeq " + value);
                    long j = bi.getLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), 0) - ((((long) (((int) b.NL()) - 8)) * 60) / 1000);
                    String[] split = value.split(",");
                    long j2 = bi.getLong(split[0], 0);
                    if (j <= bi.getLong(split[1], 0) && j >= j2) {
                        x.i("MicroMsg.SubCoreAutoDownload", "config settings can not auto download SNS short video");
                        pInt3.value = 1;
                        return false;
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.SubCoreAutoDownload", "paser error %s msg: %s", new Object[]{value, e.getMessage()});
                }
            }
            String value2 = ((a) g.l(a.class)).AT().getValue("SnsSightNotAutoDownloadTimeRange");
            x.i("MicroMsg.BusyTimeControlLogic", "SnsSightNotAutoDownloadTimeRange value: " + value2);
            if (b.lz(value2)) {
                int i2;
                x.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download(but need check again) SNS short video");
                if (i == 2) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                pInt.value = i2;
                return false;
            }
            x.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download.");
            return true;
        }
    }

    public static boolean a(PInt pInt, PInt pInt2) {
        pInt.value = 0;
        int i = bi.getInt(((a) g.l(a.class)).AT().getValue("SIGHTAutoLoadNetwork"), 1);
        pInt2.value = i;
        if (i == 3) {
            x.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video[AD]");
            return false;
        }
        boolean isWifi = ao.isWifi(ad.getContext());
        if (i == 2 && !isWifi) {
            x.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video[AD].");
            return false;
        } else if (ao.is2G(ad.getContext())) {
            x.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video[AD].");
            return false;
        } else {
            String value = ((a) g.l(a.class)).AT().getValue("SnsAdSightNotAutoDownloadTimeRange");
            x.i("MicroMsg.BusyTimeControlLogic", "isSnsAdSightNotAutoDownload value: " + value);
            if (b.lz(value)) {
                int i2;
                x.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto(but need check again) download SNS short video[AD]");
                if (i == 2) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                pInt.value = i2;
                return false;
            }
            x.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download[AD].");
            return true;
        }
    }

    public static boolean p(bd bdVar) {
        if (bdVar == null) {
            x.w("MicroMsg.SubCoreAutoDownload", "this message is null.");
            return false;
        }
        b iF = com.tencent.mm.model.bd.iF(bdVar.cqb);
        if (iF == null) {
            x.i("MicroMsg.SubCoreAutoDownload", "this message had no msg source.");
            return true;
        }
        String str = iF.dCy;
        if (bi.oW(str)) {
            x.i("MicroMsg.SubCoreAutoDownload", "this message had no not auto download time range config.");
            return true;
        } else if (b.lz(str)) {
            x.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download. timeRange : " + str);
            return false;
        } else {
            x.i("MicroMsg.SubCoreAutoDownload", "this message need control, but it is not the time. timeRange: " + str);
            return true;
        }
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
    }
}
