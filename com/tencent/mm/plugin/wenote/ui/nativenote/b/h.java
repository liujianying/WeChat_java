package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.x;

public abstract class h extends a {
    public static float qvC = Resources.getSystem().getDisplayMetrics().density;
    public static int qvD = Resources.getSystem().getDisplayMetrics().widthPixels;
    public static int qvE = ((int) ((40.0f * qvC) + 0.5f));
    public ImageView bOA;
    public LinearLayout eRj;
    public OnClickListener jXR = new OnClickListener() {
        public final void onClick(View view) {
            if (h.this.qtF.cai() != null) {
                x.e("Micromsg.NoteOtherItemHolder", "click item , now is editing, quit it");
                return;
            }
            if (h.this.qtF.qrC == 2) {
                h.this.qtF.qrp.caU().bZy();
                h.this.qtF.cal();
            }
            int gm = ((t) view.getTag()).gm();
            kp kpVar = new kp();
            if (c.bZD().Bv(gm) == null) {
                x.e("Micromsg.NoteOtherItemHolder", "click not response, null == NoteDataManager.getMgr().get(position),position is %d,datalist size = %d", new Object[]{Integer.valueOf(gm), Integer.valueOf(c.bZD().size())});
            } else if (com.tencent.mm.plugin.wenote.model.c.bZb().qnC == null) {
                x.e("Micromsg.NoteOtherItemHolder", "getWnNoteBase is null");
            } else {
                x.i("Micromsg.NoteOtherItemHolder", "click item, type is %d", new Object[]{Integer.valueOf(c.bZD().Bv(gm).getType())});
                kpVar.bUP.bUR = ((n) c.bZD().Bv(gm)).qpc;
                kpVar.bUP.context = view.getContext();
                kpVar.bUP.type = 1;
                com.tencent.mm.plugin.wenote.model.c.bZb().qnC.b(kpVar);
            }
        }
    };
    public LinearLayout qvA;
    public LinearLayout qvB;
    public WXRTEditText qvo;
    public WXRTEditText qvp;
    public LinearLayout qvq;
    public TextView qvr;
    public TextView qvs;
    public ImageView qvt;
    public View qvu;
    public LinearLayout qvv;
    public LinearLayout qvw;
    public LinearLayout qvx;
    public LinearLayout qvy;
    public LinearLayout qvz;

    public h(View view, k kVar) {
        super(view, kVar);
        this.bOA = (ImageView) view.findViewById(R.h.edit_imageView);
        this.qvu = view.findViewById(R.h.video_click_area);
        this.qvq = (LinearLayout) view.findViewById(R.h.note_card_ll);
        this.eRj = (LinearLayout) view.findViewById(R.h.note_voice_ll);
        this.qvr = (TextView) view.findViewById(R.h.note_card_title);
        this.qvs = (TextView) view.findViewById(R.h.note_card_detail);
        this.qvt = (ImageView) view.findViewById(R.h.note_card_icon);
        this.qvr.setTextSize(16.0f);
        this.qvs.setTextSize(12.0f);
        this.qvv = (LinearLayout) view.findViewById(R.h.note_split_ll);
        this.qvv.setVisibility(8);
        this.qvx = (LinearLayout) view.findViewById(R.h.note_reminder_ll);
        this.qvx.setVisibility(8);
        this.qvy = (LinearLayout) view.findViewById(R.h.note_bottom_logo_ll);
        this.qvy.setVisibility(8);
        this.qvz = (LinearLayout) view.findViewById(R.h.other_cover_view);
        this.qvz.setBackgroundColor(1347529272);
        this.qvz.setVisibility(8);
        this.qvz.setOnClickListener(new 1(this));
        this.qvA = (LinearLayout) view.findViewById(R.h.other_up_cover_view);
        this.qvA.setBackgroundColor(1347529272);
        this.qvA.setVisibility(4);
        this.qvB = (LinearLayout) view.findViewById(R.h.other_down_cover_view);
        this.qvB.setBackgroundColor(1347529272);
        this.qvB.setVisibility(4);
        this.qvw = (LinearLayout) view.findViewById(R.h.edit_view_ll);
        LayoutParams layoutParams = (LayoutParams) this.qvw.getLayoutParams();
        layoutParams.width = qvD - qvE;
        layoutParams.height = -2;
        this.qvw.setLayoutParams(layoutParams);
        this.qvp = (WXRTEditText) view.findViewById(R.h.btnNext);
        this.qvo = (WXRTEditText) view.findViewById(R.h.btnPrev);
        ((LinearLayout) view.findViewById(R.h.btnNextLL)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                h.this.qvp.bZZ();
                h.this.qvp.requestFocus();
            }
        });
        ((LinearLayout) view.findViewById(R.h.btnPrevLL)).setOnClickListener(new 3(this));
        this.qvp.setEditTextType(2);
        this.qvo.setEditTextType(1);
        this.qvo.qqL = this;
        this.qvp.qqL = this;
        if (!(kVar.qrC == 2 && this.qtF.qrD)) {
            this.qvp.setKeyListener(null);
            this.qvp.setEnabled(false);
            this.qvp.setFocusable(false);
            this.qvo.setKeyListener(null);
            this.qvo.setEnabled(false);
            this.qvo.setFocusable(false);
        }
        this.qtF.o(this.qvo);
        this.qtF.o(this.qvp);
    }

    public void a(b bVar, int i, int i2) {
        x.i("Micromsg.NoteOtherItemHolder", "ImageItemHolder position is " + gl());
        this.qvo.setPosInDataList(i);
        this.qvp.setPosInDataList(i);
        if (e.isEnabled()) {
            e.cap().a(this.qvz, this.qvA, this.qvB, i);
        }
        bVar.qoK = this.qvo;
        bVar.qoL = this.qvp;
        bVar.qoM = null;
        if (!bVar.qoH) {
            if (this.qvo.hasFocus()) {
                this.qvo.clearFocus();
            }
            if (this.qvp.hasFocus()) {
                this.qvp.clearFocus();
            }
        } else if (bVar.qoN) {
            this.qvo.requestFocus();
        } else {
            this.qvp.requestFocus();
        }
        if (this.qvq.getVisibility() != 0) {
            return;
        }
        if (bVar.qoO) {
            this.qvq.setBackgroundResource(R.g.wenote_basecard_pressed_bg);
        } else {
            this.qvq.setBackgroundResource(R.g.wenote_basecard_bg);
        }
    }
}
