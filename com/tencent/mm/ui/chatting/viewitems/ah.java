package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.widget.MMNeatTextView;
import com.tencent.mm.ui.widget.MMNeatTextView.b;
import com.tencent.mm.ui.widget.MMTextView;
import java.util.HashMap;
import java.util.Map;

public final class ah {

    private static final class c implements b {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final void a(Exception exception, String str, String str2) {
            if (!com.tencent.mm.protocal.d.qVO) {
                Map hashMap = new HashMap(2);
                hashMap.put("Content", str);
                hashMap.put("Exception", exception.toString());
                hashMap.put("Stack", exception.getStackTrace());
                h.mEJ.c("NeatTextView", str2, hashMap);
            }
        }
    }

    private static class d extends com.tencent.mm.ui.chatting.t.d {
        public d(a aVar) {
            super(aVar);
        }

        public final void a(View view, a aVar, bd bdVar) {
            au auVar = (au) view.getTag();
            if (bdVar.cmd()) {
                if (this.tKy != null) {
                    h.mEJ.k(10221, "1");
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.bg.d.b(this.tKy.tTq.getContext(), "shake", ".ui.ShakeReportUI", intent);
                }
            } else if (bdVar.isText() && (view instanceof MMTextView)) {
                MMTextView mMTextView = (MMTextView) view;
                com.tencent.mm.ui.chatting.h.a.a.cxI();
                com.tencent.mm.ui.chatting.h.a.a.a(mMTextView.getText(), auVar.bXQ);
            }
        }
    }

    static final class e extends b.a {
        View ern;
        ImageView uai;
        MMNeatTextView ueb;
        ImageView ued;
        TextView uee;
        ViewStub uef;
        ChattingItemTranslate ueg;

        e() {
        }

        public final b.a q(View view, boolean z) {
            super.dx(view);
            this.hrs = (TextView) view.findViewById(R.h.chatting_time_tv);
            this.mQc = (TextView) view.findViewById(R.h.chatting_user_tv);
            this.ueb = (MMNeatTextView) view.findViewById(R.h.chatting_content_itv);
            this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
            this.gFD = view.findViewById(R.h.chatting_maskview);
            this.ern = view.findViewById(R.h.chatting_content_area);
            this.uef = (ViewStub) view.findViewById(R.h.translate_item_vs);
            if (z) {
                this.ued = (ImageView) view.findViewById(R.h.chatting_bad_msg_icon);
                this.uee = (TextView) view.findViewById(R.h.chatting_view_full_text);
            } else {
                this.uai = (ImageView) view.findViewById(R.h.chatting_status_tick);
                this.tZv = (ImageView) view.findViewById(R.h.chatting_state_iv);
                this.mgA = (ProgressBar) view.findViewById(R.h.uploading_pb);
            }
            this.ueb.setOnTouchListener(new f(this.ueb, new m(this.ueb.getContext())));
            this.ueb.setIsOpen(cxQ());
            this.ueb.setTextCrashListener(new c());
            return this;
        }

        private static boolean cxQ() {
            try {
                x.i("NeatTextView", "[isOpenNeatTextView] value:%s isNeatTextViewOpen:%s local:%s", new Object[]{g.AT().getValue("CellTextViewEnable"), Integer.valueOf(bi.getInt(g.AT().getValue("CellTextViewEnable"), 1)), Boolean.valueOf(com.tencent.mm.kernel.g.Ei().DT().getBoolean(aa.a.sZp, true))});
                if (1 == bi.getInt(g.AT().getValue("CellTextViewEnable"), 1) && r4) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
    }
}
