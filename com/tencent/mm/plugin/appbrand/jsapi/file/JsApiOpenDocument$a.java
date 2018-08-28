package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument.OpenRequest;
import com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument.OpenResult;
import com.tencent.mm.plugin.appbrand.s$d;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

final class JsApiOpenDocument$a extends AppBrandProxyUIProcessTask {
    private static final int fQm = (JsApiOpenDocument$a.class.hashCode() & 65535);

    private JsApiOpenDocument$a() {
    }

    private void bp(String str, String str2) {
        String Uh = s.Uh(str2);
        OpenResult openResult = new OpenResult();
        try {
            Intent intent = new Intent();
            intent.setPackage(null);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(new File(str)), Uh);
            intent.addFlags(268435456);
            int i = VERSION.SDK_INT;
            intent.addFlags(524288);
            ahw().startActivity(intent);
            openResult.ret = 0;
        } catch (Exception e) {
            x.e("MicroMsg.AppBrand.JsApiOpenDocument", "start outer view with mime(%s), e = %s", new Object[]{Uh, e});
            openResult.ret = 2147483646;
            ah.A(new 1(this));
        }
        a(openResult);
    }

    protected final void a(ProcessRequest processRequest) {
        String str = ((OpenRequest) processRequest).filePath;
        String str2 = ((OpenRequest) processRequest).fjS;
        String num = Integer.toString(ahw().hashCode());
        if (e.chv()) {
            bp(str, str2);
            return;
        }
        int a = p.a(ahw(), str, str2, num, new 2(this));
        x.i("MicroMsg.AppBrand.JsApiOpenDocument", "QB openReadFile, ret = %d", new Object[]{Integer.valueOf(a)});
        if (a == -102) {
            try {
                bp(str, str2);
                return;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrand.JsApiOpenDocument", e, " openOuterAppDirectly exp = %s ", new Object[]{e});
            }
        }
        OpenResult openResult = new OpenResult();
        openResult.ret = a;
        if (openResult.ret != 0) {
            a(openResult);
        } else if (this.fEn != null) {
            this.fEn.b(openResult);
        }
    }

    protected final void ahC() {
        super.ahC();
        ahw().getWindow().setBackgroundDrawableResource(s$d.transparent);
    }

    public final void b(int i, int i2, Intent intent) {
        if (fQm == i) {
            OpenResult openResult = new OpenResult();
            if (-1 == i2) {
                openResult.ret = 0;
            } else {
                openResult.ret = Integer.MAX_VALUE;
            }
            a(openResult);
            return;
        }
        a(null);
    }
}
