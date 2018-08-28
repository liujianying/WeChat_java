package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.e.e.a.a;
import com.tencent.mm.plugin.game.f$b;
import com.tencent.mm.plugin.game.f$c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.plugin.game.f.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class r extends BaseAdapter {
    boolean bHx = false;
    Context context;
    ArrayList<b> hQM;
    int jNB = 0;
    int jZl = 0;
    boolean kbH = false;
    int kbI = 0;
    int kbJ = 0;
    int kbK = 0;
    int kbL = 0;
    private int kbM;
    boolean kbN = false;
    boolean kbO = false;
    private ArrayList<d> kbP;

    private class d {
        int end;
        int start;

        private d() {
            this.start = -1;
            this.end = -1;
        }

        /* synthetic */ d(r rVar, byte b) {
            this();
        }
    }

    public r(Context context) {
        this.context = context;
        this.hQM = null;
        this.kbM = context.getResources().getColor(f$b.gc_search_recmd_keyword_match);
    }

    public final int getCount() {
        return this.hQM == null ? 0 : this.hQM.size();
    }

    public final Object getItem(int i) {
        return this.hQM.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        return ((b) getItem(i)).type;
    }

    public final int getViewTypeCount() {
        return 7;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        b bVar = (b) getItem(i);
        if (view == null) {
            int i2;
            aVar = new a((byte) 0);
            Context context = this.context;
            switch (bVar.type) {
                case 0:
                    i2 = f.game_search_title_item_layout;
                    break;
                case 1:
                    i2 = f.game_search_game_item_layout;
                    break;
                case 2:
                    i2 = f.game_search_web_item_layout;
                    break;
                case 3:
                    i2 = f.game_search_similar_game_item_layout;
                    break;
                case 5:
                    i2 = f.game_search_more_item_layout;
                    break;
                case 6:
                    i2 = f.game_search_nores_item_layout;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            view = View.inflate(context, i2, null);
            aVar.contentView = view.findViewById(e.game_item_content_layout);
            aVar.kbT = (ImageView) view.findViewById(e.game_item_icon);
            aVar.kbU = (TextView) view.findViewById(e.game_item_name);
            aVar.kbV = (TextView) view.findViewById(e.game_item_brief);
            aVar.kbW = (TextView) view.findViewById(e.game_item_desc);
            aVar.kbX = (TextView) view.findViewById(e.game_item_play);
            aVar.kbY = view.findViewById(e.game_item_divide_view);
            aVar.kbZ = (TextView) view.findViewById(e.source_name);
            aVar.kca = (TextView) view.findViewById(e.create_time);
            view.setTag(aVar);
            if (!(aVar.kbU == null || aVar.kbW == null)) {
                TextView textView = aVar.kbU;
                textView.getViewTreeObserver().addOnGlobalLayoutListener(new 1(this, textView, aVar.kbW));
            }
        } else {
            aVar = (a) view.getTag();
        }
        a aVar2;
        switch (bVar.type) {
            case 0:
                aVar.kbW.setText(bVar.name);
                break;
            case 1:
                if (!bi.oW(bVar.iconUrl)) {
                    aVar2 = new a();
                    aVar2.dXw = false;
                    aVar2.dXy = false;
                    com.tencent.mm.plugin.game.e.e.aVj().a(aVar.kbT, bVar.iconUrl, aVar2.aVk());
                }
                a(aVar.kbU, bVar.name);
                a(aVar.kbV, bVar.kcb);
                a(aVar.kbW, bVar.fky);
                break;
            case 2:
                if (bi.oW(bVar.iconUrl)) {
                    aVar.kbT.setVisibility(8);
                } else {
                    aVar2 = new a();
                    aVar2.dXw = false;
                    aVar2.dXy = false;
                    aVar2.kdA = true;
                    com.tencent.mm.plugin.game.e.e.aVj().a(aVar.kbT, bVar.iconUrl, aVar2.aVk());
                    aVar.kbT.setVisibility(0);
                }
                a(aVar.kbU, bVar.name);
                a(aVar.kbW, bVar.fky);
                if (bi.oW(bVar.dCS)) {
                    aVar.kbZ.setVisibility(8);
                } else {
                    aVar.kbZ.setText(j.a(this.context, bVar.dCS));
                    aVar.kbZ.setVisibility(0);
                }
                if (bVar.createTime <= 0) {
                    aVar.kca.setVisibility(8);
                    break;
                }
                aVar.kca.setText(b.g(this.context, bVar.createTime * 1000));
                aVar.kca.setVisibility(0);
                break;
            case 3:
                if (!bi.oW(bVar.iconUrl)) {
                    aVar2 = new a();
                    aVar2.dXw = false;
                    aVar2.dXy = false;
                    com.tencent.mm.plugin.game.e.e.aVj().a(aVar.kbT, bVar.iconUrl, aVar2.aVk());
                }
                a(aVar.kbU, bVar.name);
                a(aVar.kbV, bVar.kcb);
                a(aVar.kbW, bVar.fky);
                TextView textView2 = aVar.kbX;
                LinkedList linkedList = bVar.kce;
                StringBuilder stringBuilder = new StringBuilder();
                if (!bi.cX(linkedList)) {
                    int size = linkedList.size();
                    for (int i3 = 0; i3 < size - 1; i3++) {
                        stringBuilder.append(((String) linkedList.get(i3)) + "\n");
                    }
                    stringBuilder.append((String) linkedList.get(size - 1));
                    textView2.setVisibility(0);
                    textView2.setText(stringBuilder.toString());
                    break;
                }
                textView2.setVisibility(8);
                break;
            case 5:
                aVar.kbT.setImageResource(h.search_more_button_icon);
                break;
            case 6:
                break;
        }
        aVar.kbU.setText(bVar.name);
        switch (bVar.type) {
            case 0:
                if (!bVar.kch) {
                    aVar.kbY.setVisibility(0);
                    break;
                }
                aVar.kbY.setVisibility(8);
                break;
            case 1:
            case 2:
            case 3:
            case 5:
                if (bVar.kci) {
                    aVar.contentView.setBackgroundResource(com.tencent.mm.plugin.game.f.d.comm_list_item_selector_no_divider);
                } else {
                    aVar.contentView.setBackgroundResource(com.tencent.mm.plugin.game.f.d.comm_list_item_selector);
                }
                int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(f$c.SearchNormalPadding);
                aVar.contentView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
                break;
        }
        return view;
    }

    private void a(TextView textView, String str) {
        if (bi.oW(str)) {
            textView.setVisibility(8);
            return;
        }
        if (this.kbP == null) {
            this.kbP = new ArrayList();
        } else {
            this.kbP.clear();
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        d dVar = new d(this, (byte) 0);
        for (int indexOf = stringBuilder.indexOf("<em>"); indexOf >= 0; indexOf = stringBuilder.indexOf("<em>")) {
            dVar.start = indexOf;
            stringBuilder.delete(indexOf, indexOf + 4);
            indexOf = stringBuilder.indexOf("</em>");
            if (indexOf < 0) {
                break;
            }
            dVar.end = indexOf;
            stringBuilder.delete(indexOf, indexOf + 5);
            this.kbP.add(dVar);
        }
        CharSequence spannableString = new SpannableString(stringBuilder.toString());
        Iterator it = this.kbP.iterator();
        while (it.hasNext()) {
            d dVar2 = (d) it.next();
            if (dVar2.start < dVar2.end) {
                spannableString.setSpan(new ForegroundColorSpan(this.kbM), dVar2.start, dVar2.end, 33);
            }
        }
        textView.setText(spannableString);
        textView.setVisibility(0);
    }
}
