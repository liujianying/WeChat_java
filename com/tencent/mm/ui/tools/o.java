package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.m;
import android.support.v4.view.m.e;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.j;
import com.tencent.mm.w.a.k;
import java.util.ArrayList;

public class o {
    final String TAG;
    ag dvh;
    MenuItem iZG;
    private boolean uBA;
    public int uBB;
    private int uBC;
    a uBD;
    boolean uBq;
    public boolean uBr;
    private boolean uBs;
    private boolean uBt;
    boolean uBu;
    public e uBv;
    public b uBw;
    private com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a uBx;
    private boolean uBy;
    private ArrayList<String> uBz;

    public interface a {
        void collapseActionView();

        void czR();
    }

    public interface b {
        void WW();

        void WX();

        void WY();

        void WZ();

        boolean pj(String str);

        void pk(String str);
    }

    public o() {
        this.uBq = false;
        this.uBr = false;
        this.uBs = false;
        this.uBt = true;
        this.uBu = true;
        this.iZG = null;
        this.dvh = new ag(Looper.getMainLooper());
        this.uBv = null;
        this.uBy = true;
        this.uBB = k.app_empty_string;
        this.uBC = 0;
        this.uBy = true;
        this.uBq = false;
        this.TAG = "MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis());
    }

    public o(byte b) {
        this.uBq = false;
        this.uBr = false;
        this.uBs = false;
        this.uBt = true;
        this.uBu = true;
        this.iZG = null;
        this.dvh = new ag(Looper.getMainLooper());
        this.uBv = null;
        this.uBy = true;
        this.uBB = k.app_empty_string;
        this.uBC = 0;
        this.uBy = true;
        this.uBq = true;
        this.TAG = "MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis());
    }

    public final String getSearchContent() {
        if (this.uBv != null) {
            return this.uBv.getSearchContent();
        }
        return "";
    }

    public final void setSearchContent(String str) {
        if (this.uBv != null) {
            this.uBv.setSearchContent(str);
        }
    }

    public final void setHint(CharSequence charSequence) {
        if (this.uBv != null) {
            this.uBv.setHint(charSequence);
        }
    }

    public final void clearFocus() {
        if (this.uBv != null) {
            this.uBv.czt();
        }
    }

    public boolean Un() {
        return false;
    }

    public void Uo() {
    }

    public void Up() {
    }

