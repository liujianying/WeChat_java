package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;

public abstract class h implements ab {
    protected MMActivity gKS;
    protected g hHC;

    public abstract boolean azJ();

    public abstract boolean azK();

    public h(g gVar, MMActivity mMActivity) {
        this.hHC = gVar;
        this.gKS = mMActivity;
    }

    public void c(ViewGroup viewGroup, b bVar) {
        if (azJ()) {
            TextView textView = (TextView) viewGroup.findViewById(d.code_text);
            String str = this.hHC.code;
            if (bVar.awg() || (!bi.oW(str) && str.length() <= 40)) {
                textView.setText(m.yd(str));
                if (bVar.awb()) {
                    textView.setVisibility(0);
                    textView.setOnLongClickListener(new 1(this, bVar));
                    this.hHC.d(c.hID);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
        if (azK()) {
            RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(d.code_jump_layout);
            if (bVar == null || bVar.awm() == null || bVar.awm().rok == null || bi.oW(bVar.awm().rok.title)) {
                relativeLayout.setVisibility(8);
                return;
            }
            viewGroup.findViewById(d.code_divider_line).setVisibility(8);
            relativeLayout.setVisibility(0);
            pr prVar = bVar.awm().rok;
            TextView textView2 = (TextView) viewGroup.findViewById(d.code_jump_title);
            textView2.setText(prVar.title);
            String str2 = bVar.awm().dxh;
            if (!bi.oW(str2)) {
                textView2.setTextColor(l.xV(str2));
            }
            textView2 = (TextView) viewGroup.findViewById(d.code_jump_second_title);
            CharSequence charSequence = prVar.huY;
            if (TextUtils.isEmpty(charSequence)) {
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
            } else if (textView2 != null) {
                textView2.setText(charSequence);
                textView2.setVisibility(0);
            }
            relativeLayout.setOnClickListener(new 2(this, bVar));
        }
    }

    public boolean i(b bVar) {
        return true;
    }

    public void g(ViewGroup viewGroup) {
    }
}
