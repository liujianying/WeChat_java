package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.m;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bw.a$f;
import com.tencent.mm.bw.a.c;
import com.tencent.mm.bw.a.e;
import com.tencent.mm.bw.a.g;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class BaseActivity extends AppCompatActivity {
    private TextView gFb;
    private ImageView hBu;
    private TextView iDE;
    private ActionBar mActionBar;
    private Context mContext;
    private boolean mQO = false;
    private View tgo;
    private int tgp = 0;
    private ImageButton tgq;
    private ImageButton tgr;
    private TextView tgs;
    private MenuItem tgt;
    private MenuItem tgu;
    private int tgv;
    private int tgw;
    private int tgx;
    private int tgy = a.tgD;
    LinkedList<b> tgz = new LinkedList();

    protected abstract int getLayoutId();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getLayoutId());
        this.mContext = this;
        this.mActionBar = getSupportActionBar();
        if (this.mActionBar != null) {
            this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
            this.mActionBar.da();
            this.mActionBar.setDisplayHomeAsUpEnabled(false);
            this.mActionBar.cZ();
            this.mActionBar.db();
            this.mActionBar.setCustomView(LayoutInflater.from(this).inflate(g.actionbar_title, null));
            if (this.tgp == 0) {
                this.tgp = this.mContext.getResources().getColor(c.normal_actionbar_color);
            }
            this.mQO = an.Ec(this.tgp);
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.tgp));
            this.iDE = (TextView) findViewById(16908308);
            this.gFb = (TextView) findViewById(16908309);
            this.tgo = findViewById(a$f.actionbar_up_indicator);
            this.hBu = (ImageView) findViewById(a$f.actionbar_up_indicator_btn);
            setTitle("WeUI");
            setBackBtn(new 1(this));
        }
        if (VERSION.SDK_INT >= 21) {
            if (this.tgp == 0) {
                this.tgp = this.mContext.getResources().getColor(c.normal_actionbar_color);
            }
            Window window = getWindow();
            window.clearFlags(201326592);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(an.n(this.mContext.getResources().getColor(c.statusbar_fg_color), this.tgp));
            if (VERSION.SDK_INT >= 23) {
                View decorView = getWindow().getDecorView();
                int systemUiVisibility = decorView.getSystemUiVisibility();
                decorView.setSystemUiVisibility(this.mQO ? systemUiVisibility & -8193 : systemUiVisibility | 8192);
            }
        }
    }

    public final void setBackBtn(OnMenuItemClickListener onMenuItemClickListener) {
        int i = a.tgD;
        if (this.mActionBar != null) {
            this.mActionBar.setDisplayHomeAsUpEnabled(false);
            if (this.tgo != null) {
                this.tgo.setVisibility(0);
                this.tgo.setOnClickListener(new 2(this, onMenuItemClickListener));
            }
            this.tgy = i;
            if (this.tgy == a.tgF) {
                this.tgv = 0;
            }
            if (this.tgy == a.tgD) {
                this.tgv = e.actionbar_icon_dark_back;
            } else if (this.tgy == a.tgE) {
                this.tgv = e.actionbar_icon_dark_close;
            }
            if (this.hBu != null && this.tgv != 0) {
                if (this.hBu != null) {
                    this.hBu.setVisibility(0);
                }
                this.hBu.setImageResource(this.tgv);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (this.mActionBar != null && this.iDE != null) {
            this.iDE.setText(charSequence.toString());
            if (this.iDE == null) {
                return;
            }
            if (this.mQO) {
                this.iDE.setTextColor(this.mContext.getResources().getColor(c.actionbar_title_light_color));
            } else {
                this.iDE.setTextColor(this.mContext.getResources().getColor(c.actionbar_title_color));
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        int i;
        ao.s("on create option menu, menuCache size:%d", new Object[]{Integer.valueOf(this.tgz.size())});
        if (this.mActionBar == null || this.tgz.size() == 0) {
            ao.u("error, mActionBar is null or cache size:%d", new Object[]{Integer.valueOf(this.tgz.size())});
            i = 0;
        } else {
            Iterator it = this.tgz.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar.tgH != 16908332) {
                    if (bVar.tgM == c.tgS) {
                        this.tgt = menu.add(0, bVar.tgH, 0, bVar.text);
                        3 3 = new 3(this, bVar);
                        if (bVar.tgL == null) {
                            bVar.tgL = View.inflate(this.mContext, g.action_option_view, null);
                        }
                        this.tgr = (ImageButton) bVar.tgL.findViewById(a$f.action_option_icon);
                        this.tgr.setVisibility(0);
                        if (this.tgr != null) {
                            if (this.mQO) {
                                this.tgr.setImageResource(e.actionbar_icon_light_search);
                            } else {
                                this.tgr.setImageResource(e.actionbar_icon_dark_search);
                            }
                        }
                        this.tgr.setOnClickListener(3);
                        this.tgr.setEnabled(bVar.bKe);
                        m.a(this.tgt, bVar.tgL);
                        this.tgt.setEnabled(bVar.bKe);
                        this.tgt.setVisible(bVar.YN);
                    } else {
                        this.tgu = menu.add(0, bVar.tgH, 0, bVar.text);
                        4 4 = new 4(this, bVar);
                        5 5 = new 5(this, bVar);
                        this.tgx = bVar.tgM;
                        if (bVar.tgM == c.tgP || bVar.tgM == c.tgO) {
                            if (bVar.tgJ == null) {
                                bVar.tgJ = View.inflate(this.mContext, g.action_option_view, null);
                            }
                            this.tgs = (TextView) bVar.tgJ.findViewById(a$f.action_option_text);
                            this.tgs.setVisibility(0);
                            this.tgs.setText(bVar.text);
                            if (bVar.tgM == c.tgP) {
                                this.tgs.setTextColor(this.mContext.getResources().getColorStateList(c.green_text_color_selector));
                            } else {
                                coL();
                            }
                            this.tgs.setOnClickListener(4);
                            this.tgs.setOnLongClickListener(5);
                            this.tgs.setEnabled(bVar.bKe);
                            m.a(this.tgu, bVar.tgJ);
                        } else {
                            if (bVar.tgI != 0) {
                                this.tgw = bVar.tgI;
                            }
                            if (bVar.tgM == c.tgT) {
                                this.tgw = 0;
                            }
                            if (bVar.tgK == null) {
                                bVar.tgK = View.inflate(this.mContext, g.action_option_view, null);
                            }
                            this.tgq = (ImageButton) bVar.tgK.findViewById(a$f.action_option_icon);
                            coL();
                            if (this.tgw != 0) {
                                this.tgq.setVisibility(0);
                                this.tgq.setOnClickListener(4);
                                this.tgq.setOnLongClickListener(5);
                                this.tgq.setEnabled(bVar.bKe);
                                m.a(this.tgu, bVar.tgK);
                            }
                        }
                        this.tgu.setEnabled(bVar.bKe);
                        this.tgu.setVisible(bVar.YN);
                    }
                }
            }
            if (this.tgt != null) {
                m.a(this.tgt, 2);
            }
            if (this.tgu != null) {
                m.a(this.tgu, 2);
            }
            i = 1;
        }
        if (i != 0) {
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    private void coL() {
        if (this.tgx != c.tgO) {
            if (this.tgx == c.tgQ) {
                this.tgw = e.actionbar_icon_dark_add;
            } else if (this.tgx == c.tgR) {
                this.tgw = e.actionbar_icon_dark_more;
            } else if (this.tgx == c.tgS) {
                this.tgw = e.actionbar_icon_dark_search;
            }
            if (this.tgq != null && this.tgw != 0) {
                this.tgq.setImageResource(this.tgw);
                if (this.mQO) {
                    this.tgq.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
                } else {
                    this.tgq.getDrawable().setColorFilter(-16777216, Mode.SRC_ATOP);
                }
            }
        } else if (this.tgs != null) {
            if (this.mQO) {
                this.tgs.setTextColor(this.mContext.getResources().getColorStateList(c.white_text_color_selector));
            } else {
                this.tgs.setTextColor(this.mContext.getResources().getColorStateList(c.black_text_color_selector));
            }
        }
    }
}
