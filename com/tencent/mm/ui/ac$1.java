package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Handler;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.x;

class ac$1 implements IdleHandler {
    final /* synthetic */ ac tpr;

    ac$1(ac acVar) {
        this.tpr = acVar;
    }

    @TargetApi(17)
    public final boolean queueIdle() {
        boolean z = true;
        try {
            if (this.tpr.nfG.isFinishing() || this.tpr.nfG.isDestroyed()) {
                String str = "MicroMsg.LauncherUI.NewChattingTabUI";
                String str2 = "prepare chattingUI but activity finished isDestroyed[%b]";
                Object[] objArr = new Object[1];
                if (!(this.tpr.nfG.isDestroyed() || this.tpr.nfG.isFinishing())) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                x.i(str, str2, objArr);
                return false;
            }
            x.i("MicroMsg.LauncherUI.NewChattingTabUI", "prepare chattingUI logic start");
            long currentTimeMillis = System.currentTimeMillis();
            if (this.tpr.tpg == null) {
                ac.a(this.tpr, new Intent().putExtra("Chat_User", q.GF()), true);
                this.tpr.tpg.setVisibility(8);
                this.tpr.tpe.cpC();
                com.tencent.mm.ui.base.x.b(true, new Intent().putExtra("classname", LauncherUI.class.getName()));
            }
            x.i("MicroMsg.LauncherUI.NewChattingTabUI", "prepare chattingUI logic use %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            return false;
        } catch (final Throwable e) {
            x.printErrStackTrace("MicroMsg.LauncherUI.NewChattingTabUI", e, "", new Object[0]);
            new Handler().post(new Runnable() {
                public final void run() {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
