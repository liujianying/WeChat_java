package com.tencent.sqlitelint.util;

import java.lang.reflect.Field;

public final class SQLite3ProfileHooker {
    private static volatile boolean vob;

    private static native boolean nativeDoHook();

    private static native void nativeStartProfile();

    private static native void nativeStopProfile();

    public static void cGj() {
        SLog.i("SQLiteLint.SQLite3ProfileHooker", "hook sIsTryHook: %b", Boolean.valueOf(vob));
        nativeStartProfile();
        if (!vob) {
            boolean nativeDoHook;
            if (cGl()) {
                nativeDoHook = nativeDoHook();
            } else {
                SLog.i("SQLiteLint.SQLite3ProfileHooker", "doHook hookOpenSQLite3Profile failed", new Object[0]);
                nativeDoHook = false;
            }
            SLog.i("SQLiteLint.SQLite3ProfileHooker", "hook hookRet: %b", Boolean.valueOf(nativeDoHook));
            vob = true;
        }
    }

    public static void cGk() {
        if (vob) {
            cGm();
            nativeStopProfile();
            SLog.i("SQLiteLint.SQLite3ProfileHooker", "unHook unHookRet: %b", Boolean.valueOf(true));
            vob = false;
        }
    }

    private static boolean cGl() {
        try {
            Class cls = Class.forName("android.database.sqlite.SQLiteDebug");
            Field declaredField = cls.getDeclaredField("DEBUG_SQL_TIME");
            declaredField.setAccessible(true);
            declaredField.setBoolean(cls, true);
            declaredField.setAccessible(false);
            return true;
        } catch (ClassNotFoundException e) {
            SLog.e("SQLiteLint.SQLite3ProfileHooker", "prepareHookBeforeOpenDatabase: e=%s", e.getLocalizedMessage());
        } catch (IllegalAccessException e2) {
            SLog.e("SQLiteLint.SQLite3ProfileHooker", "prepareHookBeforeOpenDatabase: e=%s", e2.getLocalizedMessage());
        } catch (NoSuchFieldException e3) {
            SLog.e("SQLiteLint.SQLite3ProfileHooker", "prepareHookBeforeOpenDatabase: e=%s", e3.getLocalizedMessage());
        }
        return false;
    }

    private static boolean cGm() {
        try {
            Class cls = Class.forName("android.database.sqlite.SQLiteDebug");
            Field declaredField = cls.getDeclaredField("DEBUG_SQL_TIME");
            declaredField.setAccessible(true);
            declaredField.setBoolean(cls, false);
            declaredField.setAccessible(false);
            return true;
        } catch (ClassNotFoundException e) {
            SLog.e("SQLiteLint.SQLite3ProfileHooker", "unHookOpenSQLite3Profile: e=%s", e.getLocalizedMessage());
        } catch (IllegalAccessException e2) {
            SLog.e("SQLiteLint.SQLite3ProfileHooker", "unHookOpenSQLite3Profile: e=%s", e2.getLocalizedMessage());
        } catch (NoSuchFieldException e3) {
            SLog.e("SQLiteLint.SQLite3ProfileHooker", "unHookOpenSQLite3Profile: e=%s", e3.getLocalizedMessage());
        }
        return false;
    }
}
