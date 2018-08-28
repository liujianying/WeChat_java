package com.tencent.mm.ui.fts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class FTSMainUIHotWordLayout extends LinearLayout {
    private TextView eCm = null;
    protected OnClickListener jxn;
    protected List<LinearLayout> jzM = null;
    protected int utH = 2;
    protected boolean utI = true;
    public b utJ = null;

    public FTSMainUIHotWordLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public FTSMainUIHotWordLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.jzM = new ArrayList();
    }

    public void setOnCellClickListener(OnClickListener onClickListener) {
        this.jxn = onClickListener;
    }

    public String getSearchId() {
        if (this.utJ == null || this.utJ.fuu == null) {
            return "";
        }
        return this.utJ.fuu;
    }

    public void setVisibility(int i) {
        if ((this.jzM.size() > 0 ? 1 : null) == null) {
            i = 8;
        }
        super.setVisibility(i);
    }
}
