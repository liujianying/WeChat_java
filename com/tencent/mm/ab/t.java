package com.tencent.mm.ab;

import android.os.Looper;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.model.av;
import com.tencent.mm.network.j;
import com.tencent.mm.network.q;
import com.tencent.mm.network.r.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.bkc;
import com.tencent.mm.protocal.c.sx;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.g;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.c;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.u;
import com.tencent.mm.protocal.u.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class t extends a {
    private q dJM;
    g dJZ;
    h dKa;
    ag handler;

    public t(q qVar) {
        this(qVar, Looper.myLooper() == null ? new ag(Looper.getMainLooper()) : new ag());
    }

    public t(q qVar, ag agVar) {
        this.dJM = qVar;
        this.dJZ = new s(qVar.KV(), qVar.getType());
        this.dKa = new u(qVar.Id(), qVar.getType());
        this.handler = agVar;
    }

    public final boolean KW() {
        return this.dJM.KW();
    }

    public final int Lb() {
        return this.dJM.hashCode();
    }

    public final int KP() {
        return this.dJM.KP();
    }

    public final g LC() {
        return this.dJZ;
    }

    public final h LD() {
        return this.dKa;
    }

    public final int getType() {
        return this.dJM.getType();
    }

    public final String getUri() {
        return this.dJM.getUri();
    }

    public final void kk(String str) {
    }

    public final void a(j jVar, final int i, final int i2, final String str) {
        this.handler.post(new Runnable() {
            public final void run() {
                x.d("MicroMsg.RemoteReqResp", "summerauth doAutoAuthEnd type:%d, stack[%s]", Integer.valueOf(t.this.dJM.getType()), bi.cjd());
                f fVar = (f) t.this.dJM.KV();
                i.g gVar = (i.g) t.this.dJM.Id();
                if (gVar == null) {
                    x.f("MicroMsg.RemoteReqResp", "null auth.resp");
                } else {
                    c.a.qWj.a(fVar, gVar, i, i2, str);
                }
            }
        });
    }

    public final void a(final j jVar, final int i, final int i2) {
        this.handler.post(new Runnable() {
            public final void run() {
                int i;
                int i2 = av.Ib().getInt("key_auth_update_version", 0);
                int i3 = i2 <= 637665332 ? HardCoderJNI.SCENE_SNS_SCROLL : HardCoderJNI.SCENE_ALBUM_SCROLL;
                if (i2 == 0) {
                    if (bi.oW(ad.getContext().getSharedPreferences("ticket_prefs", 4).getString("_auth_ticket", ""))) {
                        x.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth revise to autoauth");
                        com.tencent.mm.plugin.report.f.mDy.a(148, 50, 1, true);
                        i3 = HardCoderJNI.SCENE_ALBUM_SCROLL;
                    } else {
                        com.tencent.mm.plugin.report.f.mDy.a(148, 49, 1, true);
                        x.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth keep manual as old [%s]", bi.Xf(r13.getString("_auth_ticket", "")));
                    }
                }
                x.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth updateVersion:%d, clientVersion:%d WLOGIN_BUG_VERSION:%d, newAuthType:%d", Integer.valueOf(i2), Integer.valueOf(d.qVN), Integer.valueOf(637665332), Integer.valueOf(i3));
                if (i3 == HardCoderJNI.SCENE_SNS_SCROLL) {
                    com.tencent.mm.plugin.report.f.mDy.a(148, 48, 1, true);
                }
                if ((t.this.dJM.getType() == HardCoderJNI.SCENE_ALBUM_SCROLL || t.this.dJM.getType() == HardCoderJNI.SCENE_SNS_SCROLL) && ((i.g) t.this.dJM.Id()).djx == 2) {
                    i = 1;
                } else {
                    i = 0;
                }
                x.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth old type:%d new auth type:%d, reqFlag:%d", Integer.valueOf(t.this.dJM.getType()), Integer.valueOf(i3), Integer.valueOf(i));
                q aZ = c.a.qWj.aZ(i3, i);
                try {
                    jVar.a(aZ == null ? null : new t(aZ, t.this.handler), i, i2, "");
                } catch (Throwable e) {
                    x.e("MicroMsg.RemoteReqResp", "exception:%s", bi.i(e));
                }
            }
        });
    }

    public final void a(com.tencent.mm.network.d dVar, final j jVar, final int i, final int i2) {
        this.handler.post(new Runnable() {
            public final void run() {
                try {
                    jVar.a(new t(new k(), t.this.handler), i, i2, "");
                } catch (Throwable e) {
                    x.e("MicroMsg.RemoteReqResp", "exception:%s", bi.i(e));
                }
            }
        });
    }

    public final int LE() {
        int i = -1;
        x.d("MicroMsg.RemoteReqResp", "summerauth decodeAndRetriveAccInfo type:%d", Integer.valueOf(getType()));
        switch (getType()) {
            case 126:
                q qVar = this.dJM;
                u.a aVar = (u.a) qVar.KV();
                b bVar = (b) qVar.Id();
                x.i("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo type:%d, stack[%s]", Integer.valueOf(126), bi.cjd());
                if (bVar.djx != 0) {
                    x.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", Integer.valueOf(bVar.djx));
                } else {
                    bkc bkc = bVar.qWZ.rZo;
                    if (bkc != null) {
                        int i2 = bkc.reH;
                        sx sxVar = bkc.req;
                        byte[] a = ab.a(bkc.rer);
                        String str = "MicroMsg.MMReqRespReg2";
                        String str2 = "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s";
                        Object[] objArr = new Object[4];
                        objArr[0] = Integer.valueOf(sxVar.reV.siI);
                        objArr[1] = Integer.valueOf(sxVar.rwf);
                        objArr[2] = Integer.valueOf(a == null ? -1 : a.length);
                        objArr[3] = bi.Xf(bi.bB(a));
                        x.d(str, str2, objArr);
                        byte[] a2 = ab.a(sxVar.reV);
                        byte[] bArr = aVar.qWm;
                        byte[] bArr2 = null;
                        if (bi.bC(a2)) {
                            x.w("MicroMsg.MMReqRespReg2", "summerauth svr ecdh key is null!");
                        } else {
                            String str3 = "MicroMsg.MMReqRespReg2";
                            String str4 = "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s";
                            Object[] objArr2 = new Object[4];
                            objArr2[0] = Integer.valueOf(a2.length);
                            objArr2[1] = bi.Xf(bi.bB(a2));
                            objArr2[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                            objArr2[3] = bi.Xf(bi.bB(bArr));
                            x.d(str3, str4, objArr2);
                            PByteArray pByteArray = new PByteArray();
                            int computerKeyWithAllStr = MMProtocalJni.computerKeyWithAllStr(sxVar.rwf, a2, bArr, pByteArray, 0);
                            bArr2 = pByteArray.value;
                            str = "MicroMsg.MMReqRespReg2";
                            str2 = "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s";
                            objArr = new Object[3];
                            objArr[0] = Integer.valueOf(computerKeyWithAllStr);
                            objArr[1] = Integer.valueOf(bArr2 == null ? -1 : bArr2.length);
                            objArr[2] = bi.Xf(bi.bB(bArr2));
                            x.i(str, str2, objArr);
                        }
                        bVar.qWo = bArr2 != null ? bArr2 : new byte[0];
                        if ((i2 & 4) != 0) {
                            x.d("MicroMsg.MMReqRespReg2", "summerauth must decode session key");
                            if (bi.bC(bArr2)) {
                                x.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed as agreedECDHKey is null!");
                                bVar.bl(new byte[0]);
                                bVar.djx = 2;
                            } else {
                                bArr2 = MMProtocalJni.aesDecrypt(a, bArr2);
                                String str5 = "MicroMsg.MMReqRespReg2";
                                String str6 = "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s";
                                Object[] objArr3 = new Object[4];
                                objArr3[0] = Integer.valueOf(a == null ? -1 : a.length);
                                objArr3[1] = bi.bB(a);
                                if (bArr2 != null) {
                                    i = bArr2.length;
                                }
                                objArr3[2] = Integer.valueOf(i);
                                objArr3[3] = bi.Xf(bi.bB(bArr2));
                                x.d(str5, str6, objArr3);
                                if (bi.bC(bArr2)) {
                                    x.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed ret null!");
                                    bVar.bl(new byte[0]);
                                    bVar.djx = 2;
                                } else {
                                    x.d("MicroMsg.MMReqRespReg2", "summerauth decode session key succ session:%s", bi.Xf(bi.bB(bArr2)));
                                    bVar.bl(bArr2);
                                    bVar.djx = 1;
                                }
                            }
                        } else {
                            x.d("MicroMsg.MMReqRespReg2", "summerauth not need decode session key");
                            bVar.bl(a);
                            bVar.djx = 1;
                        }
                    } else {
                        x.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo sect null and decode failed!");
                        bVar.bl(new byte[0]);
                        bVar.djx = 2;
                    }
                }
                return bVar.djx;
            case HardCoderJNI.SCENE_SNS_SCROLL /*701*/:
            case HardCoderJNI.SCENE_ALBUM_SCROLL /*702*/:
                return av.b(this.dJM);
            default:
                return -1;
        }
    }
}
