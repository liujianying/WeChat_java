package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.List;

public final class d {

    static class a extends BaseAdapter {
        private final Context context;
        List<String> lSx;
        int lSy = -1;
        private final int style;

        public a(Context context) {
            this.context = context;
            this.style = 1;
        }

        public final int getCount() {
            return this.lSx != null ? this.lSx.size() : 0;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z = true;
            if (view == null) {
                view = View.inflate(this.context, g.mm_preference_dialog_item, null);
                b bVar = new b();
                bVar.lSz = (TextView) view.findViewById(f.text);
                bVar.lSA = (CheckBox) view.findViewById(f.check);
                bVar.lSB = (RadioButton) view.findViewById(f.radio);
                view.setTag(bVar);
            }
            b bVar2 = (b) view.getTag();
            bVar2.lSz.setText((CharSequence) this.lSx.get(i));
            switch (this.style) {
                case 1:
                    bVar2.lSA.setVisibility(8);
                    bVar2.lSB.setVisibility(0);
                    bVar2.lSB.setChecked(i == this.lSy);
                    break;
                case 2:
                    bVar2.lSA.setVisibility(0);
                    bVar2.lSB.setVisibility(8);
                    CheckBox checkBox = bVar2.lSA;
                    if (i != this.lSy) {
                        z = false;
                    }
                    checkBox.setChecked(z);
                    break;
                default:
                    bVar2.lSA.setVisibility(8);
                    bVar2.lSB.setVisibility(8);
                    break;
            }
            return view;
        }
    }
}
