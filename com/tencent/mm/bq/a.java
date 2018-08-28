package com.tencent.mm.bq;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Picture;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class a extends Resources {
    private static Method sCC = null;
    private static Method sCD = null;
    private Resources mResources;
    private c sCA;
    private boolean sCB;
    private e sCz;

    private a(Resources resources, e eVar, c cVar) {
        c cVar2;
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.sCz = eVar;
        if (resources instanceof a) {
            this.mResources = ((a) resources).mResources;
        } else {
            this.mResources = resources;
        }
        this.mResources = resources;
        this.sCA = cVar;
        try {
            Field declaredField;
            Class cls = Class.forName("android.content.res.MiuiResources");
            if (cls != null) {
                x.i("MicroMsg.MMResources", "sMiuiThemeEnabled false");
                declaredField = cls.getDeclaredField("sMiuiThemeEnabled");
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    declaredField.set(null, Boolean.valueOf(false));
                    cVar2 = new c(getAssets(), "mThemeCookies", null);
                    if (cVar2.zR()) {
                        cVar2.set(new a());
                    }
                    this.sCB = ad.chZ().getBoolean("ShowStringName", false);
                }
            }
            declaredField = null;
            x.e("MicroMsg.MMResources", "some thing wrong. %s %s", new Object[]{cls, declaredField});
        } catch (ClassNotFoundException e) {
            x.i("MicroMsg.MMResources", "sMiuiThemeEnabled ClassNotFoundException");
        } catch (NoSuchFieldException e2) {
            x.i("MicroMsg.MMResources", "sMiuiThemeEnabled NoSuchFieldException");
        } catch (IllegalAccessException e3) {
            x.i("MicroMsg.MMResources", "sMiuiThemeEnabled IllegalAccessException");
        } catch (IllegalArgumentException e4) {
            x.i("MicroMsg.MMResources", "sMiuiThemeEnabled IllegalArgumentException");
        }
        cVar2 = new c(getAssets(), "mThemeCookies", null);
        try {
            if (cVar2.zR()) {
                cVar2.set(new a());
            }
        } catch (Throwable e5) {
            x.printErrStackTrace("MicroMsg.MMResources", e5, "", new Object[0]);
        } catch (Throwable e52) {
            x.printErrStackTrace("MicroMsg.MMResources", e52, "", new Object[0]);
        } catch (Throwable e522) {
            x.printErrStackTrace("MicroMsg.MMResources", e522, "", new Object[0]);
        }
        try {
            this.sCB = ad.chZ().getBoolean("ShowStringName", false);
        } catch (Exception e6) {
            x.e("MicroMsg.MMResources", e6.getMessage());
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        x.i("MicroMsg.MMResources", "locale %s, orientation %s", new Object[]{configuration.locale, Integer.valueOf(configuration.orientation)});
        super.updateConfiguration(configuration, this.mResources.getDisplayMetrics());
    }

    public final void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, displayMetrics);
        }
    }

    public static Resources a(Resources resources, Context context) {
        return new a(resources, e.fm(context), new c());
    }

    public static Resources a(Resources resources, Context context, String str) {
        return new a(resources, e.bq(context, str), new c());
    }

    private boolean cgE() {
        return this.sCz != null && e.cgE();
    }

    public final CharSequence getText(int i) {
        if (this.sCB) {
            return this.mResources.getResourceEntryName(i);
        }
        CharSequence d;
        if (cgE()) {
            d = e.d(i, e.getString(i));
            if (d != null) {
                return d;
            }
        }
        d = e.d(i, this.mResources.getString(i));
        if (d != null) {
            return d.toString();
        }
        return this.mResources.getString(i);
    }

    public final CharSequence getText(int i, CharSequence charSequence) {
        if (this.sCB) {
            return this.mResources.getResourceEntryName(i);
        }
        CharSequence d;
        if (cgE()) {
            d = e.d(i, e.getString(i));
            if (d != null) {
                return d;
            }
        }
        d = e.d(i, this.mResources.getString(i));
        if (d != null) {
            return d.toString();
        }
        return this.mResources.getString(i);
    }

    public final String getString(int i) {
        if (this.sCB) {
            return this.mResources.getResourceEntryName(i);
        }
        CharSequence string;
        if (cgE()) {
            string = e.getString(i);
            if (string != null) {
                return e.d(i, string.toString()).toString();
            }
        }
        try {
            string = e.d(i, this.mResources.getString(i));
            if (string != null) {
                return string.toString();
            }
            return this.mResources.getString(i);
        } catch (Exception e) {
            return "";
        }
    }

    public final String getQuantityString(int i, int i2) {
        if (this.sCB) {
            return this.mResources.getResourceEntryName(i);
        }
        if (cgE()) {
            CharSequence quantityString = e.getQuantityString(i, i2);
            if (quantityString != null) {
                return quantityString.toString();
            }
        }
        return this.mResources.getQuantityString(i, i2);
    }

    public final String getQuantityString(int i, int i2, Object... objArr) {
        if (this.sCB) {
            return this.mResources.getResourceEntryName(i);
        }
        if (cgE()) {
            CharSequence quantityString = e.getQuantityString(i, i2, objArr);
            if (quantityString != null) {
                return quantityString.toString();
            }
        }
        return this.mResources.getQuantityString(i, i2, objArr);
    }

    public final CharSequence getQuantityText(int i, int i2) {
        if (this.sCB) {
            return this.mResources.getResourceEntryName(i);
        }
        if (cgE()) {
            CharSequence quantityString = e.getQuantityString(i, i2);
            if (quantityString != null) {
                return quantityString.toString();
            }
        }
        return this.mResources.getQuantityString(i, i2);
    }

    public final String[] getStringArray(int i) {
        if (cgE()) {
            String[] stringArray = e.getStringArray(i);
            if (stringArray != null) {
                return stringArray;
            }
        }
        return super.getStringArray(i);
    }

    public final CharSequence[] getTextArray(int i) {
        CharSequence[] stringArray = getStringArray(i);
        return stringArray != null ? stringArray : super.getTextArray(i);
    }

    public final TypedArray obtainTypedArray(int i) {
        return this.mResources.obtainTypedArray(i);
    }

    public final Drawable getDrawable(int i) {
        if (i != 0) {
            Drawable c = this.sCA.c(this.mResources, i);
            if (c != null) {
                return c;
            }
        }
        return d(super.getDrawable(i), i);
    }

    @TargetApi(21)
    public final Drawable getDrawable(int i, Theme theme) {
        if (i != 0) {
            Drawable c = this.sCA.c(this.mResources, i);
            if (c != null) {
                return c;
            }
        }
        return d(super.getDrawable(i, theme), i);
    }

    public final Drawable getDrawableForDensity(int i, int i2) {
        if (i != 0) {
            Drawable c = this.sCA.c(this.mResources, i);
            if (c != null) {
                return c;
            }
        }
        return d(super.getDrawableForDensity(i, i2), i);
    }

    @TargetApi(22)
    public final Drawable getDrawableForDensity(int i, int i2, Theme theme) {
        if (i != 0) {
            Drawable c = this.sCA.c(this.mResources, i);
            if (c != null) {
                return c;
            }
        }
        return d(super.getDrawableForDensity(i, i2, theme), i);
    }

    private Drawable d(Drawable drawable, int i) {
        if (drawable != null) {
            return drawable;
        }
        x.l("MicroMsg.MMResources", "Notice!!! drawable == null!!!", new Object[0]);
        try {
            if (this.sCA.sCI.d(this, i)) {
                x.e("MicroMsg.MMResources", "resources name = %s, this resource %s", new Object[]{getResourceName(i), this});
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMResources", e, "WTF", new Object[0]);
        }
        return new com.tencent.mm.svg.a.c(new Picture(), 0);
    }

    public static Drawable b(Resources resources, int i) {
        Drawable colorDrawable;
        Method declaredMethod;
        NotFoundException notFoundException;
        boolean z = true;
        TypedValue typedValue = new TypedValue();
        resources.getValue(i, typedValue, true);
        if (typedValue.type < 28 || typedValue.type > 31) {
            z = false;
        }
        if (z) {
            colorDrawable = new ColorDrawable(typedValue.data);
        } else {
            colorDrawable = null;
        }
        if (sCC == null) {
            try {
                declaredMethod = Resources.class.getDeclaredMethod("loadXmlResourceParser", new Class[]{String.class, Integer.TYPE, Integer.TYPE, String.class});
                sCC = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMResources", e, "", new Object[0]);
                x.printErrStackTrace("MicroMsg.MMResources", e, "", new Object[0]);
                return null;
            }
        }
        if (sCD == null) {
            try {
                declaredMethod = AssetManager.class.getDeclaredMethod("openNonAsset", new Class[]{Integer.TYPE, String.class, Integer.TYPE});
                sCD = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MMResources", e2, "", new Object[0]);
                x.printErrStackTrace("MicroMsg.MMResources", e2, "", new Object[0]);
                return null;
            }
        }
        if (colorDrawable == null) {
            if (typedValue.string == null) {
                throw new NotFoundException("Resource is not a Drawable (color or path): " + typedValue);
            }
            String charSequence = typedValue.string.toString();
            Drawable createFromXml;
            if (charSequence.endsWith(".xml")) {
                try {
                    XmlResourceParser xmlResourceParser = (XmlResourceParser) sCC.invoke(resources, new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(typedValue.assetCookie), "drawable"});
                    createFromXml = Drawable.createFromXml(resources, xmlResourceParser);
                    xmlResourceParser.close();
                    colorDrawable = createFromXml;
                } catch (Throwable e22) {
                    notFoundException = new NotFoundException("File " + charSequence + " from drawable resource ID #0x" + Integer.toHexString(i));
                    notFoundException.initCause(e22);
                    throw notFoundException;
                }
            }
            try {
                InputStream inputStream = (InputStream) sCD.invoke(resources.getAssets(), new Object[]{Integer.valueOf(typedValue.assetCookie), charSequence, Integer.valueOf(2)});
                createFromXml = Drawable.createFromResourceStream(resources, typedValue, inputStream, charSequence, null);
                inputStream.close();
                colorDrawable = createFromXml;
            } catch (Throwable e222) {
                notFoundException = new NotFoundException("File " + charSequence + " from drawable resource ID #0x" + Integer.toHexString(i));
                notFoundException.initCause(e222);
                throw notFoundException;
            }
        }
        return colorDrawable;
    }
}
