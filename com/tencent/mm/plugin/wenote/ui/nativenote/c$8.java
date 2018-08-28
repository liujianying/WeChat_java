package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.ui.base.s;

class c$8 implements OnClickListener {
    final /* synthetic */ c quZ;
    final /* synthetic */ Context val$context;

    c$8(c cVar, Context context) {
        this.quZ = cVar;
        this.val$context = context;
    }

    public final void onClick(View view) {
        c.bZD().ac(-1, false);
        if (f.zZ()) {
            Intent intent = new Intent(this.val$context, FileExplorerUI.class);
            intent.putExtra("key_title", this.val$context.getString(R.l.favorite_post_title_file));
            ((Activity) this.val$context).startActivityForResult(intent, 4099);
            return;
        }
        s.gH(this.val$context);
    }
}
