package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.d;
import java.util.Iterator;
import java.util.LinkedList;

public class FavTagPanel extends MMTagPanel {
    LinkedList<d> jfF = new LinkedList();
    private a jfG = null;
    private OnClickListener jfH = new OnClickListener() {
        public final void onClick(View view) {
            if (((Integer) view.getTag()).intValue() == 0) {
                FavTagPanel.this.a((TextView) view, true, false);
                if (FavTagPanel.this.jfG != null) {
                    view.post(new 1(this, view));
                    return;
                }
                return;
            }
            FavTagPanel.this.a((TextView) view, false, false);
            if (FavTagPanel.this.jfG != null) {
                view.post(new 2(this, view));
            }
        }
    };

    public interface a extends com.tencent.mm.ui.base.MMTagPanel.a {
        void BH(String str);

        void BI(String str);
    }

    public FavTagPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FavTagPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCallBack(a aVar) {
        this.jfG = aVar;
        super.setCallBack(aVar);
    }

    protected final void aMU() {
        if (getTagCount() <= 0 && !this.jfF.isEmpty()) {
            String str = ((d) this.jfF.getLast()).tyd;
            BJ(str);
            if (this.jfG != null) {
                this.jfG.BH(str);
            }
            crR();
        }
    }

    public void setType(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.FavTagPanel", "want to add type, but it is null or empty");
            return;
        }
        String trim = str.trim();
        Iterator it = this.jfF.iterator();
        while (it.hasNext()) {
            if (trim.equals(((d) it.next()).tyd)) {
                x.w("MicroMsg.FavTagPanel", "want to add type %s, but it exsited!", new Object[]{trim});
                return;
            }
        }
        this.jfF.clear();
        d crQ = crQ();
        this.jfF.add(crQ);
        a(crQ, trim, true);
        crQ.tye.setOnClickListener(this.jfH);
        addView(crQ.tye, this.jfF.size() - 1);
        crR();
    }

    public final void BJ(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.FavTagPanel", "want to remove type, but it is null or empty");
            return;
        }
        Iterator it = this.jfF.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equals(dVar.tyd)) {
                this.jfF.remove(dVar);
                removeView(dVar.tye);
                a(dVar);
                crR();
                return;
            }
        }
        x.w("MicroMsg.FavTagPanel", "want to remove type %s, but it not exsited!", new Object[]{str});
    }
}
