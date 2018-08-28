package com.tencent.mm.ui.chatting.b;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.chatting.b.b.e;
import com.tencent.mm.ui.chatting.b.b.m;

public class ai extends a implements u {
    private boolean tSA;
    private boolean tSB;
    private final long tSC = 259200000;
    private b tSD = new b() {
        public final void a(Boolean bool, Boolean bool2) {
            if (!bool.booleanValue()) {
                return;
            }
            if (bool2.booleanValue()) {
                ai.this.c(Boolean.valueOf(true), Boolean.valueOf(true));
            } else {
                ai.this.c(Boolean.valueOf(false), Boolean.valueOf(true));
            }
        }

        public final void b(Boolean bool, Boolean bool2) {
            if (!bool.booleanValue()) {
                return;
            }
            if (bool2.booleanValue()) {
                ai.this.c(Boolean.valueOf(true), Boolean.valueOf(false));
            } else {
                ai.this.c(Boolean.valueOf(false), Boolean.valueOf(false));
            }
        }
    };
    private View tSy;
    private ViewGroup tSz;

    private void j(Boolean bool) {
        LayoutParams layoutParams;
        this.tSz = (ViewGroup) this.bAG.findViewById(R.h.chatting_content);
        this.tSy = View.inflate(this.bAG.tTq.getContext(), R.i.new_user_tutorial, null);
        TextView textView = (TextView) this.tSy.findViewById(R.h.new_user_guide_tips);
        if (bool.booleanValue()) {
            textView.setText(this.bAG.tTq.getContext().getString(R.l.send_picture_video_tips));
            this.tSy.setBackgroundResource(R.g.ofm_pop_down_right_bg);
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 85);
        } else {
            textView.setText(this.bAG.tTq.getContext().getString(R.l.send_voice_tips));
            this.tSy.setBackgroundResource(R.g.ofm_pop_down_left_bg);
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 83);
        }
        if (this.tSz != null && this.tSy != null) {
            this.tSz.addView(this.tSy, layoutParams);
            this.tSy.startAnimation(AnimationUtils.loadAnimation(this.bAG.tTq.getContext(), R.a.shake_y));
            this.tSy.setOnClickListener(new 1(this, bool));
        }
    }

    private void c(Boolean bool, Boolean bool2) {
        if (this.tSy != null) {
            this.tSy.clearAnimation();
            this.tSy.setVisibility(8);
            if (bool2.booleanValue()) {
                if (bool.booleanValue()) {
                    au.HU();
                    c.DT().set(340228, Boolean.valueOf(true));
                    h.mEJ.a(232, 1, 1, false);
                }
            } else if (bool.booleanValue()) {
                au.HU();
                c.DT().set(340229, Boolean.valueOf(true));
                h.mEJ.a(232, 2, 1, false);
            }
        }
    }

    public final void cpI() {
        if (q.Hn().booleanValue()) {
            if (!this.bAG.oLT.ckW()) {
                au.HU();
                this.tSA = bi.d((Boolean) c.DT().get(340228, null));
                if (!(this.tSA || ((e) this.bAG.O(e.class)).cuI() || ((com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class)).cux())) {
                    j(Boolean.valueOf(true));
                }
                au.HU();
                this.tSB = bi.d((Boolean) c.DT().get(340229, null));
                long currentTimeMillis = System.currentTimeMillis();
                au.HU();
                long a = currentTimeMillis - bi.a((Long) c.DT().get(340240, null), 0);
                if (this.tSA && !this.tSB && a >= 259200000) {
                    j(Boolean.valueOf(false));
                }
            }
            if (((m) this.bAG.O(m.class)).cvb() != null) {
                ((m) this.bAG.O(m.class)).cvb().setTipsShowCallback(this.tSD);
            }
        }
    }

    public final void cpJ() {
        if (!this.bAG.oLT.ckW() && q.Hn().booleanValue()) {
            c(Boolean.valueOf(false), Boolean.valueOf(false));
        }
    }
}
