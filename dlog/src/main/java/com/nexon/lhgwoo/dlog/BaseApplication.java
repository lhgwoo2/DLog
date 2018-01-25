package com.nexon.lhgwoo.dlog;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;


/**
 * @author  이현기2
 * @brief   디버그 모드에서만 사용할 수 있는 로그 클래스를 위한 baseApplication 클래스
 * @date    2018-01-25 오전 11:13 Copyright   TedPark
 */
public class BaseApplication extends Application {

  public static boolean DEBUG = false;

  @Override
  public void onCreate() {
    super.onCreate();
    this.DEBUG = isDebuggable(this);
  }

  /**
   * @return  boolean
   * @method  isDebuggable
   * @brief   해당 빌드 모드가 디버그 모드 인지 판별.
   * @date    2018-01-25 오전 11:07
   */
  private boolean isDebuggable(Context context) {
    boolean debuggable = false;

    PackageManager pm = context.getPackageManager();
    try {
      ApplicationInfo appinfo = pm.getApplicationInfo(context.getPackageName(), 0);
      debuggable = (0 != (appinfo.flags & ApplicationInfo.FLAG_DEBUGGABLE));
    } catch (NameNotFoundException e) {

    }
    return debuggable;
  }
}
