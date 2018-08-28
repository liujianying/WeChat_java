package com.tencent.mm.modelmulti;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.f;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.s;
import com.tencent.mm.protocal.s.b;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.Map;

public final class c extends l implements k {
    protected static int selector = 7;
    private String Yy;
    private al dHa;
    private int dYV;
    private a dYW;
    private StringBuilder dYX;
    private long dYY;
    private boolean dYZ;
    private e diJ;
    private int errCode;
    private int errType;

    public c() {
        this.errType = 0;
        this.errCode = 0;
        this.Yy = "";
        this.dYV = 0;
        this.dYX = new StringBuilder();
        this.dYY = -1;
        this.dYZ = false;
        x.d("MicroMsg.NetPushSync", "dksord NetSceneSync hash:%d stack:%s", new Object[]{Integer.valueOf(hashCode()), bi.cjd()});
        this.dYW = new a();
        this.dYX.append("stack:" + bi.cjd() + " time:" + bi.VE());
    }

    public c(final b bVar, int i, long j) {
        this();
        this.dYV = i;
        this.dYY = j;
        x.d("MicroMsg.NetPushSync", "dkpush do scene resp SCENE_SYNC_WAIT");
        this.dHa = new al(aa.Vc(), new al.a() {
            public final boolean vD() {
                c.this.dYZ = true;
                int i = 0;
                c.this.a(-1, 0, i, "", new a(bVar), null);
                return false;
            }
        }, false);
    }

    public final String getInfo() {
        return this.dYX.toString();
    }

