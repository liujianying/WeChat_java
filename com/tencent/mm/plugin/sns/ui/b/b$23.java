package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.c.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.c.c;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j.a;
import com.tencent.mm.plugin.sns.a.b.j.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import java.util.Map;

class b$23 implements OnClickListener {
    final /* synthetic */ b olf;

    b$23(b bVar) {
        this.olf = bVar;
    }

    public final void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof Long)) {
            String bBl;
            l cVar;
            String str;
            Intent intent;
            boolean z;
            SnsAdClick snsAdClick;
            Bundle bundle;
            e eZ = af.byr().eZ(((Long) view.getTag()).longValue());
            n bAL = eZ.bAL();
            j.a(b.njT, a.njR, eZ.bAL());
            eZ.getSource();
            String bBm = bAL.bBm();
            if (bi.oW(bBm)) {
                bBl = bAL.bBl();
            } else {
                bBl = bBm;
            }
            if (bAL.xb(32)) {
                com.tencent.mm.plugin.sns.storage.a bAH = bAL.bAH();
                int i = -1;
                com.tencent.mm.storage.a XE = c.Jy().XE("Sns_CanvasAd_DetailLink_JumpWay");
                if (XE.isValid()) {
                    i = bi.getInt(XE.field_value, -1);
                }
                Intent intent2;
                bsu bAJ;
                List list;
                if (bAH != null && bAH.nxV == 1) {
                    Intent intent3 = new Intent();
                    intent3.putExtra("key_card_id", bAH.nxX);
                    intent3.putExtra("key_card_ext", bAH.nxY);
                    intent3.putExtra("key_from_scene", 21);
                    intent3.putExtra("key_stastic_scene", 15);
                    d.b(this.olf.activity, "card", ".ui.CardDetailUI", intent3);
                    cVar = new com.tencent.mm.plugin.sns.a.b.c(bAL.bBn(), 3, this.olf.scene == 0 ? 1 : 2, "", bAL.bBr(), 11, bAL.bAJ().nNV, bAL.bAK());
                    g.Ek();
                    g.Eh().dpP.a(cVar, 0);
                    return;
                } else if (bAH == null || i != 1) {
                    if (bAH == null || i != 0) {
                        if (bAH != null && i == -1 && bAH.nxV == 3) {
                            if (bAL.bAF().bzm() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Nf(bAL.bBp().field_adxml)) {
                                bBm = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(bAL);
                                if (!bi.oW(bBm)) {
                                    eZ.field_adxml = bBm;
                                }
                                intent2 = new Intent();
                                intent2.putExtra("sns_landing_pages_share_sns_id", bAL.bAK());
                                intent2.putExtra("sns_landing_pages_rawSnsId", bAL.bAJ().ksA);
                                intent2.putExtra("sns_landing_pages_ux_info", bAL.bBo());
                                intent2.putExtra("sns_landing_pages_aid", bAL.bBj());
                                intent2.putExtra("sns_landing_pages_traceid", bAL.bBk());
                                bAJ = bAL.bAJ();
                                if (bAJ != null) {
                                    list = bAJ.sqc.ruA;
                                    if (list.size() > 0) {
                                        intent2.putExtra("sns_landing_pages_share_thumb_url", ((ate) list.get(0)).rVE);
                                    }
                                }
                                intent2.setClass(this.olf.activity, SnsAdNativeLandingPagesUI.class);
                                intent2.putExtra("sns_landig_pages_from_source", this.olf.scene == 0 ? 9 : 10);
                                intent2.putExtra("sns_landing_pages_xml", bAL.bBp().field_adxml);
                                intent2.putExtra("sns_landing_pages_rec_src", bAL.bBq());
                                intent2.putExtra("sns_landing_pages_xml_prefix", "adxml");
                                intent2.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                                this.olf.activity.startActivity(intent2);
                                this.olf.activity.overridePendingTransition(0, 0);
                                cVar = new com.tencent.mm.plugin.sns.a.b.c(bAL.bBn(), 3, this.olf.scene == 0 ? 1 : 2, "", bAL.bBr(), 21, bAL.bAJ().nNV, bAL.bAK());
                                g.Ek();
                                g.Eh().dpP.a(cVar, 0);
                                return;
                            }
                        } else if (b.a(this.olf, bAH, bAL, false)) {
                            cVar = new com.tencent.mm.plugin.sns.a.b.c(bAL.bBn(), 3, this.olf.scene == 0 ? 1 : 2, "", bAL.bBr(), 31, bAL.bAJ().nNV, bAL.bAK());
                            g.Ek();
                            g.Eh().dpP.a(cVar, 0);
                            return;
                        }
                    } else if (bAL.bAF().bzm() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Nf(bAL.bBp().field_adxml)) {
                        bBm = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(bAL);
                        if (!bi.oW(bBm)) {
                            eZ.field_adxml = bBm;
                        }
                        Map z2 = f.z(bAL.bBp().field_adxml, "adxml");
                        if (z2 != null) {
                            bBm = bi.aG((String) z2.get(".adxml.adCanvasInfo.shareWebUrl"), "");
                            if (!bi.oW(bBm)) {
                                bBl = bBm;
                            }
                            str = bBl;
                        } else {
                            x.e("MicroMsg.TimelineClickListener", "parse landingpagexml is error,landingpagexml is " + bAL.bBp().field_adxml);
                            str = bBl;
                        }
                        cVar = new com.tencent.mm.plugin.sns.a.b.c(bAL.bBn(), 3, this.olf.scene != 0 ? 1 : 2, "", bAL.bBr(), 0, bAL.bAJ().nNV, bAL.bAK());
                        g.Ek();
                        g.Eh().dpP.a(cVar, 0);
                        x.i("MicroMsg.TimelineClickListener", "adlink url " + str + " " + bAL.bAF().nyE);
                        intent = new Intent();
                        z = bAL.bAF().nyE != 0;
                        if (com.tencent.mm.platformtools.af.exv) {
                            z = false;
                        }
                        snsAdClick = new SnsAdClick(bAL.bBn(), this.olf.scene != 0 ? 1 : 2, bAL.field_snsId, bAL.bBo(), bAL.bBr(), (byte) 0);
                        snsAdClick.egI = bAL.bAJ().ksA;
                        if (bAL.xb(32)) {
                            bAH = bAL.bAH();
                            if (bAH != null) {
                                intent.putExtra("KsnsViewId", bAH.fvT);
                            }
                        }
                        intent.putExtra("KRightBtn", z);
                        bundle = new Bundle();
                        bundle.putParcelable("KSnsAdTag", snsAdClick);
                        bundle.putString("key_snsad_statextstr", eZ.bAJ().nNV);
                        intent.putExtra("jsapiargs", bundle);
                        intent.putExtra("rawUrl", str);
                        intent.putExtra("useJs", true);
                        intent.putExtra("srcUsername", bAL.field_userName);
                        intent.putExtra("sns_local_id", bAL.bBe());
                        intent.putExtra("stastic_scene", 15);
                        intent.putExtra("KPublisherId", "sns_" + i.eF(bAL.field_snsId));
                        intent.putExtra("pre_username", bAL.field_userName);
                        intent.putExtra("prePublishId", "sns_" + i.eF(bAL.field_snsId));
                        intent.putExtra("preUsername", bAL.field_userName);
                        com.tencent.mm.plugin.sns.c.a.ezn.j(intent, this.olf.activity);
                    }
                } else if (bAL.bAF().bzm() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Nf(bAL.bBp().field_adxml)) {
                    bBm = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(bAL);
                    if (!bi.oW(bBm)) {
                        eZ.field_adxml = bBm;
                    }
                    intent2 = new Intent();
                    intent2.putExtra("sns_landing_pages_share_sns_id", bAL.bAK());
                    intent2.putExtra("sns_landing_pages_rawSnsId", bAL.bAJ().ksA);
                    intent2.putExtra("sns_landing_pages_ux_info", bAL.bBo());
                    intent2.putExtra("sns_landing_pages_aid", bAL.bBj());
                    intent2.putExtra("sns_landing_pages_traceid", bAL.bBk());
                    bAJ = bAL.bAJ();
                    if (bAJ != null) {
                        list = bAJ.sqc.ruA;
                        if (list.size() > 0) {
                            intent2.putExtra("sns_landing_pages_share_thumb_url", ((ate) list.get(0)).rVE);
                        }
                    }
                    intent2.setClass(this.olf.activity, SnsAdNativeLandingPagesUI.class);
                    intent2.putExtra("sns_landig_pages_from_source", this.olf.scene == 0 ? 9 : 10);
                    intent2.putExtra("sns_landing_pages_xml", bAL.bBp().field_adxml);
                    intent2.putExtra("sns_landing_pages_xml_prefix", "adxml");
                    intent2.putExtra("sns_landing_pages_rec_src", bAL.bBq());
                    intent2.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                    this.olf.activity.startActivity(intent2);
                    this.olf.activity.overridePendingTransition(0, 0);
                    cVar = new com.tencent.mm.plugin.sns.a.b.c(bAL.bBn(), 3, this.olf.scene == 0 ? 1 : 2, "", bAL.bBr(), 21, bAL.bAJ().nNV, bAL.bAK());
                    g.Ek();
                    g.Eh().dpP.a(cVar, 0);
                    return;
                }
            }
            str = bBl;
            if (this.olf.scene != 0) {
            }
            cVar = new com.tencent.mm.plugin.sns.a.b.c(bAL.bBn(), 3, this.olf.scene != 0 ? 1 : 2, "", bAL.bBr(), 0, bAL.bAJ().nNV, bAL.bAK());
            g.Ek();
            g.Eh().dpP.a(cVar, 0);
            x.i("MicroMsg.TimelineClickListener", "adlink url " + str + " " + bAL.bAF().nyE);
            intent = new Intent();
            if (bAL.bAF().nyE != 0) {
            }
            if (com.tencent.mm.platformtools.af.exv) {
                z = false;
            }
            if (this.olf.scene != 0) {
            }
            snsAdClick = new SnsAdClick(bAL.bBn(), this.olf.scene != 0 ? 1 : 2, bAL.field_snsId, bAL.bBo(), bAL.bBr(), (byte) 0);
            snsAdClick.egI = bAL.bAJ().ksA;
            if (bAL.xb(32)) {
                bAH = bAL.bAH();
                if (bAH != null) {
                    intent.putExtra("KsnsViewId", bAH.fvT);
                }
            }
            intent.putExtra("KRightBtn", z);
            bundle = new Bundle();
            bundle.putParcelable("KSnsAdTag", snsAdClick);
            bundle.putString("key_snsad_statextstr", eZ.bAJ().nNV);
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("rawUrl", str);
            intent.putExtra("useJs", true);
            intent.putExtra("srcUsername", bAL.field_userName);
            intent.putExtra("sns_local_id", bAL.bBe());
            intent.putExtra("stastic_scene", 15);
            intent.putExtra("KPublisherId", "sns_" + i.eF(bAL.field_snsId));
            intent.putExtra("pre_username", bAL.field_userName);
            intent.putExtra("prePublishId", "sns_" + i.eF(bAL.field_snsId));
            intent.putExtra("preUsername", bAL.field_userName);
            com.tencent.mm.plugin.sns.c.a.ezn.j(intent, this.olf.activity);
        }
    }
}
