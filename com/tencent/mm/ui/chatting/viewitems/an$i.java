package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.su;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.viewitems.an.h;
import com.tencent.mm.ui.chatting.viewitems.b.a;

final class an$i extends a {
    TextView ucQ;
    View ufh = null;

    an$i() {
    }

    public final a dG(View view) {
        super.dx(view);
        this.hrs = (TextView) view.findViewById(R.h.chatting_time_tv);
        this.ucQ = (TextView) view.findViewById(R.h.chatting_voip_tv);
        this.hrH = view.findViewById(R.h.chatting_click_area);
        this.ufh = view.findViewById(R.h.chatting_voip_iv);
        this.tZv = (ImageView) view.findViewById(R.h.chatting_state_iv);
        this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
        this.gFD = view.findViewById(R.h.chatting_maskview);
        return this;
    }

    public static void a(an$i an_i, bd bdVar, boolean z, int i, com.tencent.mm.ui.chatting.c.a aVar, h hVar, OnLongClickListener onLongClickListener) {
        char c = 0;
        if (an_i != null) {
            if (an_i.tZv != null) {
                an_i.tZv.setVisibility(bdVar.field_status == 6 ? 8 : 0);
            }
            an_i.hrH.setTag(new au(bdVar, aVar.cwr(), i, null, 0));
            an_i.hrH.setOnClickListener(hVar);
            an_i.hrH.setOnLongClickListener(onLongClickListener);
            an_i.hrH.setOnTouchListener(((g) aVar.O(g.class)).ctw());
            CharSequence charSequence = bdVar.cqb;
            if (!bi.oW(charSequence)) {
                an_i.ucQ.setText(charSequence);
            } else if (z) {
                an_i.ucQ.setText(R.l.voip_call_cancel_msg_from);
            } else {
                an_i.ucQ.setText(R.l.voip_call_cancel_msg_to);
            }
            if (an_i.ufh != null) {
                if (!bdVar.field_content.equals(bd.tbx)) {
                    int i2;
                    String str = bdVar.field_content;
                    su suVar = new su();
                    suVar.cdE.bOh = 1;
                    suVar.cdE.content = str;
                    com.tencent.mm.sdk.b.a.sFg.m(suVar);
                    if (suVar.cdF.type == 3) {
                        i2 = 1;
                    } else {
                        char i22 = 0;
                    }
                    if (i22 == 0) {
                        if (!bdVar.field_content.equals(bd.tby)) {
                            str = bdVar.field_content;
                            suVar = new su();
                            suVar.cdE.bOh = 1;
                            suVar.cdE.content = str;
                            com.tencent.mm.sdk.b.a.sFg.m(suVar);
                            if (suVar.cdF.type == 2) {
                                c = 1;
                            }
                            if (c == 0) {
                                return;
                            }
                        }
                        if (z) {
                            an_i.ufh.setBackgroundResource(R.k.voip_videocall);
                            return;
                        } else {
                            an_i.ufh.setBackgroundResource(R.k.voip_videocall_to);
                            return;
                        }
                    }
                }
                if (z) {
                    an_i.ufh.setBackgroundResource(R.k.voip_voicecall);
                } else {
                    an_i.ufh.setBackgroundResource(R.k.voip_voicecall_to);
                }
            }
        }
    }
}
