package oicq.wlogin_sdk.request;

import android.content.Context;
import java.security.SecureRandom;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public final class i {
    public static byte[] vIA = new byte[0];
    public Context _context = null;
    public long _uin = 0;
    byte[] vIB = new byte[0];
    int vIC = 0;
    byte[] vID = new byte[0];
    byte[] vIE = new byte[0];
    byte[] vIF = new byte[0];
    byte[] vIG = new byte[0];
    byte[] vIH = new byte[0];
    byte[] vII = new byte[0];
    int vIJ = 0;
    int vIK = 0;
    int vIL = 0;
    int vIM = 0;
    byte[] vIN = new byte[0];
    ErrMsg vIO = new ErrMsg();
    byte[] vIP = new byte[0];
    byte[] vIQ = new byte[4];
    byte[] vIR = new byte[0];
    c vIS = null;
    public SecureRandom vIp = new SecureRandom();
    public byte[] vIq = util.cKm();
    public byte[] vIr = null;
    public byte[] vIs = new byte[16];
    public f vIt = new f();
    public g vIu = new g();
    public long vIv = 0;
    public int vIw = 0;
    public long vIx = -1;
    public int vIy = 0;
    byte[] vIz = new byte[0];

    public static long cKc() {
        return System.currentTimeMillis() / 1000;
    }

    public final synchronized int a(long j, long j2, long j3, long j4, long j5, long j6, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[] bArr13, byte[] bArr14, byte[] bArr15, byte[] bArr16, byte[][] bArr17) {
        util.adN("put siginfo:" + j + "," + j2 + "," + j3 + "," + j4 + "," + j5 + "," + j6 + "," + util.ch(bArr) + "," + util.ch(bArr2) + "," + util.ch(bArr3) + "," + util.ch(bArr4) + "," + util.ch(bArr5) + "," + util.ch(bArr6) + "," + util.ch(bArr7) + "," + util.ch(bArr8) + "," + util.ch(bArr9) + "," + util.ch(bArr10) + "," + util.ch(bArr11) + "," + util.ch(bArr12) + "," + util.ch(bArr13) + "," + util.ch(bArr14) + "," + util.ch(bArr15) + "," + util.ch(bArr16));
        String str = "";
        for (int i = 0; i < bArr17.length; i++) {
            str = new StringBuilder(String.valueOf(str)).append(String.format("reserve[%d]: %d ", new Object[]{Integer.valueOf(i), Long.valueOf(util.ch(bArr17[i]))})).toString();
        }
        util.adN("reserve:" + str);
        return this.vIS.a(j, j2, j3, j4, j5, j6, bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13, bArr14, bArr15, bArr16, bArr17);
    }

    public final synchronized WloginSigInfo hj(long j) {
        WloginSigInfo hj;
        util.gz("get_siginfo", "uin=" + j + "appid=522017402");
        hj = this.vIS.hj(j);
        if (hj != null) {
        }
        return hj;
    }

    public final synchronized void i(Long l) {
        this.vIS.i(l);
    }
}
