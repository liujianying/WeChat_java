package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.n.d;

class l$4 implements d {
    final /* synthetic */ Context val$context;

    public l$4(Context context) {
        this.val$context = context;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + menuItem.getTitle().toString().replace(" ", "").replace("(", "").replace(")", "").replace("-", "")));
        intent.addFlags(268435456);
        if (bi.k(this.val$context, intent)) {
            this.val$context.startActivity(intent);
        }
    }
}
