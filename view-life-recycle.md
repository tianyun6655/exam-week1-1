
##Activity Life Cycle
![images](https://camo.githubusercontent.com/d95e3c6ffc2cb284e6e7af390b4c695d34398b4d/687474703a2f2f692e696d6775722e636f6d2f684251566942302e706e67)
###解释
  - 当Activity启动时，会一次调用oncreate--onStart()-OnResume()这时Activity 已经启动完毕进如运行的状态
  - 当跳转到一个新的Activity的时候，第一个activity最先调用onPause()，第一个Activity不可见的时候才会调用OnStop方法
  - **额外注意，当返回第一个Activity的时候，如果第一个Activity处于OnPause()的时候，返回之后，会第二次调用OnResume(),但是当第一个Activit   y处于OnStop()的时候会先调用Onrestart()，之后调用OnStart()**
  - 最后则为Activity正在销毁的时候
####额外情况
  - 由于系统资源发生改变，系统配置重新改变的时候，Activity异常退出之后，例如横屏转竖屏的时候，Activity 会先调用 OnsaveInstanceState()来存储当天的状态信息，会重新创建一个Activity 调用OnrestoreInsatanceState（）来恢复之前信息
  - 由于内存不足，内存泄漏造成的Activity突然销毁的话，会按照之前的Activity的优先级来重新创建

 
