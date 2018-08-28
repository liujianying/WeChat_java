package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.sdk.platformtools.ag;

class FavoriteFileDetailUI$1 implements OnClickListener {
    final /* synthetic */ String jcw;
    final /* synthetic */ FavoriteFileDetailUI jcx;

    FavoriteFileDetailUI$1(FavoriteFileDetailUI favoriteFileDetailUI, String str) {
        this.jcx = favoriteFileDetailUI;
        this.jcw = str;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("key_snsad_statextstr", FavoriteFileDetailUI.a(this.jcx).bZN);
        intent.putExtra("jsapiargs", bundle);
        intent.putExtra("rawUrl", this.jcw);
        intent.putExtra("useJs", true);
        g.DF().a(new c("", ""), 0);
        new ag(Looper.getMainLooper()).post(new 1(this, intent));
    }
}
