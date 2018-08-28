package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.platformtools.y.a;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class CategoryWithTitlePreference extends Preference implements a {
    private Context context;
    private TextView eBO;
    private f eOE;
    private ImageView gxd;
    private int hWb;
    private String iconUrl;
    private int mFp;
    private String title;

    public final /* bridge */ /* synthetic */ CharSequence getTitle() {
        return this.title;
    }

    public CategoryWithTitlePreference(Context context) {
        this(context, null);
    }

    public CategoryWithTitlePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CategoryWithTitlePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.title = "";
        this.hWb = 34;
        this.mFp = 34;
        setLayoutResource(R.i.mm_preference_category_with_title);
        this.context = context;
        y.a(this);
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0) {
            this.title = charSequence.toString();
            if (this.eBO != null) {
                this.eBO.setVisibility(0);
                this.eBO.setText(charSequence);
                x.v("MicroMsg.scanner.CategoryWithTitlePreference", "title : " + this.eBO.getText());
            }
        } else if (this.eBO != null) {
            this.eBO.setVisibility(8);
        }
        super.setTitle(charSequence);
    }

    public final void setTitle(int i) {
        if (this.eBO != null) {
            if (this.context != null) {
                this.title = this.context.getString(i);
            }
            if (bi.oW(this.title)) {
                this.eBO.setVisibility(8);
            } else {
                this.eBO.setVisibility(0);
                this.eBO.setText(this.title);
            }
        }
        super.setTitle(i);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.eBO = (TextView) view.findViewById(16908310);
        this.gxd = (ImageView) view.findViewById(R.h.icon);
        LayoutParams layoutParams = this.gxd.getLayoutParams();
        layoutParams.width = b.b(this.context, (float) (this.hWb / 2));
        layoutParams.height = b.b(this.context, (float) (this.mFp / 2));
        this.gxd.setLayoutParams(layoutParams);
        if (!(this.title == null || this.title.length() <= 0 || this.eBO == null)) {
            this.eBO.setVisibility(0);
            this.eBO.setText(this.title);
            x.v("MicroMsg.scanner.CategoryWithTitlePreference", "onBindView title : " + this.eBO.getText());
        }
        if (!bi.oW(this.iconUrl)) {
            Bitmap a = y.a(new o(this.iconUrl));
            if (a != null && !a.isRecycled()) {
                this.gxd.setImageBitmap(a);
                this.gxd.setVisibility(0);
            }
        }
    }

    public final void m(String str, Bitmap bitmap) {
        x.d("MicroMsg.scanner.CategoryWithTitlePreference", "get pic:" + str + ", iconurl:" + this.iconUrl);
        if (!bi.oW(str) && str.equals(this.iconUrl) && bitmap != null && !bitmap.isRecycled() && this.gxd != null) {
            ah.A(new 1(this, bitmap));
        }
    }
}
