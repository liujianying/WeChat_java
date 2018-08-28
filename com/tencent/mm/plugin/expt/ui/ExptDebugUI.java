package com.tencent.mm.plugin.expt.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExptDebugUI extends MMActivity {
    private Button eGn;
    private Button eOQ;
    private TextView iIJ;
    private Button iIK;
    private Button iIL;
    private TextView iIM;
    private TextView iIN;
    private TextView iIO;
    private TextView iIP;
    private TextView iIQ;
    private EditText iIR;
    private Button iIS;
    private int iIT = 0;

    static /* synthetic */ void a(ExptDebugUI exptDebugUI, int i) {
        exptDebugUI.iIT = i;
        a pn = com.tencent.mm.plugin.expt.b.a.aIu().pn(exptDebugUI.iIT);
        if (pn != null) {
            exptDebugUI.iIM.setText(pn.field_exptId);
            exptDebugUI.iIN.setText(pn.field_groupId);
            exptDebugUI.iIO.setText(pn.field_exptSeq);
            exptDebugUI.iIP.setText(" start: " + pn.field_startTime + " end: " + pn.field_endTime);
        }
        HashMap a = com.tencent.mm.plugin.expt.b.a.aIu().a(exptDebugUI.iIT, false, null);
        if (a != null) {
            exptDebugUI.iIQ.setText(" args : " + a.toString());
        }
    }

    static /* synthetic */ void b(ExptDebugUI exptDebugUI) {
        com.tencent.mm.plugin.expt.b.a.aIu().AB(exptDebugUI.iIR.getText().toString().trim());
        exptDebugUI.iIR.setText("");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle("Expt debug ui");
        setBackBtn(new 1(this));
        this.iIJ = (TextView) findViewById(b.input_exptId);
        this.eGn = (Button) findViewById(b.confirm_btn);
        this.eGn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ExptDebugUI.a(ExptDebugUI.this, bi.getInt(ExptDebugUI.this.iIJ.getText().toString().trim(), 0));
            }
        });
        this.iIR = (EditText) findViewById(b.expt_xml);
        this.iIS = (Button) findViewById(b.expt_xml_confirm);
        this.iIS.setOnClickListener(new 3(this));
        this.iIK = (Button) findViewById(b.expt_picker);
        this.iIK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.plugin.expt.b.a aIu = com.tencent.mm.plugin.expt.b.a.aIu();
                ArrayList aII = aIu.iHQ != null ? aIu.iHQ.aII() : null;
                if (aII != null && aII.size() > 0) {
                    String[] strArr = new String[aII.size()];
                    for (int i = 0; i < strArr.length; i++) {
                        strArr[i] = aII.get(i);
                    }
                    com.tencent.mm.ui.widget.picker.b bVar = new com.tencent.mm.ui.widget.picker.b(ExptDebugUI.this.mController.tml, strArr);
                    bVar.GC(0);
                    bVar.uLl = new 1(this, bVar, strArr);
                    bVar.GB(com.tencent.mm.bp.a.fromDPToPix(ExptDebugUI.this.mController.tml, 288));
                    bVar.show();
                }
            }
        });
        this.iIL = (Button) findViewById(b.req_expt);
        this.iIL.setOnClickListener(new 5(this));
        this.eOQ = (Button) findViewById(b.expt_del);
        this.eOQ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                List arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(ExptDebugUI.this.iIT));
                ExptDebugUI.this.iIQ.setText(" del :" + ExptDebugUI.this.iIT + " " + (com.tencent.mm.plugin.expt.b.a.aIu().aV(arrayList) > 0));
            }
        });
        this.iIM = (TextView) findViewById(b.expt_id);
        this.iIN = (TextView) findViewById(b.group_id);
        this.iIO = (TextView) findViewById(b.expt_seq);
        this.iIP = (TextView) findViewById(b.expt_time);
        this.iIQ = (TextView) findViewById(b.expt_args);
    }

    protected final int getLayoutId() {
        return c.activity_expt_debug;
    }
}
