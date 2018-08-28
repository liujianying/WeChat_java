package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.axj;
import com.tencent.mm.protocal.c.zh;
import com.tencent.mm.protocal.c.zi;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class ad extends l implements k {
    private static final String[] qAp = new String[]{"wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b"};
    final String appId;
    private b diG;
    private e diJ;
    private final int efG = 3;

    public ad(String str) {
        this.appId = str;
        a aVar = new a();
        aVar.dIG = new zh();
        aVar.dIH = new zi();
        aVar.uri = "/cgi-bin/micromsg-bin/getappinfo";
        aVar.dIF = 231;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        if (this.appId == null || this.appId.length() == 0) {
            x.e("MicroMsg.NetSceneGetAppInfo", "doScene fail, appId is null");
            return -1;
        }
        zh zhVar = (zh) this.diG.dID.dIL;
        zhVar.jPc = this.appId;
        zhVar.ryb = this.efG;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetAppInfo", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 4 && i3 == -1011) {
            x.e("MicroMsg.NetSceneGetAppInfo", "errType = " + i2 + ", errCode = " + i3 + ", appinfo does not exist");
            com.tencent.mm.plugin.ac.a.bmf();
            f cbQ = i.cbQ();
            cbQ.field_appId = this.appId;
            com.tencent.mm.plugin.ac.a.bmf().a(cbQ);
            this.diJ.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            f fVar;
            zi ziVar = (zi) ((b) qVar).dIE.dIL;
            String str2 = ziVar.rFo.rbj;
            axj axj = ziVar.rFo;
            if (axj == null) {
                x.e("MicroMsg.NetSceneGetAppInfo", "convertToAppInfo : openAppInfo is null");
                fVar = null;
            } else {
                fVar = new f();
                fVar.field_appId = axj.jPc;
                fVar.field_appName = axj.jSv;
                fVar.field_appDiscription = axj.sas;
                fVar.field_appIconUrl = axj.rbh;
                fVar.field_appStoreUrl = axj.jPy;
                fVar.field_appVersion = axj.riv;
                fVar.field_appWatermarkUrl = axj.sat;
                fVar.field_packageName = axj.rbj;
                fVar.field_signature = p.Ta(axj.ris);
                fVar.field_appName_en = axj.sau;
                fVar.field_appName_tw = axj.saw;
                fVar.field_appDiscription_en = axj.sav;
                fVar.field_appDiscription_tw = axj.sax;
                fVar.field_appInfoFlag = axj.jPj;
                x.d("MicroMsg.NetSceneGetAppInfo", "appid = %s, appInfoFlag = %s", new Object[]{fVar.field_appId, Integer.valueOf(fVar.field_appInfoFlag)});
            }
            if (fVar == null) {
                x.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : info is null");
                this.diJ.a(3, -1, str, this);
                return;
            }
            fVar.field_appType = ziVar.rit;
            axj axj2 = ziVar.rFo;
            String str3 = axj2.rbj;
            String str4 = axj2.ris;
            Object obj = (str3 == null || str3.length() == 0 || str4 == null || str4.length() == 0) ? 1 : null;
            if (obj != null || fVar.aaq()) {
                x.e("MicroMsg.NetSceneGetAppInfo", "no android app, packageName = " + str2);
                com.tencent.mm.pluginsdk.ui.tools.b.TX(this.appId);
            }
            if (fVar.field_appId == null) {
                x.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : info.appId is null");
                this.diJ.a(3, -1, str, this);
            } else if (fVar.field_appId.equals(this.appId)) {
                i bmf = com.tencent.mm.plugin.ac.a.bmf();
                f SW = bmf.SW(this.appId);
                if (SW == null || SW.field_appId == null || SW.field_appId.length() == 0) {
                    fVar.field_status = obj != null ? 3 : 4;
                    fVar.field_modifyTime = System.currentTimeMillis();
                    if (fVar.field_appId != null) {
                        for (Object equals : qAp) {
                            if (fVar.field_appId.equals(equals)) {
                                fVar.field_status = -1;
                                break;
                            }
                        }
                    }
                    if (bmf.b(fVar)) {
                        com.tencent.mm.plugin.ac.a.bmd().cO(this.appId, 1);
                        com.tencent.mm.plugin.ac.a.bmd().cO(this.appId, 2);
                        com.tencent.mm.plugin.ac.a.bmd().cO(this.appId, 3);
                        com.tencent.mm.plugin.ac.a.bmd().cO(this.appId, 4);
                        com.tencent.mm.plugin.ac.a.bmd().cO(this.appId, 5);
                    } else {
                        x.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : insert fail");
                        this.diJ.a(3, -1, str, this);
                        return;
                    }
                }
                fVar.field_status = obj != null ? 3 : SW.field_status;
                if (fVar.field_appId != null) {
                    for (Object equals2 : qAp) {
                        if (fVar.field_appId.equals(equals2)) {
                            fVar.field_status = -1;
                            break;
                        }
                    }
                }
                if (SW == null) {
                    x.e("MicroMsg.NetSceneGetAppInfo", "merge failed, some appinfo is null");
                } else {
                    if (SW.cbJ()) {
                        if (!bi.oW(SW.field_appIconUrl)) {
                            fVar.field_appIconUrl = SW.field_appIconUrl;
                        }
                        if (!bi.oW(SW.field_appName)) {
                            fVar.field_appName = SW.field_appName;
                        }
                        if (!bi.oW(SW.field_appName_en)) {
                            fVar.field_appName_en = SW.field_appName_en;
                        }
                        if (!bi.oW(SW.field_appName_tw)) {
                            fVar.field_appName_tw = SW.field_appName_tw;
                        }
                        if (!bi.oW(SW.field_appName_hk)) {
                            fVar.field_appName_hk = SW.field_appName_hk;
                        }
                    }
                    if (bi.oW(fVar.field_appId) || bi.oW(SW.field_appId)) {
                        x.e("MicroMsg.NetSceneGetAppInfo", "merge failed, some appid is null");
                    } else if (fVar.field_appId.equalsIgnoreCase(SW.field_appId)) {
                        fVar.field_openId = SW.field_openId;
                        fVar.field_authFlag = SW.field_authFlag;
                        fVar.dg(SW.cmC);
                        fVar.dh(SW.cmD);
                        fVar.di(SW.cmE);
                    } else {
                        x.e("MicroMsg.NetSceneGetAppInfo", "merge failed, appis is different");
                    }
                }
                if (bmf.c(fVar, new String[0])) {
                    if (SW == null || SW.field_appIconUrl == null || SW.field_appIconUrl.length() == 0) {
                        obj = 1;
                    } else {
                        if (!bi.oW(fVar.cmW)) {
                            if (bi.oW(SW.cmW)) {
                                obj = 1;
                            } else if (!SW.cmW.equals(SW.cmW)) {
                                obj = 1;
                            }
                        }
                        if (!bi.oW(fVar.cmX)) {
                            if (bi.oW(SW.cmX)) {
                                obj = 1;
                            } else if (!SW.cmX.equals(SW.cmX)) {
                                obj = 1;
                            }
                        }
                        obj = (fVar.field_appIconUrl == null || fVar.field_appIconUrl.length() == 0) ? null : !SW.field_appIconUrl.equals(fVar.field_appIconUrl) ? 1 : null;
                    }
                    if (obj != null) {
                        com.tencent.mm.plugin.ac.a.bmd().cO(this.appId, 1);
                        com.tencent.mm.plugin.ac.a.bmd().cO(this.appId, 2);
                        com.tencent.mm.plugin.ac.a.bmd().cO(this.appId, 3);
                        com.tencent.mm.plugin.ac.a.bmd().cO(this.appId, 4);
                        com.tencent.mm.plugin.ac.a.bmd().cO(this.appId, 5);
                    }
                } else {
                    x.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : update fail");
                    this.diJ.a(3, -1, str, this);
                    return;
                }
                if (bi.oW(fVar.field_openId)) {
                    x.d("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd, openId is null, trigger getAppSetting, appId = " + fVar.field_appId);
                    com.tencent.mm.plugin.ac.a.bmh().pS(fVar.field_appId);
                }
                this.diJ.a(i2, i3, str, this);
            } else {
                x.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : appId is different");
                this.diJ.a(3, -1, str, this);
            }
        } else {
            x.e("MicroMsg.NetSceneGetAppInfo", "errType = " + i2 + ", errCode = " + i3);
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 231;
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }
}
