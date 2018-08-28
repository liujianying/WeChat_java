package com.tencent.mm.plugin.ipcall.b;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.mm.R;
import com.tencent.mm.ax.e;
import com.tencent.mm.ax.g;
import com.tencent.mm.model.au;
import com.tencent.mm.p.a;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.protocal.c.akc;
import com.tencent.mm.protocal.c.bbu;
import com.tencent.mm.protocal.c.byx;
import com.tencent.mm.protocal.c.byy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class c {
    public static byy V(LinkedList<bbu> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return null;
        }
        byy byy = new byy();
        byy.suW = linkedList.size();
        byy.suX = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bbu bbu = (bbu) it.next();
            byx byx = new byx();
            byx.spR = Fw(bbu.rTO);
            byx.sed = bbu.sed;
            byy.suX.add(byx);
        }
        return byy;
    }

    private static int Fw(String str) {
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            if (address != null) {
                int i = 0;
                for (byte b : address) {
                    i = (i << 8) | (b & 255);
                }
                x.d("MicroMsg.IPCallUtil", "ipAddressStrToInt, ip: %s, result: %d", new Object[]{str, Integer.valueOf(i)});
                return i;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.IPCallUtil", e, "", new Object[0]);
        }
        return 0;
    }

    public static int aYA() {
        Context context = ad.getContext();
        if (ao.is2G(context)) {
            return 1;
        }
        if (ao.is3G(context)) {
            return 3;
        }
        if (ao.is4G(context)) {
            return 5;
        }
        if (ao.isWifi(context)) {
            return 4;
        }
        return 0;
    }

    public static String Fx(String str) {
        return str.replace("-", "").replace(" ", "").replace("(", "").replace(")", "").trim();
    }

    public static String rL(int i) {
        Context context = ad.getContext();
        switch (i) {
            case 1:
                return context.getString(R.l.ip_call_status_cancel);
            case 2:
                return context.getString(R.l.ip_call_status_cancel);
            case 6:
                return context.getString(R.l.ip_call_status_call_failed);
            case 7:
                return context.getString(R.l.ip_call_status_call_invalid_number);
            default:
                return context.getString(R.l.ip_call_status_cancel);
        }
    }

    public static CharSequence h(Context context, long j) {
        return DateFormat.format(context.getString(R.l.fmt_normal_time_24), j);
    }

    public static String aA(Context context, String str) {
        int i = 0;
        String[] stringArray = context.getResources().getStringArray(R.c.time_month);
        List arrayList = new ArrayList();
        arrayList.add("");
        for (int i2 = i; i2 < stringArray.length; i2++) {
            arrayList.add(stringArray[i2]);
        }
        try {
            i = bi.getInt(str, 0);
        } catch (Exception e) {
        }
        if (i >= arrayList.size()) {
            return "";
        }
        return (String) arrayList.get(i);
    }

    public static String dR(long j) {
        Object obj = 1;
        Context context = ad.getContext();
        if ((dS(j) == 0 ? 1 : null) != null) {
            return new SimpleDateFormat("HH:mm", Locale.US).format(new Date(j));
        }
        if (dS(j) != -1) {
            obj = null;
        }
        if (obj != null) {
            return context.getString(R.l.ip_call_call_time_yesterday_format);
        }
        return new SimpleDateFormat("MM/dd", Locale.US).format(new Date(j));
    }

    private static long dS(long j) {
        Calendar instance = Calendar.getInstance();
        long timeInMillis = instance.getTimeInMillis();
        instance.add(6, 1);
        long timeInMillis2 = instance.getTimeInMillis() - timeInMillis;
        return (j / timeInMillis2) - (Calendar.getInstance().getTimeInMillis() / timeInMillis2);
    }

    public static String dT(long j) {
        Context context = ad.getContext();
        if (((double) j) <= 60.0d) {
            return context.getString(R.l.ip_call_duration_second, new Object[]{String.valueOf(j)});
        }
        int i = (int) (((double) j) / 60.0d);
        if ((((double) j) / 60.0d) - ((double) i) > 0.0d) {
            i++;
        }
        return context.getString(R.l.ip_call_duration, new Object[]{String.valueOf(i)});
    }

    public static boolean dK(Context context) {
        int i;
        if (d.bLT()) {
            i = R.l.in_voip_tip;
        } else if (d.bLU()) {
            i = R.l.in_voip_cs_tip;
        } else if (e.SA()) {
            i = R.l.in_share_location_tip;
        } else if (a.BQ()) {
            i = R.l.in_multitalk_tip;
        } else {
            boolean z;
            if (g.elf == null || !g.elf.Sm()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                i = R.l.in_share_location_tip;
            } else {
                i = 0;
            }
        }
        if (i == 0) {
            return true;
        }
        h.i(context, i, R.l.app_tip);
        return false;
    }

    public static void c(MMActivity mMActivity, String str) {
        ((ClipboardManager) mMActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, str));
    }

    public static String aYB() {
        String string = ad.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryCode", "");
        if (bi.oW(string)) {
            return a.aYy();
        }
        return string.replace("+", "");
    }

    public static boolean aYC() {
        return com.tencent.mm.k.g.AT().getInt("WCOClosePurchaseEntranceSwitch", 0) != 0;
    }

    public static akc aYD() {
        au.HU();
        Object obj = com.tencent.mm.model.c.DT().get(aa.a.sSg, null);
        if (obj != null) {
            akc akc = new akc();
            try {
                akc.aG(bi.WP(obj.toString()));
                x.i("MicroMsg.IPCallUtil", "[royle]parse success,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,Balance:%s,PVWording:%s,PackageMsg:%s", new Object[]{akc.rMH, akc.ksB, akc.bHD, akc.jOS, akc.rMI, akc.rMJ, akc.rMK, akc.rML, akc.rMS});
                return akc;
            } catch (IOException e) {
                x.i("MicroMsg.IPCallUtil", "[royle]parse exception:%s", new Object[]{e.getMessage()});
            }
        }
        return null;
    }
}
