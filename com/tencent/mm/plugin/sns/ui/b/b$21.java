package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.b;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI;
import com.tencent.mm.plugin.sns.ui.ak;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bpg;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.av;
import java.util.List;

class b$21 implements OnClickListener {
    final /* synthetic */ b olf;

    b$21(b bVar) {
        this.olf = bVar;
    }

    public final void onClick(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        Throwable e;
        x.i("MicroMsg.TimelineClickListener", "onsight click");
        if (view.getTag() instanceof ak) {
            ak akVar = (ak) view.getTag();
            n Nl = af.byo().Nl(akVar.bKW);
            if (Nl != null) {
                if (this.olf.nMm != null) {
                    this.olf.nMm.bxT().v(Nl);
                }
                boolean xb = Nl.xb(32);
                if (xb && Nl.bAF() != null && Nl.bAF().nzp == 1) {
                    this.olf.olb.onClick(view);
                    return;
                }
                bsu bsu = akVar.nRA;
                if (bsu.sqc.ruA == null || bsu.sqc.ruA.size() == 0) {
                    x.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                    return;
                }
                ate ate = (ate) bsu.sqc.ruA.get(0);
                if (xb) {
                    af.byl();
                    if (!g.t(ate)) {
                        akVar.nEI.setVisibility(8);
                        akVar.nRD.setVisibility(0);
                        akVar.nRD.cAt();
                        af.byl().z(ate);
                        b byj = af.byj();
                        av clY = av.clY();
                        clY.time = bsu.lOH;
                        byj.a(ate, 4, null, clY);
                        if (xb) {
                            j.a(j.b.njT, a.njK, Nl);
                            return;
                        }
                        return;
                    }
                }
                Object obj = (Nl.xb(32) && Nl.bAF().bzm() && e.Nf(Nl.bBp().field_adxml)) ? 1 : null;
                if (obj == null && xb && af.byl().u(ate)) {
                    af.byl().z(ate);
                    akVar.nEI.setVisibility(8);
                    akVar.nRD.setVisibility(8);
                    g byl = af.byl();
                    com.tencent.mm.plugin.sight.decode.a.a aVar = akVar.neL;
                    int hashCode = this.olf.activity.hashCode();
                    int i5 = akVar.position;
                    av clY2 = av.clY();
                    clY2.time = bsu.lOH;
                    byl.a(Nl, ate, aVar, hashCode, i5, clY2, xb);
                    if (xb) {
                        j.a(j.b.njT, a.njK, Nl);
                        return;
                    }
                    return;
                }
                com.tencent.mm.modelsns.b io;
                if (this.olf.scene == 0) {
                    io = com.tencent.mm.modelsns.b.io(717);
                } else {
                    io = com.tencent.mm.modelsns.b.ip(717);
                }
                io.nb(i.g(Nl)).ir(Nl.field_type).bP(Nl.xb(32)).nb(Nl.bBo()).nb(ate.ksA);
                io.RD();
                if (this.olf.scene == 0) {
                    io = com.tencent.mm.modelsns.b.io(745);
                } else {
                    io = com.tencent.mm.modelsns.b.ip(745);
                }
                io.nb(i.g(Nl)).ir(Nl.field_type).bP(Nl.xb(32));
                if (xb) {
                    int i6 = this.olf.scene == 0 ? 1 : 2;
                    String bBn = Nl.bBn();
                    int i7 = (Nl.xb(32) && Nl.bAF().bzm()) ? 21 : 17;
                    c cVar = new c(bBn, i7, i6, "", Nl.bBr(), Nl.bAK());
                    com.tencent.mm.kernel.g.Ek();
                    com.tencent.mm.kernel.g.Eh().dpP.a(cVar, 0);
                    if (!(Nl.bAF().bzm() && e.Nf(Nl.bBp().field_adxml))) {
                        j.a(j.b.njT, a.njL, Nl);
                    }
                }
                String str = "";
                String s = an.s(af.getAccSnsPath(), ate.ksA);
                String str2 = "";
                String j = i.j(ate);
                if (FileOp.cn(s + j)) {
                    str = s + j;
                    str2 = s + i.e(ate);
                }
                if (FileOp.cn(s + i.p(ate))) {
                    str = s + i.p(ate);
                    str2 = s + i.n(ate);
                }
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                int width = view.getWidth();
                int height = view.getHeight();
                h.mEJ.h(11444, new Object[]{Integer.valueOf(3)});
                Intent intent;
                bsu bAJ;
                if (!xb) {
                    x.i("MicroMsg.TimelineClickListener", "it not ad video, use online video activity to play.");
                    intent = new Intent();
                    intent.setClass(this.olf.activity, SnsOnlineVideoActivity.class);
                    intent.putExtra("intent_videopath", str);
                    intent.putExtra("intent_thumbpath", str2);
                    intent.putExtra("intent_localid", akVar.bKW);
                    intent.putExtra("intent_isad", xb);
                    intent.putExtra("intent_from_scene", this.olf.scene);
                    intent.putExtra("img_gallery_left", iArr[0]);
                    intent.putExtra("img_gallery_top", iArr[1]);
                    intent.putExtra("img_gallery_width", width);
                    intent.putExtra("img_gallery_height", height);
                    io.b(intent, "intent_key_StatisticsOplog");
                    this.olf.activity.startActivity(intent);
                    this.olf.activity.overridePendingTransition(0, 0);
                    b.a(this.olf, Nl.bAJ());
                } else if (Nl.xb(32) && Nl.bAF().bzm() && e.Nf(Nl.bBp().field_adxml)) {
                    String w = e.w(Nl);
                    if (!bi.oW(w)) {
                        Nl.bBp().field_adxml = w;
                    }
                    intent = new Intent();
                    intent.putExtra("img_gallery_left", iArr[0]);
                    intent.putExtra("img_gallery_top", iArr[1]);
                    intent.putExtra("img_gallery_width", width);
                    intent.putExtra("img_gallery_height", height);
                    intent.putExtra("sns_landing_pages_share_sns_id", Nl.bAK());
                    intent.putExtra("sns_landing_pages_rawSnsId", Nl.bAJ().ksA);
                    intent.putExtra("sns_landing_pages_ux_info", Nl.bBo());
                    bAJ = Nl.bAJ();
                    if (bAJ != null) {
                        List list = bAJ.sqc.ruA;
                        if (list.size() > 0) {
                            intent.putExtra("sns_landing_pages_share_thumb_url", ((ate) list.get(0)).rVE);
                        }
                    }
                    intent.setClass(this.olf.activity, SnsAdNativeLandingPagesUI.class);
                    intent.putExtra("sns_landig_pages_from_source", this.olf.scene == 0 ? 1 : 2);
                    intent.putExtra("sns_landing_pages_xml", Nl.bBp().field_adxml);
                    intent.putExtra("sns_landing_pages_rec_src", Nl.bBq());
                    intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                    intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                    intent.putExtra("sns_landing_is_native_sight_ad", true);
                    this.olf.activity.startActivity(intent);
                    this.olf.activity.overridePendingTransition(0, 0);
                } else {
                    Intent intent2 = new Intent();
                    intent2.setClass(this.olf.activity, SnsSightPlayerUI.class);
                    intent2.putExtra("intent_videopath", str);
                    intent2.putExtra("intent_thumbpath", str2);
                    intent2.putExtra("intent_localid", akVar.bKW);
                    intent2.putExtra("intent_isad", xb);
                    intent2.putExtra("intent_from_scene", this.olf.scene);
                    intent2.putExtra("img_gallery_left", iArr[0]);
                    intent2.putExtra("img_gallery_top", iArr[1]);
                    intent2.putExtra("img_gallery_width", width);
                    intent2.putExtra("img_gallery_height", height);
                    io.b(intent2, "intent_key_StatisticsOplog");
                    this.olf.activity.startActivity(intent2);
                    this.olf.activity.overridePendingTransition(0, 0);
                    new ag().postDelayed(new 1(this, ate, akVar, Nl, bsu, xb), 500);
                    int[] iArr2 = new int[3];
                    if (!xb && af.byl().a(Nl, iArr2) > 5) {
                        af.byl().y(ate);
                        i = 1;
                    } else if (!xb || af.byl().b(Nl, iArr2) <= 5) {
                        i = 2;
                    } else {
                        af.byl().y(ate);
                        i = 1;
                    }
                    int i8 = iArr2[0];
                    int i9 = iArr2[1];
                    if (i == 2) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    width = iArr2[2];
                    bAJ = Nl.bAJ();
                    d dVar = new d();
                    dVar.r("20FeedId", bAJ.ksA + ",");
                    dVar.r("21AdUxInfo", Nl.bBo() + ",");
                    try {
                        boy boy = (boy) new boy().aG(Nl.field_attrBuf);
                        if (boy.smY != null) {
                            bpg bpg = (bpg) new bpg().aG(boy.smY.siK.lR);
                            if (bpg.snn != null) {
                                i3 = bpg.snn.rvt;
                                try {
                                    i4 = bpg.snn.rvu;
                                } catch (Exception e2) {
                                    e = e2;
                                    x.printErrStackTrace("MicroMsg.TimelineClickListener", e, "", new Object[0]);
                                    i4 = 0;
                                    dVar.r("22LayerId", i3 + ",");
                                    dVar.r("23ExpId", i4 + ",");
                                    dVar.r("24ClickState", i + ",");
                                    dVar.r("25ClickTime", bi.VE() + ",");
                                    i4 = 0;
                                    if (!ao.isWifi(ad.getContext())) {
                                        i4 = 1;
                                    } else if (ao.is2G(ad.getContext())) {
                                        i4 = 2;
                                    } else if (ao.is3G(ad.getContext())) {
                                        i4 = 3;
                                    } else if (ao.is4G(ad.getContext())) {
                                        i4 = 4;
                                    }
                                    dVar.r("26NetworkType", i4 + ",");
                                    dVar.r("27IsFlowControl", i8 + ",");
                                    dVar.r("28AutoDownloadSetting", i9 + ",");
                                    dVar.r("29IsAutoPlay", i2 + ",");
                                    dVar.r("30IsFlowControlDatePeriod", width + ",");
                                    x.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + dVar.wF());
                                    h.mEJ.h(13323, new Object[]{dVar});
                                }
                                dVar.r("22LayerId", i3 + ",");
                                dVar.r("23ExpId", i4 + ",");
                                dVar.r("24ClickState", i + ",");
                                dVar.r("25ClickTime", bi.VE() + ",");
                                i4 = 0;
                                if (!ao.isWifi(ad.getContext())) {
                                    i4 = 1;
                                } else if (ao.is2G(ad.getContext())) {
                                    i4 = 2;
                                } else if (ao.is3G(ad.getContext())) {
                                    i4 = 3;
                                } else if (ao.is4G(ad.getContext())) {
                                    i4 = 4;
                                }
                                dVar.r("26NetworkType", i4 + ",");
                                dVar.r("27IsFlowControl", i8 + ",");
                                dVar.r("28AutoDownloadSetting", i9 + ",");
                                dVar.r("29IsAutoPlay", i2 + ",");
                                dVar.r("30IsFlowControlDatePeriod", width + ",");
                                x.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + dVar.wF());
                                h.mEJ.h(13323, new Object[]{dVar});
                            }
                        }
                        i4 = 0;
                        i3 = 0;
                    } catch (Exception e3) {
                        e = e3;
                        i3 = 0;
                        x.printErrStackTrace("MicroMsg.TimelineClickListener", e, "", new Object[0]);
                        i4 = 0;
                        dVar.r("22LayerId", i3 + ",");
                        dVar.r("23ExpId", i4 + ",");
                        dVar.r("24ClickState", i + ",");
                        dVar.r("25ClickTime", bi.VE() + ",");
                        i4 = 0;
                        if (!ao.isWifi(ad.getContext())) {
                            i4 = 1;
                        } else if (ao.is2G(ad.getContext())) {
                            i4 = 2;
                        } else if (ao.is3G(ad.getContext())) {
                            i4 = 3;
                        } else if (ao.is4G(ad.getContext())) {
                            i4 = 4;
                        }
                        dVar.r("26NetworkType", i4 + ",");
                        dVar.r("27IsFlowControl", i8 + ",");
                        dVar.r("28AutoDownloadSetting", i9 + ",");
                        dVar.r("29IsAutoPlay", i2 + ",");
                        dVar.r("30IsFlowControlDatePeriod", width + ",");
                        x.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + dVar.wF());
                        h.mEJ.h(13323, new Object[]{dVar});
                    }
                    dVar.r("22LayerId", i3 + ",");
                    dVar.r("23ExpId", i4 + ",");
                    dVar.r("24ClickState", i + ",");
                    dVar.r("25ClickTime", bi.VE() + ",");
                    i4 = 0;
                    if (!ao.isWifi(ad.getContext())) {
                        i4 = 1;
                    } else if (ao.is2G(ad.getContext())) {
                        i4 = 2;
                    } else if (ao.is3G(ad.getContext())) {
                        i4 = 3;
                    } else if (ao.is4G(ad.getContext())) {
                        i4 = 4;
                    }
                    dVar.r("26NetworkType", i4 + ",");
                    dVar.r("27IsFlowControl", i8 + ",");
                    dVar.r("28AutoDownloadSetting", i9 + ",");
                    dVar.r("29IsAutoPlay", i2 + ",");
                    dVar.r("30IsFlowControlDatePeriod", width + ",");
                    x.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + dVar.wF());
                    h.mEJ.h(13323, new Object[]{dVar});
                }
            }
        }
    }
}
