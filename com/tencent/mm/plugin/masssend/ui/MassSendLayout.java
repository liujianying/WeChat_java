package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import java.util.ArrayList;
import java.util.List;

public class MassSendLayout extends BasePanelKeybordLayout {
    private View gvO;

    public MassSendLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MassSendLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setPanel(View view) {
        this.gvO = view;
    }

    protected List<View> getPanelView() {
        List<View> arrayList = new ArrayList();
        arrayList.add(this.gvO);
        return arrayList;
    }
}
