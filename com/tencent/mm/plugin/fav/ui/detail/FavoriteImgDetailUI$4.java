package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.protocal.c.vx;

class FavoriteImgDetailUI$4 implements OnClickListener {
    final /* synthetic */ FavoriteImgDetailUI jcT;

    FavoriteImgDetailUI$4(FavoriteImgDetailUI favoriteImgDetailUI) {
        this.jcT = favoriteImgDetailUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("key_detail_info_id", FavoriteImgDetailUI.b(this.jcT).field_localId);
        intent.putExtra("key_detail_data_id", ((vx) view.getTag()).jdM);
        b.a(this.jcT.mController.tml, ".ui.FavImgGalleryUI", intent);
        a aVar = this.jcT.jcb;
        aVar.iVM++;
    }
}
