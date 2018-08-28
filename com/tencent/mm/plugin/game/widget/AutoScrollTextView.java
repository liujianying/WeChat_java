package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.f.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.al;
import java.util.ArrayList;
import java.util.List;

public class AutoScrollTextView extends LinearLayout {
    private int irJ = 0;
    private al jUl = new al(new 1(this), true);
    private ArrayList<String> jVK = new ArrayList();
    private Animation jVR;
    private Animation jVS;
    private TextView kgA;
    private TextView kgB;

    static /* synthetic */ void a(AutoScrollTextView autoScrollTextView) {
        if (autoScrollTextView.jVK.size() >= 2) {
            String str;
            if (autoScrollTextView.irJ < autoScrollTextView.jVK.size() - 1) {
                autoScrollTextView.irJ++;
                str = (String) autoScrollTextView.jVK.get(autoScrollTextView.irJ);
            } else {
                autoScrollTextView.irJ = 0;
                str = (String) autoScrollTextView.jVK.get(autoScrollTextView.irJ);
            }
            autoScrollTextView.b(autoScrollTextView.kgB, str);
            autoScrollTextView.kgA.startAnimation(autoScrollTextView.jVS);
            autoScrollTextView.kgA.setVisibility(8);
            autoScrollTextView.kgB.startAnimation(autoScrollTextView.jVR);
            autoScrollTextView.kgB.setVisibility(0);
            TextView textView = autoScrollTextView.kgA;
            autoScrollTextView.kgA = autoScrollTextView.kgB;
            autoScrollTextView.kgB = textView;
        }
    }

    public AutoScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kgA = new TextView(context, attributeSet);
        this.kgA.setVisibility(8);
        this.kgB = new TextView(context, attributeSet);
        this.kgB.setVisibility(8);
        addView(this.kgA);
        addView(this.kgB);
        setOrientation(1);
        setGravity(17);
        setPadding(0, 0, 0, 0);
        this.jVR = AnimationUtils.loadAnimation(context, a.slide_bottom_in);
        this.jVS = AnimationUtils.loadAnimation(context, a.slide_top_out);
    }

    public void setText(List<String> list) {
        this.jVK.clear();
        this.jUl.SO();
        if (list == null || list.size() == 0) {
            this.kgA.setVisibility(8);
            this.kgB.setVisibility(8);
            return;
        }
        this.jVK.addAll(list);
        b(this.kgA, (String) this.jVK.get(0));
        this.kgA.setVisibility(0);
        this.irJ = 0;
        if (this.jVK.size() != 1) {
            this.jUl.J(5000, 5000);
        }
    }

    private void b(TextView textView, String str) {
        textView.setText(new SpannableString(j.a(getContext(), str, textView.getTextSize())));
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.jUl.SO();
    }
}
