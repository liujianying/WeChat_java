package com.tencent.mm.plugin.qqmail.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.p.a;
import com.tencent.mm.plugin.qqmail.b.p.c;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompressPreviewUI extends MMActivity {
    private ProgressBar gVi;
    private TextView jye;
    private String mcT = null;
    private String mcf = null;
    private c meR = new c(this);
    private String mes;
    private long mfH = 0;
    private List<a> mfI = new ArrayList();
    private String mfJ;
    private ListView mfK;
    private b mfL;
    private a mfM = new 5(this);

    protected final int getLayoutId() {
        return R.i.mail_compress_preview_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mcf = getIntent().getStringExtra("mail_id");
        this.mcT = getIntent().getStringExtra("attach_id");
        this.mfH = getIntent().getLongExtra("attach_size", 0);
        this.mes = getIntent().getStringExtra("attach_name");
        initView();
        setMMTitle(this.mes);
    }

    protected final void initView() {
        this.mfK = (ListView) findViewById(R.h.compress_preview_lv);
        this.jye = (TextView) findViewById(R.h.compress_preview_info_tv);
        this.gVi = (ProgressBar) findViewById(R.h.compress_preview_loading_pb);
        if (this.mcf == null || this.mcT == null) {
            this.gVi.setVisibility(8);
            this.jye.setText(R.l.mail_compress_preview_err_hint);
            return;
        }
        this.mfL = new b(this, (byte) 0);
        this.mfK.setAdapter(this.mfL);
        this.mfK.setOnItemClickListener(new 1(this));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                CompressPreviewUI.this.onKeyDown(4, null);
                return true;
            }
        });
        3 3 = new 3(this);
        addTextOptionMenu(0, getString(R.l.app_download), new 4(this));
        boO();
    }

    public void onDestroy() {
        super.onDestroy();
        this.meR.release();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.mfL.boQ() != null) {
            JZ(this.mfL.boQ());
            return true;
        } else if (keyEvent != null) {
            return super.onKeyDown(i, keyEvent);
        } else {
            finish();
            return true;
        }
    }

    private void JZ(String str) {
        x.i("MicroMsg.CompressPreviewUI", "curPath=" + str);
        this.gVi.setVisibility(8);
        this.jye.setVisibility(8);
        this.mfK.setVisibility(0);
        a Ka = Ka(str);
        List arrayList = new ArrayList();
        if (Ka != null) {
            arrayList.add(Ka);
        }
        for (int i = 0; i < this.mfI.size(); i++) {
            a aVar = (a) this.mfI.get(i);
            if ((str.endsWith(aVar.mfP) && aVar.mfP.length() > 0) || aVar.mfP.equals(str)) {
                arrayList.add(aVar);
            }
        }
        b bVar = this.mfL;
        bVar.mfR = Ka;
        bVar.mfS = arrayList;
        this.mfL.notifyDataSetChanged();
        this.mfK.setSelection(0);
    }

    private a Ka(String str) {
        for (a aVar : this.mfI) {
            if (aVar.id.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    private void boO() {
        Map hashMap = new HashMap();
        hashMap.put("mailid", this.mcf);
        hashMap.put("attachid", this.mcT);
        hashMap.put("fun", "list");
        w.bow().a("/cgi-bin/viewcompress", hashMap, new c(), this.mfM);
    }
}
