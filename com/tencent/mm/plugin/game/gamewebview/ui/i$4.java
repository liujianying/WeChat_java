package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.R;
import com.tencent.mm.k.d.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import java.util.ArrayList;

class i$4 implements c {
    final /* synthetic */ i jKv;
    final /* synthetic */ Boolean jKw;
    final /* synthetic */ ArrayList jKx = null;

    i$4(i iVar, Boolean bool) {
        this.jKv = iVar;
        this.jKw = bool;
    }

    public final void a(l lVar) {
        h.mEJ.a(480, 0, 1, false);
        if (this.jKw.booleanValue()) {
            int size = this.jKx.size();
            for (int i = 0; i < size; i++) {
                b bVar = (b) this.jKx.get(i);
                m mVar = (m) lVar.e(bVar.id, bVar.title);
                mVar.twe = bVar;
                mVar.setIcon(null);
                mVar.setIcon(0);
            }
            return;
        }
        if (this.jKv.jKc.getPageView().gu(21) && i.a(this.jKv, 1)) {
            lVar.a(1, this.jKv.jIJ.getString(R.l.readerapp_alert_retransmit), R.k.bottomsheet_icon_transmit);
        }
        if (this.jKv.jKc.getPageView().gu(23) && i.a(this.jKv, 2)) {
            lVar.a(2, this.jKv.jIJ.getString(R.l.readerapp_alert_share_to_timeline), R.k.bottomsheet_icon_moment);
        }
        boolean z = this.jKv.getBundle().getBoolean("is_favorite_item", false);
        if (!z && i.aTs() && i.a(this.jKv, 3)) {
            lVar.a(3, this.jKv.jIJ.getString(R.l.plugin_favorite_opt), R.k.bottomsheet_icon_fav);
        }
        lVar.a(31, this.jKv.jIJ.getString(R.l.wv_search_content), R.k.bottomsheet_icon_search);
        if (this.jKv.jKc.getPageView().gu(44) && i.a(this.jKv, 6)) {
            lVar.a(6, this.jKv.jIJ.getString(R.l.wv_alert_copy_link), R.k.bottomsheet_icon_copy);
        }
        boolean z2 = this.jKv.getBundle().getBoolean("key_detail_can_delete", true);
        if (z && z2 && i.aTs()) {
            if (i.a(this.jKv, 12)) {
                lVar.a(12, this.jKv.jIJ.getString(R.l.favorite_add_tag_tips), R.k.bottomsheet_icon_addtag);
            }
            if (i.a(this.jKv, 9)) {
                lVar.a(9, this.jKv.jIJ.getString(R.l.app_delete), R.k.bottomsheet_icon_del);
            }
        }
        if (this.jKv.Us()) {
            if (i.a(this.jKv, 32)) {
                lVar.a(32, this.jKv.jIJ.getString(R.l.readerapp_cancel_keep_page_top), R.k.bottomsheet_icon_webview_cancel_top);
            }
        } else if (i.a(this.jKv, 30)) {
            lVar.a(30, this.jKv.jIJ.getString(R.l.readerapp_keep_page_top), R.k.bottomsheet_icon_webview_top);
        }
        if (this.jKv.jKc.getPageView().gu(45) && i.a(this.jKv, 7)) {
            lVar.a(7, this.jKv.jIJ.getString(R.l.wv_alert_open_in_browser), R.k.bottomsheet_icon_brower);
        }
        if (i.a(this.jKv, 28)) {
            lVar.a(28, this.jKv.jIJ.getString(R.l.webview_bottomsheet_refresh), R.k.bottomsheet_icon_refresh);
        }
        if (this.jKv.jKc.getPageView().gnu) {
            lVar.a(27, this.jKv.jIJ.getString(R.l.readerapp_finish_webview), R.k.bottomsheet_icon_exit);
        }
        String cacheAppId = this.jKv.jKc.getPageView().getCacheAppId();
        String string = this.jKv.getBundle().getString("shortcut_user_name");
        if (!(this.jKv.getBundle().getBoolean("from_shortcut", false) || bi.oW(cacheAppId) || bi.oW(string) || !this.jKv.jKc.getPageView().gu(255) || !i.a(this.jKv, 29))) {
            lVar.a(29, this.jKv.jIJ.getString(R.l.readerapp_add_shortcut), R.k.webview_add_shortcut);
        }
        lVar.a(10, this.jKv.jIJ.getString(R.l.biz_report_text), R.k.bottomsheet_icon_complain);
    }
}
