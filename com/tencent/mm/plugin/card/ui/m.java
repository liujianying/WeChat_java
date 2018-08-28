package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.b;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.List;

public final class m extends BaseAdapter {
    OnClickListener hGS;
    boolean hGT = false;
    List<b> htU = new ArrayList();
    private Context mContext;

    public m(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.htU.size();
    }

    private b nY(int i) {
        return (b) this.htU.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        final b nY = nY(i);
        switch (nY.hvh) {
            case 2:
                view = View.inflate(this.mContext, e.card_cell_first_shop_item, null);
                TextView textView = (TextView) view.findViewById(d.card_cell_shop_item_title_tv);
                TextView textView2 = (TextView) view.findViewById(d.card_cell_shop_item_subtitle_tv);
                LinearLayout linearLayout = (LinearLayout) view.findViewById(d.shop_phone_layout);
                if (TextUtils.isEmpty(nY.hvl)) {
                    linearLayout.setVisibility(8);
                } else {
                    linearLayout.setTag(nY.hvl);
                    linearLayout.setOnClickListener(new 1(this));
                    ((ImageView) view.findViewById(d.card_cell_shop_item_phone_iv)).setBackgroundColor(l.xV(nY.dxh));
                    linearLayout.setVisibility(0);
                }
                textView.setText(nY.title);
                textView2.setText(nY.huX);
                break;
            default:
                a aVar;
                boolean z;
                if (view != null) {
                    aVar = (a) view.getTag();
                } else {
                    aVar = null;
                }
                if (view == null || r0 == null) {
                    view = View.inflate(this.mContext, e.card_cell_list_item, null);
                    a aVar2 = new a(this, (byte) 0);
                    aVar2.hFW = (TextView) view.findViewById(d.card_cell_item_title_tv);
                    aVar2.hGY = (TextView) view.findViewById(d.card_cell_item_subtitle_tv);
                    aVar2.hGZ = (TextView) view.findViewById(d.card_cell_item_divider_tv);
                    aVar2.hHa = (ImageView) view.findViewById(d.card_cell_item_icon_iv);
                    aVar2.gYR = view.findViewById(d.card_cell_item_content_layout);
                    aVar2.hHb = (CheckBox) view.findViewById(d.card_cell_item_follow_cbx);
                    view.setTag(aVar2);
                    aVar = aVar2;
                }
                aVar.hFW.setText(nY.title);
                if (nY.hvj) {
                    aVar.hHb.setVisibility(0);
                    aVar.hHb.setChecked(nY.hvk);
                    aVar.hHb.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            if (((CheckBox) view).isChecked()) {
                                nY.hvk = true;
                            } else {
                                nY.hvk = false;
                            }
                        }
                    });
                } else {
                    aVar.hHb.setVisibility(8);
                }
                if (TextUtils.isEmpty(nY.huX)) {
                    aVar.hGY.setVisibility(4);
                } else {
                    aVar.hGY.setVisibility(0);
                    aVar.hGY.setText(nY.huX);
                }
                if ((nY.roL & 1) > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    aVar.hFW.setGravity(17);
                    aVar.hFW.setTextColor(this.mContext.getResources().getColor(a.link_color));
                    aVar.hGY.setVisibility(8);
                } else {
                    aVar.hFW.setGravity(3);
                    aVar.hFW.setTextColor(this.mContext.getResources().getColor(a.item_title_color));
                }
                if (nY.hvi) {
                    aVar.hGZ.setVisibility(0);
                } else {
                    aVar.hGZ.setVisibility(8);
                }
                aVar.hGY.setTextColor(this.mContext.getResources().getColor(a.item_subtitle_color));
                if (bi.oW(nY.lMY)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    aVar.hHa.setVisibility(0);
                    com.tencent.mm.plugin.card.d.m.a(aVar.hHa, nY.lMY, com.tencent.mm.bp.a.fromDPToPix(this.mContext, 20), c.my_card_package_defaultlogo, false);
                } else {
                    aVar.hHa.setVisibility(8);
                }
                if (i + 1 >= getCount()) {
                    if (i + 1 == getCount()) {
                        if (!this.hGT) {
                            g(aVar.gYR, false);
                            break;
                        }
                        g(aVar.gYR, true);
                        break;
                    }
                }
                a(aVar.gYR, nY(i));
                a(aVar.gYR, nY(i + 1));
                break;
                break;
        }
        return view;
    }

    private static void a(View view, b bVar) {
        if (bVar != null) {
            g(view, bVar.hvi);
        }
    }

    private static void g(View view, boolean z) {
        Rect rect = new Rect();
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (z) {
            view.setBackgroundResource(c.mm_trans);
        } else {
            view.setBackgroundResource(c.list_item_normal);
        }
        view.setLayoutParams(layoutParams);
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
    }
}
