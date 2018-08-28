package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.j;
import com.tencent.mm.ac.q;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public class ChattingItemFooter extends LinearLayout implements OnClickListener {
    private static final int[] ucW = new int[]{R.g.chatfrom_bg_app_buttonleft, R.g.chatfrom_bg_app_buttonleft, R.g.chatfrom_bg_app_buttonright, R.g.chatfrom_bg_app_buttonone};
    private static final int[] ucX = new int[]{R.g.reader_news_multbg_buttonleft, R.g.reader_news_multbg_buttonmid, R.g.reader_news_multbg_buttonright, R.g.reader_news_multbg_buttonone};
    private LayoutInflater Bc;
    private String gtX;
    private Context mContext;

    public ChattingItemFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.Bc = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public final boolean l(List<j> list, String str) {
        if (list == null || list.size() <= 0) {
            x.d("ChattingItemFooter", "no menulist!");
            setVisibility(8);
            return false;
        }
        j jVar;
        TextView a;
        TextView a2;
        this.gtX = str;
        int childCount = getChildCount();
        int[] iArr = ucW;
        LayoutParams layoutParams = new LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        int size = list.size();
        switch (size) {
            case 1:
                jVar = (j) list.get(0);
                a = a(0, childCount, layoutParams);
                a.setText(jVar.name);
                a.setTag(jVar);
                a.setBackgroundResource(iArr[3]);
                break;
            case 2:
                break;
            case 3:
                jVar = (j) list.get(1);
                a2 = a(1, childCount, layoutParams);
                a2.setText(jVar.name);
                a2.setTag(jVar);
                a2.setBackgroundResource(iArr[1]);
                break;
        }
        jVar = (j) list.get(0);
        a2 = a(0, childCount, layoutParams);
        a2.setText(jVar.name);
        a2.setTag(jVar);
        a2.setBackgroundResource(iArr[0]);
        jVar = (j) list.get(size - 1);
        a = a(size - 1, childCount, layoutParams);
        a.setText(jVar.name);
        a.setTag(jVar);
        a.setBackgroundResource(iArr[2]);
        if (childCount > size && childCount - 1 > 0) {
            removeViews(size, childCount - 1);
        }
        setLongClickable(true);
        setVisibility(0);
        return true;
    }

    private TextView a(int i, int i2, LayoutParams layoutParams) {
        if (i < i2) {
            return (TextView) getChildAt(i);
        }
        TextView textView = (TextView) this.Bc.inflate(R.i.chatting_item_footer_item, null);
        textView.setLongClickable(false);
        textView.setOnClickListener(this);
        textView.setLayoutParams(layoutParams);
        addView(textView);
        return textView;
    }

    private void d(j jVar) {
        au.DF().a(new q(this.gtX, 1, jVar.getInfo(), null), 0);
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof j) {
            j jVar = (j) tag;
            switch (jVar.type) {
                case 1:
                    x.d("ChattingItemFooter", "get latest message");
                    jVar.state = j.dMg;
                    d(jVar);
                    return;
                case 2:
                    x.d("ChattingItemFooter", "start webview url");
                    jVar.state = j.dMg;
                    d(jVar);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", jVar.value);
                    intent.putExtra("showShare", false);
                    intent.putExtra("geta8key_username", this.gtX);
                    d.b(this.mContext, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                default:
                    return;
            }
        }
    }
}