    public final void a(final FragmentActivity fragmentActivity, Menu menu) {
        x.v(this.TAG, "on create options menu");
        if (fragmentActivity == null) {
            x.w(this.TAG, "on add search menu, activity is null");
            return;
        }
        if (this.uBv == null) {
            if (this.uBy) {
                this.uBv = new ActionBarSearchView(fragmentActivity);
            } else {
                this.uBv = new SearchViewNotRealTimeHelper(fragmentActivity);
                this.uBv.setNotRealCallBack(this.uBx);
            }
            this.uBv.setAutoMatchKeywords(this.uBA);
            this.uBv.setKeywords(this.uBz);
        }
        this.uBv.setCallBack(new com.tencent.mm.ui.tools.ActionBarSearchView.b() {
            public final void bad() {
                if (o.this.uBr) {
                    o.this.Uo();
                } else {
                    x.v(o.this.TAG, "onVoiceSearchRequired, but not in searching");
                }
            }

            public final void bac() {
                if (o.this.uBw != null) {
                    o.this.uBw.WZ();
                }
            }

            public final void FW(String str) {
                if (!o.this.uBr) {
                    x.v(o.this.TAG, "onSearchTextChange %s, but not in searching", str);
                } else if (o.this.uBw != null) {
                    o.this.uBw.pk(str);
                }
            }

            public final void WY() {
                if (o.this.uBw != null) {
                    o.this.uBw.WY();
                }
            }
        });
        this.uBv.ms(Un());
        this.uBv.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 != i || o.this.uBw == null) {
                    return false;
                }
                return o.this.uBw.pj(o.this.getSearchContent());
            }
        });
        if (this.uBC != 0) {
            this.uBv.setSearchTipIcon(this.uBC);
        }
        this.iZG = menu.add(0, g.menu_search, 0, this.uBB);
        this.iZG.setEnabled(this.uBt);
        int i = j.actionbar_icon_dark_search;
        if (ad.getContext().getSharedPreferences(ad.chY() + "_redesign", 4).getBoolean("dark_actionbar", false)) {
            i = j.actionbar_icon_light_search;
        }
        this.iZG.setIcon(i);
        m.a(this.iZG, (View) this.uBv);
        if (this.uBq) {
            m.a(this.iZG, 9);
        } else {
            m.a(this.iZG, 2);
        }
        if (this.uBq) {
            m.a(this.iZG, new e() {
                public final boolean onMenuItemActionExpand(MenuItem menuItem) {
                    o.this.a(fragmentActivity, false);
                    return true;
                }

                public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
                    o.this.b(fragmentActivity, false);
                    return true;
                }
            });
        } else {
            this.uBD = new a() {
                public final void czR() {
                    o.this.a(fragmentActivity, true);
                }

                public final void collapseActionView() {
                    o.this.b(fragmentActivity, true);
                }
            };
        }
        this.uBv.setBackClickCallback(new com.tencent.mm.ui.tools.ActionBarSearchView.a() {
            public final void bae() {
                if (o.this.uBq) {
                    if (o.this.iZG != null) {
                        m.c(o.this.iZG);
                    }
                } else if (o.this.uBD != null) {
                    o.this.uBD.collapseActionView();
                }
            }
        });
    }

    public void a(Activity activity, Menu menu) {
        x.v(this.TAG, "on prepare options menu, searchViewExpand %B, triggerExpand %B, canExpand %B", Boolean.valueOf(this.uBr), Boolean.valueOf(this.uBs), Boolean.valueOf(this.uBt));
        if (activity == null) {
            x.w(this.TAG, "on hanle status fail, activity is null");
            return;
        }
        this.iZG = menu.findItem(g.menu_search);
        if (this.iZG == null) {
            x.w(this.TAG, "can not find search menu, error");
            return;
        }
        this.iZG.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });
        b(activity, menu);
    }

    private void b(final Activity activity, Menu menu) {
        if (!this.uBt) {
            return;
        }
        if (this.uBr || this.uBs) {
            this.uBs = false;
            if (activity instanceof MMActivity) {
                ((MMActivity) activity).lF(ad.getContext().getResources().getColor(d.normal_actionbar_color));
            }
            if (menu != null) {
                for (int i = 0; i < menu.size(); i++) {
                    MenuItem item = menu.getItem(i);
                    if (item.getItemId() != g.menu_search) {
                        item.setVisible(false);
                    }
                }
            }
            this.dvh.postDelayed(new Runnable() {
                public final void run() {
                    if (o.this.iZG == null) {
                        x.w(o.this.TAG, "on post expand search menu, but item is null");
                        return;
                    }
                    x.i(o.this.TAG, "try to expand action view, searchViewExpand %B", Boolean.valueOf(o.this.uBr));
                    if (o.this.uBq) {
                        if (!o.this.uBr) {
                            m.b(o.this.iZG);
                        }
                    } else if (o.this.uBD != null) {
                        o.this.uBD.czR();
                    }
                    final View a = m.a(o.this.iZG);
                    if (a != null && o.this.uBr) {
                        a.findViewById(g.edittext).requestFocus();
                        if (o.this.uBu) {
                            o.this.dvh.postDelayed(new Runnable() {
                                public final void run() {
                                    ((InputMethodManager) activity.getSystemService("input_method")).showSoftInput(a.findViewById(g.edittext), 0);
                                }
                            }, 128);
                        }
                    }
                }
            }, 128);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        x.v(this.TAG, "on key down, key code %d, expand %B", Integer.valueOf(i), Boolean.valueOf(this.uBr));
        if (4 != i || !this.uBr) {
            return false;
        }
        czQ();
        return true;
    }

    public final void mv(boolean z) {
        boolean z2 = false;
        String str = this.TAG;
        String str2 = "do expand, expanded[%B], search menu item null[%B]";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.uBr);
        if (this.iZG == null) {
            z2 = true;
        }
        objArr[1] = Boolean.valueOf(z2);
        x.d(str, str2, objArr);
        if (!this.uBr) {
            if (this.uBt) {
                this.uBu = z;
                if (this.iZG != null) {
                    this.dvh.post(new Runnable() {
                        public final void run() {
                            if (o.this.iZG == null) {
                                x.w(o.this.TAG, "post do expand search menu, but search menu item is null");
                            } else if (o.this.uBq) {
                                m.b(o.this.iZG);
                            } else if (o.this.uBD != null) {
                                o.this.uBD.czR();
                            }
                        }
                    });
                    return;
                } else {
                    this.uBs = true;
                    return;
                }
            }
            x.w(this.TAG, "can not expand now");
        }
    }

    public final void czQ() {
        x.d(this.TAG, "do collapse");
        if (this.uBr && this.iZG != null) {
            if (this.uBq) {
                m.c(this.iZG);
            } else if (this.uBD != null) {
                this.uBD.collapseActionView();
            }
        }
    }

    public final boolean czu() {
        if (this.uBv != null) {
            return this.uBv.czu();
        }
        return false;
    }

    public final boolean czv() {
        if (this.uBv != null) {
            return this.uBv.czv();
        }
        return false;
    }

    public final void a(final FragmentActivity fragmentActivity, final boolean z) {
        x.d(this.TAG, "doNewExpand, searchViewExpand " + this.uBr);
        if (!this.uBr) {
            this.uBr = true;
            b((Activity) fragmentActivity, null);
            this.dvh.post(new Runnable() {
                public final void run() {
                    if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                        x.w(o.this.TAG, "want to expand search view, but activity status error");
                    } else if (z) {
                        fragmentActivity.supportInvalidateOptionsMenu();
                    }
                }
            });
            if (this.uBw != null) {
                this.uBw.WX();
            }
        }
    }

    public final void b(final FragmentActivity fragmentActivity, final boolean z) {
        x.d(this.TAG, "doNewCollapse, searchViewExpand " + this.uBr);
        if (this.uBr) {
            this.uBr = false;
            Up();
            if (this.uBv != null) {
                this.uBv.mt(false);
            }
            this.dvh.post(new Runnable() {
                public final void run() {
                    if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                        x.w(o.this.TAG, "want to collapse search view, but activity status error");
                    } else if (z) {
                        fragmentActivity.supportInvalidateOptionsMenu();
                    }
                }
            });
            if (this.uBw != null) {
                this.dvh.post(new Runnable() {
                    public final void run() {
                        if (o.this.uBw != null) {
                            o.this.uBw.WW();
                        }
                    }
                });
            }
        }
        this.dvh.post(new Runnable() {
            public final void run() {
                if (o.this.iZG == null) {
                    x.w(o.this.TAG, "want to collapse search view, but search menu item is null");
                    return;
                }
                if (!(fragmentActivity == null || fragmentActivity.isFinishing())) {
                    FragmentActivity fragmentActivity = fragmentActivity;
                    InputMethodManager inputMethodManager = (InputMethodManager) fragmentActivity.getSystemService("input_method");
                    if (inputMethodManager != null) {
                        View currentFocus = fragmentActivity.getCurrentFocus();
                        if (currentFocus != null) {
                            IBinder windowToken = currentFocus.getWindowToken();
                            if (windowToken != null) {
                                inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                            }
                        }
                    }
                }
                View a = m.a(o.this.iZG);
                if (a != null) {
                    a.findViewById(g.edittext).clearFocus();
                }
            }
        });
    }
}
