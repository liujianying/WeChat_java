package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public class AsyncNormalTextView extends CollapsibleTextView {
    public String content;
    private Context context;
    private c nLr;
    public int nLs = 0;
    public ay nLt;
    public av nuc;

    public AsyncNormalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public void setShow(c cVar) {
        this.nLr = cVar;
        bBM();
    }

    public final void bBM() {
        if (!bi.oW(this.content)) {
            System.currentTimeMillis();
            setVisibility(0);
            if (this.nLs == 1) {
                this.content = this.content.length() > 100 ? this.content.substring(0, 100) + "..." : this.content;
                a(this.nLs, new SpannableStringBuilder(j.a(this.context, this.content, this.nMn.getTextSize())), BufferType.NORMAL, this.nuc.nMs, this.nLt.nMU, this.nLt.oev, this.nuc, this.content, this.nLt.nLv);
            } else if (this.content.length() < TbsListener$ErrorCode.INFO_CODE_BASE || this.nLt.nLv) {
                CharSequence charSequence = null;
                if (this.nLt != null) {
                    charSequence = this.nLt.oet;
                }
                if (charSequence == null) {
                    charSequence = new SpannableStringBuilder(j.a(this.context, this.content, this.nMn.getTextSize()));
                }
                if (this.nLt != null) {
                    a(this.nLs, charSequence, BufferType.SPANNABLE, this.nuc.nMs, this.nLt.nMU, this.nLt.oev, this.nuc, this.content, this.nLt.nLv);
                }
            } else {
                a(this.nLs, this.content, BufferType.NORMAL, this.nuc.nMs, this.nLt.nMU, this.nLt.oev, this.nuc, this.content, this.nLt.nLv);
            }
            as asVar = new as(this.nLt.oev, this.nLt.nMU, false, false, 1);
            this.nMn.setTag(asVar);
            if (this.nMo != null) {
                this.nMo.setTag(asVar);
            }
            this.nMp.setTag(this.nLr);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(this.content);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setText(this.content);
    }

    public String getContent() {
        return this.content;
    }

    public void setContentWidth(int i) {
        if (this.nMo != null) {
            this.nMn.setSpecialWidth(i);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(i, -2);
            this.nMo.setLayoutParams(layoutParams);
            this.nMn.setLayoutParams(layoutParams);
            this.nMp.setLayoutParams(layoutParams);
        }
    }
}
