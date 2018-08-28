package com.tencent.mm.plugin.fav.ui.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.ui.m$e;
import com.tencent.mm.plugin.fav.ui.m$f;
import com.tencent.mm.plugin.fav.ui.m.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public abstract class d extends BaseAdapter implements OnClickListener {
    private Context context;
    public String jbY;
    public List<String> jbZ = new LinkedList();
    public SparseArray<SpannableString> jca = new SparseArray();

    public abstract void Ax(String str);

    public d(Context context) {
        this.context = context;
    }

    public int getCount() {
        return this.jbZ.size();
    }

    private String jl(int i) {
        return (String) this.jbZ.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = View.inflate(this.context, m$f.fav_tag_search_item, null);
            view.setOnClickListener(this);
        }
        TextView textView = (TextView) view.findViewById(m$e.search_info);
        Object aG = bi.aG(jl(i), "");
        int textSize = (int) textView.getTextSize();
        int hashCode = aG.hashCode();
        CharSequence charSequence = (SpannableString) this.jca.get(hashCode);
        if (charSequence == null) {
            charSequence = new SpannableString(j.a(this.context, aG, textSize));
            textSize = aG.indexOf(this.jbY);
            if (-1 == textSize) {
                x.w("MicroMsg.FavoriteTagSearchAdapter", "high light %s error", new Object[]{aG});
            } else {
                int length = this.jbY.length() + textSize;
                charSequence.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(b.wechat_green)), textSize, length, 33);
                charSequence.setSpan(new StyleSpan(1), textSize, length, 33);
                this.jca.put(hashCode, charSequence);
            }
        }
        textView.setText(charSequence);
        return view;
    }

    public void onClick(View view) {
        x.d("MicroMsg.FavoriteTagSearchAdapter", "select search tag %s", new Object[]{((TextView) view.findViewById(m$e.search_info)).getText().toString()});
        Ax(r0);
    }
}
