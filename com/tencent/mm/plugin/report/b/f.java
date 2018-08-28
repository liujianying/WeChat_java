package com.tencent.mm.plugin.report.b;

import com.tencent.mm.a.e;
import com.tencent.mm.a.p;
import com.tencent.mm.model.at;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class f {
    public static boolean KF(String str) {
        File file = new File("/sdcard/cov.txt");
        if (file.exists()) {
            String I = at.dBv.I("login_user_name", "never_login_crash");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("#username=" + I);
            stringBuffer.append("\n");
            stringBuffer.append("#rev=" + d.REV);
            stringBuffer.append("\n");
            stringBuffer.append("#path=" + d.SVNPATH);
            stringBuffer.append("\n");
            if (str.length() > 0) {
                stringBuffer.append("#startrev=" + str);
                stringBuffer.append("\n");
            }
            e.e(file.getAbsolutePath(), stringBuffer.toString().getBytes());
            String b = p.b(file, false, "/sdcard/cov/cov_" + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date()) + ".zip");
            if (b == null) {
                x.e("MicroMsg.NetSceneCodeCoverageReport", "zip file failed");
                return false;
            }
            file.delete();
            x.i("MicroMsg.NetSceneCodeCoverageReport", "code coverage try upload :" + I);
            ae.a(b, I, false, false, 10, 20004);
            return true;
        }
        x.w("MicroMsg.NetSceneCodeCoverageReport", "codecoverage checkUpload dir never create ?");
        return false;
    }
}
