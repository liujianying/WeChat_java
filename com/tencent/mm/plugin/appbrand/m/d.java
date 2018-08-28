package com.tencent.mm.plugin.appbrand.m;

import android.content.Intent;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.compat.a.f;
import com.tencent.mm.plugin.appbrand.q.n;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;

public final class d implements f {
    public final boolean bc(String str, String str2) {
        InputStream open;
        OutputStream outputStream = null;
        try {
            open = ad.getContext().getAssets().open(str2);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WxaFTSSearchLogic", e, "", new Object[0]);
            open = null;
        }
        if (open == null) {
            x.e("MicroMsg.WxaFTSSearchLogic", "file inputStream is null.");
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        file.getParentFile().mkdirs();
        try {
            outputStream = new FileOutputStream(file);
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.WxaFTSSearchLogic", e2, "", new Object[0]);
        }
        if (outputStream != null) {
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                }
                return true;
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.WxaFTSSearchLogic", e22, "", new Object[0]);
                return false;
            } finally {
                e.f(open);
                e.closeOutputStream(outputStream);
            }
        } else {
            e.f(open);
            return false;
        }
    }

    public final String adP() {
        return n.adP();
    }

    public final int adQ() {
        return n.adQ();
    }

    public final Intent adR() {
        Intent intent = new Intent();
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
        intent.putExtra("neverGetA8Key", true);
        return intent;
    }

    public final String v(Map<String, String> map) {
        return n.v(map);
    }

    public final Map<String, String> adS() {
        return n.b(201, true, 64);
    }

    public final Properties A(File file) {
        return n.A(file);
    }
}
