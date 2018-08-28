package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.c;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.b.b.w;
import com.tencent.mm.ui.chatting.v;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.tools.o.b;
import java.util.ArrayList;

@a(cwo = w.class)
public class ad extends a implements w {
    private o eMS = null;
    private v tRA;
    public boolean tRB = false;
    private boolean tRC = true;
    private int tRD = 0;
    public boolean tRE = false;
    private boolean tRF = false;
    private View tRp;
    public boolean tRq = false;
    public boolean tRr = false;
    public boolean tRs = false;
    public boolean tRt = false;
    private long tRu = -1;
    private ArrayList<String> tRv;
    public boolean tRw = false;
    private TextView tRx;
    private ListView tRy;
    private View tRz;

    public final ArrayList<String> cvK() {
        return this.tRv;
    }

    public final boolean gA(long j) {
        if (this.tRu != j || !this.tRt || this.tRv == null || this.tRv.size() <= 0) {
            return false;
        }
        return true;
    }

    public final boolean cvL() {
        return this.tRs;
    }

    public final void cvM() {
        String str = "MicroMsg.ChattingUI.SearchComponent";
        String str2 = "enter edit search mode, search stub view is null?%B";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.tRp == null);
        x.v(str, str2, objArr);
        this.tRB = true;
        this.bAG.EW(8);
        if (this.tRp != null) {
            this.tRp.setVisibility(0);
            if (this.tRA != null) {
                this.tRA.talker = this.bAG.getTalkerUserName();
            }
        } else {
            i.a(this.bAG.tTq, R.h.search_chat_content_ly);
            this.tRp = this.bAG.findViewById(R.h.search_content);
            this.tRp.setVisibility(0);
            this.tRz = this.bAG.findViewById(R.h.search_chat_content_bg);
            this.bAG.getListView().setFocusable(false);
            this.bAG.getListView().setFocusableInTouchMode(false);
            this.tRz.setOnClickListener(new 2(this));
            this.tRz.setVisibility(8);
            this.tRx = (TextView) this.bAG.findViewById(R.h.empty_search_result_tv);
            boolean z = s.fq(this.bAG.getTalkerUserName()) || ((c) this.bAG.O(c.class)).cus();
            this.tRA = new v(this.bAG.tTq.getContext(), new bd(), this.bAG.getTalkerUserName(), this.bAG.cwp(), z);
            this.tRA.tLf = new 3(this);
            this.tRy = (ListView) this.bAG.findViewById(R.h.search_chat_content_lv);
            this.tRy.setVisibility(0);
            this.tRy.setAdapter(this.tRA);
            this.tRy.setOnItemClickListener(new 4(this));
            this.tRy.setOnTouchListener(new 5(this));
        }
        Fd(-1);
    }

    public final void cvN() {
        x.v("MicroMsg.ChattingUI.SearchComponent", "exit edit search mode");
        this.tRB = false;
        this.tRC = true;
        if (this.tRx != null) {
            this.tRx.setVisibility(8);
        }
        if (this.tRz != null) {
            this.tRz.setVisibility(8);
        }
        if (this.tRy != null) {
            this.tRy.setVisibility(8);
        }
        this.bAG.EW(0);
        this.bAG.YC();
    }

    public final boolean cvO() {
        return this.tRB;
    }

    public final void Fd(int i) {
        x.i("MicroMsg.ChattingUI.SearchComponent", "search result count %d, in edit mode %B, can report %B", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.tRB), Boolean.valueOf(this.tRC)});
        if (this.tRq || this.tRB) {
            if (this.tRC && i >= 0) {
                this.tRC = false;
                h.mEJ.h(10811, new Object[]{Integer.valueOf(2)});
            }
            if (i > 0) {
                this.tRy.setVisibility(0);
                this.bAG.EW(8);
                this.tRx.setVisibility(8);
                this.tRz.setVisibility(8);
                return;
            } else if (i == 0) {
                this.tRy.setVisibility(8);
                this.bAG.EW(8);
                this.tRx.setVisibility(0);
                this.tRz.setVisibility(8);
                return;
            } else {
                this.tRy.setVisibility(8);
                this.bAG.EW(0);
                this.tRx.setVisibility(8);
                this.tRz.setVisibility(0);
                return;
            }
        }
        x.d("MicroMsg.ChattingUI.SearchComponent", "not search now");
    }

    public final v cvP() {
        return this.tRA;
    }

    public final boolean cvQ() {
        return this.tRr;
    }

    public final boolean cvR() {
        return this.tRq;
    }

    public final boolean cvS() {
        return this.tRt;
    }

    public final boolean cvT() {
        return this.tRw;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (((g) this.bAG.O(g.class)).isInEditMode() && this.tRB) {
            cvN();
        }
    }

    public final void cun() {
        super.cun();
        this.tRF = true;
        if (this.tRA != null) {
            this.tRA.aYc();
        }
        if (this.eMS != null) {
            this.eMS.clearFocus();
        }
    }

    public final void cpF() {
        this.tRE = this.bAG.tTq.getBooleanExtra("need_hight_item", false).booleanValue();
        this.tRq = this.bAG.tTq.getBooleanExtra("search_chat_content", false).booleanValue();
        this.tRr = this.bAG.tTq.getBooleanExtra("show_search_chat_content_result", false).booleanValue();
        this.tRv = this.bAG.tTq.getStringArrayList("highlight_keyword_list");
        this.tRu = this.bAG.tTq.getLongExtra("msg_local_id", -1);
        this.tRt = this.bAG.tTq.getBooleanExtra("from_global_search", false).booleanValue();
        this.tRs = this.bAG.tTq.getBooleanExtra("img_gallery_enter_from_chatting_ui", false).booleanValue();
    }

    public final void cpG() {
        if (this.tRu >= 0 && !this.tRF) {
            ah.i(new 1(this), 2000);
        }
        if (this.tRq) {
            boolean z;
            h.mEJ.a(219, 11, 1, true);
            i.a(this.bAG.tTq, R.h.search_chat_content_ly);
            this.tRp = this.bAG.findViewById(R.h.search_content);
            this.tRz = this.bAG.findViewById(R.h.search_chat_content_bg);
            this.bAG.getListView().setFocusable(false);
            this.bAG.getListView().setFocusableInTouchMode(false);
            this.tRz.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                }
            });
            if (this.tRx == null) {
                i.a(this.bAG.tTq, R.h.viewstub_empty_search);
                this.tRx = (TextView) this.bAG.findViewById(R.h.empty_search_result_tv);
            }
            if (s.fq(this.bAG.getTalkerUserName()) || ((c) this.bAG.O(c.class)).cus()) {
                z = true;
            } else {
                z = false;
            }
            this.tRA = new v(this.bAG.tTq.getContext(), new bd(), this.bAG.getTalkerUserName(), this.bAG.cwp(), z);
            this.tRA.tLf = new 7(this);
            this.tRy = (ListView) this.bAG.findViewById(R.h.search_chat_content_lv);
            this.tRy.setAdapter(this.tRA);
            this.tRy.setOnItemClickListener(new 8(this));
            this.tRy.setOnTouchListener(new 9(this));
            this.eMS = new o();
            this.eMS.uBw = new b() {
                private int tRI = 0;

                public final void pk(String str) {
                    if (bi.oW(str)) {
                        this.tRI = 0;
                        ad.this.Fd(-1);
                        return;
                    }
                    if (str.length() > this.tRI) {
                        h.mEJ.h(10451, new Object[]{Integer.valueOf(1)});
                    }
                    this.tRI = str.length();
                    h.mEJ.h(10456, new Object[]{Integer.valueOf(1)});
                    ad.this.tRA.pi(str);
                }

                public final void WW() {
                    new ag().post(new 1(this));
                }

                public final void WX() {
                }

                public final boolean pj(String str) {
                    return false;
                }

                public final void WY() {
                }

                public final void WZ() {
                }
            };
            this.bAG.tTq.addSearchMenu(true, this.eMS);
            this.eMS.mv(true);
        }
        if (this.tRr || this.tRt) {
            final long longExtra = this.bAG.tTq.getLongExtra("msg_local_id", -1);
            final int t = ((g) this.bAG.O(g.class)).t(longExtra, this.tRt);
            Window window = this.bAG.tTq.getWindow();
            if (window != null) {
                window.getDecorView().post(new 11(this, longExtra, t));
            } else {
                this.bAG.getListView().postDelayed(new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.ChattingUI.SearchComponent", "if (isShowSearchChatResult || isFromGlobalSearch) on set position %d, set selection %d", new Object[]{Long.valueOf(longExtra), Integer.valueOf(t)});
                        ad.this.bAG.EV(t);
                        if (ad.this.tRE && !ad.this.tRt) {
                            new ag().postDelayed(/* anonymous class already generated */, 200);
                            au.HU();
                            com.tencent.mm.model.c.DT().a(aa.a.sSm, Boolean.valueOf(false));
                        }
                    }
                }, 100);
            }
        }
    }

    public final void cpJ() {
        if (this.tRB) {
            cvN();
            ((com.tencent.mm.ui.chatting.b.b.h) this.bAG.O(com.tencent.mm.ui.chatting.b.b.h.class)).cuT();
        }
    }
}