    protected final int Cc() {
        return 500;
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    public final boolean KY() {
        return super.KY();
    }

    public final int getType() {
        return 138;
    }

    protected final void cancel() {
        super.cancel();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        boolean z = false;
        this.diJ = eVar2;
        this.dYX.append(" lastd:" + this.dIY + " dotime:" + bi.VE() + " net:" + ao.getNetType(ad.getContext()));
        String str = "MicroMsg.NetPushSync";
        String str2 = "doScene[%d] selector:%d pusher:%b ";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Integer.valueOf(selector);
        if (this.dHa != null) {
            z = true;
        }
        objArr[2] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (this.dHa != null) {
            c(eVar);
            this.dHa.J(0, 0);
            this.dHa = null;
            return -1;
        }
        a aVar = new a();
        aVar.uin = aa.UZ().esl.Df();
        awd awd = ((s.a) aVar.KV()).qWW;
        awd.rnx = selector;
        awd.rny = ab.O(bi.WP(ad.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", "")));
        awd.otY = 1;
        awd.rZv = new pn();
        awd.reT = d.DEVICE_TYPE;
        return a(eVar, aVar, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        String str2;
        String str3;
        if (qVar == null || qVar.getType() != 138) {
            int i4;
            str2 = "MicroMsg.NetPushSync";
            str3 = "onGYNetEnd error type:%d";
            Object[] objArr = new Object[1];
            if (qVar == null) {
                i4 = -2;
            } else {
                i4 = qVar.getType();
            }
            objArr[0] = Integer.valueOf(i4);
            x.e(str2, str3, objArr);
            return;
        }
        Object obj;
        this.dYX.append(" endtime:" + bi.VE());
        x.i("MicroMsg.NetPushSync", "onGYNetEnd: %d [%d,%d,%s] hash isnotifydata:%b time:%d [%s]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(this.dYZ), Long.valueOf(this.dYW.Ad()), this.dYX});
        if (i2 == 4 && i3 == -2006) {
            i2 = 0;
            i3 = 0;
            obj = 1;
        } else {
            obj = null;
        }
        if (i2 == 0 && i3 == 0) {
            String str4;
            String str5;
            byte[] WP;
            int size;
            int i5;
            b bVar = (b) qVar.Id();
            if (obj == null) {
                byte[] a = ab.a(((s.a) qVar.KV()).qWW.rny);
                str4 = "MicroMsg.NetPushSync";
                str5 = "dkpush req Key : %d[%s]";
                Object[] objArr2 = new Object[2];
                objArr2[0] = Integer.valueOf(a == null ? -1 : a.length);
                objArr2[1] = bi.bB(a);
                x.d(str4, str5, objArr2);
                if (bi.bC(a)) {
                    WP = bi.WP(ad.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", ""));
                    x.d("MicroMsg.NetPushSync", "dkpush userinfo key : %d[%s]", new Object[]{Integer.valueOf(WP.length), bi.bB(WP)});
                } else {
                    WP = a;
                }
                a = ab.a(bVar.qWX.rny);
                WP = z.g(WP, a);
                if (WP == null || WP.length <= 0) {
                    x.w("MicroMsg.NetPushSync", "merge key failed, use server side instead");
                    WP = a;
                }
                bVar.qWX.rny = ab.O(WP);
                size = (bVar.qWX.rnB == null || bVar.qWX.rnB.hbG == null) ? 0 : bVar.qWX.rnB.hbG.size();
                x.i("MicroMsg.NetPushSync", "newMsgSize:%d", new Object[]{Integer.valueOf(size)});
                str4 = "MicroMsg.NetPushSync";
                str5 = "newMsgSize:%d, mergeKey: %d[%s]";
                objArr2 = new Object[3];
                objArr2[0] = Integer.valueOf(size);
                objArr2[1] = Integer.valueOf(WP == null ? -1 : WP.length);
                objArr2[2] = bi.bB(WP);
                x.d(str4, str5, objArr2);
            }
            Iterator it = bVar.qWX.rnB.hbG.iterator();
            Object obj2 = null;
            while (it.hasNext()) {
                pm pmVar = (pm) it.next();
                if (pmVar.rtM == 5) {
                    WP = ab.a(pmVar.rtN);
                    try {
                        by byVar = new by();
                        byVar.aG(WP);
                        str3 = "MicroMsg.NetPushSync";
                        str4 = "oreh msgType:%d, talker:%s, newmsgID:%d, pushContent.len:%d, content.len:%d";
                        Object[] objArr3 = new Object[5];
                        objArr3[0] = Integer.valueOf(byVar.jQd);
                        objArr3[1] = byVar.rcj.siM;
                        objArr3[2] = Long.valueOf(byVar.rcq);
                        objArr3[3] = Integer.valueOf(byVar.rcp == null ? 0 : byVar.rcp.length());
                        objArr3[4] = Integer.valueOf(byVar.rcl.siM == null ? 0 : byVar.rcl.siM.length());
                        x.i(str3, str4, objArr3);
                        i5 = byVar.jQd;
                        str3 = byVar.rcj.siM;
                        str4 = byVar.rcl.siM;
                        if (i5 == 50) {
                            x.i("MicroMsg.NetPushSync", "hit voip");
                            obj = 1;
                        } else {
                            if (bi.oW(str4) || bi.oW(str3)) {
                                x.w("MicroMsg.NetPushSync", "check should launch to mm ,content or from username is null.");
                            } else if (i5 == 9998 && str3.equalsIgnoreCase("weixin")) {
                                x.i("MicroMsg.NetPushSync", "hit ipxx");
                                obj = 1;
                            } else if (i5 == 10002 && str4.contains("revokemsg")) {
                                x.i("MicroMsg.NetPushSync", "hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
                                obj = 1;
                            }
                            obj = null;
                        }
                        if (obj != null) {
                            obj2 = 1;
                        } else {
                            long j = byVar.rcq;
                            str5 = byVar.rcj.siM;
                            str2 = byVar.rcp;
                            int i6 = byVar.jQd;
                            if (bi.oW(str2)) {
                                x.i("MicroMsg.NetPushSync", "showNotifyCation pushContent is null, skip");
                            } else {
                                PString pString = new PString();
                                PString pString2 = new PString();
                                str2 = bi.WT(str2);
                                int indexOf = str2.indexOf("<pushcontent");
                                if (indexOf > 0) {
                                    str2 = str2.substring(indexOf);
                                }
                                Map z = bl.z(str2, "pushcontent");
                                if (z == null) {
                                    x.e("MicroMsg.NetPushSync", "inval xml");
                                } else {
                                    pString.value = (String) z.get(".pushcontent.$content");
                                    pString2.value = (String) z.get(".pushcontent.$nickname");
                                }
                                PluginZero pluginZero = (PluginZero) g.n(PluginZero.class);
                                if (pluginZero.qxH != null) {
                                    pluginZero.qxH.a(j, str5, pString2.value, pString.value, (com.tencent.mm.compatible.util.e.duM + com.tencent.mm.a.g.u(("mm" + aa.UZ().esl.Df()).getBytes())) + "/avatar/", i6);
                                }
                            }
                            if ((byVar.jQd == 10002 ? 1 : null) != null) {
                                x.i("MicroMsg.NetPushSync", "need remove pushContent");
                                byVar.rcp = null;
                                pmVar.rtN = ab.O(byVar.toByteArray());
                            }
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.NetPushSync", e, "", new Object[0]);
                    }
                }
            }
            try {
                WP = bVar.qWX.toByteArray();
                size = aa.UZ().esl.Df();
                str4 = f.fo(size);
                int eC = f.eC(str4) + 1;
                String str6 = str4 + "/syncResp.bin" + eC;
                byte[] b = com.tencent.mm.a.k.b(WP, com.tencent.mm.a.g.u((com.tencent.mm.compatible.e.q.zy() + size).getBytes()).getBytes());
                x.i("MicroMsg.NotifySyncMgr", "writeFile %d, len:%d, resultLen:%d, file:%s, dump %s -> %s, key:%s", new Object[]{Integer.valueOf(eC), Integer.valueOf(WP.length), Integer.valueOf(b.length), str6, f.D(WP), f.D(b), f.D(str3.getBytes())});
                if (bi.bC(b)) {
                    x.e("MicroMsg.NotifySyncMgr", "encry failed");
                } else {
                    i5 = com.tencent.mm.a.e.b(str6, b, b.length);
                    boolean cn = com.tencent.mm.a.e.cn(str6);
                    if (i5 == 0 && cn) {
                        WP = String.valueOf(eC).getBytes();
                        com.tencent.mm.a.e.b(str4 + "/syncResp.ini", WP, WP.length);
                    } else {
                        x.e("MicroMsg.NotifySyncMgr", "writeFile failed:!!!!!, writeResult:%d, writedFileExit:%b", new Object[]{Integer.valueOf(i5), Boolean.valueOf(cn)});
                    }
                }
            } catch (Throwable e2) {
                x.e("MicroMsg.NetPushSync", "write syncResp buf err:%s", new Object[]{e2});
                x.printErrStackTrace("MicroMsg.NetPushSync", e2, "", new Object[0]);
            }
            x.d("MicroMsg.NetPushSync", "onRespHandled sync");
            ad.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", bi.bE(ab.a(bVar.qWX.rny))).commit();
            x.d("MicroMsg.NetPushSync", "dkpush pushSyncFlag:%d", new Object[]{Integer.valueOf(this.dYV)});
            if (obj2 == null) {
                obj = ((bVar.qWX.rlm & selector) == 0 || super.KY()) ? null : 1;
                x.i("MicroMsg.NetPushSync", "continue flag=" + bVar.qWX.rlm + ", selector=" + selector + ", limit reach=" + super.KY());
                if (obj != null) {
                    a(this.dIX, this.diJ);
                    if (obj2 != null) {
                        CoreService.xw();
                        return;
                    }
                    return;
                }
            }
            if ((this.dYV & 1) > 0) {
                x.i("MicroMsg.NetPushSync", "oreh NotifyData ack");
                new g(this.dYY, ab.a(bVar.qWX.rny), aa.UZ().esl.Df()).a(aa.UZ(), new 2(this));
            }
            this.diJ.a(this.errType, this.errCode, this.Yy, this);
            if (obj2 != null) {
                CoreService.xw();
                return;
            }
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
