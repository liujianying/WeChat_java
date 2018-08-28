package android.support.v7.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.g;
import android.support.v4.widget.e;
import android.support.v7.a.a.a;
import android.support.v7.a.a.d;
import android.support.v7.a.a.f;
import android.support.v7.a.a.h;
import android.support.v7.a.a.k;
import android.support.v7.view.c;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import java.util.WeakHashMap;

public class SearchView extends LinearLayoutCompat implements c {
    private static final boolean TM;
    static final a Uw = new a();
    private final OnItemSelectedListener DT;
    private final h Mb;
    private final SearchAutoComplete TN;
    private final View TO;
    private final View TP;
    private final View TQ;
    private final ImageView TR;
    private final ImageView TS;
    private final ImageView TT;
    private final ImageView TU;
    private final View TV;
    private final ImageView TW;
    private final Drawable TX;
    private final int TY;
    private final int TZ;
    private final WeakHashMap<String, ConstantState> UA;
    OnKeyListener UB;
    private final OnEditorActionListener UC;
    private final OnItemClickListener UD;
    private TextWatcher UE;
    private final Intent Ua;
    private final Intent Ub;
    private final CharSequence Uc;
    private c Ud;
    private b Ue;
    private OnFocusChangeListener Uf;
    private d Ug;
    private OnClickListener Uh;
    private boolean Ui;
    private boolean Uj;
    private e Uk;
    private boolean Ul;
    private CharSequence Um;
    private boolean Un;
    private boolean Uo;
    private boolean Up;
    private CharSequence Uq;
    private CharSequence Ur;
    private boolean Us;
    private int Ut;
    private SearchableInfo Uu;
    private Bundle Uv;
    private Runnable Ux;
    private final Runnable Uy;
    private Runnable Uz;
    private int gg;
    private final OnClickListener mOnClickListener;

    static /* synthetic */ void a(SearchView searchView) {
        int[] iArr = searchView.TN.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = searchView.TP.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        background = searchView.TQ.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        searchView.invalidate();
    }

