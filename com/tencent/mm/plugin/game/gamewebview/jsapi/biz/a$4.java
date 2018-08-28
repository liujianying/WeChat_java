package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import org.json.JSONObject;

class a$4 implements OnClickListener {
    final /* synthetic */ int doP;
    final /* synthetic */ JSONObject fHi;
    final /* synthetic */ d jGF;
    final /* synthetic */ a jGG;

    a$4(a aVar, d dVar, JSONObject jSONObject, int i) {
        this.jGG = aVar;
        this.jGF = dVar;
        this.fHi = jSONObject;
        this.doP = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a.b(this.jGF, this.fHi, this.doP);
        dialogInterface.dismiss();
    }
}
