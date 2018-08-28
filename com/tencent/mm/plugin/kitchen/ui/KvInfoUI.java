package com.tencent.mm.plugin.kitchen.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.kitchen.b.b;
import com.tencent.mm.plugin.report.service.d;
import com.tencent.mm.plugin.report.service.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KvInfoUI extends MMActivity {
    private Button eGn;
    private c fad;
    private ArrayAdapter iIy;
    private EditText kAm;
    private Button kAn;
    private ListView kAo;
    private TextView kAp;
    private MMSwitchBtn kAq;
    private String kAr;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle("Debug show kv log");
        setBackBtn(new 1(this));
        this.kAm = (EditText) findViewById(b.input_log);
        this.kAp = (TextView) findViewById(b.select_id_info);
        this.kAn = (Button) findViewById(b.log_picker);
        this.kAn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                HashMap hashMap = j.brV().mFb;
                if (hashMap != null && hashMap.size() > 0) {
                    ArrayList arrayList = new ArrayList(hashMap.keySet());
                    com.tencent.mm.ui.widget.picker.b bVar = new com.tencent.mm.ui.widget.picker.b(KvInfoUI.this.mController.tml, arrayList);
                    bVar.GC(0);
                    bVar.uLl = new 1(this, bVar, arrayList);
                    bVar.GB(a.fromDPToPix(KvInfoUI.this.mController.tml, 288));
                    bVar.show();
                }
            }
        });
        this.kAq = (MMSwitchBtn) findViewById(b.debug_flag);
        this.kAq.setCheck(j.brV().mDt);
        this.kAq.setSwitchListener(new 3(this));
        this.eGn = (Button) findViewById(b.confirm_btn);
        this.eGn.setOnClickListener(new 4(this));
        this.kAo = (ListView) findViewById(b.kv_log_list);
        this.iIy = new 5(this, this, com.tencent.mm.plugin.kitchen.b.c.kv_info_ui_item, b.kv_info_ui_tv);
        this.kAo.setAdapter(this.iIy);
        this.kAo.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d dVar = (d) KvInfoUI.this.iIy.getItem(i);
                if (dVar != null) {
                    if (dVar.bKg == null || dVar.bKg.length() <= 0) {
                        dVar.bKg = ac.ce(dVar.value);
                    }
                    String str = (String) j.brV().mFc.get(dVar.bKg);
                    if (KvInfoUI.this.fad != null) {
                        KvInfoUI.this.fad.dismiss();
                    }
                    if (!bi.oW(str)) {
                        KvInfoUI.this.fad = h.a(KvInfoUI.this, str, "", KvInfoUI.this.getString(com.tencent.mm.plugin.kitchen.b.d.app_ok), KvInfoUI.this.getString(com.tencent.mm.plugin.kitchen.b.d.app_copy), true, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        }, new 2(this, str), -1);
                    }
                }
            }
        });
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.kitchen.b.c.kv_info_ui;
    }

    private void Fy(String str) {
        x.i("MicroMsg.KvInfoUI", "updateData new[%s] old[%s]", new Object[]{str, this.kAr});
        this.kAr = str;
        List list = (List) j.brV().mFb.get(this.kAr);
        if (list != null) {
            this.kAp.setText(this.kAr + ":" + list.size());
            this.iIy.setNotifyOnChange(false);
            this.iIy.clear();
            this.iIy.addAll(list);
            this.iIy.notifyDataSetChanged();
            return;
        }
        this.kAp.setText(this.kAr + ":0");
        this.iIy.clear();
    }

    protected void onDestroy() {
        if (this.iIy != null) {
            this.iIy.setNotifyOnChange(false);
            this.iIy.clear();
        }
        if (this.fad != null) {
            this.fad.dismiss();
        }
        YC();
        super.onDestroy();
    }

    protected void onResume() {
        if (!bi.oW(this.kAr)) {
            Fy(this.kAr);
        }
        super.onResume();
    }
}
