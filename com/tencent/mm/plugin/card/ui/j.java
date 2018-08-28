package com.tencent.mm.plugin.card.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

public final class j {
    public Bitmap eZA;
    public o eZB = null;
    public ImageView eZC;
    View eZD;
    OnClickListener eZF = new 1(this);
    MMActivity fcq;
    boolean hCn = true;
    Bitmap hGf = null;
    TextView hGg;
    TextView hGh;
    View hGi;
    ImageView hGj;
    MMVerticalTextView hGk;
    MMVerticalTextView hGl;
    ArrayList<Bitmap> hGm = new ArrayList();
    String hGn = "";
    b htQ;
    public Bitmap hyO;
    float hyW = 0.0f;

    public j(MMActivity mMActivity) {
        this.fcq = mMActivity;
    }

    private void ah(float f) {
        LayoutParams attributes = this.fcq.getWindow().getAttributes();
        attributes.screenBrightness = f;
        this.fcq.getWindow().setAttributes(attributes);
    }

    public final void ayS() {
        if (this.hyW < 0.8f) {
            ah(0.8f);
        }
    }

    public final void ayT() {
        ah(this.hyW);
    }

    final void ayU() {
        if (this.hGm.size() > 2) {
            int size = this.hGm.size() - 1;
            while (true) {
                int i = size;
                if (i > 1) {
                    l.x((Bitmap) this.hGm.remove(i));
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }
}
