package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Intent;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

public abstract class AppBrandProxyUIProcessTask implements a {
    public b fEn;

    public interface b<R extends ProcessResult> {
        void c(R r);
    }

    public abstract void a(ProcessRequest processRequest);

    public final MMActivity ahw() {
        return this.fEn.ahw();
    }

    public final void a(ProcessResult processResult) {
        1 1 = new 1(this, processResult);
        if (this.fEn != null) {
            this.fEn.runOnUiThread(1);
        }
    }

    public void b(int i, int i2, Intent intent) {
    }

    public void ahC() {
    }
}
