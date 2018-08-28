package com.tencent.mm.plugin.emoji.ui.v2;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.ui.y;

public class EmojiStoreV2HotBarView extends LinearLayout {
    private View hyK;
    private View ipJ;
    private TextView ipK;
    private View ipL;
    private TextView ipM;
    private OnClickListener ipN = new 1(this);

    public EmojiStoreV2HotBarView(Context context) {
        super(context);
        init();
    }

    public EmojiStoreV2HotBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        x.d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x.d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
    }

    @TargetApi(11)
    public EmojiStoreV2HotBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.hyK = ((ViewGroup) y.gq(getContext()).inflate(R.i.emoji_store_v2_hot_bar_view, this)).findViewById(R.h.root);
        this.ipJ = this.hyK.findViewById(R.h.emoji_designer_catalog);
        this.ipK = (TextView) this.hyK.findViewById(R.h.emoji_more);
        this.ipK.setText(getResources().getText(R.l.emoji_store_new_suggest) + " ");
        this.ipL = this.hyK.findViewById(R.h.designer_product);
        this.ipL.setOnClickListener(new 2(this));
        this.ipM = (TextView) this.hyK.findViewById(R.h.new_tips);
        aGm();
        setMoreOnClickListener(this.ipN);
    }

    public final void aGm() {
        au.HU();
        boolean booleanValue = ((Boolean) c.DT().get(a.sPa, Boolean.valueOf(false))).booleanValue();
        if (this.ipM != null) {
            this.ipM.setVisibility(booleanValue ? 0 : 8);
        }
    }

    public void setMoreOnClickListener(OnClickListener onClickListener) {
        if (this.ipK != null) {
            this.ipK.setOnClickListener(onClickListener);
        }
    }

    public View getRootView() {
        return this.hyK;
    }

    public void setDesignerEmojiViewVisibility(int i) {
        if (this.ipL != null) {
            this.ipL.setVisibility(i);
        }
    }

    public void setDesignerCatalogViewPadding(boolean z) {
        if (this.ipJ != null && !z) {
            int ad = com.tencent.mm.bp.a.ad(getContext(), R.f.ListPadding);
            int ad2 = com.tencent.mm.bp.a.ad(getContext(), R.f.MiddlePadding);
            int ad3 = com.tencent.mm.bp.a.ad(getContext(), R.f.NormalPadding);
            this.ipJ.setPadding(ad3, ad, ad3, ad2);
        }
    }

    public void setVisibility(int i) {
        if (this.hyK != null) {
            this.hyK.setVisibility(i);
        } else {
            super.setVisibility(i);
        }
    }
}
