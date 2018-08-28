package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class k implements OnClickListener, OnItemClickListener {
    protected int jNv = 0;

    public final void setSourceScene(int i) {
        this.jNv = i;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object item = adapterView.getAdapter().getItem(i);
        if (item != null && (item instanceof d)) {
            d dVar = (d) item;
            if (!bi.oW(dVar.field_appId)) {
                a(view.getContext(), dVar);
            }
        }
    }

    public final void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof d)) {
            a(view.getContext(), (d) view.getTag());
        }
    }

    private void a(Context context, d dVar) {
        int i = 0;
        if (dVar.type == 1) {
            i = c.an(context, dVar.jLe);
        } else if (dVar.type == 0) {
            if (dVar.aTx() && !bi.oW(dVar.jLx.jOU) && !g.a(context, dVar)) {
                i = c.an(context, dVar.jLx.jOU);
            } else if (bi.oW(dVar.cmK) || dVar.cmN != 4) {
                Bundle bundle = new Bundle();
                bundle.putCharSequence("game_app_id", dVar.field_appId);
                if (dVar.bYq == 1601) {
                    bundle.putInt("game_report_from_scene", this.jNv);
                } else {
                    bundle.putInt("game_report_from_scene", dVar.bYq);
                }
                i = c.b(context, dVar.field_appId, dVar.jLe, bundle);
            } else {
                x.i("MicroMsg.GameItemClickListener", "Download via Google Play");
                q.bi(context, dVar.cmK);
                i = 25;
            }
        }
        an.a(context, dVar.scene, dVar.bYq, dVar.position, i, dVar.field_appId, this.jNv, dVar.bHF, dVar.jLt);
    }
}
