package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import java.util.ArrayList;
import java.util.List;

public class ChattingUILayout extends BasePanelKeybordLayout {
    private ChatFooterBottom qMJ;

    public ChattingUILayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private ChatFooterBottom k(ViewGroup viewGroup) {
        if (this.qMJ != null) {
            return this.qMJ;
        }
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return this.qMJ;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= viewGroup.getChildCount()) {
                return this.qMJ;
            }
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ChatFooterBottom) {
                this.qMJ = (ChatFooterBottom) childAt;
                return this.qMJ;
            } else if ((childAt instanceof ViewGroup) && k((ViewGroup) childAt) != null) {
                return this.qMJ;
            } else {
                i = i2 + 1;
            }
        }
    }

    protected List<View> getPanelView() {
        List<View> arrayList = new ArrayList();
        arrayList.add(k(this));
        return arrayList;
    }
}
