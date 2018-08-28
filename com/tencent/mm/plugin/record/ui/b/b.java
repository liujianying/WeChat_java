package com.tencent.mm.plugin.record.ui.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ac$a;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.ui.RecordMsgDetailUI;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.pluginsdk.model.d;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.protocal.c.vv;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.vz;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMImageView;

public final class b implements com.tencent.mm.plugin.record.ui.h.b {
    private c fIu = new c<jt>() {
        {
            this.sFo = jt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            jt jtVar = (jt) bVar;
            if (jtVar instanceof jt) {
                switch (jtVar.bTE.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        b.this.handler.sendMessageAtFrontOfQueue(b.this.handler.obtainMessage(1));
                        break;
                }
            }
            return false;
        }
    };
    ag handler;
    private int jeu = 0;
    private OnClickListener jex = new 2(this);
    private a msR;
    boolean mtD = false;
    OnClickListener mtE = new OnClickListener() {
        public final void onClick(View view) {
            String str = null;
            com.tencent.mm.plugin.record.ui.a.b bVar = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
            Intent intent;
            Intent intent2;
            String str2;
            Intent intent3;
            Bundle no;
            Context context;
            Context context2;
            switch (bVar.bOz.bjS) {
                case 4:
                case 15:
                    Context context3 = view.getContext();
                    if ((bi.oW(bVar.bOz.rzo) && bi.oW(bVar.bOz.rAG)) || bVar.bOz.rzJ <= 0) {
                        x.w("MicroMsg.OtherViewWrapper", "full md5[%s], fullsize[%d], start use url", new Object[]{bVar.bOz.rzF, Long.valueOf(bVar.bOz.rzJ)});
                        str = bVar.bOz.rzv;
                        if (bi.oW(str)) {
                            str = bVar.bOz.rzz;
                        }
                        if (bi.oW(str)) {
                            x.w("MicroMsg.OtherViewWrapper", "go to video[webpage] error, url null, dataid[%s]", new Object[]{bVar.bOz.jdM});
                            if (bVar.bjS == 1 && bVar.msw.field_itemStatus != 10 && bVar.bOz.rAw == 0) {
                                intent = new Intent();
                                intent.putExtra("key_detail_info_id", bVar.msw.field_localId);
                                intent.putExtra("key_detail_data_id", bVar.bOz.jdM);
                                if (com.tencent.mm.plugin.record.b.b.c(bVar)) {
                                    b.a(intent, bVar, context3, com.tencent.mm.plugin.record.b.b.a(bVar), com.tencent.mm.plugin.record.b.b.b(bVar));
                                    return;
                                } else {
                                    com.tencent.mm.plugin.fav.a.b.a(context3, ".ui.detail.FavoriteFileDetailUI", intent, 1);
                                    return;
                                }
                            }
                            intent2 = new Intent();
                            str2 = "";
                            str = "";
                            if (bVar.bjS == 0) {
                                str = h.f(bVar.bOz, bVar.bJC);
                                if (bi.oW(str) || !e.cn(str)) {
                                    com.tencent.mm.ui.base.h.bA(context3, context3.getString(R.l.favorite_record_video_error));
                                    return;
                                }
                                str2 = h.c(bVar.bOz, bVar.bJC);
                                if (bi.oW(str2) || !e.cn(str2)) {
                                    intent2.putExtra("key_detail_data_valid", false);
                                }
                            } else if (bVar.bjS == 1) {
                                str = com.tencent.mm.plugin.record.b.b.b(bVar);
                                if (bi.oW(str) || !e.cn(str)) {
                                    com.tencent.mm.ui.base.h.bA(context3, context3.getString(R.l.favorite_record_video_error));
                                    return;
                                }
                                str2 = com.tencent.mm.plugin.record.b.b.a(bVar);
                                if (bi.oW(str2) || !e.cn(str2)) {
                                    intent2.putExtra("key_detail_data_valid", false);
                                }
                            }
                            b.a(intent2, bVar, context3, str2, str);
                            return;
                        }
                        intent3 = new Intent();
                        intent3.putExtra("rawUrl", str);
                        if (bVar.bjS == 1) {
                            intent3.putExtra("is_favorite_item", true);
                            intent3.putExtra("fav_local_id", bVar.msw.field_localId);
                            intent3.putExtra("key_detail_can_delete", false);
                            intent3.putExtra("geta8key_scene", 14);
                            no = com.tencent.mm.modelstat.a.b.no(d.class.getName());
                            no.putInt("mm_rpt_fav_id", bVar.msw.field_id);
                            intent3.putExtra("mm_report_bundle", no);
                            x.d("MicroMsg.OtherViewWrapper", "go to video, fav id %d, fav local id %d, data id %s", new Object[]{Integer.valueOf(bVar.msw.field_id), Long.valueOf(bVar.msw.field_localId), bVar.bOz.jdM});
                        }
                        com.tencent.mm.bg.d.b(context3, "webview", ".ui.tools.WebViewUI", intent3, 1);
                        return;
                    } else if (bVar.bjS == 0) {
                        intent = new Intent();
                        intent.putExtra("message_id", bVar.bJC);
                        intent.putExtra("record_xml", bVar.bXN);
                        intent.putExtra("record_data_id", bVar.bOz.jdM);
                        intent.putExtra("key_detail_fav_video_scene_from", 1);
                        if (h.d(bVar.bOz, bVar.bJC)) {
                            b.a(intent, bVar, context3, h.c(bVar.bOz, bVar.bJC), h.f(bVar.bOz, bVar.bJC));
                            return;
                        } else {
                            com.tencent.mm.bg.d.b(context3, "record", ".ui.RecordMsgFileUI", intent, 1);
                            return;
                        }
                    } else if (bVar.bjS == 1) {
                        intent = new Intent();
                        intent.putExtra("key_detail_info_id", bVar.msw.field_localId);
                        intent.putExtra("key_detail_data_id", bVar.bOz.jdM);
                        if (com.tencent.mm.plugin.record.b.b.c(bVar)) {
                            b.a(intent, bVar, context3, com.tencent.mm.plugin.record.b.b.a(bVar), com.tencent.mm.plugin.record.b.b.b(bVar));
                            return;
                        } else {
                            com.tencent.mm.plugin.fav.a.b.a(context3, ".ui.detail.FavoriteFileDetailUI", intent, 1);
                            return;
                        }
                    } else {
                        return;
                    }
                case 5:
                    context = view.getContext();
                    if (bVar.bOz.rAi == null) {
                        x.w("MicroMsg.OtherViewWrapper", "go to web page error, get data proto item null, dataid[%s]", new Object[]{bVar.bOz.jdM});
                        com.tencent.mm.ui.base.h.bA(context, context.getString(R.l.favorite_record_url_error));
                        return;
                    }
                    vx vxVar = bVar.bOz;
                    if (vxVar != null) {
                        if (vxVar.rAt) {
                            str = vxVar.canvasPageXml;
                        } else if (!(vxVar.rAi == null || vxVar.rAi.rAN == null || !vxVar.rAi.rAN.rAt)) {
                            str = vxVar.rAi.rAN.canvasPageXml;
                        }
                    }
                    if (bi.oW(str)) {
                        vz vzVar = bVar.bOz.rAi.rAJ;
                        str = "";
                        if (bVar.bOz.rAi.rAN != null) {
                            str = bVar.bOz.rAi.rAN.rCn;
                        }
                        if (vzVar != null && bi.oW(r1)) {
                            str = vzVar.egr;
                        }
                        if (bi.oW(str)) {
                            str = bVar.bOz.rzv;
                        }
                        if (bi.oW(str)) {
                            x.w("MicroMsg.OtherViewWrapper", "go to web page error, url null, dataid[%s]", new Object[]{bVar.bOz.jdM});
                            com.tencent.mm.ui.base.h.bA(context, context.getString(R.l.favorite_record_url_error));
                            return;
                        }
                        intent2 = new Intent();
                        intent2.putExtra("rawUrl", str);
                        if (!(vzVar == null || bi.oW(vzVar.bGy))) {
                            intent2.putExtra("srcDisplayname", r.gT(vzVar.bGy));
                        }
                        intent2.putExtra("mode", 1);
                        if (bVar.bjS == 1) {
                            intent2.putExtra("is_favorite_item", true);
                            intent2.putExtra("fav_local_id", bVar.msw.field_localId);
                            intent2.putExtra("key_detail_can_delete", false);
                            intent2.putExtra("geta8key_scene", 14);
                            intent2.putExtra("from_scence", 4);
                            no = com.tencent.mm.modelstat.a.b.no(d.class.getName());
                            no.putInt("mm_rpt_fav_id", bVar.msw.field_id);
                            intent2.putExtra("mm_report_bundle", no);
                        }
                        no = new Bundle();
                        no.putString("key_snsad_statextstr", bVar.bOz.bZN);
                        intent2.putExtra("jsapiargs", no);
                        com.tencent.mm.bg.d.b(context, "webview", ".ui.tools.WebViewUI", intent2, 1);
                        return;
                    }
                    Intent intent4 = new Intent();
                    intent4.putExtra("sns_landing_pages_xml", str);
                    intent4.putExtra("sns_landig_pages_from_source", 5);
                    intent4.putExtra("sns_landing_pages_share_thumb_url", bVar.bOz.dwE);
                    intent4.addFlags(268435456);
                    intent4.putExtra("msg_id", bVar.bJC);
                    com.tencent.mm.bg.d.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent4, 1);
                    return;
                case 6:
                    Context context4 = view.getContext();
                    if (context4 != null) {
                        we weVar;
                        vz vzVar2;
                        if (bVar.bOz.rAi != null) {
                            weVar = bVar.bOz.rAi.rAL;
                            vzVar2 = bVar.bOz.rAi.rAJ;
                        } else {
                            vzVar2 = null;
                            weVar = null;
                        }
                        if (vzVar2 != null) {
                            str = !bi.oW(vzVar2.rBh) ? r.gT(vzVar2.rBh) : r.gT(vzVar2.bSS);
                        }
                        if (vzVar2 == null && bVar.bjS == 1) {
                            str = r.gT(bVar.msw.field_fromUser);
                        }
                        if (weVar == null) {
                            x.w("MicroMsg.OtherViewWrapper", "go to location error, locItem null, dataid[%s]", new Object[]{bVar.bOz.jdM});
                            com.tencent.mm.ui.base.h.bA(context4, context4.getString(R.l.favorite_record_loc_error));
                            return;
                        }
                        intent3 = new Intent();
                        intent3.putExtra("kwebmap_slat", weVar.lat);
                        intent3.putExtra("kwebmap_lng", weVar.lng);
                        intent3.putExtra("kPoiName", weVar.bWB);
                        intent3.putExtra("Kwebmap_locaion", weVar.label);
                        if (weVar.bSz >= 0) {
                            intent3.putExtra("kwebmap_scale", weVar.bSz);
                        }
                        intent3.putExtra("kisUsername", str);
                        intent3.putExtra("kwebmap_from_to", true);
                        if (bVar.bjS == 1) {
                            intent3.putExtra("KFavLocSigleView", true);
                            intent3.putExtra("map_view_type", 2);
                            intent3.putExtra("kFavInfoLocalId", bVar.msw.field_localId);
                            intent3.putExtra("kFavCanDel", false);
                            intent3.putExtra("kFavCanRemark", false);
                            com.tencent.mm.bg.d.b(context4, "location", ".ui.RedirectUI", intent3, 1);
                            return;
                        } else if (bVar.bjS == 0) {
                            intent3.putExtra("map_view_type", 1);
                            com.tencent.mm.bg.d.b(context4, "location", ".ui.RedirectUI", intent3, 1002);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 7:
                    context2 = view.getContext();
                    intent3 = new Intent();
                    if (bi.oW(bVar.bOz.rzv)) {
                        x.w("MicroMsg.OtherViewWrapper", "go to music[webpage], web url is null, use data url instead, dataid[%s]", new Object[]{bVar.bOz.jdM});
                        intent3.putExtra("rawUrl", bVar.bOz.rzx);
                    } else {
                        intent3.putExtra("rawUrl", bVar.bOz.rzv);
                    }
                    if (bVar.bjS == 1) {
                        intent3.putExtra("is_favorite_item", true);
                        intent3.putExtra("fav_local_id", bVar.msw.field_localId);
                        intent3.putExtra("key_detail_can_delete", false);
                        Bundle no2 = com.tencent.mm.modelstat.a.b.no(d.class.getName());
                        no2.putInt("mm_rpt_fav_id", bVar.msw.field_id);
                        intent3.putExtra("mm_report_bundle", no2);
                        x.d("MicroMsg.OtherViewWrapper", "start music webview, fav id %d, fav local id %d, data id %s", new Object[]{Integer.valueOf(bVar.msw.field_id), Long.valueOf(bVar.msw.field_localId), bVar.bOz.jdM});
                    }
                    com.tencent.mm.bg.d.b(context2, "webview", ".ui.tools.WebViewUI", intent3, 1);
                    return;
                case 8:
                    boolean z;
                    context = view.getContext();
                    if (bVar.bjS == 0) {
                        if (h.d(bVar.bOz, bVar.bJC) && !com.tencent.mm.pluginsdk.ui.tools.a.a((Activity) context, h.c(bVar.bOz, bVar.bJC), bVar.bOz.rzD, 2)) {
                            z = false;
                        }
                        z = true;
                    } else {
                        if (bVar.bjS == 1 && com.tencent.mm.plugin.record.b.b.c(bVar) && !com.tencent.mm.pluginsdk.ui.tools.a.a((Activity) context, com.tencent.mm.plugin.record.b.b.a(bVar), bVar.bOz.rzD, 2)) {
                            z = false;
                        }
                        z = true;
                    }
                    if (!z) {
                        return;
                    }
                    if (bVar.bjS == 0) {
                        intent = new Intent(context, RecordMsgFileUI.class);
                        intent.putExtra("message_id", bVar.bJC);
                        intent.putExtra("record_xml", bVar.bXN);
                        intent.putExtra("record_data_id", bVar.bOz.jdM);
                        context.startActivity(intent);
                        return;
                    } else if (bVar.bjS != 1) {
                        return;
                    } else {
                        if (h.h(bVar.bOz, bVar.bJC)) {
                            intent = new Intent();
                            intent.putExtra("key_detail_info_id", bVar.msw.field_localId);
                            com.tencent.mm.plugin.fav.a.b.a(context, ".ui.detail.FavoriteImgDetailUI", intent, 1);
                            return;
                        }
                        intent = new Intent();
                        intent.putExtra("key_detail_info_id", bVar.msw.field_localId);
                        intent.putExtra("key_detail_data_id", bVar.bOz.jdM);
                        intent.putExtra("key_detail_can_delete", false);
                        com.tencent.mm.plugin.fav.a.b.a(context, ".ui.detail.FavoriteFileDetailUI", intent, 1);
                        return;
                    }
                case 10:
                    context2 = view.getContext();
                    if (bVar.bOz.rAi == null || bVar.bOz.rAi.rAP == null) {
                        x.w("MicroMsg.OtherViewWrapper", "go to product error, get data proto item null, dataid[%s]", new Object[]{bVar.bOz.jdM});
                        com.tencent.mm.ui.base.h.bA(context2, context2.getString(R.l.favorite_record_info_error));
                        return;
                    }
                    intent3 = new Intent();
                    intent3.putExtra("key_Product_xml", bVar.bOz.rAi.rAP.info);
                    if (bVar.bjS == 1) {
                        intent3.putExtra("key_is_favorite_item", true);
                        intent3.putExtra("key_favorite_local_id", bVar.msw.field_localId);
                        intent3.putExtra("key_can_delete_favorite_item", false);
                        intent3.putExtra("key_ProductUI_getProductInfoScene", 3);
                    }
                    com.tencent.mm.bg.d.b(context2, "scanner", ".ui.ProductUI", intent3, 1);
                    return;
                case 11:
                    context2 = view.getContext();
                    if (bVar.bOz.rAi == null || bVar.bOz.rAi.rAP == null) {
                        x.w("MicroMsg.OtherViewWrapper", "go to mall product error, get data proto item null, dataid[%s]", new Object[]{bVar.bOz.jdM});
                        com.tencent.mm.ui.base.h.bA(context2, context2.getString(R.l.favorite_record_info_error));
                        return;
                    }
                    intent3 = new Intent();
                    intent3.putExtra("key_product_info", bVar.bOz.rAi.rAP.info);
                    if (bVar.bjS == 1) {
                        intent3.putExtra("key_product_scene", 4);
                    }
                    com.tencent.mm.bg.d.b(context2, "product", ".ui.MallProductUI", intent3, 1);
                    return;
                case 14:
                    context2 = view.getContext();
                    if (bVar.bOz.rAi == null || bVar.bOz.rAi.rAR == null) {
                        x.w("MicroMsg.OtherViewWrapper", "go to tv error, get data proto item null, dataid[%s]", new Object[]{bVar.bOz.jdM});
                        com.tencent.mm.ui.base.h.bA(context2, context2.getString(R.l.favorite_record_info_error));
                        return;
                    }
                    intent3 = new Intent();
                    intent3.putExtra("key_TV_getProductInfoScene", 3);
                    intent3.putExtra("key_TV_xml", bVar.bOz.rAi.rAR.info);
                    if (bVar.bjS == 1) {
                        intent3.putExtra("key_is_favorite_item", true);
                        intent3.putExtra("key_favorite_local_id", bVar.msw.field_localId);
                        intent3.putExtra("key_can_delete_favorite_item", false);
                    }
                    com.tencent.mm.bg.d.b(context2, "shake", ".ui.TVInfoUI", intent3, 1);
                    return;
                case 16:
                    context2 = view.getContext();
                    if (bVar.bOz.rAi == null) {
                        x.w("MicroMsg.OtherViewWrapper", "go to friend card error, get data proto item null, dataid[%s]", new Object[]{bVar.bOz.jdM});
                        com.tencent.mm.ui.base.h.bA(context2, context2.getString(R.l.favorite_record_info_error));
                        return;
                    }
                    str2 = bVar.bOz.desc;
                    au.HU();
                    bd.a GR = com.tencent.mm.model.c.FT().GR(str2);
                    if (GR == null) {
                        x.w("MicroMsg.OtherViewWrapper", "go to friend card error, parse content fail,[%s], dataid[%s]", new Object[]{str2, bVar.bOz.jdM});
                        com.tencent.mm.ui.base.h.bA(context2, context2.getString(R.l.favorite_record_info_error));
                        return;
                    }
                    Intent intent5 = new Intent();
                    intent5.putExtra("Contact_User", GR.otZ);
                    intent5.putExtra("Contact_Alias", GR.cCR);
                    intent5.putExtra("Contact_Nick", GR.nickname);
                    intent5.putExtra("Contact_QuanPin", GR.eLA);
                    intent5.putExtra("Contact_PyInitial", GR.eLz);
                    intent5.putExtra("Contact_Uin", GR.lWQ);
                    intent5.putExtra("Contact_Mobile_MD5", GR.tbE);
                    intent5.putExtra("Contact_full_Mobile_MD5", GR.tbF);
                    intent5.putExtra("Contact_QQNick", GR.cmJ());
                    intent5.putExtra("User_From_Fmessage", false);
                    intent5.putExtra("Contact_Scene", GR.scene);
                    intent5.putExtra("Contact_FMessageCard", true);
                    intent5.putExtra("Contact_RemarkName", GR.eLE);
                    intent5.putExtra("Contact_VUser_Info_Flag", GR.pOR);
                    intent5.putExtra("Contact_VUser_Info", GR.csP);
                    intent5.putExtra("Contact_BrandIconURL", GR.lUI);
                    intent5.putExtra("Contact_Province", GR.getProvince());
                    intent5.putExtra("Contact_City", GR.getCity());
                    intent5.putExtra("Contact_Sex", GR.sex);
                    intent5.putExtra("Contact_Signature", GR.signature);
                    intent5.putExtra("Contact_ShowUserName", false);
                    intent5.putExtra("Contact_KSnsIFlag", 0);
                    com.tencent.mm.bg.d.b(context2, "profile", ".ui.ContactInfoUI", intent5, 1);
                    com.tencent.mm.bh.a.Cy(GR.scene);
                    return;
                case 17:
                    context2 = view.getContext();
                    if (context2 != null && bVar.bjS == 0 && bVar.bOz.rAy != null) {
                        intent3 = new Intent(context2, RecordMsgDetailUI.class);
                        intent3.putExtra("message_id", bVar.bJC);
                        intent3.putExtra("record_xml", bVar.bOz.rAy);
                        context2.startActivity(intent3);
                        return;
                    }
                    return;
                case 19:
                    context2 = view.getContext();
                    if (context2 != null && bVar.bOz.rAi != null) {
                        vv vvVar = bVar.bOz.rAi.rBa;
                        if (vvVar != null) {
                            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                            appBrandStatObject.scene = 1096;
                            ((com.tencent.mm.plugin.appbrand.n.d) g.l(com.tencent.mm.plugin.appbrand.n.d.class)).a(context2, vvVar.username, vvVar.appId, vvVar.bPh, -1, vvVar.bGH, appBrandStatObject);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    public b(a aVar, ag agVar) {
        this.msR = aVar;
        this.handler = agVar;
    }

    public final View eb(Context context) {
        View inflate = View.inflate(context, R.i.record_listitem_other, null);
        this.jeu = com.tencent.mm.bp.a.fromDPToPix(context, 75);
        com.tencent.mm.sdk.b.a.sFg.b(this.fIu);
        return inflate;
    }

    private static String getAppName(Context context, String str) {
        com.tencent.mm.model.ac.b bVar = ac$a.dBp;
        if (bVar != null) {
            return bVar.q(context, str);
        }
        return "";
    }

    public static boolean e(vx vxVar) {
        avq Qa = com.tencent.mm.an.b.Qa();
        return Qa != null && Qa.rYj == 6 && bi.aG(vxVar.jdM, "").equals(Qa.rsp) && com.tencent.mm.an.b.PY();
    }

    @SuppressLint({"ResourceType"})
    public final void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar) {
        TextView textView = (TextView) view.findViewById(R.h.title);
        TextView textView2 = (TextView) view.findViewById(R.h.desc);
        TextView textView3 = (TextView) view.findViewById(R.h.source);
        MMImageView mMImageView = (MMImageView) view.findViewById(R.h.icon);
        mMImageView.setVisibility(0);
        ImageView imageView = (ImageView) view.findViewById(R.h.icon_mask);
        imageView.setVisibility(8);
        View findViewById = view.findViewById(R.h.record_listitem_content);
        findViewById.setVisibility(0);
        findViewById.setTag(bVar);
        findViewById.setOnClickListener(this.mtE);
        View findViewById2 = view.findViewById(R.h.unsupported);
        findViewById2.setVisibility(8);
        a.a aVar = new a.a();
        if (bVar.bjS == 0) {
            aVar.msT = bVar.bJC;
        } else if (bVar.bjS == 1) {
            aVar.msT = bVar.msw.field_localId;
        }
        aVar.bOA = mMImageView;
        aVar.bOz = bVar.bOz;
        aVar.height = this.jeu;
        aVar.width = this.jeu;
        vx vxVar;
        CharSequence string;
        vx vxVar2;
        vx vxVar3;
        switch (bVar.bOz.bjS) {
            case 4:
            case 15:
                vxVar = bVar.bOz;
                if (bi.oW(vxVar.title)) {
                    textView.setText(R.l.favorite_video);
                } else {
                    textView.setText(vxVar.title);
                }
                if (vxVar.duration <= 0) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setVisibility(0);
                    Context context = textView2.getContext();
                    int i2 = vxVar.duration;
                    if (i2 <= 0) {
                        string = context.getString(R.l.favorite_voice_length, new Object[]{Integer.valueOf(0)});
                    } else {
                        int i3 = i2 / 60;
                        i2 %= 60;
                        string = i3 == 0 ? context.getString(R.l.favorite_voice_length, new Object[]{Integer.valueOf(i2)}) : context.getString(R.l.favorite_video_length, new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
                    }
                    textView2.setText(string);
                }
                if (vxVar.rAi == null) {
                    x.w("MicroMsg.OtherViewWrapper", "video, get data proto item null, dataid[%s]", new Object[]{vxVar.jdM});
                    textView3.setVisibility(8);
                } else {
                    vz vzVar = vxVar.rAi.rAJ;
                    if (!bi.oW(vzVar.appId)) {
                        string = getAppName(textView3.getContext(), vzVar.appId);
                        if (bi.oW(string)) {
                            textView3.setVisibility(8);
                        } else {
                            textView3.setVisibility(0);
                            textView3.setText(string);
                        }
                    }
                }
                imageView.setVisibility(0);
                imageView.setImageResource(R.g.video_playicon_normal);
                aVar.bOB = R.k.app_attach_file_icon_video;
                this.msR.a(aVar);
                break;
            case 5:
                vxVar2 = bVar.bOz;
                CharSequence charSequence = "";
                xa xaVar = null;
                if (!(vxVar2 == null || vxVar2.rAi == null)) {
                    xaVar = vxVar2.rAi.rAN;
                }
                if (xaVar != null) {
                    charSequence = xaVar.title;
                }
                if (bi.oW(charSequence) && vxVar2 != null) {
                    charSequence = vxVar2.title;
                }
                if (bi.oW(charSequence)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(charSequence);
                    textView.setVisibility(0);
                }
                textView2.setVisibility(8);
                string = "";
                if (xaVar != null) {
                    string = bi.WR(xaVar.rCn);
                }
                vz vzVar2 = null;
                if (!(vxVar2 == null || vxVar2.rAi == null)) {
                    vzVar2 = vxVar2.rAi.rAJ;
                }
                if (vzVar2 != null) {
                    if (!bi.oW(vzVar2.appId)) {
                        string = bi.aG(getAppName(textView3.getContext(), vzVar2.appId), "");
                    } else if (!bi.oW(vzVar2.bGy)) {
                        au.HU();
                        ab Yg = com.tencent.mm.model.c.FR().Yg(vzVar2.bGy);
                        if (Yg == null || !Yg.field_username.equals(vzVar2.bGy)) {
                            am.a.dBr.a(vzVar2.bGy, "", null);
                        } else {
                            string = Yg.BL();
                        }
                    }
                    if (bi.oW(string) || string.equals(vzVar2.bGy)) {
                        string = bi.WR(vzVar2.egr);
                    }
                }
                if (bi.oW(string)) {
                    textView3.setVisibility(8);
                } else {
                    textView3.setText(string);
                    textView3.setVisibility(0);
                }
                aVar.bOB = R.g.app_attach_file_icon_pic;
                this.msR.a(aVar);
                break;
            case 6:
                vxVar3 = bVar.bOz;
                if (vxVar3.rAi == null) {
                    x.w("MicroMsg.OtherViewWrapper", "location, get data proto item null, dataid[%s]", new Object[]{vxVar3.jdM});
                    textView.setText(R.l.favorite_location);
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    we weVar = vxVar3.rAi.rAL;
                    if (bi.oW(weVar.bWB)) {
                        textView.setText(weVar.label);
                        textView2.setText(R.l.favorite_location);
                        textView3.setText("");
                    } else {
                        textView.setText(weVar.bWB);
                        textView2.setText(weVar.label);
                        textView3.setText(R.l.favorite_location);
                    }
                }
                mMImageView.setImageResource(R.k.app_attach_file_icon_location);
                break;
            case 7:
                textView.setText(bVar.bOz.title);
                textView2.setText(bVar.bOz.desc);
                imageView.setTag(bVar);
                imageView.setOnClickListener(this.jex);
                imageView.setImageResource(R.g.music_playicon);
                imageView.setVisibility(0);
                if (e(bVar.bOz)) {
                    imageView.setImageResource(R.g.music_pauseicon);
                }
                textView3.setVisibility(8);
                aVar.bOB = R.k.app_attach_file_icon_music;
                this.msR.a(aVar);
                break;
            case 8:
                vxVar3 = bVar.bOz;
                textView.setText(vxVar3.title);
                textView2.setVisibility(0);
                textView2.setText(bi.aj((float) vxVar3.rzJ));
                textView3.setVisibility(8);
                if (vxVar3.rAw == 2) {
                    textView2.setText(">25MB");
                }
                mMImageView.setImageResource(com.tencent.mm.pluginsdk.c.Sz(bVar.bOz.rzD));
                break;
            case 10:
                vxVar = bVar.bOz;
                if (vxVar.rAi == null) {
                    x.w("MicroMsg.OtherViewWrapper", "product, get data proto item null, dataid[%s]", new Object[]{vxVar.jdM});
                    textView.setText("");
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    wk wkVar = vxVar.rAi.rAP;
                    textView.setText(wkVar.title);
                    textView2.setText(wkVar.desc);
                    textView3.setText(bi.aG(getAppName(textView3.getContext(), vxVar.rAi.rAJ.appId), textView3.getContext().getString(R.l.favorite_product)));
                }
                aVar.bOB = R.k.app_attach_file_icon_unknow;
                this.msR.a(aVar);
                break;
            case 11:
                vxVar = bVar.bOz;
                if (vxVar.rAi == null) {
                    x.w("MicroMsg.OtherViewWrapper", "mall product, get data proto item null, dataid[%s]", new Object[]{vxVar.jdM});
                    textView.setText("");
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    wk wkVar2 = vxVar.rAi.rAP;
                    textView.setText(wkVar2.title);
                    textView2.setText(wkVar2.desc);
                    textView.setSingleLine(false);
                    textView.setMaxLines(2);
                    textView3.setVisibility(8);
                }
                aVar.bOB = R.k.app_attach_file_icon_unknow;
                aVar.bOz = null;
                this.msR.a(aVar);
                break;
            case 14:
                vxVar = bVar.bOz;
                if (vxVar.rAi == null || vxVar.rAi.rAR == null) {
                    x.w("MicroMsg.OtherViewWrapper", "tv, get data proto item null, dataid[%s]", new Object[]{vxVar.jdM});
                    textView.setText("");
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    wu wuVar = vxVar.rAi.rAR;
                    textView.setText(wuVar.title);
                    textView2.setText(wuVar.desc);
                    textView3.setText(bi.aG(getAppName(textView3.getContext(), vxVar.rAi.rAJ.appId), textView3.getContext().getString(R.l.favorite_tv)));
                }
                aVar.bOB = R.k.app_attach_file_icon_unknow;
                aVar.bOz = null;
                this.msR.a(aVar);
                break;
            case 16:
                vxVar3 = bVar.bOz;
                au.HU();
                bd.a GR = com.tencent.mm.model.c.FT().GR(vxVar3.desc);
                if (GR == null) {
                    x.e("MicroMsg.OtherViewWrapper", "parse possible friend msg failed");
                }
                textView.setText(j.a(textView.getContext(), GR != null ? GR.nickname : "", textView.getTextSize()));
                textView2.setVisibility(8);
                textView3.setText(R.l.favorite_friend_card);
                textView3.setVisibility(0);
                String str = GR.otZ;
                if (!bi.oW(str)) {
                    com.tencent.mm.pluginsdk.ui.a.b.a(mMImageView, str);
                    break;
                } else {
                    mMImageView.setImageResource(R.g.default_avatar);
                    break;
                }
            case 17:
                vxVar3 = bVar.bOz;
                textView.setText(vxVar3.title);
                textView2.setVisibility(0);
                textView2.setText(vxVar3.desc);
                mMImageView.setVisibility(8);
                break;
            case 19:
                vxVar2 = bVar.bOz;
                CharSequence charSequence2 = "";
                if (vxVar2 != null) {
                    charSequence2 = vxVar2.title;
                }
                if (bi.oW(charSequence2)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(charSequence2);
                    textView.setVisibility(0);
                }
                textView2.setText(textView3.getContext().getString(R.l.app_brand_entrance));
                textView2.setVisibility(0);
                a.c cVar = new a.c();
                cVar.bOz = bVar.bOz;
                if (bVar.bjS == 0) {
                    cVar.msT = bVar.bJC;
                } else if (bVar.bjS == 1) {
                    cVar.msT = bVar.msw.field_localId;
                }
                aVar.bOB = R.g.app_attach_file_icon_pic;
                Bitmap a = this.msR.a(cVar);
                if (a == null) {
                    this.msR.a(aVar);
                    break;
                } else {
                    mMImageView.setImageBitmap(a);
                    break;
                }
            default:
                findViewById.setVisibility(8);
                findViewById2.setVisibility(0);
                return;
        }
        textView3.setVisibility(8);
    }

    public final void destroy() {
        x.d("MicroMsg.OtherViewWrapper", "do destroy");
        this.msR = null;
        this.handler = null;
        com.tencent.mm.sdk.b.a.sFg.c(this.fIu);
        this.mtD = false;
    }

    public final void pause() {
    }

    static void a(Intent intent, com.tencent.mm.plugin.record.ui.a.b bVar, Context context, String str, String str2) {
        intent.putExtra("key_detail_fav_path", str);
        intent.putExtra("key_detail_fav_thumb_path", str2);
        intent.putExtra("key_detail_fav_video_duration", bVar.bOz.duration);
        intent.putExtra("key_detail_statExtStr", bVar.bOz.bZN);
        com.tencent.mm.plugin.fav.a.b.a(context, ".ui.detail.FavoriteVideoPlayUI", intent, 1);
    }
}
