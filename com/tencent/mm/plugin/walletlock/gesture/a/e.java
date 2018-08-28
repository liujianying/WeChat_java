package com.tencent.mm.plugin.walletlock.gesture.a;

import android.os.SystemClock;
import com.tencent.mm.a.o;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.protocal.c.ayy;
import com.tencent.mm.protocal.c.ayz;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import java.util.List;

public final class e {
    public static boolean b(ayy ayy) {
        if (ayy == null || ayy.sbJ == null || ayy.sbJ.siK == null) {
            return false;
        }
        byte[] bArr = ayy.sbJ.siK.lR;
        if (bArr.length == 0 || (bArr.length & 1) != 0) {
            return false;
        }
        long longValue = new o(ayy.uin).longValue();
        bArr = aX(bArr);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ayy.version);
        if (ayy.sbH.siL) {
            stringBuilder.append(new String(ayy.sbH.siK.lR));
        }
        stringBuilder.append(longValue);
        x.d("MicroMsg.GestureUtil", String.format("verifyPatternBuffer, ret:%d", new Object[]{Integer.valueOf(UtilsJni.doEcdsaVerify(a.pGV, stringBuilder.toString().getBytes(), bArr))}));
        if (UtilsJni.doEcdsaVerify(a.pGV, stringBuilder.toString().getBytes(), bArr) != 1) {
            return false;
        }
        return true;
    }

    public static boolean b(ayz ayz) {
        if (ayz == null || ayz.sbL == null || ayz.sbL.siK == null) {
            return false;
        }
        byte[] bArr = ayz.sbL.siK.lR;
        if (bArr.length == 0 || (bArr.length & 1) != 0) {
            return false;
        }
        boolean z;
        bArr = aX(bArr);
        g.Eg();
        long longValue = new o(a.Df()).longValue();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ayz.sbK);
        stringBuilder.append(longValue);
        int doEcdsaVerify = UtilsJni.doEcdsaVerify(a.pGV, stringBuilder.toString().getBytes(), bArr);
        if ((doEcdsaVerify == 1 || ayz.sbM != 1) && !(doEcdsaVerify == 1 && ayz.sbM == 0)) {
            z = false;
        } else {
            z = true;
        }
        x.d("MicroMsg.GestureUtil", String.format("verifyPatternInfo, verifyRes:%d ret:%b", new Object[]{Integer.valueOf(doEcdsaVerify), Boolean.valueOf(z)}));
        return z;
    }

    private static byte[] aX(byte[] bArr) {
        String str = "0123456789abcdef";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < bArr.length - 1; i += 2) {
            byteArrayOutputStream.write((str.indexOf(Character.toLowerCase(bArr[i])) << 4) | str.indexOf(Character.toLowerCase(bArr[i + 1])));
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static boolean bRE() {
        int i = -1;
        if (!g.Eg().Dx() || a.Dr()) {
            x.w("MicroMsg.GestureUtil", "not login !!");
            return false;
        }
        int i2;
        boolean i22;
        int i3;
        boolean b;
        ayz bRL = d.bRL();
        ayy bRK = d.bRK();
        if (bRL == null) {
            i22 = 1;
        } else {
            i22 = false;
        }
        if (bRK == null) {
            i3 = 1;
        } else {
            boolean i32 = false;
        }
        if (i22 == 0) {
            i22 = b(bRL);
        } else {
            i22 = false;
        }
        String str = "MicroMsg.GestureUtil";
        String str2 = "tom isUserSetWalletLock serverInfo:%s status:%d  svrinfoValid:%s";
        Object[] objArr = new Object[3];
        objArr[0] = bRL;
        objArr[1] = Integer.valueOf(bRL == null ? -1 : bRL.sbM);
        objArr[2] = Boolean.valueOf(i22);
        x.i(str, str2, objArr);
        if (i32 == 0) {
            b = b(bRK);
        } else {
            b = false;
        }
        String str3 = "MicroMsg.GestureUtil";
        str = "tom isUserSetWalletLock localBuff:%s status:%d  localBuffValid:%s";
        Object[] objArr2 = new Object[3];
        objArr2[0] = bRK;
        if (bRK != null) {
            i = bRK.sbI;
        }
        objArr2[1] = Integer.valueOf(i);
        objArr2[2] = Boolean.valueOf(b);
        x.i(str3, str, objArr2);
        if (i22) {
            if (b) {
                try {
                    x.i("MicroMsg.GestureUtil", "Both info & buff are valid, choose one to trust.");
                    if (bRL.sbK > bRK.version) {
                        x.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, srvInfo wins.", new Object[]{Integer.valueOf(bRL.sbK), Integer.valueOf(bRK.version)});
                        if (bRL.sbM == 1) {
                            return true;
                        }
                        return false;
                    } else if (bRL.sbK == bRK.version) {
                        x.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, draw.", new Object[]{Integer.valueOf(bRL.sbK), Integer.valueOf(bRK.version)});
                        if (bRL.sbM == 1) {
                            return true;
                        }
                        return false;
                    } else {
                        x.i("MicroMsg.GestureUtil", "srvInfoVer:%d, localBuffVer:%d, localBuff wins.", new Object[]{Integer.valueOf(bRL.sbK), Integer.valueOf(bRK.version)});
                        if (bRK.sbI == 1) {
                            return true;
                        }
                        return false;
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.GestureUtil", e, "isUserSetWalletLock throw an exception.", new Object[0]);
                    return false;
                }
            }
            x.i("MicroMsg.GestureUtil", "Info is valid but buf is invalid, we trust info this time.");
            if (bRL.sbM == 1) {
                return true;
            }
            return false;
        } else if (b) {
            x.i("MicroMsg.GestureUtil", "Info is invalid but buff is valid, we trust buff this time.");
            if (bRK.sbI == 1) {
                return true;
            }
            return false;
        } else {
            x.w("MicroMsg.GestureUtil", "Both buff & info are invalid, do not activate this time and wait for next sync.");
            return false;
        }
    }

    public static byte[] cJ(List<f> list) {
        if (list == null) {
            throw new IllegalArgumentException("pattern is null");
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            f fVar = (f) list.get(i);
            bArr[i] = (byte) ((fVar.pGX + (fVar.pGW * 3)) + 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < size; i2++) {
            stringBuilder.append(bArr[i2]);
        }
        String stringBuilder2 = stringBuilder.toString();
        return com.tencent.mm.a.g.u((com.tencent.mm.a.g.u((com.tencent.mm.a.g.u(stringBuilder2.getBytes()) + q.GF()).getBytes()) + stringBuilder2).getBytes()).getBytes();
    }

    public static void a(g gVar) {
        if (gVar.pGZ != -1) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime < gVar.pGZ) {
                gVar.pGZ = elapsedRealtime;
                gVar.pHa += elapsedRealtime;
                x.d("MicroMsg.GestureUtil", String.format("Rebooted, need to add additional %d ms, now elapsed %d ms", new Object[]{Long.valueOf(elapsedRealtime), Long.valueOf(gVar.pHa)}));
                return;
            }
            gVar.pHa = (elapsedRealtime - gVar.pGZ) + gVar.pHa;
            gVar.pGZ = elapsedRealtime;
        }
    }

    public static byte[] PI(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < str.length(); i += 2) {
            byteArrayOutputStream.write(Integer.parseInt(str.substring(i, i + 2), 16));
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String aY(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & WebView.NORMAL_MODE_ALPHA);
            if (toHexString.length() < 2) {
                stringBuilder.append('0');
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }
}
