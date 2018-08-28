package com.tencent.mm.plugin.game.wepkg.model;

import com.tencent.mm.plugin.game.wepkg.utils.b;
import com.tencent.mm.sdk.platformtools.x;

class f$2 implements Runnable {
    f$2() {
    }

    public final void run() {
        f.Ek(b.OBJECT_ROOT_DIR_PATH);
        x.i("MicroMsg.Wepkg.WepkgManager", "clear all local wepkg");
    }
}
