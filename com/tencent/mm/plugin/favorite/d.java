package com.tencent.mm.plugin.favorite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.ui.h;
import com.tencent.mm.pluginsdk.ui.applet.g$a;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wa;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.protocal.c.wf;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.protocal.c.wn;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d {
    private static int[] jfV = new int[]{R.h.chatting_note_thumb_iv_0, R.h.chatting_note_thumb_iv_1, R.h.chatting_note_thumb_iv_2, R.h.chatting_note_thumb_iv_3, R.h.chatting_note_thumb_iv_4};

    public static void b(Context context, g gVar, wn wnVar) {
        if (context == null) {
            x.w("MicroMsg.FavItemLogic", "Context is null");
        } else if (gVar == null) {
            x.w("MicroMsg.FavItemLogic", "Fav item is null");
        } else {
            x.i("MicroMsg.FavItemLogic", "Handler favItemInfo id %d, type %d", new Object[]{Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_type)});
            Intent intent;
            long j;
            String str;
            Intent intent2;
            switch (gVar.field_type) {
                case -2:
                    Toast.makeText(context, R.l.favorite_unknown_type, 0).show();
                    return;
                case 1:
                    Intent intent3 = new Intent();
                    intent3.putExtra("key_detail_text", gVar.field_favProto.desc);
                    intent3.putExtra("key_detail_info_id", gVar.field_localId);
                    intent3.putExtra("key_detail_can_share_to_friend", gVar.aLd());
                    intent3.putExtra("key_detail_time", gVar.field_updateTime);
                    intent3.putExtra("key_detail_create_time", gVar.field_sourceCreateTime <= 0 ? gVar.field_updateTime : gVar.field_sourceCreateTime);
                    a(wnVar, intent3);
                    i.cJ("FavoriteTextDetailUI", wnVar.bJK);
                    b.a(context, ".ui.detail.FavoriteTextDetailUI", intent3);
                    return;
                case 2:
                    e(context, gVar, wnVar);
                    return;
                case 3:
                    intent = new Intent();
                    a(gVar, wnVar, intent);
                    intent.putExtra("key_detail_create_time", gVar.field_favProto.rBG.createTime);
                    i.cJ("FavoriteVoiceDetailUI", wnVar.bJK);
                    b.a(context, ".ui.detail.FavoriteVoiceDetailUI", intent);
                    return;
                case 4:
                    d(context, gVar, wnVar);
                    return;
                case 5:
                    d(context, gVar, true, wnVar);
                    return;
                case 6:
                    we weVar = gVar.field_favProto.rAL;
                    String str2 = gVar.field_favProto.fky;
                    wr wrVar = gVar.field_favProto.rBG;
                    String gT = (wrVar == null || bi.oW(wrVar.rBh)) ? r.gT(gVar.field_fromUser) : r.gT(wrVar.rBh);
                    ArrayList arrayList = new ArrayList();
                    if (gVar.field_tagProto.rBX != null) {
                        arrayList.addAll(gVar.field_tagProto.rBX);
                    }
                    i.cJ("RedirectUI", wnVar.bJK);
                    b.a(gVar.field_localId, weVar, gT, str2, arrayList, context);
                    return;
                case 7:
                    String absolutePath;
                    wr wrVar2 = gVar.field_favProto.rBG;
                    vx c = b.c(gVar);
                    File file = new File(b.c(c));
                    if (file.exists()) {
                        absolutePath = file.getAbsolutePath();
                    } else if (c.bJv == null) {
                        absolutePath = "";
                    } else {
                        file = new File(b.aKO() + com.tencent.mm.a.g.u(c.bJv.getBytes()));
                        absolutePath = file.exists() ? file.getAbsolutePath() : "";
                    }
                    avq a = ((com.tencent.mm.an.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.an.a.b.class)).a(6, null, c.title, c.desc, c.rzv, c.rzz, c.rzx, c.jdM, b.aKV(), absolutePath, "", wrVar2.appId);
                    com.tencent.mm.an.b.b(a);
                    a.eaZ = String.valueOf(gVar.field_localId);
                    intent = new Intent();
                    intent.putExtra("key_scene", 2);
                    i.cJ("MusicMainUI", wnVar.bJK);
                    com.tencent.mm.bg.d.b(context, "music", ".ui.MusicMainUI", intent);
                    return;
                case 8:
                    c(context, gVar, true, wnVar);
                    return;
                case 10:
                    x.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[]{Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId)});
                    j = gVar.field_localId;
                    str = gVar.field_favProto.rAP.info;
                    intent2 = new Intent();
                    intent2.putExtra("key_is_favorite_item", true);
                    intent2.putExtra("key_favorite_local_id", j);
                    intent2.putExtra("key_Product_xml", str);
                    intent2.putExtra("key_can_delete_favorite_item", true);
                    intent2.putExtra("key_ProductUI_getProductInfoScene", 3);
                    com.tencent.mm.bg.d.b(context, "scanner", ".ui.ProductUI", intent2);
                    return;
                case 11:
                    x.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[]{Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId)});
                    intent = new Intent();
                    intent.putExtra("key_product_scene", 4);
                    intent.putExtra("key_product_info", gVar.field_favProto.rAP.info);
                    com.tencent.mm.bg.d.b(context, "product", ".ui.MallProductUI", intent);
                    return;
                case 12:
                case 15:
                    x.d("MicroMsg.FavItemLogic", "start tv ui, fav id %d, fav local id %d", new Object[]{Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId)});
                    j = gVar.field_localId;
                    str = gVar.field_favProto.rAR.info;
                    intent2 = new Intent();
                    intent2.putExtra("key_TV_getProductInfoScene", 3);
                    intent2.putExtra("key_is_favorite_item", true);
                    intent2.putExtra("key_favorite_local_id", j);
                    intent2.putExtra("key_TV_xml", str);
                    intent2.putExtra("key_can_delete_favorite_item", true);
                    com.tencent.mm.bg.d.b(context, "shake", ".ui.TVInfoUI", intent2);
                    return;
                case 14:
                    a(context, gVar, true, wnVar);
                    return;
                case 16:
                    vx c2 = b.c(gVar);
                    if (c2 == null || c2.rAo == null || (bi.oW(c2.rAo.dyJ) && bi.oW(c2.rAo.dyN))) {
                        d(context, gVar, wnVar);
                        return;
                    }
                    x.i("MicroMsg.FavItemLogic", "it is ad sight.");
                    c(context, gVar, wnVar);
                    return;
                case 17:
                    String str3 = b.c(gVar).desc;
                    au.HU();
                    a GR = c.FT().GR(str3);
                    if (GR != null) {
                        Intent intent4 = new Intent();
                        intent4.putExtra("Contact_User", GR.otZ);
                        intent4.putExtra("Contact_Alias", GR.cCR);
                        intent4.putExtra("Contact_Nick", GR.nickname);
                        intent4.putExtra("Contact_QuanPin", GR.eLA);
                        intent4.putExtra("Contact_PyInitial", GR.eLz);
                        intent4.putExtra("Contact_Uin", GR.lWQ);
                        intent4.putExtra("Contact_Mobile_MD5", GR.tbE);
                        intent4.putExtra("Contact_full_Mobile_MD5", GR.tbF);
                        intent4.putExtra("Contact_QQNick", GR.cmJ());
                        intent4.putExtra("User_From_Fmessage", false);
                        intent4.putExtra("Contact_Scene", GR.scene);
                        intent4.putExtra("Contact_FMessageCard", true);
                        intent4.putExtra("Contact_RemarkName", GR.eLE);
                        intent4.putExtra("Contact_VUser_Info_Flag", GR.pOR);
                        intent4.putExtra("Contact_VUser_Info", GR.csP);
                        intent4.putExtra("Contact_BrandIconURL", GR.lUI);
                        intent4.putExtra("Contact_Province", GR.getProvince());
                        intent4.putExtra("Contact_City", GR.getCity());
                        intent4.putExtra("Contact_Sex", GR.sex);
                        intent4.putExtra("Contact_Signature", GR.signature);
                        intent4.putExtra("Contact_ShowUserName", false);
                        intent4.putExtra("Contact_KSnsIFlag", 0);
                        i.cJ("ContactInfoUI", wnVar.bJK);
                        com.tencent.mm.bg.d.b(context, "profile", ".ui.ContactInfoUI", intent4);
                        com.tencent.mm.bh.a.Cy(GR.scene);
                        return;
                    }
                    return;
                case 18:
                    b(context, gVar, true, wnVar);
                    return;
                default:
                    x.w("MicroMsg.FavItemLogic", "Do not match any type %d", new Object[]{Integer.valueOf(gVar.field_type)});
                    return;
            }
        }
    }

    private static void a(Context context, g gVar, boolean z, wn wnVar) {
        Intent intent = new Intent();
        intent.putExtra("key_detail_info_id", gVar.field_localId);
        intent.putExtra("show_share", z);
        a(wnVar, intent);
        i.cJ("FavRecordDetailUI", wnVar.bJK);
        com.tencent.mm.bg.d.b(context, "record", ".ui.FavRecordDetailUI", intent);
    }

    private static void b(Context context, g gVar, boolean z, wn wnVar) {
        x.i("MicroMsg.FavItemLogic", "click WNNoteItem, handleWNNoteItem");
        kp kpVar = new kp();
        kpVar.bUP.field_localId = gVar.field_localId;
        if (gVar.field_localId == -1) {
            kpVar.bUP.bUW = 4;
        } else {
            kpVar.bUP.bUR = gVar.field_xml;
        }
        kpVar.bUP.context = context;
        Bundle bundle = new Bundle();
        wf wfVar = gVar.field_favProto.qYa;
        if (wfVar != null) {
            bundle.putString("noteauthor", wfVar.rBz);
            bundle.putString("noteeditor", wfVar.rBA);
        }
        bundle.putLong("edittime", gVar.field_updateTime);
        kpVar.bUP.bUU = bundle;
        kpVar.bUP.field_favProto = gVar.field_favProto;
        kpVar.bUP.type = 2;
        kpVar.bUP.bUY = z;
        kpVar.bUP.bUZ = wnVar;
        com.tencent.mm.sdk.b.a.sFg.m(kpVar);
        i.cJ("NoteEditorUI", wnVar.bJK);
    }

    private static void c(Context context, g gVar, boolean z, wn wnVar) {
        vx c = b.c(gVar);
        if (b.f(c)) {
            if (b.g(c)) {
                e(context, gVar, wnVar);
                return;
            } else if (!com.tencent.mm.pluginsdk.ui.tools.a.a((Activity) context, b.b(c), c.rzD, 2)) {
                return;
            }
        }
        Intent intent = new Intent();
        intent.putExtra("key_detail_info_id", gVar.field_localId);
        intent.putExtra("show_share", z);
        a(wnVar, intent);
        i.cJ("FavoriteFileDetailUI", wnVar.bJK);
        b.a(context, ".ui.detail.FavoriteFileDetailUI", intent);
    }

    private static String G(g gVar) {
        if (gVar.field_favProto == null) {
            return null;
        }
        if (gVar.field_favProto.rAN != null && !bi.oW(gVar.field_favProto.rAN.canvasPageXml)) {
            return gVar.field_favProto.rAN.thumbUrl;
        }
        List list = gVar.field_favProto.rBI;
        if (list == null || list.size() != 1) {
            return null;
        }
        return ((vx) list.get(0)).dwE;
    }

    private static void d(Context context, g gVar, boolean z, wn wnVar) {
        String str;
        if (gVar.field_favProto != null) {
            if (gVar.field_favProto.rAN == null || bi.oW(gVar.field_favProto.rAN.canvasPageXml)) {
                List list = gVar.field_favProto.rBI;
                if (list != null && list.size() == 1) {
                    str = ((vx) list.get(0)).canvasPageXml;
                    if (bi.oW(str)) {
                        wr wrVar = gVar.field_favProto.rBG;
                        str = "";
                        String str2 = "";
                        String str3 = "";
                        if (gVar.field_favProto.rAN != null) {
                            xa xaVar = gVar.field_favProto.rAN;
                            str = xaVar.rCn;
                            str2 = xaVar.title;
                            str3 = xaVar.desc;
                        }
                        if (wrVar != null && bi.oW(r0)) {
                            str = wrVar.egr;
                        }
                        if (!bi.oW(str)) {
                            vx c = b.c(gVar);
                            if (c != null) {
                                if (bi.oW(str2)) {
                                    str2 = c.title;
                                }
                                if (bi.oW(str3)) {
                                    str3 = c.desc;
                                }
                            }
                            x.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[]{Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId)});
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", str);
                            intent.putExtra("showShare", z);
                            intent.putExtra("is_favorite_item", true);
                            intent.putExtra("fav_local_id", gVar.field_localId);
                            String str4 = "favorite_control_argument";
                            Bundle bundle = new Bundle();
                            bundle.putBoolean("key_ctrl_flag_open_chat", gVar.aLd());
                            bundle.putBoolean("key_ctrl_flag_open_sns", gVar.aLe());
                            bundle.putBoolean("key_ctrl_flag_open_weibo", (gVar.field_favProto.rAW & 4) != 0);
                            bundle.putBoolean("key_ctrl_flag_open_cplink", (gVar.field_favProto.rAW & 8) != 0);
                            bundle.putBoolean("key_ctrl_flag_open_browser", (gVar.field_favProto.rAW & 16) != 0);
                            bundle.putBoolean("key_ctrl_flag_open_weiyun", (gVar.field_favProto.rAW & 32) != 0);
                            bundle.putBoolean("key_ctrl_flag_open_facebook", (gVar.field_favProto.rAW & 64) != 0);
                            x.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", new Object[]{bundle.toString()});
                            intent.putExtra(str4, bundle);
                            intent.putExtra("sentUsername", gVar.field_fromUser);
                            if (!(wrVar == null || bi.oW(wrVar.bGy))) {
                                intent.putExtra("srcDisplayname", r.gT(wrVar.bGy));
                            }
                            intent.putExtra("mode", 1);
                            intent.putExtra("geta8key_scene", 14);
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("key_snsad_statextstr", b.c(gVar).bZN);
                            bundle2.putLong("favlocalid", gVar.field_localId);
                            intent.putExtra("jsapiargs", bundle2);
                            intent.putExtra("from_scence", 4);
                            String str5 = "fav_" + q.GF() + "_" + gVar.field_id;
                            intent.putExtra("KPublisherId", str5);
                            intent.putExtra("pre_username", gVar.field_fromUser);
                            intent.putExtra("prePublishId", str5);
                            intent.putExtra("preUsername", gVar.field_fromUser);
                            intent.putExtra("share_report_pre_msg_url", str);
                            intent.putExtra("share_report_pre_msg_title", str2);
                            intent.putExtra("share_report_pre_msg_desc", str3);
                            intent.putExtra("share_report_pre_msg_icon_url", G(gVar));
                            intent.putExtra("share_report_pre_msg_appid", "");
                            intent.putExtra("share_report_from_scene", 4);
                            Bundle no = com.tencent.mm.modelstat.a.b.no(com.tencent.mm.pluginsdk.model.d.class.getName());
                            no.putInt("mm_rpt_fav_id", gVar.field_id);
                            no.putInt("key_detail_fav_scene", wnVar.scene);
                            no.putInt("key_detail_fav_sub_scene", wnVar.iVT);
                            no.putInt("key_detail_fav_index", wnVar.index);
                            no.putString("key_detail_fav_query", wnVar.bWm);
                            no.putString("key_detail_fav_sessionid", wnVar.bJK);
                            no.putString("key_detail_fav_tags", wnVar.iVW);
                            i.cJ("WebViewUI", wnVar.bJK);
                            intent.putExtra("mm_report_bundle", no);
                            intent.putExtra("geta8key_scene", 14);
                            com.tencent.mm.bg.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
                        }
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("sns_landing_pages_xml", str);
                    intent2.putExtra("sns_landig_pages_from_source", 7);
                    intent2.putExtra("sns_landing_pages_share_thumb_url", G(gVar));
                    intent2.putExtra("sns_landing_favid", q.GF() + "_" + gVar.field_id);
                    intent2.addFlags(268435456);
                    com.tencent.mm.bg.d.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent2);
                    return;
                }
            }
            str = gVar.field_favProto.rAN.canvasPageXml;
            if (bi.oW(str)) {
                wr wrVar2 = gVar.field_favProto.rBG;
                str = "";
                String str22 = "";
                String str32 = "";
                if (gVar.field_favProto.rAN != null) {
                    xa xaVar2 = gVar.field_favProto.rAN;
                    str = xaVar2.rCn;
                    str22 = xaVar2.title;
                    str32 = xaVar2.desc;
                }
                if (wrVar2 != null && bi.oW(r0)) {
                    str = wrVar2.egr;
                }
                if (!bi.oW(str)) {
                    vx c2 = b.c(gVar);
                    if (c2 != null) {
                        if (bi.oW(str22)) {
                            str22 = c2.title;
                        }
                        if (bi.oW(str32)) {
                            str32 = c2.desc;
                        }
                    }
                    x.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[]{Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId)});
                    Intent intent3 = new Intent();
                    intent3.putExtra("rawUrl", str);
                    intent3.putExtra("showShare", z);
                    intent3.putExtra("is_favorite_item", true);
                    intent3.putExtra("fav_local_id", gVar.field_localId);
                    String str42 = "favorite_control_argument";
                    Bundle bundle3 = new Bundle();
                    bundle3.putBoolean("key_ctrl_flag_open_chat", gVar.aLd());
                    bundle3.putBoolean("key_ctrl_flag_open_sns", gVar.aLe());
                    bundle3.putBoolean("key_ctrl_flag_open_weibo", (gVar.field_favProto.rAW & 4) != 0);
                    bundle3.putBoolean("key_ctrl_flag_open_cplink", (gVar.field_favProto.rAW & 8) != 0);
                    bundle3.putBoolean("key_ctrl_flag_open_browser", (gVar.field_favProto.rAW & 16) != 0);
                    bundle3.putBoolean("key_ctrl_flag_open_weiyun", (gVar.field_favProto.rAW & 32) != 0);
                    bundle3.putBoolean("key_ctrl_flag_open_facebook", (gVar.field_favProto.rAW & 64) != 0);
                    x.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", new Object[]{bundle3.toString()});
                    intent3.putExtra(str42, bundle3);
                    intent3.putExtra("sentUsername", gVar.field_fromUser);
                    if (!(wrVar2 == null || bi.oW(wrVar2.bGy))) {
                        intent3.putExtra("srcDisplayname", r.gT(wrVar2.bGy));
                    }
                    intent3.putExtra("mode", 1);
                    intent3.putExtra("geta8key_scene", 14);
                    Bundle bundle22 = new Bundle();
                    bundle22.putString("key_snsad_statextstr", b.c(gVar).bZN);
                    bundle22.putLong("favlocalid", gVar.field_localId);
                    intent3.putExtra("jsapiargs", bundle22);
                    intent3.putExtra("from_scence", 4);
                    String str52 = "fav_" + q.GF() + "_" + gVar.field_id;
                    intent3.putExtra("KPublisherId", str52);
                    intent3.putExtra("pre_username", gVar.field_fromUser);
                    intent3.putExtra("prePublishId", str52);
                    intent3.putExtra("preUsername", gVar.field_fromUser);
                    intent3.putExtra("share_report_pre_msg_url", str);
                    intent3.putExtra("share_report_pre_msg_title", str22);
                    intent3.putExtra("share_report_pre_msg_desc", str32);
                    intent3.putExtra("share_report_pre_msg_icon_url", G(gVar));
                    intent3.putExtra("share_report_pre_msg_appid", "");
                    intent3.putExtra("share_report_from_scene", 4);
                    Bundle no2 = com.tencent.mm.modelstat.a.b.no(com.tencent.mm.pluginsdk.model.d.class.getName());
                    no2.putInt("mm_rpt_fav_id", gVar.field_id);
                    no2.putInt("key_detail_fav_scene", wnVar.scene);
                    no2.putInt("key_detail_fav_sub_scene", wnVar.iVT);
                    no2.putInt("key_detail_fav_index", wnVar.index);
                    no2.putString("key_detail_fav_query", wnVar.bWm);
                    no2.putString("key_detail_fav_sessionid", wnVar.bJK);
                    no2.putString("key_detail_fav_tags", wnVar.iVW);
                    i.cJ("WebViewUI", wnVar.bJK);
                    intent3.putExtra("mm_report_bundle", no2);
                    intent3.putExtra("geta8key_scene", 14);
                    com.tencent.mm.bg.d.b(context, "webview", ".ui.tools.WebViewUI", intent3);
                }
            }
            Intent intent22 = new Intent();
            intent22.putExtra("sns_landing_pages_xml", str);
            intent22.putExtra("sns_landig_pages_from_source", 7);
            intent22.putExtra("sns_landing_pages_share_thumb_url", G(gVar));
            intent22.putExtra("sns_landing_favid", q.GF() + "_" + gVar.field_id);
            intent22.addFlags(268435456);
            com.tencent.mm.bg.d.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent22);
            return;
        }
        str = null;
        if (bi.oW(str)) {
            Intent intent222 = new Intent();
            intent222.putExtra("sns_landing_pages_xml", str);
            intent222.putExtra("sns_landig_pages_from_source", 7);
            intent222.putExtra("sns_landing_pages_share_thumb_url", G(gVar));
            intent222.putExtra("sns_landing_favid", q.GF() + "_" + gVar.field_id);
            intent222.addFlags(268435456);
            com.tencent.mm.bg.d.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent222);
            return;
        }
        wr wrVar22 = gVar.field_favProto.rBG;
        str = "";
        String str222 = "";
        String str322 = "";
        if (gVar.field_favProto.rAN != null) {
            xa xaVar22 = gVar.field_favProto.rAN;
            str = xaVar22.rCn;
            str222 = xaVar22.title;
            str322 = xaVar22.desc;
        }
        if (wrVar22 != null && bi.oW(r0)) {
            str = wrVar22.egr;
        }
        if (!bi.oW(str)) {
            vx c22 = b.c(gVar);
            if (c22 != null) {
                if (bi.oW(str222)) {
                    str222 = c22.title;
                }
                if (bi.oW(str322)) {
                    str322 = c22.desc;
                }
            }
            x.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[]{Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId)});
            Intent intent32 = new Intent();
            intent32.putExtra("rawUrl", str);
            intent32.putExtra("showShare", z);
            intent32.putExtra("is_favorite_item", true);
            intent32.putExtra("fav_local_id", gVar.field_localId);
            String str422 = "favorite_control_argument";
            Bundle bundle32 = new Bundle();
            bundle32.putBoolean("key_ctrl_flag_open_chat", gVar.aLd());
            bundle32.putBoolean("key_ctrl_flag_open_sns", gVar.aLe());
            bundle32.putBoolean("key_ctrl_flag_open_weibo", (gVar.field_favProto.rAW & 4) != 0);
            bundle32.putBoolean("key_ctrl_flag_open_cplink", (gVar.field_favProto.rAW & 8) != 0);
            bundle32.putBoolean("key_ctrl_flag_open_browser", (gVar.field_favProto.rAW & 16) != 0);
            bundle32.putBoolean("key_ctrl_flag_open_weiyun", (gVar.field_favProto.rAW & 32) != 0);
            bundle32.putBoolean("key_ctrl_flag_open_facebook", (gVar.field_favProto.rAW & 64) != 0);
            x.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", new Object[]{bundle32.toString()});
            intent32.putExtra(str422, bundle32);
            intent32.putExtra("sentUsername", gVar.field_fromUser);
            if (!(wrVar22 == null || bi.oW(wrVar22.bGy))) {
                intent32.putExtra("srcDisplayname", r.gT(wrVar22.bGy));
            }
            intent32.putExtra("mode", 1);
            intent32.putExtra("geta8key_scene", 14);
            Bundle bundle222 = new Bundle();
            bundle222.putString("key_snsad_statextstr", b.c(gVar).bZN);
            bundle222.putLong("favlocalid", gVar.field_localId);
            intent32.putExtra("jsapiargs", bundle222);
            intent32.putExtra("from_scence", 4);
            String str522 = "fav_" + q.GF() + "_" + gVar.field_id;
            intent32.putExtra("KPublisherId", str522);
            intent32.putExtra("pre_username", gVar.field_fromUser);
            intent32.putExtra("prePublishId", str522);
            intent32.putExtra("preUsername", gVar.field_fromUser);
            intent32.putExtra("share_report_pre_msg_url", str);
            intent32.putExtra("share_report_pre_msg_title", str222);
            intent32.putExtra("share_report_pre_msg_desc", str322);
            intent32.putExtra("share_report_pre_msg_icon_url", G(gVar));
            intent32.putExtra("share_report_pre_msg_appid", "");
            intent32.putExtra("share_report_from_scene", 4);
            Bundle no22 = com.tencent.mm.modelstat.a.b.no(com.tencent.mm.pluginsdk.model.d.class.getName());
            no22.putInt("mm_rpt_fav_id", gVar.field_id);
            no22.putInt("key_detail_fav_scene", wnVar.scene);
            no22.putInt("key_detail_fav_sub_scene", wnVar.iVT);
            no22.putInt("key_detail_fav_index", wnVar.index);
            no22.putString("key_detail_fav_query", wnVar.bWm);
            no22.putString("key_detail_fav_sessionid", wnVar.bJK);
            no22.putString("key_detail_fav_tags", wnVar.iVW);
            i.cJ("WebViewUI", wnVar.bJK);
            intent32.putExtra("mm_report_bundle", no22);
            intent32.putExtra("geta8key_scene", 14);
            com.tencent.mm.bg.d.b(context, "webview", ".ui.tools.WebViewUI", intent32);
        }
    }

    private static void c(Context context, g gVar, wn wnVar) {
        m.a(m.a.iWj, gVar);
        Intent intent = new Intent();
        intent.putExtra("key_detail_info_id", gVar.field_localId);
        a(wnVar, intent);
        b.a(context, ".ui.detail.FavoriteSightDetailUI", intent);
    }

    private static void d(Context context, g gVar, wn wnVar) {
        boolean z;
        vx c = b.c(gVar);
        wa waVar = c.rAo;
        if (waVar == null || bi.oW(waVar.dyJ)) {
            z = false;
        } else {
            m.a(m.a.iWl, gVar);
            String c2 = b.c(c);
            Intent intent = new Intent();
            intent.putExtra("IsAd", false);
            intent.putExtra("KStremVideoUrl", waVar.dyJ);
            intent.putExtra("StreamWording", waVar.dyM);
            intent.putExtra("StremWebUrl", waVar.dyN);
            intent.putExtra("KThumUrl", waVar.dyO);
            intent.putExtra("KSta_StremVideoAduxInfo", waVar.dyP);
            intent.putExtra("KSta_StremVideoPublishId", waVar.dyQ);
            intent.putExtra("KSta_SourceType", 2);
            intent.putExtra("KSta_Scene", m.b.iWv.value);
            intent.putExtra("KSta_FromUserName", gVar.field_fromUser);
            intent.putExtra("KSta_FavID", gVar.field_id);
            intent.putExtra("KSta_SnsStatExtStr", c.bZN);
            intent.putExtra("KBlockFav", true);
            intent.putExtra("KMediaId", "fakeid_" + gVar.field_id);
            intent.putExtra("KThumbPath", c2);
            intent.putExtra("KMediaVideoTime", waVar.rBq);
            intent.putExtra("KMediaTitle", waVar.dyL);
            com.tencent.mm.bg.d.b(context, "sns", ".ui.VideoAdPlayerUI", intent);
            z = true;
        }
        if (!z) {
            if (bi.oW(c.rzF) || c.rzJ <= 0) {
                x.w("MicroMsg.FavItemLogic", "full md5[%s], fullsize[%d], start use url", new Object[]{c.rzF, Long.valueOf(c.rzJ)});
                String str = b.c(gVar).rzv;
                if (bi.oW(str)) {
                    str = b.c(gVar).rzz;
                }
                if (bi.oW(str)) {
                    x.w("MicroMsg.FavItemLogic", "onClick video url null, return");
                    c(context, gVar, wnVar);
                    return;
                }
                Intent intent2 = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("key_snsad_statextstr", c.bZN);
                bundle.putLong("favlocalid", gVar.field_localId);
                intent2.putExtra("jsapiargs", bundle);
                intent2.putExtra("rawUrl", str);
                intent2.putExtra("is_favorite_item", true);
                intent2.putExtra("fav_local_id", gVar.field_localId);
                intent2.putExtra("geta8key_scene", 14);
                x.d("MicroMsg.FavItemLogic", "start video webview, fav id %d, fav local id %d", new Object[]{Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId)});
                intent2.putExtra("geta8key_scene", 14);
                com.tencent.mm.bg.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
                return;
            }
            Intent intent3 = new Intent();
            a(gVar, wnVar, intent3);
            i.cJ("FavoriteSightDetailUI", wnVar.bJK);
            b.a(context, ".ui.detail.FavoriteSightDetailUI", intent3);
        }
    }

    private static void e(Context context, g gVar, wn wnVar) {
        Intent intent = new Intent();
        a(gVar, wnVar, intent);
        i.cJ("FavoriteImgDetailUI", wnVar.bJK);
        b.a(context, ".ui.detail.FavoriteImgDetailUI", intent);
    }

    private static void a(g gVar, wn wnVar, Intent intent) {
        a(wnVar, intent);
        intent.putExtra("key_detail_info_id", gVar.field_localId);
    }

    private static void a(wn wnVar, Intent intent) {
        intent.putExtra("key_detail_fav_scene", wnVar.scene);
        intent.putExtra("key_detail_fav_sub_scene", wnVar.iVT);
        intent.putExtra("key_detail_fav_index", wnVar.index);
        intent.putExtra("key_detail_fav_query", wnVar.bWm);
        intent.putExtra("key_detail_fav_sessionid", wnVar.bJK);
        intent.putExtra("key_detail_fav_tags", wnVar.iVW);
    }

    public static void a(g$a g_a, Context context, g gVar) {
        String str = null;
        if (gVar == null || context == null) {
            x.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
            return;
        }
        String absolutePath;
        xa xaVar;
        vx c = b.c(gVar);
        if (gVar == null) {
            x.w("MicroMsg.FavItemLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
        } else {
            String Bd;
            vx c2 = b.c(gVar);
            File file;
            if (5 == gVar.field_type) {
                file = new File(b.c(c2));
                if (file.exists()) {
                    absolutePath = file.getAbsolutePath();
                } else {
                    xa xaVar2 = gVar.field_favProto.rAN;
                    absolutePath = xaVar2 == null ? null : xaVar2.thumbUrl;
                    if (bi.oW(absolutePath)) {
                        absolutePath = c2.bJv;
                    }
                    absolutePath = b.Bd(absolutePath);
                    if (bi.oW(absolutePath)) {
                        absolutePath = Integer.valueOf(R.k.app_attach_file_icon_webpage);
                    }
                }
            } else {
                if (11 == gVar.field_type || 10 == gVar.field_type) {
                    wk wkVar = gVar.field_favProto.rAP;
                    if (wkVar != null) {
                        absolutePath = b.Bd(wkVar.thumbUrl);
                        if (bi.oW(absolutePath)) {
                            absolutePath = Integer.valueOf(R.k.app_attach_file_icon_unknow);
                        }
                    }
                }
                if (15 == gVar.field_type || 12 == gVar.field_type) {
                    wu wuVar = gVar.field_favProto.rAR;
                    if (wuVar != null) {
                        absolutePath = b.Bd(wuVar.thumbUrl);
                        if (bi.oW(absolutePath)) {
                            absolutePath = Integer.valueOf(R.k.app_attach_file_icon_unknow);
                        }
                    }
                }
                if (2 == gVar.field_type || 7 == gVar.field_type || 16 == gVar.field_type || 4 == gVar.field_type) {
                    file = new File(b.c(c2));
                    if (!file.exists()) {
                        absolutePath = b.Bd(c2.bJv);
                        if (bi.oW(absolutePath)) {
                            b.a(gVar, c2);
                            absolutePath = b.c(c2);
                        }
                        if (bi.oW(absolutePath)) {
                            switch (gVar.field_type) {
                                case 2:
                                    absolutePath = Integer.valueOf(R.g.app_attach_file_icon_pic);
                                    break;
                                case 7:
                                    absolutePath = Integer.valueOf(R.k.app_attach_file_icon_music);
                                    break;
                                default:
                                    absolutePath = Integer.valueOf(R.k.app_attach_file_icon_video);
                                    break;
                            }
                        }
                    }
                    absolutePath = file.getAbsolutePath();
                } else if (!(3 == gVar.field_type || 6 == gVar.field_type)) {
                    a GR;
                    if (8 == gVar.field_type) {
                        absolutePath = Integer.valueOf(com.tencent.mm.pluginsdk.c.Sz(c2.rzD));
                    } else if (17 == gVar.field_type) {
                        au.HU();
                        GR = c.FT().GR(c2.desc);
                        absolutePath = (GR.otZ == null || GR.otZ.length() == 0) ? Integer.valueOf(R.g.default_avatar) : new SpannableString(GR.otZ);
                    } else if (14 == gVar.field_type && gVar.field_favProto.rBI != null) {
                        Iterator it = gVar.field_favProto.rBI.iterator();
                        while (it.hasNext()) {
                            vx vxVar = (vx) it.next();
                            if (vxVar.bjS != 1) {
                                if (vxVar.bjS == 3) {
                                    absolutePath = Integer.valueOf(R.k.app_attach_file_icon_voice);
                                    break;
                                } else if (vxVar.bjS == 6) {
                                    absolutePath = Integer.valueOf(R.k.app_attach_file_icon_location);
                                    break;
                                } else if (vxVar.bjS == 8) {
                                    absolutePath = Integer.valueOf(com.tencent.mm.pluginsdk.c.Sz(vxVar.rzD));
                                    break;
                                } else if (vxVar.bjS == 2 || vxVar.bjS == 7 || vxVar.bjS == 15 || vxVar.bjS == 4) {
                                    file = new File(b.c(vxVar));
                                    if (file.exists()) {
                                        absolutePath = file.getAbsolutePath();
                                    } else {
                                        Bd = b.Bd(vxVar.bJv);
                                        if (bi.oW(Bd)) {
                                            switch (vxVar.bjS) {
                                                case 2:
                                                    absolutePath = Integer.valueOf(R.g.app_attach_file_icon_pic);
                                                    break;
                                                case 7:
                                                    absolutePath = Integer.valueOf(R.k.app_attach_file_icon_music);
                                                    break;
                                                default:
                                                    absolutePath = Integer.valueOf(R.k.app_attach_file_icon_video);
                                                    break;
                                            }
                                        }
                                        absolutePath = Bd;
                                    }
                                } else if (vxVar.bjS == 5) {
                                    file = new File(b.c(vxVar));
                                    if (file.exists()) {
                                        absolutePath = file.getAbsolutePath();
                                    } else {
                                        xa xaVar3 = vxVar.rAi.rAN;
                                        Bd = xaVar3 == null ? null : xaVar3.thumbUrl;
                                        if (bi.oW(Bd)) {
                                            Bd = vxVar.bJv;
                                        }
                                        absolutePath = b.Bd(Bd);
                                        if (bi.oW(absolutePath)) {
                                            absolutePath = Integer.valueOf(R.k.app_attach_file_icon_webpage);
                                        }
                                    }
                                } else {
                                    if (vxVar.bjS == 10 || vxVar.bjS == 11) {
                                        wk wkVar2 = vxVar.rAi.rAP;
                                        if (wkVar2 != null) {
                                            absolutePath = b.Bd(wkVar2.thumbUrl);
                                            if (bi.oW(absolutePath)) {
                                                absolutePath = Integer.valueOf(R.k.app_attach_file_icon_unknow);
                                            }
                                        }
                                    }
                                    if (vxVar.bjS == 12 || vxVar.bjS == 14) {
                                        wu wuVar2 = vxVar.rAi.rAR;
                                        if (wuVar2 != null) {
                                            absolutePath = b.Bd(wuVar2.thumbUrl);
                                            if (bi.oW(absolutePath)) {
                                                absolutePath = Integer.valueOf(R.k.app_attach_file_icon_unknow);
                                            }
                                        }
                                    }
                                    if (vxVar.bjS == 16) {
                                        au.HU();
                                        GR = c.FT().GR(vxVar.desc);
                                        absolutePath = (GR.otZ == null || GR.otZ.length() == 0) ? Integer.valueOf(R.g.default_avatar) : new SpannableString(GR.otZ);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (absolutePath instanceof String) {
                if (absolutePath instanceof Integer) {
                    ((Integer) absolutePath).intValue();
                }
                absolutePath = null;
            } else {
                absolutePath = absolutePath;
            }
            xaVar = gVar.field_favProto.rAN;
            switch (gVar.field_type) {
                case 1:
                    g_a.TH(gVar.field_favProto.desc);
                    g_a.cdO();
                    g_a.a(new 2(gVar, context));
                    return;
                case 2:
                    g_a.c(com.tencent.mm.sdk.platformtools.c.Wb(absolutePath), 3);
                    return;
                case 4:
                    g_a.c(com.tencent.mm.sdk.platformtools.c.Wb(absolutePath), 2);
                    return;
                case 5:
                    if (xaVar == null || bi.oW(xaVar.title)) {
                        absolutePath = null;
                        Bd = null;
                    } else {
                        Bd = xaVar.title;
                        absolutePath = xaVar.desc;
                    }
                    if (bi.oW(Bd)) {
                        Bd = c.title;
                    }
                    if (bi.oW(absolutePath)) {
                        absolutePath = c.desc;
                    }
                    g_a.TH(new StringBuffer(context.getResources().getString(R.l.app_url)).append(Bd).toString());
                    return;
                case 6:
                    g_a.TH(context.getString(R.l.app_location) + gVar.field_favProto.rAL.label);
                    return;
                case 7:
                    if (!(xaVar == null || bi.oW(xaVar.title))) {
                        str = xaVar.title;
                    }
                    if (bi.oW(str)) {
                        str = c.title;
                    }
                    g_a.TH(new StringBuffer(context.getResources().getString(R.l.app_music)).append(str).toString());
                    return;
                case 8:
                    absolutePath = gVar.field_favProto.title;
                    if (bi.oW(absolutePath)) {
                        absolutePath = c.title;
                    }
                    g_a.TH(new StringBuffer(context.getResources().getString(R.l.app_file)).append(absolutePath).toString());
                    return;
                case 14:
                    g_a.TH(new StringBuffer(context.getResources().getString(R.l.app_record)).append(h.a.a(context, gVar).title).toString());
                    return;
                case 16:
                    g_a.c(com.tencent.mm.sdk.platformtools.c.Wb(absolutePath), 2);
                    return;
                case 18:
                    g_a.TH(new StringBuffer(context.getResources().getString(R.l.app_note)).append(h.a.a(context, gVar).desc.replaceAll("\n", " ")).toString());
                    return;
                default:
                    if (!(xaVar == null || bi.oW(xaVar.title))) {
                        str = xaVar.title;
                    }
                    if (bi.oW(str)) {
                        str = c.title;
                    }
                    g_a.TH(new StringBuffer(context.getResources().getString(R.l.app_app)).append(str).toString());
                    return;
            }
        }
        absolutePath = null;
        if (absolutePath instanceof String) {
            if (absolutePath instanceof Integer) {
                ((Integer) absolutePath).intValue();
            }
            absolutePath = null;
        } else {
            absolutePath = absolutePath;
        }
        xaVar = gVar.field_favProto.rAN;
        switch (gVar.field_type) {
            case 1:
                g_a.TH(gVar.field_favProto.desc);
                g_a.cdO();
                g_a.a(new 2(gVar, context));
                return;
            case 2:
                g_a.c(com.tencent.mm.sdk.platformtools.c.Wb(absolutePath), 3);
                return;
            case 4:
                g_a.c(com.tencent.mm.sdk.platformtools.c.Wb(absolutePath), 2);
                return;
            case 5:
                if (xaVar == null || bi.oW(xaVar.title)) {
                    absolutePath = null;
                    Bd = null;
                } else {
                    Bd = xaVar.title;
                    absolutePath = xaVar.desc;
                }
                if (bi.oW(Bd)) {
                    Bd = c.title;
                }
                if (bi.oW(absolutePath)) {
                    absolutePath = c.desc;
                }
                g_a.TH(new StringBuffer(context.getResources().getString(R.l.app_url)).append(Bd).toString());
                return;
            case 6:
                g_a.TH(context.getString(R.l.app_location) + gVar.field_favProto.rAL.label);
                return;
            case 7:
                if (!(xaVar == null || bi.oW(xaVar.title))) {
                    str = xaVar.title;
                }
                if (bi.oW(str)) {
                    str = c.title;
                }
                g_a.TH(new StringBuffer(context.getResources().getString(R.l.app_music)).append(str).toString());
                return;
            case 8:
                absolutePath = gVar.field_favProto.title;
                if (bi.oW(absolutePath)) {
                    absolutePath = c.title;
                }
                g_a.TH(new StringBuffer(context.getResources().getString(R.l.app_file)).append(absolutePath).toString());
                return;
            case 14:
                g_a.TH(new StringBuffer(context.getResources().getString(R.l.app_record)).append(h.a.a(context, gVar).title).toString());
                return;
            case 16:
                g_a.c(com.tencent.mm.sdk.platformtools.c.Wb(absolutePath), 2);
                return;
            case 18:
                g_a.TH(new StringBuffer(context.getResources().getString(R.l.app_note)).append(h.a.a(context, gVar).desc.replaceAll("\n", " ")).toString());
                return;
            default:
                if (!(xaVar == null || bi.oW(xaVar.title))) {
                    str = xaVar.title;
                }
                if (bi.oW(str)) {
                    str = c.title;
                }
                g_a.TH(new StringBuffer(context.getResources().getString(R.l.app_app)).append(str).toString());
                return;
        }
    }

    public static void b(g$a g_a, final Context context, final g gVar) {
        if (gVar == null || context == null) {
            x.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
            return;
        }
        vx c = b.c(gVar);
        switch (gVar.field_type) {
            case 1:
                g_a.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                    public final void aMV() {
                        Intent intent = new Intent();
                        intent.putExtra("Retr_Msg_content", gVar.field_favProto.desc);
                        com.tencent.mm.bg.d.e(context, ".ui.transmit.RetransmitPreviewUI", intent);
                        com.tencent.mm.ui.base.b.gE(context);
                    }
                });
                return;
            case 2:
                g_a.a(new 8(gVar, c, context));
                return;
            case 4:
            case 16:
                g_a.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                    public final void aMV() {
                        vx c = b.c(gVar);
                        Intent intent;
                        if (c == null) {
                            x.e("MicroMsg.FavItemLogic", "goPlayView, but dataitem is null , exit");
                        } else if (c.rAo == null || (bi.oW(c.rAo.dyJ) && bi.oW(c.rAo.dyN))) {
                            intent = new Intent();
                            intent.putExtra("key_detail_info_id", gVar.field_localId);
                            intent.putExtra("key_detail_fav_path", b.b(c));
                            intent.putExtra("key_detail_fav_thumb_path", b.c(c));
                            intent.putExtra("key_detail_fav_video_duration", c.duration);
                            intent.putExtra("key_detail_statExtStr", c.bZN);
                            intent.putExtra("show_share", false);
                            b.a(context, ".ui.detail.FavoriteVideoPlayUI", intent);
                        } else {
                            x.i("MicroMsg.FavItemLogic", "it is ad sight.use sight play");
                            intent = new Intent();
                            intent.putExtra("key_detail_info_id", gVar.field_localId);
                            intent.putExtra("key_detail_data_id", c.jdM);
                            intent.putExtra("key_detail_can_delete", false);
                            b.a(context, ".ui.detail.FavoriteFileDetailUI", intent);
                        }
                    }
                });
                return;
            case 5:
                g_a.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                    public final void aMV() {
                        d.d(context, gVar, false, new wn());
                    }
                });
                return;
            case 6:
                g_a.a(new 5(gVar.field_favProto.rAL, context));
                return;
            case 8:
                g_a.a(new 3(context, gVar));
                return;
            case 14:
                g_a.a(new 7(context, gVar));
                return;
            case 18:
                g_a.a(new 1(context, gVar));
                return;
            default:
                return;
        }
    }
}
