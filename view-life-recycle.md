# exam-week1-1
Intfocus-exam1.1
##Activity Life Cycle
**The methods For the life cyecle**

                  - Activity Start
                       |
                  - Oncreate()
                       |
                  - OnStart()
                       |
                  - OnResume()
                       |
                  - Acitivty Launch
                       |**New Acitivty Start**
                  - OnPause()
                       |**The Activity is alreay invisiable**
                  - OnStop()
                       |
                  - OnDestory()
                       |
                  - Activity Destory
                  
##
###解释
  - 当Activity启动时，会一次调用oncreate--onStart()-OnResume()这时Activity 已经启动完毕进如运行的状态
  - 当跳转到一个新的Activity的时候，第一个activity最先调用onPause()，第一个Activity不可见的时候才会调用OnStop方法
  - **额外注意，当返回第一个Activity的时候，如果第一个Activity处于OnPause()的时候，返回之后，会第二次调用OnResume(),但是当第一个Activit   y处于OnStop()的时候会先调用Onrestart()，之后调用OnStart()**
  - 最后则为Activity正在销毁的时候
###


####额外情况
####
