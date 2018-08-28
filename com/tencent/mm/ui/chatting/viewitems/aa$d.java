package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.o;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.viewitems.b.a;

class aa$d extends a {
    ImageView uai;
    TextView ucQ;
    LinearLayout udr;
    TextView uds;
    ProgressBar udt;
    ImageView udu;
    ProgressBar udv;
    ImageView udw;

    aa$d() {
    }

    public final a q(View view, boolean z) {
        super.dx(view);
        this.hrs = (TextView) view.findViewById(R.h.chatting_time_tv);
        this.ucQ = (TextView) view.findViewById(R.h.chatting_location_info);
        this.uds = (TextView) view.findViewById(R.h.chatting_location_title);
        this.udr = (LinearLayout) view.findViewById(R.h.chatting_location_panel);
        this.udt = (ProgressBar) view.findViewById(R.h.chatting_load_progress);
        this.hrH = view.findViewById(R.h.chatting_click_area);
        this.mQc = (TextView) view.findViewById(R.h.chatting_user_tv);
        this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
        this.gFD = view.findViewById(R.h.chatting_maskview);
        this.udu = (ImageView) view.findViewById(R.h.chatting_location_bg);
        this.udv = (ProgressBar) view.findViewById(R.h.chatting_location_address_progress);
        this.udw = (ImageView) view.findViewById(R.h.chatting_content_pin);
        if (!z) {
            this.tZv = (ImageView) view.findViewById(R.h.chatting_state_iv);
            this.uai = (ImageView) view.findViewById(R.h.chatting_status_tick);
        }
        this.uds.setTextSize(1, 16.0f);
        this.ucQ.setTextSize(1, 12.0f);
        return this;
    }

    public static void a(aa$d aa_d, bd bdVar, boolean z, int i, com.tencent.mm.ui.chatting.c.a aVar, aa$c aa_c, OnLongClickListener onLongClickListener) {
        if (aa_d != null) {
            Object obj;
            aa_d.udr.setVisibility(8);
            int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(aVar.tTq.getContext(), 236);
            int fromDPToPix2 = com.tencent.mm.bp.a.fromDPToPix(aVar.tTq.getContext(), 90);
            aa_d.uds.setMaxLines(1);
            aa_d.ucQ.setMaxLines(1);
            aa_d.ucQ.setText("");
            if (d.QS("location")) {
                x.d("MicroMsg.LocationItemHolder", "plugin found!");
                iy iyVar = new iy();
                iyVar.bSB.bSv = 1;
                iyVar.bSB.bGS = bdVar;
                com.tencent.mm.sdk.b.a.sFg.m(iyVar);
                CharSequence charSequence = iyVar.bSC.bPu;
                CharSequence charSequence2 = iyVar.bSC.bSE;
                if ((charSequence != null || b(charSequence2, aVar)) && ((charSequence == null || !charSequence.equals("") || b(charSequence2, aVar)) && (charSequence == null || !charSequence.equals("err_not_started")))) {
                    aa_d.udv.setVisibility(8);
                    aa_d.udr.setVisibility(0);
                    x.d("MicroMsg.LocationItemHolder", "location info : " + charSequence);
                    if (b(charSequence2, aVar)) {
                        aa_d.uds.setVisibility(0);
                        aa_d.uds.setText(charSequence2);
                        if (charSequence == null || charSequence.equals("")) {
                            aa_d.ucQ.setVisibility(8);
                        } else {
                            aa_d.ucQ.setVisibility(0);
                            aa_d.ucQ.setText(charSequence);
                        }
                    } else {
                        aa_d.uds.setMaxLines(2);
                        aa_d.uds.setText(charSequence);
                        aa_d.ucQ.setVisibility(8);
                    }
                } else {
                    x.d("MicroMsg.LocationItemHolder", "info error or subcore not started!");
                    aa_d.udv.setVisibility(0);
                    aa_d.udr.setVisibility(0);
                    aa_d.uds.setText("");
                    aa_d.ucQ.setText("");
                }
            } else {
                aa_d.udt.setVisibility(0);
                aa_d.udr.setVisibility(8);
            }
            ImageView imageView = aa_d.udu;
            g Pf = o.Pf();
            int i2 = R.g.location_msg;
            int i3 = R.g.map_bg_mask_normal;
            if (z) {
                obj = "location_backgroup_key_from";
            } else {
                String obj2 = "location_backgroup_key_tor";
            }
            Bitmap bitmap = (Bitmap) Pf.dUr.get(obj2);
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = c.y(i2, i3, fromDPToPix, fromDPToPix2);
                Pf.dUr.m(obj2, bitmap);
            }
            imageView.setImageBitmap(bitmap);
            hv hvVar = new hv();
            hvVar.bRi.bGS = bdVar;
            hvVar.bRi.w = fromDPToPix;
            hvVar.bRi.h = fromDPToPix2;
            hvVar.bRi.bRn = R.g.map_bg_mask_normal;
            hvVar.bRi.bRk = aa_d.udu;
            hvVar.bRi.bRm = aa_d.udt;
            hvVar.bRi.bRl = aa_d.udw;
            com.tencent.mm.sdk.b.a.sFg.m(hvVar);
            aa_d.hrH.setTag(new au(bdVar, aVar.cwr(), i, null, 0));
            aa_d.hrH.setOnClickListener(aa_c);
            aa_d.hrH.setOnLongClickListener(onLongClickListener);
            aa_d.hrH.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) aVar.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
        }
    }

    private static boolean b(String str, com.tencent.mm.ui.chatting.c.a aVar) {
        return (str == null || str.equals("") || str.equals(aVar.tTq.getMMResources().getString(R.l.location_selected))) ? false : true;
    }
}
