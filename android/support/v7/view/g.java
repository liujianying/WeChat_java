package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.XmlResourceParser;
import android.support.v4.view.d;
import android.support.v4.view.m;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.i;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class g extends MenuInflater {
    private static final Class<?>[] GA;
    private static final Class<?>[] Gz;
    private final Object[] GB;
    private final Object[] GC = this.GB;
    private Object GD;
    private Context mContext;

    private static class a implements OnMenuItemClickListener {
        private static final Class<?>[] GE = new Class[]{MenuItem.class};
        private Object GD;
        private Method mMethod;

        public a(Object obj, String str) {
            this.GD = obj;
            Class cls = obj.getClass();
            try {
                this.mMethod = cls.getMethod(str, GE);
            } catch (Throwable e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.mMethod.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.mMethod.invoke(this.GD, new Object[]{menuItem})).booleanValue();
                }
                this.mMethod.invoke(this.GD, new Object[]{menuItem});
                return true;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class b {
        Menu GF;
        int GG;
        int GH;
        int GI;
        int GJ;
        boolean GK;
        boolean GL;
        boolean GM;
        int GN;
        int GO;
        CharSequence GP;
        CharSequence GQ;
        int GR;
        char GS;
        char GT;
        int GU;
        boolean GV;
        boolean GW;
        boolean GX;
        int GY;
        int GZ;
        String Ha;
        String Hb;
        String Hc;
        d Hd;

        public b(Menu menu) {
            this.GF = menu;
            dv();
        }

        public final void dv() {
            this.GG = 0;
            this.GH = 0;
            this.GI = 0;
            this.GJ = 0;
            this.GK = true;
            this.GL = true;
        }

        static char N(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        final void e(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.GV).setVisible(this.GW).setEnabled(this.GX).setCheckable(this.GU > 0).setTitleCondensed(this.GQ).setIcon(this.GR).setAlphabeticShortcut(this.GS).setNumericShortcut(this.GT);
            if (this.GY >= 0) {
                m.a(menuItem, this.GY);
            }
            if (this.Hc != null) {
                if (g.this.mContext.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.b(g.this), this.Hc));
            }
            if (this.GU >= 2) {
                if (menuItem instanceof h) {
                    ((h) menuItem).K(true);
                } else if (menuItem instanceof i) {
                    i iVar = (i) menuItem;
                    try {
                        if (iVar.IQ == null) {
                            iVar.IQ = ((android.support.v4.c.a.b) iVar.HM).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
                        }
                        iVar.IQ.invoke(iVar.HM, new Object[]{Boolean.valueOf(true)});
                    } catch (Exception e) {
                    }
                }
            }
            if (this.Ha != null) {
                m.a(menuItem, (View) newInstance(this.Ha, g.Gz, g.this.GB));
            } else {
                z = false;
            }
            if (this.GZ > 0 && !z) {
                m.b(menuItem, this.GZ);
            }
            if (this.Hd != null) {
                m.a(menuItem, this.Hd);
            }
        }

        public final SubMenu dw() {
            this.GM = true;
            SubMenu addSubMenu = this.GF.addSubMenu(this.GG, this.GN, this.GO, this.GP);
            e(addSubMenu.getItem());
            return addSubMenu;
        }

        final <T> T newInstance(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor constructor = g.this.mContext.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e) {
                return null;
            }
        }
    }

    static /* synthetic */ Object b(g gVar) {
        if (gVar.GD == null) {
            Object obj = gVar.mContext;
            while (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
                obj = ((ContextWrapper) obj).getBaseContext();
            }
            gVar.GD = obj;
        }
        return gVar.GD;
    }

    static {
        Class[] clsArr = new Class[]{Context.class};
        Gz = clsArr;
        GA = clsArr;
    }

    public g(Context context) {
        super(context);
        this.mContext = context;
        this.GB = new Object[]{context};
    }

    public final void inflate(int i, Menu menu) {
        if (menu instanceof android.support.v4.c.a.a) {
            XmlResourceParser xmlResourceParser = null;
            try {
                xmlResourceParser = this.mContext.getResources().getLayout(i);
                a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (Throwable e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (Throwable e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (Throwable th) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        } else {
            super.inflate(i, menu);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.xmlpull.v1.XmlPullParser r13, android.util.AttributeSet r14, android.view.Menu r15) {
        /*
        r12 = this;
        r5 = 0;
        r2 = 1;
        r7 = 0;
        r8 = new android.support.v7.view.g$b;
        r8.<init>(r15);
        r0 = r13.getEventType();
    L_0x000c:
        r1 = 2;
        if (r0 != r1) goto L_0x0046;
    L_0x000f:
        r0 = r13.getName();
        r1 = "menu";
        r1 = r0.equals(r1);
        if (r1 == 0) goto L_0x0030;
    L_0x001c:
        r0 = r13.next();
    L_0x0020:
        r1 = r7;
        r3 = r5;
        r6 = r7;
        r4 = r0;
    L_0x0024:
        if (r1 != 0) goto L_0x020d;
    L_0x0026:
        switch(r4) {
            case 1: goto L_0x0204;
            case 2: goto L_0x004d;
            case 3: goto L_0x01a3;
            default: goto L_0x0029;
        };
    L_0x0029:
        r0 = r1;
    L_0x002a:
        r4 = r13.next();
        r1 = r0;
        goto L_0x0024;
    L_0x0030:
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r3 = "Expecting menu, got ";
        r2.<init>(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x0046:
        r0 = r13.next();
        if (r0 != r2) goto L_0x000c;
    L_0x004c:
        goto L_0x0020;
    L_0x004d:
        if (r6 != 0) goto L_0x0029;
    L_0x004f:
        r4 = r13.getName();
        r0 = "group";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x009b;
    L_0x005c:
        r0 = r8.He;
        r0 = r0.mContext;
        r4 = android.support.v7.a.a.k.MenuGroup;
        r0 = r0.obtainStyledAttributes(r14, r4);
        r4 = android.support.v7.a.a.k.MenuGroup_android_id;
        r4 = r0.getResourceId(r4, r7);
        r8.GG = r4;
        r4 = android.support.v7.a.a.k.MenuGroup_android_menuCategory;
        r4 = r0.getInt(r4, r7);
        r8.GH = r4;
        r4 = android.support.v7.a.a.k.MenuGroup_android_orderInCategory;
        r4 = r0.getInt(r4, r7);
        r8.GI = r4;
        r4 = android.support.v7.a.a.k.MenuGroup_android_checkableBehavior;
        r4 = r0.getInt(r4, r7);
        r8.GJ = r4;
        r4 = android.support.v7.a.a.k.MenuGroup_android_visible;
        r4 = r0.getBoolean(r4, r2);
        r8.GK = r4;
        r4 = android.support.v7.a.a.k.MenuGroup_android_enabled;
        r4 = r0.getBoolean(r4, r2);
        r8.GL = r4;
        r0.recycle();
        r0 = r1;
        goto L_0x002a;
    L_0x009b:
        r0 = "item";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x018b;
    L_0x00a4:
        r0 = r8.He;
        r0 = r0.mContext;
        r4 = android.support.v7.a.a.k.MenuItem;
        r4 = r0.obtainStyledAttributes(r14, r4);
        r0 = android.support.v7.a.a.k.MenuItem_android_id;
        r0 = r4.getResourceId(r0, r7);
        r8.GN = r0;
        r0 = android.support.v7.a.a.k.MenuItem_android_menuCategory;
        r9 = r8.GH;
        r0 = r4.getInt(r0, r9);
        r9 = android.support.v7.a.a.k.MenuItem_android_orderInCategory;
        r10 = r8.GI;
        r9 = r4.getInt(r9, r10);
        r10 = -65536; // 0xffffffffffff0000 float:NaN double:NaN;
        r0 = r0 & r10;
        r10 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        r9 = r9 & r10;
        r0 = r0 | r9;
        r8.GO = r0;
        r0 = android.support.v7.a.a.k.MenuItem_android_title;
        r0 = r4.getText(r0);
        r8.GP = r0;
        r0 = android.support.v7.a.a.k.MenuItem_android_titleCondensed;
        r0 = r4.getText(r0);
        r8.GQ = r0;
        r0 = android.support.v7.a.a.k.MenuItem_android_icon;
        r0 = r4.getResourceId(r0, r7);
        r8.GR = r0;
        r0 = android.support.v7.a.a.k.MenuItem_android_alphabeticShortcut;
        r0 = r4.getString(r0);
        r0 = android.support.v7.view.g.b.N(r0);
        r8.GS = r0;
        r0 = android.support.v7.a.a.k.MenuItem_android_numericShortcut;
        r0 = r4.getString(r0);
        r0 = android.support.v7.view.g.b.N(r0);
        r8.GT = r0;
        r0 = android.support.v7.a.a.k.MenuItem_android_checkable;
        r0 = r4.hasValue(r0);
        if (r0 == 0) goto L_0x0181;
    L_0x0108:
        r0 = android.support.v7.a.a.k.MenuItem_android_checkable;
        r0 = r4.getBoolean(r0, r7);
        if (r0 == 0) goto L_0x017f;
    L_0x0110:
        r0 = r2;
    L_0x0111:
        r8.GU = r0;
    L_0x0113:
        r0 = android.support.v7.a.a.k.MenuItem_android_checked;
        r0 = r4.getBoolean(r0, r7);
        r8.GV = r0;
        r0 = android.support.v7.a.a.k.MenuItem_android_visible;
        r9 = r8.GK;
        r0 = r4.getBoolean(r0, r9);
        r8.GW = r0;
        r0 = android.support.v7.a.a.k.MenuItem_android_enabled;
        r9 = r8.GL;
        r0 = r4.getBoolean(r0, r9);
        r8.GX = r0;
        r0 = android.support.v7.a.a.k.MenuItem_showAsAction;
        r9 = -1;
        r0 = r4.getInt(r0, r9);
        r8.GY = r0;
        r0 = android.support.v7.a.a.k.MenuItem_android_onClick;
        r0 = r4.getString(r0);
        r8.Hc = r0;
        r0 = android.support.v7.a.a.k.MenuItem_actionLayout;
        r0 = r4.getResourceId(r0, r7);
        r8.GZ = r0;
        r0 = android.support.v7.a.a.k.MenuItem_actionViewClass;
        r0 = r4.getString(r0);
        r8.Ha = r0;
        r0 = android.support.v7.a.a.k.MenuItem_actionProviderClass;
        r0 = r4.getString(r0);
        r8.Hb = r0;
        r0 = r8.Hb;
        if (r0 == 0) goto L_0x0186;
    L_0x015c:
        r0 = r2;
    L_0x015d:
        if (r0 == 0) goto L_0x0188;
    L_0x015f:
        r0 = r8.GZ;
        if (r0 != 0) goto L_0x0188;
    L_0x0163:
        r0 = r8.Ha;
        if (r0 != 0) goto L_0x0188;
    L_0x0167:
        r0 = r8.Hb;
        r9 = GA;
        r10 = r8.He;
        r10 = r10.GC;
        r0 = r8.newInstance(r0, r9, r10);
        r0 = (android.support.v4.view.d) r0;
        r8.Hd = r0;
    L_0x0177:
        r4.recycle();
        r8.GM = r7;
        r0 = r1;
        goto L_0x002a;
    L_0x017f:
        r0 = r7;
        goto L_0x0111;
    L_0x0181:
        r0 = r8.GJ;
        r8.GU = r0;
        goto L_0x0113;
    L_0x0186:
        r0 = r7;
        goto L_0x015d;
    L_0x0188:
        r8.Hd = r5;
        goto L_0x0177;
    L_0x018b:
        r0 = "menu";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x019e;
    L_0x0194:
        r0 = r8.dw();
        r12.a(r13, r14, r0);
        r0 = r1;
        goto L_0x002a;
    L_0x019e:
        r0 = r1;
        r3 = r4;
        r6 = r2;
        goto L_0x002a;
    L_0x01a3:
        r0 = r13.getName();
        if (r6 == 0) goto L_0x01b4;
    L_0x01a9:
        r4 = r0.equals(r3);
        if (r4 == 0) goto L_0x01b4;
    L_0x01af:
        r0 = r1;
        r3 = r5;
        r6 = r7;
        goto L_0x002a;
    L_0x01b4:
        r4 = "group";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x01c3;
    L_0x01bd:
        r8.dv();
        r0 = r1;
        goto L_0x002a;
    L_0x01c3:
        r4 = "item";
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x01f8;
    L_0x01cc:
        r0 = r8.GM;
        if (r0 != 0) goto L_0x0029;
    L_0x01d0:
        r0 = r8.Hd;
        if (r0 == 0) goto L_0x01e2;
    L_0x01d4:
        r0 = r8.Hd;
        r0 = r0.hasSubMenu();
        if (r0 == 0) goto L_0x01e2;
    L_0x01dc:
        r8.dw();
        r0 = r1;
        goto L_0x002a;
    L_0x01e2:
        r8.GM = r2;
        r0 = r8.GF;
        r4 = r8.GG;
        r9 = r8.GN;
        r10 = r8.GO;
        r11 = r8.GP;
        r0 = r0.add(r4, r9, r10, r11);
        r8.e(r0);
        r0 = r1;
        goto L_0x002a;
    L_0x01f8:
        r4 = "menu";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0029;
    L_0x0201:
        r0 = r2;
        goto L_0x002a;
    L_0x0204:
        r0 = new java.lang.RuntimeException;
        r1 = "Unexpected end of document";
        r0.<init>(r1);
        throw r0;
    L_0x020d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.g.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }
}
