package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public class SelectScanModeGrid extends GridView {

    public static class a extends BaseAdapter {
        private Context context;
        private List<b> mLN;
        int mLO = -1;

        public a(Context context, List<b> list) {
            this.context = context;
            this.mLN = list;
            x.d("MicroMsg.scanner.SelectScanModeGroupAdapter", "<init> list size = " + this.mLN.size());
        }

        public final int getCount() {
            return this.mLN.size();
        }

        public final Object getItem(int i) {
            if (i >= 0 && i < this.mLN.size()) {
                return this.mLN.get(i);
            }
            x.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getItem fail, invalid position = " + i);
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = View.inflate(this.context, R.i.select_scan_mode_grid_item, null);
                aVar = new a();
                aVar.mLP = (TextView) view.findViewById(R.h.select_scan_mode_img);
                aVar.lSz = (TextView) view.findViewById(R.h.select_scan_mode_tv);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            if (i == viewGroup.getChildCount()) {
                b bVar = (b) getItem(i);
                if (bVar == null) {
                    x.e("MicroMsg.scanner.SelectScanModeGroupAdapter", "getView fail, item is null");
                } else {
                    if (bVar.mLQ == R.l.scan_entry_image) {
                        aVar.lSz.setText(p.et(p.mOd, this.context.getString(R.l.scan_entry_image)));
                    } else {
                        aVar.lSz.setText(bVar.mLQ);
                    }
                    if (i == this.mLO) {
                        aVar.mLP.setBackgroundResource(bVar.mLS);
                    } else {
                        aVar.mLP.setBackgroundResource(bVar.mLR);
                    }
                    bVar.mLU = aVar.mLP;
                }
            }
            return view;
        }
    }

    public SelectScanModeGrid(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelectScanModeGrid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
