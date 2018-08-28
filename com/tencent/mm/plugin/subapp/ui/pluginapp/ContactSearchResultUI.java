package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aa.q;
import com.tencent.mm.bg.d;
import com.tencent.mm.pluginsdk.ui.tools.c;
import com.tencent.mm.protocal.c.biy;
import com.tencent.mm.protocal.c.bja;
import com.tencent.mm.protocal.c.bjp;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ContactSearchResultUI extends MMActivity {
    private static ag dvt = new ag(Looper.getMainLooper());
    private LinkedList<biy> dzs = new LinkedList();
    private ListView oto;
    private b otp;
    private LinkedList<bjp> otq = new LinkedList();
    private Map<String, c> otr;

    static /* synthetic */ void a(ContactSearchResultUI contactSearchResultUI, bjp bjp) {
        int i = 1;
        Intent intent = new Intent();
        if (2 == bjp.sjj) {
            i = 15;
        } else if (1 != bjp.sjj) {
            i = 0;
        }
        c.a(intent, bjp, i);
        d.b(contactSearchResultUI, "profile", ".ui.ContactInfoUI", intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        setMMTitle(R.l.contact_search_result);
        setBackBtn(new 1(this));
        this.otr = new HashMap();
        this.oto = (ListView) findViewById(R.h.result_contactlist);
        this.oto.setEmptyView((TextView) findViewById(R.h.empty));
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("result");
        int intExtra = getIntent().getIntExtra("add_more_friend_search_scene", 0);
        if (byteArrayExtra != null) {
            try {
                bja bja = (bja) new bja().aG(byteArrayExtra);
                if (bja != null) {
                    this.dzs = bja.rHc;
                    this.otq = bja.sjp;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ContactSearchResultUI", e, "", new Object[0]);
            }
        }
        if (this.dzs.size() != 0 || !this.otq.isEmpty()) {
            this.otp = new b(this, this);
            this.oto.setAdapter(this.otp);
            this.oto.setOnItemClickListener(new 2(this, intExtra));
            this.oto.setOnScrollListener(new a());
        }
    }

    protected final int getLayoutId() {
        return R.i.contact_search_result;
    }

    protected void onDestroy() {
        q.KJ().cancel();
        if (this.otr != null) {
            this.otr.clear();
        }
        super.onDestroy();
    }
}
