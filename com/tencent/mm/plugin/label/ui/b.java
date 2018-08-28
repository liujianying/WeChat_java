package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMTextView;
import java.util.ArrayList;

public final class b extends BaseAdapter {
    String eId;
    ArrayList<String> kBD = new ArrayList();
    SparseArray<SpannableString> kBE = new SparseArray();
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.kBD == null ? 0 : this.kBD.size();
    }

    /* renamed from: jl */
    public final String getItem(int i) {
        return (this.kBD == null || i >= getCount()) ? null : (String) this.kBD.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.i.contact_label_list_item, viewGroup, false);
            cVar = new c(view);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        MMTextView mMTextView = cVar.kCe;
        Object aG = bi.aG(getItem(i), "");
        int textSize = (int) cVar.kCe.getTextSize();
        int hashCode = aG.hashCode();
        CharSequence charSequence = (SpannableString) this.kBE.get(hashCode);
        if (charSequence == null) {
            charSequence = new SpannableString(j.a(this.mContext, aG, textSize));
            textSize = aG.indexOf(this.eId);
            if (textSize == -1) {
                x.w("MicroMsg.Label.ContactLabelSearchAdapter", "hight light %s error.", new Object[]{aG});
            } else {
                int length = this.eId.length() + textSize;
                charSequence.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.e.wechat_green)), textSize, length, 33);
                charSequence.setSpan(new StyleSpan(1), textSize, length, 33);
                this.kBE.put(hashCode, charSequence);
            }
        }
        mMTextView.setText(charSequence);
        return view;
    }
}
