package com.tencent.mm.plugin.game.model;

import com.tencent.mm.g.a.qw;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter.StartGameProcessTask;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;

class SubCoreGameCenter$3 extends c<qw> {
    final /* synthetic */ SubCoreGameCenter jOH;

    SubCoreGameCenter$3(SubCoreGameCenter subCoreGameCenter) {
        this.jOH = subCoreGameCenter;
        this.sFo = qw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qw qwVar = (qw) bVar;
        StartGameProcessTask startGameProcessTask = new StartGameProcessTask(ad.getContext());
        startGameProcessTask.bGm = qwVar.cbF.bundle.getLong("extra_download_id", -1);
        startGameProcessTask.aNI();
        return false;
    }
}
