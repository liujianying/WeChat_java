package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class a extends Preference implements com.tencent.mm.platformtools.y.a {
    private ImageView gER;
    private f gua;
    String iAb;
    private TextView mGL = null;
    String mGM = null;
    private View mView = null;

    public a(Context context) {
        super(context);
        setLayoutResource(R.i.scan_product_preference);
        y.a(this);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.mGL = (TextView) view.findViewById(R.h.digest);
        this.gER = (ImageView) view.findViewById(R.h.actiontext_icon);
        if (bi.oW(this.mGM)) {
            this.mGL.setVisibility(8);
        } else {
            this.mGL.setText(this.mGM);
            this.mGL.setVisibility(0);
        }
        if (!bi.oW(this.iAb)) {
            Bitmap a = y.a(new o(this.iAb));
            if (a != null && !a.isRecycled()) {
                this.gER.setImageBitmap(a);
                this.gER.setVisibility(0);
            }
        }
    }

    public final void m(String str, Bitmap bitmap) {
        if (!bi.oW(str) && str.equals(this.iAb) && bitmap != null && !bitmap.isRecycled() && this.gER != null) {
            ah.A(new 1(this, bitmap));
        }
    }
}
