package com.tencent.mm.plugin.game.gamewebview.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonActivityTask;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsVideoCacheTask;

class h$7 implements OnMenuItemClickListener {
    final /* synthetic */ String gdi;
    final /* synthetic */ h jKm;

    h$7(h hVar, String str) {
        this.jKm = hVar;
        this.gdi = str;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.i("MicroMsg.GameWebViewMenuListHelper", "onMenuItemClick recognize qbcode");
        CommonActivityTask commonActivityTask = new CommonActivityTask(h.b(this.jKm));
        commonActivityTask.type = 1;
        commonActivityTask.jfZ.putString("result", this.gdi);
        commonActivityTask.jfZ.putString(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, h.c(this.jKm));
        commonActivityTask.jfZ.putInt("codeType", this.jKm.gcS);
        commonActivityTask.jfZ.putInt("codeVersion", this.jKm.gcT);
        commonActivityTask.aNI();
        return false;
    }
}
