package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.chatting.viewitems.b.a;

public final class o {

    static class d extends a {
        public static final int ubA = com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), aq.CTRL_BYTE);
        public static final int ubB = com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 192);
        static c ubC;
        protected ImageView tZO;
        protected ImageView tZR;
        protected ImageView tZS;
        protected TextView tZU;
        protected ChattingItemFooter tZV;
        protected ImageView tZW;
        protected LinearLayout tZX;
        protected ViewGroup tZY;
        protected TextView tZZ;
        protected LinearLayout uaa;
        ImageView uai;
        protected TextView uam;
        protected ImageView uan;
        protected TextView uao;
        protected TextView uap;
        protected LinearLayout uaq;
        protected ImageView uar;
        protected ImageView uas;
        protected TextView uat;
        protected TextView ubK;
        protected TextView ubL;

        d() {
        }

        static {
            c.a aVar = new c.a();
            aVar.dXN = R.k.app_brand_app_default_icon_for_tail;
            aVar.bg(com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 20), com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 20)).dXw = true;
            ubC = aVar.Pt();
        }

        public final d t(View view, boolean z) {
            super.dx(view);
            this.tZO = (ImageView) view.findViewById(R.h.chatting_appmsg_sub_menu_icon);
            this.tZR = (ImageView) this.jEz.findViewById(R.h.chatting_continue_btn);
            this.tZS = (ImageView) this.jEz.findViewById(R.h.chatting_stop_btn);
            this.tZU = (TextView) view.findViewById(R.h.chatting_appmsg_comment_tv);
            this.tZW = (ImageView) view.findViewById(R.h.chatting_appmsg_refuse_iv);
            this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
            this.gFD = view.findViewById(R.h.chatting_maskview);
            this.mQc = (TextView) view.findViewById(R.h.chatting_user_tv);
            this.tZV = (ChattingItemFooter) view.findViewById(R.h.footer);
            this.tZX = (LinearLayout) view.findViewById(R.h.app_msg_layout);
            this.tZY = (ViewGroup) view.findViewById(R.h.location_share_layout);
            this.tZZ = (TextView) view.findViewById(R.h.location_share_content);
            this.uaa = (LinearLayout) view.findViewById(R.h.chatting_area);
            this.hrH = view.findViewById(R.h.chatting_click_area);
            if (!z) {
                this.uai = (ImageView) this.jEz.findViewById(R.h.chatting_status_tick);
                this.mgA = (ProgressBar) this.jEz.findViewById(R.h.uploading_pb);
            }
            this.uaq = (LinearLayout) view.findViewById(R.h.chatting_appmsg_appbrand_content);
            this.uar = (ImageView) view.findViewById(R.h.chatting_appmsg_appbrand_cover_iv);
            this.uas = (ImageView) view.findViewById(R.h.error_icon_iv);
            this.uat = (TextView) view.findViewById(R.h.chatting_appmsg_appbrand_nickname_tv);
            this.uam = (TextView) view.findViewById(R.h.chatting_appmsg_appbrand_desc_tv);
            this.ubK = (TextView) view.findViewById(R.h.chatting_appmsg_appbrand_update_tv);
            this.uan = (ImageView) view.findViewById(R.h.chatting_appmsg_appbrand_source_iv);
            this.uao = (TextView) view.findViewById(R.h.chatting_appmsg_appbrand_source_tv);
            this.uap = (TextView) view.findViewById(R.h.chatting_appmsg_appbrand_source_tag_tv);
            this.ubL = (TextView) view.findViewById(R.h.chatting_appmsg_appbrand_subscribe_tv);
            return this;
        }
    }

    static class e {
        static String bq(Object obj) {
            return "WxaUpdatableMsg#" + k.bq(obj);
        }
    }
}
