package com.tencent.mm.plugin.webview.ui.tools.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.g.a.dn;
import com.tencent.mm.g.a.do;
import com.tencent.mm.g.a.dp;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.g.a.dt;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.eo;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements com.tencent.mm.pluginsdk.ui.tools.r.a {
    private static String DEVICE_TYPE = "lan";
    private static a qcQ;
    public String bKC;
    public boolean hasInit = false;
    public a qcP;
    public byte[] qcR = null;
    private int qcS = -1;
    public boolean qcT = false;

    public static class a {
        private String bKC = "";
        private e pRY = null;
        public c qcU = new c<dt>() {
            {
                this.sFo = dt.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                return a.this.h((dt) bVar);
            }
        };
        public c qcV = new 2(this);
        public c qcW = new c<do>() {
            {
                this.sFo = do.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                return a.this.h((do) bVar);
            }
        };
        public c qcX = new 4(this);
        public c qcY = new 5(this);

        public a(e eVar, String str) {
            this.pRY = eVar;
            this.bKC = str;
        }

        final boolean h(b bVar) {
            if (bVar == null) {
                return false;
            }
            if (this.pRY == null) {
                x.e("MicroMsg.webview.WebViewExDeviceLanMgr", "callbacker is null");
                return false;
            }
            try {
                Bundle bundle;
                if (bVar instanceof dt) {
                    x.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceOnDeviceBindStateChangeEvent");
                    dt dtVar = (dt) bVar;
                    if (bi.oW(dtVar.bLE.byN)) {
                        return true;
                    }
                    bundle = new Bundle();
                    bundle.putString("exdevice_device_id", dtVar.bLE.byN);
                    bundle.putBoolean("exdevice_is_bound", dtVar.bLE.bKz);
                    this.pRY.c(17, bundle);
                } else if (bVar instanceof dn) {
                    x.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceConnectStateEvent");
                    dn dnVar = (dn) bVar;
                    if (bi.oW(dnVar.bLu.byN) || !this.bKC.equals(dnVar.bLu.bKC)) {
                        return true;
                    }
                    bundle = new Bundle();
                    bundle.putString("exdevice_device_id", dnVar.bLu.byN);
                    bundle.putInt("exdevice_on_state_change_state", dnVar.bLu.bLv);
                    bundle.putString("exdevice_device_type", a.DEVICE_TYPE);
                    this.pRY.c(1004, bundle);
                } else if (bVar instanceof do) {
                    x.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceRecvDataEvent");
                    do doVar = (do) bVar;
                    if (bi.oW(doVar.bLw.byN) || bi.oW(doVar.bLw.bKC) || doVar.bLw.data == null) {
                        return true;
                    }
                    bundle = new Bundle();
                    bundle.putString("exdevice_device_id", doVar.bLw.byN);
                    bundle.putByteArray("exdevice_data", doVar.bLw.data);
                    bundle.putString("exdevice_brand_name", doVar.bLw.bKC);
                    bundle.putString("exdevice_device_type", a.DEVICE_TYPE);
                    this.pRY.c(16, bundle);
                } else if (bVar instanceof dp) {
                    x.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceScanResultEvent");
                    dp dpVar = (dp) bVar;
                    bundle = new Bundle();
                    bundle.putString("exdevice_device_id", dpVar.bLx.byN);
                    bundle.putByteArray("exdevice_broadcast_data", dpVar.bLx.bLy);
                    bundle.putBoolean("exdevice_is_complete", dpVar.bLx.aoy);
                    bundle.putBoolean("exdevice_is_lan_device", true);
                    bundle.putString("exdevice_device_type", a.DEVICE_TYPE);
                    this.pRY.c(15, bundle);
                } else if (bVar instanceof dq) {
                    x.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceStateChangeEvent");
                    dq dqVar = (dq) bVar;
                    bundle = new Bundle();
                    if (dqVar.bLz.bLA) {
                        bundle.putBoolean("exdevice_lan_state", true);
                    } else {
                        bundle.putBoolean("exdevice_lan_state", false);
                    }
                    this.pRY.c(47, bundle);
                }
            } catch (Exception e) {
                x.w("MicroMsg.webview.WebViewExDeviceLanMgr", "exception in WVExDeviceEventListener callback, %s", new Object[]{e.getMessage()});
            }
            return true;
        }
    }

    private a() {
    }

    public static a bWZ() {
        if (qcQ == null) {
            qcQ = new a();
        }
        return qcQ;
    }

    public final String getName() {
        return "WebViewExDeviceLanMgr";
    }

    public final void bXa() {
        x.i("MicroMsg.webview.WebViewExDeviceLanMgr", "stopPlugin, isScaning = %s", new Object[]{Boolean.valueOf(this.qcT)});
        if (this.qcT) {
            eo eoVar = new eo();
            eoVar.bMs.bKD = false;
            com.tencent.mm.sdk.b.a.sFg.m(eoVar);
            this.qcT = false;
        }
        this.hasInit = false;
        if (this.qcP != null) {
            com.tencent.mm.sdk.b.a.sFg.c(this.qcP.qcU);
            com.tencent.mm.sdk.b.a.sFg.c(this.qcP.qcV);
            com.tencent.mm.sdk.b.a.sFg.c(this.qcP.qcX);
            com.tencent.mm.sdk.b.a.sFg.c(this.qcP.qcW);
            com.tencent.mm.sdk.b.a.sFg.c(this.qcP.qcY);
            this.qcP = null;
        }
        this.qcR = null;
        dx dxVar = new dx();
        dxVar.bLI.bKD = false;
        com.tencent.mm.sdk.b.a.sFg.m(dxVar);
    }

    public final void ez(Context context) {
    }

    public final void bXb() {
    }
}
