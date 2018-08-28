package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.aa.f.c;
import com.tencent.mm.aa.q;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import junit.framework.Assert;

public class FriendPreference extends Preference implements c {
    private MMActivity bGc;
    private int bVF;
    private TextView eBO;
    private String eHT;
    private ab guS;
    private boolean iAc;
    private TextView lWL;
    private ImageView lWM;
    private ImageView lWN;
    private a lWO;
    private String lWP;
    private long lWQ;
    private long lWR;

    public final /* synthetic */ CharSequence getSummary() {
        return this.lWL.getText().toString();
    }

    static /* synthetic */ void a(FriendPreference friendPreference, String str) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(268435456);
        intent.setData(Uri.parse("tel:" + str));
        friendPreference.bGc.startActivity(intent);
    }

    public FriendPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGc = (MMActivity) context;
        init();
    }

    public FriendPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.mm_preference);
        setWidgetLayoutResource(R.i.mm_preference_submenu);
        init();
    }

    private void init() {
        this.iAc = false;
        this.guS = null;
        this.lWO = null;
        this.lWP = "";
        this.lWQ = 0;
        this.lWR = 0;
        this.bVF = 0;
        this.eHT = "";
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.mm_preference_content_friend, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        this.eBO = (TextView) view.findViewById(R.h.title);
        this.lWL = (TextView) view.findViewById(R.h.summary);
        this.lWM = (ImageView) view.findViewById(R.h.image_iv);
        this.lWN = (ImageView) view.findViewById(R.h.mobile_preference_more);
        this.iAc = true;
        initView();
        super.onBindView(view);
    }

    private void initView() {
        Bitmap aY;
        InputStream inputStream;
        Bitmap decodeStream;
        Bitmap createScaledBitmap;
        if (this.guS == null || !this.iAc) {
            x.d("MicroMsg.FriendPreference", "initView : contact = " + this.guS + " bindView = " + this.iAc);
        } else if (this.lWQ != -1 && new o(this.lWQ).longValue() > 0) {
            setWidgetLayoutResource(R.i.mm_preference_submenu_qzone);
            if (this.guS == null || !this.iAc) {
                x.d("MicroMsg.FriendPreference", "initView : contact = " + this.guS + " bindView = " + this.iAc);
                return;
            }
            this.bVF = 2;
            this.eBO.setText(this.mContext.getString(R.l.contact_info_friendtype_qq));
            this.lWL.setText(bi.oV(this.lWP) + " " + new o(this.lWQ).longValue());
            aY = com.tencent.mm.aa.c.aY(this.lWQ);
            if (aY == null) {
                inputStream = null;
                try {
                    inputStream = this.mContext.getResources().openRawResource(R.k.default_qq_avatar);
                    decodeStream = com.tencent.mm.compatible.g.a.decodeStream(inputStream);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.FriendPreference", e, "", new Object[0]);
                        }
                    }
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.FriendPreference", e2, "", new Object[0]);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            decodeStream = aY;
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.FriendPreference", e22, "", new Object[0]);
                            decodeStream = aY;
                        }
                    }
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e3) {
                            x.printErrStackTrace("MicroMsg.FriendPreference", e3, "", new Object[0]);
                        }
                    }
                }
                if (decodeStream != null) {
                    createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, 48, 48, false);
                    if (createScaledBitmap != decodeStream) {
                        decodeStream.recycle();
                    }
                    this.lWM.setImageBitmap(com.tencent.mm.sdk.platformtools.c.a(createScaledBitmap, true, 0.0f));
                }
                au.HU();
                if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                    this.lWM.setBackgroundDrawable(com.tencent.mm.bp.a.f(this.bGc, R.k.default_avatar));
                }
            }
            decodeStream = aY;
            if (decodeStream != null) {
                createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, 48, 48, false);
                if (createScaledBitmap != decodeStream) {
                    decodeStream.recycle();
                }
                this.lWM.setImageBitmap(com.tencent.mm.sdk.platformtools.c.a(createScaledBitmap, true, 0.0f));
            }
            au.HU();
            if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                this.lWM.setBackgroundDrawable(com.tencent.mm.bp.a.f(this.bGc, R.k.default_avatar));
            }
        } else if (this.lWO != null) {
            setWidgetLayoutResource(R.i.mm_preference_more);
            if (this.guS == null || !this.iAc) {
                x.d("MicroMsg.FriendPreference", "initView : contact = " + this.guS + " bindView = " + this.iAc);
            } else if (this.lWO != null) {
                this.bVF = 1;
                this.eBO.setText(this.mContext.getString(R.l.contact_info_friendtype_mobile));
                Object obj = bi.oV(this.lWO.Xj()) + " " + bi.oV(this.lWO.Xp()).replace(" ", "");
                this.lWL.setText(obj);
                createScaledBitmap = l.b(this.lWO.Xi(), this.mContext);
                if (createScaledBitmap == null) {
                    this.lWM.setImageDrawable(com.tencent.mm.bp.a.f(this.bGc, R.k.default_mobile_avatar));
                } else {
                    this.lWM.setImageBitmap(com.tencent.mm.sdk.platformtools.c.a(Bitmap.createScaledBitmap(createScaledBitmap, 48, 48, false), true, 0.0f));
                }
                au.HU();
                if (com.tencent.mm.model.c.FR().Yc(this.lWO.getUsername())) {
                    this.lWN.setOnClickListener(new 1(this, obj));
                } else {
                    this.lWN.setVisibility(4);
                }
            }
        } else if (this.lWR > 0) {
            if (this.guS == null || !this.iAc) {
                x.d("MicroMsg.FriendPreference", "initView : contact = " + this.guS + " bindView = " + this.iAc);
                return;
            }
            this.bVF = 3;
            this.eBO.setText(this.mContext.getString(R.l.hardcode_plugin_facebookapp_nick));
            this.lWL.setText(bi.oV(this.guS.csB));
            aY = com.tencent.mm.aa.c.jI(this.lWR);
            if (aY == null) {
                inputStream = null;
                try {
                    inputStream = this.mContext.getResources().openRawResource(R.k.default_qq_avatar);
                    decodeStream = com.tencent.mm.compatible.g.a.decodeStream(inputStream);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e32) {
                            x.printErrStackTrace("MicroMsg.FriendPreference", e32, "", new Object[0]);
                        }
                    }
                } catch (Throwable e222) {
                    x.printErrStackTrace("MicroMsg.FriendPreference", e222, "", new Object[0]);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            decodeStream = aY;
                        } catch (Throwable e2222) {
                            x.printErrStackTrace("MicroMsg.FriendPreference", e2222, "", new Object[0]);
                            decodeStream = aY;
                        }
                    }
                } catch (Throwable th2) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e322) {
                            x.printErrStackTrace("MicroMsg.FriendPreference", e322, "", new Object[0]);
                        }
                    }
                }
                if (decodeStream != null) {
                    createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, 48, 48, false);
                    if (createScaledBitmap != decodeStream) {
                        decodeStream.recycle();
                    }
                    this.lWM.setImageBitmap(com.tencent.mm.sdk.platformtools.c.a(createScaledBitmap, true, 0.0f));
                }
                au.HU();
                if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                    this.lWM.setBackgroundDrawable(com.tencent.mm.bp.a.f(this.bGc, R.k.default_avatar));
                }
            }
            decodeStream = aY;
            if (decodeStream != null) {
                createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, 48, 48, false);
                if (createScaledBitmap != decodeStream) {
                    decodeStream.recycle();
                }
                this.lWM.setImageBitmap(com.tencent.mm.sdk.platformtools.c.a(createScaledBitmap, true, 0.0f));
            }
            au.HU();
            if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                this.lWM.setBackgroundDrawable(com.tencent.mm.bp.a.f(this.bGc, R.k.default_avatar));
            }
        } else if (TextUtils.isEmpty(this.eHT)) {
            Assert.assertTrue(false);
        } else if (this.guS == null || !this.iAc) {
            x.d("MicroMsg.FriendPreference", "initView : contact = " + this.guS + " bindView = " + this.iAc);
        } else {
            this.bVF = 3;
            this.eBO.setText(this.mContext.getString(R.l.regby_email_address));
            this.lWL.setText(bi.oV(this.eHT));
            this.lWM.setVisibility(8);
        }
    }

    private boolean q(String str, Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return l.a(str, this.mContext, byteArrayOutputStream.toByteArray());
    }

    public final boolean auw() {
        q.Kp().e(this);
        return true;
    }

    public final void jX(String str) {
        long jK = com.tencent.mm.aa.c.jK(str);
        if (jK > 0 && this.lWQ == jK && com.tencent.mm.aa.c.a(str, false, -1) != null) {
            initView();
        }
        if (com.tencent.mm.aa.c.jJ(str) == this.lWR && com.tencent.mm.aa.c.a(str, false, -1) != null) {
            initView();
        }
    }
}
