package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.x;

class FavoriteFileDetailUI$10 implements OnClickListener {
    final /* synthetic */ String jcB;
    final /* synthetic */ FavoriteFileDetailUI jcx;

    FavoriteFileDetailUI$10(FavoriteFileDetailUI favoriteFileDetailUI, String str) {
        this.jcx = favoriteFileDetailUI;
        this.jcB = str;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.FavoriteFileDetailUI", "start video preview, fav id %d, fav local id %d", new Object[]{Integer.valueOf(FavoriteFileDetailUI.b(this.jcx).field_id), Long.valueOf(FavoriteFileDetailUI.b(this.jcx).field_localId)});
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.jcB);
        intent.putExtra("is_favorite_item", true);
        intent.putExtra("fav_local_id", FavoriteFileDetailUI.b(this.jcx).field_localId);
        intent.putExtra("geta8key_scene", 14);
        intent.putExtra("geta8key_scene", 14);
        d.b(this.jcx.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
    }
}
