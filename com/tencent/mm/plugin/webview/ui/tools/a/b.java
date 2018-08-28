package com.tencent.mm.plugin.webview.ui.tools.a;

import android.content.Context;
import com.tencent.mm.g.a.dy;
import com.tencent.mm.g.a.ee;
import com.tencent.mm.pluginsdk.ui.tools.r.a;
import com.tencent.mm.sdk.platformtools.x;

public final class b implements a {
    private static final byte[] ivK = new byte[]{(byte) -2, (byte) 1, (byte) 1};
    private static b qdb;
    public String bKC;
    public boolean hasInit = false;
    public byte[] qcR = null;
    public boolean qcT = false;
    public a qda;
    public int qdc = -1;
    public boolean qdd = false;

    private b() {
    }

    public static b bXc() {
        if (qdb == null) {
            qdb = new b();
        }
        return qdb;
    }

    public final String getName() {
        return "WebViewExDeviceMgr";
    }

    public final void bXa() {
        x.i("MicroMsg.webview.WebViewExDeviceMgr", "stopPlugin, isScaning = %s", new Object[]{Boolean.valueOf(this.qcT)});
        if (this.qcT) {
            dy dyVar = new dy();
            dyVar.bLJ.bKD = false;
            dyVar.bLJ.bKC = this.bKC;
            com.tencent.mm.sdk.b.a.sFg.m(dyVar);
            if (!dyVar.bLK.bKE) {
                x.e("MicroMsg.webview.WebViewExDeviceMgr", "stopScanWXDevice fail");
            }
            this.qcT = false;
        }
        this.hasInit = false;
        if (this.qda != null) {
            com.tencent.mm.sdk.b.a.sFg.c(this.qda.qde);
            com.tencent.mm.sdk.b.a.sFg.c(this.qda.qdf);
            com.tencent.mm.sdk.b.a.sFg.c(this.qda.qdg);
            com.tencent.mm.sdk.b.a.sFg.c(this.qda.qcU);
            com.tencent.mm.sdk.b.a.sFg.c(this.qda.nbf);
            this.qda = null;
        }
        this.qcR = null;
        ee eeVar = new ee();
        eeVar.bMa.byN = "";
        eeVar.bMa.direction = 0;
        eeVar.bMa.clear = true;
        com.tencent.mm.sdk.b.a.sFg.m(eeVar);
        x.i("MicroMsg.webview.WebViewExDeviceMgr", "stop EcDeviceMgr for webview %s", new Object[]{Boolean.valueOf(eeVar.bMb.bKE)});
    }

    public static boolean be(byte[] bArr) {
        if (bArr != null && bArr.length >= 9 && bArr[bArr.length - 7] == (byte) 1 && bArr[bArr.length - 8] == (byte) 1 && bArr[bArr.length - 9] == (byte) -2) {
            return true;
        }
        return false;
    }

    public final void ez(Context context) {
    }

    public final void bXb() {
    }
}
