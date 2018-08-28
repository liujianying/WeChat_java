package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.m.a;
import com.tencent.mm.protocal.c.wa;

class FavoriteFileDetailUI$7 implements OnClickListener {
    final /* synthetic */ FavoriteFileDetailUI jcx;

    FavoriteFileDetailUI$7(FavoriteFileDetailUI favoriteFileDetailUI) {
        this.jcx = favoriteFileDetailUI;
    }

    public final void onClick(View view) {
        m.a(a.iWl, FavoriteFileDetailUI.b(this.jcx));
        wa waVar = FavoriteFileDetailUI.a(this.jcx).rAo;
        String c = b.c(FavoriteFileDetailUI.a(this.jcx));
        Intent intent = new Intent();
        intent.putExtra("IsAd", false);
        intent.putExtra("KStremVideoUrl", waVar.dyJ);
        intent.putExtra("StreamWording", waVar.dyM);
        intent.putExtra("StremWebUrl", waVar.dyN);
        intent.putExtra("KBlockFav", true);
        intent.putExtra("KThumUrl", waVar.dyO);
        intent.putExtra("KThumbPath", c);
        intent.putExtra("KMediaId", "fakeid_" + FavoriteFileDetailUI.b(this.jcx).field_id);
        intent.putExtra("KMediaVideoTime", waVar.rBq);
        intent.putExtra("KMediaTitle", FavoriteFileDetailUI.a(this.jcx).title);
        intent.putExtra("KSta_StremVideoAduxInfo", waVar.dyP);
        intent.putExtra("KSta_StremVideoPublishId", waVar.dyQ);
        intent.putExtra("KSta_SourceType", 1);
        intent.putExtra("KSta_Scene", m.b.iWv.value);
        intent.putExtra("KSta_FromUserName", FavoriteFileDetailUI.b(this.jcx).field_fromUser);
        intent.putExtra("KSta_FavID", FavoriteFileDetailUI.b(this.jcx).field_id);
        intent.putExtra("KSta_SnsStatExtStr", FavoriteFileDetailUI.a(this.jcx).bZN);
        d.b(this.jcx, "sns", ".ui.VideoAdPlayerUI", intent);
    }
}
