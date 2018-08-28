package com.tencent.mm.model;

import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.ar;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.bup;
import com.tencent.mm.protocal.c.ec;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

public final class z {
    public static void a(bup bup, boolean z) {
        String bE;
        int i = bup.srM;
        String str = "MicroMsg.HandleAuthResponse";
        String str2 = "summerauth updateProfile succ update:%d unifyFlag:%d, auth:%s, acct:%s, network:%s autoauth:%b";
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(bup.srN == null ? -1 : bup.srN.reG);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = bup.srN;
        objArr[3] = bup.srO;
        objArr[4] = bup.srP;
        objArr[5] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        int i2 = 0;
        if ((i & 1) == 0 || bup.srN == null) {
            x.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set and new uin is 0!");
        } else {
            i2 = bup.srN.iwE;
        }
        g.Ek();
        g.gJ(i2);
        com.tencent.mm.storage.x DT = g.Ei().DT();
        DT.set(256, Boolean.valueOf(false));
        if ((i & 1) != 0) {
            if (bup.srN.reG > 0) {
                DT.a(a.sOv, Long.valueOf((long) bup.srN.reG));
                DT.a(a.sOx, Long.valueOf(bi.VE()));
                DT.a(a.sOw, Long.valueOf((long) d.qVN));
                x.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile need update flag[%d], autoauth[%b]", new Object[]{Integer.valueOf(bup.srN.reG), Boolean.valueOf(z)});
                if (z) {
                    long j;
                    f fVar = f.mDy;
                    if (bup.srN.reG == 2) {
                        j = 19;
                    } else {
                        j = 41;
                    }
                    fVar.a(148, j, 1, true);
                } else {
                    f.mDy.a(148, bup.srN.reG == 2 ? 10 : 11, 1, true);
                }
            } else {
                DT.a(a.sOv, Long.valueOf((long) bup.srN.reG));
                DT.a(a.sOx, Long.valueOf(bi.VE()));
                DT.a(a.sOw, Long.valueOf(0));
            }
        }
        if ((i & 2) != 0) {
            ar arVar = bup.srO;
            x.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect BindUin:%s, Status:%d, UserName:%s, NickName:%s, BindEmail:%s, BindMobile:%s, Alias:%s, PluginFlag:%d, RegType:%d, DeviceInfoXml:%s, SafeDevice:%d, OfficialUserName:%s, OfficialUserName:%s PushMailStatus:%d, FSURL:%s", new Object[]{o.getString(arVar.ray), Integer.valueOf(arVar.hcd), arVar.hbL, arVar.hcS, arVar.raz, arVar.raA, arVar.eJM, Integer.valueOf(arVar.raB), Integer.valueOf(arVar.raC), arVar.raD, Integer.valueOf(arVar.raE), arVar.raF, arVar.raF, Integer.valueOf(arVar.raH), arVar.raI});
            if (!z) {
                DT.set(52, Integer.valueOf(arVar.raC));
            }
            DT.set(9, Integer.valueOf(arVar.ray));
            DT.set(7, Integer.valueOf(arVar.hcd));
            DT.set(2, arVar.hbL);
            DT.set(4, arVar.hcS);
            DT.set(5, arVar.raz);
            DT.set(6, arVar.raA);
            DT.set(42, arVar.eJM);
            DT.set(34, Integer.valueOf(arVar.raB));
            g.Ei().DU().Zm(arVar.raD);
            DT.set(64, Integer.valueOf(arVar.raE));
            DT.set(21, arVar.raF);
            DT.set(22, arVar.raF);
            DT.set(17, Integer.valueOf(arVar.raH));
            at.dBv.T("login_weixin_username", arVar.hbL);
            at.dBv.T("last_login_nick_name", arVar.hcS);
            at.dBv.c(arVar.raA, arVar.ray, arVar.raz);
        } else {
            x.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect not set!");
        }
        boolean z2 = false;
        if ((i & 1) != 0) {
            boolean a;
            ec ecVar = bup.srN;
            String str3 = ecVar.reA;
            String bE2 = bi.bE(ab.a(ecVar.reB));
            x.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile AuthTicket:%s, NewVersion:%d, UpdateFlag:%d, AuthResultFlag:%d, authKey:%s a2Key:%s fsurl:%s", new Object[]{ecVar.reE, Integer.valueOf(ecVar.reF), Integer.valueOf(ecVar.reG), Integer.valueOf(ecVar.reH), bi.Xf(str3), bi.Xf(bE2), ecVar.raI});
            int i3 = ecVar.reu;
            o oVar = new o(bi.f((Integer) DT.get(9, Integer.valueOf(0))));
            str = "MicroMsg.HandleAuthResponse";
            str2 = "summerauth updateProfile wtBuffFlag:%d, bindQQ:%s buff len:%d";
            objArr = new Object[3];
            objArr[0] = Integer.valueOf(i3);
            objArr[1] = oVar;
            if (ecVar.rev == null) {
                i2 = -1;
            } else {
                i2 = ecVar.rev.siI;
            }
            objArr[2] = Integer.valueOf(i2);
            x.i(str, str2, objArr);
            if (i3 != 0) {
                if (i3 == 1) {
                    f.mDy.a(148, 20, 1, false);
                    a = g.Eg().Dp().a(oVar.longValue(), ab.a(ecVar.rev));
                    x.i("MicroMsg.HandleAuthResponse", "WTLoginRspBuff len %s", new Object[]{Integer.valueOf(r3.length)});
                    str = bi.bE(g.Eg().Dp().bb(oVar.longValue()));
                    DT.set(-1535680990, str3);
                    DT.set(46, bE2);
                    DT.set(72, str);
                    DT.set(29, ecVar.raI);
                } else if (i3 == 2) {
                    f.mDy.a(148, 21, 1, false);
                    g.Eg().Dp().bc(oVar.longValue());
                    bE = bi.bE(g.Eg().Dp().bb(oVar.longValue()));
                    DT.set(-1535680990, str3);
                    DT.set(46, bE2);
                    DT.set(72, bE);
                    DT.set(29, ecVar.raI);
                    a = false;
                } else {
                    x.i("MicroMsg.HandleAuthResponse", "summerauth undefined wrBuffFlag[%d]", new Object[]{Integer.valueOf(i3)});
                }
                x.i("MicroMsg.HandleAuthResponse", "wtBuffFlag %s", new Object[]{Integer.valueOf(i3)});
                if (ecVar.rew != null) {
                    str = bi.bE(ab.a(ecVar.rew.rhZ));
                    if (str != null && str.length() > 0) {
                        DT.set(47, str);
                        g.Ei().dqk.set(18, str);
                    }
                    x.i("MicroMsg.HandleAuthResponse", "updateProfile ksid:%s", new Object[]{bi.Xf(str)});
                }
                z2 = a;
            }
            a = false;
            x.i("MicroMsg.HandleAuthResponse", "wtBuffFlag %s", new Object[]{Integer.valueOf(i3)});
            if (ecVar.rew != null) {
                str = bi.bE(ab.a(ecVar.rew.rhZ));
                if (str != null && str.length() > 0) {
                    DT.set(47, str);
                    g.Ei().dqk.set(18, str);
                }
                x.i("MicroMsg.HandleAuthResponse", "updateProfile ksid:%s", new Object[]{bi.Xf(str)});
            }
            z2 = a;
        } else {
            x.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set!");
            f.mDy.a(148, 22, 1, false);
        }
        if ((i & 4) != 0) {
            f.mDy.a(148, 23, 1, false);
            avt avt = bup.srP;
            av.a(false, avt.rhK, avt.rhL, avt.rhJ);
        } else {
            x.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile networksect not set!");
        }
        if (z) {
            int i4 = 4;
            bE = q.GF();
            if (z2) {
                i4 = 1;
                bE = q.GE();
            }
            x.i("MicroMsg.HandleAuthResponse", "loginType %s", new Object[]{Integer.valueOf(i4)});
            com.tencent.mm.plugin.report.b.d.n(1, i4, bE);
        }
        DT.set(3, "");
        DT.set(19, "");
        DT.lm(true);
        g.Ei().dqk.setInt(46, 0);
        a.FK();
    }
}
