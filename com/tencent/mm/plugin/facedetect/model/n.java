package com.tencent.mm.plugin.facedetect.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.g.a.nq;
import com.tencent.mm.plugin.facedetect.ui.SettingsFacePrintManagerUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends c<nq> {
    public n() {
        this.sFo = nq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = false;
        nq nqVar = (nq) bVar;
        if (nqVar == null) {
            x.e("MicroMsg.FaceStartManageListener", "hy: event is null");
            return false;
        }
        Context context = nqVar.bYK.context;
        nq.b bVar2 = nqVar.bYL;
        f fVar = f.iNu;
        x.i("MicroMsg.FaceDetectManager", "hy: start face manage process");
        if (context == null) {
            x.e("MicroMsg.FaceDetectManager", "hy: context is null. abort");
        } else if (f.eJ(true)) {
            context.startActivity(new Intent(context, SettingsFacePrintManagerUI.class));
            z = true;
        } else {
            x.w("MicroMsg.FaceDetectManager", "hy: not support face detect. abort");
        }
        bVar2.bYJ = z;
        return true;
    }
}
