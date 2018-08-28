package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.t;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.ui.MMActivity;

public class AppBrandSharedMessageUI extends MMActivity {
    private ListView CU;
    private MRecyclerView gvH;

    public static class a extends android.support.v7.widget.RecyclerView.a {
        public final t a(ViewGroup viewGroup, int i) {
            return null;
        }

        public final void a(t tVar, int i) {
        }

        public final int getItemCount() {
            return 0;
        }

        public final int getItemViewType(int i) {
            return super.getItemViewType(i);
        }
    }

    protected final int getLayoutId() {
        return h.app_brand_shared_message_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.CU = (ListView) findViewById(g.list_view);
        this.gvH = (MRecyclerView) findViewById(g.data_rv);
        this.CU.setAdapter(new b(getLayoutInflater()));
        this.CU.setOnItemClickListener(new 1(this));
        this.gvH.setLayoutManager(new LinearLayoutManager(1));
        this.gvH.setAdapter(new a());
        this.gvH.addHeaderView(getLayoutInflater().inflate(h.app_brand_shared_message_list_header, null));
    }
}
