package com.tencent.mm.plugin.record.ui.b;

import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.widget.b.a;

class d$1 implements OnLongClickListener {
    final /* synthetic */ d mtI;
    final /* synthetic */ b mtz;

    d$1(d dVar, b bVar) {
        this.mtI = dVar;
        this.mtz = bVar;
    }

    public final boolean onLongClick(View view) {
        final TextView textView = (TextView) view;
        CharSequence spannableString = new SpannableString(textView.getText());
        spannableString.setSpan(new BackgroundColorSpan(this.mtI.context.getResources().getColor(R.e.light_blue_bg_color)), 0, textView.getText().length(), 33);
        textView.setText(spannableString);
        a aVar = new a(this.mtI.context, textView);
        aVar.uKW = new 1(this);
        aVar.ofq = new 2(this, textView);
        aVar.uCi = new OnDismissListener() {
            public final void onDismiss() {
                textView.setText(d$1.this.mtz.bOz.desc);
                j.g(textView, 1);
            }
        };
        if (view.getTag(R.h.touch_loc) instanceof int[]) {
            int[] iArr = (int[]) view.getTag(R.h.touch_loc);
            aVar.bU(iArr[0], iArr[1]);
        } else {
            aVar.bU(this.mtI.hpr, this.mtI.hps);
        }
        return true;
    }
}
