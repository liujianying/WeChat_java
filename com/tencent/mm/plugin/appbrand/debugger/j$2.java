package com.tencent.mm.plugin.appbrand.debugger;

import android.util.Log;
import android.webkit.JavascriptInterface;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.debugger.l.3;
import com.tencent.mm.plugin.appbrand.debugger.q.6;
import com.tencent.mm.plugin.appbrand.k.j.a;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.s.e.h;
import com.tencent.mm.protocal.c.cbd;
import com.tencent.mm.protocal.c.cbf;
import com.tencent.mm.protocal.c.cbk;
import com.tencent.mm.protocal.c.cbl;
import com.tencent.mm.protocal.c.cbp;
import com.tencent.mm.protocal.c.cbs;
import com.tencent.mm.protocal.c.cbt;
import com.tencent.mm.protocal.c.cbv;
import com.tencent.mm.protocal.c.cbw;
import com.tencent.mm.protocal.c.cbx;
import com.tencent.mm.protocal.c.cbz;
import com.tencent.mm.protocal.c.ccc;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Timer;

class j$2 implements a {
    final /* synthetic */ j fti;

    j$2(j jVar) {
        this.fti = jVar;
    }

    public final void a(h hVar) {
        x.i("MicroMsg.RemoteDebugJsEngine", "onSocketOpen");
        this.fti.ftb.fsG = System.currentTimeMillis();
        this.fti.ftb.fsS = 0;
        if (!bi.oW(this.fti.ftb.aeu())) {
            j.a(this.fti);
        }
        l lVar = this.fti.ftf;
        lVar.aeF();
        lVar.bno = new Timer();
        lVar.bno.schedule(new 3(lVar), 100, 1000);
    }

    public final void a(com.tencent.mm.plugin.appbrand.s.e.a aVar) {
    }

    public final void sl(String str) {
        x.i("MicroMsg.RemoteDebugJsEngine", "onSocketError message:%s ", new Object[]{str});
        this.fti.ftg.ss(str);
    }

    public final void sm(String str) {
        this.fti.ftb.fsG = System.currentTimeMillis();
    }

