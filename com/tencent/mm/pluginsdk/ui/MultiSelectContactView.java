package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.selectcontact.a.a;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MultiSelectContactView extends LinearLayout {
    private LayoutInflater eMa;
    private View nHH;
    private int padding;
    private HorizontalScrollView qFS;
    private LinearLayout qFT;
    private View qFU;
    public MMEditText qFV;
    private List<String> qFW;
    private Animation qFX;
    private int qFY;
    private a qFZ;
    private b qGa;
    private c qGb;
    private List<View> qGc;
    boolean qGd;

    static /* synthetic */ void d(MultiSelectContactView multiSelectContactView) {
        if (multiSelectContactView.qFT.getChildCount() != 0) {
            View childAt = multiSelectContactView.qFT.getChildAt(multiSelectContactView.qFT.getChildCount() - 1);
            if (multiSelectContactView.qGd) {
                multiSelectContactView.a(childAt, true, false);
                multiSelectContactView.qGd = false;
            } else {
                multiSelectContactView.qGd = true;
                multiSelectContactView.cdo();
                childAt.findViewById(e.mask).setVisibility(0);
            }
            multiSelectContactView.qFV.requestFocus();
        }
    }

    public MultiSelectContactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qFY = 0;
        this.padding = 0;
        this.qGd = false;
        this.padding = getResources().getDimensionPixelSize(c.BasicPaddingSize);
        this.eMa = LayoutInflater.from(context);
        this.eMa.inflate(f.muti_select_contact_view, this, true);
        this.qFS = (HorizontalScrollView) findViewById(e.mutiselectcontact_scroll);
        this.qFV = (MMEditText) findViewById(e.mutiselectcontact_edittext);
        this.qFT = (LinearLayout) findViewById(e.mutiselectcontact_avatar_ll);
        this.qFU = findViewById(e.mutiselectcontact_searchicon);
        this.qFW = new LinkedList();
        this.qFX = AnimationUtils.loadAnimation(context, a.fast_faded_in);
        com.tencent.mm.ui.tools.a.c.d(this.qFV).Gi(100).a(null);
        this.nHH = findViewById(e.root);
        this.qFV.addTextChangedListener(new 1(this));
        this.qFV.setOnKeyListener(new 2(this));
        this.qGc = new ArrayList();
        this.qFV.clearFocus();
        this.qFV.setOnFocusChangeListener(new 3(this));
        setBackgroundColor(-201326593);
        setOnClickListener(new 4(this));
    }

    public int getSelectedCount() {
        return this.qFT.getChildCount();
    }

    public void setOnContactDeselectListener(a aVar) {
        this.qFZ = aVar;
    }

    public void setOnSearchTextChangeListener(b bVar) {
        this.qGa = bVar;
    }

    public void setOnSearchTextFouceChangeListener(c cVar) {
        this.qGb = cVar;
    }

    public void setFixedUserList(List<String> list) {
        if (list != null) {
            this.qFW.addAll(list);
        }
    }

    public void clearFocus() {
        this.qFV.clearFocus();
        cdn();
    }

    public final void Ty(String str) {
        if (!bi.oW(str)) {
            if (this.qFW.contains(str)) {
                x.i("MicroMsg.MultiSeclectContactView", "fixed user cant change");
                return;
            }
            cdn();
            View TA = TA(str);
            if (TA != null) {
                a(TA, false, false);
            } else {
                bm(str, true);
            }
        }
    }

    public final void Tz(String str) {
        View TA = TA(str);
        if (TA != null) {
            a(TA, false, false);
        }
    }

    private void cdn() {
        if (this.qFT.getChildCount() != 0 && this.qGd) {
            View childAt = this.qFT.getChildAt(this.qFT.getChildCount() - 1);
            this.qGd = false;
            childAt.findViewById(e.mask).setVisibility(8);
        }
    }

    public final void bm(String str, boolean z) {
        BT(this.qFT.getChildCount() + 1);
        View inflate = this.eMa.inflate(f.select_contact_avatar, null, true);
        ImageView imageView = (ImageView) inflate.findViewById(e.avatar);
        b.a(imageView, str);
        imageView.setContentDescription(((com.tencent.mm.plugin.messenger.a.b) g.l(com.tencent.mm.plugin.messenger.a.b.class)).gT(str));
        inflate.setTag(str);
        inflate.setOnClickListener(new 5(this));
        if (z) {
            inflate.startAnimation(this.qFX);
        }
        this.qFT.addView(inflate);
        cdp();
        LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
        layoutParams.height = getResources().getDimensionPixelSize(c.ContactAvatarSize);
        layoutParams.width = getResources().getDimensionPixelSize(c.ContactAvatarSize);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(c.BasicPaddingSize);
        inflate.setLayoutParams(layoutParams);
        cdo();
    }

    private void a(View view, boolean z, boolean z2) {
        if (z && this.qFZ != null) {
            this.qFZ.pf(view.getTag().toString());
        }
        if (z2) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), a.fast_faded_out);
            loadAnimation.setAnimationListener(new 6(this, view));
            view.startAnimation(loadAnimation);
            return;
        }
        this.qFT.removeView(view);
        cdp();
        BT(this.qFT.getChildCount());
    }

    private void cdo() {
        this.qFT.post(new 7(this));
    }

    private void BT(int i) {
        int measureText;
        if (this.qFY <= 0) {
            this.qFY += getResources().getDimensionPixelSize(c.LargerPadding);
            int b = BackwardSupportUtil.b.b(getContext(), 40.0f);
            measureText = (int) this.qFV.getPaint().measureText(getContext().getString(h.app_search));
            this.qFY = Math.max(b, measureText) + this.qFY;
        }
        if (this.qFY > 0) {
            measureText = this.nHH.getWidth();
            x.v("MicroMsg.MultiSeclectContactView", "parentWidth:%d, avatarWidth:%d, minInputAreaWidth:%d", new Object[]{Integer.valueOf(measureText), Integer.valueOf(i * (getResources().getDimensionPixelSize(c.ContactAvatarSize) + getResources().getDimensionPixelSize(c.BasicPaddingSize))), Integer.valueOf(this.qFY)});
            LayoutParams layoutParams = (LayoutParams) this.qFS.getLayoutParams();
            if (measureText - (i * (getResources().getDimensionPixelSize(c.ContactAvatarSize) + getResources().getDimensionPixelSize(c.BasicPaddingSize))) > this.qFY) {
                layoutParams.width = -2;
            } else {
                layoutParams.width = measureText - this.qFY;
            }
        }
    }

    private void cdp() {
        if (this.qFT.getChildCount() == 0) {
            this.qFU.setVisibility(0);
        } else {
            this.qFU.setVisibility(8);
        }
    }

    public String getSearchContent() {
        return this.qFV.getText().toString();
    }

    private View TA(String str) {
        int childCount = this.qFT.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.qFT.getChildAt(i);
            if (str.equals(childAt.getTag())) {
                return childAt;
            }
        }
        return null;
    }

    public EditText getInputText() {
        return this.qFV;
    }
}
