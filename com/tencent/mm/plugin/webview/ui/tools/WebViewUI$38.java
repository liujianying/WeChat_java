package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.k.d.a;
import com.tencent.mm.k.d.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import com.tencent.wework.api.WWAPIFactory;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class WebViewUI$38 implements c {
    final /* synthetic */ Boolean jKw;
    final /* synthetic */ ArrayList jKx;
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$38(WebViewUI webViewUI, Boolean bool, ArrayList arrayList) {
        this.pZJ = webViewUI;
        this.jKw = bool;
        this.jKx = arrayList;
    }

    public final void a(l lVar) {
        h.mEJ.a(480, 0, 1, false);
        int i;
        m mVar;
        if (this.jKw.booleanValue()) {
            int size = this.jKx.size();
            for (i = 0; i < size; i++) {
                b bVar = (b) this.jKx.get(i);
                mVar = (m) lVar.e(bVar.id, bVar.title);
                mVar.twe = bVar;
                mVar.setIcon(null);
                mVar.setIcon(0);
            }
            return;
        }
        try {
            LinkedList ae = WebViewUI.ae(this.pZJ);
            if (ae != null) {
                i = 0;
                while (i < ae.size() && i < 8) {
                    a aVar = (a) ae.get(i);
                    mVar = null;
                    if ("index".equals(bi.oV(aVar.id))) {
                        mVar = (m) lVar.a(15, this.pZJ.getString(R.l.webview_jd_menu_title_index), R.k.bottomsheet_icon_jd_index);
                    } else if ("categories".equals(bi.oV(aVar.id))) {
                        mVar = (m) lVar.a(16, this.pZJ.getString(R.l.webview_jd_menu_title_categories), R.k.bottomsheet_icon_jd_collect_list);
                    } else if ("cart".equals(bi.oV(aVar.id))) {
                        mVar = (m) lVar.a(17, this.pZJ.getString(R.l.webview_jd_menu_title_cart), R.k.bottomsheet_icon_jd_cart);
                    } else if ("profile".equals(bi.oV(aVar.id))) {
                        mVar = (m) lVar.a(18, this.pZJ.getString(R.l.webview_jd_menu_title_profile), R.k.bottomsheet_icon_profile);
                    } else if ("member".equals(bi.oV(aVar.id))) {
                        mVar = (m) lVar.a(19, this.pZJ.getString(R.l.webview_jd_menu_title_member), R.k.bottomsheet_icon_jd_member);
                    }
                    if (mVar != null) {
                        mVar.fIb = aVar.url;
                    }
                    i++;
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "exception in add jd menu, " + e.getMessage());
        }
        if (this.pZJ.gcP == null || this.pZJ.gcP.bVR() == null) {
            x.e("MicroMsg.WebViewUI", "get permission failed");
            return;
        }
        boolean hf;
        String str;
        JsapiPermissionWrapper bVR = this.pZJ.gcP.bVR();
        if (WebViewUI.af(this.pZJ)) {
            if (this.pZJ.AM(35) && !this.pZJ.pZs.bWS()) {
                lVar.a(35, this.pZJ.getString(R.l.readerapp_minimize), R.k.bottomsheet_icon_webview_minimize);
            } else if (this.pZJ.AM(36) && this.pZJ.pZs.bWS()) {
                lVar.a(36, this.pZJ.getString(R.l.readerapp_cancel_minimize), R.k.bottomsheet_icon_webview_cancel_minimize);
            }
        }
        if (WebViewUI.a(bVR, 21) && this.pZJ.AM(1)) {
            lVar.a(1, this.pZJ.getString(R.l.readerapp_alert_retransmit), R.k.bottomsheet_icon_transmit, WebViewUI.b(bVR, 21));
        }
        if (WebViewUI.a(bVR, 23) && this.pZJ.AM(2)) {
            lVar.a(2, this.pZJ.getString(R.l.readerapp_alert_share_to_timeline), R.k.bottomsheet_icon_moment, WebViewUI.b(bVR, 23));
        }
        if (!(WebViewUI.ag(this.pZJ) && (bi.oW(WebViewUI.ah(this.pZJ)) || bi.oW(WebViewUI.ai(this.pZJ)) || WebViewUI.ah(this.pZJ).startsWith(WebViewUI.ai(this.pZJ)))) && WebViewUI.a(bVR, 323) && WebViewUI.aj(this.pZJ) && this.pZJ.AM(3)) {
            lVar.a(3, this.pZJ.getString(R.l.plugin_favorite_opt), R.k.bottomsheet_icon_fav, WebViewUI.b(bVR, 323));
        }
        try {
            if (this.pZJ.gcO.s(this.pZJ.getIntent().getLongExtra("msg_id", Long.MIN_VALUE), this.pZJ.getIntent().getStringExtra("sns_local_id"))) {
                lVar.a(23, this.pZJ.getString(R.l.download_other_open), R.k.bottomsheet_icon_other_mode);
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.WebViewUI", e2, "", new Object[0]);
        }
        lVar.a(31, this.pZJ.getString(R.l.wv_search_content), R.k.bottomsheet_icon_search);
        if (WebViewUI.a(bVR, 44) && this.pZJ.AM(6)) {
            lVar.a(6, this.pZJ.getString(R.l.wv_alert_copy_link), R.k.bottomsheet_icon_copy, WebViewUI.b(bVR, 44));
        }
        if (bVR.qWe != null && WebViewUI.ag(this.pZJ) && !bi.oW(WebViewUI.ah(this.pZJ)) && !bi.oW(WebViewUI.ai(this.pZJ)) && WebViewUI.ah(this.pZJ).startsWith(WebViewUI.ai(this.pZJ)) && this.pZJ.getIntent().getBooleanExtra("key_detail_can_delete", true) && WebViewUI.aj(this.pZJ)) {
            if (this.pZJ.AM(12)) {
                lVar.a(12, this.pZJ.getString(R.l.favorite_add_tag_tips), R.k.bottomsheet_icon_addtag);
            }
            if (this.pZJ.AM(9)) {
                lVar.a(9, this.pZJ.getString(R.l.app_delete), R.k.bottomsheet_icon_del);
            }
        }
        String stringExtra = this.pZJ.getIntent().getStringExtra("srcUsername");
        if (!bi.oW(stringExtra)) {
            try {
                hf = this.pZJ.gcO.hf(stringExtra);
            } catch (Exception e3) {
                x.e("MicroMsg.WebViewUI", "sharebtn click fail isBizContact, ex = " + e3.getMessage());
                hf = false;
            }
            if (hf) {
                boolean he;
                boolean a;
                try {
                    he = this.pZJ.gcO.he(stringExtra);
                } catch (Exception e32) {
                    x.e("MicroMsg.WebViewUI", "sharebtn click fail, ex = " + e32.getMessage());
                    he = false;
                }
                if (he) {
                    a = WebViewUI.a(bVR, 19);
                    hf = WebViewUI.b(bVR, 19);
                } else {
                    a = WebViewUI.a(bVR, 20);
                    hf = WebViewUI.b(bVR, 20);
                }
                boolean bWn = this.pZJ.bWn();
                if ((a && this.pZJ.AM(5)) || bWn) {
                    int i2 = he ? R.l.wv_alert_show_biz_info : R.l.wv_alert_follow_biz;
                    if (bWn) {
                        i2 = R.l.wv_alert_show_subbiz_info;
                    }
                    lVar.a(5, this.pZJ.getString(i2), R.k.bottomsheet_icon_brand_profile, hf);
                }
            } else {
                try {
                    this.pZJ.gcO.QU(stringExtra);
                } catch (Exception e322) {
                    x.e("MicroMsg.WebViewUI", "sharebtn click fail triggerGetContact, ex = " + e322.getMessage());
                }
            }
        }
        if (WebViewUI.a(bVR, TbsListener$ErrorCode.ERROR_CANLOADVIDEO_RETURN_FALSE) && this.pZJ.AM(34)) {
            lVar.a(34, this.pZJ.getString(R.l.wv_read_article), R.k.bottomsheet_icon_reading, WebViewUI.b(bVR, TbsListener$ErrorCode.ERROR_CANLOADVIDEO_RETURN_FALSE));
        }
        if (WebViewUI.a(bVR, 45) && this.pZJ.AM(7)) {
            lVar.a(7, this.pZJ.getString(R.l.wv_alert_open_in_browser), R.k.bottomsheet_icon_brower, WebViewUI.b(bVR, 45));
        }
        if (WebViewUI.a(bVR, 43) && this.pZJ.AM(24) && !p.r(this.pZJ.mController.tml, "com.tencent.wework")) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("enterprise_action", "enterprise_has_connector");
                bundle = this.pZJ.gcO.g(71, bundle);
                if (bundle != null) {
                    hf = bundle.getBoolean("enterprise_has_connector");
                    if (hf) {
                        lVar.a(24, this.pZJ.getString(R.l.readerapp_send_to_enterprise), R.k.bottomsheet_icon_enterprise, WebViewUI.b(bVR, 43));
                    }
                }
            } catch (Exception e3222) {
                x.w("MicroMsg.WebViewUI", "builder add, ex = " + e3222.getMessage());
            }
            hf = false;
            if (hf) {
                lVar.a(24, this.pZJ.getString(R.l.readerapp_send_to_enterprise), R.k.bottomsheet_icon_enterprise, WebViewUI.b(bVR, 43));
            }
        }
        if (WebViewUI.a(bVR, 18) && this.pZJ.AM(11)) {
            lVar.a(11, this.pZJ.getString(R.l.readerapp_alert_font), R.k.bottomsheet_icon_font, WebViewUI.b(bVR, 18));
        }
        if (this.pZJ.AM(28)) {
            lVar.a(28, this.pZJ.getString(R.l.webview_bottomsheet_refresh), R.k.bottomsheet_icon_refresh);
        }
        if (WebViewUI.a(bVR, 73) && this.pZJ.AM(14) && !WebViewUI.S(this.pZJ)) {
            lVar.a(14, this.pZJ.getString(R.l.wv_reading_mode), R.k.bottomsheet_icon_reader, WebViewUI.b(bVR, 73));
        }
        if (WebViewUI.S(this.pZJ) && this.pZJ.AM(14)) {
            lVar.a(14, this.pZJ.getString(R.l.wv_original_mode), R.k.bottomsheet_icon_other_mode);
        }
        if (WebViewUI.a(bVR, 47) && this.pZJ.AM(10)) {
            lVar.a(10, this.pZJ.getString(R.l.biz_report_text), R.k.bottomsheet_icon_complain, WebViewUI.b(bVR, 47));
        }
        if (WebViewUI.a(bVR, 36) && this.pZJ.AM(8)) {
            str = null;
            try {
                str = this.pZJ.gcO.bVq();
            } catch (Exception e4) {
            }
            if (bi.oW(str)) {
                x.i("MicroMsg.WebViewUI", "get mail session key is null or nil, should not show send mail menu");
            } else {
                lVar.a(8, this.pZJ.getString(R.l.wv_alert_send_mail), R.k.bottomsheet_icon_mail, WebViewUI.b(bVR, 36));
            }
        }
        if (WebViewUI.a(bVR, 31) && this.pZJ.AM(30)) {
            try {
                if (this.pZJ.gcO.g(78, null).getBoolean("isOpenForFaceBook", false)) {
                    lVar.a(33, this.pZJ.getString(R.l.wv_share_to_facebook), R.k.default_facebookapp, WebViewUI.b(bVR, 31));
                }
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.WebViewUI", e22, "", new Object[0]);
            }
        }
        if (WebViewUI.a(bVR, TbsListener$ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02) && WWAPIFactory.ii(this.pZJ).cIf() && this.pZJ.AM(25)) {
            str = WWAPIFactory.ii(this.pZJ).cIg();
            lVar.a(25, this.pZJ.getString(R.l.readerapp_send_to_wework, new Object[]{str}), R.k.bottomsheet_icon_wework, WebViewUI.b(bVR, TbsListener$ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02));
        }
        if (WebViewUI.a(bVR, 278) && com.tencent.mm.plugin.webview.stub.a.aW(this.pZJ, this.pZJ.mhH.getUrl()) && this.pZJ.AM(26)) {
            lVar.a(26, this.pZJ.getString(R.l.wv_send_to_we_read), R.k.bottomsheet_icon_weread, WebViewUI.b(bVR, 278));
        }
        if (WebViewUI.a(bVR, 91) && com.tencent.mm.plugin.webview.stub.a.ey(this.pZJ) && this.pZJ.AM(20)) {
            lVar.a(20, this.pZJ.getString(R.l.wv_share_to_qq), R.k.bottomsheet_icon_qq, WebViewUI.b(bVR, 91));
        }
        if (WebViewUI.a(bVR, 133) && com.tencent.mm.plugin.webview.stub.a.ey(this.pZJ) && this.pZJ.AM(22)) {
            lVar.a(22, this.pZJ.getString(R.l.wv_share_to_qzone), R.k.bottomsheet_icon_qzone, WebViewUI.b(bVR, 133));
        }
        try {
            if (WebViewUI.a(bVR, 43) && this.pZJ.AM(0) && this.pZJ.gcO.MN()) {
                List<String> MM = this.pZJ.gcO.MM();
                for (String str2 : MM) {
                    lVar.add(str2);
                }
                WebViewUI.a(this.pZJ, MM);
            }
        } catch (Exception e32222) {
            x.w("MicroMsg.WebViewUI", "builder add, ex = " + e32222.getMessage());
        }
        if (this.pZJ.pXI != null && this.pZJ.pXI.getVisibility() == 0) {
            lVar.a(27, this.pZJ.getString(R.l.readerapp_finish_webview), R.k.bottomsheet_icon_exit);
        }
        str2 = this.pZJ.Rp(WebViewUI.ah(this.pZJ));
        stringExtra = this.pZJ.getIntent().getStringExtra("shortcut_user_name");
        if (!WebViewUI.u(this.pZJ) && !bi.oW(str2) && !bi.oW(stringExtra) && WebViewUI.a(bVR, 255) && this.pZJ.AM(29)) {
            lVar.a(29, this.pZJ.getString(R.l.readerapp_add_shortcut), R.k.webview_add_shortcut, WebViewUI.b(bVR, 255));
        }
    }
}
