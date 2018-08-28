package com.tencent.mm.ab;

import com.tencent.mm.platformtools.af;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.b;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.util;

public final class x {
    private b dKw = null;
    private long dKx = 0;

    class a extends oicq.wlogin_sdk.tools.b {
        public final void s(int i, String str) {
            OnLog(i, "", str);
        }

        public final void OnLog(int i, String str, String str2) {
            if (i == 1) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WtloginMgr.Core", "[%s]%s", str, str2);
            } else if (i == 2) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WtloginMgr.Core", "[%s]%s", str, str2);
            } else if (i == 0) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WtloginMgr.Core", "[%s]%s", str, str2);
            }
        }
    }

    public x() {
        try {
            long VF = bi.VF();
            this.dKw = new b(ad.getContext(), d.qVN);
            util.vKe = 1;
            util.vKf = new a();
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WtloginMgr", "dkstart wtlogin init :%d", Long.valueOf(bi.bH(VF)));
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.WtloginMgr", e, "Failed initializing WtloginMgr.", new Object[0]);
        }
    }

    public final byte[] a(long j, String str, boolean z) {
        String str2 = "MicroMsg.WtloginMgr";
        String str3 = "dkwt isTestWtLogin:%b val:%d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(af.exm == 10006);
        objArr[1] = Integer.valueOf(af.exn);
        com.tencent.mm.sdk.platformtools.x.d(str2, str3, objArr);
        if (af.exm == 10006) {
            if (af.exn == 1) {
                af.exn = 0;
                return new byte[0];
            } else if (af.exn == 2) {
                return new byte[0];
            }
        }
        try {
            boolean z2;
            this.dKx = j;
            byte[] a = z ? null : this.dKw.a(j, oicq.wlogin_sdk.request.b.a.USER_WITH_A1, "");
            str3 = "MicroMsg.WtloginMgr";
            String str4 = "dkwt getReqLoginBuf sig:%d uin:%d manualauth:%b  byA1Buf:%b ";
            Object[] objArr2 = new Object[4];
            objArr2[0] = Integer.valueOf(8256);
            objArr2[1] = Long.valueOf(j);
            objArr2[2] = Boolean.valueOf(z);
            if (bi.bC(a)) {
                z2 = false;
            } else {
                z2 = true;
            }
            objArr2[3] = Boolean.valueOf(z2);
            com.tencent.mm.sdk.platformtools.x.d(str3, str4, objArr2);
            if (bi.bC(a)) {
                return this.dKw.a(j, oicq.wlogin_sdk.request.b.a.USER_WITH_MD5, new String(bi.WP(str), "ISO-8859-1"));
            }
            return a;
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBuf e:%s", e.getMessage());
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WtloginMgr", "exception:%s", bi.i(e));
            return new byte[0];
        }
    }

    public final boolean a(long j, byte[] bArr) {
        if (j != this.dKx) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.dKx), Long.valueOf(j));
            return false;
        } else if (bi.bC(bArr)) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf respBuf is null.");
            return false;
        } else {
            try {
                int i;
                b bVar = this.dKw;
                if (bArr == null || bArr.length == 0 || bVar.vHQ == null) {
                    i = -1017;
                } else {
                    util.adN("user:" + bVar.vHK._uin + " ResolveSvrData ...");
                    i = bVar.vHQ.X(bArr, bArr.length);
                    if (i == 1) {
                        bVar.hh(bVar.vHK._uin);
                    }
                    util.adN("user:" + bVar.vHK._uin + " ResolveSvrData ret=" + i);
                }
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf buflen:%d ret:%d", Integer.valueOf(bArr.length), Integer.valueOf(i));
                if (i == 0) {
                    return true;
                }
                return false;
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf e:%s", e.getMessage());
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WtloginMgr", "exception:%s", bi.i(e));
                return false;
            }
        }
    }

    public final byte[] ba(long j) {
        if (j != this.dKx) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WtloginMgr", "dkwt getVerifyImg Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.dKx), Long.valueOf(j));
            return new byte[0];
        }
        try {
            return this.dKw.hg(j);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WtloginMgr", "dkwt getVerifyImg e:%s", e.getMessage());
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WtloginMgr", "exception:%s", bi.i(e));
            return new byte[0];
        }
    }

    public final byte[] c(long j, String str) {
        if (j != this.dKx) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.dKx), Long.valueOf(j));
            return new byte[0];
        }
        byte[] bytes;
        if (bi.oW(str)) {
            bytes = "****".getBytes();
        } else {
            bytes = str.getBytes();
        }
        try {
            return this.dKw.f(j, bytes);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg e:%s", e.getMessage());
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WtloginMgr", "exception:%s", bi.i(e));
            return new byte[0];
        }
    }

    public final byte[] bb(long j) {
        if (j != this.dKx) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.dKx), Long.valueOf(j));
            return new byte[0];
        }
        try {
            WUserSigInfo wUserSigInfo;
            WloginSigInfo hj = this.dKw.vHK.hj(j);
            if (hj == null) {
                wUserSigInfo = null;
            } else {
                wUserSigInfo = new WUserSigInfo();
                wUserSigInfo.get_clone(hj);
            }
            return wUserSigInfo == null ? new byte[0] : wUserSigInfo._A2;
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf e:%s", e.getMessage());
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WtloginMgr", "exception:%s", bi.i(e));
            return new byte[0];
        }
    }

    public final void bc(long j) {
        if (j != this.dKx) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.dKx), Long.valueOf(j));
            return;
        }
        try {
            this.dKw.hh(j);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo e:%s", e.getMessage());
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WtloginMgr", "exception:%s", bi.i(e));
        }
    }
}
