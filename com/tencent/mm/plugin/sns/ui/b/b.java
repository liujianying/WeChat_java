package com.tencent.mm.plugin.sns.ui.b;

import android.app.Activity;
import android.content.Intent;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.ak;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.plugin.sns.ui.av$a;
import com.tencent.mm.plugin.sns.ui.m;
import com.tencent.mm.plugin.sns.ui.r;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.av;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.util.List;

public abstract class b {
    Activity activity;
    public OnTouchListener hqR;
    private ClipboardManager jdw;
    ae nMm;
    public OnClickListener nNR;
    public OnClickListener okA;
    public OnClickListener okB;
    public OnClickListener okC;
    public OnClickListener okD;
    public OnClickListener okE;
    public OnClickListener okF;
    public OnClickListener okG;
    public OnClickListener okH;
    public c okI;
    public c okJ;
    public c okK;
    public c okL;
    public c okM;
    public c okN;
    public c okO;
    c okP;
    public OnClickListener okQ;
    public OnClickListener okR;
    public OnClickListener okS;
    public OnClickListener okT;
    public OnClickListener okU;
    public OnClickListener okV;
    public OnClickListener okW;
    public OnItemClickListener okX;
    public OnItemClickListener okY;
    public OnClickListener okZ = new 1(this);
    public e okp;
    public a okv;
    public OnClickListener okw;
    public OnLongClickListener okx;
    public c oky;
    public OnClickListener okz;
    public OnClickListener ola = new 12(this);
    public OnClickListener olb;
    public av$a olc;
    int old;
    public OnClickListener ole = new 30(this);
    int scene = 0;

    public abstract void b(View view, int i, int i2, int i3);

    public abstract void bBS();

    public abstract void bBT();

    public abstract void bS(Object obj);

    public abstract void cE(View view);

    public abstract void cF(View view);

    public abstract void cG(View view);

    public abstract void cH(View view);

    public abstract void cI(View view);

    public abstract void cJ(View view);

