package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.platformtools.y.a;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class b extends Preference implements a {
    f eOE;
    String ijO;
    private Context mContext;
    private ImageView mGO = null;
    private View mView = null;

    public b(Context context) {
        super(context);
        setLayoutResource(R.i.product_banner_preference);
        y.a((a) this);
        this.mContext = context;
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
        this.mGO = (ImageView) view.findViewById(R.h.banner_thumb);
        if (!bi.oW(this.ijO)) {
            Bitmap a = y.a(new o(this.ijO));
            if (a == null || a.isRecycled()) {
                this.mGO.setBackgroundColor(this.mContext.getResources().getColor(R.e.grid_preference_thumb_bg_color));
                this.mGO.setImageBitmap(null);
                return;
            }
            this.mGO.setImageBitmap(a);
            this.mGO.setBackgroundColor(0);
        }
    }

    public final void m(String str, Bitmap bitmap) {
        if (!bi.oW(str) && str.equals(this.ijO) && bitmap != null && !bitmap.isRecycled()) {
            this.mGO.setImageBitmap(bitmap);
            this.mGO.setBackgroundColor(0);
            if (this.eOE != null) {
                this.eOE.notifyDataSetChanged();
            }
        }
    }
}
