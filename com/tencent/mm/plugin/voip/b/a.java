package com.tencent.mm.plugin.voip.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.protocal.c.bqq;
import com.tencent.mm.protocal.c.byx;
import com.tencent.mm.protocal.c.byy;
import com.tencent.mm.protocal.c.car;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedOutputStream;
import java.net.InetAddress;

public final class a {
    public static boolean oST = false;
    static BufferedOutputStream oSU = null;

    public static int getNetType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 2;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 4;
            }
            if (activeNetworkInfo.getType() != 0) {
                return 2;
            }
            if (activeNetworkInfo.getSubtype() == 1) {
                return 1;
            }
            if (activeNetworkInfo.getSubtype() == 2) {
                return 1;
            }
            if (activeNetworkInfo.getSubtype() == 13) {
                return 5;
            }
            if ((activeNetworkInfo.getSubtype() < 3 || activeNetworkInfo.getSubtype() >= 13) && activeNetworkInfo.getSubtype() <= 13) {
                return 1;
            }
            return 3;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Voip", e, "", new Object[0]);
            return 2;
        }
    }

    private static void OK(String str) {
        if (oSU != null) {
            try {
                oSU.write(str.getBytes());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Voip", e, "", new Object[0]);
            }
        }
    }

    public static void bLO() {
        if (oSU != null) {
            try {
                oSU.flush();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Voip", e, "", new Object[0]);
            }
        }
    }

    public static int aV(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= 4) {
                return i3;
            }
            i = ((bArr[i2] & 255) << (i2 * 8)) | i3;
            i2++;
        }
    }

    public static byte[] yO(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) (i >>> (i2 * 8));
        }
        return bArr;
    }

    public static void eT(String str, String str2) {
        x.e(str, "[" + Thread.currentThread().getId() + "]" + str2);
        OK(str + ":" + str2 + " \n");
    }

    public static void eU(String str, String str2) {
        x.i(str, "[" + Thread.currentThread().getId() + "]" + str2);
        OK(str + ":" + str2 + " \n");
    }

    public static void eV(String str, String str2) {
        x.d(str, "[" + Thread.currentThread().getId() + "]" + str2);
        OK(str + ":" + str2 + " \n");
    }

    public static void eW(String str, String str2) {
        x.w(str, "[" + Thread.currentThread().getId() + "]" + str2);
        OK(str + ":" + str2 + " \n");
    }

    public static void b(byte[] bArr, String str, int i) {
        if (bi.bC(bArr)) {
            bArr = new byte[0];
        }
        String str2 = new String(bArr);
        if (i == 4) {
            x.e(str, str2);
        } else if (i == 2) {
            x.i(str, str2);
        } else {
            x.d(str, str2);
        }
        if (str.equals("MicroMsg.v2Core")) {
            OK(str + ":" + str2);
        } else {
            OK(str + ":" + str2 + " \n");
        }
    }

    public static void yP(int i) {
        try {
            Thread.sleep((long) i);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Voip", e, "", new Object[0]);
        }
    }

    public static int[] a(byy byy) {
        int i;
        x.d("MicroMsg.Voip", "convertSvrAddr: voipAddr.Cnt " + byy.suW);
        if (3 >= byy.suW) {
            i = byy.suW;
        } else {
            i = 3;
        }
        x.d("MicroMsg.Voip", "convertSvrAddr: addrCnt " + i);
        int[] iArr = new int[(i * 2)];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2 * 2] = ((byx) byy.suX.get(i2)).spR;
            iArr[(i2 * 2) + 1] = ((byx) byy.suX.get(i2)).sed;
            x.d("MicroMsg.Voip", "convertSvrAddr: ip " + yQ(((byx) byy.suX.get(i2)).spR) + " Port: " + ((byx) byy.suX.get(i2)).sed);
        }
        return iArr;
    }

    public static int[] a(car car) {
        int i;
        x.d("MicroMsg.Voip", "convertSpeedTestPara: testID= " + car.swW + " SvrListCnt= " + car.sxb);
        if (3 >= car.sxb) {
            i = car.sxb;
        } else {
            i = 3;
        }
        int[] iArr = new int[(i * 6)];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2 * 6] = ((bqq) car.sxc.get(i2)).sop.spR;
            iArr[(i2 * 6) + 1] = ((bqq) car.sxc.get(i2)).sop.sed;
            iArr[(i2 * 6) + 2] = ((bqq) car.sxc.get(i2)).soo;
            iArr[(i2 * 6) + 3] = ((bqq) car.sxc.get(i2)).soK;
            iArr[(i2 * 6) + 4] = ((bqq) car.sxc.get(i2)).soL;
            iArr[(i2 * 6) + 5] = ((bqq) car.sxc.get(i2)).soM;
            x.d("MicroMsg.Voip", "convertSpeedTestPara: ip " + yQ(((bqq) car.sxc.get(i2)).sop.spR) + " Port: " + ((bqq) car.sxc.get(i2)).sop.sed + " TestCnt= " + ((bqq) car.sxc.get(i2)).soo + " TestGap= " + ((bqq) car.sxc.get(i2)).soK + " Timeout= " + ((bqq) car.sxc.get(i2)).soL + " PktSize= " + ((bqq) car.sxc.get(i2)).soM);
        }
        return iArr;
    }

    private static String yQ(int i) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) ((i >>> 24) & 255), (byte) ((i >>> 16) & 255), (byte) ((i >>> 8) & 255), (byte) (i & 255)}).getHostAddress();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Voip", e, "", new Object[0]);
            return null;
        }
    }

    public static int Fw(String str) {
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            if (address != null) {
                int i = 0;
                for (byte b : address) {
                    i = (i << 8) | (b & 255);
                }
                x.d("MicroMsg.Voip", "ipAddressStrToInt, ip: %s, result: %d", new Object[]{str, Integer.valueOf(i)});
                return i;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Voip", e, "", new Object[0]);
        }
        return 0;
    }
}
