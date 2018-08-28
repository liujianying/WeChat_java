package com.tencent.mm.app.plugin.a;

import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.f;
import com.tencent.mm.g.a.cx;
import com.tencent.mm.g.a.dw;
import com.tencent.mm.g.a.jd;
import com.tencent.mm.g.a.qt;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class a {
    public com.tencent.mm.ui.chatting.c.a bAG;
    public b bAH;
    public a bAI;
    private String bAJ;
    public Map<String, Boolean> bAK;
    public boolean bAL = true;

    class a extends c<cx> {
        a() {
            this.sFo = cx.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            ((cx) bVar).bKs.bAL = a.this.bAL;
            return true;
        }
    }

    public a(com.tencent.mm.ui.chatting.c.a aVar) {
        x.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now init the event listener");
        this.bAG = aVar;
        if (this.bAH == null) {
            this.bAH = new b(this);
        }
        com.tencent.mm.sdk.b.a.sFg.b(this.bAH);
        if (this.bAI == null) {
            this.bAI = new a();
        }
        com.tencent.mm.sdk.b.a.sFg.b(this.bAI);
    }

    final synchronized void d(int i, String str, String str2) {
        x.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connect state : %d", new Object[]{Integer.valueOf(i)});
        if (this.bAG != null && !bi.oW(str)) {
            d kH = f.kH(str);
            if (a(kH)) {
                if (this.bAK == null) {
                    this.bAK = new HashMap();
                }
                Map map = this.bAK;
                if (!str.equals(this.bAJ)) {
                    this.bAJ = str;
                    map.clear();
                }
                if (kH.bG(false).Ms().dLz != 1) {
                    x.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "connDeviceIds : (%s) , deviceId : (%s)", new Object[]{map, str2});
                    switch (i) {
                        case -1:
                            this.bAG.tTq.setMMSubTitle(null);
                            break;
                        case 0:
                            if (map.size() == 0) {
                                this.bAG.tTq.setMMSubTitle(R.l.exdevice_device_status_none);
                                break;
                            }
                            break;
                        case 1:
                            if (map.size() == 0) {
                                this.bAG.tTq.setMMSubTitle(R.l.exdevice_device_status_connecting);
                                break;
                            }
                            break;
                        case 2:
                            map.put(str2, Boolean.valueOf(true));
                            this.bAG.tTq.setMMSubTitle(this.bAG.tTq.getString(R.l.exdevice_device_status_connected, new Object[]{Integer.valueOf(map.size())}));
                            x.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connected(deviceId : %s), set the tips gone", new Object[]{str2});
                            break;
                        case 4:
                            if (map.remove(str2) != null) {
                                x.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "disconnected(deviceId : %s) successfully.", new Object[]{str2});
                            }
                            this.bAG.tTq.setMMSubTitle(this.bAG.tTq.getString(R.l.exdevice_device_status_connected, new Object[]{Integer.valueOf(map.size())}));
                            break;
                    }
                }
                this.bAG.tTq.setMMSubTitle(null);
            } else {
                x.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "It's not a biz, brandName(%s).", new Object[]{str});
            }
        } else {
            x.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null or brandName is null or nil.");
        }
    }

    public final void a(final int i, d dVar) {
        if (this.bAG == null) {
            x.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "notifySwitchView, context is null, maybe has been released");
        } else if (s.hf(this.bAG.getTalkerUserName()) && a(dVar)) {
            au.Em().H(new Runnable() {
                public final void run() {
                    if (1 == i) {
                        dw dwVar = new dw();
                        dwVar.bLH.op = 0;
                        dwVar.bLH.userName = a.this.bAG.getTalkerUserName();
                        dwVar.bLH.context = a.this.bAG.tTq.getContext();
                        com.tencent.mm.sdk.b.a.sFg.m(dwVar);
                        if (a.this.bAG.getTalkerUserName().equals("gh_43f2581f6fd6")) {
                            qt qtVar = new qt();
                            qtVar.cbp.action = 1;
                            com.tencent.mm.sdk.b.a.sFg.a(qtVar, Looper.getMainLooper());
                        }
                    }
                    jd jdVar = new jd();
                    jdVar.bSI.opType = i;
                    jdVar.bSI.bSK = 1;
                    jdVar.bSI.bSJ = a.this.bAG.getTalkerUserName();
                    com.tencent.mm.sdk.b.a.sFg.m(jdVar);
                }
            });
        }
    }

    public static boolean a(d dVar) {
        if (dVar == null || dVar == null) {
            return false;
        }
        d.b bG = dVar.bG(false);
        if (bG == null || bG.Ms() == null || !bG.Ms().MC()) {
            return false;
        }
        return true;
    }
}
