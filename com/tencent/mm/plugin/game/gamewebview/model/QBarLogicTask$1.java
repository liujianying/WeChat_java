package com.tencent.mm.plugin.game.gamewebview.model;

import android.os.Bundle;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.plugin.game.gamewebview.ipc.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class QBarLogicTask$1 extends c<mu> {
    QBarLogicTask$1() {
        this.sFo = mu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mu muVar = (mu) bVar;
        x.d("MicroMsg.QBarLogicTask", "mRecogResultListener");
        if ((muVar instanceof mu) && (QBarLogicTask.ajb() == null || QBarLogicTask.ajb().containsKey(muVar.bXK.filePath))) {
            if (QBarLogicTask.ajb() != null) {
                QBarLogicTask.ajb().remove(muVar.bXK.filePath);
            }
            x.d("MicroMsg.QBarLogicTask", "result: " + muVar.bXK.result);
            Bundle bundle = new Bundle();
            bundle.putInt("mm_to_client_notify_type", 2);
            bundle.putString("file_path", muVar.bXK.filePath);
            bundle.putString("result", muVar.bXK.result);
            bundle.putInt("code_type", muVar.bXK.bJr);
            bundle.putInt("code_version", muVar.bXK.bJs);
            a.z(bundle);
        }
        return false;
    }
}
