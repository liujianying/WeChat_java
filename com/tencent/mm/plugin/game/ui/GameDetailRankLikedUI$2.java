package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.game.d.bp;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;

class GameDetailRankLikedUI$2 implements a {
    final /* synthetic */ GameDetailRankLikedUI jWk;

    GameDetailRankLikedUI$2(GameDetailRankLikedUI gameDetailRankLikedUI) {
        this.jWk = gameDetailRankLikedUI;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        if (i == 0 && i2 == 0) {
            bp bpVar = (bp) bVar.dIE.dIL;
            GameDetailRankLikedUI$a a = GameDetailRankLikedUI.a(this.jWk);
            Collection collection = bpVar.jSl;
            if (collection != null) {
                a.jWl.clear();
                a.jWl.addAll(collection);
                a.notifyDataSetChanged();
            }
            GameDetailRankLikedUI.b(this.jWk).dismiss();
        } else {
            x.e(GameDetailRankLikedUI.bO(), "CGI return is not OK. (%d, %d)(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            this.jWk.finish();
        }
        return 0;
    }
}
