package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMImageView;
import java.util.List;

class b$30 implements OnClickListener {
    final /* synthetic */ b olf;

    b$30(b bVar) {
        this.olf = bVar;
    }

    public final void onClick(View view) {
        MMImageView mMImageView;
        n nVar;
        Object tag = view.getTag();
        TagImageView tagImageView = null;
        if (tag instanceof c) {
            c cVar = (c) view.getTag();
            n Nk = h.Nk(cVar.bSZ);
            mMImageView = null;
            tagImageView = cVar.oiT;
            nVar = Nk;
        } else if (tag instanceof n) {
            mMImageView = (MMImageView) view.getTag(f.link_ad_left_iv);
            nVar = (n) tag;
        } else {
            mMImageView = null;
            nVar = null;
        }
        if (nVar != null) {
            String w;
            com.tencent.mm.plugin.sns.a.b.c cVar2;
            boolean z;
            e bBp = nVar.bBp();
            bBp.getSource();
            if (nVar != null && nVar.xb(32)) {
                a bAH = nVar.bAH();
                if (nVar.bAF().bzm() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Nf(nVar.bBp().field_adxml)) {
                    w = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(nVar);
                    if (!bi.oW(w)) {
                        bBp.field_adxml = w;
                    }
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    int width = view.getWidth();
                    int height = view.getHeight();
                    if (tagImageView != null) {
                        tagImageView.getLocationInWindow(iArr);
                        width = tagImageView.getWidth();
                        height = tagImageView.getHeight();
                    } else if (mMImageView != null) {
                        mMImageView.getLocationInWindow(iArr);
                        width = mMImageView.getWidth();
                        height = mMImageView.getHeight();
                    }
                    Intent intent = new Intent();
                    intent.putExtra("img_gallery_left", iArr[0]);
                    intent.putExtra("img_gallery_top", iArr[1]);
                    intent.putExtra("img_gallery_width", width);
                    intent.putExtra("img_gallery_height", height);
                    intent.putExtra("sns_landing_pages_share_sns_id", nVar.bAK());
                    intent.putExtra("sns_landing_pages_rawSnsId", nVar.bAJ().ksA);
                    intent.putExtra("sns_landing_pages_ux_info", nVar.bBo());
                    bsu bAJ = nVar.bAJ();
                    if (bAJ != null) {
                        List list = bAJ.sqc.ruA;
                        if (list.size() > 0) {
                            intent.putExtra("sns_landing_pages_share_thumb_url", ((ate) list.get(0)).rVE);
                        }
                    }
                    intent.setClass(this.olf.activity, SnsAdNativeLandingPagesUI.class);
                    intent.putExtra("sns_landig_pages_from_source", this.olf.scene == 0 ? 1 : 2);
                    intent.putExtra("sns_landing_pages_xml", nVar.bBp().field_adxml);
                    intent.putExtra("sns_landing_pages_rec_src", nVar.bBq());
                    intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                    intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                    intent.putExtra("sns_landing_is_native_sight_ad", true);
                    this.olf.activity.startActivity(intent);
                    this.olf.activity.overridePendingTransition(0, 0);
                    cVar2 = new com.tencent.mm.plugin.sns.a.b.c(nVar.bBn(), 23, this.olf.scene == 0 ? 1 : 2, "", 3, 21, nVar.bAJ().nNV, nVar.bAK());
                    g.Ek();
                    g.Eh().dpP.a(cVar2, 0);
                    return;
                } else if (bAH != null && bAH.nxV == 1) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_card_id", bAH.nxX);
                    intent2.putExtra("key_card_ext", bAH.nxY);
                    intent2.putExtra("key_from_scene", 21);
                    intent2.putExtra("key_stastic_scene", 15);
                    d.b(this.olf.activity, "card", ".ui.CardDetailUI", intent2);
                    cVar2 = new com.tencent.mm.plugin.sns.a.b.c(nVar.bBn(), 23, this.olf.scene == 0 ? 1 : 2, "", 3, 11, nVar.bAJ().nNV, nVar.bAK());
                    g.Ek();
                    g.Eh().dpP.a(cVar2, 0);
                    return;
                } else if (b.a(this.olf, bAH, nVar, false)) {
                    cVar2 = new com.tencent.mm.plugin.sns.a.b.c(nVar.bBn(), 23, this.olf.scene == 0 ? 1 : 2, "", nVar.bBr(), 31, nVar.bAJ().nNV, nVar.bAK());
                    g.Ek();
                    g.Eh().dpP.a(cVar2, 0);
                    return;
                }
            }
            cVar2 = new com.tencent.mm.plugin.sns.a.b.c(nVar.bBn(), 23, this.olf.scene == 0 ? 1 : 2, "", 3, 0, nVar.bAJ().nNV, nVar.bAK());
            g.Ek();
            g.Eh().dpP.a(cVar2, 0);
            w = nVar.bBm();
            if (bi.oW(w)) {
                w = nVar.bBl();
            }
            x.i("MicroMsg.TimelineClickListener", "adlink url " + w + " " + nVar.bAF().nyE);
            Intent intent3 = new Intent();
            boolean z2 = nVar.bAF().nyE == 0;
            if (af.exv) {
                z = false;
            } else {
                z = z2;
            }
            SnsAdClick snsAdClick = new SnsAdClick(nVar.bBn(), this.olf.scene == 0 ? 1 : 2, nVar.field_snsId, nVar.bBo(), 3, (byte) 0);
            snsAdClick.egI = nVar.bAJ().ksA;
            if (nVar != null && nVar.xb(32)) {
                a bAH2 = nVar.bAH();
                if (bAH2 != null) {
                    intent3.putExtra("KsnsViewId", bAH2.fvT);
                }
            }
            intent3.putExtra("KRightBtn", z);
            Bundle bundle = new Bundle();
            bundle.putParcelable("KSnsAdTag", snsAdClick);
            bundle.putString("key_snsad_statextstr", bBp.bAJ().nNV);
            intent3.putExtra("jsapiargs", bundle);
            intent3.putExtra("rawUrl", w);
            intent3.putExtra("useJs", true);
            intent3.putExtra("srcUsername", nVar.field_userName);
            intent3.putExtra("stastic_scene", 15);
            intent3.putExtra("KPublisherId", "sns_" + i.eF(nVar.field_snsId));
            intent3.putExtra("pre_username", nVar.field_userName);
            intent3.putExtra("prePublishId", "sns_" + i.eF(nVar.field_snsId));
            intent3.putExtra("preUsername", nVar.field_userName);
            com.tencent.mm.plugin.sns.c.a.ezn.j(intent3, this.olf.activity);
        }
    }
}
