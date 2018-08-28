package com.tencent.mm.ui.chatting;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.g$a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AppAttachFileListUI extends MMActivity implements com.tencent.mm.plugin.messenger.foundation.a.a.f.a {
    private OnScrollListener hRW = new OnScrollListener() {
        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0 && !AppAttachFileListUI.this.tGx && AppAttachFileListUI.this.tGw && absListView.getLastVisiblePosition() == AppAttachFileListUI.this.tGv.getCount()) {
                x.d("MicroMsg.AppAttachFileListUI", "need to add item");
                int e = AppAttachFileListUI.this.tGz;
                new a(AppAttachFileListUI.this, (byte) 0).execute(new Integer[]{Integer.valueOf(e), Integer.valueOf(20)});
                AppAttachFileListUI.f(AppAttachFileListUI.this);
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private OnItemClickListener hpE = new 2(this);
    private ArrayList<c> tGs;
    private HashSet<Long> tGt;
    private ListView tGu;
    private b tGv;
    private boolean tGw = true;
    private boolean tGx = false;
    private View tGy;
    private int tGz;

    private class a extends AsyncTask<Integer, Integer, List<bd>> {
        private a() {
        }

        /* synthetic */ a(AppAttachFileListUI appAttachFileListUI, byte b) {
            this();
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            Integer[] numArr = (Integer[]) objArr;
            int intValue = numArr[0].intValue();
            int intValue2 = numArr[1].intValue();
            String GF = q.GF();
            au.HU();
            List X = c.FT().X(GF, intValue, intValue2);
            AppAttachFileListUI.this.tGz = intValue2 + AppAttachFileListUI.this.tGz;
            return X;
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            List list = (List) obj;
            super.onPostExecute(list);
            AppAttachFileListUI.g(AppAttachFileListUI.this);
            AppAttachFileListUI.this.dy(list);
            AppAttachFileListUI.this.tGv.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void f(AppAttachFileListUI appAttachFileListUI) {
        x.d("MicroMsg.AppAttachFileListUI", "start to load");
        appAttachFileListUI.tGx = true;
        appAttachFileListUI.tGy.setVisibility(0);
    }

    static /* synthetic */ void g(AppAttachFileListUI appAttachFileListUI) {
        appAttachFileListUI.tGx = false;
        appAttachFileListUI.tGy.setVisibility(8);
        x.d("MicroMsg.AppAttachFileListUI", "stop to load");
    }

    protected final int getLayoutId() {
        return R.i.app_attach_file_list_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.file_list_title);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppAttachFileListUI.this.finish();
                return true;
            }
        });
        this.tGu = (ListView) findViewById(R.h.file_list_lv);
        this.tGy = getLayoutInflater().inflate(R.i.app_attach_file_list_footer, null);
        this.tGu.addFooterView(this.tGy);
        this.tGy.setVisibility(8);
        this.tGs = new ArrayList();
        this.tGt = new HashSet();
        String GF = q.GF();
        au.HU();
        List X = c.FT().X(GF, 0, 20);
        this.tGz += 20;
        dy(X);
        this.tGv = new b(this, (byte) 0);
        this.tGu.setAdapter(this.tGv);
        this.tGu.setOnItemClickListener(this.hpE);
        this.tGu.setOnScrollListener(this.hRW);
        au.HU();
        c.FT().a(this, getMainLooper());
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        au.HU();
        c.FT().a(this);
        super.onDestroy();
    }

    private void dy(List<bd> list) {
        if (list.size() < 20) {
            this.tGw = false;
            this.tGu.removeFooterView(this.tGy);
        }
        for (bd bdVar : list) {
            c an = an(bdVar);
            if (an != null && an.tGB.type == 6 && this.tGt.add(Long.valueOf(bdVar.field_msgId))) {
                this.tGs.add(an);
            }
        }
        x.d("MicroMsg.AppAttachFileListUI", "append file item list size %d, current total size is %d", new Object[]{Integer.valueOf(list.size()), Integer.valueOf(this.tGs.size())});
    }

    private c an(bd bdVar) {
        g$a gp = g$a.gp(bdVar.field_content);
        if (gp == null) {
            return null;
        }
        c cVar = new c(this, (byte) 0);
        cVar.bXQ = bdVar;
        cVar.tGB = gp;
        return cVar;
    }

    public final void a(f fVar, f.c cVar) {
        if ("insert".equals(cVar.lcx)) {
            x.d("MicroMsg.AppAttachFileListUI", "reveive a msg");
            for (int size = cVar.lcy.size() - 1; size >= 0; size--) {
                bd bdVar = (bd) cVar.lcy.get(size);
                if (bdVar.aQm()) {
                    c an = an(bdVar);
                    if (an != null && an.tGB.type == 6) {
                        this.tGs.add(0, an);
                    }
                }
            }
            if (this.tGv != null) {
                this.tGv.notifyDataSetChanged();
            }
        }
    }
}