    public final void f(ByteBuffer byteBuffer) {
        this.fti.ftb.fsG = System.currentTimeMillis();
        try {
            cbd cbd = (cbd) new cbd().aG(c.k(byteBuffer));
            if (cbd.rwb == null) {
                x.w("MicroMsg.RemoteDebugJsEngine", "dataFormat.data is null");
                return;
            }
            byte[] bArr = cbd.rwb.lR;
            l lVar;
            switch (cbd.nc) {
                case TXLiveConstants.PUSH_EVT_CONNECT_SUCC /*1001*/:
                    p.a(this.fti.ftb, cbd, ((cbv) new cbv().aG(bArr)).sxO, this.fti.ftg, this.fti.ftf);
                    this.fti.ftb.fsG = System.currentTimeMillis();
                    break;
                case TXLiveConstants.PUSH_EVT_PUSH_BEGIN /*1002*/:
                    cbz cbz = (cbz) new cbz().aG(bArr);
                    j jVar = this.fti;
                    if (p.a(jVar.ftb, cbd, cbz.sxO, jVar.ftg, jVar.ftf)) {
                        x.i("MicroMsg.RemoteDebugJsEngine", "onLogin");
                        if (cbz.sxY != null) {
                            if (!cbz.sxY.sxG) {
                                x.i("MicroMsg.RemoteDebugJsEngine", "joinRoom");
                                jVar.ftb.setStatus(2);
                                cbw cbw = new cbw();
                                cbw.sxM = jVar.ftb.fsx;
                                cbw.sxH = jVar.ftb.fsC.fsV;
                                cbw.username = "";
                                cbw.sxX = jVar.ftb.fsC.fsW;
                                jVar.fte.a(p.a(TXLiveConstants.PUSH_EVT_OPEN_CAMERA_SUCC, cbw));
                                break;
                            }
                            jVar.ftb.fsB = cbz.sxY;
                            jVar.onReady();
                            break;
                        }
                        x.e("MicroMsg.RemoteDebugJsEngine", "onLogin room info is null");
                        break;
                    }
                    break;
                case TXLiveConstants.PUSH_EVT_OPEN_CAMERA_SUCC /*1003*/:
                    if (p.a(this.fti.ftb, cbd, ((cbx) new cbx().aG(bArr)).sxO, this.fti.ftg, this.fti.ftf)) {
                        j jVar2 = this.fti;
                        WxaPkgWrappingInfo abP = WxaCommLibRuntimeReader.abP();
                        cbt cbt = new cbt();
                        cbf cbf = new cbf();
                        cbt.sxS = cbf;
                        cbt.sxT = jVar2.fcy.aeI();
                        cbt.sxV = jVar2.fcy.fdO.fcu.frm.bKg;
                        cbt.sxW = 1;
                        String qJ = WxaCommLibRuntimeReader.qJ("WAService.js");
                        if (!bi.oW(qJ)) {
                            cbt.sxU = g.u(qJ.getBytes());
                        }
                        cbf.sxu = abP.fii;
                        cbf.sxr = d.qVI;
                        cbf.sxq = d.DEVICE_NAME;
                        cbf.sxt = e.aj(jVar2.ftd, d.qVN);
                        cbf.sxs = d.qVL;
                        cbf.sxw = jVar2.ftd.getResources().getDisplayMetrics().density;
                        cbf.sxv = ((float) jVar2.ftd.getResources().getDisplayMetrics().widthPixels) / cbf.sxw;
                        cbf.sxx = jVar2.fcy.fdO.fcz.getCurrentPage().getCurrentPageView().gns.getUserAgentString();
                        cbp cbp = new cbp();
                        l lVar2 = jVar2.ftf;
                        cbp.sxk = "WeixinJSCore";
                        lVar2.ftb.fsM.clear();
                        for (Method method : lVar2.fdP.getClass().getMethods()) {
                            if (method.isAnnotationPresent(JavascriptInterface.class)) {
                                Class[] parameterTypes = method.getParameterTypes();
                                if (parameterTypes.length > 5) {
                                    x.e("MicroMsg.RemoteDebugMsgMrg", "Interface method only support five arguments!");
                                } else {
                                    cbl cbl = new cbl();
                                    cbl.sxl = method.getName();
                                    for (Class cls : parameterTypes) {
                                        if (cls == String.class) {
                                            cbl.sxm.add("String");
                                        } else if (cls == Integer.TYPE || cls == Integer.class) {
                                            cbl.sxm.add("Number");
                                        } else if (cls == Boolean.TYPE || cls == Boolean.class) {
                                            cbl.sxm.add("Boolean");
                                        } else {
                                            cbl.sxm.add("Unknown");
                                        }
                                    }
                                    cbp.sxF.add(cbl);
                                    lVar2.ftb.fsM.put(cbl.sxl, cbl);
                                    lVar2.ftb.fsL.put(method.getName(), method);
                                }
                            }
                        }
                        cbt.sxR = cbp;
                        jVar2.ftf.a(p.a(cbt, jVar2.ftb, "setupContext"));
                        x.d("MicroMsg.RemoteDebugJsEngine", "setupContext %s/%s/%d, %s", new Object[]{cbt.sxU, cbt.sxV, Integer.valueOf(cbf.sxu), cbf.sxx});
                        break;
                    }
                    break;
                case TXLiveConstants.PUSH_EVT_SCREEN_CAPTURE_SUCC /*1004*/:
                    l lVar3 = this.fti.ftf;
                    x.i("MicroMsg.RemoteDebugMsgMrg", "onQuit");
                    lVar3.ftb.setStatus(4);
                    lVar3.fte.sp("quit");
                    q qVar = lVar3.ftg;
                    qVar.aeN();
                    ah.A(new 6(qVar));
                    break;
                case TXLiveConstants.PUSH_EVT_CHANGE_RESOLUTION /*1005*/:
                    ccc ccc = (ccc) new ccc().aG(bArr);
                    lVar = this.fti.ftf;
                    x.d("MicroMsg.RemoteDebugMsgMrg", "onSync");
                    if (p.a(lVar.ftb, cbd, ccc.sxO, lVar.ftg, lVar)) {
                        lVar.r(ccc.sxB);
                        lVar.ftb.jY(ccc.syb);
                        lVar.aeE();
                        break;
                    }
                    break;
                case TXLiveConstants.PUSH_EVT_CHANGE_BITRATE /*1006*/:
                    cbs cbs = (cbs) new cbs().aG(bArr);
                    lVar = this.fti.ftf;
                    if (p.a(lVar.ftb, cbd, cbs.sxO, lVar.ftg, lVar)) {
                        x.d("MicroMsg.RemoteDebugMsgMrg", "onSendMsgResult %d/%d", new Object[]{Integer.valueOf(cbs.sxP), Integer.valueOf(cbs.sxQ)});
                        lVar.ftb.bE(cbs.sxP, cbs.sxQ);
                        lVar.bG(cbs.sxP, cbs.sxQ);
                    }
                    m.a(cbd, (g) this.fti.ftb.fsP.get(cbd.fMk));
                    break;
                case TXLiveConstants.PLAY_EVT_PLAY_END /*2006*/:
                    this.fti.ftf.r(((cbk) new cbk().aG(bArr)).sxB);
                    break;
                case 3001:
                    this.fti.onReady();
                    break;
                case 3002:
                    this.fti.ftb.setStatus(4);
                    this.fti.ftf.quit();
                    break;
            }
            x.i("MicroMsg.RemoteDebugJsEngine", "onSocketMessage cmd: %d", new Object[]{Integer.valueOf(cbd.nc)});
        } catch (Throwable th) {
            x.e("MicroMsg.RemoteDebugJsEngine", "onSocketMessage %s", new Object[]{Log.getStackTraceString(th)});
        }
    }

    public final void C(int i, String str) {
        int i2 = 1;
        x.i("MicroMsg.RemoteDebugJsEngine", "onSocketClose code:%d reason:%s ", new Object[]{Integer.valueOf(i), str});
        if (!this.fti.fcy.fEH) {
            h hVar = this.fti.ftb;
            if (hVar.aey() || ((long) hVar.fsS) >= 10) {
                i2 = 0;
            }
            if (i2 != 0) {
                com.tencent.mm.plugin.appbrand.r.c.Em().h(new 1(this), 1000);
                h hVar2 = this.fti.ftb;
                hVar2.fsS++;
            }
            this.fti.ftf.aeF();
            this.fti.ftb.fsG = System.currentTimeMillis();
            this.fti.ftg.aeN();
            this.fti.ftb.setStatus(5);
            this.fti.ftg.ss(str);
        }
    }

    public final void sn(String str) {
        x.i("MicroMsg.RemoteDebugJsEngine", "onSocketConnectFail reason:%s ", new Object[]{str});
    }
}
