package com.tencent.tinker.lib.f;

import android.content.Context;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;
import java.io.IOException;

public final class c {
    private static c vta;
    private Context context = null;
    public boolean vtb = true;
    public File vtc = null;
    public File vtd = null;
    public int vte = 5;

    private c(Context context) {
        this.context = context;
        this.vtc = new File(SharePatchFileUtil.hW(context), "patch.retry");
        this.vtd = new File(SharePatchFileUtil.hW(context), "temp.apk");
    }

    public static c hQ(Context context) {
        if (vta == null) {
            vta = new c(context);
        }
        return vta;
    }

    public final boolean cGY() {
        if (!this.vtb) {
            a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry disabled, just return", new Object[0]);
            return false;
        } else if (!a.hL(this.context).ons) {
            a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry is not main process, just return", new Object[0]);
            return false;
        } else if (!this.vtc.exists()) {
            a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry info not exist, just return", new Object[0]);
            return false;
        } else if (b.hN(this.context)) {
            a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad tinker service is running, just return", new Object[0]);
            return false;
        } else {
            String absolutePath = this.vtd.getAbsolutePath();
            if (absolutePath == null || !new File(absolutePath).exists()) {
                a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad patch file: %s is not exist, just return", new Object[]{absolutePath});
                return false;
            }
            a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad patch file: %s is exist, retry to patch", new Object[]{absolutePath});
            com.tencent.tinker.lib.e.c.bP(this.context, absolutePath);
            return true;
        }
    }

    public final boolean acP(String str) {
        if (!this.vtb) {
            a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck retry disabled, just return", new Object[0]);
            return true;
        } else if (!this.vtc.exists()) {
            a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck retry file is not exist, just return", new Object[0]);
            return true;
        } else if (str == null) {
            a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck md5 is null, just return", new Object[0]);
            return true;
        } else {
            a ae = a.ae(this.vtc);
            if (!str.equals(ae.bKg) || Integer.parseInt(ae.vtf) < this.vte) {
                return true;
            }
            a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck, retry count %d must exceed than max retry count", new Object[]{Integer.valueOf(Integer.parseInt(ae.vtf))});
            SharePatchFileUtil.aj(this.vtd);
            return false;
        }
    }

    public final void ad(File file) {
        if (!file.getAbsolutePath().equals(this.vtd.getAbsolutePath())) {
            a.w("Tinker.UpgradePatchRetry", "try copy file: %s to %s", new Object[]{file.getAbsolutePath(), this.vtd.getAbsolutePath()});
            try {
                SharePatchFileUtil.l(file, this.vtd);
            } catch (IOException e) {
                a.e("Tinker.UpgradePatchRetry", "fail to copy file: %s to %s", new Object[]{file.getAbsolutePath(), this.vtd.getAbsolutePath()});
            }
        }
    }
}
