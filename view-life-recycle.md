
##Activity Life Cycle
![images](https://camo.githubusercontent.com/d95e3c6ffc2cb284e6e7af390b4c695d34398b4d/687474703a2f2f692e696d6775722e636f6d2f684251566942302e706e67)
###解释
  - 针对一个特定的Activity，第一次启动，回调的情况如下 OnCreate ---OnStart---OnResume
  - 当用户打开新的Activity 或者切换出去的时候，回掉会如下 OnPause ---Onstop **有一种特别特殊的情况，如果新的Activity为透明主题，那么onstop不会被调用** 因为onstop 只为上一个Activity 看不见的时候
  - 当用户再次回到原Acitivty的时候，回调如下：onreastart---onstart---onresume
  - 当按下back按键的时候 为 onpause---onstop--ondestory
  
###额外情况
  - 由于系统资源发生改变，系统配置重新改变的时候，Activity异常退出之后，例如横屏转竖屏的时候，Activity 会先调用 OnsaveInstanceState()来存储当天的状态信息，会重新创建一个Activity 调用OnrestoreInsatanceState（）来恢复之前信息
  - 由于内存不足，内存泄漏造成的Activity突然销毁的话，会按照之前的Activity的优先级来重新创建

 