    static /* synthetic */ void a(b bVar, View view, n nVar, int i, String str, boolean z) {
        c cVar;
        ak akVar;
        ak akVar2 = null;
        if (view.getTag() instanceof ak) {
            akVar2 = (ak) view.getTag();
        }
        if (view.getTag() instanceof c) {
            c cVar2 = (c) view.getTag();
            if (cVar2.ojH.nRC.getTag() instanceof ak) {
                cVar = cVar2;
                akVar = (ak) cVar2.ojH.nRC.getTag();
            } else {
                return;
            }
        }
        cVar = null;
        akVar = akVar2;
        if (nVar != null && akVar != null) {
            if (bVar.nMm != null) {
                bVar.nMm.bxT().v(nVar);
            }
            boolean xb = nVar.xb(32);
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
                    com.tencent.mm.plugin.sns.model.b byj = af.byj();
                    av clY = av.clY();
                    clY.time = bsu.lOH;
                    byj.a(ate, 4, null, clY);
                    return;
                }
            }
            Object obj = (nVar.xb(32) && nVar.bAF().bzm() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Nf(str)) ? 1 : null;
            int i2;
            if (obj == null && xb && af.byl().u(ate)) {
                af.byl().z(ate);
                akVar.nEI.setVisibility(8);
                akVar.nRD.setVisibility(8);
                g byl = af.byl();
                a aVar = akVar.neL;
                int hashCode = bVar.activity.hashCode();
                i2 = akVar.position;
                av clY2 = av.clY();
                clY2.time = bsu.lOH;
                byl.a(nVar, ate, aVar, hashCode, i2, clY2, xb);
                return;
            }
            int height;
            int i3;
            int[] iArr = new int[2];
            int i4 = 0;
            if (cVar != null) {
                if (cVar.ojH.nRC != null) {
                    cVar.ojH.nRC.getLocationInWindow(iArr);
                }
                i4 = cVar.ojH.nRC.getWidth();
                height = cVar.ojH.nRC.getHeight();
                i3 = i4;
            } else if (view.getTag() instanceof ak) {
                int height2;
                akVar2 = (ak) view.getTag();
                if (akVar2 != null) {
                    akVar2.nRC.getLocationInWindow(iArr);
                    int width = akVar2.nRC.getWidth();
                    height2 = akVar2.nRC.getHeight();
                    i4 = width;
                } else {
                    height2 = 0;
                }
                height = height2;
                i3 = i4;
            } else if (view != null) {
                view.getLocationInWindow(iArr);
                i4 = view.getWidth();
                height = view.getHeight();
                i3 = i4;
            } else {
                height = 0;
                i3 = 0;
            }
            if (nVar.xb(32) && nVar.bAF().bzm() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Nf(str)) {
                String w = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(nVar);
                if (!bi.oW(w)) {
                    nVar.bBp().field_adxml = w;
                }
                String bBn = nVar.bBn();
                int i5 = bVar.scene == 0 ? 1 : 2;
                String str2 = "";
                i2 = nVar.bBr();
                int i6 = z ? 22 : 21;
                if (nVar.bBp() != null) {
                    nVar.bBp().getSource();
                }
                com.tencent.mm.kernel.g.Eh().dpP.a(new com.tencent.mm.plugin.sns.a.b.c(bBn, i, i5, str2, i2, i6, nVar.bAJ().nNV, nVar.bAK()), 0);
                Intent intent = new Intent();
                intent.putExtra("img_gallery_left", iArr[0]);
                intent.putExtra("img_gallery_top", iArr[1]);
                intent.putExtra("img_gallery_width", i3);
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
                intent.setClass(bVar.activity, SnsAdNativeLandingPagesUI.class);
                intent.putExtra("sns_landig_pages_from_source", bVar.scene == 0 ? 1 : 2);
                intent.putExtra("sns_landing_pages_xml", str);
                intent.putExtra("sns_landing_pages_rec_src", nVar.bBq());
                intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                intent.putExtra("sns_landing_is_native_sight_ad", true);
                bVar.activity.startActivity(intent);
                bVar.activity.overridePendingTransition(0, 0);
                return;
            }
            x.e("MicroMsg.TimelineClickListener", "cardSelectLeftLsn invalid ad style");
        }
    }

    static /* synthetic */ void a(b bVar, bsu bsu) {
        if (bsu != null && bsu.nsB != null && bsu.nsB.raS != null && com.tencent.mm.pluginsdk.model.app.g.cU(bsu.nsB.raS.jQb)) {
            com.tencent.mm.protocal.c.av avVar = bsu.nsB;
            com.tencent.mm.plugin.sns.c.a.ezo.a(bVar.activity, avVar.raS.jQb, com.tencent.mm.plugin.sns.c.a.ezo.cS(avVar.raS.jQb), bsu.hbL, 38, 19, 10, avVar.raS.raM, bsu.ksA);
        }
    }

    static /* synthetic */ boolean a(b bVar, com.tencent.mm.plugin.sns.storage.a aVar, n nVar, boolean z) {
        if (aVar != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (z && nVar.bAF().nzv.bPg != null) {
                str = nVar.bAF().nzv.bPg;
                str2 = nVar.bAF().nzv.bGH;
                str3 = nVar.bAF().nzv.bvk;
            } else if (!(z || aVar.nxV != 4 || aVar.nyn == null)) {
                str = aVar.nyn.bPg;
                str2 = aVar.nyn.bGH;
                str3 = aVar.nyn.bvk;
            }
            if (!bi.oW(str)) {
                if (!bi.oW(str2)) {
                    r5 = new String[2];
                    r5[0] = String.format("gdt_vid=%s", new Object[]{nVar.bBk()});
                    r5[1] = String.format("weixinadinfo=%s.%s.0.0", new Object[]{nVar.bBj(), nVar.bBk()});
                    str2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.m(str2, r5);
                }
                qu quVar = new qu();
                quVar.cbq.bGG = i.eF(nVar.field_snsId) + ":" + aVar.ntU + ":" + af.bxU() + ":" + System.currentTimeMillis();
                quVar.cbq.userName = str;
                quVar.cbq.cbu = bi.WU(str3);
                quVar.cbq.cbs = str2;
                quVar.cbq.scene = bVar.scene == 0 ? 1045 : 1046;
                com.tencent.mm.sdk.b.a.sFg.m(quVar);
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ void b(b bVar, View view, n nVar, int i, String str, boolean z) {
        TagImageView xm = view.getTag() instanceof c ? ((c) view.getTag()).oji.xm(0) : view.getTag() instanceof MaskImageView ? (MaskImageView) view.getTag() : (TagImageView) view;
        if (!(xm.getTag() instanceof ap)) {
            return;
        }
        if (nVar.bAF().bzm() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Nf(str)) {
            String bBn = nVar.bBn();
            int i2 = bVar.scene == 0 ? 1 : 2;
            String str2 = "";
            int bBr = nVar.bBr();
            int i3 = z ? 22 : 21;
            if (nVar.bBp() != null) {
                nVar.bBp().getSource();
            }
            com.tencent.mm.kernel.g.Eh().dpP.a(new com.tencent.mm.plugin.sns.a.b.c(bBn, i, i2, str2, bBr, i3, nVar.bAJ().nNV, nVar.bAK()), 0);
            String w = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(nVar);
            if (!bi.oW(w)) {
                nVar.bBp().field_adxml = w;
            }
            int[] iArr = new int[2];
            xm.getLocationInWindow(iArr);
            int width = xm.getWidth();
            int height = xm.getHeight();
            Intent intent = new Intent();
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_width", width);
            intent.putExtra("img_gallery_height", height);
            intent.putExtra("sns_landing_pages_share_sns_id", nVar.bAK());
            intent.putExtra("sns_landing_pages_rawSnsId", nVar.bAJ().ksA);
            intent.putExtra("sns_landing_pages_ux_info", nVar.bBo());
            intent.putExtra("sns_landing_pages_aid", nVar.bBj());
            intent.putExtra("sns_landing_pages_traceid", nVar.bBk());
            bsu bAJ = nVar.bAJ();
            if (bAJ != null) {
                List list = bAJ.sqc.ruA;
                if (list.size() > 0) {
                    intent.putExtra("sns_landing_pages_share_thumb_url", ((ate) list.get(0)).rVE);
                }
            }
            intent.setClass(bVar.activity, SnsAdNativeLandingPagesUI.class);
            intent.putExtra("sns_landig_pages_from_source", bVar.scene == 0 ? 1 : 2);
            intent.putExtra("sns_landing_pages_xml", str);
            intent.putExtra("sns_landing_pages_rec_src", nVar.bBq());
            intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
            intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
            bVar.activity.startActivity(intent);
            bVar.activity.overridePendingTransition(0, 0);
            if (bVar.nMm != null) {
                bVar.nMm.bxT().v(nVar);
                return;
            }
            return;
        }
        x.e("MicroMsg.TimelineClickListener", "cardSelectLeftLsn invalid ad style");
    }

    static /* synthetic */ n cN(View view) {
        if (view.getTag() instanceof ap) {
            return h.Nl(((ap) view.getTag()).bNH);
        }
        if (view.getTag() instanceof MaskImageView) {
            MaskImageView maskImageView = (MaskImageView) view.getTag();
            return maskImageView.getTag() instanceof ap ? h.Nl(((ap) maskImageView.getTag()).bNH) : null;
        } else if (!(view.getTag() instanceof ak)) {
            return h.Nk(((c) view.getTag()).bSZ);
        } else {
            return af.byo().Nl(((ak) view.getTag()).bKW);
        }
    }

    public b(int i, Activity activity, ae aeVar) {
        this.scene = i;
        this.activity = activity;
        this.nMm = aeVar;
        this.old = bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsPOICommentFeedNewUrlSwitch"), 0);
        x.i("MicroMsg.TimelineClickListener", "init POIComment_FeedNewUrl_Switch:%d", new Object[]{Integer.valueOf(this.old)});
        this.jdw = (ClipboardManager) this.activity.getSystemService("clipboard");
        this.okv = new a(this.activity, this.scene, this.nMm);
        this.okG = new 23(this);
        this.okR = new 31(this);
        this.okV = new 32(this);
        this.okW = new 33(this);
        this.okw = new 34(this);
        this.okx = new 35(this);
        this.oky = new 36(this);
        this.okN = new c() {
            public final boolean cO(View view) {
                if (!(view.getTag() instanceof c) && !(view.getTag() instanceof n) && !(view.getTag() instanceof ak) && !(view.getTag() instanceof ap)) {
                    return false;
                }
                n Nk;
                Object tag = view.getTag();
                if (tag instanceof c) {
                    Nk = h.Nk(((c) view.getTag()).bSZ);
                } else if (tag instanceof n) {
                    Nk = (n) tag;
                } else if (tag instanceof ak) {
                    Nk = af.byo().Nl(((ak) tag).bKW);
                } else if (view.getTag() instanceof ap) {
                    Nk = af.byo().Nl(((ap) view.getTag()).bNH);
                } else {
                    Nk = null;
                }
                if (Nk != null) {
                    if (!Nk.xb(32)) {
                        return false;
                    }
                    if (Nk.bAF() == null || Nk.bAF().nzp != 1) {
                        return false;
                    }
                    b.this.okv.a(view, Nk.bBe(), Nk.bAJ());
                }
                return true;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                Object tag = view.getTag();
                if ((tag instanceof c) || (tag instanceof n) || (tag instanceof ak) || (tag instanceof ap)) {
                    n Nk;
                    if (tag instanceof c) {
                        Nk = h.Nk(((c) tag).bSZ);
                    } else if (tag instanceof n) {
                        Nk = (n) tag;
                    } else if (tag instanceof ak) {
                        Nk = af.byo().Nl(((ak) tag).bKW);
                    } else if (view.getTag() instanceof ap) {
                        Nk = af.byo().Nl(((ap) view.getTag()).bNH);
                    } else {
                        Nk = null;
                    }
                    if (Nk.xb(32) && Nk.bAF() != null && Nk.bAF().nzp == 1 && Nk.bAH().nyn == null) {
                        if (d.QS("favorite")) {
                            com.tencent.mm.plugin.sns.storage.b bAF = Nk.bAF();
                            Nk.bAH();
                            if (bAF.bzr()) {
                                contextMenu.add(0, 20, 0, view.getContext().getString(j.plugin_favorite_opt));
                            }
                            dj djVar = new dj();
                            djVar.bLf.bKW = Nk.bBe();
                            com.tencent.mm.sdk.b.a.sFg.m(djVar);
                            if (djVar.bLg.bKE) {
                                contextMenu.add(0, 18, 0, view.getContext().getString(j.app_open));
                            }
                        }
                        if (Nk != null) {
                            com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, Nk);
                        }
                    }
                }
            }
        };
        this.okO = new 3(this);
        this.okK = new c() {
            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                if (view.getTag() instanceof r) {
                    b.this.okP.onCreateContextMenu(contextMenu, view, contextMenuInfo);
                }
            }

            public final boolean cO(View view) {
                if (!(view.getTag() instanceof r)) {
                    return false;
                }
                String str = ((r) view.getTag()).bKW;
                b.this.okv.a(view, str, af.byo().Nl(str).bAJ());
                return true;
            }
        };
        this.okJ = new 5(this);
        this.okM = new 6(this);
        this.nNR = new 7(this);
        this.okz = new 8(this);
        this.okA = new 9(this);
        this.okB = new 10(this);
        this.okH = new 11(this);
        this.okC = new 13(this);
        this.okD = new 14(this);
        this.okE = new 15(this);
        this.okF = new 16(this);
        this.okI = new c() {
            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                if (view.getTag() instanceof m) {
                    m mVar = (m) view.getTag();
                    contextMenu.add(0, 11, 0, b.this.activity.getString(j.app_copy));
                    if (mVar.hbL != null && mVar.hbL.equals(q.GF())) {
                        contextMenu.add(0, 7, 0, b.this.activity.getString(j.app_delete));
                    }
                    String ez = com.tencent.mm.plugin.sns.model.ap.ez(mVar.nMv, (mVar.noe.smh != 0 ? (long) mVar.noe.smh : mVar.noe.smk));
                    int i = mVar.scene == 1 ? 2 : mVar.scene == 2 ? 4 : -1;
                    com.tencent.mm.plugin.sns.model.ap.b Mq = com.tencent.mm.plugin.sns.model.ap.Mq(ez);
                    boolean z = (Mq == null || !Mq.dDR || Mq.dHC || (i & Mq.csE) == 0) ? false : true;
                    if (z) {
                        com.tencent.mm.plugin.sns.model.ap.b(contextMenu, false);
                    } else {
                        com.tencent.mm.plugin.sns.model.ap.a(contextMenu, false);
                    }
                }
            }

            public final boolean cO(View view) {
                if (!(view.getTag() instanceof m)) {
                    return false;
                }
                n Nk = af.byo().Nk(((m) view.getTag()).nMv);
                b.this.okv.a(view, Nk.bBe(), Nk.bAJ());
                return true;
            }
        };
        this.hqR = new 18(this);
        this.okQ = new 19(this);
        this.okT = new 20(this);
        this.okS = new 21(this);
        this.okL = new 22(this);
        this.okU = new 24(this);
        this.okX = new 25(this);
        this.okY = new 26(this);
        this.olb = new 27(this);
        this.okP = new c() {
            public final boolean cO(View view) {
                Object tag = view.getTag();
                if (!(tag instanceof r)) {
                    return false;
                }
                r rVar = (r) tag;
                bsu bsu = rVar.nMH;
                if (bsu.sqc.ruz == 10 || bsu.sqc.ruz == 17 || bsu.sqc.ruz == 22 || bsu.sqc.ruz == 23) {
                    return false;
                }
                b.this.okv.a(view, rVar.bKW, bsu);
                return true;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                Object tag = view.getTag();
                if (tag instanceof r) {
                    r rVar = (r) tag;
                    bsu bsu = rVar.nMH;
                    if (d.QS("favorite")) {
                        dj djVar;
                        switch (bsu.sqc.ruz) {
                            case 1:
                                contextMenu.add(0, 2, 0, view.getContext().getString(j.plugin_favorite_opt));
                                break;
                            case 3:
                                contextMenu.add(0, 3, 0, view.getContext().getString(j.plugin_favorite_opt));
                                djVar = new dj();
                                djVar.bLf.bKW = rVar.bKW;
                                com.tencent.mm.sdk.b.a.sFg.m(djVar);
                                if (djVar.bLg.bKE) {
                                    contextMenu.add(0, 18, 0, view.getContext().getString(j.app_open));
                                    break;
                                }
                                break;
                            case 4:
                                contextMenu.add(0, 4, 0, view.getContext().getString(j.plugin_favorite_opt));
                                djVar = new dj();
                                djVar.bLf.bKW = rVar.bKW;
                                com.tencent.mm.sdk.b.a.sFg.m(djVar);
                                if (djVar.bLg.bKE) {
                                    contextMenu.add(0, 18, 0, view.getContext().getString(j.app_open));
                                    break;
                                }
                                break;
                            case 9:
                                contextMenu.add(0, 5, 0, view.getContext().getString(j.plugin_favorite_opt));
                                break;
                            case 14:
                                contextMenu.add(0, 9, 0, view.getContext().getString(j.plugin_favorite_opt));
                                break;
                            case 15:
                                contextMenu.add(0, 10, 0, view.getContext().getString(j.plugin_favorite_opt));
                                break;
                            case 26:
                                contextMenu.add(0, 22, 0, view.getContext().getString(j.plugin_favorite_opt));
                                break;
                            default:
                                contextMenu.add(0, 3, 0, view.getContext().getString(j.plugin_favorite_opt));
                                break;
                        }
                    }
                    com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, af.byo().Nl(rVar.bKW));
                }
            }
        };
        this.okp = new 29(this);
    }

    public final void aYt() {
        a aVar = this.okv;
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(TbsListener$ErrorCode.INCR_UPDATE_EXCEPTION, aVar);
    }

    public final void aEI() {
        a aVar = this.okv;
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(TbsListener$ErrorCode.INCR_UPDATE_EXCEPTION, aVar);
    }
}
