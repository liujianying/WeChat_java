package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.ak;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.av;
import java.util.List;

class b$27 implements OnClickListener {
    final /* synthetic */ b olf;

    b$27(b bVar) {
        this.olf = bVar;
    }

    public final void onClick(View view) {
        if (view.getTag() == null) {
            return;
        }
        if ((view.getTag() instanceof c) || (view.getTag() instanceof ap) || (view.getTag() instanceof ak) || (view.getTag() instanceof MaskImageView)) {
            Object obj;
            int obj2;
            int i;
            int i2;
            int i3;
            Object obj3;
            Object obj4;
            n nVar;
            MaskImageView maskImageView;
            c cVar;
            n nVar2 = null;
            Object obj5 = null;
            int i4 = 0;
            if (view.getTag() instanceof ap) {
                n Nl = h.Nl(((ap) view.getTag()).bNH);
                if (view instanceof LinearLayout) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                if (((ap) view.getTag()).nRF) {
                    int i5 = ((ap) view.getTag()).index;
                    if (i5 > 0) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    i4 = i5;
                    obj5 = 1;
                } else {
                    i = 0;
                }
                i2 = i;
                i3 = i4;
                obj3 = obj5;
                obj4 = obj2;
                nVar = Nl;
            } else if (view.getTag() instanceof MaskImageView) {
                Object obj6;
                maskImageView = (MaskImageView) view.getTag();
                if (maskImageView.getTag() instanceof ap) {
                    nVar = h.Nl(((ap) maskImageView.getTag()).bNH);
                    if (view instanceof LinearLayout) {
                        i2 = 0;
                        i3 = 0;
                        obj3 = null;
                        obj4 = null;
                    } else {
                        obj6 = 1;
                        nVar2 = nVar;
                    }
                } else {
                    obj6 = null;
                }
                i2 = 0;
                i3 = 0;
                obj3 = null;
                obj4 = obj6;
                nVar = nVar2;
            } else if (view.getTag() instanceof ak) {
                nVar = af.byo().Nl(((ak) view.getTag()).bKW);
                if (view instanceof LinearLayout) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                if (((ak) view.getTag()).nRF) {
                    obj5 = 1;
                    i4 = ((ak) view.getTag()).nRG;
                    i = i4 > 0 ? 2 : 1;
                } else {
                    i = 0;
                }
                i2 = i;
                i3 = i4;
                obj3 = obj5;
                obj4 = obj2;
            } else {
                cVar = (c) view.getTag();
                nVar = h.Nk(cVar.bSZ);
                if (cVar.ojK != null) {
                    i4 = cVar.ojK.index;
                    i2 = i4 > 0 ? 2 : 1;
                    i3 = i4;
                    int obj32 = 1;
                    obj4 = null;
                } else {
                    i2 = 0;
                    i3 = 0;
                    obj32 = null;
                    obj4 = null;
                }
            }
            if (nVar != null && nVar.xb(32)) {
                String str;
                String str2;
                String bzp;
                try {
                    a bAH = nVar.bAH();
                    if (bAH == null) {
                        obj2 = "";
                    } else {
                        str = bAH.fvT;
                    }
                    str2 = nVar.bAJ().ksA;
                    if (!nVar.bzx()) {
                        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.mEJ;
                        Object[] objArr = new Object[4];
                        objArr[0] = Integer.valueOf(this.olf.scene == 0 ? 1 : 2);
                        objArr[1] = Integer.valueOf(obj4 != null ? 1 : 2);
                        objArr[2] = str2;
                        objArr[3] = obj2;
                        hVar.h(14066, objArr);
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.TimelineClickListener", "report click ad card style error " + e.getMessage());
                }
                if (nVar.bBp().bAF().bzt()) {
                    bzp = nVar.bBp().bAF().bzp();
                    str = nVar.bBo();
                    g.Eg();
                    str2 = com.tencent.mm.kernel.a.Dg();
                    v.g(bzp, str, str2, v.ae(bzp, str, str2), 0);
                }
                bsu bAJ = nVar.bAJ();
                int i6;
                String str3;
                int i7;
                com.tencent.mm.plugin.sns.a.b.c cVar2;
                bsu bAJ2;
                List list;
                Intent intent;
                boolean z;
                SnsAdClick snsAdClick;
                a bAH2;
                Bundle bundle;
                if ((bAJ.sqc.ruz == 15 && bAJ.sqj != 1) || (bAJ.sqc.ruz == 27 && bAJ.sqc.ruA.size() > i3 && ((ate) bAJ.sqc.ruA.get(i3)).hcE == 6)) {
                    ak akVar;
                    c cVar3;
                    ak akVar2;
                    x.i("MicroMsg.TimelineClickListener", "onsight click");
                    if (view.getTag() instanceof ak) {
                        akVar = (ak) view.getTag();
                    } else {
                        akVar = null;
                    }
                    if (view.getTag() instanceof c) {
                        cVar = (c) view.getTag();
                        if (bAJ.sqc.ruz == 27) {
                            akVar = cVar.ojL;
                        } else if (cVar.ojH.nRC != null && (cVar.ojH.nRC.getTag() instanceof ak)) {
                            akVar = (ak) cVar.ojH.nRC.getTag();
                        }
                        if (akVar != null) {
                            cVar3 = cVar;
                            akVar2 = akVar;
                        } else {
                            return;
                        }
                    }
                    cVar3 = null;
                    akVar2 = akVar;
                    if (nVar != null) {
                        if (this.olf.nMm != null) {
                            this.olf.nMm.bxT().v(nVar);
                        }
                        boolean xb = nVar.xb(32);
                        bsu bsu = akVar2.nRA;
                        if (bsu.sqc.ruA == null || bsu.sqc.ruA.size() == 0) {
                            x.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                            return;
                        }
                        Object obj7;
                        b io;
                        String j;
                        int[] iArr;
                        int i8;
                        ate ate = (ate) bsu.sqc.ruA.get(i3);
                        if (xb) {
                            af.byl();
                            if (!com.tencent.mm.plugin.sns.model.g.t(ate)) {
                                akVar2.nEI.setVisibility(8);
                                akVar2.nRD.setVisibility(0);
                                akVar2.nRD.cAt();
                                af.byl().z(ate);
                                com.tencent.mm.plugin.sns.model.b byj = af.byj();
                                av clY = av.clY();
                                clY.time = bsu.lOH;
                                byj.a(ate, 4, null, clY);
                                if (xb) {
                                    j.a(j.b.njT, j.a.njK, nVar);
                                    return;
                                }
                                return;
                            }
                        }
                        if (nVar.xb(32) && nVar.bAF().bzm()) {
                            if (e.eL(nVar.bBp().field_adxml, i3 > 0 ? "adTurnCanvasInfo" : "adCanvasInfo")) {
                                obj7 = 1;
                                if (obj7 != null && xb && af.byl().u(ate)) {
                                    af.byl().z(ate);
                                    akVar2.nEI.setVisibility(8);
                                    akVar2.nRD.setVisibility(8);
                                    com.tencent.mm.plugin.sns.model.g byl = af.byl();
                                    com.tencent.mm.plugin.sight.decode.a.a aVar = akVar2.neL;
                                    i4 = this.olf.activity.hashCode();
                                    i6 = akVar2.position;
                                    av clY2 = av.clY();
                                    clY2.time = bsu.lOH;
                                    byl.a(nVar, ate, aVar, i4, i6, clY2, xb);
                                    if (xb) {
                                        j.a(j.b.njT, j.a.njK, nVar);
                                        return;
                                    }
                                    return;
                                }
                                if (this.olf.scene != 0) {
                                    io = b.io(717);
                                } else {
                                    io = b.ip(717);
                                }
                                io.nb(i.g(nVar)).ir(nVar.field_type).bP(nVar.xb(32)).nb(nVar.bBo()).nb(ate.ksA);
                                io.RD();
                                if (this.olf.scene != 0) {
                                    io = b.io(745);
                                } else {
                                    io = b.ip(745);
                                }
                                io.nb(i.g(nVar)).ir(nVar.field_type).bP(nVar.xb(32));
                                bzp = an.s(af.getAccSnsPath(), ate.ksA);
                                j = i.j(ate);
                                if (FileOp.cn(bzp + j)) {
                                    new StringBuilder().append(bzp).append(j);
                                    new StringBuilder().append(bzp).append(i.e(ate));
                                }
                                if (FileOp.cn(bzp + i.p(ate))) {
                                    new StringBuilder().append(bzp).append(i.p(ate));
                                    new StringBuilder().append(bzp).append(i.n(ate));
                                }
                                iArr = new int[2];
                                i = 0;
                                if (cVar3 == null) {
                                    if (cVar3.ojH.nRC != null) {
                                        cVar3.ojH.nRC.getLocationInWindow(iArr);
                                        obj2 = cVar3.ojH.nRC.getWidth();
                                        i = cVar3.ojH.nRC.getHeight();
                                        i8 = obj2;
                                    } else if (cVar3.ojI != null) {
                                        cVar3.ojI.getLocationInWindow(iArr);
                                        obj2 = cVar3.ojI.getWidth();
                                        i = cVar3.ojI.getHeight();
                                        i8 = obj2;
                                    } else {
                                        i8 = 0;
                                    }
                                } else if (view.getTag() instanceof ak) {
                                    ak akVar3 = (ak) view.getTag();
                                    if (akVar3 != null) {
                                        akVar3.nRC.getLocationInWindow(iArr);
                                    }
                                    obj2 = akVar3.nRC.getWidth();
                                    i = akVar3.nRC.getHeight();
                                    i8 = obj2;
                                } else {
                                    if (view != null) {
                                        view.getLocationInWindow(iArr);
                                    }
                                    obj2 = view.getWidth();
                                    i = view.getHeight();
                                    i8 = obj2;
                                }
                                com.tencent.mm.plugin.report.service.h.mEJ.h(11444, new Object[]{Integer.valueOf(3)});
                                if (obj7 == null) {
                                    str2 = nVar.bBn();
                                    i6 = this.olf.scene == 0 ? 1 : 2;
                                    str3 = "";
                                    if (obj32 != null) {
                                        i7 = 6;
                                    } else {
                                        i7 = 5;
                                    }
                                    if (nVar.bBp() != null) {
                                        nVar.bBp().getSource();
                                    }
                                    cVar2 = new com.tencent.mm.plugin.sns.a.b.c(str2, 22, i6, str3, i7, 21, nVar.bAJ().nNV, nVar.bAK(), i2);
                                    g.Ek();
                                    g.Eh().dpP.a(cVar2, 0);
                                    Intent intent2 = new Intent();
                                    intent2.putExtra("img_gallery_left", iArr[0]);
                                    intent2.putExtra("img_gallery_top", iArr[1]);
                                    intent2.putExtra("img_gallery_width", i8);
                                    intent2.putExtra("img_gallery_height", i);
                                    intent2.putExtra("sns_landing_pages_share_sns_id", nVar.bAK());
                                    intent2.putExtra("sns_landing_pages_rawSnsId", nVar.bAJ().ksA);
                                    intent2.putExtra("sns_landing_pages_ux_info", nVar.bBo());
                                    bAJ2 = nVar.bAJ();
                                    if (bAJ2 != null) {
                                        list = bAJ2.sqc.ruA;
                                        if (list.size() > i3) {
                                            intent2.putExtra("sns_landing_pages_share_thumb_url", ((ate) list.get(i3)).rVE);
                                        }
                                    }
                                    intent2.setClass(this.olf.activity, SnsAdNativeLandingPagesUI.class);
                                    intent2.putExtra("sns_landig_pages_from_source", this.olf.scene == 0 ? 1 : 2);
                                    intent2.putExtra("sns_landing_pages_xml", i3 > 0 ? nVar.bAF().bzw() : nVar.bBp().field_adxml);
                                    intent2.putExtra("sns_landing_pages_rec_src", nVar.bBq());
                                    intent2.putExtra("sns_landing_pages_xml_prefix", "adxml");
                                    intent2.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                                    intent2.putExtra("sns_landing_is_native_sight_ad", true);
                                    this.olf.activity.startActivity(intent2);
                                    this.olf.activity.overridePendingTransition(0, 0);
                                }
                                if (b.a(this.olf, nVar.bAH(), nVar, i3 > 0)) {
                                    str2 = nVar.bBn();
                                    i6 = this.olf.scene == 0 ? 1 : 2;
                                    str3 = "";
                                    i7 = nVar.bBr();
                                    if (nVar.bBp() != null) {
                                        nVar.bBp().getSource();
                                    }
                                    cVar2 = new com.tencent.mm.plugin.sns.a.b.c(str2, 22, i6, str3, i7, 31, nVar.bAJ().nNV, nVar.bAK(), i2);
                                    g.Ek();
                                    g.Eh().dpP.a(cVar2, 0);
                                    return;
                                }
                                str2 = nVar.bBn();
                                i6 = this.olf.scene == 0 ? 1 : 2;
                                str3 = "";
                                i7 = obj32 != null ? 6 : 5;
                                if (nVar.bBp() != null) {
                                    nVar.bBp().getSource();
                                }
                                cVar2 = new com.tencent.mm.plugin.sns.a.b.c(str2, 22, i6, str3, i7, 0, nVar.bAJ().nNV, nVar.bAK(), i2);
                                g.Ek();
                                g.Eh().dpP.a(cVar2, 0);
                                bzp = i3 > 0 ? nVar.bAF().nzv.nxZ : nVar.bBm();
                                if (bi.oW(bzp)) {
                                    bzp = nVar.bBl();
                                }
                                if (!bi.oW(bzp)) {
                                    x.i("MicroMsg.TimelineClickListener", "adlink url " + bzp + " " + nVar.bAF().nyE);
                                    intent = new Intent();
                                    z = nVar.bAF().nyE == 0;
                                    if (com.tencent.mm.platformtools.af.exv) {
                                        z = false;
                                    }
                                    snsAdClick = new SnsAdClick(nVar.bBn(), this.olf.scene == 0 ? 1 : 2, nVar.field_snsId, nVar.bBo(), obj32 != null ? 6 : 5, (byte) 0);
                                    snsAdClick.egI = nVar.bAJ().ksA;
                                    if (nVar != null && nVar.xb(32)) {
                                        bAH2 = nVar.bAH();
                                        if (bAH2 != null) {
                                            intent.putExtra("KsnsViewId", bAH2.fvT);
                                        }
                                    }
                                    intent.putExtra("KRightBtn", z);
                                    bundle = new Bundle();
                                    bundle.putParcelable("KSnsAdTag", snsAdClick);
                                    bundle.putString("key_snsad_statextstr", nVar.bAJ().nNV);
                                    intent.putExtra("jsapiargs", bundle);
                                    intent.putExtra("rawUrl", bzp);
                                    intent.putExtra("useJs", true);
                                    intent.putExtra("srcUsername", nVar.field_userName);
                                    intent.putExtra("stastic_scene", 15);
                                    intent.putExtra("KPublisherId", "sns_" + i.eF(nVar.field_snsId));
                                    intent.putExtra("pre_username", nVar.field_userName);
                                    intent.putExtra("prePublishId", "sns_" + i.eF(nVar.field_snsId));
                                    intent.putExtra("preUsername", nVar.field_userName);
                                    com.tencent.mm.plugin.sns.c.a.ezn.j(intent, this.olf.activity);
                                    return;
                                }
                                return;
                            }
                        }
                        obj7 = null;
                        if (obj7 != null) {
                        }
                        if (this.olf.scene != 0) {
                            io = b.ip(717);
                        } else {
                            io = b.io(717);
                        }
                        io.nb(i.g(nVar)).ir(nVar.field_type).bP(nVar.xb(32)).nb(nVar.bBo()).nb(ate.ksA);
                        io.RD();
                        if (this.olf.scene != 0) {
                            io = b.ip(745);
                        } else {
                            io = b.io(745);
                        }
                        io.nb(i.g(nVar)).ir(nVar.field_type).bP(nVar.xb(32));
                        bzp = an.s(af.getAccSnsPath(), ate.ksA);
                        j = i.j(ate);
                        if (FileOp.cn(bzp + j)) {
                            new StringBuilder().append(bzp).append(j);
                            new StringBuilder().append(bzp).append(i.e(ate));
                        }
                        if (FileOp.cn(bzp + i.p(ate))) {
                            new StringBuilder().append(bzp).append(i.p(ate));
                            new StringBuilder().append(bzp).append(i.n(ate));
                        }
                        iArr = new int[2];
                        i = 0;
                        if (cVar3 == null) {
                            if (view.getTag() instanceof ak) {
                                ak akVar32 = (ak) view.getTag();
                                if (akVar32 != null) {
                                    akVar32.nRC.getLocationInWindow(iArr);
                                }
                                obj2 = akVar32.nRC.getWidth();
                                i = akVar32.nRC.getHeight();
                                i8 = obj2;
                            } else {
                                if (view != null) {
                                    view.getLocationInWindow(iArr);
                                }
                                obj2 = view.getWidth();
                                i = view.getHeight();
                                i8 = obj2;
                            }
                        } else if (cVar3.ojH.nRC != null) {
                            cVar3.ojH.nRC.getLocationInWindow(iArr);
                            obj2 = cVar3.ojH.nRC.getWidth();
                            i = cVar3.ojH.nRC.getHeight();
                            i8 = obj2;
                        } else if (cVar3.ojI != null) {
                            cVar3.ojI.getLocationInWindow(iArr);
                            obj2 = cVar3.ojI.getWidth();
                            i = cVar3.ojI.getHeight();
                            i8 = obj2;
                        } else {
                            i8 = 0;
                        }
                        com.tencent.mm.plugin.report.service.h.mEJ.h(11444, new Object[]{Integer.valueOf(3)});
                        if (obj7 == null) {
                            if (b.a(this.olf, nVar.bAH(), nVar, i3 > 0)) {
                                str2 = nVar.bBn();
                                i6 = this.olf.scene == 0 ? 1 : 2;
                                str3 = "";
                                i7 = nVar.bBr();
                                if (nVar.bBp() != null) {
                                    nVar.bBp().getSource();
                                }
                                cVar2 = new com.tencent.mm.plugin.sns.a.b.c(str2, 22, i6, str3, i7, 31, nVar.bAJ().nNV, nVar.bAK(), i2);
                                g.Ek();
                                g.Eh().dpP.a(cVar2, 0);
                                return;
                            }
                            str2 = nVar.bBn();
                            i6 = this.olf.scene == 0 ? 1 : 2;
                            str3 = "";
                            i7 = obj32 != null ? 6 : 5;
                            if (nVar.bBp() != null) {
                                nVar.bBp().getSource();
                            }
                            cVar2 = new com.tencent.mm.plugin.sns.a.b.c(str2, 22, i6, str3, i7, 0, nVar.bAJ().nNV, nVar.bAK(), i2);
                            g.Ek();
                            g.Eh().dpP.a(cVar2, 0);
                            bzp = i3 > 0 ? nVar.bAF().nzv.nxZ : nVar.bBm();
                            if (bi.oW(bzp)) {
                                bzp = nVar.bBl();
                            }
                            if (!bi.oW(bzp)) {
                                x.i("MicroMsg.TimelineClickListener", "adlink url " + bzp + " " + nVar.bAF().nyE);
                                intent = new Intent();
                                z = nVar.bAF().nyE == 0;
                                if (com.tencent.mm.platformtools.af.exv) {
                                    z = false;
                                }
                                snsAdClick = new SnsAdClick(nVar.bBn(), this.olf.scene == 0 ? 1 : 2, nVar.field_snsId, nVar.bBo(), obj32 != null ? 6 : 5, (byte) 0);
                                snsAdClick.egI = nVar.bAJ().ksA;
                                if (nVar != null && nVar.xb(32)) {
                                    bAH2 = nVar.bAH();
                                    if (bAH2 != null) {
                                        intent.putExtra("KsnsViewId", bAH2.fvT);
                                    }
                                }
                                intent.putExtra("KRightBtn", z);
                                bundle = new Bundle();
                                bundle.putParcelable("KSnsAdTag", snsAdClick);
                                bundle.putString("key_snsad_statextstr", nVar.bAJ().nNV);
                                intent.putExtra("jsapiargs", bundle);
                                intent.putExtra("rawUrl", bzp);
                                intent.putExtra("useJs", true);
                                intent.putExtra("srcUsername", nVar.field_userName);
                                intent.putExtra("stastic_scene", 15);
                                intent.putExtra("KPublisherId", "sns_" + i.eF(nVar.field_snsId));
                                intent.putExtra("pre_username", nVar.field_userName);
                                intent.putExtra("prePublishId", "sns_" + i.eF(nVar.field_snsId));
                                intent.putExtra("preUsername", nVar.field_userName);
                                com.tencent.mm.plugin.sns.c.a.ezn.j(intent, this.olf.activity);
                                return;
                            }
                            return;
                        }
                        str2 = nVar.bBn();
                        i6 = this.olf.scene == 0 ? 1 : 2;
                        str3 = "";
                        if (obj32 != null) {
                            i7 = 6;
                        } else {
                            i7 = 5;
                        }
                        if (nVar.bBp() != null) {
                            nVar.bBp().getSource();
                        }
                        cVar2 = new com.tencent.mm.plugin.sns.a.b.c(str2, 22, i6, str3, i7, 21, nVar.bAJ().nNV, nVar.bAK(), i2);
                        g.Ek();
                        g.Eh().dpP.a(cVar2, 0);
                        Intent intent22 = new Intent();
                        intent22.putExtra("img_gallery_left", iArr[0]);
                        intent22.putExtra("img_gallery_top", iArr[1]);
                        intent22.putExtra("img_gallery_width", i8);
                        intent22.putExtra("img_gallery_height", i);
                        intent22.putExtra("sns_landing_pages_share_sns_id", nVar.bAK());
                        intent22.putExtra("sns_landing_pages_rawSnsId", nVar.bAJ().ksA);
                        intent22.putExtra("sns_landing_pages_ux_info", nVar.bBo());
                        bAJ2 = nVar.bAJ();
                        if (bAJ2 != null) {
                            list = bAJ2.sqc.ruA;
                            if (list.size() > i3) {
                                intent22.putExtra("sns_landing_pages_share_thumb_url", ((ate) list.get(i3)).rVE);
                            }
                        }
                        intent22.setClass(this.olf.activity, SnsAdNativeLandingPagesUI.class);
                        intent22.putExtra("sns_landig_pages_from_source", this.olf.scene == 0 ? 1 : 2);
                        intent22.putExtra("sns_landing_pages_xml", i3 > 0 ? nVar.bAF().bzw() : nVar.bBp().field_adxml);
                        intent22.putExtra("sns_landing_pages_rec_src", nVar.bBq());
                        intent22.putExtra("sns_landing_pages_xml_prefix", "adxml");
                        intent22.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                        intent22.putExtra("sns_landing_is_native_sight_ad", true);
                        this.olf.activity.startActivity(intent22);
                        this.olf.activity.overridePendingTransition(0, 0);
                    }
                } else if ((bAJ.sqc.ruz == 1 && bAJ.sqc.ruA.size() == 1) || bAJ.sqc.ruz == 7 || (bAJ.sqc.ruz == 27 && bAJ.sqc.ruA.size() > i3 && ((ate) bAJ.sqc.ruA.get(i3)).hcE == 2)) {
                    TagImageView tagImageView;
                    if (view.getTag() instanceof c) {
                        cVar = (c) view.getTag();
                        if (bAJ.sqc.ruz == 27) {
                            tagImageView = (TagImageView) cVar.ojK.view;
                        } else {
                            tagImageView = cVar.oji.xm(0);
                        }
                    } else if (view.getTag() instanceof MaskImageView) {
                        maskImageView = (MaskImageView) view.getTag();
                    } else {
                        tagImageView = (TagImageView) view;
                    }
                    if (tagImageView.getTag() instanceof ap) {
                        if (nVar.bAF().bzm()) {
                            if (e.eL(nVar.bBp().field_adxml, i3 > 0 ? "adTurnCanvasInfo" : "adCanvasInfo")) {
                                str2 = nVar.bBn();
                                i6 = this.olf.scene == 0 ? 1 : 2;
                                str3 = "";
                                if (obj32 != null) {
                                    i7 = 6;
                                } else {
                                    i7 = 4;
                                }
                                if (nVar.bBp() != null) {
                                    nVar.bBp().getSource();
                                }
                                cVar2 = new com.tencent.mm.plugin.sns.a.b.c(str2, 22, i6, str3, i7, 21, nVar.bAJ().nNV, nVar.bAK(), i2);
                                g.Ek();
                                g.Eh().dpP.a(cVar2, 0);
                                int[] iArr2 = new int[2];
                                if (tagImageView != null) {
                                    tagImageView.getLocationInWindow(iArr2);
                                }
                                int width = tagImageView.getWidth();
                                i = tagImageView.getHeight();
                                Intent intent3 = new Intent();
                                intent3.putExtra("img_gallery_left", iArr2[0]);
                                intent3.putExtra("img_gallery_top", iArr2[1]);
                                intent3.putExtra("img_gallery_width", width);
                                intent3.putExtra("img_gallery_height", i);
                                intent3.putExtra("sns_landing_pages_share_sns_id", nVar.bAK());
                                intent3.putExtra("sns_landing_pages_rawSnsId", nVar.bAJ().ksA);
                                intent3.putExtra("sns_landing_pages_ux_info", nVar.bBo());
                                intent3.putExtra("sns_landing_pages_aid", nVar.bBj());
                                intent3.putExtra("sns_landing_pages_traceid", nVar.bBk());
                                bAJ2 = nVar.bAJ();
                                if (bAJ2 != null) {
                                    list = bAJ2.sqc.ruA;
                                    if (list.size() > i3) {
                                        intent3.putExtra("sns_landing_pages_share_thumb_url", ((ate) list.get(i3)).rVE);
                                    } else if (list.size() > 0) {
                                        intent3.putExtra("sns_landing_pages_share_thumb_url", ((ate) list.get(0)).rVE);
                                    }
                                }
                                intent3.setClass(this.olf.activity, SnsAdNativeLandingPagesUI.class);
                                intent3.putExtra("sns_landig_pages_from_source", this.olf.scene == 0 ? 1 : 2);
                                intent3.putExtra("sns_landing_pages_xml", i3 > 0 ? nVar.bAF().bzw() : nVar.bBp().field_adxml);
                                intent3.putExtra("sns_landing_pages_rec_src", nVar.bBq());
                                intent3.putExtra("sns_landing_pages_xml_prefix", "adxml");
                                intent3.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                                this.olf.activity.startActivity(intent3);
                                this.olf.activity.overridePendingTransition(0, 0);
                                if (this.olf.nMm != null) {
                                    this.olf.nMm.bxT().v(nVar);
                                    return;
                                }
                                return;
                            }
                        }
                        if (b.a(this.olf, nVar.bAH(), nVar, i3 > 0)) {
                            str2 = nVar.bBn();
                            i6 = this.olf.scene == 0 ? 1 : 2;
                            str3 = "";
                            i7 = nVar.bBr();
                            if (nVar.bBp() != null) {
                                nVar.bBp().getSource();
                            }
                            cVar2 = new com.tencent.mm.plugin.sns.a.b.c(str2, 22, i6, str3, i7, 31, nVar.bAJ().nNV, nVar.bAK(), i2);
                            g.Ek();
                            g.Eh().dpP.a(cVar2, 0);
                            return;
                        }
                        bzp = i3 > 0 ? nVar.bAF().nzv.nxZ : nVar.bBm();
                        if (bi.oW(bzp)) {
                            bzp = nVar.bBl();
                        }
                        if (!bi.oW(bzp)) {
                            str2 = nVar.bBn();
                            i6 = this.olf.scene == 0 ? 1 : 2;
                            str3 = "";
                            i7 = obj32 != null ? 6 : 4;
                            if (nVar.bBp() != null) {
                                nVar.bBp().getSource();
                            }
                            cVar2 = new com.tencent.mm.plugin.sns.a.b.c(str2, 22, i6, str3, i7, 0, nVar.bAJ().nNV, nVar.bAK(), i2);
                            g.Ek();
                            g.Eh().dpP.a(cVar2, 0);
                            x.i("MicroMsg.TimelineClickListener", "adlink url " + bzp + " " + nVar.bAF().nyE);
                            intent = new Intent();
                            z = nVar.bAF().nyE == 0;
                            if (com.tencent.mm.platformtools.af.exv) {
                                z = false;
                            }
                            snsAdClick = new SnsAdClick(nVar.bBn(), this.olf.scene == 0 ? 1 : 2, nVar.field_snsId, nVar.bBo(), obj32 != null ? 6 : 4, (byte) 0);
                            snsAdClick.egI = nVar.bAJ().ksA;
                            if (nVar != null && nVar.xb(32)) {
                                bAH2 = nVar.bAH();
                                if (bAH2 != null) {
                                    intent.putExtra("KsnsViewId", bAH2.fvT);
                                }
                            }
                            intent.putExtra("KRightBtn", z);
                            bundle = new Bundle();
                            bundle.putParcelable("KSnsAdTag", snsAdClick);
                            bundle.putString("key_snsad_statextstr", nVar.bAJ().nNV);
                            intent.putExtra("jsapiargs", bundle);
                            intent.putExtra("rawUrl", bzp);
                            intent.putExtra("useJs", true);
                            intent.putExtra("srcUsername", nVar.field_userName);
                            intent.putExtra("stastic_scene", 15);
                            intent.putExtra("KPublisherId", "sns_" + i.eF(nVar.field_snsId));
                            intent.putExtra("pre_username", nVar.field_userName);
                            intent.putExtra("prePublishId", "sns_" + i.eF(nVar.field_snsId));
                            intent.putExtra("preUsername", nVar.field_userName);
                            com.tencent.mm.plugin.sns.c.a.ezn.j(intent, this.olf.activity);
                        }
                    }
                }
            }
        }
    }
}
