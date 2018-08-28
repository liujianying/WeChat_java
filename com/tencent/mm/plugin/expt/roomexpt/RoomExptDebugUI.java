package com.tencent.mm.plugin.expt.roomexpt;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b$b;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RoomExptDebugUI extends MMActivity {
    private ListView eVT;
    private Button iIA;
    private Button iIB;
    private Button iIC;
    private Button iID;
    private Button iIE;
    private ArrayAdapter iIy;
    private TextView iIz;

    static /* synthetic */ void a(RoomExptDebugUI roomExptDebugUI) {
        Collection aID = a.aIx().iIl.aID();
        if (aID.size() > 0) {
            roomExptDebugUI.iIy.setNotifyOnChange(false);
            roomExptDebugUI.iIy.clear();
            roomExptDebugUI.iIy.addAll(aID);
        } else {
            roomExptDebugUI.iIy.setNotifyOnChange(false);
            roomExptDebugUI.iIy.clear();
        }
        ah.A(new 8(roomExptDebugUI));
    }

    static /* synthetic */ void b(RoomExptDebugUI roomExptDebugUI) {
        List<c> aIz = a.aIx().aIz();
        Collection arrayList = new ArrayList();
        if (aIz != null) {
            for (c cVar : aIz) {
                arrayList.add(cVar.toString());
            }
        }
        if (arrayList.size() > 0) {
            roomExptDebugUI.iIy.setNotifyOnChange(false);
            roomExptDebugUI.iIy.clear();
            roomExptDebugUI.iIy.addAll(arrayList);
        } else {
            roomExptDebugUI.iIy.setNotifyOnChange(false);
            roomExptDebugUI.iIy.clear();
        }
        ah.A(new 7(roomExptDebugUI));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iIA = (Button) findViewById(b$b.get_db_btn);
        this.iIA.setOnClickListener(new 1(this));
        this.iIB = (Button) findViewById(b$b.calc);
        this.iIB.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                g.Em().H(new 1(this));
            }
        });
        this.iID = (Button) findViewById(b$b.reset_btn);
        this.iID.setOnClickListener(new 3(this));
        this.iIC = (Button) findViewById(b$b.del_db);
        this.iIC.setOnClickListener(new 4(this));
        this.iIE = (Button) findViewById(b$b.show_btn);
        this.iIE.setOnClickListener(new 5(this));
        this.iIz = (TextView) findViewById(b$b.expt_info);
        aIE();
        this.eVT = (ListView) findViewById(b$b.room_list);
        this.iIy = new 6(this, this, c.room_expt_ui_item, b$b.room_expt_ui_tv);
        this.eVT.setAdapter(this.iIy);
    }

    private void aIE() {
        TextView textView = this.iIz;
        a aIx = a.aIx();
        textView.setText(aIx.iIm != null ? aIx.iIm.wF() : "");
    }

    protected final int getLayoutId() {
        return c.activity_room_expt_debug;
    }

    protected void onDestroy() {
        if (this.iIy != null) {
            this.iIy.setNotifyOnChange(false);
            this.iIy.clear();
        }
        super.onDestroy();
    }
}
