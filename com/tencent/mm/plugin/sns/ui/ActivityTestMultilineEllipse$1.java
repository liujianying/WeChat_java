package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

class ActivityTestMultilineEllipse$1 implements OnClickListener {
    final /* synthetic */ QTextView nJP;
    final /* synthetic */ ActivityTestMultilineEllipse nJQ;

    ActivityTestMultilineEllipse$1(ActivityTestMultilineEllipse activityTestMultilineEllipse, QTextView qTextView) {
        this.nJQ = activityTestMultilineEllipse;
        this.nJP = qTextView;
    }

    public final void onClick(View view) {
        QTextView qTextView;
        if (this.nJP.getIsExpanded()) {
            qTextView = this.nJP;
            qTextView.nQB = false;
            qTextView.requestLayout();
            qTextView.invalidate();
            return;
        }
        qTextView = this.nJP;
        qTextView.nQB = true;
        qTextView.requestLayout();
        qTextView.invalidate();
    }
}
