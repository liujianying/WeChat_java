package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.e;
import com.tencent.mm.plugin.sns.ui.previewimageview.e.8;
import com.tencent.mm.sdk.platformtools.x;

class e$1 implements e {
    final /* synthetic */ DynamicGridView olI;
    final /* synthetic */ e olJ;

    e$1(e eVar, DynamicGridView dynamicGridView) {
        this.olJ = eVar;
        this.olI = dynamicGridView;
    }

    public final void xI(int i) {
        x.i("DynamicGrid", "drag started at position " + i);
        if (VERSION.SDK_INT >= 21) {
            this.olJ.olB = this.olI.getElevation();
            this.olI.setElevation(100.0f);
        } else {
            this.olI.bringToFront();
        }
        e eVar = this.olJ;
        eVar.olC.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(eVar.olC, "translationY", new float[]{(float) eVar.olC.getHeight(), 0.0f});
        ofFloat.setDuration(200);
        ofFloat.start();
        e.a(this.olJ);
    }

    public final void xJ(int i) {
        x.i("DynamicGrid", "drag to del " + i);
        c cVar = this.olJ.oly;
        Object item = cVar.getItem(i);
        cVar.bA.remove(item);
        cVar.olp.remove(item);
        cVar.notifyDataSetChanged();
        if (cVar.olu != null) {
            cVar.olu.removeItem(i - cVar.olq);
        }
    }

    public final void k(Rect rect) {
        if (l(rect)) {
            e eVar = this.olJ;
            eVar.olC.setBackgroundColor(Color.parseColor("#ce3c39"));
            eVar.olD.setImageResource(i.sns_img_highlight_delete);
            eVar.nNC.setText("松手即可删除");
            return;
        }
        e.b(this.olJ);
    }

    public final void bEM() {
        e eVar = this.olJ;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(eVar.olC, "translationY", new float[]{0.0f, (float) eVar.olC.getHeight()});
        ofFloat.setDuration(200);
        ofFloat.addListener(new 8(eVar));
        ofFloat.start();
        this.olJ.oly.bEJ();
    }

    public final boolean l(Rect rect) {
        e eVar = this.olJ;
        if (rect == null) {
            return false;
        }
        if (eVar.olH == null) {
            eVar.olH = new Rect(eVar.olC.getLeft(), eVar.olC.getTop(), eVar.olC.getRight(), eVar.olC.getBottom());
        }
        x.d("DynamicGrid", "del area " + eVar.olH + ", test rect " + rect);
        return eVar.olH.intersects(rect.left, rect.top, rect.right, rect.bottom);
    }
}
