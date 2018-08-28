package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.widget.d;
import java.util.Calendar;

class EditHintView$7 implements OnClickListener {
    final /* synthetic */ EditHintView uYF;

    EditHintView$7(EditHintView editHintView) {
        this.uYF = editHintView;
    }

    public final void onClick(View view) {
        if (EditHintView.h(this.uYF) == null) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(System.currentTimeMillis());
            instance.add(2, 1);
            EditHintView.a(this.uYF, instance.get(1));
            EditHintView.b(this.uYF, instance.get(2));
            EditHintView.a(this.uYF, new d(this.uYF.getContext(), new 1(this), EditHintView.i(this.uYF), EditHintView.j(this.uYF), instance.get(5), instance.getTimeInMillis()));
        }
        EditHintView.h(this.uYF).show();
    }
}
