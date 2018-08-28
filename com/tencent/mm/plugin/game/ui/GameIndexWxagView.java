package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.n.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.sdk.platformtools.x;

public class GameIndexWxagView extends LinearLayout implements OnClickListener {
    LayoutInflater Bc = ((LayoutInflater) getContext().getSystemService("layout_inflater"));
    int jNv;
    ViewGroup mContainer = this;

    public GameIndexWxagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        x.i("MicroMsg.GameIndexWxagView", "initView finished");
    }

    public void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof a)) {
            a aVar = (a) view.getTag();
            if (aVar.jYX != null) {
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1079;
                ((d) g.l(d.class)).a(getContext(), aVar.jYX.hbL, aVar.jYX.jQb, aVar.jYX.jTy, 0, aVar.jYX.jTx, appBrandStatObject);
                an.a(getContext(), 10, 1025, aVar.jOu, 30, aVar.jYX.jQb, this.jNv, null);
            }
        }
    }
}
