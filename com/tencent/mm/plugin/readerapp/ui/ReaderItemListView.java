package com.tencent.mm.plugin.readerapp.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.View.OnCreateContextMenuListener;
import android.widget.ListView;
import com.tencent.mm.model.bi;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public class ReaderItemListView extends ListView {
    private Context context;
    private LayoutInflater eMa;
    d hqV;
    List<bi> mok = new ArrayList();
    a mol;
    OnCreateContextMenuListener mom;
    private DisplayMetrics mon;
    int position = 0;
    int type = 0;

    public ReaderItemListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public ReaderItemListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        boolean z = false;
        this.context = context;
        this.eMa = y.gq(context);
        this.type = ((Activity) context).getIntent().getIntExtra("type", 0);
        if (bi.he(this.type) != null) {
            z = true;
        }
        Assert.assertTrue(z);
        this.mon = getResources().getDisplayMetrics();
        this.mol = new a(this);
        setAdapter(this.mol);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
