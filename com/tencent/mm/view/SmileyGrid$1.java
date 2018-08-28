package com.tencent.mm.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.br.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.view.a.d;

class SmileyGrid$1 implements OnItemClickListener {
    final /* synthetic */ SmileyGrid uSI;

    SmileyGrid$1(SmileyGrid smileyGrid) {
        this.uSI = smileyGrid;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (SmileyGrid.a(this.uSI)) {
            case 20:
                if (adapterView.getAdapter() instanceof d) {
                    int i2;
                    d dVar = (d) adapterView.getAdapter();
                    if (dVar.uTO == 0) {
                        if (i == (dVar.uTJ * dVar.jZk) - 5) {
                            i2 = 1;
                            if (i2 != 0) {
                                if (SmileyGrid.d(this.uSI) != null) {
                                    SmileyGrid.d(this.uSI).apK();
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    i2 = 0;
                    if (i2 != 0) {
                        if (SmileyGrid.d(this.uSI) != null) {
                            SmileyGrid.d(this.uSI).apK();
                            return;
                        }
                        return;
                    }
                }
                if (i == this.uSI.Do.getCount() - 1) {
                    if (SmileyGrid.d(this.uSI) != null) {
                        SmileyGrid.d(this.uSI).apK();
                        return;
                    }
                    return;
                } else if ((this.uSI.gKM * (this.uSI.uSD - 1)) + i < SmileyGrid.e(this.uSI)) {
                    int i3 = (this.uSI.gKM * (this.uSI.uSD - 1)) + i;
                    ((c) g.n(c.class)).getProvider().bg(e.cjH().mi(i3), i3);
                    if (SmileyGrid.d(this.uSI) != null) {
                        String mh;
                        if (SmileyGrid.f(this.uSI)) {
                            mh = e.cjH().mh(i3);
                        } else {
                            mh = e.cjH().getText(i3);
                        }
                        SmileyGrid.d(this.uSI).append(mh);
                        h.mEJ.h(13470, new Object[]{mh.replaceAll(",", " "), Integer.valueOf(SmileyGrid.b(this.uSI)), Integer.valueOf(0)});
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case 23:
            case 25:
                if (SmileyGrid.a(this.uSI) == 25 && i == 0 && this.uSI.gKM == 0 && SmileyGrid.b(this.uSI) != ChatFooterPanel.qFf) {
                    SmileyGrid.c(this.uSI);
                    return;
                }
                SmileyGrid.a(this.uSI, (EmojiInfo) this.uSI.Do.getItem(i));
                return;
            default:
                return;
        }
    }
}
