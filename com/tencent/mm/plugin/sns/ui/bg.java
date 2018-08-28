package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.an.c;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.g.a.js;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j.a;
import com.tencent.mm.plugin.sns.a.b.j.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.protocal.c.bgx;
import com.tencent.mm.protocal.c.brh;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.protocal.c.cfn;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.List;

public final class bg {
    Context context;
    ae nMm;
    public OnClickListener nZN = new OnClickListener() {
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - bg.this.ohu >= 500) {
                bg.this.ohu = currentTimeMillis;
                if (view.getTag() instanceof r) {
                    r rVar = (r) view.getTag();
                    bsu bsu = rVar.nMH;
                    n Nl = af.byo().Nl(rVar.bKW);
                    if (bg.this.nMm != null) {
                        bg.this.nMm.bxT().v(Nl);
                    }
                    Intent intent;
                    ate ate;
                    String str;
                    if (bsu.sqc.ruz == 18) {
                        Context context = bg.this.context;
                        bsu bsu2 = rVar.nMH;
                        j.a(b.njU, a.njM, af.byo().Nl(rVar.bKW));
                        intent = new Intent();
                        ate = null;
                        if (bsu2.sqc.ruA.size() > 0) {
                            ate = (ate) bsu2.sqc.ruA.get(0);
                        }
                        intent.putExtra("IsAd", false);
                        intent.putExtra("KStremVideoUrl", bsu2.sqc.jPK);
                        intent.putExtra("KSta_SourceType", 2);
                        intent.putExtra("KSta_Scene", b.njU.value);
                        intent.putExtra("KSta_FromUserName", bsu2.hbL);
                        intent.putExtra("KSta_SnSId", bsu2.ksA);
                        if (ate == null) {
                            intent.putExtra("KMediaId", "fakeid_" + (ate == null ? bsu2.ksA : ate.ksA));
                        } else {
                            intent.putExtra("KMediaId", ate.ksA);
                        }
                        brh brh = bsu2.sqh;
                        if (brh != null) {
                            intent.putExtra("KMediaVideoTime", brh.dyK);
                            intent.putExtra("StreamWording", brh.dyM);
                            intent.putExtra("StremWebUrl", brh.dyN);
                            intent.putExtra("KMediaTitle", brh.dyL);
                            intent.putExtra("KStremVideoUrl", brh.dyJ);
                            intent.putExtra("KThumUrl", brh.dyO);
                            intent.putExtra("KSta_StremVideoAduxInfo", brh.dyP);
                            intent.putExtra("KSta_StremVideoPublishId", brh.dyQ);
                        }
                        intent.putExtra("KSta_SnsStatExtStr", bsu2.nNV);
                        d.b(context, "sns", ".ui.VideoAdPlayerUI", intent);
                    } else if (bsu.nsD == null || bi.oW(bsu.nsD.pLr)) {
                        String str2 = bsu.sqc.jPK;
                        str = bsu.sqb.ksA;
                        x.d("MicroMsg.TimeLineClickEvent", "url:" + str2);
                        String B = com.tencent.mm.plugin.sns.c.a.ezo.B(str2, "timeline");
                        if (B != null && B.length() != 0) {
                            Intent intent2 = new Intent();
                            Bundle bundle = null;
                            if (bsu != null) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("KSnsStrId", bsu.ksA);
                                bundle2.putString("KSnsLocalId", rVar.bKW);
                                bundle2.putBoolean("KFromTimeline", true);
                                if (bsu.sqc != null && bsu.sqc.ruA.size() > 0) {
                                    bundle2.putString("K_sns_thumb_url", ((ate) bsu.sqc.ruA.get(0)).rVE);
                                    bundle2.putString("K_sns_raw_url", bsu.sqc.jPK);
                                    x.i("MicroMsg.TimeLineClickEvent", "put the thumb url %s redirectUrl %s", new Object[]{((ate) bsu.sqc.ruA.get(0)).rVE, bsu.sqc.jPK});
                                }
                                bundle = bundle2;
                            }
                            bundle.putString("key_snsad_statextstr", bsu.nNV);
                            intent2.putExtra("rawUrl", B);
                            intent2.putExtra("shortUrl", B);
                            intent2.putExtra("useJs", true);
                            intent2.putExtra("type", -255);
                            if (bsu.sqd != null) {
                                intent2.putExtra("srcUsername", bsu.sqd);
                                intent2.putExtra("srcDisplayname", bsu.qIc);
                                x.i("MicroMsg.TimeLineClickEvent", "urlRedirectListener tlObj.sourceNickName: " + bsu.qIc + " tlObj.publicUserName: " + bsu.sqd);
                            }
                            intent2.putExtra("sns_local_id", rVar.bKW);
                            if (Nl != null) {
                                intent2.putExtra("KPublisherId", "sns_" + i.eF(Nl.field_snsId));
                                intent2.putExtra("pre_username", Nl.field_userName);
                                intent2.putExtra("prePublishId", "sns_" + i.eF(Nl.field_snsId));
                                intent2.putExtra("preUsername", Nl.field_userName);
                                intent2.putExtra("share_report_pre_msg_url", B);
                                intent2.putExtra("share_report_pre_msg_title", bsu.sqc.bHD);
                                intent2.putExtra("share_report_pre_msg_desc", bsu.sqc.jOS);
                                if (bsu.sqc.ruA != null && bsu.sqc.ruA.size() > 0) {
                                    intent2.putExtra("share_report_pre_msg_icon_url", ((ate) bsu.sqc.ruA.get(0)).rVE);
                                }
                                intent2.putExtra("share_report_pre_msg_appid", "");
                                intent2.putExtra("share_report_from_scene", 1);
                            }
                            if (!(bsu == null || bsu.sqb == null)) {
                                intent2.putExtra("KAppId", bsu.sqb.ksA);
                            }
                            if (Nl != null && Nl.xb(32)) {
                                com.tencent.mm.plugin.sns.storage.a bAH = Nl.bAH();
                                if (bAH != null) {
                                    intent2.putExtra("KsnsViewId", bAH.fvT);
                                }
                            }
                            if (!(Nl == null || bsu == null)) {
                                com.tencent.mm.modelsns.b io;
                                if (bg.this.scene == 0) {
                                    io = com.tencent.mm.modelsns.b.io(718);
                                } else {
                                    io = com.tencent.mm.modelsns.b.ip(718);
                                }
                                io.nb(i.g(Nl)).ir(Nl.field_type).bP(Nl.xb(32)).nb(Nl.bBo()).nb(bsu.sqd).nb(bsu.sqb == null ? "" : bsu.sqb.ksA).nb(bsu.sqc.jPK);
                                io.RD();
                                if (bg.this.scene == 0) {
                                    io = com.tencent.mm.modelsns.b.io(743);
                                } else {
                                    io = com.tencent.mm.modelsns.b.ip(743);
                                }
                                com.tencent.mm.modelsns.b nb = io.nb(i.g(Nl)).ir(Nl.field_type).bP(Nl.xb(32)).nb(Nl.bBo()).nb(bsu.sqd);
                                if (bsu.sqb == null) {
                                    str = "";
                                } else {
                                    str = bsu.sqb.ksA;
                                }
                                nb.nb(str).nb(bsu.sqc.jPK);
                                if (bundle != null) {
                                    str = "intent_key_StatisticsOplog";
                                    byte[] Lv = io.Lv();
                                    if (Lv != null) {
                                        bundle.putByteArray(str, Lv);
                                    }
                                }
                            }
                            if (bundle != null) {
                                intent2.putExtra("jsapiargs", bundle);
                            }
                            intent2.putExtra("geta8key_scene", 2);
                            intent2.putExtra("from_scence", 3);
                            if (bi.oW(bsu.ogR) || !e.Nf(bsu.ogR)) {
                                intent2.addFlags(536870912);
                                com.tencent.mm.plugin.sns.c.a.ezn.j(intent2, bg.this.context);
                                str = null;
                                int i = 0;
                                if (!(bsu == null || bsu.sqb == null)) {
                                    str = bsu.sqb.ksA;
                                    i = bi.getInt(bsu.sqb.hcr, 0);
                                }
                                B = com.tencent.mm.plugin.sns.c.a.ezo.s(str, i);
                                if (!bi.oW(B) && com.tencent.mm.plugin.sns.c.a.ezo.cU(str)) {
                                    String str3 = null;
                                    if (!(bsu == null || bsu.nsB == null || bsu.nsB.raS == null)) {
                                        str3 = bsu.nsB.raS.raM;
                                    }
                                    com.tencent.mm.plugin.sns.c.a.ezo.a(bg.this.context, str, B, bsu == null ? null : bsu.hbL, 5, 4, 1, str3, bsu.ksA);
                                }
                                h.mEJ.h(11105, new Object[]{bsu.hbL, bsu.sqc.jPK});
                                if (Nl != null && Nl.field_type == 4) {
                                    ate = (ate) bsu.sqc.ruA.get(0);
                                    h hVar = h.mEJ;
                                    Object[] objArr = new Object[3];
                                    objArr[0] = Integer.valueOf(1);
                                    objArr[1] = ate == null ? "" : ate.jOS;
                                    objArr[2] = bsu.sqb.ksA;
                                    hVar.h(13043, objArr);
                                    return;
                                }
                                return;
                            }
                            int[] iArr = new int[2];
                            if (view != null) {
                                view.getLocationInWindow(iArr);
                            }
                            int width = view.getWidth();
                            int height = view.getHeight();
                            intent = new Intent();
                            intent.putExtra("img_gallery_left", iArr[0]);
                            intent.putExtra("img_gallery_top", iArr[1]);
                            intent.putExtra("img_gallery_width", width);
                            intent.putExtra("img_gallery_height", height);
                            if (bsu != null) {
                                List list = bsu.sqc.ruA;
                                if (list.size() > 0) {
                                    intent.putExtra("sns_landing_pages_share_thumb_url", ((ate) list.get(0)).rVE);
                                }
                            }
                            intent.putExtra("sns_landing_pages_share_sns_id", Nl.bAK());
                            intent.putExtra("sns_landing_pages_rawSnsId", Nl.bAJ().ksA);
                            intent.putExtra("sns_landing_pages_aid", Nl.bBj());
                            intent.putExtra("sns_landing_pages_traceid", Nl.bBk());
                            intent.putExtra("sns_landing_pages_ux_info", Nl.bBo());
                            intent.putExtra("sns_landig_pages_from_source", bg.this.scene == 0 ? 3 : 4);
                            intent.setClass(bg.this.context, SnsAdNativeLandingPagesUI.class);
                            intent.putExtra("sns_landing_pages_xml", bsu.ogR);
                            intent.putExtra("sns_landing_pages_rec_src", Nl.bBq());
                            intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                            e.y(intent, bg.this.context);
                        }
                    } else {
                        bg bgVar = bg.this;
                        cfn cfn = bsu.nsD;
                        if (cfn != null && !bi.oW(cfn.pLr)) {
                            Intent intent3 = new Intent();
                            try {
                                intent3.putExtra("key_context", g.a(cfn, 31, r.PX("discoverRecommendEntry").optString("wording")).toByteArray());
                            } catch (IOException e) {
                            }
                            p.c(bgVar.context, ".ui.video.TopStoryVideoStreamUI", intent3);
                            String str4 = bsu.qIb;
                            str = bsu.ksA;
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append("isShareClick=1");
                            stringBuffer.append("&relevant_vid=");
                            stringBuffer.append(cfn.pLr);
                            stringBuffer.append("&relevant_pre_searchid=");
                            stringBuffer.append(cfn.pLt);
                            stringBuffer.append("&relevant_shared_openid=");
                            stringBuffer.append(cfn.pLu);
                            stringBuffer.append("&rec_category=");
                            stringBuffer.append(cfn.pLv);
                            stringBuffer.append("&source=");
                            stringBuffer.append(cfn.bhd);
                            stringBuffer.append("&fromUser=");
                            stringBuffer.append(str4);
                            stringBuffer.append("&fromScene=");
                            stringBuffer.append(3);
                            stringBuffer.append("&targetInfo=");
                            stringBuffer.append(str);
                            x.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", new Object[]{stringBuffer.toString()});
                            bgx bgx = new bgx();
                            bgx.shQ = stringBuffer.toString();
                            com.tencent.mm.kernel.g.DF().a(new com.tencent.mm.plugin.websearch.api.n(bgx), 0);
                        }
                    }
                }
            }
        }
    };
    public OnClickListener ohA = new 13(this);
    public OnClickListener ohB = new 14(this);
    public OnClickListener ohC = new 15(this);
    public OnClickListener ohD = new 2(this);
    public OnClickListener ohE = new 3(this);
    public OnClickListener ohF = new OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.TimeLineClickEvent", "appbrandHomeRedirectListener");
            if (view.getTag() instanceof bsu) {
                bsu bsu = (bsu) view.getTag();
                if (bsu.sqi == null) {
                    x.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener username is null");
                    return;
                }
                String str = bsu.sqi.username;
                qu quVar = new qu();
                x.i("MicroMsg.TimeLineClickEvent", "username: " + str);
                quVar.cbq.userName = str;
                quVar.cbq.scene = 1009;
                quVar.cbq.bGG = bsu.ksA + ":" + bsu.hbL;
                com.tencent.mm.sdk.b.a.sFg.m(quVar);
            }
        }
    };
    public OnClickListener ohG = new OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.TimeLineClickEvent", "hardMallProductRedirectListener");
            if (view.getTag() instanceof r) {
                r rVar = (r) view.getTag();
                bsu bsu = rVar.nMH;
                if (bsu.sqc.ruA.size() > 0) {
                    n Nl = af.byo().Nl(rVar.bKW);
                    if (bg.this.nMm != null) {
                        bg.this.nMm.bxT().v(Nl);
                    }
                    String str = ((ate) bsu.sqc.ruA.get(0)).nME;
                    Intent intent = new Intent();
                    intent.putExtra("key_product_scene", 2);
                    intent.putExtra("key_product_info", str);
                    d.b(bg.this.context, "product", ".ui.MallProductUI", intent);
                }
            }
        }
    };
    public OnClickListener ohH = new OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.TimeLineClickEvent", "cardRediretListener");
            if (view.getTag() instanceof r) {
                r rVar = (r) view.getTag();
                bsu bsu = rVar.nMH;
                if (bsu.sqc.ruA.size() > 0) {
                    n Nl = af.byo().Nl(rVar.bKW);
                    if (bg.this.nMm != null) {
                        bg.this.nMm.bxT().v(Nl);
                    }
                    String str = ((ate) bsu.sqc.ruA.get(0)).nME;
                    Intent intent = new Intent();
                    intent.putExtra("key_from_scene", 12);
                    if (TextUtils.isEmpty(str)) {
                        x.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData is empty");
                        return;
                    }
                    String[] split = str.split("#");
                    if (split.length >= 2) {
                        x.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData[0]:" + split[0]);
                        intent.putExtra("key_card_id", split[0]);
                        intent.putExtra("key_card_ext", split[1]);
                        d.b(bg.this.context, "card", ".ui.CardDetailUI", intent);
                    } else if (split.length == 1) {
                        x.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include cardExt");
                        x.i("MicroMsg.TimeLineClickEvent", "cardRediretListener card_id :" + str);
                        intent.putExtra("key_card_id", split[0]);
                        intent.putExtra("key_card_ext", "");
                        d.b(bg.this.context, "card", ".ui.CardDetailUI", intent);
                    } else {
                        x.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include card_id and cardExt");
                        x.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData :" + str);
                    }
                }
            }
        }
    };
    public OnClickListener ohI = new 7(this);
    a oht;
    long ohu = 0;
    public OnClickListener ohv = new OnClickListener() {
        public final void onClick(View view) {
            boolean z;
            String str;
            String str2 = null;
            bg bgVar = bg.this;
            if (view == null || !(view.getTag() instanceof bsu)) {
                z = true;
            } else {
                str = ((bsu) view.getTag()).sqb.ksA;
                Intent intent;
                if ("wx485a97c844086dc9".equals(str)) {
                    d.b(view.getContext(), "shake", ".ui.ShakeReportUI", new Intent().putExtra("shake_music", true));
                    z = true;
                } else if ("wx7fa037cc7dfabad5".equals(str)) {
                    com.tencent.mm.plugin.sport.b.d.kB(34);
                    com.tencent.mm.kernel.g.Ek();
                    if (com.tencent.mm.l.a.gd(((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg("gh_43f2581f6fd6").field_type)) {
                        intent = new Intent();
                        intent.putExtra("Chat_User", "gh_43f2581f6fd6");
                        intent.putExtra("finish_direct", true);
                        d.e(bgVar.context, ".ui.chatting.ChattingUI", intent);
                    } else {
                        intent = new Intent();
                        intent.putExtra("Contact_User", "gh_43f2581f6fd6");
                        d.b(bgVar.context, "profile", ".ui.ContactInfoUI", intent);
                    }
                    z = true;
                } else if ("wx9181ed3f223e6d76".equals(str) || "wx2fe12a395c426fcf".equals(str)) {
                    x.i("MicroMsg.TimeLineClickEvent", "hy: shake new year closed. try to go to shake TV");
                    intent = new Intent();
                    intent.putExtra("shake_tv", true);
                    d.b(view.getContext(), "shake", ".ui.ShakeReportUI", intent);
                    z = true;
                } else if ("wx751a1acca5688ba3".equals(str)) {
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 5);
                    if (!(com.tencent.mm.p.a.bx(bgVar.context) || com.tencent.mm.p.a.bw(bgVar.context))) {
                        d.b(bgVar.context, "scanner", ".ui.BaseScanUI", intent);
                    }
                    z = true;
                } else if ("wxfbc915ff7c30e335".equals(str)) {
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 1);
                    if (!(com.tencent.mm.p.a.bx(bgVar.context) || com.tencent.mm.p.a.bw(bgVar.context))) {
                        d.b(bgVar.context, "scanner", ".ui.BaseScanUI", intent);
                    }
                    z = true;
                } else if ("wx482a4001c37e2b74".equals(str)) {
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 2);
                    if (!(com.tencent.mm.p.a.bx(bgVar.context) || com.tencent.mm.p.a.bw(bgVar.context))) {
                        d.b(bgVar.context, "scanner", ".ui.BaseScanUI", intent);
                    }
                    z = true;
                } else if (!"wxaf060266bfa9a35c".equals(str)) {
                    z = false;
                } else if (c.Qf()) {
                    intent = new Intent();
                    intent.putExtra("shake_tv", true);
                    d.b(bgVar.context, "shake", ".ui.ShakeReportUI", intent);
                    z = true;
                } else {
                    z = true;
                }
            }
            if (!z && view != null && (view.getTag() instanceof bsu)) {
                bsu bsu = (bsu) view.getTag();
                if (bsu == null || bsu.sqb == null) {
                    x.e("MicroMsg.TimeLineClickEvent", "appInfo is null");
                    return;
                }
                String str3 = bsu.sqb.ksA;
                String cS = com.tencent.mm.plugin.sns.c.a.ezo.cS(str3);
                if (bi.oW(cS) || !com.tencent.mm.plugin.sns.c.a.ezo.cU(str3)) {
                    str = com.tencent.mm.plugin.sns.c.a.ezo.h(bg.this.context, str3, "timeline");
                    if (str != null && str.length() != 0) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("rawUrl", str);
                        intent2.putExtra("shortUrl", str);
                        intent2.putExtra("useJs", true);
                        intent2.putExtra("type", -255);
                        intent2.putExtra("geta8key_scene", 2);
                        com.tencent.mm.plugin.sns.c.a.ezn.j(intent2, bg.this.context);
                        return;
                    }
                    return;
                }
                int i;
                String str4 = bsu == null ? null : bsu.hbL;
                if (bsu.sqc.ruz == 1) {
                    i = 2;
                } else if (bsu.sqc.ruz == 3) {
                    i = 5;
                } else {
                    i = 2;
                }
                if (!(bsu.nsB == null || bsu.nsB.raS == null)) {
                    str2 = bsu.nsB.raS.raM;
                }
                nk nkVar = new nk();
                nkVar.bYs.context = bg.this.context;
                nkVar.bYs.scene = 4;
                nkVar.bYs.bPS = str3;
                nkVar.bYs.packageName = cS;
                nkVar.bYs.msgType = i;
                nkVar.bYs.bSS = str4;
                nkVar.bYs.mediaTagName = str2;
                nkVar.bYs.bYt = 5;
                nkVar.bYs.bYu = 0;
                nkVar.bYs.bYv = bsu.ksA;
                com.tencent.mm.sdk.b.a.sFg.m(nkVar);
                gk gkVar = new gk();
                gkVar.bPB.actionCode = 2;
                gkVar.bPB.scene = 3;
                gkVar.bPB.extMsg = "timeline_src=3";
                gkVar.bPB.appId = str3;
                gkVar.bPB.context = bg.this.context;
                com.tencent.mm.sdk.b.a.sFg.m(gkVar);
            }
        }
    };
    public OnClickListener ohw = new 9(this);
    public OnClickListener ohx = new 10(this);
    public OnClickListener ohy = new 11(this);
    public OnClickListener ohz = new 12(this);
    int scene = 0;
    com.tencent.mm.ui.base.p tipDialog;

    public bg(Context context, a aVar, int i, ae aeVar) {
        this.context = context;
        this.oht = aVar;
        this.scene = i;
        this.nMm = aeVar;
    }

    protected static boolean KK(String str) {
        js jsVar = new js();
        jsVar.bTw.action = -2;
        com.tencent.mm.sdk.b.a.sFg.m(jsVar);
        avq avq = jsVar.bTx.bTy;
        if (avq != null && com.tencent.mm.an.b.d(avq) && str.equals(avq.rsp) && com.tencent.mm.an.b.PY()) {
            return true;
        }
        return false;
    }
}
