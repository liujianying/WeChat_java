package com.tencent.mm.plugin.sns.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.List;

public class SnsCardAdTagListView extends LinearLayout {
    private Activity activity;
    private List<View> nWx = new ArrayList();
    private int omV;

    public SnsCardAdTagListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SnsCardAdTagListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setActivityContext(Activity activity) {
        this.activity = activity;
    }

    public final void cw(List<String> list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Object obj;
                if (i == 0) {
                    obj = null;
                } else {
                    int obj2 = 1;
                }
                String str = (String) list.get(i);
                if (!bi.oW(str)) {
                    View inflate = this.activity.getLayoutInflater().inflate(g.ad_card_tag_item, null);
                    TextView textView = (TextView) inflate.findViewById(f.card_ad_tag_text);
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    if (obj2 != null) {
                        layoutParams.leftMargin = this.omV;
                    }
                    textView.setText(str);
                    addView(inflate, layoutParams);
                    this.nWx.add(inflate);
                }
            }
        }
    }

    public void setTagSpace(int i) {
        this.omV = i;
    }

    public void removeAllViews() {
        super.removeAllViews();
        this.nWx.clear();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        super.onMeasure(i, i2);
        int i5 = 0;
        while (true) {
            i3 = i4;
            if (i3 < this.nWx.size()) {
                if (i3 > 0) {
                    i4 = i5 + this.omV;
                } else {
                    i4 = i5;
                }
                if (i4 < getMeasuredWidth()) {
                    i5 = ((View) this.nWx.get(i3)).getMeasuredWidth() + i4;
                    if (i5 >= getMeasuredWidth()) {
                        break;
                    }
                    i4 = i3 + 1;
                } else {
                    i3--;
                    break;
                }
            }
            break;
        }
        if (i3 >= 0 && i3 < this.nWx.size()) {
            View view = (View) this.nWx.get(i3);
            TextView textView = (TextView) view.findViewById(f.card_ad_tag_text);
            textView.setEllipsize(TruncateAt.END);
            getViewTreeObserver().addOnPreDrawListener(new 1(this, textView, view));
            i5 = i3 + 1;
            while (true) {
                i4 = i5;
                if (i4 < this.nWx.size()) {
                    removeView((View) this.nWx.get(i4));
                    this.nWx.remove(i4);
                    i5 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
