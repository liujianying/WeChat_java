package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.sdk.platformtools.x;

class GameDetailRankLikeView$1 implements a {
    final /* synthetic */ GameDetailRankLikeView jWh;

    GameDetailRankLikeView$1(GameDetailRankLikeView gameDetailRankLikeView) {
        this.jWh = gameDetailRankLikeView;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        if (!(i == 0 && i2 == 0)) {
            x.e("MicroMsg.GameDetailRankLikeView", "CGI return is not OK. (%d, %d)(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        }
        return 0;
    }
}
