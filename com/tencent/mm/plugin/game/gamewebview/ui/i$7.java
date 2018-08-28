package com.tencent.mm.plugin.game.gamewebview.ui;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.ipc.AddShortcutTask;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import org.json.JSONObject;

class i$7 implements Runnable {
    final /* synthetic */ i jKv;
    final /* synthetic */ AddShortcutTask jKy;

    i$7(i iVar, AddShortcutTask addShortcutTask) {
        this.jKv = iVar;
        this.jKy = addShortcutTask;
    }

    public final void run() {
        this.jKy.ahB();
        d pageView = this.jKv.jKc.getPageView();
        boolean z = this.jKy.success;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", z);
            pageView.cW("onAddShortcutStatus", jSONObject.toString());
        } catch (Exception e) {
            x.e("MicroMsg.GameWebviewJsLoader", "onGetAddShortcutStatus, e:" + e.getMessage());
        }
        if (this.jKy.success) {
            h.a(this.jKv.jIJ, R.l.wv_add_shortcut_success, R.l.app_tip, false, new 1(this));
        } else {
            Toast.makeText(this.jKv.jIJ, this.jKv.jIJ.getString(R.l.wv_add_shortcut_fail), 0).show();
        }
    }
}
