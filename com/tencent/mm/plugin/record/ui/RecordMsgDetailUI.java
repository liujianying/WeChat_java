package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ab.f;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.g.a;
import java.util.Iterator;

public class RecordMsgDetailUI extends RecordMsgBaseUI {
    private long bJC = -1;
    private boolean bUY = true;
    private String bXN = null;
    private p fUo = null;
    private c msX = null;
    private boolean msY = false;
    private String msZ = "";
    private String mta = "";
    private String title = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void bqA() {
        this.bJC = getIntent().getLongExtra("message_id", -1);
        this.bXN = getIntent().getStringExtra("record_xml");
        this.bUY = getIntent().getBooleanExtra("record_show_share", true);
        this.msY = getIntent().getBooleanExtra("big_appmsg", false);
        this.msX = h.Ks(this.bXN);
        if (this.msX != null) {
            if (a(this.msX) != null) {
                this.title = a(this.msX);
            } else {
                this.title = this.msX.title;
            }
            if (!bi.cX(this.msX.dzs)) {
                this.msZ = ((vx) this.msX.dzs.getFirst()).rAm;
                this.mta = ((vx) this.msX.dzs.getLast()).rAm;
            }
        } else {
            au.HU();
            bd dW = com.tencent.mm.model.c.FT().dW(this.bJC);
            a J = a.J(dW.field_content, dW.field_reserved);
            if (J != null) {
                this.title = J.title;
                this.fUo = p.b(this, getString(R.l.loading_tips), true, 0, null);
            }
        }
        if (this.bXN == null || this.msX == null) {
            bqI();
            setBackBtn(new 1(this));
            if (this.msY && ao.asF().fH(this.bJC) != null) {
                au.HU();
                au.DF().a(new ac(this.bJC, com.tencent.mm.model.c.FT().dW(this.bJC).field_msgSvrId, new f() {
                    public final void a(int i, int i2, l lVar) {
                        if (i == i2) {
                            if (RecordMsgDetailUI.this.fUo != null) {
                                RecordMsgDetailUI.this.fUo.dismiss();
                                RecordMsgDetailUI.this.fUo = null;
                            }
                            au.HU();
                            bd dW = com.tencent.mm.model.c.FT().dW(RecordMsgDetailUI.this.bJC);
                            String str = dW.field_content;
                            if (s.fq(dW.field_talker)) {
                                str = com.tencent.mm.model.bd.iC(dW.field_content);
                            }
                            a gp = a.gp(str);
                            if (gp != null) {
                                RecordMsgDetailUI.this.bXN = gp.dwW;
                                RecordMsgDetailUI.this.msX = h.Ks(RecordMsgDetailUI.this.bXN);
                                if (RecordMsgDetailUI.this.msX != null) {
                                    if (RecordMsgDetailUI.this.a(RecordMsgDetailUI.this.msX) != null) {
                                        RecordMsgDetailUI.this.title = RecordMsgDetailUI.this.a(RecordMsgDetailUI.this.msX);
                                    } else {
                                        RecordMsgDetailUI.this.title = RecordMsgDetailUI.this.msX.title;
                                    }
                                    RecordMsgDetailUI.this.msZ = ((vx) RecordMsgDetailUI.this.msX.dzs.getFirst()).rAm;
                                    RecordMsgDetailUI.this.mta = ((vx) RecordMsgDetailUI.this.msX.dzs.getLast()).rAm;
                                }
                                RecordMsgDetailUI.this.aL();
                            }
                        }
                    }
                }), 0);
                return;
            }
            return;
        }
        aL();
    }

    private String a(c cVar) {
        String str = null;
        if (cVar == null) {
            return null;
        }
        String str2;
        Iterator it = cVar.dzs.iterator();
        int i = 0;
        String str3 = null;
        String str4 = null;
        while (true) {
            str2 = str;
            if (!it.hasNext()) {
                break;
            }
            vx vxVar = (vx) it.next();
            if (vxVar.rAi.rAJ.rBh != null) {
                str = this.mController.tml.getString(R.l.record_chatroom_title);
                i = 1;
            } else {
                if (vxVar.rAi.rAJ.bSS != null) {
                    if (str4 == null) {
                        str = vxVar.rAk;
                    } else if (str4 != vxVar.rAk) {
                        str = vxVar.rAk;
                    }
                }
                str = str3;
            }
        }
        if (str4 != null && str3 == null && i == 0) {
            return this.mController.tml.getString(R.l.favorite_record_chatroom_title, new Object[]{str4});
        } else if (str4 == null || str3 == null || str4.equals(str3) || i != 0) {
            return str2;
        } else {
            return this.mController.tml.getString(R.l.favorite_record_chat_title, new Object[]{str4, str3});
        }
    }

    private void aL() {
        f fVar = new f();
        fVar.msv = this.msX.dzs;
        fVar.bJC = this.bJC;
        fVar.bXN = this.bXN;
        super.bqA();
        this.msU.a(fVar);
        n.getRecordMsgCDNStorage().a((e) this.msU);
    }

    protected final h bqB() {
        e eVar = new e(this, new g());
        eVar.fromScene = getIntent().getIntExtra("from_scene", 0);
        return eVar;
    }

    protected void onDestroy() {
        super.onDestroy();
        n.getRecordMsgCDNStorage().b((e) this.msU);
    }

    protected final String bqC() {
        return this.title;
    }

    protected final String bqD() {
        return this.msZ;
    }

    protected final String bqE() {
        return this.mta;
    }

    protected final void bqF() {
        if (this.bUY) {
            addIconOptionMenu(0, R.g.mm_title_btn_menu, new 3(this));
        }
    }

    protected final void c(int i, int i2, Intent intent) {
        if (-1 != i2) {
            x.e("MicroMsg.RecordMsgDetailUI", "processResult %d", new Object[]{Integer.valueOf(i2)});
        } else if (1001 == i) {
            final String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            final String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
            if (bi.oW(stringExtra)) {
                x.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but toUser is null");
                return;
            }
            au.HU();
            final bd dW = com.tencent.mm.model.c.FT().dW(this.bJC);
            if (dW.field_msgId != this.bJC) {
                x.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but message info is null");
                return;
            }
            final p a = com.tencent.mm.ui.base.h.a(this.mController.tml, getString(R.l.favorite_forward_tips), false, null);
            au.Em().H(new Runnable() {
                public final void run() {
                    h.a(stringExtra, stringExtra2, dW);
                    ah.A(new Runnable() {
                        public final void run() {
                            a.dismiss();
                        }
                    });
                }

                public final String toString() {
                    return super.toString() + "|onActivityResult";
                }
            });
        } else if (1002 == i && intent.getBooleanExtra("kfavorite", false)) {
            ch chVar = new ch();
            e.a(chVar, intent);
            chVar.bJF.activity = this;
            chVar.bJF.bJM = 8;
            com.tencent.mm.sdk.b.a.sFg.m(chVar);
        }
    }
}
