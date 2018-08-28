package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.g;

class ac$4 implements Runnable {
    final /* synthetic */ ac tpr;

    ac$4(ac acVar) {
        this.tpr = acVar;
    }

    public final void run() {
        this.tpr.mChattingClosed = false;
        if (!this.tpr.nfG.isFinishing()) {
            boolean z;
            String str = "MicroMsg.LauncherUI.NewChattingTabUI";
            String str2 = "ashutest::startChatting, ishow:%b";
            Object[] objArr = new Object[1];
            if (this.tpr.tpg == null) {
                z = false;
            } else {
                z = this.tpr.tpg.isShown();
            }
            objArr[0] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            Intent putExtra = new Intent().putExtra("Chat_User", this.tpr.tpl);
            if (this.tpr.tpm != null) {
                putExtra.putExtras(this.tpr.tpm);
            }
            putExtra.putExtra("img_gallery_enter_from_chatting_ui", true);
            ac.a(this.tpr, putExtra, false);
            this.tpr.tpj.setOnChattingLayoutChangedListener(this.tpr.onChattingLayoutChangedListener);
            this.tpr.tpg.setVisibility(0);
            this.tpr.tpg.setTranslationX((this.tpr.nfG.getWindow().getDecorView().getWidth() == 0 ? (float) this.tpr.nfG.getResources().getDisplayMetrics().widthPixels : (float) this.tpr.nfG.getWindow().getDecorView().getWidth()) - 0.1f);
            this.tpr.tpf = ai.VE();
            this.tpr.kB(3);
            if (this.tpr.bWY()) {
                g.a(this.tpr.nfG);
            }
        }
    }

    public final String toString() {
        return super.toString() + "|startChattingRunnable";
    }
}