    static /* synthetic */ void d(SearchView searchView) {
        if (searchView.TV.getWidth() > 1) {
            Resources resources = searchView.getContext().getResources();
            int paddingLeft = searchView.TP.getPaddingLeft();
            Rect rect = new Rect();
            boolean bv = at.bv(searchView);
            int dimensionPixelSize = searchView.Ui ? resources.getDimensionPixelSize(d.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(d.abc_dropdownitem_icon_width) : 0;
            searchView.TN.getDropDownBackground().getPadding(rect);
            searchView.TN.setDropDownHorizontalOffset(bv ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            searchView.TN.setDropDownWidth((dimensionPixelSize + ((searchView.TV.getWidth() + rect.left) + rect.right)) - paddingLeft);
        }
    }

    static /* synthetic */ void j(SearchView searchView) {
        CharSequence text = searchView.TN.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (searchView.Ud != null) {
                c cVar = searchView.Ud;
                text.toString();
                if (cVar.gL()) {
                    return;
                }
            }
            if (searchView.Uu != null) {
                searchView.P(text.toString());
            }
            searchView.setImeVisibility(false);
            searchView.TN.dismissDropDown();
        }
    }

    static /* synthetic */ void l(SearchView searchView) {
        String str = null;
        if (searchView.Uu != null) {
            SearchableInfo searchableInfo = searchView.Uu;
            try {
                Intent intent;
                String str2;
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    intent = new Intent(searchView.Ua);
                    ComponentName searchActivity = searchableInfo.getSearchActivity();
                    str2 = "calling_package";
                    if (searchActivity != null) {
                        str = searchActivity.flattenToShortString();
                    }
                    intent.putExtra(str2, str);
                    searchView.getContext().startActivity(intent);
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    String string;
                    Intent intent2 = searchView.Ub;
                    ComponentName searchActivity2 = searchableInfo.getSearchActivity();
                    intent = new Intent("android.intent.action.SEARCH");
                    intent.setComponent(searchActivity2);
                    Parcelable activity = PendingIntent.getActivity(searchView.getContext(), 0, intent, 1073741824);
                    Bundle bundle = new Bundle();
                    if (searchView.Uv != null) {
                        bundle.putParcelable("app_data", searchView.Uv);
                    }
                    Intent intent3 = new Intent(intent2);
                    String str3 = "free_form";
                    int i = 1;
                    if (VERSION.SDK_INT >= 8) {
                        Resources resources = searchView.getResources();
                        if (searchableInfo.getVoiceLanguageModeId() != 0) {
                            str3 = resources.getString(searchableInfo.getVoiceLanguageModeId());
                        }
                        str2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
                        string = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
                        if (searchableInfo.getVoiceMaxResults() != 0) {
                            i = searchableInfo.getVoiceMaxResults();
                        }
                    } else {
                        string = null;
                        str2 = null;
                    }
                    intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", str3);
                    intent3.putExtra("android.speech.extra.PROMPT", str2);
                    intent3.putExtra("android.speech.extra.LANGUAGE", string);
                    intent3.putExtra("android.speech.extra.MAX_RESULTS", i);
                    String str4 = "calling_package";
                    if (searchActivity2 != null) {
                        str = searchActivity2.flattenToShortString();
                    }
                    intent3.putExtra(str4, str);
                    intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
                    intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
                    searchView.getContext().startActivity(intent3);
                }
            } catch (ActivityNotFoundException e) {
            }
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT >= 8) {
            z = true;
        } else {
            z = false;
        }
        TM = z;
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ux = new 1(this);
        this.Uy = new Runnable() {
            public final void run() {
                SearchView.a(SearchView.this);
            }
        };
        this.Uz = new 6(this);
        this.UA = new WeakHashMap();
        this.mOnClickListener = new 10(this);
        this.UB = new 11(this);
        this.UC = new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                SearchView.j(SearchView.this);
                return true;
            }
        };
        this.UD = new 2(this);
        this.DT = new 3(this);
        this.UE = new 4(this);
        this.Mb = h.eJ();
        ap a = ap.a(context, attributeSet, k.SearchView, i);
        LayoutInflater.from(context).inflate(a.getResourceId(k.SearchView_layout, h.abc_search_view), this, true);
        this.TN = (SearchAutoComplete) findViewById(f.search_src_text);
        this.TN.setSearchView(this);
        this.TO = findViewById(f.search_edit_frame);
        this.TP = findViewById(f.search_plate);
        this.TQ = findViewById(f.submit_area);
        this.TR = (ImageView) findViewById(f.search_button);
        this.TS = (ImageView) findViewById(f.search_go_btn);
        this.TT = (ImageView) findViewById(f.search_close_btn);
        this.TU = (ImageView) findViewById(f.search_voice_btn);
        this.TW = (ImageView) findViewById(f.search_mag_icon);
        this.TP.setBackgroundDrawable(a.getDrawable(k.SearchView_queryBackground));
        this.TQ.setBackgroundDrawable(a.getDrawable(k.SearchView_submitBackground));
        this.TR.setImageDrawable(a.getDrawable(k.SearchView_searchIcon));
        this.TS.setImageDrawable(a.getDrawable(k.SearchView_goIcon));
        this.TT.setImageDrawable(a.getDrawable(k.SearchView_closeIcon));
        this.TU.setImageDrawable(a.getDrawable(k.SearchView_voiceIcon));
        this.TW.setImageDrawable(a.getDrawable(k.SearchView_searchIcon));
        this.TX = a.getDrawable(k.SearchView_searchHintIcon);
        this.TY = a.getResourceId(k.SearchView_suggestionRowLayout, h.abc_search_dropdown_item_icons_2line);
        this.TZ = a.getResourceId(k.SearchView_commitIcon, 0);
        this.TR.setOnClickListener(this.mOnClickListener);
        this.TT.setOnClickListener(this.mOnClickListener);
        this.TS.setOnClickListener(this.mOnClickListener);
        this.TU.setOnClickListener(this.mOnClickListener);
        this.TN.setOnClickListener(this.mOnClickListener);
        this.TN.addTextChangedListener(this.UE);
        this.TN.setOnEditorActionListener(this.UC);
        this.TN.setOnItemClickListener(this.UD);
        this.TN.setOnItemSelectedListener(this.DT);
        this.TN.setOnKeyListener(this.UB);
        this.TN.setOnFocusChangeListener(new 7(this));
        setIconifiedByDefault(a.getBoolean(k.SearchView_iconifiedByDefault, true));
        int dimensionPixelSize = a.getDimensionPixelSize(k.SearchView_android_maxWidth, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.Uc = a.getText(k.SearchView_defaultQueryHint);
        this.Um = a.getText(k.SearchView_queryHint);
        dimensionPixelSize = a.getInt(k.SearchView_android_imeOptions, -1);
        if (dimensionPixelSize != -1) {
            setImeOptions(dimensionPixelSize);
        }
        dimensionPixelSize = a.getInt(k.SearchView_android_inputType, -1);
        if (dimensionPixelSize != -1) {
            setInputType(dimensionPixelSize);
        }
        setFocusable(a.getBoolean(k.SearchView_android_focusable, true));
        a.Ww.recycle();
        this.Ua = new Intent("android.speech.action.WEB_SEARCH");
        this.Ua.addFlags(268435456);
        this.Ua.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.Ub = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.Ub.addFlags(268435456);
        this.TV = findViewById(this.TN.getDropDownAnchor());
        if (this.TV != null) {
            if (VERSION.SDK_INT >= 11) {
                this.TV.addOnLayoutChangeListener(new 8(this));
            } else {
                this.TV.getViewTreeObserver().addOnGlobalLayoutListener(new 9(this));
            }
        }
        V(this.Ui);
        gG();
    }

    int getSuggestionRowLayout() {
        return this.TY;
    }

    int getSuggestionCommitIconResId() {
        return this.TZ;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSearchableInfo(android.app.SearchableInfo r9) {
        /*
        r8 = this;
        r4 = 0;
        r7 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r3 = 0;
        r2 = 1;
        r8.Uu = r9;
        r0 = r8.Uu;
        if (r0 == 0) goto L_0x0079;
    L_0x000b:
        r0 = TM;
        if (r0 == 0) goto L_0x0076;
    L_0x000f:
        r0 = r8.TN;
        r1 = r8.Uu;
        r1 = r1.getSuggestThreshold();
        r0.setThreshold(r1);
        r0 = r8.TN;
        r1 = r8.Uu;
        r1 = r1.getImeOptions();
        r0.setImeOptions(r1);
        r0 = r8.Uu;
        r0 = r0.getInputType();
        r1 = r0 & 15;
        if (r1 != r2) goto L_0x003f;
    L_0x002f:
        r1 = -65537; // 0xfffffffffffeffff float:NaN double:NaN;
        r0 = r0 & r1;
        r1 = r8.Uu;
        r1 = r1.getSuggestAuthority();
        if (r1 == 0) goto L_0x003f;
    L_0x003b:
        r0 = r0 | r7;
        r1 = 524288; // 0x80000 float:7.34684E-40 double:2.590327E-318;
        r0 = r0 | r1;
    L_0x003f:
        r1 = r8.TN;
        r1.setInputType(r0);
        r0 = r8.Uk;
        if (r0 == 0) goto L_0x004d;
    L_0x0048:
        r0 = r8.Uk;
        r0.changeCursor(r4);
    L_0x004d:
        r0 = r8.Uu;
        r0 = r0.getSuggestAuthority();
        if (r0 == 0) goto L_0x0076;
    L_0x0055:
        r0 = new android.support.v7.widget.ak;
        r1 = r8.getContext();
        r5 = r8.Uu;
        r6 = r8.UA;
        r0.<init>(r1, r8, r5, r6);
        r8.Uk = r0;
        r0 = r8.TN;
        r1 = r8.Uk;
        r0.setAdapter(r1);
        r0 = r8.Uk;
        r0 = (android.support.v7.widget.ak) r0;
        r1 = r8.Un;
        if (r1 == 0) goto L_0x00ba;
    L_0x0073:
        r1 = 2;
    L_0x0074:
        r0.Vw = r1;
    L_0x0076:
        r8.gG();
    L_0x0079:
        r0 = TM;
        if (r0 == 0) goto L_0x00cb;
    L_0x007d:
        r0 = r8.Uu;
        if (r0 == 0) goto L_0x00c9;
    L_0x0081:
        r0 = r8.Uu;
        r0 = r0.getVoiceSearchEnabled();
        if (r0 == 0) goto L_0x00c9;
    L_0x0089:
        r0 = r8.Uu;
        r0 = r0.getVoiceSearchLaunchWebSearch();
        if (r0 == 0) goto L_0x00bc;
    L_0x0091:
        r0 = r8.Ua;
    L_0x0093:
        if (r0 == 0) goto L_0x00c9;
    L_0x0095:
        r1 = r8.getContext();
        r1 = r1.getPackageManager();
        r0 = r1.resolveActivity(r0, r7);
        if (r0 == 0) goto L_0x00c7;
    L_0x00a3:
        r0 = r2;
    L_0x00a4:
        if (r0 == 0) goto L_0x00cb;
    L_0x00a6:
        r8.Up = r2;
        r0 = r8.Up;
        if (r0 == 0) goto L_0x00b4;
    L_0x00ac:
        r0 = r8.TN;
        r1 = "nm";
        r0.setPrivateImeOptions(r1);
    L_0x00b4:
        r0 = r8.Uj;
        r8.V(r0);
        return;
    L_0x00ba:
        r1 = r2;
        goto L_0x0074;
    L_0x00bc:
        r0 = r8.Uu;
        r0 = r0.getVoiceSearchLaunchRecognizer();
        if (r0 == 0) goto L_0x00cd;
    L_0x00c4:
        r0 = r8.Ub;
        goto L_0x0093;
    L_0x00c7:
        r0 = r3;
        goto L_0x00a4;
    L_0x00c9:
        r0 = r3;
        goto L_0x00a4;
    L_0x00cb:
        r2 = r3;
        goto L_0x00a6;
    L_0x00cd:
        r0 = r4;
        goto L_0x0093;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.setSearchableInfo(android.app.SearchableInfo):void");
    }

    public void setAppSearchData(Bundle bundle) {
        this.Uv = bundle;
    }

    public void setImeOptions(int i) {
        this.TN.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.TN.getImeOptions();
    }

    public void setInputType(int i) {
        this.TN.setInputType(i);
    }

    public int getInputType() {
        return this.TN.getInputType();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.Uo || !isFocusable()) {
            return false;
        }
        if (this.Uj) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.TN.requestFocus(i, rect);
        if (requestFocus) {
            V(false);
        }
        return requestFocus;
    }

    public void clearFocus() {
        this.Uo = true;
        setImeVisibility(false);
        super.clearFocus();
        this.TN.clearFocus();
        this.Uo = false;
    }

    public void setOnQueryTextListener(c cVar) {
        this.Ud = cVar;
    }

    public void setOnCloseListener(b bVar) {
        this.Ue = bVar;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.Uf = onFocusChangeListener;
    }

    public void setOnSuggestionListener(d dVar) {
        this.Ug = dVar;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.Uh = onClickListener;
    }

    public CharSequence getQuery() {
        return this.TN.getText();
    }

    public void setQueryHint(CharSequence charSequence) {
        this.Um = charSequence;
        gG();
    }

    public CharSequence getQueryHint() {
        if (this.Um != null) {
            return this.Um;
        }
        if (!TM || this.Uu == null || this.Uu.getHintId() == 0) {
            return this.Uc;
        }
        return getContext().getText(this.Uu.getHintId());
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.Ui != z) {
            this.Ui = z;
            V(z);
            gG();
        }
    }

    public void setIconified(boolean z) {
        if (z) {
            gH();
        } else {
            gI();
        }
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.Ul = z;
        V(this.Uj);
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.Un = z;
        if (this.Uk instanceof ak) {
            ((ak) this.Uk).Vw = z ? 2 : 1;
        }
    }

    public void setSuggestionsAdapter(e eVar) {
        this.Uk = eVar;
        this.TN.setAdapter(this.Uk);
    }

    public e getSuggestionsAdapter() {
        return this.Uk;
    }

    public void setMaxWidth(int i) {
        this.gg = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.gg;
    }

    protected void onMeasure(int i, int i2) {
        if (this.Uj) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.gg <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.gg, size);
                    break;
                }
            case 0:
                if (this.gg <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.gg;
                    break;
                }
            case 1073741824:
                if (this.gg > 0) {
                    size = Math.min(this.gg, size);
                    break;
                }
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(d.abc_search_view_preferred_width);
    }

    private void V(boolean z) {
        boolean z2;
        boolean z3 = true;
        int i = 8;
        this.Uj = z;
        int i2 = z ? 0 : 8;
        if (TextUtils.isEmpty(this.TN.getText())) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.TR.setVisibility(i2);
        W(z2);
        View view = this.TO;
        if (z) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        view.setVisibility(i2);
        if (!(this.TW.getDrawable() == null || this.Ui)) {
            i = 0;
        }
        this.TW.setVisibility(i);
        gE();
        if (z2) {
            z3 = false;
        }
        X(z3);
        gD();
    }

    private boolean gC() {
        return (this.Ul || this.Up) && !this.Uj;
    }

    private void W(boolean z) {
        int i = 8;
        if (this.Ul && gC() && hasFocus() && (z || !this.Up)) {
            i = 0;
        }
        this.TS.setVisibility(i);
    }

    private void gD() {
        int i = 8;
        if (gC() && (this.TS.getVisibility() == 0 || this.TU.getVisibility() == 0)) {
            i = 0;
        }
        this.TQ.setVisibility(i);
    }

    private void gE() {
        int i = 1;
        int i2 = 0;
        int i3 = !TextUtils.isEmpty(this.TN.getText()) ? 1 : 0;
        if (i3 == 0 && (!this.Ui || this.Us)) {
            i = 0;
        }
        ImageView imageView = this.TT;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.TT.getDrawable();
        if (drawable != null) {
            drawable.setState(i3 != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void gF() {
        post(this.Uy);
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.Uy);
        post(this.Uz);
        super.onDetachedFromWindow();
    }

    private void setImeVisibility(boolean z) {
        if (z) {
            post(this.Ux);
            return;
        }
        removeCallbacks(this.Ux);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    private boolean b(int i, KeyEvent keyEvent) {
        if (this.Uu == null || this.Uk == null || keyEvent.getAction() != 0 || !g.a(keyEvent)) {
            return false;
        }
        if (i == 66 || i == 84 || i == 61) {
            return bz(this.TN.getListSelection());
        }
        if (i != 21 && i != 22) {
            return (i == 19 && this.TN.getListSelection() == 0) ? false : false;
        } else {
            int i2;
            if (i == 21) {
                i2 = 0;
            } else {
                i2 = this.TN.length();
            }
            this.TN.setSelection(i2);
            this.TN.setListSelection(0);
            this.TN.clearListSelection();
            Uw.a(this.TN);
            return true;
        }
    }

    private void gG() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.TN;
        if (queryHint == null) {
            queryHint = "";
        }
        if (this.Ui && this.TX != null) {
            int textSize = (int) (((double) this.TN.getTextSize()) * 1.25d);
            this.TX.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(this.TX), 1, 2, 33);
            spannableStringBuilder.append(queryHint);
            Object obj = spannableStringBuilder;
        }
        searchAutoComplete.setHint(queryHint);
    }

    private void X(boolean z) {
        int i;
        if (this.Up && !this.Uj && z) {
            i = 0;
            this.TS.setVisibility(8);
        } else {
            i = 8;
        }
        this.TU.setVisibility(i);
    }

    private void gH() {
        if (!TextUtils.isEmpty(this.TN.getText())) {
            this.TN.setText("");
            this.TN.requestFocus();
            setImeVisibility(true);
        } else if (!this.Ui) {
        } else {
            if (this.Ue == null || !this.Ue.onClose()) {
                clearFocus();
                V(true);
            }
        }
    }

    private void gI() {
        V(false);
        this.TN.requestFocus();
        setImeVisibility(true);
        if (this.Uh != null) {
            this.Uh.onClick(this);
        }
    }

    final void gJ() {
        V(this.Uj);
        gF();
        if (this.TN.hasFocus()) {
            gK();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        gF();
    }

    public final void onActionViewCollapsed() {
        CharSequence charSequence = "";
        this.TN.setText(charSequence);
        this.TN.setSelection(this.TN.length());
        this.Ur = charSequence;
        clearFocus();
        V(true);
        this.TN.setImeOptions(this.Ut);
        this.Us = false;
    }

    public final void onActionViewExpanded() {
        if (!this.Us) {
            this.Us = true;
            this.Ut = this.TN.getImeOptions();
            this.TN.setImeOptions(this.Ut | 33554432);
            this.TN.setText("");
            setIconified(false);
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.UK = this.Uj;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            V(savedState.UK);
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private boolean bz(int i) {
        if (this.Ug != null && this.Ug.gN()) {
            return false;
        }
        Cursor cursor = this.Uk.yV;
        if (cursor != null && cursor.moveToPosition(i)) {
            Intent b = b(cursor);
            if (b != null) {
                try {
                    getContext().startActivity(b);
                } catch (RuntimeException e) {
                    new StringBuilder("Failed launch activity: ").append(b);
                }
            }
        }
        setImeVisibility(false);
        this.TN.dismissDropDown();
        return true;
    }

    void setQuery(CharSequence charSequence) {
        this.TN.setText(charSequence);
        this.TN.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    private void P(String str) {
        getContext().startActivity(a("android.intent.action.SEARCH", null, null, str));
    }

    private Intent a(String str, Uri uri, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.Ur);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.Uv != null) {
            intent.putExtra("app_data", this.Uv);
        }
        if (TM) {
            intent.setComponent(this.Uu.getSearchActivity());
        }
        return intent;
    }

    private Intent b(Cursor cursor) {
        try {
            String str;
            String a = ak.a(cursor, "suggest_intent_action");
            if (a == null && VERSION.SDK_INT >= 8) {
                a = this.Uu.getSuggestIntentAction();
            }
            if (a == null) {
                str = "android.intent.action.SEARCH";
            } else {
                str = a;
            }
            a = ak.a(cursor, "suggest_intent_data");
            if (TM && a == null) {
                a = this.Uu.getSuggestIntentData();
            }
            if (a != null) {
                String a2 = ak.a(cursor, "suggest_intent_data_id");
                if (a2 != null) {
                    a = a + "/" + Uri.encode(a2);
                }
            }
            return a(str, a == null ? null : Uri.parse(a), ak.a(cursor, "suggest_intent_extra_data"), ak.a(cursor, "suggest_intent_query"));
        } catch (RuntimeException e) {
            int position;
            try {
                position = cursor.getPosition();
            } catch (RuntimeException e2) {
                position = -1;
            }
            new StringBuilder("Search suggestions cursor at row ").append(position).append(" returned exception.");
            return null;
        }
    }

    private void gK() {
        a aVar = Uw;
        SearchAutoComplete searchAutoComplete = this.TN;
        if (aVar.UG != null) {
            try {
                aVar.UG.invoke(searchAutoComplete, new Object[0]);
            } catch (Exception e) {
            }
        }
        aVar = Uw;
        searchAutoComplete = this.TN;
        if (aVar.UH != null) {
            try {
                aVar.UH.invoke(searchAutoComplete, new Object[0]);
            } catch (Exception e2) {
            }
        }
    }

    static boolean S(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
