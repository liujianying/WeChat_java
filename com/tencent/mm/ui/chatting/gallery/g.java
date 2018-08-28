package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.Iterator;

public final class g {
    public ArrayList<bd> tTJ;
    public boolean tVs;
    ArrayList<b> tVt;

    /* synthetic */ g(byte b) {
        this();
    }

    private g() {
        this.tTJ = new ArrayList();
        this.tVs = false;
        this.tVt = new ArrayList();
    }

    public final void bw(bd bdVar) {
        if (bdVar != null) {
            x.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", new Object[]{Long.valueOf(bdVar.field_msgId)});
            this.tTJ.remove(bdVar);
            this.tTJ.remove(gI(bdVar.field_msgId));
            this.tTJ.add(bdVar);
            cwT();
        }
    }

    private bd gI(long j) {
        Iterator it = this.tTJ.iterator();
        while (it.hasNext()) {
            bd bdVar = (bd) it.next();
            if (bdVar.field_msgId == j) {
                return bdVar;
            }
        }
        return null;
    }

    public final void bx(bd bdVar) {
        if (bdVar != null) {
            x.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", new Object[]{Long.valueOf(bdVar.field_msgId)});
            this.tTJ.remove(bdVar);
            this.tTJ.remove(gI(bdVar.field_msgId));
            cwT();
        }
    }

    public final void clear() {
        x.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
        this.tTJ.clear();
        Iterator it = this.tVt.iterator();
        while (it.hasNext()) {
            ((b) it.next()).clear();
        }
    }

    public final void detach() {
        this.tVt.clear();
        clear();
        this.tVs = false;
    }

    public final boolean by(bd bdVar) {
        if (bdVar == null) {
            return false;
        }
        Iterator it = this.tTJ.iterator();
        while (it.hasNext()) {
            if (((bd) it.next()).field_msgId == bdVar.field_msgId) {
                return true;
            }
        }
        return false;
    }

    private void cwT() {
        Iterator it = this.tVt.iterator();
        while (it.hasNext()) {
            ((b) it.next()).cwS();
        }
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.tVt.remove(bVar);
            this.tVt.add(bVar);
        }
    }
}
