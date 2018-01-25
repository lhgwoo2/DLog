package com.nexon.lhgwoo.dlog;

import android.util.Log;

/**
 *  @brief      Debug 환경에서만 사용할 수 있는 Log클래스
 *  @author     이현기2
 *  @date       2018-01-25 오전 11:24
 *  Copyright   TedPark
 */
public class Dlog {

  static final String TAG = "HyeonGi";

  /** Log Level Error **/
  public static final void e(String message) {
    if (BaseApplication.DEBUG) {
      Log.e(TAG, buildLogMsg(message));
    }
  }
  /** Log Level Warning **/
  public static final void w(String message) {
    if (BaseApplication.DEBUG) {
      Log.w(TAG, buildLogMsg(message));
    }
  }
  /** Log Level Information **/
  public static final void i(String message) {
    if (BaseApplication.DEBUG) {
      Log.i(TAG, buildLogMsg(message));
    }
  }
  /** Log Level Debug **/
  public static final void d(String message) {
    if (BaseApplication.DEBUG) {
      Log.d(TAG, buildLogMsg(message));
    }
  }
  /** Log Level Verbose **/
  public static final void v(String message) {
    if (BaseApplication.DEBUG) {
      Log.v(TAG, buildLogMsg(message));
    }
  }


  public static String buildLogMsg(String message) {
    StackTraceElement ste = Thread.currentThread().getStackTrace()[4];
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    sb.append(ste.getFileName().replace(".java", ""));
    sb.append("::");
    sb.append(ste.getMethodName());
    sb.append("]");
    sb.append(message);
  }

}
