package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends a {
    private WXRTEditText qvK;

    public k(View view, com.tencent.mm.plugin.wenote.model.nativenote.manager.k kVar) {
        super(view, kVar);
        this.qvK = (WXRTEditText) view.findViewById(R.h.rte_text);
        if (!(kVar.qrC == 2 && this.qtF.qrD)) {
            this.qvK.setKeyListener(null);
            this.qvK.setFocusable(false);
            this.qvK.setClickable(true);
        }
        this.qvK.qqL = this;
        this.qvK.setEditTextType(0);
        this.qtF.o(this.qvK);
        this.qvK.getViewTreeObserver().addOnGlobalLayoutListener(new 1(this));
    }

    public final void a(b bVar, int i, int i2) {
        LayoutParams layoutParams;
        this.qvK.setPosInDataList(i);
        h hVar = (h) bVar;
        hVar.qoM = this.qvK;
        hVar.qoK = null;
        hVar.qoL = null;
        b Bv = c.bZD().Bv(i - 1);
        if (Bv != null && Bv.getType() == 1) {
            layoutParams = (LayoutParams) this.qvK.getLayoutParams();
            layoutParams.topMargin = 0;
            this.qvK.setLayoutParams(layoutParams);
        }
        Bv = c.bZD().Bv(i + 1);
        if (Bv != null && Bv.getType() == 1) {
            layoutParams = (LayoutParams) this.qvK.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.qvK.setLayoutParams(layoutParams);
        }
        if (this.qtF.qrC == 2 && this.qtF.qrD) {
            ah.A(new 2(this, hVar));
        } else {
            this.qvK.setRichTextEditing(hVar.content);
            j.g(this.qvK);
        }
        x.i("MicroMsg.Note.NoteTextItemHolder", "TextItemHolder position is " + gl());
    }

    public final int caZ() {
        return 1;
    }
}
