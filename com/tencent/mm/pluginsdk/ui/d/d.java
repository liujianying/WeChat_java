package com.tencent.mm.pluginsdk.ui.d;

import android.text.SpannableString;

public interface d {

    public static class a {
        protected static d qPH;

        public static final void a(d dVar) {
            qPH = dVar;
        }
    }

    SpannableString g(CharSequence charSequence, int i);

    boolean u(CharSequence charSequence);

    boolean v(CharSequence charSequence);
}
