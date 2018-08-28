package com.tencent.mrs.a;

import android.text.TextUtils;
import com.tencent.mars.app.AppLogic;
import com.tencent.matrix.d.b;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.matrix.mrs.core.MrsCallback;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mrs.a.c.AnonymousClass2;
import java.util.HashMap;
import java.util.Iterator;

public final class a implements MrsCallback {
    private HashMap<String, Boolean> uZS = new HashMap();

    public final void onMrsReportDataReady(byte[] bArr) {
        b.i("Matrix.MrsCallbackImp", "onMrsReportDataReady, try to report mars", new Object[0]);
        if (bArr == null) {
            b.e("Matrix.ReportMrsUpload", "report mrs date is null", new Object[0]);
        } else {
            e.post(new AnonymousClass2(bArr), "ReportMrsUpload");
        }
    }

    public final boolean onRequestGetMrsStrategy(byte[] bArr) {
        try {
            if (g.Eg().Dx()) {
                synchronized (this) {
                    if (b.isRunning()) {
                        x.i("Matrix.MrsCallbackImp", "NetSceneGetMrsStrategy is already running, just return");
                        return false;
                    }
                    x.i("Matrix.MrsCallbackImp", "onRequestGetMrsStrategy, try to request mrs strategy");
                    g.Eh().dpP.a(new b(bArr), 0);
                    return true;
                }
            }
            x.e("Matrix.MrsCallbackImp", "onRequestGetMrsStrategy, account not ready");
            return false;
        } catch (Exception e) {
            x.e("Matrix.MrsCallbackImp", "error: " + e.getMessage());
            return false;
        }
    }

    public final void onStrategyNotify(String str, boolean z) {
        b.i("Matrix.MrsCallbackImp", "onStrategyNotify, strategy: %s, isReportProcess; %b", str, Boolean.valueOf(z));
        if (!com.tencent.matrix.a.isInstalled() || !MatrixReport.isInstalled()) {
            return;
        }
        if (MatrixReport.with().isDebug()) {
            b.i("Matrix.MrsCallbackImp", "onStrategyNotify, matrix will report all for debug mode", new Object[0]);
            return;
        }
        this.uZS.clear();
        HashMap hashMap = this.uZS;
        if (TextUtils.isEmpty(str) || hashMap == null) {
            b.e("Matrix.MatrixUtil", "changeStrategyToMap, input params is illegal", new Object[0]);
        } else {
            for (String split : str.split(";")) {
                String[] split2 = split.split(",", 2);
                if (split2.length != 2) {
                    b.e("Matrix.MatrixUtil", "changeStrategyToMap, strategy format is illegal, value: %s", split);
                } else {
                    hashMap.put(split2[0].trim(), Boolean.valueOf(split2[1].trim().equals("1")));
                }
            }
        }
        Iterator it = com.tencent.matrix.a.tg().boT.iterator();
        while (it.hasNext()) {
            com.tencent.matrix.b.b bVar = (com.tencent.matrix.b.b) it.next();
            String tag = bVar.getTag();
            if (this.uZS.containsKey(tag)) {
                boolean booleanValue = ((Boolean) this.uZS.get(tag)).booleanValue();
                if (booleanValue) {
                    int i;
                    if (bVar.status == 4) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        b.w("Matrix.MrsCallbackImp", "matrix strategy change, try to turn on plugin %s", tag);
                        bVar.start();
                    }
                }
                if (!booleanValue && bVar.tw()) {
                    b.w("Matrix.MrsCallbackImp", "matrix strategy change, try to turn off plugin %s", tag);
                    bVar.stop();
                }
            }
        }
    }

    public final String getPublicSharePath() {
        return AppLogic.getAppFilePath() + "/mrs/";
    }
}
