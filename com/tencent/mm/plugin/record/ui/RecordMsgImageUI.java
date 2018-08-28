package com.tencent.mm.plugin.record.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.plugin.record.b.f;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.k;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@a(3)
public class RecordMsgImageUI extends MMActivity implements c {
    private long bJC = -1;
    private k gcQ;
    private MMGestureGallery hDd;
    private List<vx> hoC = new LinkedList();
    private Map<String, mu> iYQ = new HashMap();
    private com.tencent.mm.sdk.b.c iYS = new 3(this);
    private Runnable iYm = new 2(this);
    private d ioF = new 9(this);
    private f mtf;
    private a mtm;
    private int mtn = 0;
    private String mto = null;

    static /* synthetic */ void d(RecordMsgImageUI recordMsgImageUI) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        arrayList.add(Integer.valueOf(0));
        arrayList2.add(recordMsgImageUI.getString(R.l.retransmits));
        arrayList.add(Integer.valueOf(1));
        arrayList2.add(recordMsgImageUI.getString(R.l.plugin_favorite_opt));
        arrayList.add(Integer.valueOf(2));
        arrayList2.add(recordMsgImageUI.getString(R.l.save_to_local));
        String bqL = recordMsgImageUI.h();
        mu muVar = (mu) recordMsgImageUI.iYQ.get(bqL);
        if (muVar == null) {
            ms msVar = new ms();
            msVar.bXH.filePath = bqL;
            com.tencent.mm.sdk.b.a.sFg.m(msVar);
        } else if (!bi.oW(muVar.bXK.result)) {
            arrayList.add(Integer.valueOf(3));
            arrayList2.add(recordMsgImageUI.getString(com.tencent.mm.plugin.scanner.a.aB(muVar.bXK.bJr, muVar.bXK.result) ? R.l.recog_wxcode_of_image_file : R.l.recog_qbar_of_image_file));
        }
        if (!recordMsgImageUI.isFinishing()) {
            if (recordMsgImageUI.gcQ == null) {
                recordMsgImageUI.gcQ = new k(recordMsgImageUI.mController.tml);
            }
            recordMsgImageUI.gcQ.ofp = new 7(recordMsgImageUI, arrayList, arrayList2);
            recordMsgImageUI.gcQ.ofq = recordMsgImageUI.ioF;
            recordMsgImageUI.gcQ.d(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    RecordMsgImageUI.this.gcQ = null;
                }
            });
            h.a(recordMsgImageUI.mController.tml, recordMsgImageUI.gcQ.bEo());
        }
    }

    static /* synthetic */ void f(RecordMsgImageUI recordMsgImageUI) {
        recordMsgImageUI.mto = recordMsgImageUI.h();
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("image_path", recordMsgImageUI.mto);
        com.tencent.mm.bg.d.b(recordMsgImageUI, ".ui.transmit.SelectConversationUI", intent, TXLiveConstants.PUSH_EVT_CONNECT_SUCC);
    }

    protected final int getLayoutId() {
        return R.i.show_image_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(1024, 1024);
        }
        this.mtf = new f();
        this.bJC = getIntent().getLongExtra("message_id", -1);
        String stringExtra = getIntent().getStringExtra("record_data_id");
        com.tencent.mm.protocal.b.a.c Ks = com.tencent.mm.plugin.record.b.h.Ks(getIntent().getStringExtra("record_xml"));
        if (Ks == null) {
            x.w("MicroMsg.ShowImageUI", "get record msg data error, empty");
            finish();
            return;
        }
        Iterator it = Ks.dzs.iterator();
        while (it.hasNext()) {
            vx vxVar = (vx) it.next();
            if (vxVar.bjS == 2) {
                this.hoC.add(vxVar);
                if (vxVar.jdM.equals(stringExtra)) {
                    this.mtn = this.hoC.size() - 1;
                }
            }
        }
        if (this.hoC.isEmpty()) {
            x.w("MicroMsg.ShowImageUI", "get image data error, empty");
            finish();
            return;
        }
        this.hDd = (MMGestureGallery) findViewById(R.h.gallery);
        this.hDd.setVerticalFadingEdgeEnabled(false);
        this.hDd.setHorizontalFadingEdgeEnabled(false);
        this.mtm = new a((byte) 0);
        this.mtm.hoC = this.hoC;
        this.mtm.bJC = this.bJC;
        this.mtm.mtf = this.mtf;
        this.hDd.setAdapter(this.mtm);
        this.hDd.setSelection(this.mtn);
        this.hDd.setOnItemSelectedListener(new 1(this));
        this.hDd.setSingleClickOverListener(new 4(this));
        this.hDd.setLongClickOverListener(new 5(this));
        fullScreenNoTitleBar(true);
        setBackBtn(new 6(this));
        n.getRecordMsgCDNStorage().a(this);
        com.tencent.mm.sdk.b.a.sFg.b(this.iYS);
    }

    protected void onDestroy() {
        n.getRecordMsgCDNStorage().b(this);
        this.mtf.destory();
        com.tencent.mm.sdk.b.a.sFg.c(this.iYS);
        super.onDestroy();
    }

    /* renamed from: bqL */
    final String h() {
        int selectedItemPosition = this.hDd.getSelectedItemPosition();
        if (-1 == selectedItemPosition) {
            x.w("MicroMsg.ShowImageUI", "error position");
            return null;
        }
        x.d("MicroMsg.ShowImageUI", "cur pos %d path %s", new Object[]{Integer.valueOf(selectedItemPosition), com.tencent.mm.plugin.record.b.h.c(this.mtm.vo(selectedItemPosition), this.bJC)});
        return com.tencent.mm.plugin.record.b.h.c(this.mtm.vo(selectedItemPosition), this.bJC);
    }

    protected final void dealContentView(View view) {
        ak.d(ak.a(getWindow(), null), this.mController.tlX);
        ((ViewGroup) this.mController.tlX.getParent()).removeView(this.mController.tlX);
        ((ViewGroup) getWindow().getDecorView()).addView(this.mController.tlX, 0);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (TXLiveConstants.PUSH_EVT_CONNECT_SUCC == i && -1 == i2) {
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
            if (!bi.oW(stringExtra)) {
                List F = bi.F(stringExtra.split(","));
                if (bi.cX(F)) {
                    x.w("MicroMsg.ShowImageUI", "want to send record msg, but toUser is null");
                    return;
                }
                final p a = h.a(this.mController.tml, getString(R.l.favorite_forward_tips), false, null);
                au.Em().H(new 11(this, F, stringExtra2, new Runnable() {
                    public final void run() {
                        a.dismiss();
                    }
                }));
                return;
            }
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void a(int i, com.tencent.mm.plugin.record.a.f fVar) {
        for (vx vxVar : this.hoC) {
            if (vxVar.jdM.equals(fVar.field_dataId)) {
                ah.A(this.iYm);
                return;
            }
        }
    }
}
