package oicq.wlogin_sdk.request;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.tools.util;

public final class b {
    private static /* synthetic */ int[] vHT;
    private Context mContext = null;
    public i vHK = new i();
    private j vHL = new j(this.vHK);
    private f vHM = new f(this.vHK);
    private g vHN = new g(this.vHK);
    private h vHO = new h(this.vHK);
    private e vHP = new e(this.vHK);
    public d vHQ = null;
    private int vHR = 66560;
    private int vHS = 1404;

    public enum a {
        USER_WITH_PWD,
        USER_WITH_MD5,
        USER_WITH_A1
    }

    private static /* synthetic */ int[] cJZ() {
        int[] iArr = vHT;
        if (iArr == null) {
            iArr = new int[a.values().length];
            try {
                iArr[a.USER_WITH_A1.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[a.USER_WITH_MD5.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[a.USER_WITH_PWD.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            vHT = iArr;
        }
        return iArr;
    }

    public b(Context context, int i) {
        this.mContext = context;
        i iVar = this.vHK;
        iVar._context = context;
        iVar.vIy = i;
        iVar.vIS = new c(context);
        Object obj = new byte[16];
        iVar.vIp.nextBytes(obj);
        System.arraycopy(obj, 0, iVar.vIs, 0, 16);
        cJY();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] a(long r10, oicq.wlogin_sdk.request.b.a r12, java.lang.String r13) {
        /*
        r9 = this;
        r4 = 16;
        r2 = 0;
        r1 = 0;
        r0 = new java.lang.StringBuilder;
        r3 = "wtlogin login with GetStWithPasswd:user:";
        r0.<init>(r3);
        r0 = r0.append(r10);
        r3 = " appid:522017402 dwSigMap:8256 ...";
        r0 = r0.append(r3);
        r0 = r0.toString();
        oicq.wlogin_sdk.tools.util.adN(r0);
        r0 = r13.length();
        if (r0 <= r4) goto L_0x0028;
    L_0x0024:
        r13 = r13.substring(r2, r4);
    L_0x0028:
        monitor-enter(r9);
        r0 = cJZ();	 Catch:{ all -> 0x0161 }
        r3 = r12.ordinal();	 Catch:{ all -> 0x0161 }
        r0 = r0[r3];	 Catch:{ all -> 0x0161 }
        switch(r0) {
            case 1: goto L_0x0039;
            case 2: goto L_0x00b6;
            case 3: goto L_0x00de;
            default: goto L_0x0036;
        };	 Catch:{ all -> 0x0161 }
    L_0x0036:
        monitor-exit(r9);	 Catch:{ all -> 0x0161 }
        r0 = r1;
    L_0x0038:
        return r0;
    L_0x0039:
        if (r13 == 0) goto L_0x0041;
    L_0x003b:
        r0 = r13.length();	 Catch:{ all -> 0x0161 }
        if (r0 != 0) goto L_0x004a;
    L_0x0041:
        r0 = "USER_WITH_PWD userPasswd null";
        oicq.wlogin_sdk.tools.util.adN(r0);	 Catch:{ all -> 0x0161 }
        monitor-exit(r9);	 Catch:{ all -> 0x0161 }
        r0 = r1;
        goto L_0x0038;
    L_0x004a:
        r5 = oicq.wlogin_sdk.tools.c.adL(r13);	 Catch:{ all -> 0x0161 }
        r1 = r2;
    L_0x004f:
        r0 = r9.vHK;	 Catch:{ all -> 0x0161 }
        r2 = r9.mContext;	 Catch:{ all -> 0x0161 }
        r2 = oicq.wlogin_sdk.tools.util.iu(r2);	 Catch:{ all -> 0x0161 }
        r0.vIC = r2;	 Catch:{ all -> 0x0161 }
        r0 = r9.vHK;	 Catch:{ all -> 0x0161 }
        r2 = r9.mContext;	 Catch:{ all -> 0x0161 }
        r2 = oicq.wlogin_sdk.tools.util.ix(r2);	 Catch:{ all -> 0x0161 }
        r2 = r2.getBytes();	 Catch:{ all -> 0x0161 }
        r0.vIE = r2;	 Catch:{ all -> 0x0161 }
        r0 = r9.vHK;	 Catch:{ all -> 0x0161 }
        r0._uin = r10;	 Catch:{ all -> 0x0161 }
        r0 = r9.vHK;	 Catch:{ all -> 0x0161 }
        r2 = 522017402; // 0x1f1d5a7a float:3.3320884E-20 double:2.57910865E-315;
        r0.vIv = r2;	 Catch:{ all -> 0x0161 }
        r0 = r9.vHK;	 Catch:{ all -> 0x0161 }
        r2 = 8256; // 0x2040 float:1.1569E-41 double:4.079E-320;
        r0.vIw = r2;	 Catch:{ all -> 0x0161 }
        r0 = r9.vHK;	 Catch:{ all -> 0x0161 }
        r2 = new oicq.wlogin_sdk.a.f;	 Catch:{ all -> 0x0161 }
        r2.<init>();	 Catch:{ all -> 0x0161 }
        r0.vIt = r2;	 Catch:{ all -> 0x0161 }
        r0 = r9.vHL;	 Catch:{ all -> 0x0161 }
        r9.vHQ = r0;	 Catch:{ all -> 0x0161 }
        if (r1 == 0) goto L_0x0141;
    L_0x0087:
        r1 = r9.vHL;	 Catch:{ all -> 0x0161 }
        r0 = r9.vHK;	 Catch:{ all -> 0x0161 }
        r4 = r0.vIQ;	 Catch:{ all -> 0x0161 }
        r6 = r9.vHS;	 Catch:{ all -> 0x0161 }
        r7 = r9.vHR;	 Catch:{ all -> 0x0161 }
        r0 = r9.vHK;	 Catch:{ all -> 0x0161 }
        r8 = r0.vIN;	 Catch:{ all -> 0x0161 }
        r2 = r10;
        r0 = r1.a(r2, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0161 }
    L_0x009a:
        monitor-exit(r9);	 Catch:{ all -> 0x0161 }
        r1 = new java.lang.StringBuilder;
        r2 = "wtlogin login with GetStWithPasswd:user:";
        r1.<init>(r2);
        r1 = r1.append(r10);
        r2 = " appid:522017402 dwSigMap:8256 end";
        r1 = r1.append(r2);
        r1 = r1.toString();
        oicq.wlogin_sdk.tools.util.adN(r1);
        goto L_0x0038;
    L_0x00b6:
        if (r13 == 0) goto L_0x00be;
    L_0x00b8:
        r0 = r13.length();	 Catch:{ all -> 0x0161 }
        if (r0 != 0) goto L_0x00c8;
    L_0x00be:
        r0 = "USER_WITH_MD5 userPasswd null";
        oicq.wlogin_sdk.tools.util.adN(r0);	 Catch:{ all -> 0x0161 }
        monitor-exit(r9);	 Catch:{ all -> 0x0161 }
        r0 = r1;
        goto L_0x0038;
    L_0x00c8:
        r0 = "ISO-8859-1";
        r0 = r13.getBytes(r0);	 Catch:{ Exception -> 0x00d9 }
        r0 = r0.clone();	 Catch:{ Exception -> 0x00d9 }
        r0 = (byte[]) r0;	 Catch:{ Exception -> 0x00d9 }
        r1 = r2;
        r5 = r0;
        goto L_0x004f;
    L_0x00d9:
        r0 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x0161 }
        r0 = r1;
        goto L_0x0038;
    L_0x00de:
        r0 = r9.vHK;	 Catch:{ all -> 0x0161 }
        r0 = r0.hj(r10);	 Catch:{ all -> 0x0161 }
        if (r0 == 0) goto L_0x00ef;
    L_0x00e6:
        r2 = r0._en_A1;	 Catch:{ all -> 0x0161 }
        if (r2 == 0) goto L_0x00ef;
    L_0x00ea:
        r2 = r0._en_A1;	 Catch:{ all -> 0x0161 }
        r2 = r2.length;	 Catch:{ all -> 0x0161 }
        if (r2 > 0) goto L_0x0119;
    L_0x00ef:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0161 }
        r2 = "userAccount:";
        r0.<init>(r2);	 Catch:{ all -> 0x0161 }
        r0 = r0.append(r10);	 Catch:{ all -> 0x0161 }
        r2 = " appid:522017402 GetA1ByAccount return: null";
        r0 = r0.append(r2);	 Catch:{ all -> 0x0161 }
        r0 = r0.toString();	 Catch:{ all -> 0x0161 }
        oicq.wlogin_sdk.tools.util.adN(r0);	 Catch:{ all -> 0x0161 }
        r5 = r1;
    L_0x010a:
        if (r5 == 0) goto L_0x010f;
    L_0x010c:
        r0 = r5.length;	 Catch:{ all -> 0x0161 }
        if (r0 >= r4) goto L_0x013d;
    L_0x010f:
        r0 = "USER_WITH_A1 tmp_pwd null";
        oicq.wlogin_sdk.tools.util.adN(r0);	 Catch:{ all -> 0x0161 }
        monitor-exit(r9);	 Catch:{ all -> 0x0161 }
        r0 = r1;
        goto L_0x0038;
    L_0x0119:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0161 }
        r3 = "userAccount:";
        r2.<init>(r3);	 Catch:{ all -> 0x0161 }
        r2 = r2.append(r10);	 Catch:{ all -> 0x0161 }
        r3 = " appid:522017402 GetA1ByAccount return: not null";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0161 }
        r2 = r2.toString();	 Catch:{ all -> 0x0161 }
        oicq.wlogin_sdk.tools.util.adN(r2);	 Catch:{ all -> 0x0161 }
        r0 = r0._en_A1;	 Catch:{ all -> 0x0161 }
        r0 = r0.clone();	 Catch:{ all -> 0x0161 }
        r0 = (byte[]) r0;	 Catch:{ all -> 0x0161 }
        r5 = r0;
        goto L_0x010a;
    L_0x013d:
        r0 = 1;
        r1 = r0;
        goto L_0x004f;
    L_0x0141:
        r0 = 4;
        r4 = new byte[r0];	 Catch:{ all -> 0x0161 }
        r0 = 0;
        r2 = oicq.wlogin_sdk.request.i.cKc();	 Catch:{ all -> 0x0161 }
        oicq.wlogin_sdk.tools.util.d(r4, r0, r2);	 Catch:{ all -> 0x0161 }
        r0 = r9.vHL;	 Catch:{ all -> 0x0161 }
        r1 = r9.vHK;	 Catch:{ all -> 0x0161 }
        r3 = r1.vIQ;	 Catch:{ all -> 0x0161 }
        r6 = r9.vHS;	 Catch:{ all -> 0x0161 }
        r7 = r9.vHR;	 Catch:{ all -> 0x0161 }
        r1 = r9.vHK;	 Catch:{ all -> 0x0161 }
        r8 = r1.vIN;	 Catch:{ all -> 0x0161 }
        r1 = r10;
        r0 = r0.a(r1, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0161 }
        goto L_0x009a;
    L_0x0161:
        r0 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x0161 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: oicq.wlogin_sdk.request.b.a(long, oicq.wlogin_sdk.request.b$a, java.lang.String):byte[]");
    }

    public final byte[] f(long j, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        byte[] bX;
        util.adN("user:" + j + " CheckPicture ...");
        synchronized (this) {
            this.vHQ = this.vHN;
            bX = this.vHN.bX(bArr);
        }
        util.adN("user:" + j + " CheckPicture end");
        return bX;
    }

    public final byte[] hg(long j) {
        Object obj;
        synchronized (this) {
            g gVar = this.vHK.vIu;
            obj = new byte[gVar.vJf];
            if (gVar.vJf > 0) {
                System.arraycopy(gVar.vIf, gVar.vJh, obj, 0, gVar.vJf);
            }
        }
        util.adN("user:" + j + " GetPicture data len:" + obj.length);
        return obj;
    }

    public final void hh(long j) {
        util.adN("user:" + j + " ClearUserSigInfo");
        this.vHK.i(Long.valueOf(j));
    }

    private int cJY() {
        synchronized (this) {
            Object iz = util.iz(this.mContext);
            if (iz == null || iz.length <= 0) {
                iz = util.is(this.mContext);
                if (iz == null || iz.length <= 0) {
                    iz = new String("%4;7t>;28<fc.5*6").getBytes();
                    this.vHK.vIL = 0;
                } else {
                    this.vHK.vIL = 1;
                }
                util.b(this.mContext, iz);
                this.vHK.vIK = 1;
                this.vHK.vIM = 1;
            } else {
                this.vHK.vIL = 1;
                this.vHK.vIK = 0;
                this.vHK.vIM = 0;
            }
            this.vHK.vIz = new byte[iz.length];
            System.arraycopy(iz, 0, this.vHK.vIz, 0, iz.length);
            Object obj = new byte[(iz.length + 1)];
            obj[0] = (byte) 35;
            System.arraycopy(iz, 0, obj, 1, iz.length);
            this.vHK.vIq = util.cf(obj);
            i.vIA = (byte[]) this.vHK.vIz.clone();
            this.vHK.vIB = util.it(this.mContext);
            int iv = util.iv(this.mContext);
            this.vHK.vIC = util.iu(this.mContext);
            if (iv != this.vHK.vIC) {
                util.iw(this.mContext);
                util.at(this.mContext, this.vHK.vIC);
            }
            this.vHK.vIE = util.ix(this.mContext).getBytes();
            this.vHK.vIN = util.iy(this.mContext);
            this.vHK.vID = util.iA(this.mContext);
            this.vHK.vIG = util.bV(this.mContext, new String(this.vHK.vID));
            this.vHK.vIH = util.bW(this.mContext, new String(this.vHK.vID));
            String str = Build.MODEL;
            if (str == null) {
                this.vHK.vII = new byte[0];
            } else {
                this.vHK.vII = str.getBytes();
            }
            if (util.isFileExist("/system/bin/su") || util.isFileExist("/system/xbin/su") || util.isFileExist("/sbin/su")) {
                iv = 1;
            } else {
                iv = 0;
            }
            i iVar = this.vHK;
            if (iv != 0) {
                iv = 1;
            } else {
                iv = 0;
            }
            iVar.vIJ = iv;
            str = VERSION.RELEASE;
            if (str == null) {
                str = "";
            }
            util.adN("WtloginHelper init ok: android version:" + str + " release time:" + util.cKp());
        }
        return 0;
    }
}
