package com.tencent.tinker.lib.service;

import android.os.Process;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.lib.f.a;
import com.tencent.tinker.lib.f.b;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

public class DefaultTinkerResultService extends AbstractResultService {
    public void a(a aVar) {
        if (aVar == null) {
            a.e("Tinker.DefaultTinkerResultService", "DefaultTinkerResultService received null result!!!!", new Object[0]);
            return;
        }
        a.i("Tinker.DefaultTinkerResultService", "DefaultTinkerResultService received a result:%s ", new Object[]{aVar.toString()});
        b.hM(getApplicationContext());
        if (aVar.bLW) {
            ab(new File(aVar.vso));
            if (b(aVar)) {
                Process.killProcess(Process.myPid());
            } else {
                a.i("Tinker.DefaultTinkerResultService", "I have already install the newly patch version!", new Object[0]);
            }
        }
    }

    public static void ab(File file) {
        if (SharePatchFileUtil.ah(file)) {
            a.w("Tinker.DefaultTinkerResultService", "deleteRawPatchFile rawFile path: %s", new Object[]{file.getPath()});
            String name = file.getName();
            if (name.startsWith("patch-") && name.endsWith(".apk")) {
                File parentFile = file.getParentFile();
                if (!parentFile.getName().startsWith("patch-")) {
                    SharePatchFileUtil.aj(file);
                    return;
                } else if (!parentFile.getParentFile().getName().equals("tinker")) {
                    SharePatchFileUtil.aj(file);
                    return;
                } else {
                    return;
                }
            }
            SharePatchFileUtil.aj(file);
        }
    }

    public final boolean b(a aVar) {
        com.tencent.tinker.lib.e.a hL = com.tencent.tinker.lib.e.a.hL(getApplicationContext());
        if (hL.vsE) {
            d dVar = hL.vsD;
            if (dVar != null) {
                String str = dVar.vsI;
                if (aVar.vsp != null && aVar.vsp.equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }
}
