package com.tencent.mm.plugin.recharge.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.telephony.PhoneNumberUtils;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils.TruncateAt;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.plugin.recharge.model.b;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public class MallEditText extends LinearLayout implements OnFocusChangeListener {
    private TextView eCM;
    private OnFocusChangeListener eYB;
    private ImageView eYE;
    private String eYF;
    String eYG;
    int eYH;
    public boolean eYJ;
    boolean eYL;
    private int eYM;
    private int eYN;
    private boolean fTt;
    private int gravity;
    private int imeOptions;
    private int inputType;
    private b mpc;
    AutoCompleteTextView mpd;
    boolean mpe;
    private a mpf;
    private List<String[]> mpg;
    private com.tencent.mm.plugin.recharge.model.a mph;
    private Runnable mpi;
    private boolean mpj;
    private int mpk;

    private class a extends BaseAdapter implements Filterable {
        public List<com.tencent.mm.plugin.recharge.model.a> mpm;
        public boolean mpn;
        private List<com.tencent.mm.plugin.recharge.model.a> mpo;
        private a mpp;
        private String mpq;

        private a() {
            this.mpm = new ArrayList();
            this.mpn = false;
        }

        /* synthetic */ a(MallEditText mallEditText, byte b) {
            this();
        }

        public final void bP(List<com.tencent.mm.plugin.recharge.model.a> list) {
            this.mpo = list;
            this.mpm.clear();
            this.mpn = false;
        }

        public final Filter getFilter() {
            x.d("MicroMsg.MallEditText", "getFilter");
            if (this.mpp == null) {
                this.mpp = new a(this, (byte) 0);
            }
            return this.mpp;
        }

        public final int getCount() {
            if (this.mpn) {
                return this.mpm.size() + 2;
            }
            return this.mpm.size() > 0 ? this.mpm.size() + 1 : 0;
        }

        /* renamed from: vg */
        public final synchronized com.tencent.mm.plugin.recharge.model.a getItem(int i) {
            com.tencent.mm.plugin.recharge.model.a aVar = null;
            synchronized (this) {
                if (this.mpn) {
                    if (i != 0) {
                        if (i <= this.mpm.size()) {
                            aVar = (com.tencent.mm.plugin.recharge.model.a) this.mpm.get(i - 1);
                        }
                    }
                } else if (i < this.mpm.size()) {
                    aVar = (com.tencent.mm.plugin.recharge.model.a) this.mpm.get(i);
                }
            }
            return aVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    c cVar;
                    if (view == null) {
                        view = View.inflate(MallEditText.this.getContext(), g.recharge_input_history_item, null);
                        c cVar2 = new c(MallEditText.this, (byte) 0);
                        cVar2.mpu = (TextView) view.findViewById(f.mall_input_record);
                        cVar2.eHU = (TextView) view.findViewById(f.mall_input_name);
                        view.setTag(cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (c) view.getTag();
                    }
                    com.tencent.mm.plugin.recharge.model.a vg = getItem(i);
                    if (vg == null || cVar == null || cVar.mpu == null || cVar.eHU == null) {
                        return view;
                    }
                    CharSequence Km = b.Km(vg.mov);
                    x.d("MicroMsg.MallEditText", "record.record " + Km + ", record.name " + vg.name);
                    if (com.tencent.mm.plugin.recharge.model.a.mot.equals(vg.mox)) {
                        cVar.mpu.setText(Km);
                    } else {
                        CharSequence spannableStringBuilder = new SpannableStringBuilder(Km);
                        for (int i2 : vg.mox) {
                            int i22;
                            if (i22 >= 0) {
                                if (i22 >= 7) {
                                    i22 += 2;
                                } else if (i22 >= 3) {
                                    i22++;
                                }
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(-65536), i22, i22 + 1, 34);
                            }
                        }
                        cVar.mpu.setText(spannableStringBuilder);
                    }
                    if (vg.name == null || bi.oW(vg.name.trim())) {
                        cVar.eHU.setText("");
                    } else {
                        cVar.eHU.setText(MallEditText.this.getResources().getString(a$i.mall_recharge_username, new Object[]{vg.name}));
                    }
                    view.setBackgroundResource(e.comm_list_item_selector);
                    return view;
                case 1:
                    view = View.inflate(MallEditText.this.getContext(), g.recharge_input_history_last_item, null);
                    view.setOnClickListener(new 2(this));
                    return view;
                case 2:
                    view = View.inflate(MallEditText.this.getContext(), g.recharge_input_history_first_item, null);
                    view.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            MallEditText.this.mpd.dismissDropDown();
                        }
                    });
                    return view;
                case 3:
                    View inflate = View.inflate(MallEditText.this.getContext(), g.recharge_input_history_last_item, null);
                    ((TextView) inflate).setText(a$i.mall_recharge_close);
                    inflate.setOnClickListener(new 3(this));
                    return inflate;
                default:
                    return view;
            }
        }

        public final int getItemViewType(int i) {
            if (this.mpn) {
                if (i == 0) {
                    return 2;
                }
                if (i > this.mpm.size()) {
                    return 3;
                }
                return 0;
            } else if (i >= this.mpm.size()) {
                return 1;
            } else {
                return 0;
            }
        }

        public final int getViewTypeCount() {
            return 4;
        }
    }

    public MallEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mpf = null;
        this.eYF = "";
        this.eYG = "";
        this.inputType = 1;
        this.fTt = true;
        this.eYN = -1;
        this.eYM = 1;
        this.gravity = 19;
        this.eYH = -1;
        this.eYL = false;
        this.mph = null;
        this.eYJ = true;
        this.mpi = null;
        this.mpj = false;
        this.mpk = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a$k.MallEditText, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(a$k.MallEditText_mallHint, 0);
        if (resourceId != 0) {
            this.eYF = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(a$k.MallEditText_mallTipmsg, 0);
        if (resourceId != 0) {
            this.eYG = context.getString(resourceId);
        }
        this.inputType = obtainStyledAttributes.getInteger(a$k.MallEditText_android_inputType, 1);
        this.eYJ = obtainStyledAttributes.getBoolean(a$k.MallEditText_android_editable, true);
        this.gravity = obtainStyledAttributes.getInt(a$k.MallEditText_android_gravity, 19);
        this.fTt = obtainStyledAttributes.getBoolean(a$k.MallEditText_android_clickable, true);
        this.eYN = obtainStyledAttributes.getInteger(a$k.MallEditText_android_maxLength, -1);
        this.eYH = obtainStyledAttributes.getInteger(a$k.MallEditText_mallEditType, 0);
        this.imeOptions = obtainStyledAttributes.getInteger(a$k.MallEditText_android_imeOptions, 5);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(g.recharge_edit_text, this, true);
        this.eCM = (TextView) inflate.findViewById(f.username_tv);
        this.mpd = (AutoCompleteTextView) inflate.findViewById(f.hint_et);
        if (com.tencent.mm.bp.a.fi(context)) {
            this.mpd.setTextSize(0, ((float) context.getResources().getDimensionPixelSize(d.NormalTextSize)) * 1.25f);
        } else {
            this.mpd.setTextSize(0, (float) com.tencent.mm.bp.a.ad(context, d.NormalTextSize));
        }
        this.eYE = (ImageView) inflate.findViewById(f.info_iv);
        x.d("MicroMsg.MallEditText", "setFormat editType:" + this.eYH);
        this.mpd.setImeOptions(this.imeOptions);
        switch (this.eYH) {
            case 0:
                if (!this.eYJ) {
                    this.eYE.setImageResource(e.mm_submenu);
                    this.eYE.setVisibility(0);
                    break;
                }
                break;
            case 1:
                this.eYM = 13;
                this.eYN = 13;
                this.inputType = 2;
                setInfoTvImageResource(e.recharge_phone_contact);
                this.eYE.setVisibility(0);
                break;
        }
        this.inputType = 1;
        this.mpd.addTextChangedListener(new 1(this));
        this.mpd.setOnFocusChangeListener(this);
        if (!bi.oW(this.eYF)) {
            this.mpd.setHint(this.eYF);
        }
        if (this.inputType == 2) {
            this.mpd.setKeyListener(new NumberKeyListener() {
                public final int getInputType() {
                    return 3;
                }

                protected final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ' '};
                }
            });
        } else {
            this.mpd.setInputType(this.inputType);
            this.mpd.setRawInputType(this.inputType);
        }
        this.mpd.setGravity(this.gravity);
        if (!this.fTt) {
            this.mpd.setEnabled(false);
            this.mpd.setTextColor(getResources().getColor(c.black));
            this.mpd.setFocusable(false);
            this.mpd.setClickable(false);
        }
        if (this.eYJ) {
            this.eYL = false;
        } else {
            this.eYL = true;
            this.mpd.setEnabled(false);
            this.mpd.setFocusable(false);
            this.mpd.setClickable(false);
        }
        if (this.eYN != -1) {
            this.mpd.setFilters(new InputFilter[]{new LengthFilter(this.eYN)});
        }
        x.d("MicroMsg.MallEditText", "initData editType:" + this.eYH);
        switch (this.eYH) {
            case 1:
                x.d("MicroMsg.MallEditText", "setMobileEditTv");
                List bpW = com.tencent.mm.plugin.recharge.a.a.bpV().bpW();
                this.mpf = new a(this, (byte) 0);
                this.mpf.bP(bpW);
                if (bpW != null && bpW.size() > 0) {
                    this.mph = (com.tencent.mm.plugin.recharge.model.a) bpW.get(0);
                    setInput(this.mph);
                } else if (this.mpg == null) {
                    new Runnable() {
                        public final void run() {
                            try {
                                MallEditText.this.mpg = com.tencent.mm.pluginsdk.a.cz(MallEditText.this.getContext());
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.MallEditText", e, "", new Object[0]);
                            }
                        }
                    }.run();
                }
                if (bpW == null || bpW.size() == 0) {
                    com.tencent.mm.kernel.g.Ek();
                    this.mpd.setText((String) com.tencent.mm.kernel.g.Ei().DT().get(6, null));
                    this.mpd.setSelection(this.mpd.getText().length());
                    bpZ();
                }
                this.mpd.setAdapter(this.mpf);
                this.mpd.setOnItemClickListener(new 4(this));
                return;
            default:
                return;
        }
    }

    public MallEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setOnInputValidChangeListener(b bVar) {
        this.mpc = bVar;
    }

    public void setHintStr(String str) {
        this.mpd.setHint(str);
    }

    public void setInfoTvOnClickListener(OnClickListener onClickListener) {
        this.eYE.setOnClickListener(onClickListener);
    }

    public void setInfoTvImageResource(int i) {
        this.mpe = i == e.list_clear;
        this.eYE.setImageResource(i);
    }

    public void setInput(com.tencent.mm.plugin.recharge.model.a aVar) {
        this.mph = aVar;
        if (aVar != null) {
            this.mpd.setText(aVar.mov);
            this.mpd.setSelection(this.mpd.getText().length());
            bpZ();
            x.d("MicroMsg.MallEditText", "editTv.setText " + aVar.mov + ", name " + aVar.name + ", isInputValid " + this.eYL);
            if (bi.oW(aVar.name) || !this.eYL) {
                this.eCM.setText("");
                this.eCM.setVisibility(8);
                return;
            }
            this.eCM.setText(aVar.name);
            this.eCM.setVisibility(0);
            return;
        }
        this.mpd.setText("");
        bpZ();
        x.d("MicroMsg.MallEditText", "editTv.setText null");
        this.eCM.setText("");
        this.eCM.setVisibility(8);
    }

    private void setInputForce(com.tencent.mm.plugin.recharge.model.a aVar) {
        this.mph = aVar;
        if (aVar != null) {
            KeyListener keyListener = this.mpd.getKeyListener();
            this.mpd.setKeyListener(null);
            this.mpd.setText(aVar.mov);
            this.mpd.setSelection(this.mpd.getText().length());
            this.mpd.setKeyListener(keyListener);
            bpZ();
            x.d("MicroMsg.MallEditText", "editTv.setText " + aVar.mov + ", name " + aVar.name + ", isInputValid " + this.eYL);
            if (bi.oW(aVar.name) || !this.eYL) {
                this.eCM.setText("");
                this.eCM.setVisibility(8);
                return;
            }
            this.eCM.setText(aVar.name);
            this.eCM.setVisibility(0);
            return;
        }
        this.mpd.setText("");
        bpZ();
        x.d("MicroMsg.MallEditText", "editTv.setText null");
        this.eCM.setText("");
        this.eCM.setVisibility(8);
    }

    private void bpZ() {
        boolean ZF = ZF();
        if (ZF != this.eYL) {
            x.d("MicroMsg.MallEditText", "View:" + this.eYG + ", editType:" + this.eYH + " inputValid change to " + ZF);
            this.eYL = ZF;
            if (this.mpc != null) {
                this.mpc.fE(this.eYL);
            }
            if (!ZF) {
                if (this.eCM.getVisibility() == 0) {
                    this.eCM.setText("");
                    this.eCM.setVisibility(8);
                }
                this.mph = null;
            }
        }
        if (this.mpc != null) {
            this.mpc.bqa();
        }
    }

    public String getText() {
        switch (this.eYH) {
            case 1:
                return bi.aG(this.mpd.getText().toString(), "");
            default:
                return bi.aG(this.mpd.getText().toString(), "");
        }
    }

    public final boolean ZF() {
        switch (this.eYH) {
            case 1:
                String obj = this.mpd.getText().toString();
                if (obj.length() < this.eYM || obj.length() > this.eYN || !PhoneNumberUtils.isGlobalPhoneNumber(b.pK(obj))) {
                    return false;
                }
                return true;
            default:
                if (this.mpd.getText().length() >= this.eYM) {
                    return true;
                }
                return false;
        }
    }

    public void setEllipsize(TruncateAt truncateAt) {
        this.mpd.setEllipsize(truncateAt);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.eYJ) {
            return false;
        }
        return true;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.mpd.setOnClickListener(onClickListener);
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.eYB = onFocusChangeListener;
    }

    public void onFocusChange(View view, boolean z) {
        if (this.eYB != null) {
            this.eYB.onFocusChange(this, z);
        }
        if (!((!this.mpj) != z || z || this.mpi == null)) {
            this.mpi.run();
        }
        this.mpj = z;
        x.d("MicroMsg.MallEditText", "View:" + this.eYG + ", editType:" + this.eYH + " onFocusChange to " + z);
        if (this.mpc != null) {
            this.mpc.fE(this.eYL);
        }
    }

    public void setImeOptions(int i) {
        this.mpd.setImeOptions(i);
    }

    public void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        this.mpd.setOnEditorActionListener(onEditorActionListener);
    }

    public com.tencent.mm.plugin.recharge.model.a getInputRecord() {
        if (this.mph != null) {
            return this.mph;
        }
        this.mph = new com.tencent.mm.plugin.recharge.model.a(getText(), this.eCM.getText().toString(), 0);
        return this.mph;
    }

    public void getFocus() {
        this.mpd.findFocus();
    }
}
