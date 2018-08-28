package com.tencent.mm.ui.base.preference;

import android.view.View;
import android.view.View.OnClickListener;

class InputPreference$1 implements OnClickListener {
    final /* synthetic */ InputPreference tCy;

    InputPreference$1(InputPreference inputPreference) {
        this.tCy = inputPreference;
    }

    public final void onClick(View view) {
        if (InputPreference.a(this.tCy) != null && InputPreference.b(this.tCy) != null && InputPreference.b(this.tCy).getText() != null) {
            InputPreference.b(this.tCy).getText().toString();
        }
    }
}
