package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.lucky.b.a;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class b$7 implements OnClickListener {
    final /* synthetic */ b olf;

    b$7(b bVar) {
        this.olf = bVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof ap) {
            String str = ((ap) view.getTag()).bNH;
            n Nl = h.Nl(str);
            if (Nl == null) {
                x.e("MicroMsg.TimelineClickListener", "photo click without snsinfo ,localId " + str);
            } else if (Nl.xb(32) && Nl.bAF() != null && Nl.bAF().nzp == 1) {
                this.olf.olb.onClick(view);
            } else {
                if (Nl.bAJ().sqc.ruz == 21) {
                    if (q.GF().equals(Nl.field_userName)) {
                        str = Nl.bAJ().ksA;
                        m.j(Nl);
                        m.i(Nl);
                        System.currentTimeMillis();
                        b.kB(25);
                    }
                    if (!q.GF().equals(Nl.field_userName)) {
                        a.a(2, Nl);
                        b.kB(30);
                    }
                }
                if (Nl.xb(32)) {
                    Nl.bAH();
                    if (Nl.bAF().bzm() && e.Nf(Nl.bBp().field_adxml)) {
                        str = e.w(Nl);
                        if (!bi.oW(str)) {
                            Nl.bBp().field_adxml = str;
                        }
                        c cVar = new c(Nl.bBn(), 21, this.olf.scene == 0 ? 1 : 2, "", Nl.bBr(), Nl.bAK());
                        g.Ek();
                        g.Eh().dpP.a(cVar, 0);
                        int[] iArr = new int[2];
                        if (view != null) {
                            view.getLocationInWindow(iArr);
                        }
                        int width = view.getWidth();
                        int height = view.getHeight();
                        Intent intent = new Intent();
                        intent.putExtra("img_gallery_left", iArr[0]);
                        intent.putExtra("img_gallery_top", iArr[1]);
                        intent.putExtra("img_gallery_width", width);
                        intent.putExtra("img_gallery_height", height);
                        intent.putExtra("sns_landing_pages_share_sns_id", Nl.bAK());
                        intent.putExtra("sns_landing_pages_rawSnsId", Nl.bAJ().ksA);
                        intent.putExtra("sns_landing_pages_ux_info", Nl.bBo());
                        intent.putExtra("sns_landing_pages_aid", Nl.bBj());
                        intent.putExtra("sns_landing_pages_traceid", Nl.bBk());
                        bsu bAJ = Nl.bAJ();
                        if (bAJ != null) {
                            List list = bAJ.sqc.ruA;
                            if (list.size() > 0) {
                                intent.putExtra("sns_landing_pages_share_thumb_url", ((ate) list.get(0)).rVE);
                                intent.putExtra("sns_landing_pages_from_outer_index", ((ap) view.getTag()).index);
                            }
                        }
                        intent.setClass(this.olf.activity, SnsAdNativeLandingPagesUI.class);
                        intent.putExtra("sns_landig_pages_from_source", this.olf.scene == 0 ? 1 : 2);
                        intent.putExtra("sns_landing_pages_xml", Nl.bBp().field_adxml);
                        intent.putExtra("sns_landing_pages_rec_src", Nl.bBq());
                        intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                        this.olf.activity.startActivity(intent);
                        this.olf.activity.overridePendingTransition(0, 0);
                        if (this.olf.nMm != null) {
                            this.olf.nMm.bxT().v(Nl);
                        }
                    } else {
                        this.olf.bS(view);
                    }
                } else {
                    this.olf.bS(view);
                }
                Nl.xb(32);
                ap apVar = (ap) view.getTag();
                if (apVar.nTx && Nl != null) {
                    ax.b(Nl, apVar.index);
                    ax.c(Nl, apVar.index);
                    av.Mw(Nl.bBe());
                }
                if (Nl != null) {
                    bsu bAJ2 = Nl.bAJ();
                    if (bAJ2 != null) {
                        String str2 = bAJ2.sqb == null ? null : bAJ2.sqb.ksA;
                        if (!bi.oW(str2) && com.tencent.mm.plugin.sns.c.a.ezo.cU(str2)) {
                            com.tencent.mm.plugin.sns.c.a.ezo.a(null, str2, com.tencent.mm.plugin.sns.c.a.ezo.cS(str2), bAJ2.hbL, 2, 4, 4, bAJ2.sqg, bAJ2.ksA);
                        }
                    }
                }
            }
        }
    }
}
