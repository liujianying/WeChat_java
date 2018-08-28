package com.tencent.mm.ui.tools;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMWebView;

public final class k implements OnItemClickListener {
    private LayoutInflater Bc;
    private OnDismissListener gFM;
    private Context mContext;
    public com.tencent.mm.ui.base.k ofo;
    public c ofp;
    public d ofq;
    private l ofr;
    private a uAw;
    public a uAx;
    public b uAy;

    public k(Context context) {
        this.mContext = context;
        this.Bc = LayoutInflater.from(context);
        this.ofo = new com.tencent.mm.ui.base.k(context);
        this.ofr = new l(context);
    }

    public final void a(View view, final OnCreateContextMenuListener onCreateContextMenuListener, d dVar) {
        this.ofq = dVar;
        x.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu");
        if (view instanceof AbsListView) {
            x.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView");
            ((AbsListView) view).setOnItemLongClickListener(new 1(this, onCreateContextMenuListener));
        } else if (view instanceof MMWebView) {
            x.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu for webview");
            view.setOnLongClickListener(new 2(this, onCreateContextMenuListener));
        } else {
            x.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view");
            view.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    x.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
                    k.this.ofr.clear();
                    onCreateContextMenuListener.onCreateContextMenu(k.this.ofr, view, null);
                    k.this.bEo();
                    return true;
                }
            });
        }
    }

    public final void a(View view, int i, long j, OnCreateContextMenuListener onCreateContextMenuListener, d dVar) {
        if ((this.mContext instanceof MMFragmentActivity) && ((MMFragmentActivity) this.mContext).isSwiping()) {
            x.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenuForAdapterView");
            return;
        }
        this.ofr.clear();
        ContextMenuInfo adapterContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
        onCreateContextMenuListener.onCreateContextMenu(this.ofr, view, adapterContextMenuInfo);
        for (MenuItem menuItem : this.ofr.twb) {
            ((m) menuItem).twe = adapterContextMenuInfo;
        }
        bEo();
        this.ofq = dVar;
    }

    public final void a(View view, OnCreateContextMenuListener onCreateContextMenuListener, d dVar, OnDismissListener onDismissListener) {
        if ((this.mContext instanceof MMFragmentActivity) && ((MMFragmentActivity) this.mContext).isSwiping()) {
            x.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenu");
            return;
        }
        this.gFM = onDismissListener;
        this.ofr.clear();
        onCreateContextMenuListener.onCreateContextMenu(this.ofr, view, null);
        bEo();
        this.ofq = dVar;
    }

    public final void b(View view, OnCreateContextMenuListener onCreateContextMenuListener, d dVar) {
        a(view, onCreateContextMenuListener, dVar, null);
    }

    public final void d(OnCancelListener onCancelListener) {
        this.ofo.setOnCancelListener(onCancelListener);
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m mVar = (m) this.ofr.twb.get(i);
        if (mVar.performClick()) {
            x.i("MicroMsg.MMSubMenuHelper", "onItemClick menu item has listener");
            dismiss();
            return;
        }
        if (this.ofq != null) {
            this.ofq.onMMMenuItemSelected(mVar, i);
        }
        dismiss();
    }

    public final void dismiss() {
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
            x.w("MicroMsg.MMSubMenuHelper", "show, menu empty");
            return null;
        }
        if (this.uAw == null) {
            this.uAw = new a(this, (byte) 0);
        }
        this.ofo.hAv = this.uAw;
        this.ofo.qRL = this;
        this.ofo.setTitle(this.ofr.Io);
        this.ofo.setOnDismissListener(this.gFM);
        this.ofo.show();
        return this.ofo;
    }
}
