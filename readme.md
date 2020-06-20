[toc]

### 第一次课

#### tasking

- given locker未满  when 存包 t hen 存包成功，拿到ticket

- given locker已满 when 存包 then 存包失败，提示储物柜已满
     - 初始容量不为零，添加背包导致容量满

- given 一张有效票据 when 取包，then 取包成功

- given 一张无效票据 when 取包，then 取包失败，提示非法票据

- given 一张重复使用票据 when 取包 then 取包失败，提示非法票据

#### question

- 测试中如何设置存包满或者未满状态。
- tasking过程中要不要认为初始未容量为0的状态也是满的状态
  - 不需要，需求中没有这种场景





### 第二次课

#### tasking

- given PrimaryLockerRobot 管理两个柜子都未满 when 存包 then 存包成功到第一个未满的柜子，拿到ticket

- given PrimaryLockerRobot 管理两个柜子第一个满 when 存包 then 存包成功到第二个的柜子，拿到ticket

- given PrimaryLockerRobot 管理的柜子全满 when 存包 then 存包失败，提示管理的储物柜已满 

- given 有效票据  when 取包包 then 取包成功

- given 一张无效票据 when 取包，then 取包失败，提示非法票据


### 第三次次课

#### tasking


- given SmartLockerRobot 管理两个Locker第一个Locker比第二个空格多 when 存包 then 存包成功到第一个的Locker，拿到ticket
- given SmartLockerRobot 管理两个Locker第二个Locker比第一个空格多 when 存包 then 存包成功到第二个的Locker，拿到ticket
- given SmartLockerRobot 管理两个Locker空格一样多 when 存包 then 存包成功到第二个的Locker，拿到ticket

- given SmartLockerRobot 管理的柜子全满 when 存包 then 存包失败，提示管理的储物柜已满 

- given SmartLockerRobot 拿到有效票据  when 取包 then 取包成功

- given SmartLockerRobot 拿到一张无效票据 when 取包，then 取包失败，提示非法票据
 
- given PrimaryLockerRobot 和 SmartLockerRobot 同时管理一个Locker SmartLockerRobot拿到PrimaryLockerRobot存包成功的票据 when 取包
then 取包成功

- given PrimaryLockerRobot 和 SmartLockerRobot 同时管理一个Locker PrimaryLockerRobot拿到SmartLockerRobot存包成功的票据 when 取包
then 取包成功

 
 