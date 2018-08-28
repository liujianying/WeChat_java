package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.x;

class c$9 implements OnClickListener {
    final /* synthetic */ c quZ;
    final /* synthetic */ Context val$context;

    c$9(c cVar, Context context) {
        this.quZ = cVar;
        this.val$context = context;
    }

    public final void onClick(View view) {
        c.bZD().ac(-1, false);
        x.i("MicroMsg.WNNoteFootPannel", "summerper checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(a.a((Activity) this.val$context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null))});
        if (a.a((Activity) this.val$context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
            Intent intent = new Intent();
            intent.putExtra("MMActivity.OverrideExitAnimation", R.a.push_down_out);
            intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.fast_faded_in);
            intent.putExtra("map_view_type", 3);
            d.b(this.val$context, "location", ".ui.RedirectUI", intent, 4098);
        }
    }
}
