package com.tencent.mm.plugin.sns.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n$c;
import com.tencent.mm.ui.base.n.d;
import java.util.HashMap;

public final class ba implements OnItemClickListener {
    private LayoutInflater Bc;
    private Context mContext;
    private k ofo;
    n$c ofp;
    d ofq;
    private l ofr;
    private a ofs;
    private HashMap<Integer, CharSequence> oft = new HashMap();
    private HashMap<Integer, Integer> ofu = new HashMap();

    private class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(ba baVar, byte b) {
            this();
        }

        public final int getCount() {
            return ba.this.ofr.size();
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = ba.this.Bc.inflate(g.sns_timeline_list_menu_item, viewGroup, false);
                aVar = new a(this, (byte) 0);
                aVar.eGX = (TextView) view.findViewById(f.title);
                aVar.ofw = (TextView) view.findViewById(f.right_hint);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            MenuItem item = ba.this.ofr.getItem(i);
            aVar.eGX.setText(item.getTitle());
            if (ba.this.oft.get(Integer.valueOf(item.getItemId())) != null) {
                aVar.ofw.setText((CharSequence) ba.this.oft.get(Integer.valueOf(item.getItemId())));
                aVar.ofw.setVisibility(0);
            } else {
                aVar.ofw.setVisibility(4);
            }
            if (ba.this.ofu.get(Integer.valueOf(item.getItemId())) != null) {
                aVar.ofw.setTextColor(((Integer) ba.this.ofu.get(Integer.valueOf(item.getItemId()))).intValue());
            }
            return view;
        }
    }

    public ba(Context context) {
        this.mContext = context;
        this.Bc = LayoutInflater.from(context);
        this.ofo = new k(context);
        this.ofr = new l(context);
    }

    public final void c(int i, CharSequence charSequence) {
        this.oft.put(Integer.valueOf(i), charSequence);
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m mVar = (m) this.ofr.twb.get(i);
        if (mVar.performClick()) {
            x.i("MicroMsg.SnsTimelineListMenu", "onItemClick menu item has listener");
            dismiss();
            return;
        }
        if (this.ofq != null) {
            this.ofq.onMMMenuItemSelected(mVar, i);
        }
        dismiss();
    }

    private void dismiss() {
        if (this.ofo.isShowing()) {
            this.ofo.dismiss();
        }
    }

    public final Dialog bEo() {
        if (this.ofp != null) {
            this.ofr.clear();
            this.ofr = new l(this.mContext);
            this.ofp.a(this.ofr);
        }
        if (this.ofr.crF()) {
            x.w("MicroMsg.SnsTimelineListMenu", "show, menu empty");
            return null;
        }
        if (this.ofs == null) {
            this.ofs = new a(this, (byte) 0);
        }
        this.ofo.hAv = this.ofs;
        this.ofo.qRL = this;
        this.ofo.setTitle(this.ofr.Io);
        this.ofo.show();
        return this.ofo;
    }
}
