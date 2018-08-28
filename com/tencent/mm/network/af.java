package com.tencent.mm.network;

import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.stn.StnLogic.ICallBack;
import com.tencent.mm.af.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public final class af implements ICallBack {
    private static WakerLock etI = null;
    private static int etJ = 1000000205;
    private static int etK = 205;
    private static byte[] etL;
    private static byte[] etM;

    private static String exception2String(Exception exception) {
        Writer stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public final boolean makesureAuthed() {
        boolean z = false;
        if (aa.UZ() == null) {
            return z;
        }
        try {
            return aa.UZ().UE();
        } catch (Exception e) {
            x.e("StnCallBack", exception2String(e));
            new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[z]).append(", ").append(e.getStackTrace()[1]);
            return z;
        }
    }

    public final String[] onNewDns(String str) {
        return new String[0];
    }

    public final void onPush(int i, byte[] bArr) {
        if (aa.Vb() != null) {
            try {
                if (etI == null) {
                    etI = new WakerLock(aa.getContext(), "StnCallBack");
                }
                etI.lock(1000, "StnLogic.onNotify");
                aa.UX().post(new 1(this, i, bArr));
            } catch (Exception e) {
                x.e("StnCallBack", exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
            }
        }
    }

    public final boolean req2Buf(int i, Object obj, ByteArrayOutputStream byteArrayOutputStream, int[] iArr, int i2) {
        boolean z = false;
        if (aa.Va() == null) {
            return z;
        }
        try {
            return aa.Va().a(i, byteArrayOutputStream, iArr, i2);
        } catch (Exception e) {
            x.e("StnCallBack", exception2String(e));
            new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[z]).append(", ").append(e.getStackTrace()[1]);
            return z;
        }
    }

    public final int buf2Resp(int i, Object obj, byte[] bArr, int[] iArr, int[] iArr2, int i2) {
        int i3 = -1;
        if (aa.Va() == null) {
            return i3;
        }
        try {
            return aa.Va().a(i, bArr, iArr, iArr2);
        } catch (Exception e) {
            x.e("StnCallBack", exception2String(e));
            new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
            return i3;
        }
    }

    public final int onTaskEnd(int i, Object obj, int i2, int i3) {
        Exception e;
        int i4;
        if (aa.Va() == null) {
            return 0;
        }
        try {
            int iM = aa.Va().iM(i);
            try {
                aa.UX().post(new 2(this, i, obj, i2, i3));
                return iM;
            } catch (Exception e2) {
                e = e2;
                i4 = iM;
                x.e("StnCallBack", exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
                return i4;
            }
        } catch (Exception e3) {
            e = e3;
            i4 = 0;
        }
    }

    public final void reportConnectInfo(int i, int i2) {
        try {
            aa.UW().iO(i);
            a.hF(i);
        } catch (Throwable e) {
            x.e("StnCallBack", "reportConnectInfo :%s", new Object[]{bi.i(e)});
        }
    }

    public final int getLongLinkIdentifyCheckBuffer(ByteArrayOutputStream byteArrayOutputStream, ByteArrayOutputStream byteArrayOutputStream2, int[] iArr) {
        iArr[0] = etK;
        iArr[1] = etJ;
        if (a(byteArrayOutputStream, byteArrayOutputStream2) != 0 && byteArrayOutputStream.size() != 0 && byteArrayOutputStream2.size() != 0) {
            return StnLogic.ECHECK_NOW;
        }
        requestDoSync();
        return StnLogic.ECHECK_NEXT;
    }

    public final boolean onLongLinkIdentifyResp(byte[] bArr, byte[] bArr2) {
        if (!(bArr == null || bArr2 == null)) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr2);
            } catch (IOException e) {
            }
            onPush(etJ, byteArrayOutputStream.toByteArray());
        }
        return true;
    }

    public final String[] requestNetCheckShortLinkHosts() {
        return new String[0];
    }

    private static int a(ByteArrayOutputStream byteArrayOutputStream, ByteArrayOutputStream byteArrayOutputStream2) {
        if (aa.UZ() == null) {
            return 0;
        }
        try {
            byte[] UF = aa.UZ().UF();
            if (UF != null) {
                byteArrayOutputStream.write(UF);
                etL = UF;
            }
            UF = aa.UZ().dpW;
            if (UF != null) {
                byteArrayOutputStream2.write(UF);
                etM = UF;
            }
            return aa.UZ().esl.Df();
        } catch (Exception e) {
            x.e("StnCallBack", exception2String(e));
            if (etL == null || etM == null) {
                return 0;
            }
            try {
                byteArrayOutputStream.write(etL);
                byteArrayOutputStream2.write(etM);
                return 0;
            } catch (IOException e2) {
                return 0;
            }
        }
    }

    public final void requestDoSync() {
        if (aa.Vb() != null) {
            try {
                aa.UX().post(new 3(this));
            } catch (Exception e) {
                x.e("StnCallBack", exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
            }
        }
    }

    public final boolean isLogoned() {
        boolean z = false;
        if (aa.UZ() == null) {
            return z;
        }
        try {
            return aa.UZ().esl.Ln();
        } catch (Exception e) {
            x.e("StnCallBack", exception2String(e));
            new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[z]).append(", ").append(e.getStackTrace()[1]);
            return z;
        }
    }

    public final void networkAnalysisCallBack(int i, int i2, boolean z, String str) {
        x.i("StnCallBack", "networkAnalysisCallBack: status:%d, stage:%d, isDetectEnd:%b, kvInfo:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str});
        try {
            aa.UZ().est.networkAnalysisCallBack(i, i2, z, str);
        } catch (Throwable e) {
            x.printErrStackTrace("StnCallBack", e, "", new Object[0]);
            new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
        }
    }
}
