package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.pluginsdk.ui.d.j;

public final class d implements b {
    Context context;
    int hpr;
    int hps;

    public d(Context context) {
        this.context = context;
    }

    public final View eb(Context context) {
        return View.inflate(context, R.i.record_listitem_text, null);
    }

    public final void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar) {
        TextView textView = (TextView) view.findViewById(R.h.record_listitem_content);
        textView.setText(bVar.bOz.desc);
        j.g(textView, 1);
        textView.setOnLongClickListener(new 1(this, bVar));
        view.setOnTouchListener(new 2(this));
    }

    public final void destroy() {
        this.context = null;
    }

    public final void pause() {
    }
}
