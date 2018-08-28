package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n$d;
import com.tencent.mm.plugin.fts.ui.n.e;
import com.tencent.mm.plugin.fts.ui.n.g;
import com.tencent.mm.sdk.platformtools.bi;

public final class h extends a {
    CharSequence jyi;
    private b jyj = new b(this, (byte) 0);
    a jyk = new a(this, (byte) 0);

    private class b extends com.tencent.mm.plugin.fts.a.d.a.a.b {
        private b() {
            super(h.this);
        }

        /* synthetic */ b(h hVar, byte b) {
            this();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(e.fts_create_chatroom_item, viewGroup, false);
            a aVar = h.this.jyk;
            aVar.eCn = (TextView) inflate.findViewById(n$d.desc_tv);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, a.a aVar, a aVar2, Object... objArr) {
            m.a(h.this.jyi, ((a) aVar).eCn);
        }

        public final boolean a(Context context, a aVar) {
            Intent intent = new Intent();
            intent.putExtra("query_phrase_list", bi.F(h.this.jrx.jrX));
            intent.putExtra("go_to_chatroom_direct", true);
            intent.putExtra("scene_from", 3);
            d.e(context, ".ui.transmit.MMCreateChatroomUI", intent);
            return true;
        }
    }

    public h(int i) {
        super(17, i);
    }

    public final void a(Context context, a.a aVar, Object... objArr) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (Object obj : this.jrx.jrX) {
            CharSequence spannableString = new SpannableString(obj);
            spannableString.setSpan(new ForegroundColorSpan(com.tencent.mm.plugin.fts.ui.b.b.jvr), 0, obj.length(), 33);
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append("、");
        }
        this.jyi = TextUtils.concat(new CharSequence[]{context.getString(g.select_create_desc_prefix), spannableStringBuilder.subSequence(0, spannableStringBuilder.length() - 1), context.getString(g.select_create_desc_postfix)});
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.b BV() {
        return this.jyj;
    }

    protected final a.a afD() {
        return this.jyk;
    }
}
