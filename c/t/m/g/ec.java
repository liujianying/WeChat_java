package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import c.t.m.g.dp.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;

public final class ec {
    public static boolean a = false;

    @SuppressLint({"NewApi"})
    public static boolean a(Context context) {
        try {
            if (VERSION.SDK_INT >= 17) {
                if (Global.getInt(context.getContentResolver(), "airplane_mode_on") == 1) {
                    return true;
                }
                return false;
            } else if (System.getInt(context.getContentResolver(), "airplane_mode_on") != 1) {
                return false;
            } else {
                return true;
            }
        } catch (Throwable th) {
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public static List<dp> a(ct ctVar) {
        try {
            TelephonyManager telephonyManager = ctVar.e;
            if (telephonyManager != null) {
                List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
                if (allCellInfo == null) {
                    return null;
                }
                List<dp> arrayList = new ArrayList();
                for (CellInfo cellInfo : allCellInfo) {
                    if (cellInfo.isRegistered()) {
                        arrayList.add(dp.a(ctVar, cellInfo));
                    }
                }
                return arrayList;
            }
        } catch (Throwable th) {
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.telephony.CellLocation b(c.t.m.g.ct r6) {
        /*
        r2 = 0;
        r1 = 1;
        r3 = r6.e;
        if (r3 == 0) goto L_0x0046;
    L_0x0006:
        r4 = r3.getCellLocation();	 Catch:{ Exception -> 0x0043 }
        r0 = r3.getSimState();	 Catch:{ Exception -> 0x0043 }
        r5 = 5;
        if (r0 != r5) goto L_0x003c;
    L_0x0011:
        r0 = r1;
    L_0x0012:
        r3 = r3.getSubscriberId();	 Catch:{ Exception -> 0x0040 }
        r3 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Exception -> 0x0040 }
        if (r3 != 0) goto L_0x003e;
    L_0x001c:
        r3 = r1;
    L_0x001d:
        if (r0 == 0) goto L_0x003a;
    L_0x001f:
        if (r3 == 0) goto L_0x003a;
    L_0x0021:
        if (r4 == 0) goto L_0x002f;
    L_0x0023:
        r0 = b(r4);	 Catch:{ Exception -> 0x0043 }
        if (r0 != 0) goto L_0x002f;
    L_0x0029:
        r0 = a(r4);	 Catch:{ Exception -> 0x0043 }
        if (r0 >= 0) goto L_0x0038;
    L_0x002f:
        r0 = r6.a;	 Catch:{ Exception -> 0x0043 }
        r0 = a(r0);	 Catch:{ Exception -> 0x0043 }
        if (r0 != 0) goto L_0x0038;
    L_0x0037:
        r2 = r1;
    L_0x0038:
        a = r2;	 Catch:{ Exception -> 0x0043 }
    L_0x003a:
        r0 = r4;
    L_0x003b:
        return r0;
    L_0x003c:
        r0 = r2;
        goto L_0x0012;
    L_0x003e:
        r3 = r2;
        goto L_0x001d;
    L_0x0040:
        r3 = move-exception;
        r3 = r1;
        goto L_0x001d;
    L_0x0043:
        r0 = move-exception;
        a = r1;
    L_0x0046:
        r0 = android.telephony.CellLocation.getEmpty();
        goto L_0x003b;
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.ec.b(c.t.m.g.ct):android.telephony.CellLocation");
    }

    public static int a(CellLocation cellLocation) {
        if (cellLocation instanceof CdmaCellLocation) {
            return ((CdmaCellLocation) cellLocation).getBaseStationId();
        }
        try {
            return ((GsmCellLocation) cellLocation).getCid();
        } catch (Exception e) {
            return -1;
        }
    }

    private static boolean b(CellLocation cellLocation) {
        try {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            if (gsmCellLocation.getCid() == 0 && gsmCellLocation.getLac() == 0) {
                return true;
            }
        } catch (ClassCastException e) {
        }
        return false;
    }

    public static boolean a(CellLocation cellLocation, CellLocation cellLocation2) {
        boolean z;
        if (cellLocation == null || cellLocation2 == null) {
            z = true;
        } else {
            z = false;
        }
        if (z || cellLocation.getClass() != cellLocation2.getClass()) {
            return false;
        }
        if (cellLocation instanceof GsmCellLocation) {
            if (((GsmCellLocation) cellLocation).getCid() == ((GsmCellLocation) cellLocation2).getCid()) {
                return true;
            }
            return false;
        } else if (!(cellLocation instanceof CdmaCellLocation)) {
            return false;
        } else {
            if (((CdmaCellLocation) cellLocation).getBaseStationId() == ((CdmaCellLocation) cellLocation2).getBaseStationId()) {
                return true;
            }
            return false;
        }
    }

    public static boolean a(dp dpVar) {
        boolean z;
        if (dpVar == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        return a(dpVar.a.ordinal(), dpVar.b, dpVar.c, dpVar.d, dpVar.e);
    }

    public static boolean a(int i, int i2, int i3, int i4, int i5) {
        if (b(i)) {
            if (i2 < 0 || i3 < 0 || i4 < 0 || i4 > 65535 || i5 <= 0 || i5 > 65535 || (i3 == 0 && i4 == 0 && i5 == 0)) {
                return false;
            }
            return true;
        } else if (i2 < 0 || i3 < 0 || i4 <= 0 || i4 >= 65535) {
            return false;
        } else {
            if (i5 == 268435455 || i5 == Integer.MAX_VALUE || i5 == 50594049 || i5 == 65535 || i5 <= 0) {
                return false;
            }
            if (i5 == 65535 || i5 <= 0) {
                return false;
            }
            return true;
        }
    }

    public static boolean a(int i, SignalStrength signalStrength, SignalStrength signalStrength2) {
        if (signalStrength == null || signalStrength2 == null) {
            return true;
        }
        int abs = Math.abs(b(i, signalStrength, signalStrength2));
        if (a(i)) {
            if (abs <= 3) {
                return false;
            }
            return true;
        } else if (!b(i)) {
            return false;
        } else {
            if (abs <= 6) {
                return false;
            }
            return true;
        }
    }

    private static int b(int i, SignalStrength signalStrength, SignalStrength signalStrength2) {
        try {
            if (a(i)) {
                return signalStrength.getGsmSignalStrength() - signalStrength2.getGsmSignalStrength();
            }
            if (b(i)) {
                return signalStrength.getCdmaDbm() - signalStrength2.getCdmaDbm();
            }
            return 0;
        } catch (Throwable th) {
        }
    }

    private static boolean a(int i) {
        return i != a.c.ordinal();
    }

    private static boolean b(int i) {
        return i == a.c.ordinal();
    }

    public static void a(@NonNull TelephonyManager telephonyManager, @NonNull int[] iArr) {
        String networkOperator = telephonyManager.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() >= 5) {
            try {
                iArr[0] = Integer.parseInt(networkOperator.substring(0, 3));
                iArr[1] = Integer.parseInt(networkOperator.substring(3, 5));
                return;
            } catch (Throwable th) {
                th.toString();
            }
        }
        iArr[0] = 460;
        iArr[1] = 0;
    }

    public static List<NeighboringCellInfo> c(ct ctVar) {
        TelephonyManager telephonyManager = ctVar.e;
        if (telephonyManager != null) {
            try {
                return telephonyManager.getNeighboringCellInfo();
            } catch (Exception e) {
            }
        }
        return Collections.emptyList();
    }
}
