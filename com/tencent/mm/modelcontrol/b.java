package com.tencent.mm.modelcontrol;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class b {
    public static boolean lz(String str) {
        if (bi.oW(str)) {
            return false;
        }
        try {
            int NK = NK();
            String[] split = str.split(";");
            for (String split2 : split) {
                String[] split3 = split2.split("-");
                String[] split4 = split3[0].split(":");
                int WU = bi.WU(split4[1]) + (bi.WU(split4[0]) * 60);
                split3 = split3[1].split(":");
                if (y(WU, bi.WU(split3[1]) + (bi.WU(split3[0]) * 60), NK)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BusyTimeControlLogic", e, "", new Object[0]);
            x.e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + e.toString());
            return false;
        }
    }

    public static boolean M(String str, int i) {
        if (bi.oW(str)) {
            return false;
        }
        try {
            int NK = NK();
            String[] split = str.split(";");
            for (String split2 : split) {
                String[] split3 = split2.split("-");
                String[] split4 = split3[0].split(":");
                int WU = bi.WU(split4[1]) + (bi.WU(split4[0]) * 60);
                split3 = split3[1].split(":");
                if (y(WU, (bi.WU(split3[1]) + (bi.WU(split3[0]) * 60)) + i, NK)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BusyTimeControlLogic", e, "", new Object[0]);
            x.e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + e.toString());
            return false;
        }
    }

    private static int NK() {
        String[] split = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
        int WU = (bi.WU(split[1]) + (bi.WU(split[0]) * 60)) - ((((int) NL()) - 8) * 60);
        if (WU < 0) {
            return WU + 1440;
        }
        if (WU >= 1440) {
            return WU - 1440;
        }
        return WU;
    }

    public static long NL() {
        return ((long) ((int) (((long) TimeZone.getDefault().getRawOffset()) / 60000))) / 60;
    }

    private static boolean y(int i, int i2, int i3) {
        if (i < i2) {
            if (i3 >= i2 || i3 < i) {
                return false;
            }
            return true;
        } else if (i3 <= 1440 && i3 >= i) {
            return true;
        } else {
            if (i3 >= i2 || i3 < 0) {
                return false;
            }
            return true;
        }
    }
}
