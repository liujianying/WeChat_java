package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.protocal.c.boh;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ay;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.y;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public class SnsMsgUI extends DrawStatusBarActivity implements e, b {
    private String dIc;
    private long dRd = 0;
    private int dYK;
    private long dkA = 0;
    private View gvO;
    private View hFL = null;
    private boolean hFM = false;
    private ag handler = af.aRu();
    private d hlb = new 5(this);
    private ListView kww;
    private View kwy;
    int nJg;
    private ao nLP;
    private SnsCmdList nND = new SnsCmdList();
    private ay nUe;
    private a nYb;
    private boolean nYc = false;
    private boolean nYd = false;
    private boolean nYe = false;
    private p nYf;
    private int[] nYg = new int[2];
    private OnClickListener nYh = new 1(this);
    private a nYi = new 10(this);
    private j.a nYj = new 8(this);
    Runnable nYk = new 9(this);
    long nvb;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.Ek();
        g.Eh().dpP.a(210, this);
        g.Ek();
        g.Eh().dpP.a(683, this);
        g.Ek();
        g.Eh().dpP.a(TbsListener$ErrorCode.INCR_UPDATE_EXCEPTION, this);
        this.dIc = q.GF();
        this.nUe = af.byc();
        this.nYd = getIntent().getBooleanExtra("sns_msg_force_show_all", false);
        if (this.nYd) {
            this.hFM = true;
        }
        af.byt().c(this.nYj);
        lF(this.mController.cqm());
        initView();
    }

    public void onDestroy() {
        x.d("MicroMsg.SnsMsgUI", "msgui onDestroy");
        af.byt().axe();
        g.Ek();
        g.Eh().dpP.b(210, this);
        g.Ek();
        g.Eh().dpP.b(683, this);
        g.Ek();
        g.Eh().dpP.b(TbsListener$ErrorCode.INCR_UPDATE_EXCEPTION, this);
        af.byt().d(this.nYj);
        this.nYb.aYc();
        af.byl().H(this);
        if (this.nYf != null) {
            this.nYf.dismiss();
            this.nYf = null;
        }
        super.onDestroy();
    }

    public void onResume() {
        this.dRd = bi.VE();
        ((com.tencent.matrix.trace.a) com.tencent.matrix.a.tg().g(com.tencent.matrix.trace.a.class)).bsV.a(this.nYi);
        af.byj().a((b) this);
        super.onResume();
    }

    public void onPause() {
        HardCoderJNI.stopPerformace(HardCoderJNI.hcSNSMsgScrollEnable, this.dYK);
        this.dYK = 0;
        af.byj().b((b) this);
        super.onPause();
        ((com.tencent.matrix.trace.a) com.tencent.matrix.a.tg().g(com.tencent.matrix.trace.a.class)).bsV.b(this.nYi);
        this.dRd = bi.VE() > this.dRd ? bi.VE() - this.dRd : 1;
        HardCoderJNI.reportFPS(Downloads.DOWNLOAD_ERR_TOTAL_SIZE_NOT_SAME, HardCoderJNI.hcSNSMsgScrollAction, 1, this.dkA, this.dRd);
        this.dkA = 0;
        this.dRd = 0;
    }

    protected final int getLayoutId() {
        return i.g.sns_msg_ui;
    }

    protected final void initView() {
        setMMTitle(i.j.sns_msgui_title);
        addTextOptionMenu(0, getString(i.j.app_clear), new 11(this));
        this.nLP = new ao(this);
        this.kwy = findViewById(f.sns_msg_empty_view);
        this.kww = (ListView) findViewById(f.sns_msg_list);
        this.gvO = y.gq(this).inflate(i.g.sns_msg_footer, null);
        this.hFL = y.gq(this).inflate(i.g.mm_footerview, null);
        x.d("MicroMsg.SnsMsgUI", "autoLoad " + this.hFM);
        if (this.hFM) {
            this.kww.addFooterView(this.hFL);
        } else {
            this.kww.addFooterView(this.gvO);
        }
        this.nYb = new a(this, this, new com.tencent.mm.plugin.sns.storage.j());
        this.nYb.setGetViewPositionCallback(new 12(this));
        this.nYb.setPerformItemClickListener(new 13(this));
        this.nYb.b(new 14(this));
        this.nYb.tlG = new 15(this);
        this.kww.setAdapter(this.nYb);
        this.kww.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == SnsMsgUI.this.nYb.getCount()) {
                    int i2;
                    if (af.byt().axd() > 0) {
                        af.byt().axe();
                        i2 = SnsMsgUI.this.nYb.ayQ() ? 0 : 1;
                    } else {
                        i2 = SnsMsgUI.this.nYb.ayR();
                    }
                    SnsMsgUI.this.nYb.a(null, null);
                    if (!SnsMsgUI.this.hFM) {
                        if (SnsMsgUI.this.gvO.getParent() != null) {
                            x.d("MicroMsg.SnsMsgUI", "remove footer");
                            SnsMsgUI.this.kww.removeFooterView(SnsMsgUI.this.gvO);
                        }
                        if (SnsMsgUI.this.hFL.getParent() == null && i2 > 0) {
                            SnsMsgUI.this.kww.addFooterView(SnsMsgUI.this.hFL);
                            x.i("MicroMsg.SnsMsgUI", "add mLoadingFooterView");
                        }
                    }
                    SnsMsgUI.this.hFM = true;
                    SnsMsgUI.this.gvO.setVisibility(8);
                    return;
                }
                SnsMsgUI.a(SnsMsgUI.this, (com.tencent.mm.plugin.sns.storage.j) SnsMsgUI.this.nYb.getItem(i));
            }
        });
        k kVar = new k(this);
        this.kww.setOnTouchListener(new 17(this));
        this.kww.setOnItemLongClickListener(new 2(this));
        this.kww.setOnScrollListener(new 3(this));
        if (this.nYb.getCount() == 0) {
            this.kww.setVisibility(8);
            this.kwy.setVisibility(0);
            enableOptionMenu(false);
        } else {
            this.kww.setVisibility(0);
            this.kwy.setVisibility(8);
            enableOptionMenu(true);
        }
        if ((this.nYb.ayQ() && af.byt().axd() == 0) || af.byt().axd() == af.byt().bAQ()) {
            this.gvO.setVisibility(8);
        }
        if (this.nYb.ayQ() && this.hFM) {
            this.kww.removeFooterView(this.hFL);
        }
        setBackBtn(new 4(this));
        if (this.nYb.ayQ() && this.hFM) {
            this.kww.removeFooterView(this.hFL);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        com.tencent.mm.plugin.sns.storage.j jVar = (com.tencent.mm.plugin.sns.storage.j) this.nYb.getItem(adapterContextMenuInfo.position);
        if (jVar != null) {
            this.nJg = jVar.nJg;
            this.nvb = jVar.field_snsID;
            try {
                boh boh = (boh) new boh().aG(jVar.field_curActionBuf);
                if (boh != null) {
                    String BL;
                    ab Yg = this.nUe.Yg(boh.seC);
                    if (Yg != null) {
                        BL = Yg.BL();
                    } else if (bi.oW(boh.sme)) {
                        BL = boh.seC;
                    } else {
                        BL = boh.sme;
                    }
                    contextMenu.setHeaderTitle(bi.oV(BL));
                    if (jVar.field_isSilence == 0) {
                        contextMenu.add(adapterContextMenuInfo.position, 1, 1, getString(i.j.notification_sns_msg_not_remind));
                    } else {
                        contextMenu.add(adapterContextMenuInfo.position, 2, 1, getString(i.j.notification_sns_msg_do_remind));
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsMsgUI", e, "", new Object[0]);
            }
            contextMenu.add(adapterContextMenuInfo.position, 0, 0, getString(i.j.app_delete));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SnsMsgUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            if (intent != null && intent.getBooleanExtra("result_finish", false)) {
                finish();
            } else if (intent != null) {
                this.nND.wj(intent.getIntExtra("sns_gallery_op_id", 0));
            }
        }
    }

    public final void LR(String str) {
        this.nYb.notifyDataSetChanged();
    }

    public final void aS(String str, boolean z) {
    }

    public final void bxb() {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        x.d("MicroMsg.SnsMsgUI", "dispatchKeyEvent");
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", this.nND);
        setResult(-1, intent);
        finish();
        return true;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0 && (lVar instanceof com.tencent.mm.plugin.sns.model.q)) {
            x.d("MicroMsg.SnsMsgUI", "onSceneEnd errtype errcode");
            if (!this.nYc) {
                this.nYc = true;
                this.handler.postDelayed(this.nYk, 500);
            } else {
                return;
            }
        }
        if (lVar.getType() == TbsListener$ErrorCode.INCR_UPDATE_EXCEPTION && ((r) lVar).type == 12) {
            if (i == 0 && i2 == 0) {
                this.nYb.a(null, null);
                Toast.makeText(this, getString(i.j.notification_sns_msg_set_suc), 0).show();
            } else {
                Toast.makeText(this, getString(i.j.notification_sns_msg_set_failed), 0).show();
            }
            if (this.nYf != null) {
                this.nYf.dismiss();
                this.nYf = null;
            }
        }
    }

    public final void aT(String str, boolean z) {
    }
}
