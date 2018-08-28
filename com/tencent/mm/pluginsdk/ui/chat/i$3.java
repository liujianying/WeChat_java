package com.tencent.mm.pluginsdk.ui.chat;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

class i$3 implements Runnable {
    final /* synthetic */ i qMU;
    final /* synthetic */ ag qMV;

    i$3(i iVar, ag agVar) {
        this.qMU = iVar;
        this.qMV = agVar;
    }

    public final void run() {
        boolean z = true;
        i iVar = this.qMU;
        String ceS = iVar.ceS();
        if (ceS == null) {
            z = false;
        } else {
            int i;
            int i2;
            int Cm = (int) iVar.Cm(70);
            int Cm2 = (int) iVar.Cm(120);
            int VX = ExifHelper.VX(ceS);
            if (VX == 90 || VX == 270) {
                i = Cm;
                i2 = Cm2;
            } else {
                i = Cm2;
                i2 = Cm;
            }
            Cm = (int) iVar.Cm(4);
            Bitmap a = c.a(ceS, i, i2, true, null, 0);
            if (a != null) {
                iVar.bitmap = c.a(c.b(a, (float) VX), true, (float) Cm);
                iVar.duR.edit().putString("chattingui_recent_shown_image_path", iVar.qMP.qMN).commit();
                x.d("MicroMsg.RecentImageBubble", "check ok");
            } else {
                x.e("MicroMsg.RecentImageBubble", "image hits hole.");
                z = false;
            }
        }
        if (z) {
            this.qMV.sendEmptyMessage(0);
        } else {
            x.d("MicroMsg.RecentImageBubble", "check false");
        }
    }

    public final String toString() {
        return super.toString() + "|checkIfShow";
    }
}
