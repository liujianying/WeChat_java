package com.tencent.mm.plugin.webview.ui.tools.a;

import android.os.Bundle;
import com.tencent.mm.g.a.ds;
import com.tencent.mm.g.a.dt;
import com.tencent.mm.g.a.du;
import com.tencent.mm.g.a.dv;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class b$a {
    private String bKC = "";
    public c nbf = new 5(this);
    private e pRY = null;
    public c qcU = new 3(this);
    public c qde = new 1(this);
    public c qdf = new 2(this);
    public c qdg = new 4(this);

    public b$a(e eVar, String str) {
        this.pRY = eVar;
        this.bKC = str;
    }

    final boolean h(b bVar) {
        if (bVar == null) {
            return false;
        }
        if (this.pRY == null) {
            x.e("MicroMsg.webview.WebViewExDeviceMgr", "callbacker is null");
            return false;
        }
        try {
            Bundle bundle;
            if (bVar instanceof dv) {
                x.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnScanDeviceResultEvent");
                dv dvVar = (dv) bVar;
                bundle = new Bundle();
                bundle.putString("exdevice_device_id", dvVar.bLG.byN);
                bundle.putByteArray("exdevice_broadcast_data", dvVar.bLG.bLy);
                bundle.putBoolean("exdevice_is_complete", dvVar.bLG.aoy);
                this.pRY.c(15, bundle);
            } else if (bVar instanceof du) {
                x.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnRecvDataFromDeviceEvent");
                du duVar = (du) bVar;
                if (bi.oW(duVar.bLF.byN) || bi.oW(duVar.bLF.bKC) || duVar.bLF.data == null) {
                    return true;
                }
                bundle = new Bundle();
                bundle.putString("exdevice_device_id", duVar.bLF.byN);
                bundle.putByteArray("exdevice_data", duVar.bLF.data);
                bundle.putString("exdevice_brand_name", duVar.bLF.bKC);
                this.pRY.c(16, bundle);
            } else if (bVar instanceof dt) {
                x.d("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnDeviceBindStateChangeEvent");
                dt dtVar = (dt) bVar;
                if (bi.oW(dtVar.bLE.byN)) {
                    return true;
                }
                bundle = new Bundle();
                bundle.putString("exdevice_device_id", dtVar.bLE.byN);
                bundle.putBoolean("exdevice_is_bound", dtVar.bLE.bKz);
                this.pRY.c(17, bundle);
            } else if (bVar instanceof lb) {
                lb lbVar = (lb) bVar;
                if (lbVar.bVp.op != 2) {
                    return true;
                }
                if (bi.oW(lbVar.bVp.bSJ) || !this.bKC.equals(lbVar.bVp.bSJ)) {
                    return true;
                }
                bundle = new Bundle();
                bundle.putString("exdevice_device_id", lbVar.bVp.byN);
                bundle.putInt("exdevice_on_state_change_state", lbVar.bVp.bLv);
                this.pRY.c(1004, bundle);
            } else if (bVar instanceof ds) {
                ds dsVar = (ds) bVar;
                bundle = new Bundle();
                if (dsVar.bLC.bLD == 12) {
                    bundle.putBoolean("exdevice_bt_state", true);
                } else {
                    bundle.putBoolean("exdevice_bt_state", false);
                }
                this.pRY.c(18, bundle);
            }
        } catch (Exception e) {
            x.w("MicroMsg.webview.WebViewExDeviceMgr", "exception in WVExDeviceEventListener callback, %s", new Object[]{e.getMessage()});
        }
        return true;
    }
}
