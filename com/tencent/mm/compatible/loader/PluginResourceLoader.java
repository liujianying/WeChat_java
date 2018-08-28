package com.tencent.mm.compatible.loader;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.TypedValue;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class PluginResourceLoader extends Resources {
    public Resources dfI;
    private Method dfJ;
    private Method dfK;
    private HashMap<String, ZipFile> dfL;
    private final b<WeakReference<ConstantState>> dfM;

    private XmlResourceParser b(String str, int i, int i2, String str2) {
        try {
            return (XmlResourceParser) this.dfK.invoke(this.dfI, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2});
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.PluginResourceLoader", e, "", new Object[0]);
            return null;
        }
    }

    Drawable loadDrawable(TypedValue typedValue, int i) {
        return a(typedValue, i);
    }

    Drawable loadDrawable(TypedValue typedValue, int i, boolean z) {
        return a(typedValue, i);
    }

    public InputStream openRawResource(int i, TypedValue typedValue) {
        InputStream openRawResource;
        InputStream inputStream = null;
        getValue(i, typedValue, true);
        try {
            openRawResource = super.openRawResource(i, typedValue);
        } catch (Exception e) {
            openRawResource = null;
        }
        if (openRawResource != null) {
            return openRawResource;
        }
        for (Entry value : this.dfL.entrySet()) {
            inputStream = b((ZipFile) value.getValue(), typedValue);
            if (inputStream != null) {
                return inputStream;
            }
        }
        return inputStream;
    }

    private Drawable a(TypedValue typedValue, int i) {
        try {
            return (Drawable) this.dfJ.invoke(this.dfI, new Object[]{typedValue, Integer.valueOf(i)});
        } catch (Exception e) {
        } catch (StackOverflowError e2) {
            x.e("MicroMsg.PluginResourceLoader", "load drawable StackOverflowError");
        }
        Drawable createFromXml;
        try {
            if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
                Object b = b(typedValue.string.toString(), i, typedValue.assetCookie, "drawable");
                createFromXml = Drawable.createFromXml(this, b);
                b.close();
                return createFromXml;
            }
        } catch (Exception e3) {
        }
        for (Entry value : this.dfL.entrySet()) {
            createFromXml = a((ZipFile) value.getValue(), typedValue);
            if (createFromXml != null) {
                return createFromXml;
            }
        }
        x.d("MicroMsg.PluginResourceLoader", "loadFromZipFile null");
        return null;
        while (r1.hasNext()) {
            createFromXml = a((ZipFile) value.getValue(), typedValue);
            if (createFromXml != null) {
                return createFromXml;
            }
        }
        x.d("MicroMsg.PluginResourceLoader", "loadFromZipFile null");
        return null;
    }

    private Drawable a(ZipFile zipFile, TypedValue typedValue) {
        InputStream inputStream = null;
        if (typedValue.string == null) {
            return null;
        }
        Drawable newDrawable;
        long j = ((long) typedValue.data) | (((long) typedValue.assetCookie) << 32);
        b bVar = this.dfM;
        int b = b.b(bVar.tC, bVar.fi, j);
        InputStream inputStream2 = (b < 0 || bVar.tD[b] == b.tA) ? null : bVar.tD[b];
        WeakReference weakReference = (WeakReference) inputStream2;
        if (weakReference != null) {
            ConstantState constantState = (ConstantState) weakReference.get();
            if (constantState != null) {
                newDrawable = constantState.newDrawable(this);
                if (newDrawable == null) {
                    x.v("MicroMsg.PluginResourceLoader", "get form cache");
                    return newDrawable;
                }
                ZipEntry entry;
                Drawable drawable;
                String charSequence = typedValue.string.toString();
                try {
                    x.v("MicroMsg.PluginResourceLoader", "try load drawable from zip, entry=%s, file=%s", new Object[]{charSequence, zipFile.getName()});
                    entry = zipFile.getEntry(charSequence);
                    inputStream = zipFile.getInputStream(entry);
                    newDrawable = Drawable.createFromResourceStream(this, typedValue, inputStream, charSequence);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e2) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            drawable = newDrawable;
                        } catch (Exception e3) {
                            drawable = newDrawable;
                        }
                    }
                } catch (Exception e4) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                } catch (Exception e6) {
                    drawable = newDrawable;
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e7) {
                        }
                    }
                }
                if (newDrawable == null) {
                    inputStream = zipFile.getInputStream(entry);
                    newDrawable = Drawable.createFromStream(inputStream, charSequence);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            drawable = newDrawable;
                        } catch (Exception e8) {
                            drawable = newDrawable;
                        }
                        if (drawable != null) {
                            return drawable;
                        }
                        this.dfM.put(j, new WeakReference(drawable.getConstantState()));
                        return drawable;
                    }
                }
                drawable = newDrawable;
                if (drawable != null) {
                    return drawable;
                }
                this.dfM.put(j, new WeakReference(drawable.getConstantState()));
                return drawable;
            }
            bVar = this.dfM;
            b = b.b(bVar.tC, bVar.fi, j);
            if (b >= 0 && bVar.tD[b] != b.tA) {
                bVar.tD[b] = b.tA;
                bVar.tB = true;
            }
        }
        newDrawable = null;
        if (newDrawable == null) {
            ZipEntry entry2;
            Drawable drawable2;
            String charSequence2 = typedValue.string.toString();
            try {
                x.v("MicroMsg.PluginResourceLoader", "try load drawable from zip, entry=%s, file=%s", new Object[]{charSequence2, zipFile.getName()});
                entry2 = zipFile.getEntry(charSequence2);
                inputStream = zipFile.getInputStream(entry2);
                newDrawable = Drawable.createFromResourceStream(this, typedValue, inputStream, charSequence2);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e9) {
                    }
                }
            } catch (Exception e22) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        drawable2 = newDrawable;
                    } catch (Exception e32) {
                        drawable2 = newDrawable;
                    }
                }
            } catch (Exception e42) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e52) {
                    }
                }
            } catch (Exception e62) {
                drawable2 = newDrawable;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e72) {
                    }
                }
            }
            if (newDrawable == null) {
                inputStream = zipFile.getInputStream(entry2);
                newDrawable = Drawable.createFromStream(inputStream, charSequence2);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        drawable2 = newDrawable;
                    } catch (Exception e82) {
                        drawable2 = newDrawable;
                    }
                    if (drawable2 != null) {
                        return drawable2;
                    }
                    this.dfM.put(j, new WeakReference(drawable2.getConstantState()));
                    return drawable2;
                }
            }
            drawable2 = newDrawable;
            if (drawable2 != null) {
                return drawable2;
            }
            this.dfM.put(j, new WeakReference(drawable2.getConstantState()));
            return drawable2;
        }
        x.v("MicroMsg.PluginResourceLoader", "get form cache");
        return newDrawable;
    }

    private static InputStream b(ZipFile zipFile, TypedValue typedValue) {
        InputStream inputStream = null;
        if (typedValue.string == null) {
            return inputStream;
        }
        try {
            x.d("MicroMsg.PluginResourceLoader", "try load stream from zip, entry=%s, file=%s", new Object[]{typedValue.string.toString(), zipFile.getName()});
            return zipFile.getInputStream(zipFile.getEntry(typedValue.string.toString()));
        } catch (Exception e) {
            return inputStream;
        }
    }
}
