package com.tencent.mm.pluginsdk.ui.preference;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.tools.g;

class a$1 implements OnClickListener {
    final /* synthetic */ a qOu;

    a$1(a aVar) {
        this.qOu = aVar;
    }

    public final void onClick(View view) {
        View inflate = View.inflate(a.a(this.qOu), R.i.sendrequest_dialog, null);
        ((TextView) inflate.findViewById(R.h.sendrequest_tip)).setVisibility(8);
        final TextView textView = (TextView) inflate.findViewById(R.h.wordcount);
        textView.setVisibility(0);
        textView.setText("50");
        EditText editText = (EditText) inflate.findViewById(R.h.sendrequest_content);
        editText.setSingleLine(false);
        c.d(editText).Gi(100).a(null);
        editText.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                int be = g.be(100, editable.toString());
                if (textView != null) {
                    textView.setText(String.valueOf(be));
                }
            }
        });
        h.a(a.a(this.qOu), a.a(this.qOu).getString(R.l.app_reply), inflate, new 2(this, editText), null);
        editText.post(new Runnable() {
            public final void run() {
                if (a.a(a$1.this.qOu) instanceof MMActivity) {
                    ((MMActivity) a.a(a$1.this.qOu)).showVKB();
                }
            }
        });
    }
}
