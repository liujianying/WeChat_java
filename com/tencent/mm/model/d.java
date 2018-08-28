package com.tencent.mm.model;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    private com.tencent.mm.compatible.util.b bEL;
    private com.tencent.mm.compatible.util.b.a dAm;
    a dAn;
    private boolean dAo = false;
    private Context rc = ad.getContext();

    public interface a {
    }

    private class b implements com.tencent.mm.compatible.util.b.a {
        private b() {
        }

        /* synthetic */ b(d dVar, byte b) {
            this();
        }

        public final void ex(int i) {
            switch (i) {
                case -3:
                    x.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
                    if (d.this.dAn == null) {
                        return;
                    }
                    return;
                case -2:
                    x.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
                    if (d.this.dAn == null) {
                        return;
                    }
                    return;
                case -1:
                    x.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
                    if (d.this.dAn == null) {
                        return;
                    }
                    return;
                case 1:
                    x.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_GAIN");
                    if (d.this.dAn == null) {
                        return;
                    }
                    return;
                default:
                    x.v("MicroMsg.AudioHelperTool", "jacks UNKNOW_AUDIOFOCUS_LOSS DEFAULT");
                    return;
            }
        }
    }

    public final boolean a(a aVar) {
        this.dAn = aVar;
        b bVar = new b(this, (byte) 0);
        if (this.bEL == null) {
            this.bEL = new com.tencent.mm.compatible.util.b(this.rc);
        }
        if (this.dAm != bVar) {
            this.dAm = bVar;
        }
        this.bEL.a(this.dAm);
        if (this.bEL == null || this.dAo) {
            return false;
        }
        this.bEL.requestFocus();
        this.dAo = true;
        return this.dAo;
    }

    public final boolean bv(boolean z) {
        boolean zY;
        if (this.bEL != null) {
            zY = this.bEL.zY();
        } else {
            zY = false;
        }
        this.dAo = false;
        if (z) {
            this.bEL = null;
            this.dAm = null;
            this.dAn = null;
        }
        return zY;
    }
}
