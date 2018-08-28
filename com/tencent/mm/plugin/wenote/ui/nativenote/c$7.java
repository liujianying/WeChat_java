package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.e.b.j;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.k.1;
import com.tencent.mm.plugin.wenote.model.k.2;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;

class c$7 implements OnClickListener {
    final /* synthetic */ a quY;
    final /* synthetic */ c quZ;
    final /* synthetic */ Context val$context;

    c$7(c cVar, a aVar, Context context) {
        this.quZ = cVar;
        this.quY = aVar;
        this.val$context = context;
    }

    public final void onClick(View view) {
        boolean z = false;
        if (c.a(this.quZ) == 3) {
            this.quY.e(true, 50);
            this.quY.Q(1, 0);
        }
        c.bZD().ac(-1, false);
        x.i("MicroMsg.WNNoteFootPannel", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a((Activity) this.val$context, "android.permission.RECORD_AUDIO", 80, null, null)), bi.cjd()});
        if (com.tencent.mm.pluginsdk.permission.a.a((Activity) this.val$context, "android.permission.RECORD_AUDIO", 80, null, null)) {
            if (!this.quZ.quS) {
                if (!f.zZ()) {
                    s.gH(this.val$context);
                    return;
                } else if (com.tencent.mm.p.a.by(this.val$context) || com.tencent.mm.p.a.bw(this.val$context)) {
                    return;
                }
            }
            if (this.quZ.quS) {
                this.quZ.a(this.quY);
                return;
            }
            h.mEJ.h(14547, new Object[]{Integer.valueOf(3)});
            if (c.bZD().eq(0, 1)) {
                this.quY.bZn();
                return;
            }
            this.quZ.quM.setImageResource(R.g.fav_note_voiceplayer_record_icon);
            if (com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.cbb().aLq()) {
                com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.cbb().stopPlay();
            }
            this.quZ.quS = true;
            b kVar = new k();
            kVar.type = 4;
            kVar.qpd = false;
            kVar.qoV = Boolean.valueOf(true);
            kVar.qpt = this.val$context.getString(R.l.favorite_wenote_voice_recording);
            this.quZ.qoA = "speex";
            kVar.bOS = 1;
            kVar.qpc = c.bZD().bZJ();
            kVar.qoT = this.quZ.qoA;
            kVar.jdM = com.tencent.mm.plugin.wenote.model.f.Sf(kVar.toString());
            vx vxVar = new vx();
            vxVar.UO(kVar.jdM);
            vxVar.UL(kVar.qoT);
            com.tencent.mm.plugin.wenote.model.nativenote.manager.k caj = com.tencent.mm.plugin.wenote.model.nativenote.manager.k.caj();
            if (caj != null) {
                c.bZD().a(kVar, caj.cam(), false, false, false);
            } else {
                c.bZD().a(kVar, null, false, false, false);
            }
            com.tencent.mm.plugin.wenote.model.k bZe = com.tencent.mm.plugin.wenote.model.k.bZe();
            c cVar = this.quZ.quT;
            String o = com.tencent.mm.plugin.wenote.model.f.o(vxVar);
            bZe.qoE = kVar;
            int i = bi.getInt(kVar.qpc.substring(7), 0);
            String str = kVar.qoT;
            if (!bZe.hnt) {
                String aLV;
                bZe.hnt = true;
                bZe.jaG = null;
                bZe.qoC = i;
                bZe.qoD = cVar;
                bZe.qoA = str;
                bZe.path = o;
                if (bZe.epT != null) {
                    bZe.epT.requestFocus();
                }
                bZe.hnu = false;
                if (bi.oW(bZe.path)) {
                    aLV = an.aLV();
                    File file = new File(aLV);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    do {
                        o = aLV + "/" + System.currentTimeMillis();
                    } while (new File(o).exists());
                    bZe.path = o;
                }
                if (bi.oW(str)) {
                    aLV = "amr";
                } else {
                    aLV = str;
                }
                if (aLV.equals("speex")) {
                    bZe.qoz = new com.tencent.mm.modelvoice.k();
                    1 1 = new 1(bZe);
                } else {
                    com.tencent.mm.compatible.b.b.a aVar = com.tencent.mm.compatible.b.b.a.daM;
                    bZe.iZl = new j();
                    bZe.iZl.bFw = new 2(bZe);
                }
                bZe.hng = -1;
                Boolean.valueOf(false);
                if ((str.equals("speex") ? Boolean.valueOf(bZe.qoz.dc(bZe.path)) : Boolean.valueOf(bZe.iZl.de(bZe.path))).booleanValue()) {
                    bZe.iZe = bi.VG();
                    bZe.hnz.J(200, 200);
                } else {
                    bZe.iZe = 0;
                }
                if (bZe.iZe == 0) {
                    z = true;
                } else {
                    bZe.qoF.sendEmptyMessage(Downloads.RECV_BUFFER_SIZE);
                }
            }
            if (z >= false) {
                this.quY.bZo();
                this.quZ.a(this.quY);
            }
        }
    }
}
