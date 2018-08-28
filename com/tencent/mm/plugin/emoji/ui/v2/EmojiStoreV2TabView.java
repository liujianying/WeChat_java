package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMTabView;

public class EmojiStoreV2TabView extends RelativeLayout {
    private int irI;
    private int irJ = 0;
    private Bitmap irK;
    private LinearLayout irL;
    private ImageView irM;
    private MMTabView irN;
    private MMTabView irO;
    private a irP;
    protected OnClickListener irQ = new 1(this);
    private Matrix mMatrix = new Matrix();

    public EmojiStoreV2TabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public EmojiStoreV2TabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.irI = (i3 - i) / 2;
        int i5 = this.irI;
        if (this.irK == null || this.irK.getWidth() != i5) {
            String str = "MicroMsg.emoji.EmojiStoreV2TabView";
            String str2 = "sharp width changed, from %d to %d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.irK == null ? -1 : this.irK.getWidth());
            objArr[1] = Integer.valueOf(i5);
            x.w(str, str2, objArr);
            this.irK = Bitmap.createBitmap(i5, a.fromDPToPix(getContext(), 3), Config.ARGB_8888);
            new Canvas(this.irK).drawColor(getResources().getColor(R.e.wechat_green));
            h(this.irJ, 0.0f);
            this.irM.setImageBitmap(this.irK);
        }
        setTo(this.irJ);
    }

    private void init() {
        this.irL = new LinearLayout(getContext());
        this.irL.setBackgroundResource(R.e.white);
        this.irL.setId(R.h.emoji_store_tab_container);
        this.irL.setOrientation(0);
        addView(this.irL, new LayoutParams(-1, -2));
        this.irM = new ImageView(getContext());
        this.irM.setImageMatrix(this.mMatrix);
        this.irM.setScaleType(ScaleType.MATRIX);
        this.irM.setId(R.h.emoji_store_tab_shape);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, a.fromDPToPix(getContext(), 3));
        layoutParams.addRule(8, R.h.emoji_store_tab_container);
        addView(this.irM, layoutParams);
        this.irN = oU(0);
        this.irN.setText(R.l.emoji_store_main_tab);
        layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.topTabbarHeight));
        layoutParams.weight = 1.0f;
        this.irL.addView(this.irN, layoutParams);
        this.irO = oU(1);
        this.irO.setText(R.l.emoji_store_person_tab_more);
        layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.topTabbarHeight));
        layoutParams.weight = 1.0f;
        this.irL.addView(this.irO, layoutParams);
    }

    private MMTabView oU(int i) {
        MMTabView mMTabView = new MMTabView(getContext(), i);
        mMTabView.setTag(Integer.valueOf(i));
        mMTabView.setOnClickListener(this.irQ);
        return mMTabView;
    }

    public void setOnTabClickListener(a aVar) {
        this.irP = aVar;
    }

    public int getCurentIndex() {
        return this.irJ;
    }

    public final void h(int i, float f) {
        this.mMatrix.setTranslate(((float) this.irI) * (((float) i) + f), 0.0f);
        this.irM.setImageMatrix(this.mMatrix);
    }

    public void setTo(int i) {
        this.irJ = i;
        this.irN.setTextColor(this.irJ == 0 ? getResources().getColorStateList(R.e.wechat_green) : getResources().getColorStateList(R.e.launcher_tab_text_selector));
        this.irO.setTextColor(this.irJ == 1 ? getResources().getColorStateList(R.e.wechat_green) : getResources().getColorStateList(R.e.launcher_tab_text_selector));
    }

    public void setPersonTabUnReadCount(String str) {
        if (this.irO != null) {
            this.irO.setUnread(str);
        }
    }

    public final void eu(boolean z) {
        if (this.irO != null) {
            this.irO.lF(z);
        }
    }
}
