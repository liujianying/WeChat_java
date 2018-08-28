package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.platformtools.y.a;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.io.IOException;

public final class d extends Preference implements a {
    private f eOE;
    private TextView gsY = null;
    private ImageView hVP = null;
    String jNk;
    private TextView mHZ = null;
    String mIa;
    private View mView = null;
    String myS;

    public d(Context context) {
        super(context);
        setLayoutResource(R.i.product_comment_preference);
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
        this.hVP = (ImageView) view.findViewById(R.h.comment_avatar);
        this.gsY = (TextView) view.findViewById(R.h.comment_nickname);
        this.mHZ = (TextView) view.findViewById(R.h.comment_content);
        if (bi.oW(this.mIa)) {
            this.hVP.setVisibility(8);
        } else {
            Bitmap a = y.a(new o(this.mIa));
            if (a == null || a.isRecycled()) {
                try {
                    this.hVP.setImageBitmap(b.a(ad.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bp.a.getDensity(null)));
                } catch (IOException e) {
                    this.hVP.setImageBitmap(null);
                }
            } else {
                this.hVP.setImageBitmap(a);
                this.hVP.setBackgroundColor(0);
            }
        }
        if (bi.oW(this.myS)) {
            this.gsY.setVisibility(8);
        } else {
            this.gsY.setText(j.a(this.mContext, this.myS, this.gsY.getTextSize()));
        }
        if (bi.oW(this.jNk)) {
            this.mHZ.setVisibility(8);
        } else {
            this.mHZ.setText(this.jNk);
        }
        if (bi.oW(this.myS) && bi.oW(this.mIa)) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.h.comment_container);
            LayoutParams layoutParams = linearLayout.getLayoutParams();
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(R.f.product_common_pref_height);
            linearLayout.setPadding(b.b(this.mContext, 9.0f), 0, 0, 0);
            linearLayout.setLayoutParams(layoutParams);
        }
    }

    public final void m(String str, Bitmap bitmap) {
        if (!bi.oW(str) && str.equals(this.mIa) && bitmap != null && !bitmap.isRecycled()) {
            this.hVP.setImageBitmap(bitmap);
            this.hVP.setBackgroundColor(0);
            if (this.eOE != null) {
                this.eOE.notifyDataSetChanged();
            }
        }
    }
}
