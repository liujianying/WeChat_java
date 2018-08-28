package com.tencent.mm.plugin.appbrand.game.d.a;

import android.widget.Button;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.appbrand.game.d.a.e.2;
import com.tencent.mm.plugin.appbrand.game.d.a.e.3;
import com.tencent.mm.plugin.appbrand.game.d.a.e.4;
import com.tencent.mm.plugin.appbrand.game.d.a.e.5;
import com.tencent.mm.plugin.appbrand.game.d.a.e.6;
import com.tencent.mm.plugin.appbrand.game.d.a.e.7;
import com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.widget.input.c.b;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.tools.g;

class e$1 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ String fCs;
    final /* synthetic */ int fCt;
    final /* synthetic */ boolean fCu;
    final /* synthetic */ boolean fCv;
    final /* synthetic */ b fCw;
    final /* synthetic */ e fCx;

    e$1(e eVar, l lVar, String str, int i, boolean z, boolean z2, b bVar, int i2) {
        this.fCx = eVar;
        this.fCl = lVar;
        this.fCs = str;
        this.fCt = i;
        this.fCu = z;
        this.fCv = z2;
        this.fCw = bVar;
        this.doP = i2;
    }

    public final void run() {
        e eVar = this.fCx;
        l lVar = this.fCl;
        CharSequence charSequence = this.fCs;
        int i = this.fCt;
        boolean z = this.fCu;
        boolean z2 = this.fCv;
        b bVar = this.fCw;
        int i2 = this.doP;
        if (lVar.Sx) {
            p d = e.d(lVar);
            if (d != null) {
                float density = a.getDensity(d.mContext);
                com.tencent.mm.plugin.appbrand.game.widget.input.a bI = com.tencent.mm.plugin.appbrand.game.widget.input.a.bI(d.getContentView());
                WAGamePanelInputEditText attachedEditText = bI.getAttachedEditText();
                if (bi.oW(charSequence)) {
                    attachedEditText.setText("");
                } else {
                    if (charSequence.length() > i) {
                        charSequence = charSequence.substring(0, i);
                    }
                    attachedEditText.setText(charSequence);
                    attachedEditText.setSelection(attachedEditText.getText().length());
                }
                attachedEditText.setSingleLine(!z);
                attachedEditText.setMaxLength(i);
                c Gi = n.a(attachedEditText).Gi(i);
                Gi.uCR = false;
                Gi.gHz = g.a.uzY;
                Gi.a(new 2(eVar, attachedEditText, lVar));
                attachedEditText.addTextChangedListener(new 3(eVar, lVar));
                attachedEditText.setComposingDismissedListener(new 4(eVar, attachedEditText, lVar));
                bI.setOnConfirmClickListener(new 5(eVar, attachedEditText, lVar, z2, bI));
                bI.setOnVisibilityChangedListener(new 6(eVar, attachedEditText, lVar, bI, density, i2));
                if (!z) {
                    attachedEditText.setOnEditorActionListener(new 7(eVar, z2, attachedEditText, lVar));
                }
                b bVar2 = bVar == null ? b.gLl : bVar;
                bI.getAttachedEditText().setImeOptions(bVar2.gLq);
                bI.getAttachedEditText().setFocusable(true);
                bI.getAttachedEditText().setFocusableInTouchMode(true);
                bI.show();
                switch (com.tencent.mm.plugin.appbrand.game.widget.input.a.2.fDv[bVar2.ordinal()]) {
                    case 1:
                        ((Button) bI.fDr.getConfirmButton()).setText(j.appbrand_game_input_confirm);
                        return;
                    case 2:
                        ((Button) bI.fDr.getConfirmButton()).setText(j.appbrand_game_input_confirm_search);
                        return;
                    case 3:
                        ((Button) bI.fDr.getConfirmButton()).setText(j.appbrand_game_input_confirm_next);
                        return;
                    case 4:
                        ((Button) bI.fDr.getConfirmButton()).setText(j.appbrand_game_input_confirm_go);
                        return;
                    case 5:
                        ((Button) bI.fDr.getConfirmButton()).setText(j.appbrand_game_input_confirm_send);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
