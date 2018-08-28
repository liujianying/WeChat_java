package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.text.TextPaint;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.product.a.a;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.m;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class i extends BaseAdapter {
    private c lSG = a.bmG();
    LinkedList<m> lTr;
    OnItemClickListener lTs;
    private Context mContext;

    public i(Context context) {
        this.mContext = context;
        a.bmF();
    }

    public final int getCount() {
        return this.lTr != null ? this.lTr.size() : 0;
    }

    private m uz(int i) {
        return (m) this.lTr.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        String str;
        Pair pair;
        m uz = uz(i);
        if (view == null || view.getTag() == null) {
            aVar = new a(this);
            view = View.inflate(this.mContext, g.product_select_sku_item, null);
            aVar.lTt = (TextView) view.findViewById(f.mall_product_sku_title_tv);
            aVar.lTu = (MaxGridView) view.findViewById(f.mall_product_sku_gv);
            aVar.lTv = new j(this.mContext);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.lTt.setText(uz.lRV);
        aVar.lTu.setOnItemClickListener(this.lTs);
        j jVar = aVar.lTv;
        c cVar = this.lSG;
        String str2 = uz.lRU;
        if (cVar.lQX.containsKey(str2)) {
            str = (String) cVar.lQX.get(str2);
        } else {
            str = null;
        }
        jVar.lTx = uz;
        jVar.lTy = str;
        Context context = this.mContext;
        LinkedList linkedList = uz.lRW;
        int fromDPToPix = context.getResources().getDisplayMetrics().widthPixels - (com.tencent.mm.bp.a.fromDPToPix(context, 16) * 2);
        TextPaint paint = ((TextView) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(g.product_select_sku_cell, null)).getPaint();
        float f = 0.0f;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            float measureText = paint.measureText(((h) it.next()).name);
            if (f >= measureText) {
                measureText = f;
            }
            f = measureText;
        }
        int fromDPToPix2 = ((int) f) + (com.tencent.mm.bp.a.fromDPToPix(context, 10) * 2);
        int[] iArr = new int[4];
        int fromDPToPix3 = com.tencent.mm.bp.a.fromDPToPix(context, 12);
        for (int i2 = 0; i2 < 4; i2++) {
            iArr[i2] = (fromDPToPix - (fromDPToPix3 * i2)) / (i2 + 1);
        }
        for (fromDPToPix3 = 4; fromDPToPix3 > 0; fromDPToPix3--) {
            if (fromDPToPix2 < iArr[fromDPToPix3 - 1]) {
                pair = new Pair(Integer.valueOf(fromDPToPix3), Integer.valueOf(iArr[fromDPToPix3 - 1]));
                break;
            }
        }
        pair = new Pair(Integer.valueOf(1), Integer.valueOf(fromDPToPix));
        x.d("MicroMsg.MallProductImageAdapter", uz.lRV + " numColumns = " + pair);
        aVar.lTu.setColumnWidth(((Integer) pair.second).intValue());
        aVar.lTv.notifyDataSetChanged();
        aVar.lTu.setAdapter(aVar.lTv);
        return view;
    }
}
