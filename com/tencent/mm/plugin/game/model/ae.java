package com.tencent.mm.plugin.game.model;

import com.tencent.mm.bk.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.d.az;
import com.tencent.mm.plugin.game.d.bs;
import com.tencent.mm.plugin.game.d.bv;
import com.tencent.mm.plugin.game.d.by;
import com.tencent.mm.plugin.game.d.ck;
import com.tencent.mm.plugin.game.e.d;
import com.tencent.mm.plugin.game.ui.GameMediaList;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class ae extends ac {
    public az jNC;
    private boolean jND;
    public d jNE;
    public af jNF;

    public ae(a aVar) {
        if (aVar == null) {
            this.jNC = new az();
            return;
        }
        this.jNC = (az) aVar;
        this.jND = false;
        Wj();
    }

    public ae(byte[] bArr) {
        this.jNC = new az();
        if (bArr != null && bArr.length != 0) {
            try {
                this.jNC.aG(bArr);
            } catch (IOException e) {
                x.e("MicroMsg.GamePBDataDetail", "Parsing Failed: %s", new Object[]{e.getMessage()});
            }
            this.jND = true;
            Wj();
        }
    }

    private void Wj() {
        d a = a(this.jNC.jOV);
        if (a != null) {
            a.scene = 12;
            a.bYq = 1201;
        }
        this.jNE = a;
        if (this.jND) {
            this.jNF = new af(this.jNE.field_appId);
        } else {
            this.jNF = new af(this.jNE.field_appId, this.jNC.jRB != null ? this.jNC.jRB.jTc : null);
        }
        if (!this.jND) {
            d.a(this.jNE);
            ((c) g.l(c.class)).aSk().a(this.jNE.field_appId, this.jNC);
        }
    }

    public final String aUh() {
        if (this.jNC.jRF != null) {
            return this.jNC.jRF.title;
        }
        if (this.jNC.jRA != null) {
            return this.jNC.jRA.bHD;
        }
        return null;
    }

    public final LinkedList<b> aUi() {
        LinkedList<b> linkedList;
        Iterator it;
        b bVar;
        if (this.jNC.jRF != null && this.jNC.jRF.hyy != null) {
            linkedList = new LinkedList();
            it = this.jNC.jRF.hyy.iterator();
            while (it.hasNext()) {
                by byVar = (by) it.next();
                bVar = new b();
                bVar.bWP = byVar.bWP;
                bVar.desc = byVar.desc;
                linkedList.add(bVar);
            }
            return linkedList;
        } else if (this.jNC.jRA == null || this.jNC.jRA.jSm == null) {
            return null;
        } else {
            linkedList = new LinkedList();
            it = this.jNC.jRA.jSm.iterator();
            while (it.hasNext()) {
                bs bsVar = (bs) it.next();
                bVar = new b();
                bVar.bWP = bsVar.jSp;
                bVar.title = bsVar.bHD;
                bVar.desc = bsVar.jQf;
                bVar.url = bsVar.jOX;
                linkedList.add(bVar);
            }
            return linkedList;
        }
    }

    public final int aUj() {
        if (this.jNC.jRF != null) {
            return 2;
        }
        return 1;
    }

    public final LinkedList<GameMediaList.a> aUk() {
        LinkedList<GameMediaList.a> linkedList = new LinkedList();
        if (this.jNC.jRy == null || this.jNC.jRy.jSG == null) {
            return linkedList;
        }
        Iterator it = this.jNC.jRy.jSG.iterator();
        while (it.hasNext()) {
            ck ckVar = (ck) it.next();
            GameMediaList.a aVar = new GameMediaList.a();
            aVar.type = ckVar.jSO;
            aVar.kao = ckVar.jSP;
            aVar.url = ckVar.jSQ;
            linkedList.add(aVar);
        }
        return linkedList;
    }

    public final String aUl() {
        if (this.jNC.jRy == null || this.jNC.jRy.bHD == null) {
            return null;
        }
        return this.jNC.jRy.bHD;
    }

    public final String aUm() {
        if (this.jNC.jRy == null || this.jNC.jRy.jQf == null) {
            return null;
        }
        return this.jNC.jRy.jQf;
    }

    public final String aUn() {
        if (this.jNC.jRz == null) {
            return null;
        }
        return this.jNC.jRz.bHD;
    }

    public final LinkedList<bv> aUo() {
        if (this.jNC.jRz == null) {
            return null;
        }
        return this.jNC.jRz.jSs;
    }
}
