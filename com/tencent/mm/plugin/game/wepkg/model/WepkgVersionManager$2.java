package com.tencent.mm.plugin.game.wepkg.model;

import com.tencent.mm.plugin.game.wepkg.model.WepkgVersionManager.WepkgNetSceneProcessTask;

class WepkgVersionManager$2 implements Runnable {
    final /* synthetic */ WepkgNetSceneProcessTask kgc;

    WepkgVersionManager$2(WepkgNetSceneProcessTask wepkgNetSceneProcessTask) {
        this.kgc = wepkgNetSceneProcessTask;
    }

    public final void run() {
        this.kgc.aai();
    }
}
