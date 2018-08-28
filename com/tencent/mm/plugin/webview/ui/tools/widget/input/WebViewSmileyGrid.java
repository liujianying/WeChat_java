package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import com.tencent.mm.R;
import com.tencent.mm.br.e;
import com.tencent.mm.ui.y;

public class WebViewSmileyGrid extends GridView {
    OnItemClickListener UD = new 1(this);
    int gKK;
    int gKL = 0;
    int gKM;
    int gKN = 0;
    int gKO = 0;
    int gKP = 0;
    private c qlL;
    a qlM;

    private class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(WebViewSmileyGrid webViewSmileyGrid, byte b) {
            this();
        }

        public final int getCount() {
            return WebViewSmileyGrid.this.gKL;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null || view.getTag() == null) {
                view = y.gq(WebViewSmileyGrid.this.getContext()).inflate(R.i.webview_smiley_grid_item, null);
                view.setLayoutParams(new LayoutParams(-1, ((WebViewSmileyGrid.this.qlL.gKZ - com.tencent.mm.bp.a.ad(WebViewSmileyGrid.this.getContext(), R.f.LittlePadding)) - com.tencent.mm.bp.a.ad(WebViewSmileyGrid.this.getContext(), R.f.emoji_panel_tab_height)) / WebViewSmileyGrid.this.gKP));
                bVar = new b(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            if (i == getCount() - 1) {
                bVar.gmn.setImageResource(R.g.del_btn);
                bVar.gmn.setContentDescription(WebViewSmileyGrid.this.getContext().getString(R.l.delete_btn));
            } else {
                int d = ((WebViewSmileyGrid.this.gKL - 1) * WebViewSmileyGrid.this.gKM) + i;
                if (d > WebViewSmileyGrid.this.gKK - 1) {
                    bVar.gmn.setImageDrawable(null);
                } else {
                    bVar.gmn.setImageDrawable(e.cjH().mg(d));
                }
            }
            return view;
        }
    }

    public WebViewSmileyGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    int getRowSpacing() {
        return this.gKN;
    }

    public void setPanelManager(c cVar) {
        this.qlL = cVar;
    }
}
