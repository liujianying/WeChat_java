package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wenote.model.a.g;
import com.tencent.mm.plugin.wenote.model.b.a;
import com.tencent.mm.plugin.wenote.model.nativenote.b.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements a, b {
    View eZZ;
    String qoA = "";
    ImageButton quH;
    LinearLayout quI;
    ImageButton quJ;
    ImageButton quK;
    ImageButton quL;
    ImageButton quM;
    LinearLayout quN;
    LinearLayout quO;
    LinearLayout quP;
    LinearLayout quQ;
    LinearLayout quR;
    public boolean quS = false;
    c quT = this;
    boolean quU = false;
    boolean quV = false;
    boolean quW = false;
    boolean quX = false;

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$13 */
    class AnonymousClass13 implements OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.wenote.model.nativenote.b.a quY;

        AnonymousClass13(com.tencent.mm.plugin.wenote.model.nativenote.b.a aVar) {
            this.quY = aVar;
        }

        public final void onClick(View view) {
            boolean z = true;
            h.mEJ.h(14547, new Object[]{Integer.valueOf(9)});
            c.this.quO.setPressed(false);
            c.this.quR.setPressed(false);
            if (c.this.quV || c.this.quX) {
                c.this.quW = false;
            }
            c.c(u.qty, Boolean.valueOf(!c.this.quW));
            c cVar = c.this;
            if (c.this.quW) {
                z = false;
            }
            cVar.quW = z;
            view.postDelayed(new 5(c.this, view, c.this.quW), 100);
            c.b(this.quY);
            c.this.quV = false;
            c.this.quX = false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$1 */
    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.wenote.model.nativenote.b.a quY;

        AnonymousClass1(com.tencent.mm.plugin.wenote.model.nativenote.b.a aVar) {
            this.quY = aVar;
        }

        public final void onClick(View view) {
            int a = c.a(c.this);
            if (a == 1) {
                this.quY.e(false, 0);
                this.quY.Q(3, 100);
            } else if (a == 3) {
                this.quY.e(true, 50);
                this.quY.Q(1, 0);
            } else if (a == 2) {
                this.quY.Q(3, 0);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$2 */
    class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.wenote.model.nativenote.b.a quY;

        AnonymousClass2(com.tencent.mm.plugin.wenote.model.nativenote.b.a aVar) {
            this.quY = aVar;
        }

        public final void onClick(View view) {
            h.mEJ.h(14547, new Object[]{Integer.valueOf(10)});
            g gVar = new g();
            k caj = k.caj();
            if (caj != null) {
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().a(gVar, caj.cam(), false, false, true);
            } else {
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().a(gVar, null, false, false, true);
            }
            c.b(this.quY);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.c$6 */
    class AnonymousClass6 implements OnClickListener {
        final /* synthetic */ Context val$context;

        AnonymousClass6(Context context) {
            this.val$context = context;
        }

        public final void onClick(View view) {
            x.i("MicroMsg.WNNoteFootPannel", "go to GalleryEntryUI");
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().ac(-1, false);
            Intent intent = new Intent();
            intent.putExtra("max_select_count", 9);
            intent.putExtra("query_source_type", 13);
            intent.putExtra("query_media_type", 3);
            intent.putExtra("show_header_view", true);
            intent.putExtra("send_btn_string", this.val$context.getString(R.l.favorite));
            Parcelable parcelable = (SightParams) intent.getParcelableExtra("KEY_SIGHT_PARAMS");
            if (parcelable == null) {
                parcelable = new SightParams(4, 0);
            }
            String str = "micromsg_" + System.currentTimeMillis();
            String str2 = e.dgl + str + ".mp4";
            String str3 = e.dgl + str + ".jpeg";
            int intExtra = intent.getIntExtra("key_pick_local_media_duration", 60);
            SightParams sightParams = new SightParams(4, 1);
            sightParams.lel = 2;
            sightParams.mode = 0;
            if (sightParams.lem == null) {
                sightParams.lem = new VideoTransPara();
            }
            sightParams.lem.duration = intExtra;
            sightParams.m(str, str2, str3, e.dgl + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
            intent.putExtra("KEY_SIGHT_PARAMS", parcelable);
            intent.putExtra("record_video_force_sys_camera", false);
            intent.putExtra("record_video_is_sight_capture", true);
            intent.addFlags(67108864);
            intent.putExtra("key_can_select_video_and_pic", true);
            d.b(this.val$context, "gallery", ".ui.GalleryEntryUI", intent, 4097);
        }
    }

    static /* synthetic */ void b(com.tencent.mm.plugin.wenote.model.nativenote.b.a aVar) {
        aVar.e(true, 50);
        aVar.Q(1, 0);
    }

    static /* synthetic */ void c(t tVar, Object obj) {
        if (k.caj() != null) {
            k.caj().b(tVar, obj);
        }
    }

    public final void bZk() {
        com.tencent.mm.ui.base.h.a(this.quM.getContext(), this.quM.getContext().getString(R.l.note_record_stop_request), "", true, new 3(this), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    public final void bZj() {
        a(null);
    }

    public final void a(com.tencent.mm.plugin.wenote.model.nativenote.b.a aVar) {
        this.quM.setImageResource(R.g.wenote_voice_button);
        if (this.quS) {
            this.quS = false;
            com.tencent.mm.plugin.wenote.model.k bZe = com.tencent.mm.plugin.wenote.model.k.bZe();
            if (bZe.hnt && !bZe.hnu) {
                bZe.aMn();
            }
            bZe = com.tencent.mm.plugin.wenote.model.k.bZe();
            String str = com.tencent.mm.a.e.cn(bZe.path) ? bZe.path : "";
            int i = (int) com.tencent.mm.plugin.wenote.model.k.bZe().duration;
            int bD = (int) com.tencent.mm.bb.a.bD((long) i);
            int bZI = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().bZI();
            com.tencent.mm.plugin.wenote.model.a.b Bv = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().Bv(bZI);
            if (!com.tencent.mm.a.e.cn(str)) {
                x.e("MicroMsg.WNNoteFootPannel", "voicePath not exist, remove data from datalist and ui");
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().ab(bZI, false);
                if (aVar != null) {
                    aVar.Bq(bZI);
                }
                com.tencent.mm.plugin.wenote.model.a.h hVar = new com.tencent.mm.plugin.wenote.model.a.h();
                hVar.content = "";
                hVar.qoH = true;
                hVar.qoN = false;
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().a(bZI, hVar);
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().er(bZI - 1, bZI + 1);
            } else if (bZI != -1 && Bv != null && Bv.getType() == 4) {
                ((com.tencent.mm.plugin.wenote.model.a.k) Bv).qoV = Boolean.valueOf(false);
                ((com.tencent.mm.plugin.wenote.model.a.k) Bv).type = 4;
                ((com.tencent.mm.plugin.wenote.model.a.k) Bv).qpd = true;
                ((com.tencent.mm.plugin.wenote.model.a.k) Bv).qpt = "";
                ((com.tencent.mm.plugin.wenote.model.a.k) Bv).length = i;
                ((com.tencent.mm.plugin.wenote.model.a.k) Bv).qps = com.tencent.mm.bb.a.v(ad.getContext(), bD).toString();
                ((com.tencent.mm.plugin.wenote.model.a.k) Bv).fTs = an.aLQ() + "/fav_fileicon_recording.png";
                ((com.tencent.mm.plugin.wenote.model.a.k) Bv).bVd = str;
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c bZD = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD();
                if (bZD.qpR != null) {
                    bZD.qpR.Bo(bZI);
                }
            }
        }
    }

    public final void ks(boolean z) {
        this.quU = z;
        this.quN.setPressed(z);
    }

    public final void kt(boolean z) {
        this.quV = z;
        this.quO.setPressed(z);
    }

    public final void ku(boolean z) {
        this.quW = z;
        this.quP.setPressed(z);
    }

    public final void kv(boolean z) {
        this.quX = z;
        this.quR.setPressed(z);
    }
}
