package com.tencent.mm.plugin.fav;

import com.tencent.mm.g.c.ff;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.fav.a.aa;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.s;
import com.tencent.mm.plugin.fav.a.t;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.b.d.a;
import com.tencent.mm.plugin.fav.b.d.d;
import com.tencent.mm.plugin.fav.b.d.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.c.wd;
import com.tencent.mm.protocal.c.wo;
import java.util.List;

public class PluginFav extends f implements b, c, ae {
    private a iUX;
    private x iUY;
    private q iUZ;
    private aa iVa;
    private t iVb;
    private s iVc;
    private l iVd;
    private e iVe;
    private d iVf;
    private a iVg;
    private com.tencent.mm.plugin.fav.b.d.b iVh;
    private com.tencent.mm.plugin.fav.b.d.c iVi;
    private com.tencent.mm.plugin.fav.b.b.a iVj = new com.tencent.mm.plugin.fav.b.b.a();
    private com.tencent.mm.plugin.fav.b.b.b iVk = new com.tencent.mm.plugin.fav.b.b.b();
    private com.tencent.mm.sdk.b.c iVl = new 4(this);

    public void execute(g gVar) {
    }

    public void parallelsDependency() {
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        this.iUX = new a();
        ((o) com.tencent.mm.kernel.g.n(o.class)).getSysCmdMsgExtension().a("uploadfavitem", this.iUX);
        ((o) com.tencent.mm.kernel.g.n(o.class)).getSysCmdMsgExtension().a("resendfavitem", this.iUX);
        this.iUY = new com.tencent.mm.plugin.fav.b.e.d(ff.xa());
        this.iUZ = new com.tencent.mm.plugin.fav.b.e.a(ff.xa());
        this.iVa = new com.tencent.mm.plugin.fav.b.e.e(ff.xa());
        this.iVb = new com.tencent.mm.plugin.fav.b.e.c(ff.xa());
        this.iVc = new com.tencent.mm.plugin.fav.b.e.b(ff.xa());
        this.iVe = new e();
        this.iVf = new d();
        this.iVg = new a();
        this.iVh = new com.tencent.mm.plugin.fav.b.d.b();
        this.iVi = new com.tencent.mm.plugin.fav.b.d.c();
        this.iVd = new l();
        ((n) com.tencent.mm.kernel.g.n(n.class)).getFTSTaskDaemon().a(-86016, new 1(this));
        this.iVl.cht();
        this.iVj.cht();
        this.iVk.cht();
        checkDir();
    }

    public void onAccountRelease() {
        this.iVl.dead();
        this.iVj.dead();
        this.iVk.dead();
        ah.aLL();
        ((n) com.tencent.mm.kernel.g.n(n.class)).unregisterIndexStorage(ab.CTRL_BYTE);
        ((n) com.tencent.mm.kernel.g.n(n.class)).unregisterNativeLogic(6);
        ((o) com.tencent.mm.kernel.g.n(o.class)).getSysCmdMsgExtension().b("uploadfavitem", this.iUX);
        ((o) com.tencent.mm.kernel.g.n(o.class)).getSysCmdMsgExtension().b("resendfavitem", this.iUX);
        this.iUX = null;
        this.iUY = null;
        this.iUZ = null;
        this.iVa = null;
        this.iVb = null;
        this.iVc = null;
        this.iVd = null;
        if (this.iVe != null) {
            e eVar = this.iVe;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Fav.FavSendService", "stop");
            eVar.wx();
            eVar.bFo.SO();
            eVar.bFj = 0;
            com.tencent.mm.kernel.g.DF().b(401, eVar);
            this.iVe = null;
        }
        if (this.iVf != null) {
            d dVar = this.iVf;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Fav.FavModService", "stop");
            dVar.wx();
            dVar.bFo.SO();
            dVar.bFj = 0;
            com.tencent.mm.kernel.g.DF().b(426, dVar);
            this.iVf = null;
        }
        if (this.iVg != null) {
            a aVar = this.iVg;
            aVar.wx();
            aVar.bFo.SO();
            aVar.bFj = 0;
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().b(aVar.dOT);
            this.iVg = null;
        }
        if (this.iVh != null) {
            com.tencent.mm.plugin.fav.b.d.b bVar = this.iVh;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Fav.FavCheckCdnService", "stop");
            bVar.wx();
            bVar.bFo.SO();
            com.tencent.mm.kernel.g.DF().b(404, bVar);
            com.tencent.mm.kernel.g.Eh().b(bVar.dOT);
            this.iVh = null;
        }
        if (this.iVi != null) {
            com.tencent.mm.plugin.fav.b.d.c cVar = this.iVi;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Fav.FavEditService", "stop");
            com.tencent.mm.kernel.g.DF().b(426, cVar);
            com.tencent.mm.kernel.g.DF().b(401, cVar);
            cVar.iXL.clear();
            this.iVi = null;
        }
    }

    public void checkFavItem(List<wd> list) {
        com.tencent.mm.sdk.platformtools.ah.A(new 2(this, new com.tencent.mm.plugin.fav.b.c.a(list)));
    }

    public void checkFavItem(wo woVar) {
        com.tencent.mm.sdk.platformtools.ah.A(new 3(this, new com.tencent.mm.plugin.fav.b.c.a(woVar)));
    }

    public x getFavItemInfoStorage() {
        return this.iUY;
    }

    public q getFavCdnStorage() {
        return this.iUZ;
    }

    public s getFavConfigStorage() {
        return this.iVc;
    }

    public t getFavEditInfoStorage() {
        return this.iVb;
    }

    public aa getFavSearchStorage() {
        return this.iVa;
    }

    public l getFavTagSetMgr() {
        return this.iVd;
    }

    public ac getSendService() {
        return this.iVe;
    }

    public d getModService() {
        return this.iVf;
    }

    public a getFavCdnService() {
        return this.iVg;
    }

    public com.tencent.mm.plugin.fav.b.d.b getCheckCdnService() {
        return this.iVh;
    }

    public com.tencent.mm.plugin.fav.b.d.c getEditService() {
        return this.iVi;
    }

    private static void checkDir() {
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.aKW());
        if (!(bVar.exists() && bVar.isDirectory())) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Fav.PluginFav", "fav root dir not exists, try to make it");
            bVar.mkdirs();
        }
        bVar = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.aKO());
        if (!(bVar.exists() && bVar.isDirectory())) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Fav.PluginFav", "fav web dir not exists, try to make it");
            bVar.mkdirs();
        }
        bVar = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.aKV());
        if (!(bVar.exists() && bVar.isDirectory())) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Fav.PluginFav", "fav attach dir not exists, try to make it");
            bVar.mkdirs();
        }
        bVar = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.aKX());
        if (!bVar.exists() || !bVar.isDirectory()) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Fav.PluginFav", "fav voice dir not exists, try to make it");
            bVar.mkdirs();
        }
    }
}
