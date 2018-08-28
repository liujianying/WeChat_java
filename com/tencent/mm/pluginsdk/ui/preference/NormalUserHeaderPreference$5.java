package com.tencent.mm.pluginsdk.ui.preference;

import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.b.a;

class NormalUserHeaderPreference$5 implements OnLongClickListener {
    final /* synthetic */ NormalUserHeaderPreference qPp;

    NormalUserHeaderPreference$5(NormalUserHeaderPreference normalUserHeaderPreference) {
        this.qPp = normalUserHeaderPreference;
    }

    public final boolean onLongClick(View view) {
        if (!(NormalUserHeaderPreference.d(this.qPp).getText() == null || NormalUserHeaderPreference.e(this.qPp) == null)) {
            String charSequence = NormalUserHeaderPreference.d(this.qPp).getText().toString();
            int indexOf = charSequence.indexOf(58);
            if (indexOf >= 0 && indexOf < charSequence.length()) {
                charSequence = charSequence.substring(indexOf + 1).trim();
            }
            CharSequence spannableString = new SpannableString(NormalUserHeaderPreference.d(this.qPp).getText());
            spannableString.setSpan(new BackgroundColorSpan(NormalUserHeaderPreference.a(this.qPp).getResources().getColor(R.e.light_blue_bg_color)), indexOf + 1, NormalUserHeaderPreference.d(this.qPp).getText().length(), 33);
            NormalUserHeaderPreference.d(this.qPp).setText(spannableString);
            a aVar = new a(NormalUserHeaderPreference.a(this.qPp), NormalUserHeaderPreference.d(this.qPp));
            aVar.uKW = new 1(this);
            aVar.ofq = new d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    if (i == 0) {
                        NormalUserHeaderPreference.e(NormalUserHeaderPreference$5.this.qPp).setText(charSequence);
                        h.bz(NormalUserHeaderPreference.a(NormalUserHeaderPreference$5.this.qPp), NormalUserHeaderPreference.a(NormalUserHeaderPreference$5.this.qPp).getString(R.l.app_copy_ok));
                    }
                }
            };
            aVar.uCi = new OnDismissListener() {
                public final void onDismiss() {
                    NormalUserHeaderPreference$5.this.qPp.cfc();
                }
            };
            aVar.bU(0, 0);
        }
        return true;
    }
}
