package com.dn.flutter_toast_plugin_dn;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** FlutterToastPluginDnPlugin */
public class FlutterToastPluginDnPlugin implements MethodCallHandler {
  private Context context;
  private Toast toast;

  private FlutterToastPluginDnPlugin(Context context) {
    this.context = context;
  }

  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_toast_plugin_dn");
    channel.setMethodCallHandler(new FlutterToastPluginDnPlugin(registrar.context()));
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("showToast")) {
      String msg = call.argument("msg");
      String duration = call.argument("duration");
      Number textColor = call.argument("textColor");
      Number textSize = call.argument("textSize");

      toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
      //set text
      if (msg != null) {
        toast.setText(msg);
      }
      //set duration
      if (duration != null && duration.equals("long")) {
        toast.setDuration(Toast.LENGTH_LONG);
      } else {
        toast.setDuration(Toast.LENGTH_SHORT);
      }
      //set styles
      TextView textView = (TextView) toast.getView().findViewById(android.R.id.message);
      if (textSize != null) {
        textView.setTextSize(textSize.floatValue());
      }
      if (textColor != null) {
        textView.setTextColor(textColor.intValue());
      }
      toast.show();
    } else {
      result.notImplemented();
    }
  }
}
