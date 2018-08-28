package com.tencent.mm.plugin.game;

import com.tencent.mm.bt.h;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.model.a.f;
import com.tencent.mm.plugin.game.model.ab;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class e implements a, d, c {
    private w jFR;
    private ab jFS;
    private q jFT;
    private f jFU;

    public final void onDataBaseOpened(h hVar, h hVar2) {
        x.i("MicroMsg.GameStorage", "GameStorage onDataBaseOpened");
        this.jFR = new w(hVar);
        this.jFS = new ab(hVar);
        this.jFT = new q(hVar);
        this.jFU = new f(hVar);
    }

    public final HashMap<Integer, h.d> collectDatabaseFactory() {
        x.i("MicroMsg.GameStorage", "GameStorage collectDatabaseFactory");
        HashMap<Integer, h.d> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("GAME_CENTER_MSG_INFO_TABLE".hashCode()), new 1(this));
        hashMap.put(Integer.valueOf("GAME_CENTER_JSON_CACHE_TABLE".hashCode()), new 2(this));
        hashMap.put(Integer.valueOf("GAME_CENTER_PB_CACHE_TABLE".hashCode()), new 3(this));
        hashMap.put(Integer.valueOf("GAME_CENTER_SILENT_DOWNLOAD_TABLE".hashCode()), new 4(this));
        hashMap.put(Integer.valueOf("CHECK_WEPKG_VERSION".hashCode()), new 5(this));
        hashMap.put(Integer.valueOf("WEPKG_PRELOAD_FILES".hashCode()), new 6(this));
        return hashMap;
    }

    public final void onDataBaseClosed(h hVar, h hVar2) {
    }

    public final w aSj() {
        g.Eg().Ds();
        if (this.jFR == null) {
            g.Ek();
            this.jFR = new w(g.Ei().dqq);
        }
        return this.jFR;
    }

    public final ab aSk() {
        g.Eg().Ds();
        if (this.jFS == null) {
            g.Ek();
            this.jFS = new ab(g.Ei().dqq);
        }
        return this.jFS;
    }

    public final f aSl() {
        g.Eg().Ds();
        if (this.jFU == null) {
            g.Ek();
            this.jFU = new f(g.Ei().dqq);
        }
        return this.jFU;
    }
}
