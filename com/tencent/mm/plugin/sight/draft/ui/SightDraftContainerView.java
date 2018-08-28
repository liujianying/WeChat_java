package com.tencent.mm.plugin.sight.draft.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.modelvideo.j;
import com.tencent.mm.plugin.sight.draft.ui.b.d;

public class SightDraftContainerView extends ListView {
    private boolean neP;
    private a neQ;
    b neR;

    public SightDraftContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public SightDraftContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SightDraftContainerView(Context context) {
        super(context);
        init();
    }

    private void init() {
        setBackgroundColor(getResources().getColor(R.e.black));
        setSelector(R.e.transparent);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.SmallPadding);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.LargePadding);
        View textView = new TextView(getContext());
        textView.setText(R.l.sight_draft_tips);
        textView.setTextSize(0, (float) a.ad(getContext(), R.f.HintTextSize));
        textView.setGravity(17);
        textView.setTextColor(getResources().getColor(R.e.hint_text_color_dark_bg));
        textView.setTextSize(1, 11.0f);
        textView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize2);
        addFooterView(textView);
        setOnTouchListener(new 1(this));
    }

    public void setTipsResId(int i) {
        if (this.neR != null) {
            this.neR.neA = i;
        }
    }

    public final void bwf() {
        if (this.neP) {
            this.neR.neB = 12;
            this.neR.a(d.neH, false);
            this.neR.a(null, null);
            setSelection(0);
            return;
        }
        this.neP = true;
        this.neR = new b(getContext(), this.neQ);
        this.neR.neB = 12;
        setAdapter(this.neR);
    }

    public void setSightDraftCallback(a aVar) {
        this.neQ = aVar;
        if (this.neR != null) {
            this.neR.nez = aVar;
        }
    }

    public j getLastDrafInfo() {
        b bVar = this.neR;
        return bVar.neF == null ? null : bVar.neF.neN;
    }
}
